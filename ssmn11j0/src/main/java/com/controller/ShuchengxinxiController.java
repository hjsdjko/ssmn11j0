package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ShuchengxinxiEntity;
import com.entity.view.ShuchengxinxiView;

import com.service.ShuchengxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 书城信息
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-21 10:49:45
 */
@RestController
@RequestMapping("/shuchengxinxi")
public class ShuchengxinxiController {
    @Autowired
    private ShuchengxinxiService shuchengxinxiService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShuchengxinxiEntity shuchengxinxi, 
		HttpServletRequest request){

        EntityWrapper<ShuchengxinxiEntity> ew = new EntityWrapper<ShuchengxinxiEntity>();
		PageUtils page = shuchengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shuchengxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShuchengxinxiEntity shuchengxinxi, 
		HttpServletRequest request){
        EntityWrapper<ShuchengxinxiEntity> ew = new EntityWrapper<ShuchengxinxiEntity>();
		PageUtils page = shuchengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shuchengxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShuchengxinxiEntity shuchengxinxi){
       	EntityWrapper<ShuchengxinxiEntity> ew = new EntityWrapper<ShuchengxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shuchengxinxi, "shuchengxinxi")); 
        return R.ok().put("data", shuchengxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShuchengxinxiEntity shuchengxinxi){
        EntityWrapper< ShuchengxinxiEntity> ew = new EntityWrapper< ShuchengxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shuchengxinxi, "shuchengxinxi")); 
		ShuchengxinxiView shuchengxinxiView =  shuchengxinxiService.selectView(ew);
		return R.ok("查询书城信息成功").put("data", shuchengxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShuchengxinxiEntity shuchengxinxi = shuchengxinxiService.selectById(id);
		shuchengxinxi.setClicknum(shuchengxinxi.getClicknum()+1);
		shuchengxinxi.setClicktime(new Date());
		shuchengxinxiService.updateById(shuchengxinxi);
        return R.ok().put("data", shuchengxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShuchengxinxiEntity shuchengxinxi = shuchengxinxiService.selectById(id);
		shuchengxinxi.setClicknum(shuchengxinxi.getClicknum()+1);
		shuchengxinxi.setClicktime(new Date());
		shuchengxinxiService.updateById(shuchengxinxi);
        return R.ok().put("data", shuchengxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        ShuchengxinxiEntity shuchengxinxi = shuchengxinxiService.selectById(id);
        if(type.equals("1")) {
        	shuchengxinxi.setThumbsupnum(shuchengxinxi.getThumbsupnum()+1);
        } else {
        	shuchengxinxi.setCrazilynum(shuchengxinxi.getCrazilynum()+1);
        }
        shuchengxinxiService.updateById(shuchengxinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShuchengxinxiEntity shuchengxinxi, HttpServletRequest request){
    	shuchengxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shuchengxinxi);

        shuchengxinxiService.insert(shuchengxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShuchengxinxiEntity shuchengxinxi, HttpServletRequest request){
    	shuchengxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shuchengxinxi);

        shuchengxinxiService.insert(shuchengxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShuchengxinxiEntity shuchengxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shuchengxinxi);
        shuchengxinxiService.updateById(shuchengxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shuchengxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ShuchengxinxiEntity> wrapper = new EntityWrapper<ShuchengxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = shuchengxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ShuchengxinxiEntity shuchengxinxi, HttpServletRequest request,String pre){
        EntityWrapper<ShuchengxinxiEntity> ew = new EntityWrapper<ShuchengxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = shuchengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shuchengxinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ShuchengxinxiEntity shuchengxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "shuchengfenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "shuchengxinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ShuchengxinxiEntity> shuchengxinxiList = new ArrayList<ShuchengxinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                shuchengxinxiList.addAll(shuchengxinxiService.selectList(new EntityWrapper<ShuchengxinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ShuchengxinxiEntity> ew = new EntityWrapper<ShuchengxinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = shuchengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shuchengxinxi), params), params));
        List<ShuchengxinxiEntity> pageList = (List<ShuchengxinxiEntity>)page.getList();
        if(shuchengxinxiList.size()<limit) {
            int toAddNum = (limit-shuchengxinxiList.size())<=pageList.size()?(limit-shuchengxinxiList.size()):pageList.size();
            for(ShuchengxinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(ShuchengxinxiEntity o2 : shuchengxinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    shuchengxinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(shuchengxinxiList.size()>limit) {
            shuchengxinxiList = shuchengxinxiList.subList(0, limit);
        }
        page.setList(shuchengxinxiList);
        return R.ok().put("data", page);
    }





}

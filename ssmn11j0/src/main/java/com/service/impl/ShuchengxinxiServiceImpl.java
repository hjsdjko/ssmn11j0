package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShuchengxinxiDao;
import com.entity.ShuchengxinxiEntity;
import com.service.ShuchengxinxiService;
import com.entity.vo.ShuchengxinxiVO;
import com.entity.view.ShuchengxinxiView;

@Service("shuchengxinxiService")
public class ShuchengxinxiServiceImpl extends ServiceImpl<ShuchengxinxiDao, ShuchengxinxiEntity> implements ShuchengxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShuchengxinxiEntity> page = this.selectPage(
                new Query<ShuchengxinxiEntity>(params).getPage(),
                new EntityWrapper<ShuchengxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShuchengxinxiEntity> wrapper) {
		  Page<ShuchengxinxiView> page =new Query<ShuchengxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShuchengxinxiVO> selectListVO(Wrapper<ShuchengxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShuchengxinxiVO selectVO(Wrapper<ShuchengxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShuchengxinxiView> selectListView(Wrapper<ShuchengxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShuchengxinxiView selectView(Wrapper<ShuchengxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

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


import com.dao.ShuchengfenleiDao;
import com.entity.ShuchengfenleiEntity;
import com.service.ShuchengfenleiService;
import com.entity.vo.ShuchengfenleiVO;
import com.entity.view.ShuchengfenleiView;

@Service("shuchengfenleiService")
public class ShuchengfenleiServiceImpl extends ServiceImpl<ShuchengfenleiDao, ShuchengfenleiEntity> implements ShuchengfenleiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShuchengfenleiEntity> page = this.selectPage(
                new Query<ShuchengfenleiEntity>(params).getPage(),
                new EntityWrapper<ShuchengfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShuchengfenleiEntity> wrapper) {
		  Page<ShuchengfenleiView> page =new Query<ShuchengfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShuchengfenleiVO> selectListVO(Wrapper<ShuchengfenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShuchengfenleiVO selectVO(Wrapper<ShuchengfenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShuchengfenleiView> selectListView(Wrapper<ShuchengfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShuchengfenleiView selectView(Wrapper<ShuchengfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

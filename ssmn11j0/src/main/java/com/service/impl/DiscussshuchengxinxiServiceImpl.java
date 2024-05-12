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


import com.dao.DiscussshuchengxinxiDao;
import com.entity.DiscussshuchengxinxiEntity;
import com.service.DiscussshuchengxinxiService;
import com.entity.vo.DiscussshuchengxinxiVO;
import com.entity.view.DiscussshuchengxinxiView;

@Service("discussshuchengxinxiService")
public class DiscussshuchengxinxiServiceImpl extends ServiceImpl<DiscussshuchengxinxiDao, DiscussshuchengxinxiEntity> implements DiscussshuchengxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshuchengxinxiEntity> page = this.selectPage(
                new Query<DiscussshuchengxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussshuchengxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshuchengxinxiEntity> wrapper) {
		  Page<DiscussshuchengxinxiView> page =new Query<DiscussshuchengxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussshuchengxinxiVO> selectListVO(Wrapper<DiscussshuchengxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshuchengxinxiVO selectVO(Wrapper<DiscussshuchengxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshuchengxinxiView> selectListView(Wrapper<DiscussshuchengxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshuchengxinxiView selectView(Wrapper<DiscussshuchengxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

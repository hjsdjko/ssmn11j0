package com.dao;

import com.entity.DiscussshuchengxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshuchengxinxiVO;
import com.entity.view.DiscussshuchengxinxiView;


/**
 * 书城信息评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-21 10:49:45
 */
public interface DiscussshuchengxinxiDao extends BaseMapper<DiscussshuchengxinxiEntity> {
	
	List<DiscussshuchengxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussshuchengxinxiEntity> wrapper);
	
	DiscussshuchengxinxiVO selectVO(@Param("ew") Wrapper<DiscussshuchengxinxiEntity> wrapper);
	
	List<DiscussshuchengxinxiView> selectListView(@Param("ew") Wrapper<DiscussshuchengxinxiEntity> wrapper);

	List<DiscussshuchengxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshuchengxinxiEntity> wrapper);
	
	DiscussshuchengxinxiView selectView(@Param("ew") Wrapper<DiscussshuchengxinxiEntity> wrapper);
	

}

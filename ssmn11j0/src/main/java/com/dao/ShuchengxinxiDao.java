package com.dao;

import com.entity.ShuchengxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShuchengxinxiVO;
import com.entity.view.ShuchengxinxiView;


/**
 * 书城信息
 * 
 * @author 
 * @email 
 * @date 2022-04-21 10:49:45
 */
public interface ShuchengxinxiDao extends BaseMapper<ShuchengxinxiEntity> {
	
	List<ShuchengxinxiVO> selectListVO(@Param("ew") Wrapper<ShuchengxinxiEntity> wrapper);
	
	ShuchengxinxiVO selectVO(@Param("ew") Wrapper<ShuchengxinxiEntity> wrapper);
	
	List<ShuchengxinxiView> selectListView(@Param("ew") Wrapper<ShuchengxinxiEntity> wrapper);

	List<ShuchengxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShuchengxinxiEntity> wrapper);
	
	ShuchengxinxiView selectView(@Param("ew") Wrapper<ShuchengxinxiEntity> wrapper);
	

}

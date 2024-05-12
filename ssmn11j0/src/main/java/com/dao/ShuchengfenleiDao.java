package com.dao;

import com.entity.ShuchengfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShuchengfenleiVO;
import com.entity.view.ShuchengfenleiView;


/**
 * 书城分类
 * 
 * @author 
 * @email 
 * @date 2022-04-21 10:49:45
 */
public interface ShuchengfenleiDao extends BaseMapper<ShuchengfenleiEntity> {
	
	List<ShuchengfenleiVO> selectListVO(@Param("ew") Wrapper<ShuchengfenleiEntity> wrapper);
	
	ShuchengfenleiVO selectVO(@Param("ew") Wrapper<ShuchengfenleiEntity> wrapper);
	
	List<ShuchengfenleiView> selectListView(@Param("ew") Wrapper<ShuchengfenleiEntity> wrapper);

	List<ShuchengfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<ShuchengfenleiEntity> wrapper);
	
	ShuchengfenleiView selectView(@Param("ew") Wrapper<ShuchengfenleiEntity> wrapper);
	

}

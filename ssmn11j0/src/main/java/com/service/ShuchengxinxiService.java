package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShuchengxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShuchengxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShuchengxinxiView;


/**
 * 书城信息
 *
 * @author 
 * @email 
 * @date 2022-04-21 10:49:45
 */
public interface ShuchengxinxiService extends IService<ShuchengxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShuchengxinxiVO> selectListVO(Wrapper<ShuchengxinxiEntity> wrapper);
   	
   	ShuchengxinxiVO selectVO(@Param("ew") Wrapper<ShuchengxinxiEntity> wrapper);
   	
   	List<ShuchengxinxiView> selectListView(Wrapper<ShuchengxinxiEntity> wrapper);
   	
   	ShuchengxinxiView selectView(@Param("ew") Wrapper<ShuchengxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShuchengxinxiEntity> wrapper);
   	

}


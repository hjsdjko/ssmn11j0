package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShuchengfenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShuchengfenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShuchengfenleiView;


/**
 * 书城分类
 *
 * @author 
 * @email 
 * @date 2022-04-21 10:49:45
 */
public interface ShuchengfenleiService extends IService<ShuchengfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShuchengfenleiVO> selectListVO(Wrapper<ShuchengfenleiEntity> wrapper);
   	
   	ShuchengfenleiVO selectVO(@Param("ew") Wrapper<ShuchengfenleiEntity> wrapper);
   	
   	List<ShuchengfenleiView> selectListView(Wrapper<ShuchengfenleiEntity> wrapper);
   	
   	ShuchengfenleiView selectView(@Param("ew") Wrapper<ShuchengfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShuchengfenleiEntity> wrapper);
   	

}


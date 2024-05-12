package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshuchengxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshuchengxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshuchengxinxiView;


/**
 * 书城信息评论表
 *
 * @author 
 * @email 
 * @date 2022-04-21 10:49:45
 */
public interface DiscussshuchengxinxiService extends IService<DiscussshuchengxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshuchengxinxiVO> selectListVO(Wrapper<DiscussshuchengxinxiEntity> wrapper);
   	
   	DiscussshuchengxinxiVO selectVO(@Param("ew") Wrapper<DiscussshuchengxinxiEntity> wrapper);
   	
   	List<DiscussshuchengxinxiView> selectListView(Wrapper<DiscussshuchengxinxiEntity> wrapper);
   	
   	DiscussshuchengxinxiView selectView(@Param("ew") Wrapper<DiscussshuchengxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshuchengxinxiEntity> wrapper);
   	

}


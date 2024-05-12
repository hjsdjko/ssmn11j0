package com.entity.view;

import com.entity.ShuchengfenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 书城分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-21 10:49:45
 */
@TableName("shuchengfenlei")
public class ShuchengfenleiView  extends ShuchengfenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShuchengfenleiView(){
	}
 
 	public ShuchengfenleiView(ShuchengfenleiEntity shuchengfenleiEntity){
 	try {
			BeanUtils.copyProperties(this, shuchengfenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

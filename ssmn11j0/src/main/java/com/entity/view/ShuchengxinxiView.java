package com.entity.view;

import com.entity.ShuchengxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 书城信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-21 10:49:45
 */
@TableName("shuchengxinxi")
public class ShuchengxinxiView  extends ShuchengxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShuchengxinxiView(){
	}
 
 	public ShuchengxinxiView(ShuchengxinxiEntity shuchengxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, shuchengxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

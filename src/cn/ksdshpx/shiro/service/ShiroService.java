package cn.ksdshpx.shiro.service;

import java.util.Date;

import org.apache.shiro.authz.annotation.RequiresRoles;

/**
 * @author peng.x
 * @date 2019年2月19日 下午4:12:35
 */
public class ShiroService {
	@RequiresRoles("admin")
	public void testMethod() {
		System.out.println("testMethod...time:"+new Date());
	}
}

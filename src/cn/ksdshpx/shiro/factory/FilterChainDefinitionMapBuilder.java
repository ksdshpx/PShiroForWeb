package cn.ksdshpx.shiro.factory;
/**
 * @author peng.x
 * @date 2019年2月22日 下午4:02:02
 */

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {
	public LinkedHashMap<String, String> bulidFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		//从数据表中初始化资源和权限
		map.put("/login.jsp", "anon");
		map.put("/shiro/login", "anon");
		map.put("/shiro/logout", "logout");
		map.put("/admin.jsp", "authc,roles[admin]");
		map.put("/User.jsp", "authc,roles[user]");
		map.put("/list", "user");
		map.put("/**", "authc");
		
		return map;
	}
}

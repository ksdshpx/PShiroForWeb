package cn.ksdshpx.shiro.handler;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.ksdshpx.shiro.service.ShiroService;
import jdk.nashorn.internal.parser.Token;

/**
 * @author peng.x
 * @date 2019年1月29日 下午4:16:49
 */
@RequestMapping("/shiro")
@Controller
public class ShiroHandler {
	@Autowired
	private ShiroService shiroService;

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			try {
				UsernamePasswordToken token = new UsernamePasswordToken(username, password);
				System.out.println("1." + token.hashCode());
				token.setRememberMe(true);
				currentUser.login(token);
			} catch (AuthenticationException e) {
				System.out.println("登录失败");
				e.printStackTrace();
			}
		}
		return "redirect:/list.jsp";
	}
	
	@RequestMapping("testShiroAnnotation")
	public String testShiroAnnotation(HttpSession session) {
		session.setAttribute("key", "value12345");
		shiroService.testMethod();
		return "redirect:/list.jsp";
	}
}

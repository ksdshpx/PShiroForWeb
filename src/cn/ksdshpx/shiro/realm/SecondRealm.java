package cn.ksdshpx.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * @author peng.x
 * @date 2019年1月24日 下午4:44:20
 */
public class SecondRealm extends AuthenticatingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("[SecondRealm doGetAuthenticationInfo]");
		//1.把AuthenticationToken转换为UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2.从UsernamePasswordToken中获取username
		String username = upToken.getUsername();
		//3.调用数据库的方法，从数据库中查询username对应的记录
		System.out.println("从数据库中查找"+username+"对应的记录");
		//4.若用户不存在，则可以抛出UnknownAccountException异常
		if("unknown".equals(username)) {
			throw new UnknownAccountException("该账户不存在！");
		}
		//5.根据用户信息的情况决定是否需要抛出其他的异常
		if("monster".equals(username)) {
			throw new LockedAccountException("用户被锁定");
		}
		//6.根据用户信息的情况构建AuthenticationInfo对象并返回
		//以下数据是从数据库中获取的
		//1)principal:认证的实体信息,可以是username,也可以是数据表对应的用户的实体类对象
		Object principal = username;
		//2)credentials:密码
		Object credentials =null;//"fc1709d0a95a6be30bc5926fdb7f22f4";
		if("admin".equals(username)) {
			credentials = "ce2f6417c7e1d32c1d81a797ee0b499f87c5de06---";
		}else if("user".equals(username)) {
			credentials = "073d4c3ae812935f23cb3f2a71943f49e082a718---";
		}
		//3)realmName:当前realm对象的name.调用父类对象的getName()方法即可
		String realmName = getName();
		//4)盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("secondRealmName", credentials, credentialsSalt, realmName);
		return info;
	}
	public static void main(String[] args) {
		String hashAlgorithmName = "SHA1";
		Object credentials = "123456";
		Object salt = ByteSource.Util.bytes("admin");
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(result);
	}
}

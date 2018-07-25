package com.itmuch.cloud.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 自定义过滤器
 * @ClassName: PreRequestLogFilter
 * @Description: TODO
 * 
 * zuul的核心组件是过滤器，有以下四种类型的过滤器：
 * pre：请求被路由之前，可以实现身份验证、在集群中选择请求的微服务，记录调试信息等
 * routing：请求路由到微服务，用户构建发送给微服务的请求
 * post：在气流在路由的微服务之后执行，可以用来响应添加标志的http header、收集统计信息等
 * error：在其他阶段法神错误时执行该过滤器
 * 
 * 禁用过滤器：
 * zuul.<SimpleClassName>.<filterType>.disable=true 即可禁用SimpleClassName所对应的过滤器
 * zuul.PreRequestLogFilter.pre.disable=true 禁用PreRequestLogFilter
 * zuul提供的默认的过滤器都在：
 * org.springframework.cloud.netflix.zuul.filters包中
 *
 */
public class PreRequestLogFilter extends ZuulFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(PreRequestLogFilter.class); 
	
	/**
	 * 过滤器的具体逻辑
	 * <p>Description: </p>
	 * @return
	 */
	@Override
	public Object run() {
		// TODO Auto-generated method stub
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
		
		return null;
	}

	/**
	 * 该过滤器是否需要执行
	 * true：需要执行
	 * false：不需要执行
	 * <p>Description: </p>
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 返回一个int值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字
	 * <p>Description: </p>
	 * @return
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

	/**
	 * 返回过滤器的类型，有pre、route、post、error几种取指，对应上面四种类型的过滤器
	 * <p>Description: </p>
	 * @return
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}
	
}

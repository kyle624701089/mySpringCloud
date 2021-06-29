package com.kyle.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ ClassName: MyZuulFilter
 * @ Description: 实现自己的zuul路由过滤器
 * @ author: Administrator
 * @ date: 2018/9/4 22:53
 * @ version: 1.0
 **/
@Component
public class MyZuulFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(MyZuulFilter.class);

    /**
     * zuul定义了4种不同生命周期的过滤器类型
     * pre：路由之前
     * routing：路由之时
     * post： 路由之后
     * error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤的具体业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        log.info("%s >>> s%",request.getMethod(),request.getRequestURI());
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            log.warn("token is empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                log.error("zuulFilter error {}", e.getMessage());
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}

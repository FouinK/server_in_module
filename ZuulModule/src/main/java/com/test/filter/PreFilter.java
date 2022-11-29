package com.test.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;        //true 일경우 run() 실행
    }

    @Override
    public Object run() throws ZuulException {
        try {

            System.out.println("[PreFilter 실행]");
            RequestContext requestContext = RequestContext.getCurrentContext();
            HttpServletRequest request = requestContext.getRequest();

            requestContext.addZuulRequestHeader("Zuul","hi, spring ! ! !");

        } catch (RuntimeException e) {

            e.printStackTrace();

        }
        return null;
    }
}

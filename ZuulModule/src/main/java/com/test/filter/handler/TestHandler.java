package com.test.filter.handler;

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TestHandler {

    public void requestTest() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        requestContext.addZuulRequestHeader("Zuul","hi, spring ! ! !");
    }
}

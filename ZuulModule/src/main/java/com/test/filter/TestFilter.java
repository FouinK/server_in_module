package com.test.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.test.filter.handler.TestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestFilter extends ZuulFilter {

    private final TestHandler testHandler;

    @Override
    public String filterType() {
        return "route";
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

            System.out.println("run 실행");
            testHandler.requestTest();

        } catch (RuntimeException e) {

            e.printStackTrace();

        }
        return null;
    }
}

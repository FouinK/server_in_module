package com.test.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class PostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("[PostFilter 실행]");
        RequestContext requestContext = RequestContext.getCurrentContext();

        InputStream responseDataStream = requestContext.getResponseDataStream();    //응답 바디
        int responseStatusCode = requestContext.getResponseStatusCode();            //응답 코드

        try {
            String responseAsString = StreamUtils.copyToString(responseDataStream, Charset.forName("utf-8"));
            System.out.println(responseAsString);
            System.out.println(responseStatusCode);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }
}

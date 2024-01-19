package org.willd.authserver.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.net.URI;
import java.util.Enumeration;
import java.util.logging.LogRecord;

@Slf4j
@Component
public class LoggerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ContentCachingRequestWrapper req = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper res = new ContentCachingResponseWrapper((HttpServletResponse) response);

        log.info("🍎 INIT URI: {}", req.getRequestURI());

        chain.doFilter(req, res);

        String uri = req.getRequestURI();
        String method = req.getMethod();
        Enumeration<String> headerNames = req.getHeaderNames();

        StringBuffer headerValues = new StringBuffer();
        headerNames.asIterator().forEachRemaining(headerKey -> {
            String headerValue = req.getHeader(headerKey);
            headerValues
                    .append("[")
                    .append(headerKey)
                    .append(": ")
                    .append(headerValue)
                    .append("]");
        });

        String requestBody = new String(req.getContentAsByteArray());
        log.info("🍎 IN>>>> uri: {}, method: {}, header: {}, body: {}", uri, method, headerValues, requestBody);

        StringBuffer responseHeaderValues = new StringBuffer();
        res.getHeaderNames().forEach(headerKey -> {
            var headerValue = res.getHeader(headerKey);
            responseHeaderValues
                    .append("[")
                    .append(headerKey)
                    .append(": ")
                    .append(headerValue)
                    .append("]");
        });

        String responseBody = new String(res.getContentAsByteArray());
        log.info("🍎 OUT<<<< uri: {}, method: {}, header: {}, body: {}", uri, method, responseHeaderValues, responseBody);

        res.copyBodyToResponse();;
    }
}

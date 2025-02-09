package hrs.com.interview.booking.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Component
public class ApiLoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String requestId = StringUtils.defaultIfBlank(request.getHeader("request-id"), UUID.randomUUID().toString());
        response.setHeader("request-id", requestId);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "access-control-allow-origin, Authorization, Content-Type, Access-Control-Allow-Origin");
        MDC.put("request-id", requestId);
        MDC.put("request-url", request.getRequestURI());
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        try {
            filterChain.doFilter(requestWrapper, responseWrapper);
        } finally {
            try {
                int status = response.getStatus();
                if (status >= HttpStatus.BAD_REQUEST.value() || !RequestMethod.GET.name().equals(request.getMethod())) {
                    String requestUrl = requestWrapper.getRequestURL().toString();
                    String requestMethod = requestWrapper.getMethod();
                    String requestBody = new String(requestWrapper.getContentAsByteArray());
                    log.info("[RESPONSE] Code = {}, [REQUEST] {} {} QUERY {} BODY: {}", status, requestMethod, requestUrl, request.getQueryString(), StringUtils.trimToEmpty(requestBody));
                }
                responseWrapper.copyBodyToResponse();
            } catch (Exception ignored) {
            } finally {
                MDC.clear();
            }
        }
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String requestURI = request.getRequestURI();
        return requestURI.contains("/healthcheck");
    }
}

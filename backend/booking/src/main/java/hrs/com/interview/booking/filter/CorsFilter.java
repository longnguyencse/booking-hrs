package hrs.com.interview.booking.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CorsFilter implements Filter  {
	@Override
	public void init(FilterConfig arg0) {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response=(HttpServletResponse) resp;
		String origin = ((HttpServletRequest) req).getHeader("Origin");

		response.setHeader("Access-Control-Allow-Origin", origin != null && (origin .contains("jiohealth.com")
				|| origin.contains("http://localhost"))  ? origin : "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With, Accept, Origin, App-Location");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {}

}

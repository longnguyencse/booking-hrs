package hrs.com.interview.booking.interceptor;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Setter
@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Component
public class RequestScopedContext {
    private static final ThreadLocal<RequestScopedContext> context = new ThreadLocal<>();

    public static RequestScopedContext get() {
        RequestScopedContext ctx = context.get();
        if (ctx == null) {
            ctx = new RequestScopedContext();
            context.set(ctx);
        }
        return ctx;
    }

    public static void remove() {
        context.remove();
    }

    private String requestId;

}

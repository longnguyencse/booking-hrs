package hrs.com.interview.booking.aop;

import hrs.com.interview.booking.anotation.SynchronizeBiz;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
@Aspect
@Slf4j
public class AopSynchronizeBiz  {

    @Before("@annotation(myAnnotation)")
    public void onBeforeAmendReservation(JoinPoint joinPoint, SynchronizeBiz myAnnotation) {
    }

}

package com.zl.common.aop;

import com.zl.common.converter.JsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  14:58
 */
@Aspect
@Component
public class WebLogAspect {
    private static Logger logger = LoggerFactory.getLogger(WebLogAspect.class.getSimpleName());

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        try {
            MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
            String[] parameterNames = methodSignature.getParameterNames();
            Map<String, Object> paramMap = new HashMap<>(16);
            if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
                for (int i = 0; i < joinPoint.getArgs().length; i++) {
                    Object object = joinPoint.getArgs()[i];
                    if (object instanceof MultipartFile || object instanceof HttpServletRequest || object instanceof HttpServletResponse) {
                        continue;
                    }
                    String name = parameterNames[i];
                    paramMap.put(name, object);
                }
            }
            logger.info(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()
                + " : request parameter : " + JsonUtil.toJson(paramMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterReturning(returning = "response", pointcut = "webLog()")
    public void doAfterReturning(Object response) throws Throwable {
        if (response != null) {
            logger.info("response parameter : " + JsonUtil.toJson(response));
        }
    }
}

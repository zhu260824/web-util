package com.zl.common.exception;

import com.zl.common.bean.Result;
import com.zl.common.util.StringUtil;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  15:32
 */
@RestController
@ControllerAdvice
public class ExceptionController {
    private static Logger logger = LoggerFactory.getLogger(ExceptionController.class.getSimpleName());

    @ExceptionHandler(value = BindException.class)
    public Result handleBindException(BindException ex) {
        String message = "";
        if (ex != null) {
            message = ex.getMessage();
            if (StringUtil.isEmpty(message)) {
                String fieldName = ex.getBindingResult().getFieldError().getField();
                message = "参数" + fieldName + ",有错，可能是格式或者类型错误，或未传参";
            }
        }
        return Result.getError(400, message);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public Result handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        StringBuilder sb = new StringBuilder();
        constraintViolations.forEach(constraintViolation -> sb.append(constraintViolation.getMessage()).append(","));
        String errorMessage = sb.toString();
        errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
        return Result.getError(400, errorMessage);
    }

    @ExceptionHandler(value = FileUploadBase.FileSizeLimitExceededException.class)
    public Result handleFileSizeLimitExceededException(FileUploadBase.FileSizeLimitExceededException ex) {
        return Result.getError(400, "文件大小超过系统限制");
    }

    @ExceptionHandler(value = BusinessException.class)
    public Result handleBusinessException(BusinessException ex) {
        return Result.getError(ex.getErrorCode(), ex.getMessage());
    }

    @ExceptionHandler(value = IOException.class)
    public Result handleIOException(IOException ex) {
        logger.info("IOException-->" + ex.getMessage());
        return Result.getError(400, "文件操作异常");
    }

    @ExceptionHandler(value = SQLException.class)
    public Result handleSQLException(SQLException ex) {
        logger.info("SQLException-->" + ex.getMessage());
        return Result.getError(400, "数据操作异常");
    }
}

package com.cn.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Constraint(validatedBy = AlphaNumericValidator.class)
public @interface AlphaNumeric {

	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payloads() default {};

}

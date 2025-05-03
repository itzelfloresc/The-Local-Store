package com.product.api.dto.in.validationAuth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = AuthRequestValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthRequestConstraint {

    String message() default "La solicitud no cumple con la especificación requerida";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}

package com.product.api.dto.in.validationAuth;

import org.springframework.util.StringUtils;

import com.product.api.dto.in.AuthRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AuthRequestValidator implements ConstraintValidator<AuthRequestConstraint, AuthRequest>{

    @Override
	public boolean isValid(AuthRequest request, ConstraintValidatorContext context) {
		return StringUtils.hasLength(request.getCorreo()) || StringUtils.hasLength(request.getNombreUsuario());
	}
}

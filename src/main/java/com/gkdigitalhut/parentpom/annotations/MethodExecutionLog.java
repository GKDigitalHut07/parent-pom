package com.gkdigitalhut.parentpom.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  // Only for methods
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodExecutionLog {
}
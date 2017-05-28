package com.ivanserbyniuk.androidkdsl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Администратор on 28.05.2017.
 */


@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD) //can use in method only.
public @interface Experimental {

}
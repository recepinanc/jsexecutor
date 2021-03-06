package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Exec
{
    String js() default "";

    String jquery() default "";

    String sql() default "";

    String path() default "";

    String func() default "";


}

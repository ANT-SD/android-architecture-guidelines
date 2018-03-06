package team.ant.architectureguides.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Nacho Vazquez on 3/6/2018.
 */

@Documented
@Qualifier
@Retention(RUNTIME)
public @interface ForOkHttpInterceptors {
}

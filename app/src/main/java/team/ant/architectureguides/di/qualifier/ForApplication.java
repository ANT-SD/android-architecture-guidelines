package team.ant.architectureguides.di.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Nacho Vazquez on 3/5/2018.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForApplication {
}

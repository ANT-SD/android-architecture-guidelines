package team.ant.architectureguides.di.component;

import dagger.Component;
import team.ant.architectureguides.di.ApplicationScope;
import team.ant.architectureguides.di.module.AndroidModule;
import team.ant.architectureguides.di.module.ApplicationModule;
import team.ant.architectureguides.di.module.NetworkModule;
import team.ant.architectureguides.di.module.OkHttpInterceptorsModule;

/**
 * Created by Nacho Vazquez on 3/6/2018.
 */
@ApplicationScope
@Component(modules = {
        AndroidModule.class,
        ApplicationModule.class,
        NetworkModule.class,
        OkHttpInterceptorsModule.class})
public interface ApplicationComponent {
}

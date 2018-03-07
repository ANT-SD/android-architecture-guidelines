package team.ant.architectureguides.di.component;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import team.ant.architectureguides.ArchitectureApplication;
import team.ant.architectureguides.di.module.AndroidModule;
import team.ant.architectureguides.di.module.ApplicationModule;
import team.ant.architectureguides.di.module.DatabaseModule;
import team.ant.architectureguides.di.module.GsonModule;
import team.ant.architectureguides.di.module.NetworkModule;
import team.ant.architectureguides.di.module.OkHttpInterceptorsModule;
import team.ant.architectureguides.di.scope.ApplicationScope;

/**
 * Created by Nacho Vazquez on 3/6/2018.
 */
@ApplicationScope
@Component(modules = {
        AndroidModule.class,
        ApplicationModule.class,
        NetworkModule.class,
        OkHttpInterceptorsModule.class,
        GsonModule.class,
        DatabaseModule.class,
        AndroidInjectionModule.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

    void inject(ArchitectureApplication application);


}

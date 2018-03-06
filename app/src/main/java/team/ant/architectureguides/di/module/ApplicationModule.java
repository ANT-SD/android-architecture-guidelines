package team.ant.architectureguides.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import team.ant.architectureguides.ArchitectureApplication;
import team.ant.architectureguides.di.ActivityScope;
import team.ant.architectureguides.di.ForApplication;

/**
 * Created by Nacho Vazquez on 3/5/2018.
 */
@Module
public class ApplicationModule {
    private ArchitectureApplication application;

    public ApplicationModule(ArchitectureApplication application) {
        this.application = application;
    }

    @ActivityScope
    @ForApplication
    @Provides
    public Application provideApplication(){
        return this.application;
    }

    @ActivityScope
    @ForApplication
    @Provides
    public ArchitectureApplication provideArchitectureApplication(){
        return this.application;
    }

    @ForApplication
    @ActivityScope
    @Provides
    public Context provideContext() {
        return this.application.getApplicationContext();
    }
}

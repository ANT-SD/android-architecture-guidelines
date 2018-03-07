package team.ant.architectureguides.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import team.ant.architectureguides.di.qualifier.ForApplication;
import team.ant.architectureguides.di.scope.ApplicationScope;

/**
 * Created by Nacho Vazquez on 3/5/2018.
 */
@Module
public class ApplicationModule {

    @ForApplication
    @ApplicationScope
    @Provides
    public Context provideContext(Application application) {
        return application.getApplicationContext();
    }

    //may also share sharedPref
}

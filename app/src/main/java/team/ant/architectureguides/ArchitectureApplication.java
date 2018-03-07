package team.ant.architectureguides;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import team.ant.architectureguides.di.ApplicationInjector;
import team.ant.architectureguides.di.component.ApplicationComponent;
import timber.log.Timber;

/**
 * Created by Nacho Vazquez on 3/5/2018.
 */

public class ArchitectureApplication extends Application implements HasActivityInjector {

    private ApplicationComponent applicationComponent;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        Stetho.initializeWithDefaults(this);

        ApplicationInjector.init(this);
    }

    public static ArchitectureApplication get(Context context) {
        return (ArchitectureApplication) context.getApplicationContext();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}

package team.ant.architectureguides;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import team.ant.architectureguides.di.component.ApplicationComponent;
import timber.log.Timber;

/**
 * Created by Nacho Vazquez on 3/5/2018.
 */

public class ArchitectureApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        applicationComponent = createComponent();
        Stetho.initializeWithDefaults(this);
    }

    private ApplicationComponent createComponent() {
        applicationComponent = ApplicationComponent.Initializer.init(this);
        applicationComponent.inject(this);
        return applicationComponent;
    }

    public ApplicationComponent getComponent() {
        if (applicationComponent == null) {
            createComponent();
        }
        return applicationComponent;
    }

    public static ArchitectureApplication get(Context context) {
        return (ArchitectureApplication) context.getApplicationContext();
    }
}

package team.ant.architectureguides.di.module;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import team.ant.architectureguides.di.scope.ActivityScope;
import team.ant.architectureguides.ui.MainActivity;

/**
 * Created by Nacho Vazquez on 3/6/2018.
 */

@Module
@ActivityScope
public abstract class MainModule {
    @ContributesAndroidInjector()
    abstract MainActivity contributeMainActivity();

    @ActivityScope
    @Provides
    static FragmentManager provideFragmentManager(MainActivity activity) {
        return activity.getSupportFragmentManager();
    }
}

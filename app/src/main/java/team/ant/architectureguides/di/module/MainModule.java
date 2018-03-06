package team.ant.architectureguides.di.module;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import team.ant.architectureguides.di.ActivityScope;
import team.ant.architectureguides.di.ForActivity;
import team.ant.architectureguides.ui.MainActivity;

/**
 * Created by Nacho Vazquez on 3/6/2018.
 */

@Module
@ActivityScope
public class MainModule {
    private MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    protected MainActivity activity() {
        return activity;
    }

    @ActivityScope
    @ForActivity
    @Provides
    Context provideContext() {
        return activity;
    }

    @ActivityScope
    @Provides
    FragmentManager provideFragmentManager(MainActivity activity) {
        return activity.getSupportFragmentManager();
    }
}

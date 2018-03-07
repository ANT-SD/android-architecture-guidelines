package team.ant.architectureguides.di.component;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.ContributesAndroidInjector;
import team.ant.architectureguides.di.scope.ActivityScope;
import team.ant.architectureguides.di.module.MainModule;
import team.ant.architectureguides.ui.MainActivity;

/**
 * Created by Nacho Vazquez on 3/6/2018.
 */

@ActivityScope
@Component(modules = MainModule.class)
public interface MainComponent {



}

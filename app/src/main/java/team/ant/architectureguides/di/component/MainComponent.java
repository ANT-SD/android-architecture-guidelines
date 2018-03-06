package team.ant.architectureguides.di.component;

import dagger.Component;
import team.ant.architectureguides.di.ActivityScope;
import team.ant.architectureguides.di.module.MainModule;
import team.ant.architectureguides.ui.MainActivity;

/**
 * Created by Nacho Vazquez on 3/6/2018.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity activity);
//    void inject(GithubFragment fragment);
//    void inject(RepositoryDetailFragment fragment);
}

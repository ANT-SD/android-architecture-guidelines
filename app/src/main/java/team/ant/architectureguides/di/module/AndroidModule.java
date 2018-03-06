package team.ant.architectureguides.di.module;

import android.app.Application;
import android.view.LayoutInflater;

import dagger.Module;
import dagger.Provides;
import team.ant.architectureguides.di.ForApplication;

/**
 * Created by Nacho Vazquez on 3/5/2018.
 */
@Module
public class AndroidModule {
    @Provides
    public LayoutInflater provideLayoutInflater(@ForApplication Application application) {
        return LayoutInflater.from(application);
    }
}

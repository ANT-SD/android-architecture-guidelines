package team.ant.architectureguides.di.component;

import android.content.Context;
import android.view.LayoutInflater;

import com.google.gson.Gson;

import dagger.Component;
import retrofit2.Retrofit;
import team.ant.architectureguides.ArchitectureApplication;
import team.ant.architectureguides.di.ApplicationScope;
import team.ant.architectureguides.di.ForApplication;
import team.ant.architectureguides.di.module.AndroidModule;
import team.ant.architectureguides.di.module.ApplicationModule;
import team.ant.architectureguides.di.module.GsonModule;
import team.ant.architectureguides.di.module.NetworkModule;
import team.ant.architectureguides.di.module.OkHttpInterceptorsModule;

/**
 * Created by Nacho Vazquez on 3/6/2018.
 */
@ApplicationScope
@Component(modules = {
        AndroidModule.class,
        ApplicationModule.class,
        NetworkModule.class,
        OkHttpInterceptorsModule.class,
        GsonModule.class})
public interface ApplicationComponent {

    @ForApplication
    Context provideContext();

    LayoutInflater provideLayoutInflater();
    Retrofit provideRetrofit();
    Gson provideGson();

    void inject (ArchitectureApplication application);

//    final class Initializer {
//        public static ApplicationComponent init(ArchitectureApplication application) {
//            return DaggerApplicationComponent.builder()
//                    .androidModule(new AndroidModule())
//                    .applicationModule(new ApplicationModule(application))
//                    .gsonModule(new GsonModule())
//                    .networkModule(new NetworkModule(application))
//                    .okHttpInterceptorsModule(new OkHttpInterceptorsModule())
//                    .build();
//        }
//    }
}

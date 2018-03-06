package team.ant.architectureguides.di.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import team.ant.architectureguides.ArchitectureApplication;
import team.ant.architectureguides.BuildConfig;
import team.ant.architectureguides.di.ApplicationScope;
import team.ant.architectureguides.di.ForApplication;
import team.ant.architectureguides.di.ForOkHttpInterceptors;
import team.ant.architectureguides.di.ForOkHttpNetworkInterceptors;
import team.ant.architectureguides.utils.LiveDataCallAdapterFactory;

/**
 * Created by Nacho Vazquez on 3/5/2018.
 */
@Module
public class NetworkModule {
    static final int DISK_CACHE_SIZE = (int) 1_000_000L;

    private final ArchitectureApplication application;

    public NetworkModule(ArchitectureApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(@ForApplication Context app,
                                            @ForOkHttpInterceptors @NonNull List<Interceptor> interceptors,
                                            @ForOkHttpNetworkInterceptors @NonNull List<Interceptor> networkInterceptors) {

        File cacheDir = new File(app.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);

        final OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

        for (Interceptor interceptor : interceptors) {
            okHttpBuilder.addInterceptor(interceptor);
        }

        for (Interceptor networkInterceptor : networkInterceptors) {
            okHttpBuilder.addNetworkInterceptor(networkInterceptor);
        }

        okHttpBuilder.cache(cache);
        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS);

        return okHttpBuilder.build();

    }

    @Provides
    @ApplicationScope
    public Retrofit provideRestAdapter(@NonNull OkHttpClient okHttpClient, @NonNull Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT_LOCAL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build();
    }
}

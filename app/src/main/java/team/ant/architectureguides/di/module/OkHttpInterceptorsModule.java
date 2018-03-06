package team.ant.architectureguides.di.module;

import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import team.ant.architectureguides.di.ApplicationScope;
import team.ant.architectureguides.di.ForOkHttpInterceptors;
import team.ant.architectureguides.di.ForOkHttpNetworkInterceptors;
import timber.log.Timber;

import static java.util.Collections.singletonList;

/**
 * Created by Nacho Vazquez on 3/6/2018.
 */
@Module
public class OkHttpInterceptorsModule {
    @Provides
    @ApplicationScope
    @NonNull
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor(message -> Timber.d(message));
    }

    @Provides
    @ForOkHttpInterceptors
    @ApplicationScope
    @NonNull
    public List<Interceptor> provideOkHttpInterceptors(@NonNull HttpLoggingInterceptor httpLoggingInterceptor) {
        return singletonList(httpLoggingInterceptor);
    }

    @Provides
    @ForOkHttpNetworkInterceptors
    @ApplicationScope
    @NonNull
    public List<Interceptor> provideOkHttpNetworkInterceptors() {
        return singletonList(new StethoInterceptor());
    }
}

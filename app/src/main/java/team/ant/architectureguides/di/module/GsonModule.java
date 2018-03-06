package team.ant.architectureguides.di.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

import dagger.Module;
import dagger.Provides;
import team.ant.architectureguides.di.ApplicationScope;

/**
 * Created by Nacho Vazquez on 3/6/2018.
 */

@Module
public class GsonModule {
    @Provides
    @ApplicationScope
    public GsonBuilder provideDefaultGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.setDateFormat(DateFormat.FULL);
        return gsonBuilder;
    }

    @Provides
    @ApplicationScope
    Gson provideGson(GsonBuilder gsonBuilder) {
        return gsonBuilder.create();
    }
}
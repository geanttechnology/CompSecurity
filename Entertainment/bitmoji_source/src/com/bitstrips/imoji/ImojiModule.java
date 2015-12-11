// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji;

import android.app.AlarmManager;
import android.app.Application;
import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.BitstripsAnalyticsWebService;
import com.bitstrips.imoji.analytics.FloaterGoogleAnalyticsService;
import com.bitstrips.imoji.analytics.GoogleAnalyticsService;
import com.bitstrips.imoji.analytics.GoogleAnalyticsServiceMock;
import com.bitstrips.imoji.analytics.GoogleAndBitstripsAnalyticsService;
import com.bitstrips.imoji.api.BSAuthPasswordService;
import com.bitstrips.imoji.api.BSAuthService;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.api.TemplatesService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.deserializers.AvatarInfoDeserializer;
import com.bitstrips.imoji.deserializers.OutfitBuilderCatalogsDeserializer;
import com.bitstrips.imoji.manager.FloaterServiceManager;
import com.bitstrips.imoji.manager.RecentImojiesManager;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.models.OutfitBuilderCatalogs;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.services.BitshopGooglePlayService;
import com.bitstrips.imoji.services.CrashlyticsService;
import com.bitstrips.imoji.services.PackageService;
import com.bitstrips.imoji.ui.ImageLoader;
import com.bitstrips.imoji.ui.IntentCreatorService;
import com.bitstrips.imoji.ui.ResolveInfosSorter;
import com.bitstrips.imoji.util.FileUtil;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.bitstrips.imoji.util.WebUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

// Referenced classes of package com.bitstrips.imoji:
//            InjectorApplication

public class ImojiModule
{

    private Application application;

    public ImojiModule(Application application1)
    {
        application = application1;
    }

    AlarmManager provideAlarmManager()
    {
        return (AlarmManager)application.getSystemService("alarm");
    }

    AnalyticsService provideAnalyticsService(GoogleAndBitstripsAnalyticsService googleandbitstripsanalyticsservice)
    {
        return googleandbitstripsanalyticsservice;
    }

    String provideAvatarId(PreferenceUtils preferenceutils)
    {
        return preferenceutils.getString(0x7f06002a, null);
    }

    BSAuthPasswordService provideBSAuthPasswordService()
    {
        return (BSAuthPasswordService)provideRestAdapter(0x7f060039, com/bitstrips/imoji/api/BSAuthPasswordService, null);
    }

    BSAuthService provideBSAuthService()
    {
        return (BSAuthService)provideRestAdapter(0x7f060039, com/bitstrips/imoji/api/BSAuthService, null);
    }

    BitstripsAnalyticsWebService provideBitStripsAnalyticsService()
    {
        return (BitstripsAnalyticsWebService)provideRestAdapter(0x7f060036, com/bitstrips/imoji/analytics/BitstripsAnalyticsWebService, new GsonConverter((new GsonBuilder()).setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()));
    }

    BitshopGooglePlayService provideBitshopGooglePlayService()
    {
        return new BitshopGooglePlayService(application);
    }

    BitstripsService provideBitstripsService()
    {
        return (BitstripsService)provideRestAdapter(0x7f060038, com/bitstrips/imoji/api/BitstripsService, new GsonConverter((new GsonBuilder()).registerTypeAdapter(com/bitstrips/imoji/models/AvatarInfo, new AvatarInfoDeserializer()).create()));
    }

    Context provideContext()
    {
        return application;
    }

    FacebookService provideFacebookService()
    {
        return new FacebookService();
    }

    FileUtil provideFileUtil()
    {
        return new FileUtil(application);
    }

    FloaterGoogleAnalyticsService provideFloaterAnalyticsService()
    {
        return new FloaterGoogleAnalyticsService(GoogleAnalytics.getInstance(application).newTracker(0x7f050001), application);
    }

    FloaterServiceManager provideFloaterServiceManager()
    {
        return new FloaterServiceManager(application);
    }

    GoogleAnalyticsService provideGoogleAnalyticsAnalyticsService(Tracker tracker)
    {
        if ("r2d2".equals("production"))
        {
            return new GoogleAnalyticsServiceMock(tracker, application);
        } else
        {
            return new GoogleAnalyticsService(tracker, application);
        }
    }

    GoogleAndBitstripsAnalyticsService provideGoogleAndBitstripsAnalyticsService()
    {
        GoogleAndBitstripsAnalyticsService googleandbitstripsanalyticsservice = new GoogleAndBitstripsAnalyticsService();
        ((InjectorApplication)application).inject(googleandbitstripsanalyticsservice);
        return googleandbitstripsanalyticsservice;
    }

    ImageLoader provideImageLoader(Picasso picasso)
    {
        return new ImageLoader(picasso);
    }

    Picasso providePicasso()
    {
        return Picasso.with(application);
    }

    PreferenceUtils providePreferenceUtils()
    {
        return new PreferenceUtils(application, 0x7f0600bd);
    }

    RequestInterceptor provideRequestInterceptor()
    {
        return new RequestInterceptor() {

            final ImojiModule this$0;

            public void intercept(retrofit.RequestInterceptor.RequestFacade requestfacade)
            {
                requestfacade.addHeader("User-Agent", System.getProperty("http.agent"));
                requestfacade.addHeader("Bitmoji-User-Agent", WebUtils.getBitmojiUserAgent(application));
                requestfacade.addHeader(application.getString(0x7f060001), application.getString(0x7f060002));
            }

            
            {
                this$0 = ImojiModule.this;
                super();
            }
        };
    }

    ResolveInfosSorter provideResolveInfosSorter()
    {
        return new ResolveInfosSorter();
    }

    Object provideRestAdapter(int i, Class class1, Converter converter)
    {
        retrofit.RestAdapter.Builder builder = (new retrofit.RestAdapter.Builder()).setEndpoint(application.getString(i)).setRequestInterceptor(provideRequestInterceptor());
        if (converter != null)
        {
            builder.setConverter(converter);
        }
        return builder.build().create(class1);
    }

    TemplatesManager provideTemplatesManager()
    {
        return new TemplatesManager(application);
    }

    TemplatesService provideTemplatesService()
    {
        return (TemplatesService)provideRestAdapter(0x7f060038, com/bitstrips/imoji/api/TemplatesService, new GsonConverter((new GsonBuilder()).registerTypeAdapter(com/bitstrips/imoji/models/OutfitBuilderCatalogs, new OutfitBuilderCatalogsDeserializer()).create()));
    }

    Tracker provideTracker()
    {
        return GoogleAnalytics.getInstance(application).newTracker(0x7f050003);
    }

    B4MService providerB4MService()
    {
        B4MService b4mservice = new B4MService(application);
        b4mservice.setGraphAPIVersionData(application.getString(0x7f060001), application.getString(0x7f060002));
        return b4mservice;
    }

    CrashlyticsService providerCrashlyticsService()
    {
        return new CrashlyticsService();
    }

    IntentCreatorService providerIntentCreatorService()
    {
        return new IntentCreatorService(application);
    }

    PackageService providerPackageService()
    {
        return new PackageService(application);
    }

    RecentImojiesManager providerRecentImojiesManager()
    {
        return new RecentImojiesManager(application);
    }

    RequestQueue providerRequestQueue()
    {
        return Volley.newRequestQueue(application);
    }

}

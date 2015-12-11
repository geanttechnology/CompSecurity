// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.init;

import android.content.Context;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.client.ClientIdProvider;
import com.amazon.retailsearch.data.IRetailSearchDataProvider;
import com.amazon.retailsearch.data.assets.AssetFetchType;
import com.amazon.retailsearch.deviceinfo.DeviceInfoLoader;
import com.amazon.retailsearch.deviceinfo.MasEventReceiver;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.di.RetailSearchInternalModule;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.SearchLog;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.dp.utils.SystemTime;
import dagger.Lazy;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.amazon.retailsearch.android.api.init:
//            SearchInitializer, RetailSearchInitSettings, DebugMode

public class RetailSearchInitializer
    implements SearchInitializer
{

    private static RetailSearchInitializer initializer = new RetailSearchInitializer();
    FeatureConfiguration featureConfig;
    private boolean initComplete;
    Lazy retailSearchDataProvider;
    private RetailSearchLogger retailSearchLogger;
    private RetailSearchInitSettings settings;

    public RetailSearchInitializer()
    {
        initComplete = false;
    }

    private void doInit(Context context, RetailSearchInitSettings retailsearchinitsettings)
    {
        com.amazon.retailsearch.android.api.experimentation.WeblabClient weblabclient = null;
        settings = retailsearchinitsettings;
        FeatureConfiguration featureconfiguration;
        if (retailsearchinitsettings != null)
        {
            featureconfiguration = retailsearchinitsettings.getFeatureConfiguration();
        } else
        {
            featureconfiguration = null;
        }
        if (retailsearchinitsettings != null)
        {
            weblabclient = retailsearchinitsettings.getWeblabClient();
        }
        RetailSearchDaggerGraphController.createGraph(new Object[] {
            new RetailSearchInternalModule(context, featureconfiguration, weblabclient)
        });
        RetailSearchDaggerGraphController.inject(this);
        initializeLog(context, retailsearchinitsettings);
        AndroidRetailSearchClient.setClientId(ClientIdProvider.getClientId(context.getResources()));
        AndroidRetailSearchClient.setUserAgent(retailsearchinitsettings.getUserAgent());
        AndroidRetailSearchClient.setAppVersion(retailsearchinitsettings.getAppVersion());
        DeviceInfoLoader.getInstance().refresh(context, 750);
        (new MasEventReceiver()).register(context);
    }

    public static RetailSearchInitializer getInstance()
    {
        return initializer;
    }

    private void initializeLog(Context context, RetailSearchInitSettings retailsearchinitsettings)
    {
        AppLog applog = AppLog.getAppLog();
        if (retailsearchinitsettings != null && retailsearchinitsettings.isDebugMode())
        {
            DebugMode.setEnabled(true);
            applog.setLevel(2);
        } else
        {
            DebugMode.setEnabled(false);
            applog.setLevel(6);
        }
        RetailSearchLoggingProvider.init(context);
        applog.getRecorders().add(new SearchLog(applog));
        applog.setEnabled(true);
    }

    public RetailSearchInitSettings getSettings()
    {
        return settings;
    }

    public void initialize(Context context)
    {
        initialize(context, null);
    }

    public void initialize(Context context, RetailSearchInitSettings retailsearchinitsettings)
    {
        if (initComplete)
        {
            return;
        } else
        {
            long l = SystemTime.now();
            doInit(context, retailsearchinitsettings);
            initComplete = true;
            long l1 = SystemTime.now();
            retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
            retailSearchLogger.saveSearchInitTime(l1 - l);
            return;
        }
    }

    public void onStartup()
    {
        try
        {
            ((IRetailSearchDataProvider)retailSearchDataProvider.get()).fetchAssets(AssetFetchType.STARTUP_SEQUENCE);
            return;
        }
        catch (Exception exception)
        {
            retailSearchLogger.error("startUp call resulted in an exception", exception);
        }
    }

    public void reset()
    {
        reset(null);
    }

    public void reset(Locale locale)
    {
        SearchConfiguration searchconfiguration = SearchConfiguration.getConfiguration();
        Locale locale1 = locale;
        if (locale == null)
        {
            locale1 = Locale.getDefault();
        }
        locale = searchconfiguration.getRealmForLocale(locale1);
        if (locale.equals(searchconfiguration.getRealm()))
        {
            return;
        } else
        {
            searchconfiguration.setRealm(locale);
            AndroidRetailSearchClient.resetClient();
            ((IRetailSearchDataProvider)retailSearchDataProvider.get()).clearAssets();
            ((IRetailSearchDataProvider)retailSearchDataProvider.get()).fetchAssets(AssetFetchType.APP_RESET);
            ((IRetailSearchDataProvider)retailSearchDataProvider.get()).clearSuggestions();
            return;
        }
    }

}

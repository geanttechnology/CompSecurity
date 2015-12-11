// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.init;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.retailsearch.android.api.debug.SearchDebugDataStore;
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
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.SearchLog;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchConfigurationManager;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import com.amazon.searchapp.retailsearch.client.ServiceCallDebugOptions;
import com.dp.utils.SystemTime;
import dagger.Lazy;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.amazon.retailsearch.android.api.init:
//            SearchInitializer, RetailSearchInitSettings, RetailSearchAppType, DebugMode

public class RetailSearchInitializer
    implements SearchInitializer
{

    private static RetailSearchInitializer initializer = new RetailSearchInitializer();
    private Context context;
    Lazy dataSource;
    FeatureConfiguration featureConfig;
    private boolean initComplete;
    Lazy retailSearchDataProvider;
    private RetailSearchLogger retailSearchLogger;
    SearchDebugDataStore searchDataStore;
    private RetailSearchInitSettings settings;
    private boolean startupComplete;

    public RetailSearchInitializer()
    {
        initComplete = false;
        startupComplete = false;
    }

    private void doInit(RetailSearchInitSettings retailsearchinitsettings)
    {
        Object obj1 = null;
        settings = retailsearchinitsettings;
        Context context1 = context;
        Object obj;
        if (retailsearchinitsettings != null)
        {
            obj = retailsearchinitsettings.getFeatureConfiguration();
        } else
        {
            obj = null;
        }
        if (retailsearchinitsettings != null)
        {
            obj1 = retailsearchinitsettings.getWeblabClient();
        }
        RetailSearchDaggerGraphController.createGraph(new Object[] {
            new RetailSearchInternalModule(context1, ((FeatureConfiguration) (obj)), ((com.amazon.retailsearch.android.api.experimentation.WeblabClient) (obj1)))
        });
        RetailSearchDaggerGraphController.inject(this);
        initializeLog(retailsearchinitsettings);
        obj1 = SearchConfiguration.getConfiguration();
        obj = null;
        if (retailsearchinitsettings != null)
        {
            if (retailsearchinitsettings.getConfigId() != null)
            {
                SearchConfigurationManager.getInstance().setConfigurationId(retailsearchinitsettings.getConfigId());
            }
            if (retailsearchinitsettings.getObsfucatedMarketplaceId() != null)
            {
                obj = ((SearchConfiguration) (obj1)).getRealmByObfuscatedMarketplaceId(retailsearchinitsettings.getObsfucatedMarketplaceId());
                if (obj != null)
                {
                    ((SearchConfiguration) (obj1)).setRealm(((SearchRealm) (obj)));
                }
            }
            if (retailsearchinitsettings.isDebugMode())
            {
                obj = searchDataStore.getSearchRealm();
                if (obj != null)
                {
                    SearchConfiguration.getConfiguration().setRealm(((SearchRealm) (obj)));
                }
                obj = searchDataStore.getServiceCallDebugOptions();
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    ServiceCallDebugOptions.getInstance().setSearchDebugOptions(((String) (obj)));
                }
            }
            if (retailsearchinitsettings.getUserAgent() != null)
            {
                AndroidRetailSearchClient.setUserAgent(retailsearchinitsettings.getUserAgent());
            }
            if (retailsearchinitsettings.getAppVersion() != null)
            {
                AndroidRetailSearchClient.setAppVersion(retailsearchinitsettings.getAppVersion());
            }
            if (retailsearchinitsettings.getDeviceId() != null)
            {
                DeviceInfoLoader.getInstance().setDeviceType(retailsearchinitsettings.getDeviceId());
            }
            if (retailsearchinitsettings.getDataVersion() != null)
            {
                AndroidRetailSearchClient.setDataVersion(retailsearchinitsettings.getDataVersion());
            }
            obj = retailsearchinitsettings.getAppType();
        }
        if (obj != null)
        {
            retailsearchinitsettings = ((RetailSearchAppType) (obj)).getClientId();
        } else
        {
            retailsearchinitsettings = ClientIdProvider.getClientId(context.getResources());
        }
        AndroidRetailSearchClient.setClientId(retailsearchinitsettings);
        retailsearchinitsettings = ((SearchConfiguration) (obj1)).getRealmForLocale(Locale.getDefault());
        if (!retailsearchinitsettings.equals(((SearchConfiguration) (obj1)).getRealm()))
        {
            ((SearchConfiguration) (obj1)).setRealm(retailsearchinitsettings);
        }
        if (obj != null && ((RetailSearchAppType) (obj)).isAppStoreSupported())
        {
            DeviceInfoLoader.getInstance().refresh(context, 750);
            (new MasEventReceiver()).register(context);
            return;
        } else
        {
            DeviceInfoLoader.getInstance().loadDefaults(context);
            return;
        }
    }

    public static RetailSearchInitializer getInstance()
    {
        return initializer;
    }

    private void initializeLog(RetailSearchInitSettings retailsearchinitsettings)
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

    private void setRealm(SearchRealm searchrealm, SearchConfiguration searchconfiguration)
    {
        if (searchrealm == null || searchrealm.equals(searchconfiguration.getRealm()))
        {
            return;
        }
        searchconfiguration.setRealm(searchrealm);
        AndroidRetailSearchClient.resetClient();
        ((IRetailSearchDataProvider)retailSearchDataProvider.get()).clearAssets();
        ((IRetailSearchDataProvider)retailSearchDataProvider.get()).fetchAssets(AssetFetchType.APP_RESET);
        if ("T1".equals(FeatureStateUtil.getAdaptiveSearchWeblab(featureConfig)))
        {
            ((IRetailSearchDataProvider)retailSearchDataProvider.get()).clearMetrics();
            ((IRetailSearchDataProvider)retailSearchDataProvider.get()).fetchMetrics();
        }
        ((IRetailSearchDataProvider)retailSearchDataProvider.get()).clearSuggestions();
        ((SearchDataSource)dataSource.get()).clearCache();
    }

    public RetailSearchInitSettings getSettings()
    {
        return settings;
    }

    public void initialize(Context context1)
    {
        initialize(context1, null);
    }

    public void initialize(Context context1, RetailSearchInitSettings retailsearchinitsettings)
    {
        context = context1;
        if (initComplete)
        {
            return;
        } else
        {
            long l = SystemTime.now();
            doInit(retailsearchinitsettings);
            initComplete = true;
            long l1 = SystemTime.now();
            retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
            retailSearchLogger.saveSearchInitTime(l1 - l);
            return;
        }
    }

    public void onStartup()
    {
        if (startupComplete)
        {
            return;
        }
        try
        {
            if ("T1".equals(FeatureStateUtil.getAdaptiveSearchWeblab(featureConfig)))
            {
                ((IRetailSearchDataProvider)retailSearchDataProvider.get()).fetchMetrics();
            }
            ((IRetailSearchDataProvider)retailSearchDataProvider.get()).fetchAssets(AssetFetchType.STARTUP_SEQUENCE);
            startupComplete = true;
            return;
        }
        catch (Exception exception)
        {
            retailSearchLogger.error("startUp call resulted in an exception", exception);
        }
    }

    public void reset()
    {
        reset((Locale)null);
    }

    public void reset(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            SearchConfiguration searchconfiguration = SearchConfiguration.getConfiguration();
            setRealm(searchconfiguration.getRealmByObfuscatedMarketplaceId(s), searchconfiguration);
            return;
        }
    }

    public void reset(Locale locale)
    {
        SearchConfiguration searchconfiguration = SearchConfiguration.getConfiguration();
        Locale locale1 = locale;
        if (locale == null)
        {
            locale1 = Locale.getDefault();
        }
        setRealm(searchconfiguration.getRealmForLocale(locale1), searchconfiguration);
    }

    public void reset(Locale locale, boolean flag)
    {
        if (settings != null)
        {
            settings.setAppStoreEnabled(flag);
        }
        reset(locale);
    }

}

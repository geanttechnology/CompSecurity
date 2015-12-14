// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads.identity:
//            ThreadUtils, AdvertisingIdentifier, Settings, WebRequest, 
//            DebugProperties, Metrics, AmazonRegistration, IAmazonRegistration, 
//            RegistrationInfo, DeviceInfo, Version, PreferredMarketplaceRetriever, 
//            Log, PermissionChecker, ResponseReader, StringUtils, 
//            MetricsCollector

class Configuration
{
    public static class ConfigOption
    {

        public static final ConfigOption AAX_HOSTNAME;
        public static final ConfigOption AD_PREF_URL;
        public static final ConfigOption MADS_HOSTNAME;
        public static final ConfigOption SEND_GEO;
        public static final ConfigOption SIS_DOMAIN;
        public static final ConfigOption SIS_URL;
        public static final ConfigOption configOptions[];
        private final boolean allowEmpty;
        private final Class dataType;
        private final String debugProperty;
        private final String responseKey;
        private final String settingsName;

        boolean getAllowEmpty()
        {
            return allowEmpty;
        }

        Class getDataType()
        {
            return dataType;
        }

        String getDebugProperty()
        {
            return debugProperty;
        }

        String getResponseKey()
        {
            return responseKey;
        }

        String getSettingsName()
        {
            return settingsName;
        }

        static 
        {
            AAX_HOSTNAME = new ConfigOption("config-aaxHostname", java/lang/String, "aaxHostname", "debug.aaxHostname");
            SIS_URL = new ConfigOption("config-sisURL", java/lang/String, "sisURL", "debug.sisURL");
            AD_PREF_URL = new ConfigOption("config-adPrefURL", java/lang/String, "adPrefURL", "debug.adPrefURL");
            MADS_HOSTNAME = new ConfigOption("config-madsHostname", java/lang/String, "madsHostname", "debug.madsHostname", true);
            SIS_DOMAIN = new ConfigOption("config-sisDomain", java/lang/String, "sisDomain", "debug.sisDomain");
            SEND_GEO = new ConfigOption("config-sendGeo", java/lang/Boolean, "sendGeo", "debug.sendGeo");
            configOptions = (new ConfigOption[] {
                AAX_HOSTNAME, SIS_URL, AD_PREF_URL, MADS_HOSTNAME, SIS_DOMAIN, SEND_GEO
            });
        }

        protected ConfigOption(String s, Class class1, String s1, String s2)
        {
            this(s, class1, s1, s2, false);
        }

        protected ConfigOption(String s, Class class1, String s1, String s2, boolean flag)
        {
            settingsName = s;
            responseKey = s1;
            dataType = class1;
            debugProperty = s2;
            allowEmpty = flag;
        }
    }

    static interface ConfigurationListener
    {

        public abstract void onConfigurationFailure();

        public abstract void onConfigurationReady();
    }


    private static final String LOG_TAG = com/amazon/device/ads/identity/Configuration.getSimpleName();
    private static Configuration instance = new Configuration();
    private String appDefinedMarketplace;
    private boolean isAppDefinedMarketplaceSet;
    private AtomicBoolean isFetching;
    private boolean isFirstParty;
    private Boolean lastTestModeValue;
    private List listeners;
    private PreferredMarketplaceRetriever pfmRetriever;

    protected Configuration()
    {
        appDefinedMarketplace = null;
        isAppDefinedMarketplaceSet = false;
        listeners = null;
        isFetching = null;
        lastTestModeValue = null;
        isFirstParty = false;
        pfmRetriever = new PreferredMarketplaceRetriever.NullPreferredMarketplaceRetriever();
        listeners = new ArrayList(5);
        isFetching = new AtomicBoolean(false);
    }

    public static final Configuration getInstance()
    {
        return instance;
    }

    protected void beginFetch()
    {
        ThreadUtils.executeRunnable(new Runnable() {

            final Configuration this$0;

            public void run()
            {
                fetchConfigurationOnBackgroundThread();
            }

            
            {
                this$0 = Configuration.this;
                super();
            }
        });
    }

    AdvertisingIdentifier.Info createAdvertisingIdentifierInfo()
    {
        boolean flag = false;
        AdvertisingIdentifier advertisingidentifier = new AdvertisingIdentifier();
        if (Settings.getInstance().getInt("configVersion", 0) != 0)
        {
            flag = true;
        }
        return advertisingidentifier.setShouldSetCurrentAdvertisingIdentifier(flag).getAdvertisingIdentifierInfo();
    }

    protected WebRequest createWebRequest(AdvertisingIdentifier.Info info)
    {
        WebRequest webrequest = WebRequest.createJSONGetWebRequest();
        webrequest.setExternalLogTag(LOG_TAG);
        webrequest.enableLog$1385ff();
        webrequest.setHost(DebugProperties.getInstance().getDebugPropertyAsString("debug.aaxConfigHostname", "aax-us-east.amazon-adsystem.com"));
        webrequest.setPath("/e/msdk/cfg");
        webrequest.setMetricsCollector(Metrics.getInstance().getMetricsCollector());
        webrequest.setServiceCallLatencyMetric(Metrics.MetricType.AAX_CONFIG_DOWNLOAD_LATENCY);
        webrequest.setUseSecure(DebugProperties.getInstance().getDebugPropertyAsBoolean("debug.aaxConfigUseSecure", true));
        RegistrationInfo registrationinfo = AmazonRegistration.getInstance().getRegistrationInfo();
        DeviceInfo deviceinfo = AmazonRegistration.getInstance().getDeviceInfo();
        webrequest.putUnencodedQueryParameter("appId", registrationinfo.getAppKey());
        webrequest.putUnencodedQueryParameter("dinfo", deviceinfo.getDInfoProperty().toString());
        webrequest.putUnencodedQueryParameter("adId", info.getSISDeviceIdentifier());
        webrequest.putUnencodedQueryParameter("sdkVer", Version.getSDKVersion());
        webrequest.putUnencodedQueryParameter("fp", Boolean.toString(isFirstParty));
        webrequest.putUnencodedQueryParameter("mkt", Settings.getInstance().getString("config-appDefinedMarketplace", null));
        webrequest.putUnencodedQueryParameter("pfm", pfmRetriever.retrievePreferredMarketplace(AmazonRegistration.getInstance().getApplicationContext()));
        boolean flag = Settings.getInstance().getBoolean("testingEnabled", false);
        setLastTestModeValue(flag);
        if (flag)
        {
            webrequest.putUnencodedQueryParameter("testMode", "true");
        }
        webrequest.setAdditionalQueryParamsString(DebugProperties.getInstance().getDebugPropertyAsString("debug.aaxConfigParams", null));
        return webrequest;
    }

    protected void fetchConfigurationOnBackgroundThread()
    {
        Object obj;
        Settings settings;
        ConfigOption configoption;
        String s;
        int i;
        Log.d(LOG_TAG, "In configuration fetcher background thread.", new Object[0]);
        if (!PermissionChecker.hasInternetPermission(AmazonRegistration.getInstance().getApplicationContext()))
        {
            Log.e(LOG_TAG, "Network task cannot commence because the INTERNET permission is missing from the app's manifest.", new Object[0]);
            onFetchFailure();
            return;
        }
        obj = createAdvertisingIdentifierInfo();
        if (!((AdvertisingIdentifier.Info) (obj)).canDo())
        {
            onFetchFailure();
            return;
        }
        obj = createWebRequest(((AdvertisingIdentifier.Info) (obj)));
        ConfigOption aconfigoption[];
        int j;
        try
        {
            obj = ((WebRequest) (obj)).makeCall();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            onFetchFailure();
            return;
        }
        obj = ((WebRequest.WebResponse) (obj)).getResponseReader().readAsJSON();
        settings = Settings.getInstance();
        try
        {
            aconfigoption = getConfigOptions();
            j = aconfigoption.length;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(LOG_TAG, "Unable to parse JSON response: %s", new Object[] {
                ((JSONException) (obj)).getMessage()
            });
            onFetchFailure();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e(LOG_TAG, "Unexpected error during parsing: %s", new Object[] {
                ((Exception) (obj)).getMessage()
            });
            onFetchFailure();
            return;
        }
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_330;
        }
        configoption = aconfigoption[i];
        if (!((JSONObject) (obj)).isNull(configoption.getResponseKey()))
        {
            break MISSING_BLOCK_LABEL_185;
        }
        if (!configoption.getAllowEmpty())
        {
            throw new Exception("The configuration value must be present and not null.");
        }
        settings.removeWithNoFlush(configoption.getSettingsName());
        break MISSING_BLOCK_LABEL_426;
        if (!configoption.getDataType().equals(java/lang/String))
        {
            break MISSING_BLOCK_LABEL_279;
        }
        s = ((JSONObject) (obj)).getString(configoption.getResponseKey());
        if (!configoption.getAllowEmpty() && StringUtils.isNullOrWhiteSpace(s))
        {
            throw new IllegalArgumentException("The configuration value must not be empty or contain only white spaces.");
        }
        Settings.getInstance().putStringWithNoFlush(configoption.getSettingsName(), s);
        break MISSING_BLOCK_LABEL_426;
        if (configoption.getDataType().equals(java/lang/Boolean))
        {
            boolean flag = ((JSONObject) (obj)).getBoolean(configoption.getResponseKey());
            Settings.getInstance().putBooleanWithNoFlush(configoption.getSettingsName(), flag);
            break MISSING_BLOCK_LABEL_426;
        }
        throw new IllegalArgumentException("Undefined configuration option type.");
        if (((JSONObject) (obj)).isNull("ttl"))
        {
            throw new Exception("The configuration value must be present and not null.");
        }
        i = ((JSONObject) (obj)).getInt("ttl");
        int k = i;
        if (i > 0x2a300)
        {
            k = 0x2a300;
        }
        settings.putIntWithNoFlush("config-ttl", k);
        settings.putLongWithNoFlush("config-lastFetchTime", nanoTime());
        settings.putIntWithNoFlush("configVersion", 1);
        settings.flush();
        Log.d(LOG_TAG, "Configuration fetched and saved.", new Object[0]);
        onFetchSuccess();
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected ConfigurationListener[] getAndClearListeners()
    {
        this;
        JVM INSTR monitorenter ;
        ConfigurationListener aconfigurationlistener[];
        aconfigurationlistener = new ConfigurationListener[listeners.size()];
        aconfigurationlistener = (ConfigurationListener[])listeners.toArray(aconfigurationlistener);
        listeners.clear();
        this;
        JVM INSTR monitorexit ;
        return aconfigurationlistener;
        Exception exception;
        exception;
        throw exception;
    }

    protected ConfigOption[] getConfigOptions()
    {
        return ConfigOption.configOptions;
    }

    public String getString(ConfigOption configoption)
    {
        String s1 = DebugProperties.getInstance().getDebugPropertyAsString(configoption.getDebugProperty(), null);
        String s = s1;
        if (s1 == null)
        {
            s = Settings.getInstance().getString(configoption.getSettingsName(), null);
        }
        return s;
    }

    public boolean hasValue(ConfigOption configoption)
    {
        return !StringUtils.isNullOrWhiteSpace(getString(configoption));
    }

    protected boolean isFetching()
    {
        return isFetching.get();
    }

    protected long nanoTime()
    {
        return System.nanoTime();
    }

    protected void onFetchFailure()
    {
        this;
        JVM INSTR monitorenter ;
        ConfigurationListener aconfigurationlistener[];
        int j;
        Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AAX_CONFIG_DOWNLOAD_FAILED);
        setIsFetching(false);
        aconfigurationlistener = getAndClearListeners();
        j = aconfigurationlistener.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aconfigurationlistener[i].onConfigurationFailure();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void onFetchSuccess()
    {
        this;
        JVM INSTR monitorenter ;
        ConfigurationListener aconfigurationlistener[];
        int j;
        setIsFetching(false);
        aconfigurationlistener = getAndClearListeners();
        j = aconfigurationlistener.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aconfigurationlistener[i].onConfigurationReady();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void queueConfigurationListener(ConfigurationListener configurationlistener)
    {
        this;
        JVM INSTR monitorenter ;
        queueConfigurationListener$1aa4596a(configurationlistener);
        this;
        JVM INSTR monitorexit ;
        return;
        configurationlistener;
        throw configurationlistener;
    }

    public void queueConfigurationListener$1aa4596a(ConfigurationListener configurationlistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (!isFetching()) goto _L2; else goto _L1
_L1:
        listeners.add(configurationlistener);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!shouldFetch())
        {
            break MISSING_BLOCK_LABEL_71;
        }
        listeners.add(configurationlistener);
        Log.d(LOG_TAG, "Starting configuration fetching...", new Object[0]);
        setIsFetching(true);
        beginFetch();
          goto _L3
        configurationlistener;
        throw configurationlistener;
        configurationlistener.onConfigurationReady();
          goto _L3
    }

    protected void setIsFetching(boolean flag)
    {
        isFetching.set(flag);
    }

    public void setIsFirstParty$1385ff()
    {
        isFirstParty = true;
    }

    protected void setLastTestModeValue(boolean flag)
    {
        lastTestModeValue = Boolean.valueOf(flag);
    }

    public void setPreferredMarketplaceRetriever(PreferredMarketplaceRetriever preferredmarketplaceretriever)
    {
        pfmRetriever = preferredmarketplaceretriever;
    }

    protected boolean shouldFetch()
    {
        Settings settings;
        Settings settings1;
        String s;
        settings = Settings.getInstance();
        settings1 = Settings.getInstance();
        s = settings1.getString("config-appDefinedMarketplace", null);
        if (!isAppDefinedMarketplaceSet) goto _L2; else goto _L1
_L1:
        isAppDefinedMarketplaceSet = false;
        if (appDefinedMarketplace == null || appDefinedMarketplace.equals(s)) goto _L4; else goto _L3
_L3:
        boolean flag;
        settings1.putLongWithNoFlush("config-lastFetchTime", 0L);
        settings1.putStringWithNoFlush("config-appDefinedMarketplace", appDefinedMarketplace);
        settings1.flush();
        AmazonRegistration.getInstance().getRegistrationInfo().requestNewSISDeviceIdentifier();
        Log.d(LOG_TAG, "New application-defined marketplace set. A new configuration will be retrieved.", new Object[0]);
        flag = true;
          goto _L5
_L8:
        return true;
_L4:
        if (s == null || appDefinedMarketplace != null) goto _L2; else goto _L6
_L6:
        settings1.remove("config-appDefinedMarketplace");
        AmazonRegistration.getInstance().getRegistrationInfo().requestNewSISDeviceIdentifier();
        Log.d(LOG_TAG, "Application-defined marketplace removed. A new configuration will be retrieved.", new Object[0]);
        flag = true;
_L5:
        if (flag || Settings.getInstance().getInt("configVersion", 0) != 1) goto _L8; else goto _L7
_L7:
        long l = nanoTime();
        long l1 = settings.getLong("config-lastFetchTime", 0L);
        long l2 = settings.getInt("config-ttl", 0x2a300);
        if (l1 == 0L)
        {
            Log.d(LOG_TAG, "No configuration found. A new configuration will be retrieved.", new Object[0]);
            return true;
        }
        if (l - l1 > 0x3b9aca00L * l2)
        {
            Log.d(LOG_TAG, "The configuration has expired. A new configuration will be retrieved.", new Object[0]);
            return true;
        }
        if (lastTestModeValue != null && lastTestModeValue.booleanValue() != settings.getBoolean("testingEnabled", false))
        {
            Log.d(LOG_TAG, "The testing mode has changed. A new configuration will be retrieved.", new Object[0]);
            return true;
        }
        if (DebugProperties.getInstance().getDebugPropertyAsBoolean("debug.shouldFetchConfig", false)) goto _L8; else goto _L9
_L9:
        return false;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L10
_L10:
    }

}

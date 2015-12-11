// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            DebugProperties, PreferredMarketplaceRetriever, Settings, InternalAdRegistration, 
//            IInternalAdRegistration, RegistrationInfo, Log, Utils, 
//            ThreadUtils, AdvertisingIdentifier, WebRequest, Metrics, 
//            DeviceInfo, Version, PermissionChecker, MetricsCollector

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


    private static final String AAX_MSDK_CONFIG_ENDPOINT = "/e/msdk/cfg";
    private static final String AAX_PROD_US_HOSTNAME = "aax-us-east.amazon-adsystem.com";
    protected static final String CONFIG_APP_DEFINED_MARKETPLACE = "config-appDefinedMarketplace";
    protected static final String CONFIG_LASTFETCHTIME = "config-lastFetchTime";
    protected static final String CONFIG_TTL = "config-ttl";
    protected static final String CONFIG_VERSION_NAME = "configVersion";
    protected static final int CURRENT_CONFIG_VERSION = 1;
    private static final String LOG_TAG = com/amazon/device/ads/Configuration.getSimpleName();
    protected static final int MAX_CONFIG_TTL = 0x2a300;
    protected static final int MAX_NO_RETRY_TTL = 0x493e0;
    protected static Configuration instance = new Configuration();
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

    public static int getMaxNoRetryTtl()
    {
        return DebugProperties.getDebugPropertyAsInteger("debug.noRetryTTLMax", 0x493e0);
    }

    private String getPreferredMarketplace()
    {
        return pfmRetriever.retrievePreferredMarketplace();
    }

    private boolean hasAppDefinedMarketplaceChanged()
    {
        Settings settings = Settings.getInstance();
        String s = settings.getString("config-appDefinedMarketplace", null);
        boolean flag1 = false;
        boolean flag = flag1;
        if (isAppDefinedMarketplaceSet)
        {
            isAppDefinedMarketplaceSet = false;
            if (appDefinedMarketplace != null && !appDefinedMarketplace.equals(s))
            {
                settings.putLongWithNoFlush("config-lastFetchTime", 0L);
                settings.putStringWithNoFlush("config-appDefinedMarketplace", appDefinedMarketplace);
                settings.flush();
                InternalAdRegistration.getInstance().getRegistrationInfo().requestNewSISDeviceIdentifier();
                Log.d(LOG_TAG, "New application-defined marketplace set. A new configuration will be retrieved.");
                flag = true;
            } else
            {
                flag = flag1;
                if (s != null)
                {
                    flag = flag1;
                    if (appDefinedMarketplace == null)
                    {
                        settings.remove("config-appDefinedMarketplace");
                        InternalAdRegistration.getInstance().getRegistrationInfo().requestNewSISDeviceIdentifier();
                        Log.d(LOG_TAG, "Application-defined marketplace removed. A new configuration will be retrieved.");
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    private void writeSettingFromConfigOption(ConfigOption configoption, JSONObject jsonobject)
        throws Exception
    {
        if (configoption.getDataType().equals(java/lang/String))
        {
            jsonobject = jsonobject.getString(configoption.getResponseKey());
            if (!configoption.getAllowEmpty() && Utils.isNullOrWhiteSpace(jsonobject))
            {
                throw new IllegalArgumentException("The configuration value must not be empty or contain only white spaces.");
            } else
            {
                Settings.getInstance().putStringWithNoFlush(configoption.getSettingsName(), jsonobject);
                return;
            }
        }
        if (configoption.getDataType().equals(java/lang/Boolean))
        {
            boolean flag = jsonobject.getBoolean(configoption.getResponseKey());
            Settings.getInstance().putBooleanWithNoFlush(configoption.getSettingsName(), flag);
            return;
        } else
        {
            throw new IllegalArgumentException("Undefined configuration option type.");
        }
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
        webrequest.enableLogUrl(true);
        webrequest.setHost(DebugProperties.getDebugPropertyAsString("debug.aaxConfigHostname", "aax-us-east.amazon-adsystem.com"));
        webrequest.setPath("/e/msdk/cfg");
        webrequest.setMetricsCollector(Metrics.getInstance().getMetricsCollector());
        webrequest.setServiceCallLatencyMetric(Metrics.MetricType.AAX_CONFIG_DOWNLOAD_LATENCY);
        webrequest.setUseSecure(DebugProperties.getDebugPropertyAsBoolean("debug.aaxConfigUseSecure", true));
        RegistrationInfo registrationinfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        DeviceInfo deviceinfo = InternalAdRegistration.getInstance().getDeviceInfo();
        webrequest.putUnencodedQueryParameter("appId", registrationinfo.getAppKey());
        webrequest.putUnencodedQueryParameter("dinfo", deviceinfo.getDInfoProperty().toString());
        webrequest.putUnencodedQueryParameter("adId", info.getSISDeviceIdentifier());
        webrequest.putUnencodedQueryParameter("sdkVer", Version.getSDKVersion());
        webrequest.putUnencodedQueryParameter("fp", Boolean.toString(isFirstParty));
        webrequest.putUnencodedQueryParameter("mkt", Settings.getInstance().getString("config-appDefinedMarketplace", null));
        webrequest.putUnencodedQueryParameter("pfm", getPreferredMarketplace());
        boolean flag = Settings.getInstance().getBoolean("testingEnabled", false);
        setLastTestModeValue(flag);
        if (flag)
        {
            webrequest.putUnencodedQueryParameter("testMode", "true");
        }
        webrequest.setAdditionalQueryParamsString(DebugProperties.getDebugPropertyAsString("debug.aaxConfigParams", null));
        return webrequest;
    }

    protected void fetchConfigurationOnBackgroundThread()
    {
        Object obj;
        Settings settings;
        int i;
        Log.d(LOG_TAG, "In configuration fetcher background thread.");
        if (!PermissionChecker.getInstance().passesInternetPermissionCheck(InternalAdRegistration.getInstance().getApplicationContext(), LOG_TAG))
        {
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
        ConfigOption configoption;
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
        Log.d(LOG_TAG, "Response Body: %s", new Object[] {
            ((WebRequest.WebResponse) (obj)).getBody()
        });
        obj = ((WebRequest.WebResponse) (obj)).getJSONObjectBody();
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
            break MISSING_BLOCK_LABEL_227;
        }
        configoption = aconfigoption[i];
        if (!((JSONObject) (obj)).isNull(configoption.getResponseKey()))
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (!configoption.getAllowEmpty())
        {
            throw new Exception("The configuration value must be present and not null.");
        }
        settings.removeWithNoFlush(configoption.getSettingsName());
        break MISSING_BLOCK_LABEL_315;
        writeSettingFromConfigOption(configoption, ((JSONObject) (obj)));
        break MISSING_BLOCK_LABEL_315;
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
        Log.d(LOG_TAG, "Configuration fetched and saved.");
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

    public String getAppDefinedMarketplace()
    {
        return appDefinedMarketplace;
    }

    public boolean getBoolean(ConfigOption configoption)
    {
        return getBooleanWithDefault(configoption, false);
    }

    public boolean getBooleanWithDefault(ConfigOption configoption, boolean flag)
    {
        if (DebugProperties.containsDebugProperty(configoption.getDebugProperty()))
        {
            return DebugProperties.getDebugPropertyAsBoolean(configoption.getDebugProperty(), flag);
        } else
        {
            return Settings.getInstance().getBoolean(configoption.getSettingsName(), flag);
        }
    }

    protected ConfigOption[] getConfigOptions()
    {
        return ConfigOption.configOptions;
    }

    PreferredMarketplaceRetriever getPreferredMarketplaceRetriever()
    {
        return pfmRetriever;
    }

    public String getString(ConfigOption configoption)
    {
        String s1 = DebugProperties.getDebugPropertyAsString(configoption.getDebugProperty(), null);
        String s = s1;
        if (s1 == null)
        {
            s = Settings.getInstance().getString(configoption.getSettingsName(), null);
        }
        return s;
    }

    protected boolean isFetching()
    {
        return isFetching.get();
    }

    boolean isFirstParty()
    {
        return isFirstParty;
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
        queueConfigurationListener(configurationlistener, true);
        this;
        JVM INSTR monitorexit ;
        return;
        configurationlistener;
        throw configurationlistener;
    }

    public void queueConfigurationListener(ConfigurationListener configurationlistener, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!isFetching()) goto _L2; else goto _L1
_L1:
        listeners.add(configurationlistener);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!shouldFetch())
        {
            break MISSING_BLOCK_LABEL_71;
        }
        listeners.add(configurationlistener);
        if (!flag) goto _L4; else goto _L3
_L3:
        Log.d(LOG_TAG, "Starting configuration fetching...");
        setIsFetching(true);
        beginFetch();
          goto _L4
        configurationlistener;
        throw configurationlistener;
        configurationlistener.onConfigurationReady();
          goto _L4
    }

    public void setAppDefinedMarketplace(String s)
    {
        appDefinedMarketplace = s;
        isAppDefinedMarketplaceSet = true;
    }

    protected void setIsFetching(boolean flag)
    {
        isFetching.set(flag);
    }

    public void setIsFirstParty(boolean flag)
    {
        isFirstParty = flag;
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
        settings = Settings.getInstance();
        break MISSING_BLOCK_LABEL_4;
        if (!hasAppDefinedMarketplaceChanged() && Settings.getInstance().getInt("configVersion", 0) == 1)
        {
            long l = nanoTime();
            long l1 = settings.getLong("config-lastFetchTime", 0L);
            long l2 = settings.getInt("config-ttl", 0x2a300);
            if (l1 == 0L)
            {
                Log.d(LOG_TAG, "No configuration found. A new configuration will be retrieved.");
                return true;
            }
            if (l - l1 > Utils.convertToNsFromS(l2))
            {
                Log.d(LOG_TAG, "The configuration has expired. A new configuration will be retrieved.");
                return true;
            }
            if (lastTestModeValue != null && lastTestModeValue.booleanValue() != settings.getBoolean("testingEnabled", false))
            {
                Log.d(LOG_TAG, "The testing mode has changed. A new configuration will be retrieved.");
                return true;
            }
            if (!DebugProperties.getDebugPropertyAsBoolean("debug.shouldFetchConfig", false))
            {
                return false;
            }
        }
        return true;
    }

}

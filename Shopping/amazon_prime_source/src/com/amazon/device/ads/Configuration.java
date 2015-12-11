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
//            MobileAdsLoggerFactory, PermissionChecker, DebugProperties, Settings, 
//            MobileAdsInfoStore, SystemTime, Metrics, ThreadUtils, 
//            WebRequestUserId, PreferredMarketplaceRetriever, RegistrationInfo, MobileAdsLogger, 
//            StringUtils, WebRequest, DeviceInfo, Version, 
//            ResponseReader, NumberUtils, MetricsCollector

class Configuration
{
    public static class ConfigOption
    {

        public static final ConfigOption AAX_HOSTNAME;
        public static final ConfigOption AD_PREF_URL;
        public static final ConfigOption AD_RESOURCE_PATH;
        public static final ConfigOption IDENTIFY_USER_INTERVAL;
        public static final ConfigOption MADS_HOSTNAME;
        public static final ConfigOption SEND_GEO;
        public static final ConfigOption SIS_DOMAIN;
        public static final ConfigOption SIS_URL;
        public static final ConfigOption TRUNCATE_LAT_LON;
        public static final ConfigOption WHITELISTED_CUSTOMER;
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
            AD_RESOURCE_PATH = new ConfigOption("config-adResourcePath", java/lang/String, "adResourcePath", "debug.adResourcePath");
            SIS_URL = new ConfigOption("config-sisURL", java/lang/String, "sisURL", "debug.sisURL");
            AD_PREF_URL = new ConfigOption("config-adPrefURL", java/lang/String, "adPrefURL", "debug.adPrefURL");
            MADS_HOSTNAME = new ConfigOption("config-madsHostname", java/lang/String, "madsHostname", "debug.madsHostname", true);
            SIS_DOMAIN = new ConfigOption("config-sisDomain", java/lang/String, "sisDomain", "debug.sisDomain");
            SEND_GEO = new ConfigOption("config-sendGeo", java/lang/Boolean, "sendGeo", "debug.sendGeo");
            TRUNCATE_LAT_LON = new ConfigOption("config-truncateLatLon", java/lang/Boolean, "truncateLatLon", "debug.truncateLatLon");
            WHITELISTED_CUSTOMER = new ConfigOption("config-whitelistedCustomer", java/lang/Boolean, "whitelistedCustomer", "debug.whiteListedCustomer");
            IDENTIFY_USER_INTERVAL = new ConfigOption("config-identifyUserInterval", java/lang/Long, "identifyUserInterval", "debug.identifyUserInterval");
            configOptions = (new ConfigOption[] {
                AAX_HOSTNAME, AD_RESOURCE_PATH, SIS_URL, AD_PREF_URL, MADS_HOSTNAME, SIS_DOMAIN, SEND_GEO, TRUNCATE_LAT_LON, WHITELISTED_CUSTOMER, IDENTIFY_USER_INTERVAL
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


    private static final String AAX_MSDK_CONFIG_ENDPOINT = "/msdk/getConfig";
    private static final String AAX_PROD_US_HOSTNAME = "mads.amazon-adsystem.com";
    protected static final String CONFIG_APP_DEFINED_MARKETPLACE = "config-appDefinedMarketplace";
    protected static final String CONFIG_LASTFETCHTIME = "config-lastFetchTime";
    protected static final String CONFIG_TTL = "config-ttl";
    protected static final String CONFIG_VERSION_NAME = "configVersion";
    protected static final int CURRENT_CONFIG_VERSION = 3;
    private static final String LOGTAG = com/amazon/device/ads/Configuration.getSimpleName();
    protected static final int MAX_CONFIG_TTL = 0xa4cb800;
    protected static final int MAX_NO_RETRY_TTL = 0x493e0;
    private static Configuration instance = new Configuration();
    private String appDefinedMarketplace;
    private final DebugProperties debugProperties;
    private final MobileAdsInfoStore infoStore;
    private boolean isAppDefinedMarketplaceSet;
    private final AtomicBoolean isFetching;
    private boolean isFirstParty;
    private Boolean lastTestModeValue;
    private final List listeners;
    private final MobileAdsLogger logger;
    private final Metrics metrics;
    private final PermissionChecker permissionChecker;
    private PreferredMarketplaceRetriever pfmRetriever;
    private final Settings settings;
    private final SystemTime systemTime;
    private final ThreadUtils.ThreadRunner threadRunner;
    private final WebRequest.WebRequestFactory webRequestFactory;
    private final WebRequestUserId webRequestUserId;

    protected Configuration()
    {
        this(new MobileAdsLoggerFactory(), new PermissionChecker(), new WebRequest.WebRequestFactory(), DebugProperties.getInstance(), Settings.getInstance(), MobileAdsInfoStore.getInstance(), new SystemTime(), Metrics.getInstance(), ThreadUtils.getThreadRunner(), new WebRequestUserId());
    }

    Configuration(MobileAdsLoggerFactory mobileadsloggerfactory, PermissionChecker permissionchecker, WebRequest.WebRequestFactory webrequestfactory, DebugProperties debugproperties, Settings settings1, MobileAdsInfoStore mobileadsinfostore, SystemTime systemtime, 
            Metrics metrics1, ThreadUtils.ThreadRunner threadrunner, WebRequestUserId webrequestuserid)
    {
        appDefinedMarketplace = null;
        isAppDefinedMarketplaceSet = false;
        listeners = new ArrayList(5);
        isFetching = new AtomicBoolean(false);
        lastTestModeValue = null;
        isFirstParty = false;
        pfmRetriever = new PreferredMarketplaceRetriever.NullPreferredMarketplaceRetriever();
        logger = mobileadsloggerfactory.createMobileAdsLogger(LOGTAG);
        permissionChecker = permissionchecker;
        webRequestFactory = webrequestfactory;
        debugProperties = debugproperties;
        settings = settings1;
        infoStore = mobileadsinfostore;
        systemTime = systemtime;
        metrics = metrics1;
        threadRunner = threadrunner;
        webRequestUserId = webrequestuserid;
    }

    public static final Configuration getInstance()
    {
        return instance;
    }

    private String getPreferredMarketplace()
    {
        return pfmRetriever.retrievePreferredMarketplace(MobileAdsInfoStore.getInstance().getApplicationContext());
    }

    private boolean hasAppDefinedMarketplaceChanged()
    {
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
                infoStore.getRegistrationInfo().requestNewSISDeviceIdentifier();
                logger.d("New application-defined marketplace set. A new configuration will be retrieved.");
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
                        infoStore.getRegistrationInfo().requestNewSISDeviceIdentifier();
                        logger.d("Application-defined marketplace removed. A new configuration will be retrieved.");
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
            if (!configoption.getAllowEmpty() && StringUtils.isNullOrWhiteSpace(jsonobject))
            {
                throw new IllegalArgumentException("The configuration value must not be empty or contain only white spaces.");
            } else
            {
                settings.putStringWithNoFlush(configoption.getSettingsName(), jsonobject);
                return;
            }
        }
        if (configoption.getDataType().equals(java/lang/Boolean))
        {
            boolean flag = jsonobject.getBoolean(configoption.getResponseKey());
            settings.putBooleanWithNoFlush(configoption.getSettingsName(), flag);
            return;
        }
        if (configoption.getDataType().equals(java/lang/Long))
        {
            long l = jsonobject.getLong(configoption.getResponseKey());
            settings.putLongWithNoFlush(configoption.getSettingsName(), l);
            return;
        } else
        {
            throw new IllegalArgumentException("Undefined configuration option type.");
        }
    }

    protected void beginFetch()
    {
        threadRunner.execute(new Runnable() {

            final Configuration this$0;

            public void run()
            {
                fetchConfigurationOnBackgroundThread();
            }

            
            {
                this$0 = Configuration.this;
                super();
            }
        }, ThreadUtils.ExecutionStyle.SCHEDULE, ThreadUtils.ExecutionThread.BACKGROUND_THREAD);
    }

    protected WebRequest createWebRequest()
    {
        WebRequest webrequest = webRequestFactory.createJSONGetWebRequest();
        webrequest.setExternalLogTag(LOGTAG);
        webrequest.enableLog(true);
        webrequest.setHost(debugProperties.getDebugPropertyAsString("debug.aaxConfigHostname", "mads.amazon-adsystem.com"));
        webrequest.setPath("/msdk/getConfig");
        webrequest.setMetricsCollector(metrics.getMetricsCollector());
        webrequest.setServiceCallLatencyMetric(Metrics.MetricType.AAX_CONFIG_DOWNLOAD_LATENCY);
        webrequest.setUseSecure(debugProperties.getDebugPropertyAsBoolean("debug.aaxConfigUseSecure", Boolean.valueOf(true)).booleanValue());
        Object obj = infoStore.getRegistrationInfo();
        DeviceInfo deviceinfo = infoStore.getDeviceInfo();
        webrequest.putUnencodedQueryParameter("appId", ((RegistrationInfo) (obj)).getAppKey());
        webrequest.putUnencodedQueryParameter("dinfo", deviceinfo.getDInfoProperty().toString());
        webrequest.putUnencodedQueryParameter("sdkVer", Version.getSDKVersion());
        webrequest.putUnencodedQueryParameter("fp", Boolean.toString(isFirstParty));
        webrequest.putUnencodedQueryParameter("mkt", settings.getString("config-appDefinedMarketplace", null));
        webrequest.putUnencodedQueryParameter("pfm", getPreferredMarketplace());
        boolean flag = settings.getBoolean("testingEnabled", false);
        setLastTestModeValue(flag);
        if (flag)
        {
            webrequest.putUnencodedQueryParameter("testMode", "true");
        }
        webrequest.setAdditionalQueryParamsString(debugProperties.getDebugPropertyAsString("debug.aaxConfigParams", null));
        obj = webrequest;
        if (!webRequestUserId.populateWebRequestUserId(webrequest))
        {
            obj = null;
        }
        return ((WebRequest) (obj));
    }

    protected void fetchConfigurationOnBackgroundThread()
    {
        Object obj;
        int i;
        logger.d("In configuration fetcher background thread.");
        if (!permissionChecker.hasInternetPermission(infoStore.getApplicationContext()))
        {
            logger.e("Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
            onFetchFailure();
            return;
        }
        obj = createWebRequest();
        if (obj == null)
        {
            onFetchFailure();
            return;
        }
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
        obj = ((WebRequest.WebResponse) (obj)).getResponseReader().readAsJSON();
        try
        {
            aconfigoption = getConfigOptions();
            j = aconfigoption.length;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logger.e("Unable to parse JSON response: %s", new Object[] {
                ((JSONException) (obj)).getMessage()
            });
            onFetchFailure();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logger.e("Unexpected error during parsing: %s", new Object[] {
                ((Exception) (obj)).getMessage()
            });
            onFetchFailure();
            return;
        }
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        configoption = aconfigoption[i];
        if (!((JSONObject) (obj)).isNull(configoption.getResponseKey()))
        {
            break MISSING_BLOCK_LABEL_195;
        }
        if (!configoption.getAllowEmpty())
        {
            throw new Exception((new StringBuilder()).append("The configuration value for ").append(configoption.getResponseKey()).append(" must be present and not null.").toString());
        }
        settings.removeWithNoFlush(configoption.getSettingsName());
        break MISSING_BLOCK_LABEL_342;
        writeSettingFromConfigOption(configoption, ((JSONObject) (obj)));
        break MISSING_BLOCK_LABEL_342;
        long l;
        if (((JSONObject) (obj)).isNull("ttl"))
        {
            throw new Exception("The configuration value must be present and not null.");
        }
        l = NumberUtils.convertToMillisecondsFromSeconds(((JSONObject) (obj)).getInt("ttl"));
        long l1 = l;
        if (l > 0xa4cb800L)
        {
            l1 = 0xa4cb800L;
        }
        settings.putLongWithNoFlush("config-ttl", l1);
        settings.putLongWithNoFlush("config-lastFetchTime", systemTime.currentTimeMillis());
        settings.putIntWithNoFlush("configVersion", 3);
        settings.flush();
        logger.d("Configuration fetched and saved.");
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
        if (debugProperties.containsDebugProperty(configoption.getDebugProperty()))
        {
            return debugProperties.getDebugPropertyAsBoolean(configoption.getDebugProperty(), Boolean.valueOf(flag)).booleanValue();
        } else
        {
            return settings.getBoolean(configoption.getSettingsName(), flag);
        }
    }

    protected ConfigOption[] getConfigOptions()
    {
        return ConfigOption.configOptions;
    }

    public long getLong(ConfigOption configoption)
    {
        return getLongWithDefault(configoption, 0L);
    }

    public long getLongWithDefault(ConfigOption configoption, long l)
    {
        if (debugProperties.containsDebugProperty(configoption.getDebugProperty()))
        {
            return debugProperties.getDebugPropertyAsLong(configoption.getDebugProperty(), Long.valueOf(l)).longValue();
        } else
        {
            return settings.getLong(configoption.getSettingsName(), l);
        }
    }

    PreferredMarketplaceRetriever getPreferredMarketplaceRetriever()
    {
        return pfmRetriever;
    }

    public String getString(ConfigOption configoption)
    {
        String s1 = debugProperties.getDebugPropertyAsString(configoption.getDebugProperty(), null);
        String s = s1;
        if (s1 == null)
        {
            s = settings.getString(configoption.getSettingsName(), null);
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

    boolean isFirstParty()
    {
        return isFirstParty;
    }

    protected void onFetchFailure()
    {
        this;
        JVM INSTR monitorenter ;
        ConfigurationListener aconfigurationlistener[];
        int j;
        metrics.getMetricsCollector().incrementMetric(Metrics.MetricType.AAX_CONFIG_DOWNLOAD_FAILED);
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
            break MISSING_BLOCK_LABEL_72;
        }
        listeners.add(configurationlistener);
        if (!flag) goto _L4; else goto _L3
_L3:
        logger.d("Starting configuration fetching...");
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
        if (hasAppDefinedMarketplaceChanged())
        {
            return true;
        }
        if (settings.getInt("configVersion", 0) != 3)
        {
            return true;
        }
        long l = settings.getLong("config-lastFetchTime", 0L);
        if (l == 0L)
        {
            logger.d("No configuration found. A new configuration will be retrieved.");
            return true;
        }
        if (systemTime.currentTimeMillis() - l > settings.getLong("config-ttl", 0xa4cb800L))
        {
            logger.d("The configuration has expired. A new configuration will be retrieved.");
            return true;
        }
        if (settings.getWrittenLong("amzn-ad-iu-last-checkin", 0L) - l > 0L)
        {
            logger.d("A new user has been identified. A new configuration will be retrieved.");
            return true;
        }
        if (lastTestModeValue != null && lastTestModeValue.booleanValue() != settings.getBoolean("testingEnabled", false))
        {
            logger.d("The testing mode has changed. A new configuration will be retrieved.");
            return true;
        }
        return debugProperties.getDebugPropertyAsBoolean("debug.shouldFetchConfig", Boolean.valueOf(false)).booleanValue();
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            NewInjector, PostableWorker, CountersLogger, ManifestHelper, 
//            SingularLog, KeyNotFoundException, KeyValueStore, AdvertisingIdHelper, 
//            SessionManager, FacebookAttributionIdGetter

class Collector
{

    public static final String COLLECTOR_NAMESPACE = "collector";
    public static final int EXTERNAL_JOB_MAX_TIMEOUT_MILLIS = 10000;
    private NewInjector I;
    private AdvertisingIdHelper adIdHelper;
    private String advertisingId;
    private String androidId;
    private String androidVersion;
    private String apiKey;
    private String appId;
    private int appVersionCode;
    private String appVersionName;
    private String brand;
    private String carrierName;
    private Context context;
    private CountersLogger countersLogger;
    private String currency;
    private final JSONObject debug_vars = new JSONObject();
    private PostableWorker externalJobsWorker;
    private final FacebookAttributionIdGetter facebookAttributionGetter;
    private String facebookAttributionId;
    private Long firstInstallTime;
    private Long firstUploadDelay;
    private boolean isFirstOpen;
    private String language;
    private Long lastUpdateTime;
    private String localeCountry;
    private String locationCountry;
    private final SingularLog log;
    private String macAddress;
    private final ManifestHelper manifestHelper;
    private String manufacturer;
    private String model;
    private String networkCountry;
    private Long normalUploadDelay;
    private String packageName;
    private KeyValueStore preferences;
    private String referralId;
    private final Object referralIdLock = new Object();
    private boolean sandbox;
    private int sdkVersion;
    private final SessionManager sessionManager;
    private String simCountry;
    private String singularId;
    private JSONObject temporalIds;

    public Collector(SingularLog singularlog, Context context1, AdvertisingIdHelper advertisingidhelper, SessionManager sessionmanager, CountersLogger counterslogger, ManifestHelper manifesthelper, FacebookAttributionIdGetter facebookattributionidgetter, 
            NewInjector newinjector, boolean flag)
    {
        log = singularlog;
        context = context1;
        adIdHelper = advertisingidhelper;
        sessionManager = sessionmanager;
        externalJobsWorker = newinjector.generatePostableWorker("external_worker");
        isFirstOpen = false;
        externalJobsWorker.start();
        countersLogger = counterslogger;
        manifestHelper = manifesthelper;
        facebookAttributionGetter = facebookattributionidgetter;
        sandbox = flag;
        I = newinjector;
    }

    private void addCountersField(JSONObject jsonobject)
        throws JSONException
    {
        jsonobject.put("counters", countersLogger.getAllCounters());
    }

    private void addDebugVars(JSONObject jsonobject)
        throws JSONException
    {
        jsonobject.put("debug_vars", debug_vars);
    }

    private void getAdvertisingIdBackupMethodAndAndroidIdAndMacOnFailure()
    {
        runExternalJob("getAdvertisingIdBackupMethodAndAndroidIdAndMacOnFailure", new Runnable() {

            final Collector this$0;

            public void run()
            {
                advertisingId = facebookAttributionGetter.getAdvertisingId();
                if (advertisingId != null)
                {
                    log.trackInternalDebugEvent("singular_sdk", "getAdvertisingIdBackupMethod: ok");
                }
            }

            
            {
                this$0 = Collector.this;
                super();
            }
        });
        if (advertisingId == null)
        {
            getAndroidId();
            getMacAddress();
        }
    }

    private void getAndroidId()
    {
        androidId = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private String getAndroidVersion()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    private String getApiKey()
    {
        return manifestHelper.getManifestAttribute("net.singular.api_key", "apiKey", "getApiKey", true);
    }

    private String getAppId()
    {
        return manifestHelper.getManifestAttribute("net.singular.app_id", "appId", "getAppId", true);
    }

    private int getAppVersionCode()
    {
        int i;
        try
        {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return -1;
        }
        catch (RuntimeException runtimeexception)
        {
            log.trackError("singular_sdk", "getAppVersionCode failed", runtimeexception);
            return -1;
        }
        return i;
    }

    private String getAppVersionName()
    {
        String s;
        try
        {
            s = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return null;
        }
        catch (RuntimeException runtimeexception)
        {
            log.trackError("singular_sdk", "getAppVersionName failed", runtimeexception);
            return null;
        }
        return s;
    }

    private String getBrand()
    {
        return Build.BRAND;
    }

    private String getDefaultCurrency()
    {
        String s1 = manifestHelper.getManifestAttribute("net.singular.default_currency", "currency", "getDefaultCurrency", false);
        String s = s1;
        if (s1 == null)
        {
            s = "USD";
        }
        return s;
    }

    private void getFacebookAttributionId()
    {
        runExternalJob("getFacebookAttributionId", new Runnable() {

            final Collector this$0;

            public void run()
            {
                facebookAttributionId = facebookAttributionGetter.getAttributionId();
            }

            
            {
                this$0 = Collector.this;
                super();
            }
        });
    }

    private void getInstallDates()
    {
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        PackageInfo packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        firstInstallTime = Long.valueOf(packageinfo.firstInstallTime);
        lastUpdateTime = Long.valueOf(packageinfo.lastUpdateTime);
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
    }

    private String getLanguage()
    {
        String s;
        try
        {
            s = Locale.getDefault().getDisplayLanguage(Locale.US).toLowerCase(Locale.US);
        }
        catch (RuntimeException runtimeexception)
        {
            log.trackError("singular_sdk", "getLanguage failed", runtimeexception);
            return null;
        }
        return s;
    }

    private Location getLastLocation()
    {
        LocationManager locationmanager = (LocationManager)context.getSystemService("location");
        List list = locationmanager.getProviders(true);
        long l = -1L;
        Location location = null;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Location location1 = locationmanager.getLastKnownLocation((String)iterator.next());
            if (location1 != null)
            {
                long l1 = location1.getTime();
                if (l1 > l)
                {
                    location = location1;
                    l = l1;
                }
            }
        } while (true);
        return location;
    }

    private String getLocaleCountry()
    {
        String s = Locale.getDefault().getCountry();
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        try
        {
            s = s.toLowerCase(Locale.US);
        }
        catch (RuntimeException runtimeexception)
        {
            log.trackError("singular_sdk", "getLocaleCountry failed", runtimeexception);
            return null;
        }
        return s;
    }

    private String getLocationCountry()
    {
        Object obj;
        Geocoder geocoder;
        try
        {
            obj = getLastLocation();
        }
        catch (RuntimeException runtimeexception)
        {
            log.trackError("singular_sdk", "getLocationCountry failed", runtimeexception);
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        geocoder = new Geocoder(context);
        obj = geocoder.getFromLocation(((Location) (obj)).getLatitude(), ((Location) (obj)).getLongitude(), 1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (((List) (obj)).size() != 0)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        log.v("singular_sdk", "Got no addresses for given coordinates");
        return null;
        obj;
        log.trackError("singular_sdk", "Could not geocode location");
        return null;
        obj = ((Address)((List) (obj)).get(0)).getCountryCode().toLowerCase(Locale.US);
        return ((String) (obj));
    }

    private void getMacAddress()
    {
        try
        {
            macAddress = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            log.e("singular_sdk", "getMacAddress runtime", runtimeexception);
        }
    }

    private String getManufacturer()
    {
        return Build.MANUFACTURER;
    }

    private String getModel()
    {
        return Build.MODEL;
    }

    private String getNetworkCountry()
    {
        String s = ((TelephonyManager)context.getSystemService("phone")).getNetworkCountryIso();
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        try
        {
            s = s.toLowerCase(Locale.US);
        }
        catch (RuntimeException runtimeexception)
        {
            log.trackError("singular_sdk", "getNetworkCountry failed", runtimeexception);
            return null;
        }
        return s;
    }

    private String getPackageName()
    {
        String s;
        try
        {
            s = context.getPackageName();
        }
        catch (RuntimeException runtimeexception)
        {
            log.trackError("singular_sdk", "getPackageName failed", runtimeexception);
            return null;
        }
        return s;
    }

    private void getReferralId()
    {
        Object obj = referralIdLock;
        obj;
        JVM INSTR monitorenter ;
        String s = referralId;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        initKeyValueStore();
        Object obj1;
        try
        {
            String s1 = preferences.getString("referral_id");
            if (!TextUtils.isEmpty(s1))
            {
                referralId = s1;
            }
        }
        catch (KeyNotFoundException keynotfoundexception) { }
        obj;
        JVM INSTR monitorexit ;
        return;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        log.trackError("singular_sdk", "getReferralId failed", ((Throwable) (obj1)));
        break MISSING_BLOCK_LABEL_46;
    }

    private void getSandboxValue()
    {
        String s = manifestHelper.getManifestAttribute("net.singular.sandbox", "sandbox", "getSandboxValue", false);
        if (s != null)
        {
            sandbox = s.equalsIgnoreCase("true");
        }
    }

    private int getSdkVersion()
    {
        return android.os.Build.VERSION.SDK_INT;
    }

    private String getSimCountry()
    {
        String s = ((TelephonyManager)context.getSystemService("phone")).getSimCountryIso();
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        try
        {
            s = s.toLowerCase(Locale.US);
        }
        catch (RuntimeException runtimeexception)
        {
            log.trackError("singular_sdk", "getSimCountry failed", runtimeexception);
            return null;
        }
        return s;
    }

    private void initKeyValueStore()
    {
        if (preferences == null)
        {
            preferences = I.generateKeyValueStore("collector");
        }
    }

    private void initSendDelayOptions()
    {
        firstUploadDelay = manifestHelper.tryToGetManifestAttributeLong("net.singular.first_upload_delay_millis");
        normalUploadDelay = manifestHelper.tryToGetManifestAttributeLong("net.singular.normal_upload_delay_millis");
    }

    private void initializeBuildIds()
    {
        sdkVersion = -1;
        brand = null;
        androidVersion = null;
        manufacturer = null;
        model = null;
        try
        {
            sdkVersion = getSdkVersion();
            brand = getBrand();
            androidVersion = getAndroidVersion();
            manufacturer = getManufacturer();
            model = getModel();
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            log.e("singular_sdk", "initializeBuildIds runtime", runtimeexception);
        }
    }

    private JSONObject loadTemporalIds()
    {
        initKeyValueStore();
        Object obj = JSONObjectInstrumentation.init(preferences.getString("temporal_ids"));
        return ((JSONObject) (obj));
        Object obj1;
        obj1;
        log.trackError("singular_sdk", "loadTemporalIds: got invalid json!");
_L5:
        JSONObject jsonobject;
        KeyValueStore keyvaluestore;
        jsonobject = new JSONObject();
        keyvaluestore = preferences;
        if (jsonobject instanceof JSONObject) goto _L2; else goto _L1
_L1:
        obj1 = jsonobject.toString();
_L3:
        keyvaluestore.put("temporal_ids", ((String) (obj1)));
        return jsonobject;
_L2:
        try
        {
            obj1 = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            log.trackError("singular_sdk", "loadTemporalIds failed", ((Throwable) (obj1)));
            return new JSONObject();
        }
          goto _L3
        obj1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void runExternalJob(final String name, final Runnable setRunnable)
    {
        final Semaphore waitSem = new Semaphore(0);
        externalJobsWorker.postNow(new Runnable() {

            final Collector this$0;
            final String val$name;
            final Runnable val$setRunnable;
            final Semaphore val$waitSem;

            public void run()
            {
                setRunnable.run();
                Object obj;
                try
                {
                    waitSem.release();
                    return;
                }
                catch (RuntimeException runtimeexception)
                {
                    return;
                }
                obj;
                log.trackError("singular_sdk", String.format("runExternalJob(%s) failed", new Object[] {
                    name
                }), ((Throwable) (obj)));
                try
                {
                    waitSem.release();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    return;
                }
                obj;
                try
                {
                    waitSem.release();
                }
                catch (RuntimeException runtimeexception1) { }
                throw obj;
            }

            
            {
                this$0 = Collector.this;
                setRunnable = runnable;
                name = s;
                waitSem = semaphore;
                super();
            }
        });
        try
        {
            if (!waitSem.tryAcquire(10000L, TimeUnit.MILLISECONDS))
            {
                log.trackError("singular_sdk", String.format("runExternalJob(%s) timeout", new Object[] {
                    name
                }));
                externalJobsWorker.interruptThread();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final String name)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final String name)
        {
            return;
        }
    }

    private void saveTemporalIds(PostableWorker postableworker)
    {
        postableworker.postNow(new Runnable() {

            final Collector this$0;

            public void run()
            {
                Object obj;
                KeyValueStore keyvaluestore;
                initKeyValueStore();
                keyvaluestore = preferences;
                obj = temporalIds;
                if (obj instanceof JSONObject)
                {
                    break MISSING_BLOCK_LABEL_60;
                }
                obj = ((JSONObject) (obj)).toString();
_L2:
                if (!keyvaluestore.put("temporal_ids", ((String) (obj))))
                {
                    log.trackError("singular_sdk", "saveTemporalIdsRunnable: couldn't save the temporal id");
                    return;
                }
                break MISSING_BLOCK_LABEL_71;
                obj = JSONObjectInstrumentation.toString((JSONObject)obj);
                if (true) goto _L2; else goto _L1
_L1:
                try
                {
                    log.v("singular_sdk", "saveTemporalIdsRunnable: Successful!");
                    return;
                }
                catch (RuntimeException runtimeexception)
                {
                    log.trackError("singular_sdk", "saveTemporalIdsRunnable: RuntimeException - couldn't save the temporal id");
                }
                return;
            }

            
            {
                this$0 = Collector.this;
                super();
            }
        });
    }

    private void setDebugVar(String s, boolean flag)
    {
        try
        {
            debug_vars.put(s, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void clearTemporalIds(PostableWorker postableworker)
    {
        temporalIds = new JSONObject();
        saveTemporalIds(postableworker);
    }

    public String getAdvertisingId()
    {
        advertisingId = null;
        adIdHelper.initializeClass();
        if (adIdHelper.isLimitAdTrackingEnabled()) goto _L2; else goto _L1
_L1:
        setDebugVar("LimitAdTrackingEnabled", false);
        advertisingId = adIdHelper.getId();
_L3:
        adIdHelper.cleanupClass();
_L4:
        return advertisingId;
_L2:
        setDebugVar("LimitAdTrackingEnabled", true);
          goto _L3
        Object obj;
        obj;
        setDebugVar("NoPlayServices", true);
        log.d("singular_sdk", "Google Play Services SDK not found!");
        getAdvertisingIdBackupMethodAndAndroidIdAndMacOnFailure();
          goto _L4
        obj;
        setDebugVar("GAIDInvocationError", true);
        log.d("singular_sdk", "Encountered an error connecting to Google Play Services", ((Throwable) (obj)));
        getAdvertisingIdBackupMethodAndAndroidIdAndMacOnFailure();
          goto _L4
    }

    public String getCarrierName()
    {
        String s;
        try
        {
            s = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        }
        catch (RuntimeException runtimeexception)
        {
            log.trackError("singular_sdk", "getCarrierName failed", runtimeexception);
            return null;
        }
        return s;
    }

    public String getCurrency()
    {
        return currency;
    }

    public long getFirstUploadDelay()
    {
        if (firstUploadDelay == null)
        {
            return 3000L;
        } else
        {
            return firstUploadDelay.longValue();
        }
    }

    public long getNormalUploadDelay()
    {
        if (normalUploadDelay == null)
        {
            return 30000L;
        } else
        {
            return normalUploadDelay.longValue();
        }
    }

    public JSONObject getPersistentIdCountersAndDebugVars()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("singular_sdk_version", 7);
            jsonobject.put("app_id", appId);
            jsonobject.put("sandbox", sandbox);
            jsonobject.put("api_key", apiKey);
            jsonobject.put("package_name", packageName);
            jsonobject.put("sdk_version", sdkVersion);
            jsonobject.put("android_version", androidVersion);
            jsonobject.put("brand", brand);
            jsonobject.put("manufacturer", manufacturer);
            jsonobject.put("model", model);
            jsonobject.put("language", language);
            jsonobject.put("carrier_name", carrierName);
            jsonobject.put("app_version_code", appVersionCode);
            jsonobject.put("app_version_name", appVersionName);
            jsonobject.put("singular_id", singularId);
            jsonobject.put("referral_id", referralId);
            jsonobject.put("locale_country", localeCountry);
            jsonobject.put("sim_country", simCountry);
            jsonobject.put("network_country", networkCountry);
            jsonobject.put("location_country", locationCountry);
            jsonobject.put("android_id", androidId);
            jsonobject.put("mac_address", macAddress);
            jsonobject.put("google_advertising_id", advertisingId);
            jsonobject.put("facebook_attribution_id", facebookAttributionId);
            jsonobject.put("first_install_time", firstInstallTime);
            jsonobject.put("last_install_time", lastUpdateTime);
            addCountersField(jsonobject);
            addDebugVars(jsonobject);
        }
        catch (JSONException jsonexception)
        {
            log.e("singular_sdk", "JSONException in getPersistentIds. Should never happen");
            return null;
        }
        return jsonobject;
    }

    public String getSingularId()
    {
        initKeyValueStore();
        String s;
        boolean flag;
        try
        {
            s = preferences.getString("singular_id");
            flag = TextUtils.isEmpty(s);
        }
        catch (KeyNotFoundException keynotfoundexception)
        {
            String s1;
            boolean flag1;
            try
            {
                isFirstOpen = true;
                s1 = UUID.randomUUID().toString();
                flag1 = preferences.put("singular_id", s1);
            }
            catch (RuntimeException runtimeexception)
            {
                log.trackError("singular_sdk", "getSingularId failed", runtimeexception);
                return null;
            }
            if (!flag1)
            {
                return null;
            } else
            {
                return s1;
            }
        }
label0:
        {
            if (!flag)
            {
                return s;
            }
            break label0;
        }
    }

    public JSONObject getTemporalIds()
    {
        JSONObject jsonobject;
        if (temporalIds != null)
        {
            jsonobject = temporalIds;
        } else
        {
            jsonobject = new JSONObject();
        }
        if (sessionManager != null)
        {
            try
            {
                jsonobject.put("session_id", sessionManager.getSessionId());
            }
            catch (JSONException jsonexception)
            {
                return jsonobject;
            }
        }
        return jsonobject;
    }

    public void initializeIds()
    {
        packageName = getPackageName();
        initializeBuildIds();
        language = getLanguage();
        appVersionCode = getAppVersionCode();
        appVersionName = getAppVersionName();
        carrierName = getCarrierName();
        singularId = getSingularId();
        getInstallDates();
        getReferralId();
        advertisingId = getAdvertisingId();
        simCountry = getSimCountry();
        networkCountry = getNetworkCountry();
        locationCountry = getLocationCountry();
        localeCountry = getLocaleCountry();
        getFacebookAttributionId();
        temporalIds = loadTemporalIds();
    }

    public boolean initializeMandatoryManifestIds()
    {
        appId = getAppId();
        apiKey = getApiKey();
        currency = getDefaultCurrency();
        getSandboxValue();
        initSendDelayOptions();
        return appId != null && apiKey != null;
    }

    public boolean isFirstOpen()
    {
        return isFirstOpen;
    }

    public void setCurrency(String s)
    {
        currency = s;
    }

    public void setReferralId(final String referralId, PostableWorker postableworker)
    {
        synchronized (referralIdLock)
        {
            this.referralId = referralId;
        }
        postableworker.postNow(new Runnable() {

            final Collector this$0;
            final String val$referralId;

            public void run()
            {
                initKeyValueStore();
                if (!preferences.put("referral_id", referralId))
                {
                    log.trackError("singular_sdk", "setReferralIdRunnable: couldn't save the referralId");
                    return;
                }
                try
                {
                    log.v("singular_sdk", "setReferralIdRunnable: Successful!");
                    return;
                }
                catch (RuntimeException runtimeexception)
                {
                    log.trackError("singular_sdk", "setReferralIdRunnable: couldn't save the referralId");
                }
                return;
            }

            
            {
                this$0 = Collector.this;
                referralId = s;
                super();
            }
        });
        return;
        referralId;
        obj;
        JVM INSTR monitorexit ;
        throw referralId;
    }

    public boolean setTemporalId(String s, Object obj, PostableWorker postableworker)
    {
        try
        {
            temporalIds.put(s, obj);
            saveTemporalIds(postableworker);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.trackError("singular_sdk", "Invalid JSON in setTemporalId", s);
            return false;
        }
        return true;
    }

    public void unsetTemporalId(String s, PostableWorker postableworker)
    {
        temporalIds.remove(s);
        saveTemporalIds(postableworker);
    }


/*
    static String access$002(Collector collector, String s)
    {
        collector.facebookAttributionId = s;
        return s;
    }

*/








/*
    static String access$602(Collector collector, String s)
    {
        collector.advertisingId = s;
        return s;
    }

*/
}

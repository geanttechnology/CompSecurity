// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.amazon.android.service.IntentTimeoutService;
import com.amazon.android.service.SchedulePeriodicWork;
import com.amazon.profiling.Profiler;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Security;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            DatastoreFactory, EncryptionFactory, DataStore, StringUtil, 
//            AvailabilityServiceException, Logger, Clock, ConfigurationState, 
//            Configuration, Connectivity, Preferences, Stage, 
//            ConfigurationClientFactory, ConfigurationClient, DataStoreException, DataStoreIterator, 
//            StagingStream, AwsUtil

public class AvailabilityService extends IntentTimeoutService
{

    private static boolean haveWarnedAboutPrng = false;
    private static boolean isInitialized = false;
    private AlarmManager alarmManager;
    private boolean attemptedToSyncEmptyConfigThisInstance;
    private Context context;
    private boolean submissionScheduledForThisInstance;

    public AvailabilityService()
    {
        super("AvailabilityServiceWorker", 19);
        attemptedToSyncEmptyConfigThisInstance = false;
        submissionScheduledForThisInstance = false;
    }

    private DataStore getAndOpenDataStore(String s, Configuration.CollectionConfiguration collectionconfiguration)
    {
        Object obj = collectionconfiguration.getLocalStoragePersistenceFormat();
        if (obj == null)
        {
            s = null;
        } else
        {
            obj = DatastoreFactory.getDataStore(((Configuration.PersistenceFormat) (obj)), collectionconfiguration.getLocalStorageMaxRollover(), collectionconfiguration.getLocalStorageRolloverFilesize(), s);
            s = ((String) (obj));
            if (obj != null)
            {
                s = EncryptionFactory.getEncryptionManager(collectionconfiguration.getLocalStorageEncryptionScheme(), collectionconfiguration.getLocalStorageEncryptionKey());
                ((DataStore) (obj)).open(getContext(), s);
                return ((DataStore) (obj));
            }
        }
        return s;
    }

    private Intent getIntent(String s, Bundle bundle)
    {
        if (StringUtil.isEmpty(s))
        {
            throw new AvailabilityServiceException("'intentAction' cannot be null");
        }
        s = new Intent(s);
        s.setClass(context, com/amazon/sdk/availability/AvailabilityService);
        if (bundle != null)
        {
            s.putExtras(bundle);
        }
        return s;
    }

    protected void addFilesToMeasurement(JSONObject jsonobject, Bundle bundle)
        throws JSONException
    {
        com.amazon.profiling.ProfilerScope profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/AvailabilityService, "addFilesToMeasurement");
        if (bundle.containsKey("mapOfFiles"))
        {
            Iterator iterator = ((Map)bundle.getSerializable("mapOfFiles")).entrySet().iterator();
            while (iterator.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                bundle = getBytesOfFile((String)entry.getKey(), (File)entry.getValue());
                JSONObject jsonobject1;
                if (bundle == null)
                {
                    bundle = "ERROR_READING_FILE";
                } else
                {
                    bundle = Base64.encodeToString(bundle, 11);
                }
                jsonobject1 = jsonobject.getJSONObject("metadata");
                jsonobject1.put((String)entry.getKey(), bundle);
                jsonobject.put("metadata", jsonobject1);
                Logger.v((new StringBuilder()).append((String)entry.getKey()).append(" added to measurement").toString());
            }
        }
        Profiler.scopeEnd(profilerscope);
    }

    protected void adjustMeasurementTimestamp(JSONObject jsonobject)
        throws JSONException, ParseException
    {
        com.amazon.profiling.ProfilerScope profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/AvailabilityService, "adjustMeasurementTimestamp");
        String s = jsonobject.getString("measurementTimestamp");
        if (s != null)
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            long l = simpledateformat.parse(s).getTime();
            jsonobject.put("measurementTimestamp", simpledateformat.format(Long.valueOf(Clock.getAdjustedTime(getContext(), l))));
        }
        Profiler.scopeEnd(profilerscope);
    }

    protected void cancelSubmit()
    {
        SchedulePeriodicWork.cancelWork(getContext(), getIntent("SubmitMeasurements", null));
    }

    protected void createSchedule()
    {
        if (!isInitialized)
        {
            Configuration configuration = loadConfiguration();
            ConfigurationState configurationstate = new ConfigurationState(getContext());
            Long long1 = configurationstate.getConfigurationNextRefresh();
            if (long1 != null)
            {
                scheduleSync(long1, configuration.getStateNextRefresh());
            } else
            {
                scheduleSync(Long.valueOf(0L), null);
            }
            Logger.i((new StringBuilder()).append("created schedule @ ").append(StringUtil.dateToString(Long.valueOf(System.currentTimeMillis()))).toString());
            Logger.v((new StringBuilder()).append("schedule: ").append(configurationstate.toString()).toString());
            isInitialized = true;
        }
    }

    protected void fixBrokenPreferences(String s, long l)
    {
        long l1 = System.currentTimeMillis();
        if (l > l1)
        {
            setLastClientSubmission(s, l1);
        }
    }

    byte[] getBytesOfFile(String s, File file)
    {
        byte abyte0[] = null;
        if (file != null) goto _L2; else goto _L1
_L1:
        s = abyte0;
_L6:
        return s;
_L2:
        Object obj;
        Object obj1;
        Object obj2;
        long l;
        l = file.length();
        if (l > 0x100000L)
        {
            Logger.v((new StringBuilder()).append("File ").append(s).append(" is too big. Not added to measurement").toString());
            return null;
        }
        if (!file.canRead())
        {
            Logger.v((new StringBuilder()).append("Cannot read file ").append(s).toString());
            return null;
        }
        obj2 = null;
        obj1 = null;
        abyte0 = null;
        obj = null;
        FileInputStream fileinputstream = new FileInputStream(file);
        int i;
        i = (int)l;
        file = obj2;
        abyte0 = new byte[i];
        i = 0;
_L4:
        if ((long)i >= l)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        file = abyte0;
        int j = fileinputstream.read(abyte0, i, (int)l - i);
        if (j > 0)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        if (fileinputstream == null)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.w("Could not close fileInputStream", s);
            return abyte0;
        }
        return abyte0;
        i += j;
        if (true) goto _L4; else goto _L3
        file;
        fileinputstream = ((FileInputStream) (obj));
        obj = file;
        file = obj1;
_L9:
        abyte0 = fileinputstream;
        Logger.e((new StringBuilder()).append("Exception thrown when reading file ").append(s).append(" to measurement").toString(), ((Throwable) (obj)));
        s = file;
        if (fileinputstream == null) goto _L6; else goto _L5
_L5:
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.w("Could not close fileInputStream", s);
            return file;
        }
        return file;
        s;
_L8:
        if (abyte0 != null)
        {
            try
            {
                abyte0.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                Logger.w("Could not close fileInputStream", file);
            }
        }
        throw s;
        s;
        abyte0 = fileinputstream;
        if (true) goto _L8; else goto _L7
_L7:
        obj;
          goto _L9
_L3:
        return abyte0;
    }

    protected String getCarrierName()
    {
        String s = null;
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        if (telephonymanager != null)
        {
            s = telephonymanager.getNetworkOperatorName();
        }
        return s;
    }

    protected Connectivity getConnectivity()
    {
        return new Connectivity((ConnectivityManager)getSystemService("connectivity"));
    }

    protected Context getContext()
    {
        return context;
    }

    protected long getLastClientSubmission(String s)
    {
        long l1 = 0L;
        long l = l1;
        if (s != null)
        {
            String s1 = (new Preferences(getContext())).get((new StringBuilder()).append("lastClientSubmission-").append(s).toString());
            l = l1;
            if (s1 != null)
            {
                try
                {
                    l = Long.parseLong(s1);
                }
                catch (NumberFormatException numberformatexception)
                {
                    Logger.e((new StringBuilder()).append("error parsing last submission time for ").append(s).toString(), numberformatexception);
                    l = l1;
                }
            }
        }
        Logger.v((new StringBuilder()).append("last submission for ").append(s).append(" @ ").append(StringUtil.dateToString(Long.valueOf(l))).toString());
        return l;
    }

    protected String getPackageNameForMeasurement(JSONObject jsonobject)
    {
        Object obj = null;
        String s = obj;
        if (jsonobject != null)
        {
            jsonobject = jsonobject.optJSONObject("metadata");
            s = obj;
            if (jsonobject != null)
            {
                s = jsonobject.optString("packageName");
            }
        }
        return s;
    }

    protected PendingIntent getPendingIntent(String s, Bundle bundle)
    {
        s = getIntent(s, bundle);
        return PendingIntent.getService(context, 0, s, 0);
    }

    protected void handleForceSubmitMeasurementsIntent(Intent intent)
    {
        if (!Stage.isProduction())
        {
            Logger.w("force-submit intent received, attempting submission");
            intent = intent.getStringExtra("clientId");
            if (submitMeasurements(intent, 0L))
            {
                setLastClientSubmission(intent, System.currentTimeMillis());
            }
            return;
        } else
        {
            Logger.w("force-submit intent received, but not gamma, so ignoring");
            return;
        }
    }

    public void handlePutMeasurement(Intent intent)
    {
        com.amazon.profiling.ProfilerScope profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/AvailabilityService, "handlePutMeasurement");
        Object obj = intent.getExtras();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (((Bundle) (obj)).containsKey("payload"))
        {
            break MISSING_BLOCK_LABEL_42;
        }
        Logger.w("no payload for measurement");
        Profiler.scopeEnd(profilerscope);
        return;
        intent = ((Bundle) (obj)).getString("payload");
        String s;
        String s1;
        boolean flag;
        intent = new JSONObject(intent);
        s = intent.optString("clientId");
        s1 = intent.optString("measurementName");
        Logger.v(String.format("processing putMeasurement intent (%s)", new Object[] {
            s
        }));
        flag = StringUtil.isEmpty(s);
        if (flag)
        {
            Profiler.scopeEnd(profilerscope);
            return;
        }
        Configuration.CollectionConfiguration collectionconfiguration;
        adjustMeasurementTimestamp(intent);
        if (!Stage.isProduction())
        {
            intent.put("stage", Stage.getDomain().toString());
        }
        addFilesToMeasurement(intent, ((Bundle) (obj)));
        obj = new Preferences(getContext());
        if (!attemptedToSyncEmptyConfigThisInstance && !((Preferences) (obj)).contains("configuration"))
        {
            Logger.v("Configuration has never been retrieved. Attempting to sync once.");
            attemptedToSyncEmptyConfigThisInstance = true;
            handleSyncConfigurationIntent();
        }
        obj = loadConfiguration();
        collectionconfiguration = ((Configuration) (obj)).getCollectionConfiguration(s);
        if (collectionconfiguration == null)
        {
            Profiler.scopeEnd(profilerscope);
            return;
        }
        flag = writeMeasurement(collectionconfiguration, s1, s, intent);
        submitImmediateMeasurements(collectionconfiguration, s, intent);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        if (!submissionScheduledForThisInstance)
        {
            scheduleSubmit(((Configuration) (obj)).getStateSubmissionInterval());
            submissionScheduledForThisInstance = true;
        }
        Profiler.scopeEnd(profilerscope);
        return;
        intent;
        Logger.w("runtime exception caught and suppressed handling PUT_MEASUREMENT", intent);
        throw new AvailabilityServiceException(intent);
        intent;
        Profiler.scopeEnd(profilerscope);
        throw intent;
        intent;
        throw new AvailabilityServiceException(intent);
    }

    protected void handleSetIdentity(Intent intent)
    {
        Object obj = intent.getExtras();
        if (obj != null)
        {
            intent = ((Bundle) (obj)).getString("marketplaceId");
            String s = ((Bundle) (obj)).getString("customerId");
            String s1 = ((Bundle) (obj)).getString("deviceType");
            String s2 = ((Bundle) (obj)).getString("deviceId");
            String s3 = ((Bundle) (obj)).getString("region");
            obj = ((Bundle) (obj)).getString("clientIds");
            Logger.v(String.format("processing setIdentity intent (%s, %s, %s, %s, %s, %s)", new Object[] {
                intent, s, s1, s2, s3, obj
            }));
            Preferences preferences = new Preferences(context);
            if (intent != null)
            {
                preferences.put("marketplaceId", intent);
            }
            if (s != null)
            {
                preferences.put("customerId", s);
            }
            if (s1 != null)
            {
                preferences.put("deviceType", s1);
            }
            if (s2 != null)
            {
                preferences.put("deviceId", s2);
            }
            if (s3 != null)
            {
                preferences.put("region", s3);
            }
            if (obj != null)
            {
                preferences.put("clientIds", ((String) (obj)));
            }
        }
        createSchedule();
    }

    protected void handleSubmitMeasurementsIntent()
    {
        Configuration configuration = loadConfiguration();
        Iterator iterator = configuration.getClientIds().iterator();
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Logger.i((new StringBuilder()).append("analyzing ").append(s).append(" submission policies").toString());
            Object obj = configuration.getCollectionConfiguration(s);
            if (obj == null)
            {
                continue;
            }
            Object obj1 = ((Configuration.CollectionConfiguration) (obj)).getSubmissionPolicies();
            if (obj1 == null)
            {
                continue;
            }
            long l = getLastClientSubmission(s);
            long l1 = System.currentTimeMillis();
            fixBrokenPreferences(s, l);
            boolean flag2 = isAirplaneMode();
            obj = getConnectivity();
            obj1 = ((List) (obj1)).iterator();
            do
            {
                Configuration.Policy policy;
                long l2;
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        continue label0;
                    }
                    policy = (Configuration.Policy)((Iterator) (obj1)).next();
                    Logger.v(String.format("analyzing policy: %s", new Object[] {
                        policy
                    }));
                    l2 = policy.getPeriod();
                } while (policy.isPackageSpecific() || l2 == -1L);
                boolean flag;
                boolean flag1;
                if (l2 < l1 - l)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag2 && isNetworkSupported(((Connectivity) (obj)), policy))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } while (!flag || !flag1);
            Logger.v(String.format("applying policy: %s", new Object[] {
                policy
            }));
            if (submitMeasurements(s, l))
            {
                setLastClientSubmission(s, l1);
            }
        } while (true);
        SchedulePeriodicWork.workComplete(getContext(), getIntent("SubmitMeasurements", null));
    }

    protected void handleSyncConfigurationIntent()
    {
        long l1;
        l1 = System.currentTimeMillis();
        Preferences preferences = new Preferences(getContext());
        Object obj = preferences.get("marketplaceId");
        String s = preferences.get("customerId");
        String s1 = preferences.get("deviceType");
        String s2 = preferences.get("deviceId");
        String s3 = preferences.get("region");
        String as[] = StringUtil.split(preferences.get("clientIds"), ",");
        if (preferences.get("submissionState") != null)
        {
            preferences.remove("submissionState");
        }
        Configuration configuration = null;
        try
        {
            obj = ConfigurationClientFactory.getConfigurationClient().getAvailabilityConfiguration("1.3", ((String) (obj)), s, s1, s2, Build.MANUFACTURER, Build.MODEL, getCarrierName(), android.os.Build.VERSION.RELEASE, s3, as, null);
        }
        catch (Exception exception)
        {
            Logger.e("error retrieving configuration", exception);
            continue; /* Loop/switch isn't completed */
        }
        configuration = ((Configuration) (obj));
_L6:
        if (configuration == null) goto _L2; else goto _L1
_L1:
        Logger.v((new StringBuilder()).append("retrieved configuration: ").append(configuration.toString()).toString());
        preferences.remove("configuration");
        obj = configuration.getJson();
        if (obj != null)
        {
            preferences.put("configuration", ((JSONObject) (obj)).toString());
        }
        Clock.updateAdjustment(getContext(), configuration.getStateServerTime().longValue());
        (new ConfigurationState(getContext())).updateSchedule(getContext(), configuration);
        obj = configuration.getStateNextRefresh();
        if (obj != null)
        {
            scheduleSync(Long.valueOf(((Long) (obj)).longValue() + l1), ((Long) (obj)));
        }
        scheduleSubmit(configuration.getStateSubmissionInterval());
_L4:
        return;
_L2:
        long l;
        l = -1L;
        Long long1 = loadConfiguration().getStateRetryInterval();
        if (long1 != null)
        {
            l = long1.longValue();
        }
        if (l < 0L) goto _L4; else goto _L3
_L3:
        scheduleSync(Long.valueOf(l1 + l), Long.valueOf(0L));
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void handleThrowable(String s, Throwable throwable)
    {
        Logger.e(s, throwable);
        if (throwable instanceof ThreadDeath)
        {
            throw (ThreadDeath)throwable;
        }
        if (throwable instanceof InterruptedException)
        {
            Thread.currentThread().interrupt();
        } else
        if (!Stage.isProduction())
        {
            throw new RuntimeException("Debug, unhandled throwable caught in non-prod mode", throwable);
        }
    }

    protected boolean isAirplaneMode()
    {
        boolean flag;
        if (android.provider.Settings.System.getInt(getContentResolver(), "airplane_mode_on", 0) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Logger.v(String.format("airplane mode: %s", new Object[] {
            Boolean.valueOf(flag)
        }));
        return flag;
    }

    protected boolean isNetworkSupported(Connectivity connectivity, Configuration.Policy policy)
    {
        boolean flag3 = false;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (connectivity.hasWifi() && !policy.isExcluded(Connectivity.Network.WIFI))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (connectivity.hasMobile() && !policy.isExcluded(Connectivity.Network.MOBILE))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (connectivity.hasEthernet() && !policy.isExcluded(Connectivity.Network.ETHERNET))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag || flag1 || flag2)
        {
            flag3 = true;
        }
        return flag3;
    }

    protected Configuration loadConfiguration()
    {
        Object obj1;
        Configuration configuration;
        com.amazon.profiling.ProfilerScope profilerscope;
        Object obj2;
        long l;
        profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/AvailabilityService, "loadConfiguration");
        l = System.currentTimeMillis();
        obj1 = new Preferences(getContext());
        obj2 = (new ConfigurationState(context)).getConfigurationExpiry();
        configuration = new Configuration(null);
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        Object obj = configuration;
        if (((Long) (obj2)).longValue() <= l) goto _L3; else goto _L2
_L2:
        obj2 = ((Preferences) (obj1)).get("configuration");
        obj = configuration;
        if (obj2 == null) goto _L3; else goto _L4
_L4:
        obj1 = null;
        obj = new JSONObject(((String) (obj2)));
        obj1 = obj;
_L6:
        obj = configuration;
        if (obj1 != null)
        {
            obj = new Configuration(((JSONObject) (obj1)));
        }
_L3:
        warnOnceAboutPRNG(((Configuration) (obj)));
        Profiler.scopeEnd(profilerscope);
        return ((Configuration) (obj));
        JSONException jsonexception;
        jsonexception;
        Logger.e("failed to parse stored configuration", jsonexception);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onCreate()
    {
        super.onCreate();
        Logger.v("onCreate()");
        Logger.v((new StringBuilder()).append("Stage is ").append(Stage.getDomain()).toString());
    }

    public void onDestroy()
    {
        super.onDestroy();
        Logger.v("onDestroy()");
    }

    protected void onHandleIntent(Intent intent)
    {
        com.amazon.profiling.ProfilerScope profilerscope;
        profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/AvailabilityService, "onHandleIntent");
        if (intent == null)
        {
            Profiler.scopeEnd(profilerscope);
            return;
        }
        setContextIfNeeded();
        String s;
        s = intent.getAction();
        Logger.v((new StringBuilder()).append("received intent: ").append(intent.toString()).toString());
        Logger.v((new StringBuilder()).append("intentAction = <<").append(s).append(">>").toString());
        if (!"SetIdentity".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        handleSetIdentity(intent);
_L3:
        Profiler.scopeEnd(profilerscope);
        return;
_L2:
        if (!"PutMeasurement".equalsIgnoreCase(s))
        {
            break MISSING_BLOCK_LABEL_139;
        }
        handlePutMeasurement(intent);
          goto _L3
        intent;
        handleThrowable("uncaught error handling intent", intent);
          goto _L3
        intent;
        Profiler.scopeEnd(profilerscope);
        throw intent;
label0:
        {
            if (!"SyncConfiguration".equalsIgnoreCase(s))
            {
                break label0;
            }
            Logger.v(String.format("processing syncConfiguration intent", new Object[0]));
            handleSyncConfigurationIntent();
        }
          goto _L3
label1:
        {
            if (!"SubmitMeasurements".equalsIgnoreCase(s))
            {
                break label1;
            }
            Logger.v("processing submitMeasurements intent");
            handleSubmitMeasurementsIntent();
        }
          goto _L3
        if (!"SubmitMeasurementsUponStart".equalsIgnoreCase(s)) goto _L5; else goto _L4
_L4:
        Logger.v("processing submitMeasurementsUponStart intent");
        handleSubmitMeasurementsIntent();
          goto _L3
_L5:
        if (!"ForceSubmitMeasurements".equalsIgnoreCase(s)) goto _L3; else goto _L6
_L6:
        handleForceSubmitMeasurementsIntent(intent);
          goto _L3
    }

    protected void onTimeout()
    {
        super.onTimeout();
        submissionScheduledForThisInstance = false;
        try
        {
            updateSubmitSchedule();
            return;
        }
        catch (Throwable throwable)
        {
            handleThrowable("Caught throwable trying to update schedule", throwable);
        }
    }

    protected void scheduleSubmit(Long long1)
    {
        if (long1 != null)
        {
            SchedulePeriodicWork.scheduleWork(getContext(), getIntent("SubmitMeasurements", null), long1.longValue());
        }
    }

    protected void scheduleSync(Long long1, Long long2)
    {
        PendingIntent pendingintent = getPendingIntent("SyncConfiguration", null);
        boolean flag;
        if (long1 != null)
        {
            if (long2 != null)
            {
                alarmManager.cancel(pendingintent);
                alarmManager.setInexactRepeating(1, long1.longValue(), long2.longValue(), pendingintent);
            } else
            {
                alarmManager.set(1, long1.longValue(), pendingintent);
            }
        }
        if (long2 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Logger.syncConfigurationScheduled(long1, flag);
    }

    protected void setAlarmManager(AlarmManager alarmmanager)
    {
        alarmManager = alarmmanager;
    }

    protected void setContext(Context context1)
    {
        context = context1;
    }

    protected void setContextIfNeeded()
    {
        if (context == null)
        {
            setContext(getApplicationContext());
        }
        if (context != null)
        {
            setAlarmManager((AlarmManager)context.getSystemService("alarm"));
        }
    }

    protected void setLastClientSubmission(String s, long l)
    {
        (new Preferences(getContext())).put((new StringBuilder()).append("lastClientSubmission-").append(s).toString(), Long.toString(l));
    }

    protected void submitImmediateMeasurements(Configuration.CollectionConfiguration collectionconfiguration, String s, JSONObject jsonobject)
    {
label0:
        {
            com.amazon.profiling.ProfilerScope profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/AvailabilityService, "submitImmediateMeasurements");
            Object obj = collectionconfiguration.getSubmissionPolicies();
            if (obj == null)
            {
                break label0;
            }
            long l = getLastClientSubmission(s);
            long l1 = System.currentTimeMillis();
            fixBrokenPreferences(s, l);
            collectionconfiguration = getPackageNameForMeasurement(jsonobject);
            boolean flag1 = isAirplaneMode();
            Connectivity connectivity = getConnectivity();
            obj = ((List) (obj)).iterator();
            do
            {
                Configuration.Policy policy;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    policy = (Configuration.Policy)((Iterator) (obj)).next();
                } while (policy.getPeriod() != 0L);
                boolean flag2 = policy.isPackageSupported(collectionconfiguration);
                boolean flag;
                if (!flag1 && isNetworkSupported(connectivity, policy))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } while (!flag2 || !flag || !policy.applies(jsonobject));
            Logger.v((new StringBuilder()).append("policy ").append(policy).append(" applies to measurement ").append(jsonobject).toString());
            if (submitMeasurements(s, l))
            {
                setLastClientSubmission(s, l1);
            }
        }
        Profiler.scopeEnd(profilerscope);
    }

    protected boolean submitMeasurements(String s, long l)
    {
        Configuration.CollectionConfiguration collectionconfiguration;
        boolean flag;
        boolean flag3;
        boolean flag4;
        flag3 = false;
        flag4 = false;
        flag = false;
        collectionconfiguration = loadConfiguration().getCollectionConfiguration(s);
        if (collectionconfiguration != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        String s2;
        String s3;
        long l1;
        long l2;
        long l3;
        boolean flag1;
        boolean flag2;
        obj = collectionconfiguration.getAwsAccessId();
        String s1 = collectionconfiguration.getAwsSecretKey();
        obj2 = collectionconfiguration.getAwsSesssionToken();
        if (obj == null || s1 == null)
        {
            return false;
        }
        if (obj2 != null)
        {
            obj4 = new BasicSessionCredentials(((String) (obj)), s1, ((String) (obj2)));
        } else
        {
            obj4 = new BasicAWSCredentials(((String) (obj)), s1);
        }
        s2 = collectionconfiguration.getS3Bucket();
        obj = collectionconfiguration.getS3DateFormatKey();
        if (s2 == null || obj == null)
        {
            return false;
        }
        obj = new SimpleDateFormat(((String) (obj)));
        ((SimpleDateFormat) (obj)).setTimeZone(TimeZone.getTimeZone("GMT"));
        s3 = ((SimpleDateFormat) (obj)).format(Long.valueOf(Clock.getCurrentTime(getContext())));
        l3 = 0L;
        obj3 = null;
        obj = null;
        obj2 = null;
        l1 = l3;
        flag1 = flag3;
        l2 = l3;
        flag2 = flag4;
        Object obj1 = getAndOpenDataStore(s, collectionconfiguration);
        if (obj1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 != null)
        {
            ((DataStore) (obj1)).close();
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj2 = obj1;
        l1 = l3;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l3;
        flag2 = flag4;
        obj = obj1;
        Logger.i((new StringBuilder()).append("looking for ").append(s).append(" measurements to submit...").toString());
        obj2 = obj1;
        l1 = l3;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l3;
        flag2 = flag4;
        obj = obj1;
        Object obj5 = ((DataStore) (obj1)).getMeasurementsAfter(l);
        obj2 = obj1;
        l1 = l3;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l3;
        flag2 = flag4;
        obj = obj1;
        boolean flag5 = ((DataStoreIterator) (obj5)).hasNext();
        if (!flag5) goto _L5; else goto _L4
_L4:
        obj2 = obj1;
        l1 = l3;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l3;
        flag2 = flag4;
        obj = obj1;
        File file = File.createTempFile("submission", "gz", context.getCacheDir());
        obj2 = obj1;
        l1 = l3;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l3;
        flag2 = flag4;
        obj = obj1;
        Logger.v((new StringBuilder()).append("stagedFile is ").append(file).toString());
        obj2 = obj1;
        l1 = l3;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l3;
        flag2 = flag4;
        obj = obj1;
        StagingStream stagingstream = new StagingStream(file, collectionconfiguration.getPublicKeyString(), collectionconfiguration.getPublicKeySerial());
        obj2 = obj1;
        l1 = l3;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l3;
        flag2 = flag4;
        obj = obj1;
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(stagingstream, 0x10000);
        l = l3;
        flag = flag5;
_L17:
        if (!flag) goto _L7; else goto _L6
_L6:
        long l4;
        l3 = l;
        l4 = l;
        obj = (String)((DataStoreIterator) (obj5)).next();
        l3 = l;
        l4 = l;
        bufferedoutputstream.write((new StringBuilder()).append(((String) (obj))).append("\n").toString().getBytes("UTF-8"));
        l++;
_L9:
        l3 = l;
        l4 = l;
        try
        {
            flag = ((DataStoreIterator) (obj5)).hasNext();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            l4 = l3;
        }
        finally
        {
            obj2 = obj1;
            l1 = l4;
            flag1 = flag3;
            obj3 = obj1;
            l2 = l4;
            flag2 = flag4;
            obj = obj1;
        }
        break MISSING_BLOCK_LABEL_657;
        obj;
        l3 = l;
        l4 = l;
        Logger.w("persistence read error, record skipped, continuing", ((Throwable) (obj)));
        if (true) goto _L9; else goto _L8
_L8:
        Logger.w("unexpected persistence read error, all subsequent records discarded", ((Throwable) (obj)));
        obj2 = obj1;
        l1 = l3;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l3;
        flag2 = flag4;
        obj = obj1;
        bufferedoutputstream.close();
        l = l3;
_L12:
        if (l <= 0L) goto _L11; else goto _L10
_L10:
        obj2 = obj1;
        l1 = l;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l;
        flag2 = flag4;
        obj = obj1;
        flag3 = AwsUtil.putObject(((com.amazonaws.auth.AWSCredentials) (obj4)), s2, s3, file, stagingstream.getUserMetadata());
        obj2 = obj1;
        l1 = l;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l;
        flag2 = flag3;
        obj = obj1;
        Logger.measurementsSubmitted(flag3, l, s2, s3);
        flag = flag3;
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_865;
        }
        obj2 = obj1;
        l1 = l;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l;
        flag2 = flag3;
        obj = obj1;
        ((DataStoreIterator) (obj5)).clear();
        obj2 = obj1;
        l1 = l;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l;
        flag2 = flag3;
        obj = obj1;
        Logger.i("completed clearing the data store");
        flag = flag3;
_L14:
        l3 = l;
        flag3 = flag;
        obj2 = obj1;
        l1 = l;
        flag1 = flag;
        obj3 = obj1;
        l2 = l;
        flag2 = flag;
        obj = obj1;
        if (file.delete())
        {
            break MISSING_BLOCK_LABEL_945;
        }
        obj2 = obj1;
        l1 = l;
        flag1 = flag;
        obj3 = obj1;
        l2 = l;
        flag2 = flag;
        obj = obj1;
        Logger.w("could not delete staged measurements file");
        flag3 = flag;
        l3 = l;
_L15:
        l = l3;
        flag = flag3;
        if (obj1 != null)
        {
            ((DataStore) (obj1)).close();
            flag = flag3;
            l = l3;
        }
_L13:
        if (flag)
        {
            obj = collectionconfiguration.getSqsQueueName();
            if (!StringUtil.isBlank(((String) (obj))))
            {
                obj1 = new JSONObject();
                try
                {
                    ((JSONObject) (obj1)).put("clientId", s);
                    ((JSONObject) (obj1)).put("s3Bucket", s2);
                    ((JSONObject) (obj1)).put("s3Key", s3);
                    ((JSONObject) (obj1)).put("numMeasurements", l);
                    AwsUtil.sendMessage(((com.amazonaws.auth.AWSCredentials) (obj4)), ((String) (obj)), ((JSONObject) (obj1)));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Logger.e("error building message payload", s);
                }
            }
        }
        return flag;
_L7:
        obj2 = obj1;
        l1 = l;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l;
        flag2 = flag4;
        obj = obj1;
        bufferedoutputstream.close();
          goto _L12
        obj1;
        obj = obj2;
        Logger.e("runtime error building submission", ((Throwable) (obj1)));
        l = l1;
        flag = flag1;
        if (obj2 != null)
        {
            ((DataStore) (obj2)).close();
            l = l1;
            flag = flag1;
        }
          goto _L13
        bufferedoutputstream.close();
        obj2 = obj1;
        l1 = l4;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l4;
        flag2 = flag4;
        obj = obj1;
        throw obj5;
        obj1;
        obj = obj3;
        Logger.e("error occurred building submission", ((Throwable) (obj1)));
        l = l2;
        flag = flag2;
        if (obj3 != null)
        {
            ((DataStore) (obj3)).close();
            l = l2;
            flag = flag2;
        }
          goto _L13
_L11:
        flag = true;
          goto _L14
_L5:
        obj2 = obj1;
        l1 = l3;
        flag1 = flag3;
        obj3 = obj1;
        l2 = l3;
        flag2 = flag4;
        obj = obj1;
        ((DataStoreIterator) (obj5)).clear();
        flag3 = flag;
          goto _L15
        s;
        if (obj != null)
        {
            ((DataStore) (obj)).close();
        }
        throw s;
        if (true) goto _L17; else goto _L16
_L16:
    }

    protected void updateSubmitSchedule()
    {
        Configuration configuration;
        Object obj;
        boolean flag1;
        configuration = loadConfiguration();
        obj = configuration.getClientIds();
        flag1 = false;
        obj = ((Set) (obj)).iterator();
_L2:
        Object obj1;
        Object obj2;
        boolean flag;
        flag = flag1;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_141;
        }
        obj2 = (String)((Iterator) (obj)).next();
        Logger.i((new StringBuilder()).append("analyzing ").append(((String) (obj2))).append(" submission policies").toString());
        obj1 = configuration.getCollectionConfiguration(((String) (obj2)));
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = getAndOpenDataStore(((String) (obj2)), ((Configuration.CollectionConfiguration) (obj1)));
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = ((DataStore) (obj1)).getMeasurementsAfter(getLastClientSubmission(((String) (obj2))));
        boolean flag2 = ((DataStoreIterator) (obj2)).hasNext();
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        flag = true;
        ((DataStore) (obj1)).close();
        ((DataStoreIterator) (obj2)).closeAfterUse();
        Exception exception;
        if (flag)
        {
            scheduleSubmit(configuration.getStateSubmissionInterval());
            return;
        } else
        {
            cancelSubmit();
            return;
        }
        ((DataStore) (obj1)).close();
        ((DataStoreIterator) (obj2)).closeAfterUse();
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        ((DataStore) (obj1)).close();
        ((DataStoreIterator) (obj2)).closeAfterUse();
        throw exception;
    }

    protected void warnOnceAboutPRNG(Configuration configuration)
    {
        Logger.v("warnOnceAboutPRNG() called");
        if (haveWarnedAboutPrng)
        {
            Logger.v("warnOnceAboutPRNG() has already been called, doing nothing");
            return;
        }
        haveWarnedAboutPrng = true;
        if (android.os.Build.VERSION.SDK_INT > 18)
        {
            Logger.v("warnOnceAboutPRNG() detected unaffected OS version, doing nothing");
            return;
        }
        boolean flag1 = false;
        Iterator iterator = configuration.getClientIds().iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (StringUtil.isBlank(configuration.getCollectionConfiguration(s).getPublicKeyString()))
            {
                continue;
            }
            Logger.v((new StringBuilder()).append("warnOnceAboutPRNG() detected encrypted upload usage for client ID ").append(s).toString());
            flag = true;
            break;
        } while (true);
        if (!flag)
        {
            Logger.v("warnOnceAboutPRNG() detected no clients using encrypted upload, doing nothing");
            return;
        }
        configuration = Security.getProviders("SecureRandom.SHA1PRNG");
        if (configuration != null && configuration.length >= 1 && com/amazon/googlefixes/PRNGFixes$LinuxPRNGSecureRandomProvider.equals(configuration[0].getClass()))
        {
            Logger.v("warnOnceAboutPRNG() detected workaround applied, doing nothing");
            return;
        } else
        {
            Logger.w("A possible problem has been detected");
            Logger.v("SecureRandom workaround appears applicable and appears not to have been applied.");
            Logger.v("SecureRandom info http://android-developers.blogspot.com/2013/08/some-securerandom-thoughts.html");
            return;
        }
    }

    protected boolean writeMeasurement(Configuration.CollectionConfiguration collectionconfiguration, String s, String s1, JSONObject jsonobject)
    {
        com.amazon.profiling.ProfilerScope profilerscope;
        Object obj;
        Object obj1;
        Long long1;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        profilerscope = Profiler.methodScopeStart(com/amazon/sdk/availability/AvailabilityService, "writeMeasurement");
        obj = collectionconfiguration.getLocalStoragePersistenceFormat();
        obj1 = collectionconfiguration.getLocalStorageMaxRollover();
        long1 = collectionconfiguration.getLocalStorageRolloverFilesize();
        flag3 = false;
        flag2 = false;
        flag1 = false;
        flag = flag3;
        if (obj == null) goto _L2; else goto _L1
_L1:
        collectionconfiguration = EncryptionFactory.getEncryptionManager(collectionconfiguration.getLocalStorageEncryptionScheme(), collectionconfiguration.getLocalStorageEncryptionKey());
        obj = DatastoreFactory.getDataStore(((Configuration.PersistenceFormat) (obj)), ((Long) (obj1)), long1, s1);
        flag = flag3;
        if (obj == null) goto _L2; else goto _L3
_L3:
        obj1 = Profiler.methodScopeStart(com/amazon/sdk/availability/AvailabilityService, "writeMeasurement/write");
        flag = flag2;
        ((DataStore) (obj)).open(getContext(), collectionconfiguration);
        flag = flag2;
        if (!((DataStore) (obj)).put(jsonobject)) goto _L5; else goto _L4
_L4:
        flag = flag2;
        Logger.measurementRecorded(s, s1);
        flag = true;
        flag1 = true;
        Logger.v((new StringBuilder()).append("put measurement for client ID: ").append(s1).toString());
        flag = flag1;
_L7:
        ((DataStore) (obj)).close();
        Profiler.scopeEnd(((com.amazon.profiling.ProfilerScope) (obj1)));
_L2:
        Profiler.scopeEnd(profilerscope);
        return flag;
_L5:
        flag = flag2;
        Logger.v((new StringBuilder()).append("dropped measurement for client ID: ").append(s1).toString());
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        collectionconfiguration;
        Logger.e("persistence write error", collectionconfiguration);
        ((DataStore) (obj)).close();
        Profiler.scopeEnd(((com.amazon.profiling.ProfilerScope) (obj1)));
          goto _L2
        collectionconfiguration;
        ((DataStore) (obj)).close();
        Profiler.scopeEnd(((com.amazon.profiling.ProfilerScope) (obj1)));
        throw collectionconfiguration;
        if (true) goto _L7; else goto _L6
_L6:
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import com.newrelic.agent.android.api.common.ConnectionState;
import com.newrelic.agent.android.api.common.ErrorData;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.api.v1.Configuration;
import com.newrelic.agent.android.api.v1.ConnectionEvent;
import com.newrelic.agent.android.api.v1.ConnectionListener;
import com.newrelic.agent.android.api.v1.DefaultNewRelicApi;
import com.newrelic.agent.android.api.v1.DeviceForm;
import com.newrelic.agent.android.api.v1.NewRelicApi;
import com.newrelic.agent.android.background.ApplicationStateEvent;
import com.newrelic.agent.android.background.ApplicationStateListener;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.background.HarvestHeartbeat;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.AndroidConnectivitySampler;
import com.newrelic.agent.android.util.AndroidEncoder;
import com.newrelic.agent.android.util.AndroidMachineMeasurementsSampler;
import com.newrelic.agent.android.util.Carrier;
import com.newrelic.agent.android.util.ConnectionStateUtil;
import com.newrelic.agent.android.util.ConnectivitySampler;
import com.newrelic.agent.android.util.Encoder;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.newrelic.agent.android:
//            AgentImpl, AgentInitializationException, Agent, NullAgentImpl

public class AndroidAgentImpl
    implements AgentImpl, ConnectionListener, ApplicationStateListener
{
    private static final class AppInfo
    {

        private final String appName;
        private final String appVersion;
        private final PackageManager packageManager;
        private final String packageName;

        public static AppInfo fromContext(Context context1)
            throws AgentInitializationException
        {
            String s;
            s = context1.getPackageName();
            PackageManager packagemanager = context1.getPackageManager();
            String s1;
            try
            {
                context1 = packagemanager.getPackageInfo(s, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context1)
            {
                throw new AgentInitializationException("Could not determine package version", context1);
            }
            if (context1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            s1 = ((PackageInfo) (context1)).versionName;
            context1 = packagemanager.getApplicationInfo(s, 0);
            if (context1 != null)
            {
                try
                {
                    context1 = packagemanager.getApplicationLabel(context1).toString();
                }
                // Misplaced declaration of an exception variable
                catch (Context context1)
                {
                    AndroidAgentImpl.log.warning(context1.toString());
                    context1 = s;
                }
                // Misplaced declaration of an exception variable
                catch (Context context1)
                {
                    AndroidAgentImpl.log.warning(context1.toString());
                    context1 = s;
                }
            } else
            {
                context1 = s;
            }
            return new AppInfo(s, context1, s1, packagemanager);
            throw new AgentInitializationException("No package info available for this app");
        }

        public String getAppName()
        {
            return appName;
        }

        public String getAppVersion()
        {
            return appVersion;
        }

        public PackageManager getPackageManager()
        {
            return packageManager;
        }

        public String getPackageName()
        {
            return packageName;
        }

        private AppInfo(String s, String s1, String s2, PackageManager packagemanager)
        {
            packageName = s;
            appName = s1;
            appVersion = s2;
            packageManager = packagemanager;
        }
    }


    private static final float LOCATION_ACCURACY_THRESHOLD = 500F;
    static final String NEW_RELIC_AGENT_DISABLED_VERSION_KEY = "NewRelicAgentDisabledVersion";
    public static final String PREF_AGENT_VERSION = "agentVersion";
    public static final String PREF_ANDROID_ID_BUG_WORK_AROUND = "androidIdBugWorkAround";
    public static final String PREF_APP_TOKEN = "appToken";
    public static final String PREF_COLLECT_NETWORK_ERRORS = "collectNetworkErrors";
    public static final String PREF_CROSS_PROCESS_ID = "crossProcessId";
    public static final String PREF_DATA_TOKEN = "dataToken";
    public static final String PREF_ERROR_LIMIT = "errorLimit";
    public static final String PREF_HARVEST_INTERVAL = "harvestIntervalInSeconds";
    public static final String PREF_MAX_TRANSACTION_AGE = "maxTransactionAgeInSeconds";
    public static final String PREF_MAX_TRANSACTION_COUNT = "maxTransactionCount";
    public static final String PREF_RESPONSE_BODY_LIMIT = "responseBodyLimit";
    public static final String PREF_SERVER_TIMESTAMP = "serverTimestamp";
    public static final String PREF_STACK_TRACE_LIMIT = "stackTraceLimit";
    private static final Comparator cmp = new Comparator() {

        public int compare(TransactionData transactiondata, TransactionData transactiondata1)
        {
            if (transactiondata.getTimestamp() > transactiondata1.getTimestamp())
            {
                return -1;
            }
            return transactiondata.getTimestamp() >= transactiondata1.getTimestamp() ? 0 : 1;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((TransactionData)obj, (TransactionData)obj1);
        }

    };
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final NewRelicApi api;
    private final String appToken;
    private boolean connected;
    private final Condition connectedCond;
    private ConnectionState connectionState;
    private final Context context;
    private final Encoder encoder;
    private final ArrayList errorDataList;
    private final HarvestHeartbeat heartbeat;
    private LocationListener locationListener;
    private final Lock lock;
    private final String packageName;
    private final ArrayList transactionDataList;

    AndroidAgentImpl(Context context1, String s, String s1, boolean flag, boolean flag1, NewRelicApi newrelicapi, ConnectivitySampler connectivitysampler, 
            long l, TimeUnit timeunit, long l1, TimeUnit timeunit1)
        throws AgentInitializationException
    {
        connectionState = ConnectionState.NULL;
        lock = new ReentrantLock();
        connected = false;
        connectedCond = lock.newCondition();
        encoder = new AndroidEncoder();
        context = appContext(context1);
        if (isDisabled())
        {
            throw new AgentInitializationException("This version of the agent has been disabled");
        }
        transactionDataList = new ArrayList();
        errorDataList = new ArrayList();
        context1 = AppInfo.fromContext(context);
        packageName = context1.getPackageName();
        if (flag1 && context1.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName) == 0)
        {
            log.debug("Location stats enabled");
            addLocationListener();
        }
        appToken = s;
        api = newrelicapi;
        heartbeat = createHarvestHeartbeat(l, timeunit, l1, timeunit1, connectivitysampler);
        ApplicationStateMonitor.getInstance().addApplicationStateListener(this);
    }

    public AndroidAgentImpl(Context context1, String s, String s1, boolean flag, boolean flag1, String s2)
        throws AgentInitializationException
    {
        connectionState = ConnectionState.NULL;
        lock = new ReentrantLock();
        connected = false;
        connectedCond = lock.newCondition();
        encoder = new AndroidEncoder();
        context = appContext(context1);
        if (isDisabled())
        {
            throw new AgentInitializationException("This version of the agent has been disabled");
        }
        transactionDataList = new ArrayList();
        errorDataList = new ArrayList();
        AppInfo appinfo = AppInfo.fromContext(context);
        packageName = appinfo.getPackageName();
        if (flag1 && appinfo.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", packageName) == 0)
        {
            log.debug("Location stats enabled");
            addLocationListener();
        }
        String s4 = sniffDeviceId();
        Configuration configuration = new Configuration();
        String s3 = s2;
        if (s2 == null)
        {
            s3 = appinfo.getAppName();
        }
        configuration.setAppName(s3);
        configuration.setAppVersion(appinfo.getAppVersion());
        configuration.setPackageId(appinfo.getPackageName());
        configuration.setLicenseKey(s);
        configuration.setDeviceId(s4);
        configuration.setDeviceForm(deviceForm(context1));
        configuration.setCollectorHost(s1);
        configuration.setSslEnabled(flag);
        configuration.setDeviceManufacturer(Build.MANUFACTURER);
        configuration.setDeviceModel(Build.MODEL);
        configuration.setAndroidRelease(android.os.Build.VERSION.RELEASE);
        if (!configuration.validate())
        {
            throw new AgentInitializationException("Failed to validate agent configuration");
        } else
        {
            appToken = s;
            s = new DefaultNewRelicApi(configuration);
            s.addConnectionListener(this);
            api = s;
            heartbeat = createHarvestHeartbeat(60L, TimeUnit.SECONDS, 50L, TimeUnit.SECONDS, new AndroidConnectivitySampler(context1));
            ApplicationStateMonitor.getInstance().addApplicationStateListener(this);
            return;
        }
    }

    private void addLocationListener()
    {
        LocationManager locationmanager = (LocationManager)context.getSystemService("location");
        if (locationmanager == null)
        {
            log.error("Unable to retrieve reference to LocationManager. Disabling location listener.");
            return;
        } else
        {
            locationListener = new LocationListener() {

                final AndroidAgentImpl this$0;

                public void onLocationChanged(Location location)
                {
                    if (isAccurate(location))
                    {
                        setLocation(location);
                    }
                }

                public void onProviderDisabled(String s)
                {
                    if (s == "passive")
                    {
                        removeLocationListener();
                    }
                }

                public void onProviderEnabled(String s)
                {
                }

                public void onStatusChanged(String s, int i, Bundle bundle)
                {
                }

            
            {
                this$0 = AndroidAgentImpl.this;
                super();
            }
            };
            locationmanager.requestLocationUpdates("passive", 1000L, 0.0F, locationListener);
            return;
        }
    }

    private static Context appContext(Context context1)
    {
        Context context2 = context1;
        if (!(context1 instanceof Application))
        {
            context2 = context1.getApplicationContext();
        }
        return context2;
    }

    static void clearPreferences(Context context1)
    {
        log.verbose((new StringBuilder()).append("Clearing shared preferences in ").append(getPreferenceFileName(context1.getPackageName())).toString());
        context1 = context1.getSharedPreferences(getPreferenceFileName(context1.getPackageName()), 0).edit();
        context1.clear();
        context1.commit();
    }

    private void constrainTransactions(long l)
    {
        if ((long)transactionDataList.size() > l)
        {
            log.warning((new StringBuilder()).append("Transaction count limit (").append(l).append(") exceeded! Purging ").append((long)transactionDataList.size() - l).append(" oldest transactions").toString());
            StatsEngine.get().inc("Supportability/MobileAgent/TransactionsDropped", (long)transactionDataList.size() - l);
            Collections.sort(transactionDataList, cmp);
            for (; (long)transactionDataList.size() > l; transactionDataList.remove(transactionDataList.size() - 1)) { }
        }
    }

    private HarvestHeartbeat createHarvestHeartbeat(long l, TimeUnit timeunit, long l1, TimeUnit timeunit1, ConnectivitySampler connectivitysampler)
    {
        return new HarvestHeartbeat(api, new AndroidMachineMeasurementsSampler(context), connectivitysampler, l, timeunit, l1, timeunit1);
    }

    private static DeviceForm deviceForm(Context context1)
    {
        int i = context1.getResources().getConfiguration().screenLayout & 0xf;
        switch (i)
        {
        default:
            if (i > 3)
            {
                return DeviceForm.XLARGE;
            } else
            {
                return DeviceForm.UNKNOWN;
            }

        case 1: // '\001'
            return DeviceForm.SMALL;

        case 2: // '\002'
            return DeviceForm.NORMAL;

        case 3: // '\003'
            return DeviceForm.LARGE;
        }
    }

    private long getMaxTransactionAgeInSeconds()
    {
        lock.lock();
        long l = connectionState.getMaxTransactionAgeInSeconds();
        lock.unlock();
        return l;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    static String getPreferenceFileName(String s)
    {
        return (new StringBuilder()).append("com.newrelic.android.agent.v1_").append(s).toString();
    }

    private SharedPreferences getSharedPreferences()
    {
        return context.getSharedPreferences(getPreferenceFileName(context.getPackageName()), 0);
    }

    public static void init(Context context1, String s, String s1, boolean flag, boolean flag1)
    {
        init(context1, s, s1, flag, flag1, null);
    }

    public static void init(Context context1, String s, String s1, boolean flag, boolean flag1, String s2)
    {
        try
        {
            Agent.setImpl(new AndroidAgentImpl(context1, s, s1, flag, flag1, s2));
            Agent.start();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context1)
        {
            log.error((new StringBuilder()).append("Failed to initialize the agent: ").append(context1.toString()).toString());
        }
    }

    private boolean isAccurate(Location location)
    {
        while (location == null || 500F < location.getAccuracy()) 
        {
            return false;
        }
        return true;
    }

    private boolean isAndroidIdBuggy()
    {
        return "9774d56d682e549c".equals(android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id"));
    }

    private boolean isConnected()
    {
        lock.lock();
        boolean flag = connected;
        lock.unlock();
        return flag;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    private boolean isErrorListFull(long l)
    {
        return (long)errorDataList.size() >= l;
    }

    private boolean isStaleTransaction(TransactionData transactiondata)
    {
        long l = TimeUnit.MILLISECONDS.convert(getMaxTransactionAgeInSeconds(), TimeUnit.SECONDS);
        return System.currentTimeMillis() - transactiondata.getTimestamp() > l;
    }

    private boolean isTransactionListFull(long l)
    {
        ArrayList arraylist = transactionDataList;
        arraylist;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if ((long)transactionDataList.size() >= l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        arraylist;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean loadConnectionState(NewRelicApi newrelicapi)
    {
        Object obj = getSharedPreferences();
        log.verbose(MessageFormat.format("New Relic Agent v{0}", new Object[] {
            Agent.getVersion()
        }));
        String s = ((SharedPreferences) (obj)).getString("agentVersion", null);
        if (!api.getDeviceInfo().toString().equals(s))
        {
            if (s != null)
            {
                log.verbose("New agent version detected! We'll need to reconnect.");
            }
            disconnected(new ConnectionEvent(this));
            return false;
        }
        s = ((SharedPreferences) (obj)).getString("appToken", null);
        if (!appToken.equals(s))
        {
            log.verbose("App token has changed!  We'll need to reconnect.");
            disconnected(new ConnectionEvent(this));
            return false;
        }
        obj = ConnectionStateUtil.fromSharedPreferences(((SharedPreferences) (obj)));
        if (ConnectionStateUtil.isValid(((ConnectionState) (obj))))
        {
            newrelicapi.setConnectionState(((ConnectionState) (obj)));
            setConnectionState(((ConnectionState) (obj)));
            return true;
        } else
        {
            log.warning((new StringBuilder()).append("Invalid connection state in shared preferences: ").append(obj).toString());
            disconnected(new ConnectionEvent(this));
            return false;
        }
    }

    private void purgeStaleTransactions(List list)
    {
        long l = getMaxTransactionAgeInSeconds();
        long l1 = System.currentTimeMillis();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            if (l1 - ((TransactionData)list.next()).getTimestamp() > TimeUnit.MILLISECONDS.convert(l, TimeUnit.SECONDS))
            {
                log.verbose("Purging expired transaction");
                list.remove();
            }
        } while (true);
    }

    private void removeLocationListener()
    {
        LocationManager locationmanager;
        if (locationListener == null)
        {
            return;
        }
        locationmanager = (LocationManager)context.getSystemService("location");
        if (locationmanager == null)
        {
            log.error("Unable to retrieve reference to LocationManager. Can't unregister location listener.");
            return;
        }
        locationmanager;
        JVM INSTR monitorenter ;
        locationmanager.removeUpdates(locationListener);
        locationListener = null;
        locationmanager;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        locationmanager;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private String sniffDeviceId()
    {
        Object obj;
        String s;
        if (!isAndroidIdBuggy())
        {
            obj = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        } else
        {
            log.warning("The ANDROID_ID associated with this device indicates an emulator (or an old & buggy physical device). Generating a random UUID.");
            obj = getSharedPreferences().getString("androidIdBugWorkAround", null);
        }
        s = ((String) (obj));
        if (obj == null)
        {
            obj = getSharedPreferences().edit();
            s = UUID.randomUUID().toString();
            ((android.content.SharedPreferences.Editor) (obj)).putString("androidIdBugWorkAround", s);
            ((android.content.SharedPreferences.Editor) (obj)).commit();
        }
        return s;
    }

    private void stop(boolean flag)
    {
        heartbeat.stop(flag);
    }

    public void addErrorData(ErrorData errordata)
    {
        lock.lock();
        boolean flag = connectionState.isCollectingNetworkErrors();
        if (!flag)
        {
            lock.unlock();
            return;
        }
        int i = connectionState.getErrorLimit();
        long l;
        l = i;
        lock.unlock();
        synchronized (errorDataList)
        {
            Iterator iterator = errorDataList.iterator();
            ErrorData errordata1;
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_131;
                }
                errordata1 = (ErrorData)iterator.next();
            } while (!errordata.getHash().equals(errordata1.getHash()));
            errordata1.incrementCount();
        }
        return;
        errordata;
        arraylist;
        JVM INSTR monitorexit ;
        throw errordata;
        errordata;
        lock.unlock();
        throw errordata;
        if (isErrorListFull(l))
        {
            break MISSING_BLOCK_LABEL_152;
        }
        errorDataList.add(errordata);
_L2:
        arraylist;
        JVM INSTR monitorexit ;
        return;
        log.warning((new StringBuilder()).append("Error limit (").append(l).append(") exceeded for this harvest! Skipping new error.").toString());
        StatsEngine.get().inc("Supportability/MobileAgent/ErrorsDropped");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void addTransactionData(TransactionData transactiondata)
    {
        if (transactiondata != null && isStaleTransaction(transactiondata) || !isConnected())
        {
            return;
        }
        lock.lock();
        long l = connectionState.getMaxTransactionCount();
        lock.unlock();
        ArrayList arraylist = transactionDataList;
        arraylist;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = isTransactionListFull(l);
        transactionDataList.add(transactiondata);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        constrainTransactions(l);
        arraylist;
        JVM INSTR monitorexit ;
        return;
        transactiondata;
        arraylist;
        JVM INSTR monitorexit ;
        throw transactiondata;
        transactiondata;
        lock.unlock();
        throw transactiondata;
    }

    public void applicationBackgrounded(ApplicationStateEvent applicationstateevent)
    {
        stop();
    }

    public void applicationForegrounded(ApplicationStateEvent applicationstateevent)
    {
        start();
    }

    public void connected(ConnectionEvent connectionevent)
    {
        log.verbose("New connection detected: updating shared preferences");
        SharedPreferences sharedpreferences = getSharedPreferences();
        connectionevent = connectionevent.getConnectionState();
        ConnectionStateUtil.saveSharedPreferences(sharedpreferences, connectionevent, api.getDeviceInfo(), appToken);
        setConnectionState(connectionevent);
    }

    public void disable()
    {
        log.warning((new StringBuilder()).append("PERMANENTLY DISABLING AGENT v").append(Agent.getVersion()).toString());
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences(getPreferenceFileName(context.getPackageName()), 0).edit();
        editor.putString("NewRelicAgentDisabledVersion", Agent.getVersion());
        editor.commit();
        stop(false);
        Agent.setImpl(NullAgentImpl.instance);
        return;
        Exception exception;
        exception;
        Agent.setImpl(NullAgentImpl.instance);
        throw exception;
        exception;
        stop(false);
        Agent.setImpl(NullAgentImpl.instance);
        throw exception;
        exception;
        Agent.setImpl(NullAgentImpl.instance);
        throw exception;
    }

    public void disconnected(ConnectionEvent connectionevent)
    {
        log.verbose("Detected disconnect: clearing shared preferences");
        ConnectionStateUtil.clearSharedPreferences(getSharedPreferences());
        lock.lock();
        connectionState = ConnectionState.NULL;
        synchronized (transactionDataList)
        {
            transactionDataList.clear();
        }
        synchronized (errorDataList)
        {
            errorDataList.clear();
        }
        connected = false;
        connectedCond.signalAll();
        lock.unlock();
        return;
        exception;
        connectionevent;
        JVM INSTR monitorexit ;
        throw exception;
        connectionevent;
        lock.unlock();
        throw connectionevent;
        exception1;
        connectionevent;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    void dispose()
    {
        heartbeat.dispose();
    }

    public List getAndClearErrorData()
    {
        ArrayList arraylist1;
        synchronized (errorDataList)
        {
            arraylist1 = new ArrayList(errorDataList);
            errorDataList.clear();
        }
        return arraylist1;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public List getAndClearTransactionData()
    {
        ArrayList arraylist1;
        synchronized (transactionDataList)
        {
            arraylist1 = new ArrayList(transactionDataList);
            transactionDataList.clear();
        }
        return arraylist1;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getCrossProcessId()
    {
        lock.lock();
        if (!"".equals(connectionState.getCrossProcessId()))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        String s = null;
_L1:
        boolean flag = connected;
        if (!flag)
        {
            s = null;
        }
        lock.unlock();
        return s;
        s = connectionState.getCrossProcessId();
          goto _L1
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public Encoder getEncoder()
    {
        return encoder;
    }

    public String getNetworkCarrier()
    {
        return Carrier.nameFromContext(context);
    }

    public int getResponseBodyLimit()
    {
        lock.lock();
        int i = connectionState.getResponseBodyLimit();
        lock.unlock();
        return i;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public int getStackTraceLimit()
    {
        lock.lock();
        int i = connectionState.getStackTraceLimit();
        lock.unlock();
        return i;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public boolean isDisabled()
    {
        SharedPreferences sharedpreferences = context.getSharedPreferences(getPreferenceFileName(context.getPackageName()), 0);
        return Agent.getVersion().equals(sharedpreferences.getString("NewRelicAgentDisabledVersion", null));
    }

    public void mergeErrorData(List list)
    {
        lock.lock();
        boolean flag = connectionState.isCollectingNetworkErrors();
        if (!flag)
        {
            lock.unlock();
            return;
        }
        int i = connectionState.getErrorLimit();
        long l;
        l = i;
        lock.unlock();
        ArrayList arraylist = errorDataList;
        arraylist;
        JVM INSTR monitorenter ;
        i = (int)l;
        int j = i - errorDataList.size();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        list = list.iterator();
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        errorDataList.add(list.next());
        i++;
        if (true) goto _L3; else goto _L2
        list;
        lock.unlock();
        throw list;
_L2:
        arraylist;
        JVM INSTR monitorexit ;
        return;
        list;
        arraylist;
        JVM INSTR monitorexit ;
        throw list;
    }

    public void mergeTransactionData(List list)
    {
        if (isConnected()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        purgeStaleTransactions(list);
        if (list.size() <= 0) goto _L1; else goto _L3
_L3:
        lock.lock();
        long l = connectionState.getMaxTransactionCount();
        lock.unlock();
        synchronized (transactionDataList)
        {
            transactionDataList.addAll(list);
            constrainTransactions(l);
        }
        return;
        list;
        arraylist;
        JVM INSTR monitorexit ;
        throw list;
    }

    void setConnectionState(ConnectionState connectionstate)
    {
        if (!ConnectionStateUtil.isValid(connectionstate))
        {
            break MISSING_BLOCK_LABEL_101;
        }
        lock.lock();
        connectionState = connectionstate;
        lock.unlock();
        heartbeat.setInterval(connectionstate.getHarvestIntervalInMilliseconds(), TimeUnit.MILLISECONDS);
        lock.lock();
        connected = true;
        connectedCond.signalAll();
        lock.unlock();
        return;
        connectionstate;
        lock.unlock();
        throw connectionstate;
        connectionstate;
        lock.unlock();
        throw connectionstate;
        log.warning((new StringBuilder()).append("Invalid connection state detected: ").append(connectionstate.toString()).toString());
        lock.lock();
        connected = false;
        connectedCond.signalAll();
        lock.unlock();
        return;
        connectionstate;
        lock.unlock();
        throw connectionstate;
    }

    public void setLocation(Location location)
    {
        if (location == null)
        {
            throw new IllegalArgumentException("Location must not be null.");
        }
        Geocoder geocoder = new Geocoder(context);
        Object obj = null;
        try
        {
            location = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        }
        // Misplaced declaration of an exception variable
        catch (Location location)
        {
            log.error((new StringBuilder()).append("Unable to geocode location: ").append(location.toString()).toString());
            location = ((Location) (obj));
        }
        if (location != null && location.size() != 0)
        {
            if ((obj = (Address)location.get(0)) != null)
            {
                location = ((Address) (obj)).getCountryCode();
                obj = ((Address) (obj)).getAdminArea();
                if (location != null && obj != null)
                {
                    setLocation(((String) (location)), ((String) (obj)));
                    removeLocationListener();
                    return;
                }
            }
        }
    }

    public void setLocation(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            throw new IllegalArgumentException("Country code and administrative region are required.");
        } else
        {
            api.setLocation(new com.newrelic.agent.android.instrumentation.Location(s, s1));
            return;
        }
    }

    public void start()
    {
        boolean flag = false;
        if (!isDisabled())
        {
            api.reset();
            HarvestHeartbeat harvestheartbeat = heartbeat;
            if (!loadConnectionState(api))
            {
                flag = true;
            }
            harvestheartbeat.start(flag);
            return;
        } else
        {
            stop(false);
            return;
        }
    }

    public void stop()
    {
        stop(true);
    }

    public boolean waitForConnect(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        lock.lock();
        timeunit = new Date(System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(l, timeunit));
_L1:
        boolean flag;
        if (connected)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        flag = connectedCond.awaitUntil(timeunit);
        if (!flag)
        {
            lock.unlock();
            return false;
        }
          goto _L1
        lock.unlock();
        return true;
        timeunit;
        lock.unlock();
        throw timeunit;
    }

    public boolean waitForHarvest(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        return heartbeat.waitForHarvest(l, timeunit);
    }

    public boolean waitForStop(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        return heartbeat.waitForStop(l, timeunit);
    }




}

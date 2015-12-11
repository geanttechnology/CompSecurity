// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.EventManager;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.api.v1.ConnectionEvent;
import com.newrelic.agent.android.api.v1.ConnectionListener;
import com.newrelic.agent.android.api.v1.DeviceForm;
import com.newrelic.agent.android.api.v2.TraceMachineInterface;
import com.newrelic.agent.android.background.ApplicationStateEvent;
import com.newrelic.agent.android.background.ApplicationStateListener;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.crashes.CrashReporter;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.sample.MachineMeasurementConsumer;
import com.newrelic.agent.android.sample.Sampler;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.Sample;
import com.newrelic.agent.android.tracing.SampleValue;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.AndroidEncoder;
import com.newrelic.agent.android.util.Connectivity;
import com.newrelic.agent.android.util.Encoder;
import com.newrelic.agent.android.util.JsonCrashStore;
import com.newrelic.agent.android.util.PersistentUUID;
import com.newrelic.agent.android.util.SharedPrefsAnalyticAttributeStore;
import com.newrelic.agent.android.util.UiBackgroundListener;
import d.a.a;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.newrelic.agent.android:
//            AgentImpl, AgentInitializationException, SavedState, AgentConfiguration, 
//            Agent, Measurements, NullAgentImpl

public class AndroidAgentImpl
    implements AgentImpl, ConnectionListener, TraceMachineInterface, ApplicationStateListener
{

    private static final float LOCATION_ACCURACY_THRESHOLD = 500F;
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
    private final AgentConfiguration agentConfiguration;
    private ApplicationInformation applicationInformation;
    private final Context context;
    private DeviceInformation deviceInformation;
    private final Encoder encoder = new AndroidEncoder();
    private LocationListener locationListener;
    private final Lock lock = new ReentrantLock();
    private MachineMeasurementConsumer machineMeasurementConsumer;
    private SavedState savedState;

    public AndroidAgentImpl(Context context1, AgentConfiguration agentconfiguration)
        throws AgentInitializationException
    {
        context = appContext(context1);
        agentConfiguration = agentconfiguration;
        savedState = new SavedState(context);
        if (isDisabled())
        {
            throw new AgentInitializationException("This version of the agent has been disabled");
        }
        initApplicationInformation();
        if (agentconfiguration.useLocationService() && context.getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", getApplicationInformation().getPackageId()) == 0)
        {
            log.debug("Location stats enabled");
            addLocationListener();
        }
        TraceMachine.setTraceMachineInterface(this);
        agentconfiguration.setCrashStore(new JsonCrashStore(context1));
        agentconfiguration.setAnalyticAttributeStore(new SharedPrefsAnalyticAttributeStore(context1));
        ApplicationStateMonitor.getInstance().addApplicationStateListener(this);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            context1.registerComponentCallbacks(new UiBackgroundListener());
        }
        Sampler.init(context1);
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
                    if ("passive".equals(s))
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

    private String getUUID()
    {
        String s1 = savedState.getConnectInformation().getDeviceInformation().getDeviceId();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = (new PersistentUUID(context)).getPersistentUUID();
            savedState.saveDeviceId(s);
        }
        return s;
    }

    private String getUnhandledExceptionHandlerName()
    {
        String s;
        try
        {
            s = Thread.getDefaultUncaughtExceptionHandler().getClass().getName();
        }
        catch (Exception exception)
        {
            return "unknown";
        }
        return s;
    }

    public static void init(Context context1, AgentConfiguration agentconfiguration)
    {
        try
        {
            Agent.setImpl(new AndroidAgentImpl(context1, agentconfiguration));
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

    private void pokeCanary()
    {
        a.a();
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

    private void stop(boolean flag)
    {
        Sampler.shutdown();
        TraceMachine.haltTracing();
        int i = AnalyticsControllerImpl.getInstance().getEventManager().getEventsRecorded();
        int j = AnalyticsControllerImpl.getInstance().getEventManager().getEventsEjected();
        Measurements.addCustomMetric("Supportability/Events/Recorded", MetricCategory.NONE.name(), i, j, j, MetricUnit.OPERATIONS, MetricUnit.OPERATIONS);
        if (flag)
        {
            Harvest.harvestNow();
        }
        AnalyticsControllerImpl.shutdown();
        TraceMachine.clearActivityHistory();
        Harvest.shutdown();
        Measurements.shutdown();
    }

    public void addTransactionData(TransactionData transactiondata)
    {
    }

    public void applicationBackgrounded(ApplicationStateEvent applicationstateevent)
    {
        log.info("AndroidAgentImpl: application backgrounded ");
        stop();
    }

    public void applicationForegrounded(ApplicationStateEvent applicationstateevent)
    {
        log.info("AndroidAgentImpl: application foregrounded ");
        start();
    }

    public void connected(ConnectionEvent connectionevent)
    {
        log.error("AndroidAgentImpl: connected ");
    }

    public void disable()
    {
        log.warning((new StringBuilder()).append("PERMANENTLY DISABLING AGENT v").append(Agent.getVersion()).toString());
        savedState.saveDisabledVersion(Agent.getVersion());
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
        savedState.clear();
    }

    public List getAndClearTransactionData()
    {
        return null;
    }

    public ApplicationInformation getApplicationInformation()
    {
        return applicationInformation;
    }

    public String getCrossProcessId()
    {
        lock.lock();
        String s = savedState.getCrossProcessId();
        lock.unlock();
        return s;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public long getCurrentThreadId()
    {
        return Thread.currentThread().getId();
    }

    public String getCurrentThreadName()
    {
        return Thread.currentThread().getName();
    }

    public DeviceInformation getDeviceInformation()
    {
        if (deviceInformation != null)
        {
            return deviceInformation;
        } else
        {
            DeviceInformation deviceinformation = new DeviceInformation();
            deviceinformation.setOsName("Android");
            deviceinformation.setOsVersion(android.os.Build.VERSION.RELEASE);
            deviceinformation.setOsBuild(android.os.Build.VERSION.INCREMENTAL);
            deviceinformation.setModel(Build.MODEL);
            deviceinformation.setAgentName("AndroidAgent");
            deviceinformation.setAgentVersion(Agent.getVersion());
            deviceinformation.setManufacturer(Build.MANUFACTURER);
            deviceinformation.setDeviceId(getUUID());
            deviceinformation.setArchitecture(System.getProperty("os.arch"));
            deviceinformation.setRunTime(System.getProperty("java.vm.version"));
            deviceinformation.setSize(deviceForm(context).name().toLowerCase());
            deviceInformation = deviceinformation;
            return deviceInformation;
        }
    }

    public Encoder getEncoder()
    {
        return encoder;
    }

    public EnvironmentInformation getEnvironmentInformation()
    {
        EnvironmentInformation environmentinformation;
        long al[];
        ActivityManager activitymanager;
        environmentinformation = new EnvironmentInformation();
        activitymanager = (ActivityManager)context.getSystemService("activity");
        al = new long[2];
        StatFs statfs;
        StatFs statfs1;
        statfs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        statfs1 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (android.os.Build.VERSION.SDK_INT < 18) goto _L2; else goto _L1
_L1:
        al[0] = statfs.getAvailableBlocksLong() * statfs.getBlockSizeLong();
        al[1] = statfs1.getAvailableBlocksLong() * statfs.getBlockSizeLong();
_L6:
        if (al[0] < 0L)
        {
            al[0] = 0L;
        }
        if (al[1] < 0L)
        {
            al[1] = 0L;
        }
        environmentinformation.setDiskAvailable(al);
_L4:
        environmentinformation.setMemoryUsage(Sampler.sampleMemory(activitymanager).getSampleValue().asLong().longValue());
        environmentinformation.setOrientation(context.getResources().getConfiguration().orientation);
        environmentinformation.setNetworkStatus(getNetworkCarrier());
        environmentinformation.setNetworkWanType(getNetworkWanType());
        return environmentinformation;
_L2:
        int i = statfs.getAvailableBlocks();
        al[0] = statfs.getBlockSize() * i;
        i = statfs1.getAvailableBlocks();
        al[1] = statfs1.getBlockSize() * i;
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        AgentHealth.noticeException(exception1);
        if (al[0] < 0L)
        {
            al[0] = 0L;
        }
        if (al[1] < 0L)
        {
            al[1] = 0L;
        }
        environmentinformation.setDiskAvailable(al);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        if (al[0] < 0L)
        {
            al[0] = 0L;
        }
        if (al[1] < 0L)
        {
            al[1] = 0L;
        }
        environmentinformation.setDiskAvailable(al);
        throw exception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String getNetworkCarrier()
    {
        return Connectivity.carrierNameFromContext(context);
    }

    public String getNetworkWanType()
    {
        return Connectivity.wanType(context);
    }

    public int getResponseBodyLimit()
    {
        lock.lock();
        int i = savedState.getHarvestConfiguration().getResponse_body_limit();
        lock.unlock();
        return i;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public long getSessionDurationMillis()
    {
        Harvest.getInstance();
        return Harvest.getMillisSinceStart();
    }

    public int getStackTraceLimit()
    {
        lock.lock();
        int i = savedState.getStackTraceLimit();
        lock.unlock();
        return i;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public void initApplicationInformation()
        throws AgentInitializationException
    {
        String s;
        if (applicationInformation != null)
        {
            log.debug("attempted to reinitialize ApplicationInformation.");
            return;
        }
        s = context.getPackageName();
        PackageManager packagemanager = context.getPackageManager();
        Object obj;
        String s2;
        String s3;
        PackageInfo packageinfo;
        try
        {
            packageinfo = packagemanager.getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new AgentInitializationException((new StringBuilder()).append("Could not determine package version: ").append(((android.content.pm.PackageManager.NameNotFoundException) (obj1)).getMessage()).toString());
        }
        obj = agentConfiguration.getCustomApplicationVersion();
        s2 = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            if (packageinfo == null || packageinfo.versionName == null || packageinfo.versionName.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_282;
            }
            s2 = packageinfo.versionName;
        }
        log.debug((new StringBuilder()).append("Using application version ").append(s2).toString());
        obj = packagemanager.getApplicationInfo(s, 0);
        Object obj1;
        String s1;
        if (obj != null)
        {
            try
            {
                obj1 = packagemanager.getApplicationLabel(((android.content.pm.ApplicationInfo) (obj))).toString();
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                log.warning(namenotfoundexception.toString());
                namenotfoundexception = s;
            }
            catch (SecurityException securityexception)
            {
                log.warning(securityexception.toString());
                securityexception = s;
            }
        } else
        {
            obj1 = s;
        }
        log.debug((new StringBuilder()).append("Using application name ").append(((String) (obj1))).toString());
        s3 = agentConfiguration.getCustomBuildIdentifier();
        s1 = s3;
        if (TextUtils.isEmpty(s3))
        {
            if (packageinfo != null)
            {
                s1 = String.valueOf(packageinfo.versionCode);
            } else
            {
                s1 = "";
                log.warning("Your app doesn't appear to have a version code defined. Ensure you have defined 'versionCode' in your manifest.");
            }
        }
        log.debug((new StringBuilder()).append("Using build  ").append(s1).toString());
        applicationInformation = new ApplicationInformation(((String) (obj1)), s2, s, s1);
        return;
        throw new AgentInitializationException("Your app doesn't appear to have a version defined. Ensure you have defined 'versionName' in your manifest.");
    }

    protected void initialize()
    {
        Harvest.addHarvestListener(savedState);
        Harvest.initialize(agentConfiguration);
        Harvest.setHarvestConfiguration(savedState.getHarvestConfiguration());
        Harvest.setHarvestConnectInformation(savedState.getConnectInformation());
        Measurements.initialize();
        log.info(MessageFormat.format("New Relic Agent v{0}", new Object[] {
            Agent.getVersion()
        }));
        log.verbose(MessageFormat.format("Application token: {0}", new Object[] {
            agentConfiguration.getApplicationToken()
        }));
        machineMeasurementConsumer = new MachineMeasurementConsumer();
        Measurements.addMeasurementConsumer(machineMeasurementConsumer);
        AnalyticsControllerImpl.getInstance();
        AnalyticsControllerImpl.initialize(agentConfiguration, this);
        StatsEngine.get().inc((new StringBuilder()).append("Supportability/AgentHealth/UncaughtExceptionHandler/").append(getUnhandledExceptionHandlerName()).toString());
        CrashReporter.initialize(agentConfiguration);
    }

    public boolean isDisabled()
    {
        return Agent.getVersion().equals(savedState.getDisabledVersion());
    }

    public boolean isUIThread()
    {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public void mergeTransactionData(List list)
    {
    }

    public void setLocation(Location location)
    {
        if (location == null)
        {
            throw new IllegalArgumentException("Location must not be null.");
        }
        Object obj = new Geocoder(context);
        try
        {
            location = ((Geocoder) (obj)).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
        }
        // Misplaced declaration of an exception variable
        catch (Location location)
        {
            log.error((new StringBuilder()).append("Unable to geocode location: ").append(location.toString()).toString());
            location = null;
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
            return;
        }
    }

    public void start()
    {
        if (!isDisabled())
        {
            initialize();
            Harvest.start();
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

    public boolean updateSavedConnectInformation()
    {
        ConnectInformation connectinformation = savedState.getConnectInformation();
        ConnectInformation connectinformation1 = new ConnectInformation(getApplicationInformation(), getDeviceInformation());
        String s = savedState.getAppToken();
        if (!connectinformation1.equals(connectinformation) || !agentConfiguration.getApplicationToken().equals(s))
        {
            savedState.clear();
            savedState.saveConnectInformation(connectinformation1);
            savedState.saveAppToken(agentConfiguration.getApplicationToken());
            return true;
        } else
        {
            return false;
        }
    }



}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import android.content.Context;
import android.content.SharedPreferences;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.ConnectInformation;
import com.newrelic.agent.android.harvest.DataToken;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

// Referenced classes of package com.newrelic.agent.android:
//            Agent

public class SavedState extends HarvestAdapter
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final String NEW_RELIC_AGENT_DISABLED_VERSION_KEY = "NewRelicAgentDisabledVersion";
    private final String PREFERENCE_FILE_PREFIX = "com.newrelic.android.agent.v1_";
    private final String PREF_ACTIVITY_TRACE_MIN_UTILIZATION = "activityTraceMinUtilization";
    private final String PREF_AGENT_NAME = "agentName";
    private final String PREF_AGENT_VERSION = "agentVersion";
    private final String PREF_APP_BUILD = "appBuild";
    private final String PREF_APP_NAME = "appName";
    private final String PREF_APP_TOKEN = "appToken";
    private final String PREF_APP_VERSION = "appVersion";
    private final String PREF_COLLECT_NETWORK_ERRORS = "collectNetworkErrors";
    private final String PREF_CROSS_PROCESS_ID = "crossProcessId";
    private final String PREF_DATA_TOKEN = "dataToken";
    private final String PREF_DEVICE_ARCHITECTURE = "deviceArchitecture";
    private final String PREF_DEVICE_ID = "deviceId";
    private final String PREF_DEVICE_MANUFACTURER = "deviceManufacturer";
    private final String PREF_DEVICE_MODEL = "deviceModel";
    private final String PREF_DEVICE_RUN_TIME = "deviceRunTime";
    private final String PREF_DEVICE_SIZE = "deviceSize";
    private final String PREF_ERROR_LIMIT = "errorLimit";
    private final String PREF_HARVEST_INTERVAL = "harvestIntervalInSeconds";
    private final String PREF_MAX_TRANSACTION_AGE = "maxTransactionAgeInSeconds";
    private final String PREF_MAX_TRANSACTION_COUNT = "maxTransactionCount";
    private final String PREF_OS_BUILD = "osBuild";
    private final String PREF_OS_NAME = "osName";
    private final String PREF_OS_VERSION = "osVersion";
    private final String PREF_PACKAGE_ID = "packageId";
    private final String PREF_RESPONSE_BODY_LIMIT = "responseBodyLimit";
    private final String PREF_SERVER_TIMESTAMP = "serverTimestamp";
    private final String PREF_STACK_TRACE_LIMIT = "stackTraceLimit";
    private final String PREF_VERSION_CODE = "versionCode";
    private Float activityTraceMinUtilization;
    private final HarvestConfiguration configuration = new HarvestConfiguration();
    private final ConnectInformation connectInformation = new ConnectInformation(new ApplicationInformation(), new DeviceInformation());
    private final android.content.SharedPreferences.Editor editor;
    private final Lock lock = new ReentrantLock();
    private final SharedPreferences prefs;

    public SavedState(Context context)
    {
        prefs = context.getSharedPreferences(getPreferenceFileName(context.getPackageName()), 0);
        editor = prefs.edit();
        loadHarvestConfiguration();
        loadConnectInformation();
    }

    private String getPreferenceFileName(String s)
    {
        return (new StringBuilder()).append("com.newrelic.android.agent.v1_").append(s).toString();
    }

    private boolean has(String s)
    {
        return prefs.contains(s);
    }

    private void saveApplicationInformation(ApplicationInformation applicationinformation)
    {
        save("appName", applicationinformation.getAppName());
        save("appVersion", applicationinformation.getAppVersion());
        save("appBuild", applicationinformation.getAppBuild());
        save("packageId", applicationinformation.getPackageId());
        save("versionCode", applicationinformation.getVersionCode());
    }

    private void saveDeviceInformation(DeviceInformation deviceinformation)
    {
        save("agentName", deviceinformation.getAgentName());
        save("agentVersion", deviceinformation.getAgentVersion());
        save("deviceArchitecture", deviceinformation.getArchitecture());
        save("deviceId", deviceinformation.getDeviceId());
        save("deviceModel", deviceinformation.getModel());
        save("deviceManufacturer", deviceinformation.getManufacturer());
        save("deviceRunTime", deviceinformation.getRunTime());
        save("deviceSize", deviceinformation.getSize());
        save("osName", deviceinformation.getOsName());
        save("osBuild", deviceinformation.getOsBuild());
        save("osVersion", deviceinformation.getOsVersion());
    }

    public void clear()
    {
        lock.lock();
        editor.clear();
        editor.commit();
        configuration.setDefaultValues();
        lock.unlock();
        return;
        Exception exception;
        exception;
        lock.unlock();
        throw exception;
    }

    public float getActivityTraceMinUtilization()
    {
        if (activityTraceMinUtilization == null)
        {
            activityTraceMinUtilization = getFloat("activityTraceMinUtilization");
        }
        return activityTraceMinUtilization.floatValue();
    }

    public String getAgentName()
    {
        return getString("agentName");
    }

    public String getAgentVersion()
    {
        return getString("agentVersion");
    }

    public String getAppBuild()
    {
        return getString("appBuild");
    }

    public String getAppName()
    {
        return getString("appName");
    }

    public String getAppToken()
    {
        return getString("appToken");
    }

    public String getAppVersion()
    {
        return getString("appVersion");
    }

    public boolean getBoolean(String s)
    {
        return prefs.getBoolean(s, false);
    }

    public ConnectInformation getConnectInformation()
    {
        return connectInformation;
    }

    public String getCrossProcessId()
    {
        return getString("crossProcessId");
    }

    public int[] getDataToken()
    {
        int ai[] = new int[2];
        Object obj = getString("dataToken");
        if (obj == null)
        {
            return null;
        }
        try
        {
            obj = new JSONTokener(((String) (obj)));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return ai;
        }
        if (obj == null)
        {
            return null;
        }
        obj = (JSONArray)((JSONTokener) (obj)).nextValue();
        if (obj == null)
        {
            return null;
        }
        ai[0] = ((JSONArray) (obj)).getInt(0);
        ai[1] = ((JSONArray) (obj)).getInt(1);
        return ai;
    }

    public String getDeviceArchitecture()
    {
        return getString("deviceArchitecture");
    }

    public String getDeviceId()
    {
        return getString("deviceId");
    }

    public String getDeviceManufacturer()
    {
        return getString("deviceManufacturer");
    }

    public String getDeviceModel()
    {
        return getString("deviceModel");
    }

    public String getDeviceRunTime()
    {
        return getString("deviceRunTime");
    }

    public String getDeviceSize()
    {
        return getString("deviceSize");
    }

    public String getDisabledVersion()
    {
        return getString("NewRelicAgentDisabledVersion");
    }

    public int getErrorLimit()
    {
        return getInt("errorLimit");
    }

    public Float getFloat(String s)
    {
        if (!prefs.contains(s))
        {
            return null;
        } else
        {
            return Float.valueOf((float)(int)(prefs.getFloat(s, 0.0F) * 100F) / 100F);
        }
    }

    public HarvestConfiguration getHarvestConfiguration()
    {
        return configuration;
    }

    public long getHarvestInterval()
    {
        return getLong("harvestIntervalInSeconds");
    }

    public long getHarvestIntervalInSeconds()
    {
        return getHarvestInterval();
    }

    public int getInt(String s)
    {
        return prefs.getInt(s, 0);
    }

    public long getLong(String s)
    {
        return prefs.getLong(s, 0L);
    }

    public long getMaxTransactionAge()
    {
        return getLong("maxTransactionAgeInSeconds");
    }

    public long getMaxTransactionAgeInSeconds()
    {
        return getMaxTransactionAge();
    }

    public long getMaxTransactionCount()
    {
        return getLong("maxTransactionCount");
    }

    public String getOsBuild()
    {
        return getString("osBuild");
    }

    public String getOsName()
    {
        return getString("osName");
    }

    public String getOsVersion()
    {
        return getString("osVersion");
    }

    public String getPackageId()
    {
        return getString("packageId");
    }

    public int getResponseBodyLimit()
    {
        return getInt("responseBodyLimit");
    }

    public long getServerTimestamp()
    {
        return getLong("serverTimestamp");
    }

    public int getStackTraceLimit()
    {
        return getInt("stackTraceLimit");
    }

    public String getString(String s)
    {
        if (!prefs.contains(s))
        {
            return null;
        } else
        {
            return prefs.getString(s, null);
        }
    }

    public int getVersionCode()
    {
        return getInt("versionCode");
    }

    public boolean isCollectingNetworkErrors()
    {
        return getBoolean("collectNetworkErrors");
    }

    public void loadConnectInformation()
    {
        ApplicationInformation applicationinformation = new ApplicationInformation();
        if (has("appName"))
        {
            applicationinformation.setAppName(getAppName());
        }
        if (has("appVersion"))
        {
            applicationinformation.setAppVersion(getAppVersion());
        }
        if (has("appBuild"))
        {
            applicationinformation.setAppBuild(getAppBuild());
        }
        if (has("packageId"))
        {
            applicationinformation.setPackageId(getPackageId());
        }
        if (has("versionCode"))
        {
            applicationinformation.setVersionCode(getVersionCode());
        }
        DeviceInformation deviceinformation = new DeviceInformation();
        if (has("agentName"))
        {
            deviceinformation.setAgentName(getAgentName());
        }
        if (has("agentVersion"))
        {
            deviceinformation.setAgentVersion(getAgentVersion());
        }
        if (has("deviceArchitecture"))
        {
            deviceinformation.setArchitecture(getDeviceArchitecture());
        }
        if (has("deviceId"))
        {
            deviceinformation.setDeviceId(getDeviceId());
        }
        if (has("deviceModel"))
        {
            deviceinformation.setModel(getDeviceModel());
        }
        if (has("deviceManufacturer"))
        {
            deviceinformation.setManufacturer(getDeviceManufacturer());
        }
        if (has("deviceRunTime"))
        {
            deviceinformation.setRunTime(getDeviceRunTime());
        }
        if (has("deviceSize"))
        {
            deviceinformation.setSize(getDeviceSize());
        }
        if (has("osName"))
        {
            deviceinformation.setOsName(getOsName());
        }
        if (has("osBuild"))
        {
            deviceinformation.setOsBuild(getOsBuild());
        }
        if (has("osVersion"))
        {
            deviceinformation.setOsVersion(getOsVersion());
        }
        connectInformation.setApplicationInformation(applicationinformation);
        connectInformation.setDeviceInformation(deviceinformation);
    }

    public void loadHarvestConfiguration()
    {
        if (has("dataToken"))
        {
            configuration.setData_token(getDataToken());
        }
        if (has("crossProcessId"))
        {
            configuration.setCross_process_id(getCrossProcessId());
        }
        if (has("serverTimestamp"))
        {
            configuration.setServer_timestamp(getServerTimestamp());
        }
        if (has("harvestIntervalInSeconds"))
        {
            configuration.setData_report_period((int)getHarvestIntervalInSeconds());
        }
        if (has("maxTransactionAgeInSeconds"))
        {
            configuration.setReport_max_transaction_age((int)getMaxTransactionAgeInSeconds());
        }
        if (has("maxTransactionCount"))
        {
            configuration.setReport_max_transaction_count((int)getMaxTransactionCount());
        }
        if (has("stackTraceLimit"))
        {
            configuration.setStack_trace_limit(getStackTraceLimit());
        }
        if (has("responseBodyLimit"))
        {
            configuration.setResponse_body_limit(getResponseBodyLimit());
        }
        if (has("collectNetworkErrors"))
        {
            configuration.setCollect_network_errors(isCollectingNetworkErrors());
        }
        if (has("errorLimit"))
        {
            configuration.setError_limit(getErrorLimit());
        }
        if (has("activityTraceMinUtilization"))
        {
            configuration.setActivity_trace_min_utilization(getActivityTraceMinUtilization());
        }
        log.info((new StringBuilder()).append("Loaded configuration: ").append(configuration).toString());
    }

    public void onHarvestComplete()
    {
        saveHarvestConfiguration(Harvest.getHarvestConfiguration());
    }

    public void onHarvestConnected()
    {
        saveHarvestConfiguration(Harvest.getHarvestConfiguration());
    }

    public void onHarvestDisabled()
    {
        String s = Agent.getDeviceInformation().getAgentVersion();
        log.info((new StringBuilder()).append("Disabling agent version ").append(s).toString());
        saveDisabledVersion(s);
    }

    public void onHarvestDisconnected()
    {
        log.info("Clearing harvest configuration.");
        clear();
    }

    public void save(String s, float f)
    {
        lock.lock();
        editor.putFloat(s, f);
        editor.commit();
        lock.unlock();
        return;
        s;
        lock.unlock();
        throw s;
    }

    public void save(String s, int i)
    {
        lock.lock();
        editor.putInt(s, i);
        editor.commit();
        lock.unlock();
        return;
        s;
        lock.unlock();
        throw s;
    }

    public void save(String s, long l)
    {
        lock.lock();
        editor.putLong(s, l);
        editor.commit();
        lock.unlock();
        return;
        s;
        lock.unlock();
        throw s;
    }

    public void save(String s, String s1)
    {
        lock.lock();
        editor.putString(s, s1);
        editor.commit();
        lock.unlock();
        return;
        s;
        lock.unlock();
        throw s;
    }

    public void save(String s, boolean flag)
    {
        lock.lock();
        editor.putBoolean(s, flag);
        editor.commit();
        lock.unlock();
        return;
        s;
        lock.unlock();
        throw s;
    }

    public void saveActivityTraceMinUtilization(float f)
    {
        activityTraceMinUtilization = Float.valueOf(f);
        save("activityTraceMinUtilization", f);
    }

    public void saveAppToken(String s)
    {
        save("appToken", s);
    }

    public void saveConnectInformation(ConnectInformation connectinformation)
    {
        if (connectInformation.equals(connectinformation))
        {
            return;
        } else
        {
            saveApplicationInformation(connectinformation.getApplicationInformation());
            saveDeviceInformation(connectinformation.getDeviceInformation());
            loadConnectInformation();
            return;
        }
    }

    public void saveDeviceId(String s)
    {
        save("deviceId", s);
        connectInformation.getDeviceInformation().setDeviceId(s);
    }

    public void saveDisabledVersion(String s)
    {
        save("NewRelicAgentDisabledVersion", s);
    }

    public void saveHarvestConfiguration(HarvestConfiguration harvestconfiguration)
    {
        if (configuration.equals(harvestconfiguration))
        {
            return;
        }
        if (!harvestconfiguration.getDataToken().isValid())
        {
            harvestconfiguration.setData_token(configuration.getData_token());
        }
        log.info((new StringBuilder()).append("Saving configuration: ").append(harvestconfiguration).toString());
        String s = harvestconfiguration.getDataToken().toJsonString();
        log.debug((new StringBuilder()).append("!! saving data token: ").append(s).toString());
        save("dataToken", s);
        save("crossProcessId", harvestconfiguration.getCross_process_id());
        save("serverTimestamp", harvestconfiguration.getServer_timestamp());
        save("harvestIntervalInSeconds", harvestconfiguration.getData_report_period());
        save("maxTransactionAgeInSeconds", harvestconfiguration.getReport_max_transaction_age());
        save("maxTransactionCount", harvestconfiguration.getReport_max_transaction_count());
        save("stackTraceLimit", harvestconfiguration.getStack_trace_limit());
        save("responseBodyLimit", harvestconfiguration.getResponse_body_limit());
        save("collectNetworkErrors", harvestconfiguration.isCollect_network_errors());
        save("errorLimit", harvestconfiguration.getError_limit());
        saveActivityTraceMinUtilization((float)harvestconfiguration.getActivity_trace_min_utilization());
        loadHarvestConfiguration();
    }

}

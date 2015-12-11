// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.utils;

import android.text.TextUtils;
import com.supersonic.mediationsdk.logger.SupersonicError;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.supersonic.mediationsdk.utils:
//            ErrorBuilder

public class ServerResponseWrapper
{

    public static final String APP_KEY_FIELD = "appKey";
    public static final String SETTINGS_FIELD = "settings";
    public static final String USER_ID_FIELD = "userId";
    private final String ADAPTERS_LOAD_TIMEOUT;
    private final int DEFAULT_ADAPTERS_SMARTLOAD_AMOUNT;
    private final int DEFAULT_ADAPTERS_SMARTLOAD_TIMEOUT;
    private final String ERROR_KEY;
    private final String NUM_OF_ADAPTERS_KEY;
    private final String PROVIDERS_KEY;
    private String mAppKey;
    private int mLoadPosition;
    private ArrayList mProviders;
    private JSONObject mSettings;
    private String mUserId;

    private ServerResponseWrapper()
    {
        PROVIDERS_KEY = "providers";
        ERROR_KEY = "error";
        NUM_OF_ADAPTERS_KEY = "maxNumOfAdaptersToLoadOnStart";
        ADAPTERS_LOAD_TIMEOUT = "adapterTimeOutInSeconds";
        DEFAULT_ADAPTERS_SMARTLOAD_AMOUNT = 2;
        DEFAULT_ADAPTERS_SMARTLOAD_TIMEOUT = 60;
        mLoadPosition = -1;
    }

    public ServerResponseWrapper(ServerResponseWrapper serverresponsewrapper)
    {
        PROVIDERS_KEY = "providers";
        ERROR_KEY = "error";
        NUM_OF_ADAPTERS_KEY = "maxNumOfAdaptersToLoadOnStart";
        ADAPTERS_LOAD_TIMEOUT = "adapterTimeOutInSeconds";
        DEFAULT_ADAPTERS_SMARTLOAD_AMOUNT = 2;
        DEFAULT_ADAPTERS_SMARTLOAD_TIMEOUT = 60;
        mLoadPosition = -1;
        try
        {
            mSettings = new JSONObject(serverresponsewrapper.mSettings.toString());
            mProviders = new ArrayList();
            mProviders.addAll(serverresponsewrapper.mProviders);
            mAppKey = serverresponsewrapper.mAppKey;
            mUserId = serverresponsewrapper.mUserId;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ServerResponseWrapper serverresponsewrapper)
        {
            defaultInit();
        }
        serverresponsewrapper.printStackTrace();
    }

    public ServerResponseWrapper(String s, String s1, String s2)
    {
        PROVIDERS_KEY = "providers";
        ERROR_KEY = "error";
        NUM_OF_ADAPTERS_KEY = "maxNumOfAdaptersToLoadOnStart";
        ADAPTERS_LOAD_TIMEOUT = "adapterTimeOutInSeconds";
        DEFAULT_ADAPTERS_SMARTLOAD_AMOUNT = 2;
        DEFAULT_ADAPTERS_SMARTLOAD_TIMEOUT = 60;
        mLoadPosition = -1;
        if (!TextUtils.isEmpty(s2)) goto _L2; else goto _L1
_L1:
        mSettings = new JSONObject();
_L7:
        s2 = mSettings.optJSONArray("providers");
        if (s2 == null) goto _L4; else goto _L3
_L3:
        int i;
        try
        {
            mProviders = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            defaultInit();
            return;
        }
        i = 0;
        if (i >= s2.length())
        {
            break; /* Loop/switch isn't completed */
        }
        mProviders.add(s2.optJSONObject(i));
        i++;
        if (true) goto _L6; else goto _L5
_L6:
        break MISSING_BLOCK_LABEL_90;
_L2:
        mSettings = new JSONObject(s2);
          goto _L7
_L4:
        mProviders = new ArrayList();
_L5:
        s2 = s;
        if (TextUtils.isEmpty(s))
        {
            s2 = "";
        }
        mAppKey = s2;
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = "";
        }
        mUserId = s;
        return;
    }

    private void defaultInit()
    {
        mSettings = new JSONObject();
        mProviders = new ArrayList();
        mAppKey = "";
        mUserId = "";
    }

    private Map getAdColonySupportedVersions()
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add("2.2.1");
        hashmap.put("1.0", arraylist);
        return hashmap;
    }

    private Map getAppLovinSupportedVesions()
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add("5.4.2");
        arraylist.add("5.4.3");
        hashmap.put("1.0", arraylist);
        return hashmap;
    }

    private JSONObject getEventsSettingsSection()
    {
        return getSection(getSettingsSection(), "events");
    }

    private Map getFlurrySupportedVesions()
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add("5.3.0");
        hashmap.put("1.0", arraylist);
        return hashmap;
    }

    private int getIntFromEventsSectionOrNegative(String s)
    {
        byte byte0 = -1;
        JSONObject jsonobject = getEventsSettingsSection();
        int i = byte0;
        if (jsonobject != null)
        {
            i = byte0;
            if (jsonobject.has(s))
            {
                try
                {
                    i = jsonobject.getInt(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return -1;
                }
            }
        }
        return i;
    }

    private JSONArray getJSONArrayWithSupersonicAdapter()
    {
        JSONArray jsonarray;
        JSONArray jsonarray1;
        jsonarray = new JSONArray();
        jsonarray1 = getRVProvidersArray();
        if (jsonarray1 == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L8:
        if (i >= jsonarray1.length()) goto _L2; else goto _L3
_L3:
        JSONObject jsonobject = (JSONObject)jsonarray1.get(i);
        if (jsonobject == null) goto _L5; else goto _L4
_L4:
        if (!"SupersonicAds".equals(jsonobject.optString("provider"))) goto _L5; else goto _L6
_L6:
        jsonarray.put(jsonobject);
_L2:
        return jsonarray;
        Exception exception;
        exception;
_L5:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private int getLoggerLogLevel(String s)
    {
        byte byte0 = -1;
        int i = byte0;
        if (s != null)
        {
            JSONObject jsonobject = getLoggersSettings();
            i = byte0;
            try
            {
                if (jsonobject.has(s))
                {
                    i = jsonobject.getInt(s);
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return -1;
            }
        }
        return i;
    }

    private JSONObject getLoggersSettings()
    {
        JSONObject jsonobject1 = getSettingsSection().optJSONObject("loggers");
        JSONObject jsonobject = jsonobject1;
        if (jsonobject1 == null)
        {
            jsonobject = new JSONObject();
        }
        return jsonobject;
    }

    private JSONObject getProviderSettings(String s)
    {
        JSONArray jsonarray = getRVProvidersArray();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.optJSONObject(i);
            if (jsonobject != null && jsonobject.optString("provider").equals(s))
            {
                return jsonobject;
            }
        }

        return new JSONObject();
    }

    private JSONObject getSection(JSONObject jsonobject, String s)
    {
        JSONObject jsonobject1 = null;
        if (jsonobject != null)
        {
            jsonobject1 = jsonobject.optJSONObject(s);
        }
        jsonobject = jsonobject1;
        if (jsonobject1 == null)
        {
            jsonobject = new JSONObject();
        }
        return jsonobject;
    }

    private JSONObject getSettingsSection()
    {
        return getSection(mSettings, "settings");
    }

    private int getSmartLoadAmountFromResponse()
    {
        return getSettingsSection().optInt("maxNumOfAdaptersToLoadOnStart");
    }

    private int getSmartLoadTimeoutFromResponse()
    {
        return getSettingsSection().optInt("adapterTimeOutInSeconds");
    }

    private Map getSupersonicSupportedVersions()
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add("5.14");
        hashmap.put("1.0", arraylist);
        return hashmap;
    }

    private Map getUnityAdsSupportedVersion()
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add("1.3.12");
        hashmap.put("1.0", arraylist);
        return hashmap;
    }

    private Map getVungleSupportedVersion()
    {
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        arraylist.add("3.3.0");
        hashmap.put("1.0", arraylist);
        return hashmap;
    }

    public Map getAdapterSupportedVersion(String s)
    {
        HashMap hashmap = new HashMap();
        if (s != null)
        {
            if (s.equals("SupersonicAds"))
            {
                return getSupersonicSupportedVersions();
            }
            if (s.equals("AdColony"))
            {
                return getAdColonySupportedVersions();
            }
            if (s.equals("AppLovin"))
            {
                return getAppLovinSupportedVesions();
            }
            if (s.equals("Flurry"))
            {
                return getFlurrySupportedVesions();
            }
            if (s.equals("UnityAds"))
            {
                return getUnityAdsSupportedVersion();
            }
            if (s.equals("Vungle"))
            {
                return getVungleSupportedVersion();
            }
        }
        return hashmap;
    }

    public int getAdaptersLoadPosition()
    {
        return mLoadPosition;
    }

    public int getAdaptersSmartLoadAmount()
    {
        int j = getSmartLoadAmountFromResponse();
        int i = j;
        if (j == 0)
        {
            i = 2;
        }
        return i;
    }

    public int getAdaptersSmartLoadTimeout()
    {
        int j = getSmartLoadTimeoutFromResponse();
        int i = j;
        if (j == 0)
        {
            i = 60;
        }
        return i;
    }

    public int getConsoleLoggerLevel()
    {
        return getLoggerLogLevel("console");
    }

    public int getEventsBackupThreshold()
    {
        return getIntFromEventsSectionOrNegative("backupThreshold");
    }

    public String getEventsUrl()
    {
        return getEventsSettingsSection().optString("serverEventsURL");
    }

    public JSONArray getISProvidersArray()
    {
        return getJSONArrayWithSupersonicAdapter();
    }

    public int getMaxNumberOfEvents()
    {
        return getIntFromEventsSectionOrNegative("maxNumberOfEvents");
    }

    public JSONObject getNextProvider()
    {
label0:
        {
            JSONObject jsonobject;
            try
            {
                mLoadPosition = mLoadPosition + 1;
                if (mProviders.size() <= mLoadPosition)
                {
                    break label0;
                }
                jsonobject = (JSONObject)mProviders.get(mLoadPosition);
            }
            catch (Exception exception)
            {
                SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.INTERNAL, (new StringBuilder()).append("getNextProvider(mLoadPosition: ").append(mLoadPosition).append(" mProviders.size(): ").append(mProviders.size()).append(")").toString(), exception);
                return null;
            }
            return jsonobject;
        }
        return null;
    }

    public JSONArray getOWProvidersArray()
    {
        return getJSONArrayWithSupersonicAdapter();
    }

    public int getPublisherLoggerLevel()
    {
        return getLoggerLogLevel("publisher");
    }

    public JSONArray getRVProvidersArray()
    {
        JSONArray jsonarray = null;
        if (mSettings != null)
        {
            jsonarray = mSettings.optJSONArray("providers");
        }
        JSONArray jsonarray1 = jsonarray;
        if (jsonarray == null)
        {
            jsonarray1 = new JSONArray();
        }
        return jsonarray1;
    }

    public SupersonicError getReponseError()
    {
        if (isValidResponse())
        {
            return null;
        }
        String s1 = "";
        String s = s1;
        if (mSettings != null)
        {
            s = s1;
            if (mSettings.has("error"))
            {
                s = mSettings.optString("error");
            }
        }
        s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        return ErrorBuilder.buildAdapterInitFailedError(s1);
    }

    public int getServerLoggerLevel()
    {
        return getLoggerLogLevel("server");
    }

    public boolean hasMoreProvidersToLoad()
    {
        return mLoadPosition < mProviders.size() && mProviders.size() > 0;
    }

    public boolean isEventsEnabled()
    {
        boolean flag1 = true;
        JSONObject jsonobject;
        boolean flag;
        try
        {
            jsonobject = getEventsSettingsSection();
        }
        catch (Exception exception)
        {
            return true;
        }
        flag = flag1;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        flag = flag1;
        if (jsonobject.has("sendEventsToggle"))
        {
            flag = jsonobject.getBoolean("sendEventsToggle");
        }
        return flag;
    }

    public boolean isValidResponse()
    {
        boolean flag;
        if (true && mSettings != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && !mSettings.has("error"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && getRVProvidersArray() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag && getRVProvidersArray().length() != 0;
    }

    public String toString()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("appKey", mAppKey);
            jsonobject.put("userId", mUserId);
            jsonobject.put("settings", mSettings);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        return jsonobject.toString();
    }
}

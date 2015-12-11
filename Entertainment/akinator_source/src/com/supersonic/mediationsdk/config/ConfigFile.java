// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.config;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigFile
{

    public static final String DEFAULT_AMOUNT_WARNING_MESSAGE = "Rewards amount doesn't exist in configuration, value was set to 1. Edit configurations file in order to change the value";
    public static final int DEFAULT_REWARD_AMOUNT = 1;
    private static ConfigFile mInstance;
    private final String CONFIG_ADAPTERS;
    private final String CONFIG_FILE_DEFAULT_PATH;
    private final String CONFIG_PROVIDER_NAME;
    private final String CONFIG_PROVIDER_SETTINGS;
    private final String CONFIG_PROVIDER_VERSION;
    private final String CONFIG_TEST_FILE;
    private final String CONFIG_TEST_FOLDER;
    protected final String TAG;
    private Map mProvidersConfigMap;

    protected ConfigFile()
    {
        TAG = com/supersonic/mediationsdk/config/ConfigFile.getName();
        CONFIG_ADAPTERS = "adapters";
        CONFIG_PROVIDER_NAME = "name";
        CONFIG_PROVIDER_VERSION = "version";
        CONFIG_PROVIDER_SETTINGS = "settings";
        CONFIG_TEST_FILE = "supersonic.config";
        CONFIG_TEST_FOLDER = "SupersonicTest";
        CONFIG_FILE_DEFAULT_PATH = "/supersonic.config";
    }

    protected ConfigFile(Context context)
    {
        TAG = com/supersonic/mediationsdk/config/ConfigFile.getName();
        CONFIG_ADAPTERS = "adapters";
        CONFIG_PROVIDER_NAME = "name";
        CONFIG_PROVIDER_VERSION = "version";
        CONFIG_PROVIDER_SETTINGS = "settings";
        CONFIG_TEST_FILE = "supersonic.config";
        CONFIG_TEST_FOLDER = "SupersonicTest";
        CONFIG_FILE_DEFAULT_PATH = "/supersonic.config";
        mProvidersConfigMap = parseConfig(readConfig(context));
    }

    public static ConfigFile getConfigFile(Context context)
    {
        com/supersonic/mediationsdk/config/ConfigFile;
        JVM INSTR monitorenter ;
        if (mInstance == null)
        {
            mInstance = new ConfigFile(context);
        }
        context = mInstance;
        com/supersonic/mediationsdk/config/ConfigFile;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private String getExternalConfigFilePath()
    {
        String s;
        boolean flag;
        if (!isExternalStorageReadable())
        {
            break MISSING_BLOCK_LABEL_87;
        }
        s = (new StringBuilder()).append(Environment.getExternalStorageDirectory().toString()).append(File.separator).append("SupersonicTest").append(File.separator).append("supersonic.config").toString();
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        flag = (new File(s)).exists();
        if (flag)
        {
            return s;
        }
        break MISSING_BLOCK_LABEL_87;
        Throwable throwable;
        throwable;
        SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "getExternalConfigFilePath()", throwable);
        return null;
    }

    private boolean isExternalStorageReadable()
    {
        String s = Environment.getExternalStorageState();
        return "mounted".equals(s) || "mounted_ro".equals(s);
    }

    private Map parseConfig(String s)
    {
        HashMap hashmap;
        int i;
        hashmap = new HashMap();
        JSONObject jsonobject;
        try
        {
            s = (new JSONObject(s)).optJSONArray("adapters");
            break MISSING_BLOCK_LABEL_22;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "Please verify that supersonic.config file contains a well formed JSON structure.", null);
        }
          goto _L1
_L6:
        if (i >= s.length()) goto _L1; else goto _L2
_L2:
        jsonobject = (JSONObject)s.get(i);
        if (jsonobject == null || jsonobject == null) goto _L4; else goto _L3
_L3:
        if (!jsonobject.isNull("name"))
        {
            hashmap.put(jsonobject.optString("name"), jsonobject);
        }
          goto _L4
_L1:
        return hashmap;
        if (s == null)
        {
            return hashmap;
        }
        i = 0;
        continue; /* Loop/switch isn't completed */
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String getProviderCoreSdkVersion(String s)
    {
        String s2 = "";
        String s1;
        JSONObject jsonobject;
        try
        {
            jsonobject = (JSONObject)mProvidersConfigMap.get(s);
        }
        catch (Exception exception)
        {
            SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("getProviderCoreSdkVersion(providerName:").append(s).append(")").toString(), exception);
            return "";
        }
        s1 = s2;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        s1 = s2;
        if (jsonobject.has("version"))
        {
            s1 = (String)jsonobject.get("version");
        }
        return s1;
    }

    public JSONObject getProviderJsonSettings(String s)
    {
        Object obj1 = null;
        JSONObject jsonobject = (JSONObject)mProvidersConfigMap.get(s);
        Object obj = obj1;
        if (jsonobject != null)
        {
            try
            {
                obj = (JSONObject)jsonobject.get("settings");
            }
            catch (Throwable throwable)
            {
                SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("getProviderJSONSettings(providerName:").append(s).append(")").toString(), throwable);
                throwable = obj1;
            }
        }
        s = ((String) (obj));
        if (obj == null)
        {
            s = new JSONObject();
        }
        return s;
    }

    public String readConfig(Context context)
    {
        FileInputStream fileinputstream;
        Object obj1;
        fileinputstream = null;
        obj1 = null;
        String s = getExternalConfigFilePath();
        if (s == null) goto _L2; else goto _L1
_L1:
        fileinputstream = new FileInputStream(s);
        Object obj;
        try
        {
            obj = new BufferedReader(new InputStreamReader(fileinputstream));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            continue; /* Loop/switch isn't completed */
        }
_L10:
        if (true && s != null) goto _L4; else goto _L3
_L3:
        obj = context.getAssets().open("supersonic.config");
        context = new BufferedReader(new InputStreamReader(((InputStream) (obj))));
_L13:
        obj1 = new StringBuilder();
_L7:
        s = context.readLine();
        if (s == null) goto _L6; else goto _L5
_L5:
        ((StringBuilder) (obj1)).append(s);
          goto _L7
        context;
_L12:
        SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.API, "supersonic.config not found under assets folder.", null);
        obj = (new JSONObject()).toString();
_L9:
        return ((String) (obj));
_L6:
        obj1 = ((StringBuilder) (obj1)).toString();
        Log.i(TAG, ((String) (obj1)));
        if (fileinputstream == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        fileinputstream.close();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        ((InputStream) (obj)).close();
        obj = obj1;
        if (context == null) goto _L9; else goto _L8
_L8:
        context.close();
        return ((String) (obj1));
        context;
_L11:
        SupersonicLoggerManager.getLogger().logException(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.NATIVE, "readConfig()", context);
        return (new JSONObject()).toString();
        context;
        if (true) goto _L11; else goto _L10
        context;
        if (true) goto _L12; else goto _L4
_L4:
        context = ((Context) (obj));
        obj = obj1;
        if (true) goto _L13; else goto _L2
_L2:
        obj = null;
        if (true) goto _L10; else goto _L14
_L14:
    }
}

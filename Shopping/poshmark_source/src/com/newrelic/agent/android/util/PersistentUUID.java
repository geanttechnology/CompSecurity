// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.newrelic.agent.android.analytics.AnalyticAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class PersistentUUID
{

    public static final String METRIC_UUID_RECOVERED = "UUIDRecovered";
    private static File UUID_FILE = new File(Environment.getDataDirectory(), "nr_installation");
    private static final String UUID_FILENAME = "nr_installation";
    private static final String UUID_KEY = "nr_uuid";
    private static AgentLog log = AgentLogManager.getAgentLog();

    public PersistentUUID(Context context)
    {
        UUID_FILE = new File(context.getFilesDir(), "nr_installation");
    }

    private String generateUniqueID(Context context)
    {
        Object obj;
        obj = Build.SERIAL;
        String s = Build.ID;
        String s1;
        s1 = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_34;
        }
        context = UUID.randomUUID().toString();
        return context;
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        context = ((Context) (obj));
        if (telephonymanager != null)
        {
            try
            {
                context = telephonymanager.getDeviceId();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = "badf00d";
            }
        }
        obj = context;
        try
        {
            if (TextUtils.isEmpty(context))
            {
                obj = (new StringBuilder()).append(Build.HARDWARE).append(Build.DEVICE).append(Build.BOARD).append(Build.BRAND).toString();
            }
            (new StringBuilder()).append(intToHexString(s1.hashCode(), 8)).append("-").append(intToHexString(((String) (obj)).hashCode(), 4)).append("-").append(intToHexString(android.os.Build.VERSION.SDK_INT, 4)).append("-").append(intToHexString(android.os.Build.VERSION.RELEASE.hashCode(), 12)).toString();
            throw new RuntimeException("Not supported (TODO)");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return UUID.randomUUID().toString();
        }
    }

    private String intToHexString(int i, int j)
    {
        String s = "";
        String s1 = Integer.toHexString(i);
        char ac[] = new char[j - s1.length()];
        Arrays.fill(ac, '0');
        String s2 = (new StringBuilder()).append(new String(ac)).append(s1).toString();
        int k = 0;
        for (i = s2.length() - 1; i >= 0; i--)
        {
            k++;
            s1 = (new StringBuilder()).append(s2.substring(i, i + 1)).append(s).toString();
            s = s1;
            if (k % j == 0)
            {
                s = (new StringBuilder()).append("-").append(s1).toString();
            }
        }

        s1 = s;
        if (s.startsWith("-"))
        {
            s1 = s.substring(1, s.length());
        }
        return s1;
    }

    public String getDeviceId(Context context)
    {
        String s = generateUniqueID(context);
        context = s;
        if (TextUtils.isEmpty(s))
        {
            context = UUID.randomUUID().toString();
        }
        return context;
    }

    public String getPersistentUUID()
    {
        String s = getUUIDFromFileStore();
        if (!TextUtils.isEmpty(s))
        {
            noticeUUIDMetric("UUIDRecovered");
            return s;
        } else
        {
            String s1 = UUID.randomUUID().toString();
            log.info((new StringBuilder()).append("Created random UUID: ").append(s1).toString());
            StatsEngine.get().inc("Mobile/App/Install");
            AnalyticAttribute analyticattribute = new AnalyticAttribute("install", true);
            AnalyticsControllerImpl.getInstance().addAttributeUnchecked(analyticattribute, false);
            setPersistedUUID(s1);
            return s1;
        }
    }

    protected String getUUIDFromFileStore()
    {
        Object obj;
        Object obj2;
        String s;
        Object obj4;
        Object obj5;
        Object obj6;
        s = "";
        obj = s;
        if (!UUID_FILE.exists())
        {
            break MISSING_BLOCK_LABEL_76;
        }
        obj4 = null;
        obj5 = null;
        obj6 = null;
        obj = null;
        obj2 = null;
        Object obj1 = new BufferedReader(new FileReader(UUID_FILE));
        obj2 = (new JSONObject(((BufferedReader) (obj1)).readLine())).getString("nr_uuid");
        obj = obj2;
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                log.error(((IOException) (obj)).getMessage());
                return ((String) (obj2));
            }
            obj = obj2;
        }
_L2:
        return ((String) (obj));
        obj;
        obj1 = obj2;
        obj2 = obj;
_L11:
        obj = obj1;
        log.error(((FileNotFoundException) (obj2)).getMessage());
        obj = s;
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            log.error(((IOException) (obj)).getMessage());
            return "";
        }
        return "";
        Object obj3;
        obj3;
        obj1 = obj4;
_L10:
        obj = obj1;
        log.error(((IOException) (obj3)).getMessage());
        obj = s;
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            log.error(((IOException) (obj)).getMessage());
            return "";
        }
        return "";
        obj3;
        obj1 = obj5;
_L9:
        obj = obj1;
        log.error(((JSONException) (obj3)).getMessage());
        obj = s;
        if (obj1 == null) goto _L2; else goto _L4
_L4:
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            log.error(((IOException) (obj)).getMessage());
            return "";
        }
        return "";
        obj3;
        obj1 = obj6;
_L8:
        obj = obj1;
        log.error(((NullPointerException) (obj3)).getMessage());
        obj = s;
        if (obj1 == null) goto _L2; else goto _L5
_L5:
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            log.error(((IOException) (obj)).getMessage());
            return "";
        }
        return "";
        obj1;
_L7:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                log.error(((IOException) (obj)).getMessage());
            }
        }
        throw obj1;
        obj3;
        obj = obj1;
        obj1 = obj3;
        if (true) goto _L7; else goto _L6
_L6:
        obj3;
          goto _L8
        obj3;
          goto _L9
        obj3;
          goto _L10
        obj3;
          goto _L11
    }

    protected void noticeUUIDMetric(String s)
    {
        StatsEngine statsengine = StatsEngine.get();
        if (statsengine != null)
        {
            statsengine.inc((new StringBuilder()).append("Supportability/AgentHealth/").append(s).toString());
            return;
        } else
        {
            log.error((new StringBuilder()).append("StatsEngine is null. ").append(s).append("  not recorded.").toString());
            return;
        }
    }

    protected void putUUIDToFileStore(String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj2 = null;
        obj3 = null;
        obj1 = null;
        obj = obj3;
        JSONObject jsonobject = new JSONObject();
        obj = obj3;
        jsonobject.put("nr_uuid", s);
        obj = obj3;
        s = new BufferedWriter(new FileWriter(UUID_FILE));
        s.write(jsonobject.toString());
        s.flush();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        s.close();
_L2:
        return;
        s;
        log.error(s.getMessage());
        return;
        obj;
        s = ((String) (obj1));
        obj1 = obj;
_L7:
        obj = s;
        log.error(((IOException) (obj1)).getMessage());
        if (s == null) goto _L2; else goto _L1
_L1:
        try
        {
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error(s.getMessage());
        }
        return;
        JSONException jsonexception;
        jsonexception;
        s = obj2;
_L6:
        obj = s;
        log.error(jsonexception.getMessage());
        if (s == null) goto _L2; else goto _L3
_L3:
        try
        {
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error(s.getMessage());
        }
        return;
        s;
_L5:
        if (obj != null)
        {
            try
            {
                ((BufferedWriter) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                log.error(((IOException) (obj)).getMessage());
            }
        }
        throw s;
        jsonexception;
        obj = s;
        s = jsonexception;
        if (true) goto _L5; else goto _L4
_L4:
        jsonexception;
          goto _L6
        jsonexception;
          goto _L7
    }

    protected void setPersistedUUID(String s)
    {
        putUUIDToFileStore(s);
    }

}

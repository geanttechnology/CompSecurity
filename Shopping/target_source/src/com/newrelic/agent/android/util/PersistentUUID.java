// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
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
        context = (TelephonyManager)context.getSystemService("phone");
        if (context != null)
        {
            try
            {
                context = context.getDeviceId();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context = "badf00d";
            }
        } else
        {
            context = ((Context) (obj));
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
        String s = Integer.toHexString(i);
        char ac[] = new char[j - s.length()];
        Arrays.fill(ac, '0');
        String s3 = (new StringBuilder()).append(new String(ac)).append(s).toString();
        i = s3.length();
        s = "";
        int k = 0;
        for (i--; i >= 0; i--)
        {
            k++;
            String s1 = (new StringBuilder()).append(s3.substring(i, i + 1)).append(s).toString();
            s = s1;
            if (k % j == 0)
            {
                s = (new StringBuilder()).append("-").append(s1).toString();
            }
        }

        String s2 = s;
        if (s.startsWith("-"))
        {
            s2 = s.substring(1, s.length());
        }
        return s2;
    }

    private void noticeUUIDMetric(String s)
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
            setPersistedUUID(s1);
            return s1;
        }
    }

    protected String getUUIDFromFileStore()
    {
        String s = "";
        if (UUID_FILE.exists())
        {
            try
            {
                s = (new JSONObject((new BufferedReader(new FileReader(UUID_FILE))).readLine())).getString("nr_uuid");
            }
            catch (FileNotFoundException filenotfoundexception)
            {
                log.error(filenotfoundexception.getMessage());
                return "";
            }
            catch (IOException ioexception)
            {
                log.error(ioexception.getMessage());
                return "";
            }
            catch (JSONException jsonexception)
            {
                log.error(jsonexception.getMessage());
                return "";
            }
        }
        return s;
    }

    protected void putUUIDToFileStore(String s)
    {
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("nr_uuid", s);
            s = new BufferedWriter(new FileWriter(UUID_FILE));
            s.write(jsonobject.toString());
            s.flush();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error(s.getMessage());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error(s.getMessage());
        }
    }

    protected void setPersistedUUID(String s)
    {
        putUUIDToFileStore(s);
    }

}

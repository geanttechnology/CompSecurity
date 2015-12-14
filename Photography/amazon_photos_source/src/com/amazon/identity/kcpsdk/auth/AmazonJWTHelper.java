// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public final class AmazonJWTHelper
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/AmazonJWTHelper.getName();

    private AmazonJWTHelper()
    {
    }

    static JSONObject deviceInfo(String s, String s1, String s2)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("typ", "v1");
        jsonobject.put("dt", s);
        jsonobject.put("dsn", s1);
        if (!TextUtils.isEmpty(s2))
        {
            jsonobject.put("ds", s2);
        }
        jsonobject.put("cpuid", getCPUId());
        return jsonobject;
    }

    static String getCPUId()
    {
        Object obj;
        Object obj2;
        String s;
        obj = null;
        s = null;
        obj2 = null;
        Object obj1 = new BufferedReader(new FileReader("/proc/cpuinfo"));
_L2:
        s = ((BufferedReader) (obj1)).readLine();
        obj = obj2;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        if (!s.startsWith("Serial")) goto _L2; else goto _L1
_L1:
        obj = s.split(":")[1].trim();
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            MAPLog.e(TAG, "Error closing bufferReader in getCPUId()!", ((Throwable) (obj1)));
        }
        return ((String) (obj));
        Object obj3;
        obj3;
        obj1 = s;
_L6:
        obj = obj1;
        recordErrorMetric((new StringBuilder("GetCPUInfoFailed:")).append(obj3.getClass().getSimpleName()).toString());
        obj = obj1;
        MAPLog.e(TAG, "Exception thrown when getting the serial number(cpuId)", ((Throwable) (obj3)));
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MAPLog.e(TAG, "Error closing bufferReader in getCPUId()!", ((Throwable) (obj)));
            }
        }
        return null;
        obj1;
_L4:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MAPLog.e(TAG, "Error closing bufferReader in getCPUId()!", ((Throwable) (obj)));
            }
        }
        throw obj1;
        obj3;
        obj = obj1;
        obj1 = obj3;
        if (true) goto _L4; else goto _L3
_L3:
        obj3;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static JSONObject getRegistrationPayload(JSONObject jsonobject, JSONObject jsonobject1, String s)
    {
        JSONObject jsonobject2;
        jsonobject2 = new JSONObject();
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_41;
        }
        jsonobject2.put("dat", s);
_L1:
        jsonobject2.put("dev", jsonobject);
        jsonobject2.put("cust", jsonobject1);
        return jsonobject2;
        try
        {
            s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.US);
            s.setTimeZone(TimeZone.getTimeZone("UTC"));
            jsonobject2.put("dat", s.format(new Date()));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new RuntimeException(jsonobject);
        }
          goto _L1
    }

    static JSONObject newCustInfo()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("typ", "v1");
        return jsonobject;
    }

    static void recordErrorMetric(String s)
    {
        MetricsHelper.incrementCounter((new StringBuilder("GenerateJWTFailure:")).append(s).toString(), new String[0]);
    }

}

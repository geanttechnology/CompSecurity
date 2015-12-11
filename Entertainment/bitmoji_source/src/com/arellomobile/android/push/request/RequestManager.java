// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.arellomobile.android.push.utils.JsonUtils;
import com.arellomobile.android.push.utils.PreferenceUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class RequestManager
{
    public static class NetworkResult
    {

        private int mPushwooshCode;
        private int mResultCode;
        private JSONObject mResultData;

        public int getPushwooshCode()
        {
            return mPushwooshCode;
        }

        public int getResultCode()
        {
            return mResultCode;
        }

        public JSONObject getResultData()
        {
            return mResultData;
        }

        public void setCode(int i)
        {
            mResultCode = i;
        }

        public void setData(JSONObject jsonobject)
        {
            mResultData = jsonobject;
        }

        public void setPushwooshCode(int i)
        {
            mPushwooshCode = i;
        }

        public NetworkResult(int i, int j, JSONObject jsonobject)
        {
            mResultCode = i;
            mPushwooshCode = j;
            mResultData = jsonobject;
        }
    }


    private static final String BASE_URL = "http://cp.pushwoosh.com/json/1.3/";
    private static final String BASE_URL_SECURE = "https://cp.pushwoosh.com/json/1.3/";
    public static final int MAX_TRIES = 1;
    private static final String META_NAME_PUSHWOOSH_URL = "PushwooshUrl";
    private static final String TAG = "Pushwoosh: Request manager";
    public static boolean useSSL = false;

    public RequestManager()
    {
    }

    private static String getDefaultUrl(Context context)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = context.getPackageManager();
        obj1 = ((PackageManager) (obj1)).getApplicationInfo(context.getPackageName(), 128).metaData;
label0:
        {
            context = ((Context) (obj));
            if (obj1 != null)
            {
                try
                {
                    context = ((Bundle) (obj1)).getString("PushwooshUrl");
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context = ((Context) (obj));
                }
            }
            obj = context;
            if (TextUtils.isEmpty(context))
            {
                if (!useSSL)
                {
                    break label0;
                }
                obj = "https://cp.pushwoosh.com/json/1.3/";
            }
            return ((String) (obj));
        }
        return "http://cp.pushwoosh.com/json/1.3/";
    }

    private static NetworkResult makeRequest(Context context, Map map, String s)
        throws Exception
    {
        byte abyte0[];
        NetworkResult networkresult;
        abyte0 = null;
        networkresult = new NetworkResult(500, 0, null);
        Object obj1 = PreferenceUtils.getBaseUrl(context);
        Object obj = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj = getDefaultUrl(context);
        }
        obj1 = obj;
        if (!((String) (obj)).endsWith("/"))
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("/").toString();
        }
        PreferenceUtils.setBaseUrl(context, ((String) (obj1)));
        obj = (HttpURLConnection)(new URL((new StringBuilder()).append(((String) (obj1))).append(s).toString())).openConnection();
        ((HttpURLConnection) (obj)).setRequestMethod("POST");
        ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", "application/json; charset=utf-8");
        ((HttpURLConnection) (obj)).setDoOutput(true);
        s = new JSONObject();
        s.put("request", JsonUtils.mapToJson(map));
        ((HttpURLConnection) (obj)).setRequestProperty("Content-Length", String.valueOf(s.toString().getBytes().length));
        map = ((HttpURLConnection) (obj)).getOutputStream();
        map.write(s.toString().getBytes());
        map.flush();
        map.close();
        s = new BufferedInputStream(((HttpURLConnection) (obj)).getInputStream());
        obj1 = new ByteArrayOutputStream();
        abyte0 = new byte[1024];
_L3:
        int i = s.read(abyte0);
        if (i < 0) goto _L2; else goto _L1
_L1:
        ((ByteArrayOutputStream) (obj1)).write(abyte0, 0, i);
          goto _L3
        context;
_L5:
        if (s != null)
        {
            s.close();
        }
        if (map != null)
        {
            map.close();
        }
        throw context;
_L2:
        ((ByteArrayOutputStream) (obj1)).close();
        obj1 = (new String(((ByteArrayOutputStream) (obj1)).toByteArray())).trim();
        Log.w("Pushwoosh: Request manager", (new StringBuilder()).append("PushWooshResult: ").append(((String) (obj1))).toString());
        obj1 = new JSONObject(((String) (obj1)));
        networkresult.setData(((JSONObject) (obj1)));
        networkresult.setCode(((HttpURLConnection) (obj)).getResponseCode());
        networkresult.setPushwooshCode(((JSONObject) (obj1)).getInt("status_code"));
        if (s != null)
        {
            s.close();
        }
        if (map != null)
        {
            map.close();
        }
        return networkresult;
        Exception exception;
        exception;
        PreferenceUtils.setBaseUrl(context, getDefaultUrl(context));
        throw exception;
        context;
        map = null;
        s = abyte0;
        continue; /* Loop/switch isn't completed */
        context;
        s = abyte0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void sendRequest(Context context, PushRequest pushrequest)
        throws Exception
    {
        NetworkResult networkresult;
        Object obj;
        Map map;
        int i;
        map = pushrequest.getParams(context);
        Log.w("Pushwoosh: Request manager", (new StringBuilder()).append("Try To sent: ").append(pushrequest.getMethod()).toString());
        networkresult = new NetworkResult(500, 0, null);
        obj = null;
        i = 0;
_L10:
        if (i >= 1) goto _L2; else goto _L1
_L1:
        NetworkResult networkresult1;
        int j;
        try
        {
            networkresult1 = makeRequest(context, map, pushrequest.getMethod());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            break; /* Loop/switch isn't completed */
        }
        networkresult = networkresult1;
        if (200 == networkresult1.getResultCode()) goto _L4; else goto _L3
_L3:
        networkresult = networkresult1;
          goto _L5
_L4:
        networkresult = networkresult1;
        j = networkresult1.getPushwooshCode();
        if (200 == j) goto _L7; else goto _L6
_L6:
        context = networkresult1;
_L8:
        pushrequest = ((PushRequest) (obj));
        if (obj == null)
        {
            pushrequest = "";
            if (context.getResultData() != null)
            {
                pushrequest = context.getResultData().toString();
            }
            pushrequest = new Exception(pushrequest);
        }
        Log.e("Pushwoosh: Request manager", (new StringBuilder()).append("ERROR: ").append(pushrequest.getMessage()).append(". Response = ").append(context.getResultData()).toString(), pushrequest);
        throw pushrequest;
_L7:
        networkresult = networkresult1;
        Log.w("Pushwoosh: Request manager", (new StringBuilder()).append(pushrequest.getMethod()).append(" response success").toString());
        networkresult = networkresult1;
        obj = networkresult1.getResultData();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        networkresult = networkresult1;
        if (!((JSONObject) (obj)).has("base_url"))
        {
            break MISSING_BLOCK_LABEL_263;
        }
        networkresult = networkresult1;
        PreferenceUtils.setBaseUrl(context, ((JSONObject) (obj)).optString("base_url"));
        networkresult = networkresult1;
        pushrequest.parseResponse(((JSONObject) (obj)));
        return;
_L2:
        context = networkresult;
        if (true) goto _L8; else goto _L5
_L5:
        i++;
        if (true) goto _L10; else goto _L9
_L9:
    }

}

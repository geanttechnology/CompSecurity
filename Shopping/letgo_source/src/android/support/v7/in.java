// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            aqo

public class in
{

    public static int a(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            return 0;
        }
        int i;
        try
        {
            i = jsonobject.getInt(s);
        }
        catch (JSONException jsonexception)
        {
            a(jsonobject, s, jsonexception, false);
            return 0;
        }
        return i;
    }

    public static String a(Context context, int i)
    {
        return a(context.getResources().openRawResource(i));
    }

    private static String a(InputStream inputstream)
    {
        Object obj;
        Object obj1;
        StringBuffer stringbuffer;
        obj1 = null;
        obj = null;
        stringbuffer = new StringBuffer();
        if (inputstream != null) goto _L2; else goto _L1
_L1:
        return ((String) (obj));
_L2:
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
_L3:
        inputstream = bufferedreader.readLine();
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        stringbuffer.append(inputstream).append("\n");
          goto _L3
        inputstream;
        aqo.b(inputstream, "getJsonStringFromIS", new Object[0]);
        if (bufferedreader == null) goto _L1; else goto _L4
_L4:
        try
        {
            bufferedreader.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            Log.e("JsonTools", "Error closing stream", inputstream);
            return null;
        }
        return null;
        int i = stringbuffer.length();
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        inputstream = obj1;
_L6:
        obj = inputstream;
        if (bufferedreader == null) goto _L1; else goto _L5
_L5:
        try
        {
            bufferedreader.close();
        }
        catch (IOException ioexception)
        {
            Log.e("JsonTools", "Error closing stream", ioexception);
            return inputstream;
        }
        return inputstream;
        inputstream = stringbuffer.toString();
          goto _L6
        inputstream;
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            catch (IOException ioexception1)
            {
                Log.e("JsonTools", "Error closing stream", ioexception1);
            }
        }
        throw inputstream;
    }

    public static String a(URL url)
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
        String s;
        httpurlconnection.setRequestMethod("GET");
        httpurlconnection.connect();
        if (httpurlconnection.getResponseCode() != 200)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        s = a(httpurlconnection.getInputStream());
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        Log.d("JsonTools", (new StringBuilder()).append("json string ").append(s).toString());
        return s;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        return null;
        IOException ioexception;
        ioexception;
        httpurlconnection = null;
_L4:
        Log.e("JsonTools", (new StringBuilder()).append("queryForResultBatches url : ").append(url.toString()).toString(), ioexception);
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        return null;
        url;
        httpurlconnection = null;
_L2:
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        throw url;
        url;
        continue; /* Loop/switch isn't completed */
        url;
        if (true) goto _L2; else goto _L1
_L1:
        ioexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void a(JSONObject jsonobject, String s, JSONException jsonexception, boolean flag)
    {
        if (flag)
        {
            aqo.b(jsonexception, "Error finding field %s in JSONObject %s", new Object[] {
                s, jsonobject.toString()
            });
            return;
        } else
        {
            aqo.d("Error finding field %s in JSONObject %s", new Object[] {
                s, jsonobject.toString()
            });
            return;
        }
    }

    public static Double b(JSONObject jsonobject, String s)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (!jsonobject.has(s)) goto _L1; else goto _L3
_L3:
        double d1 = jsonobject.getDouble(s);
        return Double.valueOf(d1);
        JSONException jsonexception;
        jsonexception;
        a(jsonobject, s, jsonexception, true);
        return null;
    }

    public static String c(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = jsonobject.getString(s);
        }
        catch (JSONException jsonexception)
        {
            a(jsonobject, s, jsonexception, false);
            return null;
        }
        return s1;
    }

    public static JSONObject d(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            return null;
        }
        JSONObject jsonobject1;
        try
        {
            jsonobject1 = jsonobject.getJSONObject(s);
        }
        catch (JSONException jsonexception)
        {
            a(jsonobject, s, jsonexception, false);
            return null;
        }
        return jsonobject1;
    }

    public static boolean e(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = jsonobject.getBoolean(s);
        }
        catch (JSONException jsonexception)
        {
            a(jsonobject, s, jsonexception, false);
            return false;
        }
        return flag;
    }

    public static JSONArray f(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            return null;
        }
        JSONArray jsonarray;
        try
        {
            jsonarray = jsonobject.getJSONArray(s);
        }
        catch (JSONException jsonexception)
        {
            a(jsonobject, s, jsonexception, false);
            return null;
        }
        return jsonarray;
    }
}

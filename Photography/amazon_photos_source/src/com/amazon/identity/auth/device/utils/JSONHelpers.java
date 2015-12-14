// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog, StreamUtils

public final class JSONHelpers
{

    private static final String TAG = com/amazon/identity/auth/device/utils/JSONHelpers.getName();

    private JSONHelpers()
    {
    }

    public static String addNewItemToJsonArray(String s, String s1)
    {
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = new JSONArray(s);
        int i = 0;
_L5:
        Object obj = jsonarray;
        if (i < jsonarray.length())
        {
            JSONException jsonexception;
            if (s1.equals(jsonarray.get(i)))
            {
                return s;
            }
            i++;
            continue; /* Loop/switch isn't completed */
        }
          goto _L3
_L2:
        try
        {
            obj = new JSONArray();
        }
        // Misplaced declaration of an exception variable
        catch (JSONException jsonexception)
        {
            MAPLog.w(TAG, "Error occurred while trying to create jsonArray from input string.");
            jsonexception = TAG;
            (new StringBuilder("jsonArray input:")).append(s).toString();
            jsonexception = new JSONArray();
        }
_L3:
        ((JSONArray) (obj)).put(s1);
        return ((JSONArray) (obj)).toString();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static JSONObject getJSONObject(JSONObject jsonobject, String s)
    {
        if (!jsonobject.has(s))
        {
            break MISSING_BLOCK_LABEL_43;
        }
        jsonobject = jsonobject.getJSONObject(s);
        return jsonobject;
        jsonobject;
        MAPLog.i(TAG, String.format("Problem parsing JSON for key %s. Error: %s", new Object[] {
            s, jsonobject.getMessage()
        }));
        return null;
    }

    public static String getJsonOfList(List list)
    {
        return (new JSONArray(list)).toString();
    }

    public static Set getSetFromJSONArray(String s)
    {
        HashSet hashset = new HashSet();
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray = new JSONArray(s);
        int i = 0;
_L3:
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        hashset.add((String)jsonarray.get(i));
        i++;
        if (true) goto _L3; else goto _L2
        JSONException jsonexception;
        jsonexception;
        MAPLog.e(TAG, "Error occurred while trying to convert jsonArray string to Set.");
        String s1 = TAG;
        (new StringBuilder("jsonArray input:")).append(s).toString();
_L2:
        return hashset;
    }

    public static String getStringOrDefault(JSONObject jsonobject, String s, String s1)
    {
        String s2 = s1;
        if (jsonobject.has(s))
        {
            s2 = s1;
            try
            {
                if (!jsonobject.isNull(s))
                {
                    s2 = jsonobject.getString(s);
                }
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                MAPLog.i(TAG, String.format("Problem parsing JSON for key %s. Error: %s", new Object[] {
                    s, jsonobject.getMessage()
                }));
                return s1;
            }
        }
        return s2;
    }

    public static JSONObject toJson(HttpURLConnection httpurlconnection)
        throws JSONException
    {
        Object obj;
        Object obj1;
        boolean flag;
        obj = null;
        flag = false;
        obj1 = obj;
        Object obj2 = httpurlconnection.getInputStream();
        obj = obj2;
_L6:
        if (obj != null) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpURLConnection httpurlconnection)
            {
                MAPLog.e(TAG, "IOException thrown closing input stream");
                return null;
            }
        }
_L4:
        return null;
        obj1;
        flag = true;
        obj1 = obj;
        obj = httpurlconnection.getErrorStream();
        continue; /* Loop/switch isn't completed */
_L2:
        obj1 = obj;
        obj2 = new String(StreamUtils.readInputStream(((InputStream) (obj))));
        obj1 = obj;
        String s = TAG;
        obj1 = obj;
        httpurlconnection.getURL().toString();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj1 = obj;
        s = TAG;
        obj1 = obj;
        httpurlconnection.getURL().toString();
        obj1 = obj;
        Integer.toString(httpurlconnection.getResponseCode());
        obj1 = obj;
        httpurlconnection = new JSONObject(((String) (obj2)));
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MAPLog.e(TAG, "IOException thrown closing input stream");
            }
        }
        return httpurlconnection;
        httpurlconnection;
        obj1 = obj;
        MAPLog.e(TAG, "Could not parse response because of network issue", httpurlconnection);
        if (obj == null) goto _L4; else goto _L3
_L3:
        try
        {
            ((InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            MAPLog.e(TAG, "IOException thrown closing input stream");
            return null;
        }
        return null;
        httpurlconnection;
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            catch (IOException ioexception)
            {
                MAPLog.e(TAG, "IOException thrown closing input stream");
            }
        }
        throw httpurlconnection;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static String toJsonString(Map map)
    {
        ArrayList arraylist = new ArrayList();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); arraylist.add(String.format("\"%s\":\"%s\"", new Object[] {
    entry.getKey(), entry.getValue()
})))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return String.format("{%s}", new Object[] {
            TextUtils.join(", ", arraylist)
        });
    }

}

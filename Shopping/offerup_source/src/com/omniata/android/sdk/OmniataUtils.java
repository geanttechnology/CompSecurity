// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.omniata.android.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

class OmniataUtils
{

    static String API = "api.omniata.com";
    static String BASE_API_URL = "omniata.com";
    static String CHANNEL_API = "";
    static String EVENT_API = "";
    static String TEST_API = "api-test.omniata.com";
    static String TEST_EVENT_API = "";

    OmniataUtils()
    {
    }

    static void assertApiKeyValid(String s)
    {
        if (s == null || s == "")
        {
            throw new IllegalArgumentException("API key is invalid");
        } else
        {
            return;
        }
    }

    static void assertUserIdValid(String s)
    {
        if (s == null || s == "")
        {
            throw new IllegalArgumentException("API key is invalid");
        } else
        {
            return;
        }
    }

    static void assertValidEventType(String s)
    {
        if (s == null || s == "")
        {
            throw new IllegalArgumentException("Event Type is invalid");
        } else
        {
            return;
        }
    }

    static String convertStreamToString(InputStream inputstream)
    {
        Scanner scanner = new Scanner(inputstream);
        scanner.useDelimiter("\\A");
        if (scanner.hasNext())
        {
            inputstream = scanner.next();
        } else
        {
            inputstream = "";
        }
        scanner.close();
        return inputstream;
    }

    static String getChannelAPI(boolean flag)
    {
        return (new StringBuilder()).append(getProtocol(flag)).append(CHANNEL_API).append("/channel").toString();
    }

    static String getEventAPI(boolean flag, boolean flag1)
    {
        if (flag1)
        {
            return (new StringBuilder()).append(getProtocol(false)).append(TEST_EVENT_API).append("/event").toString();
        } else
        {
            return (new StringBuilder()).append(getProtocol(flag)).append(EVENT_API).append("/event").toString();
        }
    }

    static String getProtocol(boolean flag)
    {
        if (flag)
        {
            return "https://";
        } else
        {
            return "http://";
        }
    }

    static boolean isConnected(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return context != null && context.isConnected();
    }

    static String jsonToQueryString(JSONObject jsonobject)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = jsonobject.keys();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        Object obj;
        try
        {
            obj = jsonobject.get(s);
        }
        catch (JSONException jsonexception)
        {
            jsonexception = "";
        }
        stringbuilder.append(URLEncoder.encode(s, "UTF-8"));
        stringbuilder.append("=");
        stringbuilder.append(URLEncoder.encode(obj.toString(), "UTF-8"));
        stringbuilder.append("&");
        if (true) goto _L2; else goto _L1
        jsonobject;
        System.out.println(jsonobject);
_L1:
        return stringbuilder.substring(0, stringbuilder.length() - 1);
    }

    static JSONObject mergeJSON(JSONObject jsonobject, JSONObject jsonobject1)
    {
        JSONObject jsonobject2 = new JSONObject();
        Iterator iterator1 = jsonobject.keys();
        Iterator iterator = jsonobject1.keys();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            String s = (String)iterator1.next();
            try
            {
                if (!jsonobject1.has(s))
                {
                    jsonobject2.put(s, jsonobject.get(s));
                }
            }
            catch (Exception exception) { }
        } while (true);
        while (iterator.hasNext()) 
        {
            jsonobject = (String)iterator.next();
            try
            {
                jsonobject2.put(jsonobject, jsonobject1.get(jsonobject));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject) { }
        }
        return jsonobject2;
    }

    public static void setURL(String s)
    {
        EVENT_API = (new StringBuilder()).append(s).append(".analyzer.").append(BASE_API_URL).toString();
        CHANNEL_API = (new StringBuilder()).append(s).append(".engager.").append(BASE_API_URL).toString();
    }

}

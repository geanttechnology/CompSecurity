// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth.register;

import android.os.Build;
import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth.register:
//            PandaTokenExchangeRequest

public class PandaTokenExchangeRequestBuilder
{

    public static final String TAG = com/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeRequestBuilder.getCanonicalName();
    private String mAccessToken;
    private String mAppName;
    private String mAppVersion;
    private String mCookieDomain;
    private Map mExistingCookies;

    public PandaTokenExchangeRequestBuilder()
    {
        mExistingCookies = new HashMap();
    }

    public PandaTokenExchangeRequestBuilder addExistingCookie(String s, String s1)
    {
        mExistingCookies.put(s, s1);
        return this;
    }

    public PandaTokenExchangeRequest build()
    {
        Object obj;
        JSONObject jsonobject;
        JSONObject jsonobject1;
        JSONArray jsonarray;
        obj = new LinkedList();
        if (TextUtils.isEmpty(mAccessToken))
        {
            ((List) (obj)).add("AccessToken");
        }
        if (TextUtils.isEmpty(mCookieDomain))
        {
            ((List) (obj)).add("CookieDomain");
        }
        boolean flag;
        if (!((List) (obj)).isEmpty())
        {
            obj = (new StringBuilder("Missing arguments for Panda: ")).append(TextUtils.join(",", ((Iterable) (obj)))).toString();
            MAPLog.e(TAG, ((String) (obj)));
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            return null;
        }
        try
        {
            obj = new JSONObject();
            jsonobject1 = new JSONObject();
            jsonobject1.put("access_token", mAccessToken);
            jsonobject = new JSONObject();
            jsonobject.put("bearer", jsonobject1);
            jsonobject1 = new JSONObject();
            jsonobject1.put("token_type", "bearer");
            jsonarray = new JSONArray();
            JSONObject jsonobject3;
            for (Iterator iterator = mExistingCookies.entrySet().iterator(); iterator.hasNext(); jsonarray.put(jsonobject3))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                jsonobject3 = new JSONObject();
                jsonobject3.put("Name", entry.getKey());
                jsonobject3.put("Value", entry.getValue());
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MAPLog.e(TAG, (new StringBuilder("Error creating JSON request: ")).append(((JSONException) (obj)).getMessage()).toString());
            return null;
        }
        JSONObject jsonobject2 = new JSONObject();
        jsonobject2.put("domain", mCookieDomain);
        jsonobject2.put("existing_cookies", jsonarray);
        jsonarray = new JSONArray();
        jsonarray.put(jsonobject2);
        jsonobject2 = new JSONObject();
        jsonobject2.put("token_type", "website_cookies");
        jsonobject2.put("website_cookies", jsonarray);
        jsonarray = new JSONArray();
        jsonarray.put(jsonobject1);
        jsonarray.put(jsonobject2);
        ((JSONObject) (obj)).put("source_tokens", jsonobject);
        ((JSONObject) (obj)).put("requested_token_types", jsonarray);
        ((JSONObject) (obj)).put("device_hw_version", Build.MODEL);
        ((JSONObject) (obj)).put("device_os_version", Build.FINGERPRINT);
        ((JSONObject) (obj)).put("device_sdk_version", Integer.toString(android.os.Build.VERSION.SDK_INT));
        ((JSONObject) (obj)).put("device_os_name", "android");
        ((JSONObject) (obj)).putOpt("app_name", mAppName);
        ((JSONObject) (obj)).putOpt("app_version", mAppVersion);
        obj = new PandaTokenExchangeRequest(((JSONObject) (obj)));
        return ((PandaTokenExchangeRequest) (obj));
    }

    public PandaTokenExchangeRequestBuilder setAccessToken(String s)
    {
        mAccessToken = s;
        return this;
    }

    public PandaTokenExchangeRequestBuilder setAppName(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            mAppName = s;
        }
        return this;
    }

    public PandaTokenExchangeRequestBuilder setAppVersion(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            mAppVersion = s;
        }
        return this;
    }

    public PandaTokenExchangeRequestBuilder setCookieDomain(String s)
    {
        mCookieDomain = s;
        return this;
    }

}

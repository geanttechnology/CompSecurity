// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth.register;

import android.text.TextUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class PandaTokenExchangeResponse
{

    public static final String TAG = com/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse.getCanonicalName();
    private String mAccessToken;
    private String mDomain;
    private Map mDomainToCookies;
    private int mExpiry;
    private String mRefreshToken;

    private PandaTokenExchangeResponse()
    {
        mDomainToCookies = new HashMap();
    }

    public static PandaTokenExchangeResponse parse(String s)
    {
        s = new JSONObject(s);
        PandaTokenExchangeResponse pandatokenexchangeresponse = new PandaTokenExchangeResponse();
        Object obj = new LinkedList();
        Object obj1 = s.optJSONObject("bearer");
        if (obj1 == null)
        {
            ((List) (obj)).add("bearer");
        } else
        {
            int i = ((JSONObject) (obj1)).optInt("expires_in", -1);
            String s2;
            if (i < 0)
            {
                ((List) (obj)).add("bearer.expires_in");
            } else
            {
                pandatokenexchangeresponse.mExpiry = i;
            }
            s2 = ((JSONObject) (obj1)).optString("access_token");
            if (TextUtils.isEmpty(s2))
            {
                ((List) (obj)).add("bearer.access_token");
            } else
            {
                pandatokenexchangeresponse.mAccessToken = s2;
            }
            obj1 = ((JSONObject) (obj1)).optString("refresh_token");
            if (TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                ((List) (obj)).add("bearer.refresh_token");
            } else
            {
                pandatokenexchangeresponse.mRefreshToken = ((String) (obj1));
            }
        }
        s = s.optJSONArray("website_cookies");
        if (s == null || s.length() <= 0)
        {
            ((List) (obj)).add("website_cookies");
        } else
        {
            if (s.length() > 1)
            {
                MAPLog.w(TAG, "Panda returned more than one domain's cookies. Using first in list.");
            }
            int j = 0;
            while (j <= 0) 
            {
                Object obj2 = s.optJSONObject(j);
                if (obj2 == null)
                {
                    ((List) (obj)).add((new StringBuilder("website_cookies.cookiesObject")).append(j).toString());
                } else
                {
                    String s1 = ((JSONObject) (obj2)).optString("domain");
                    if (TextUtils.isEmpty(s1))
                    {
                        ((List) (obj)).add((new StringBuilder("website_cookies.cookiesObject")).append(j).append(".domain").toString());
                    } else
                    {
                        pandatokenexchangeresponse.mDomain = s1;
                        obj2 = ((JSONObject) (obj2)).optJSONArray("cookies");
                        if (obj2 == null || ((JSONArray) (obj2)).length() <= 0)
                        {
                            ((List) (obj)).add((new StringBuilder("website_cookies.cookiesObject")).append(j).append(".cookiesArray").toString());
                        } else
                        {
                            pandatokenexchangeresponse.mDomainToCookies.put(s1, obj2);
                        }
                    }
                }
                j++;
            }
        }
        s = pandatokenexchangeresponse;
        if (!((List) (obj)).isEmpty())
        {
            MAPLog.w(TAG, (new StringBuilder("Missing values from Panda: ")).append(TextUtils.join(",", ((Iterable) (obj)))).toString());
            obj = ((List) (obj)).iterator();
            do
            {
                s = pandatokenexchangeresponse;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                s = (String)((Iterator) (obj)).next();
                MetricsHelper.incrementCounter((new StringBuilder("ExchangeTokenResponseMissing:")).append(s).toString(), new String[0]);
            } while (true);
        }
        break MISSING_BLOCK_LABEL_192;
        s;
        MAPLog.e(TAG, (new StringBuilder("Invalid JSON from Panda: ")).append(s.getMessage()).toString());
        s = null;
        return s;
    }

    public String getAccessToken()
    {
        return mAccessToken;
    }

    public JSONArray getCookies()
    {
        JSONArray jsonarray;
        if (mDomain == null)
        {
            jsonarray = new JSONArray();
        } else
        {
            JSONArray jsonarray1 = (JSONArray)mDomainToCookies.get(mDomain);
            jsonarray = jsonarray1;
            if (jsonarray1 == null)
            {
                return new JSONArray();
            }
        }
        return jsonarray;
    }

    public int getExpirySeconds()
    {
        return mExpiry;
    }

    public String getRefreshToken()
    {
        return mRefreshToken;
    }

}

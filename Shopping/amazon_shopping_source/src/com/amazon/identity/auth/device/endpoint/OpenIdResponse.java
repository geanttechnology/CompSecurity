// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.endpoint;

import android.text.TextUtils;
import com.amazon.identity.auth.device.token.AccessToken;
import com.amazon.identity.auth.device.token.RefreshToken;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class OpenIdResponse
{
    public static final class Tags
    {

        public static final String ACCESSTOKEN = "openid.oa2.access_token";
        public static final String ACCESS_TOKEN_SCOPE = "device_auth_access";
        public static final String DIRECTEDID = "openid.identity";
        public static final String IDENTITY = "openid.identity";
        public static final String NEWACCOUNT = "new_account";
        public static final String REFRESHTOKEN = "openid.oa2.refresh_token";
        public static final String REFRESH_TOKEN_SCOPE = "device_auth_refresh";
        public static final String SCOPE = "openid.oa2.scope";
        public static final String TOKEN = "aToken";

        private Tags()
        {
        }
    }


    private static final String LOG_TAG = com/amazon/identity/auth/device/endpoint/OpenIdResponse.getName();
    private final Map mParams = new HashMap();
    private final String mRedirectUrl;

    public OpenIdResponse(String s)
    {
        mRedirectUrl = s;
        parseRedirectUrl(s);
    }

    private void parseRedirectUrl(String s)
    {
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException((new StringBuilder("Exception parsing Open ID redirect URL: ")).append(s).toString(), s);
        }
        s = s.getQuery();
        if (!TextUtils.isEmpty(s))
        {
            s = s.split("&");
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                String as[] = s[i].split("=");
                if (as.length > 1)
                {
                    mParams.put(as[0], URLDecoder.decode(as[1]));
                }
                i++;
            }
        }
    }

    public AccessToken getAccessToken()
    {
        Object obj;
        if (!"device_auth_access".equalsIgnoreCase(getScope()))
        {
            break MISSING_BLOCK_LABEL_100;
        }
        obj = LOG_TAG;
        obj = null;
        if (!mParams.containsKey("openid.oa2.access_token")) goto _L2; else goto _L1
_L1:
        obj = new AccessToken((String)mParams.get("openid.oa2.access_token"), getDirectedId());
_L4:
        return ((AccessToken) (obj));
_L2:
        if (!mParams.containsKey("openid.oa2.refresh_token")) goto _L4; else goto _L3
_L3:
        return new AccessToken((String)mParams.get("openid.oa2.refresh_token"), getDirectedId());
        return null;
    }

    public String getDirectedId()
    {
        String s = null;
        if (mParams.containsKey("openid.identity"))
        {
            s = (String)mParams.get("openid.identity");
            s = s.substring(s.lastIndexOf("/") + 1);
        }
        return s;
    }

    public String getIdentity()
    {
        return (String)mParams.get("openid.identity");
    }

    public RefreshToken getRefreshToken()
    {
        if ("device_auth_refresh".equalsIgnoreCase(getScope()))
        {
            String s = LOG_TAG;
            if (mParams.containsKey("openid.oa2.refresh_token"))
            {
                return new RefreshToken((String)mParams.get("openid.oa2.refresh_token"), getDirectedId());
            }
            if (mParams.containsKey("openid.oa2.access_token"))
            {
                return new RefreshToken((String)mParams.get("openid.oa2.access_token"), getDirectedId());
            }
        }
        return null;
    }

    public String getScope()
    {
        String s = "device_auth_refresh";
        if (mParams.containsKey("openid.oa2.scope"))
        {
            s = (String)mParams.get("openid.oa2.scope");
        }
        String s1 = LOG_TAG;
        (new StringBuilder("Token Scope = ")).append(s).toString();
        return s;
    }

    public String getToken()
    {
        return (String)mParams.get("aToken");
    }

    public boolean isCancelEvent(String s)
    {
        String s1;
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(mRedirectUrl))
        {
            if (TextUtils.equals(s, s1 = mRedirectUrl.trim()) || TextUtils.equals((new StringBuilder()).append(s).append("/").toString(), s1))
            {
                return true;
            }
        }
        return false;
    }

    public Boolean isNewAccount()
    {
        if ("1".equalsIgnoreCase((String)mParams.get("new_account")))
        {
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

}

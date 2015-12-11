// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.endpoint;

import android.text.TextUtils;
import com.amazon.identity.auth.device.token.AccessToken;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class OpenIdResponse
{

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
        AccessToken accesstoken;
        if (!"device_auth_access".equalsIgnoreCase(getScope()))
        {
            break MISSING_BLOCK_LABEL_96;
        }
        accesstoken = null;
        if (!mParams.containsKey("openid.oa2.access_token")) goto _L2; else goto _L1
_L1:
        accesstoken = new AccessToken((String)mParams.get("openid.oa2.access_token"), getDirectedId());
_L4:
        return accesstoken;
_L2:
        if (!mParams.containsKey("openid.oa2.refresh_token")) goto _L4; else goto _L3
_L3:
        return new AccessToken((String)mParams.get("openid.oa2.refresh_token"), getDirectedId());
        return null;
    }

    public String getClaimType()
    {
        return (String)mParams.get("claim_type");
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

    public String getScope()
    {
        String s = "device_auth_refresh";
        if (mParams.containsKey("openid.oa2.scope"))
        {
            s = (String)mParams.get("openid.oa2.scope");
        }
        return s;
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

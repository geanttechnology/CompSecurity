// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.google.oauth;

import android.util.Log;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.google.oauth:
//            RevokeTokenResponse

public class RevokeTokenRequest extends Request
{

    private static final String LOG_TAG = "GoogleNowAuthService";
    private final String token;

    public RevokeTokenRequest(String s)
    {
        token = s;
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = new URL((new StringBuilder()).append("https://accounts.google.com/o/oauth2/revoke?token=").append(token).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            Log.e("GoogleNowAuthService", "Request URL could not be parsed!", malformedurlexception);
            return null;
        }
        return url;
    }

    public RevokeTokenResponse getResponse()
    {
        return new RevokeTokenResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public String getUserAgent()
    {
        return EbayAppCredentials.get(getEbayContext()).userAgent;
    }
}

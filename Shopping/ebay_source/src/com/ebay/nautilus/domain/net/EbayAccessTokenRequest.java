// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.net.Uri;
import android.text.TextUtils;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayRequest, ApiSettings, EbayAccessTokenResponse

public final class EbayAccessTokenRequest extends EbayRequest
{

    private final String clientId;
    private final String clientSecret;
    public String grantType;
    public String scope;

    public EbayAccessTokenRequest(String s, String s1)
    {
        super("idauth", "accesstoken");
        grantType = "client_credentials";
        scope = "https://api.ebay.com/oauth/scope/@public";
        clientId = s;
        clientSecret = s1;
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("clientId");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("clientSecret");
        } else
        {
            return;
        }
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.get(ApiSettings.accessTokenUrl)).buildUpon().appendQueryParameter("client_id", clientId).appendQueryParameter("client_secret", clientSecret).appendQueryParameter("grant_type", grantType).appendQueryParameter("scope", scope).build();
        try
        {
            obj = new URL(((Uri) (obj)).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            throw new RuntimeException(malformedurlexception);
        }
        return ((URL) (obj));
    }

    public EbayAccessTokenResponse getResponse()
    {
        return new EbayAccessTokenResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}

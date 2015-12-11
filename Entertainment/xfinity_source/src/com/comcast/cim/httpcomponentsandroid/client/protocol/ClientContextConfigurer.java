// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.protocol;

import com.comcast.cim.httpcomponentsandroid.auth.AuthSchemeRegistry;
import com.comcast.cim.httpcomponentsandroid.client.CookieStore;
import com.comcast.cim.httpcomponentsandroid.client.CredentialsProvider;
import com.comcast.cim.httpcomponentsandroid.cookie.CookieSpecRegistry;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.util.List;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.client.protocol:
//            ClientContext

public class ClientContextConfigurer
    implements ClientContext
{

    private final HttpContext context;

    public void setAuthSchemePref(List list)
    {
        context.setAttribute("http.auth.scheme-pref", list);
    }

    public void setAuthSchemeRegistry(AuthSchemeRegistry authschemeregistry)
    {
        context.setAttribute("http.authscheme-registry", authschemeregistry);
    }

    public void setCookieSpecRegistry(CookieSpecRegistry cookiespecregistry)
    {
        context.setAttribute("http.cookiespec-registry", cookiespecregistry);
    }

    public void setCookieStore(CookieStore cookiestore)
    {
        context.setAttribute("http.cookie-store", cookiestore);
    }

    public void setCredentialsProvider(CredentialsProvider credentialsprovider)
    {
        context.setAttribute("http.auth.credentials-provider", credentialsprovider);
    }
}

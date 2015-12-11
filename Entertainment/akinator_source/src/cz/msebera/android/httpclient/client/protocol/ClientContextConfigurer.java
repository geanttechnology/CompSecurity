// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.cookie.CookieSpecRegistry;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

// Referenced classes of package cz.msebera.android.httpclient.client.protocol:
//            ClientContext

public class ClientContextConfigurer
    implements ClientContext
{

    private final HttpContext context;

    public ClientContextConfigurer(HttpContext httpcontext)
    {
        Args.notNull(httpcontext, "HTTP context");
        context = httpcontext;
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

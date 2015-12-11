// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.auth;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;

// Referenced classes of package cz.msebera.android.httpclient.auth:
//            AuthSchemeProvider, AuthSchemeRegistry, AuthScheme

class val.name
    implements AuthSchemeProvider
{

    final AuthSchemeRegistry this$0;
    final String val$name;

    public AuthScheme create(HttpContext httpcontext)
    {
        httpcontext = (HttpRequest)httpcontext.getAttribute("http.request");
        return getAuthScheme(val$name, httpcontext.getParams());
    }

    ()
    {
        this$0 = final_authschemeregistry;
        val$name = String.this;
        super();
    }
}

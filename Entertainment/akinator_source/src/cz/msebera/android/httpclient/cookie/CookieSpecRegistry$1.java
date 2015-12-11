// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.cookie;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;

// Referenced classes of package cz.msebera.android.httpclient.cookie:
//            CookieSpecProvider, CookieSpecRegistry, CookieSpec

class val.name
    implements CookieSpecProvider
{

    final CookieSpecRegistry this$0;
    final String val$name;

    public CookieSpec create(HttpContext httpcontext)
    {
        httpcontext = (HttpRequest)httpcontext.getAttribute("http.request");
        return getCookieSpec(val$name, httpcontext.getParams());
    }

    ()
    {
        this$0 = final_cookiespecregistry;
        val$name = String.this;
        super();
    }
}

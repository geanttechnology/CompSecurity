// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            AsyncHttpClient

final class c extends DefaultRedirectHandler
{

    final boolean a;
    final AsyncHttpClient b;

    c(AsyncHttpClient asynchttpclient, boolean flag)
    {
        b = asynchttpclient;
        a = flag;
        super();
    }

    public final boolean isRedirectRequested(HttpResponse httpresponse, HttpContext httpcontext)
    {
        return a;
    }
}

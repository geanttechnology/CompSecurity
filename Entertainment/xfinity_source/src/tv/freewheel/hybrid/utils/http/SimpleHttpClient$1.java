// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.utils.http;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package tv.freewheel.hybrid.utils.http:
//            SimpleHttpClient

static final class 
    implements HttpRequestInterceptor
{

    public void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (SimpleHttpClient.access$000().get() != null && ((Boolean)SimpleHttpClient.access$000().get()).booleanValue())
        {
            throw new RuntimeException("This thread forbids HTTP requests");
        } else
        {
            return;
        }
    }

    ()
    {
    }
}

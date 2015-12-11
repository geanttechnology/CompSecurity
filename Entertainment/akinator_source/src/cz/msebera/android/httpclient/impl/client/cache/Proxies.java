// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.util.Args;
import java.lang.reflect.Proxy;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            ResponseProxyHandler

class Proxies
{

    Proxies()
    {
    }

    public static CloseableHttpResponse enhanceResponse(HttpResponse httpresponse)
    {
        Args.notNull(httpresponse, "HTTP response");
        if (httpresponse instanceof CloseableHttpResponse)
        {
            return (CloseableHttpResponse)httpresponse;
        } else
        {
            ClassLoader classloader = cz/msebera/android/httpclient/impl/client/cache/ResponseProxyHandler.getClassLoader();
            httpresponse = new ResponseProxyHandler(httpresponse);
            return (CloseableHttpResponse)Proxy.newProxyInstance(classloader, new Class[] {
                cz/msebera/android/httpclient/client/methods/CloseableHttpResponse
            }, httpresponse);
        }
    }
}

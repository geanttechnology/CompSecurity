// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.Context;
import com.amazon.identity.auth.device.framework.security.EnhancedURLConnectionFactory;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            RetryableHttpsURLConnection, RetryableHttpURLConnection, RetryLogic, Tracer

public final class RetryableURLConnection
{

    public static HttpURLConnection openConnection(URL url, RetryLogic retrylogic, Tracer tracer, Context context)
        throws IOException
    {
        if (url == null)
        {
            throw new IllegalArgumentException("Must Specify a URL");
        }
        if (retrylogic == null)
        {
            throw new IllegalArgumentException("Must Specify Retry Logic");
        }
        java.net.URLConnection urlconnection = EnhancedURLConnectionFactory.createURLConnection(url);
        if (urlconnection instanceof HttpsURLConnection)
        {
            return new RetryableHttpsURLConnection(url, retrylogic, tracer, context);
        }
        if (urlconnection instanceof HttpURLConnection)
        {
            return new RetryableHttpURLConnection(url, retrylogic, tracer, context);
        } else
        {
            throw new IllegalArgumentException("Url must be an Https or Http Url");
        }
    }
}

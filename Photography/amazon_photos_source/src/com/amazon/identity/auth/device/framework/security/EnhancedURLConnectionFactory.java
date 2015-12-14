// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework.security;

import com.amazon.identity.auth.device.env.EnvironmentUtils;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.identity.auth.device.framework.security:
//            EnhancedSSLSocketFactory

public final class EnhancedURLConnectionFactory
{

    public static URLConnection createURLConnection(URL url)
        throws IOException
    {
        if (url == null)
        {
            throw new IllegalArgumentException("Null url is not allowed");
        }
        url = url.openConnection();
        if (EnvironmentUtils.isCurrentEnvironmentProd() && (url instanceof HttpsURLConnection))
        {
            ((HttpsURLConnection)url).setSSLSocketFactory(EnhancedSSLSocketFactory.INSTANCE);
            ((HttpsURLConnection)url).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
        return url;
    }
}

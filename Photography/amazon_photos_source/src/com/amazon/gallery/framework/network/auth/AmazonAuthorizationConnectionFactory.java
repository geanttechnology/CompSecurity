// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.auth;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.gallery.framework.network.auth:
//            EnhancedSSLSocketFactory

public class AmazonAuthorizationConnectionFactory
{

    public AmazonAuthorizationConnectionFactory()
    {
    }

    public HttpURLConnection createHttpURLConnection(URL url)
        throws IOException
    {
        url = (HttpURLConnection)url.openConnection();
        if (url instanceof HttpsURLConnection)
        {
            ((HttpsURLConnection)url).setSSLSocketFactory(EnhancedSSLSocketFactory.INSTANCE);
            ((HttpsURLConnection)url).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
        return url;
    }
}

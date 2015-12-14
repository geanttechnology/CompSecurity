// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.auth;

import com.amazon.gallery.thor.cds.StethoNetworkInjector;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.apache.OkApacheClient;
import java.util.Collections;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.gallery.framework.network.auth:
//            EnhancedSSLSocketFactory

public class AmazonHttpClientFactory
{

    private static final OkHttpClient okHttpClient;

    public static HttpClient getHttpClient()
    {
        return new OkApacheClient(okHttpClient);
    }

    public static OkHttpClient getOkHttpClient()
    {
        return okHttpClient;
    }

    static 
    {
        okHttpClient = new OkHttpClient();
        okHttpClient.setConnectionSpecs(Collections.singletonList(ConnectionSpec.MODERN_TLS)).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER).setSslSocketFactory(EnhancedSSLSocketFactory.INSTANCE);
        StethoNetworkInjector.inject(okHttpClient);
    }
}

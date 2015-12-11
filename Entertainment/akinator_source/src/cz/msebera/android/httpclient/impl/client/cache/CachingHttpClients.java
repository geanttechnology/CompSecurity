// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.impl.client.CloseableHttpClient;
import java.io.File;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            CachingHttpClientBuilder

public class CachingHttpClients
{

    private CachingHttpClients()
    {
    }

    public static CloseableHttpClient createFileBound(File file)
    {
        return CachingHttpClientBuilder.create().setCacheDir(file).build();
    }

    public static CloseableHttpClient createMemoryBound()
    {
        return CachingHttpClientBuilder.create().build();
    }

    public static CachingHttpClientBuilder custom()
    {
        return CachingHttpClientBuilder.create();
    }
}

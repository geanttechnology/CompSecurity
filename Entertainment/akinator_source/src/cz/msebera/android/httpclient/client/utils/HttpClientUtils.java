// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.Closeable;
import java.io.IOException;

public class HttpClientUtils
{

    private HttpClientUtils()
    {
    }

    public static void closeQuietly(HttpResponse httpresponse)
    {
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        httpresponse = httpresponse.getEntity();
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        EntityUtils.consume(httpresponse);
        return;
        httpresponse;
    }

    public static void closeQuietly(HttpClient httpclient)
    {
        if (httpclient == null || !(httpclient instanceof Closeable))
        {
            break MISSING_BLOCK_LABEL_20;
        }
        ((Closeable)httpclient).close();
        return;
        httpclient;
    }

    public static void closeQuietly(CloseableHttpResponse closeablehttpresponse)
    {
        if (closeablehttpresponse == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        EntityUtils.consume(closeablehttpresponse.getEntity());
        Exception exception;
        try
        {
            closeablehttpresponse.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CloseableHttpResponse closeablehttpresponse) { }
        break MISSING_BLOCK_LABEL_30;
        exception;
        closeablehttpresponse.close();
        throw exception;
    }
}

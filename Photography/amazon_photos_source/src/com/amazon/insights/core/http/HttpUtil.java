// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpUtil
{

    private static volatile HttpClient client;

    private HttpUtil()
    {
    }

    private static HttpClient createHttpClient()
    {
        HttpParams httpparams = (new DefaultHttpClient()).getParams();
        HttpConnectionParams.setConnectionTimeout(httpparams, 5000);
        HttpConnectionParams.setSoTimeout(httpparams, 10000);
        httpparams.setParameter("http.conn-manager.max-total", Integer.valueOf(30));
        httpparams.setParameter("http.conn-manager.max-per-route", new ConnPerRouteBean(30));
        httpparams.setParameter("http.protocol.expect-continue", Boolean.valueOf(false));
        HttpProtocolParams.setVersion(httpparams, HttpVersion.HTTP_1_1);
        httpparams.setParameter("http.connection.stalecheck", Boolean.valueOf(true));
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new DefaultHttpClient(new ThreadSafeClientConnManager(httpparams, schemeregistry), httpparams);
    }

    static HttpClient getHttpClient()
    {
        if (client != null) goto _L2; else goto _L1
_L1:
        com/amazon/insights/core/http/HttpUtil;
        JVM INSTR monitorenter ;
        if (client == null)
        {
            client = createHttpClient();
        }
        com/amazon/insights/core/http/HttpUtil;
        JVM INSTR monitorexit ;
_L2:
        return client;
        Exception exception;
        exception;
        com/amazon/insights/core/http/HttpUtil;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String getMessageForResponse(HttpClient.Response response)
    {
        switch (response.getCode())
        {
        default:
            if (response.getCode() < 0)
            {
                return response.getMessage();
            } else
            {
                return "";
            }

        case 403: 
            return "Access denied. Verify your application key and private key are correct.";

        case 500: 
            return "An unexpected server error occurred.";

        case 400: 
            return "Bad server request.";

        case 404: 
            return "Application not found.";
        }
    }
}

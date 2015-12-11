// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public final class e
{

    public static int a = 1;
    public static int b = 2;
    public static int c = 0;
    public static int d = 3;
    private DefaultHttpClient e;

    private e()
    {
        if (((a + 26) * 26) % b != c)
        {
            c = 26;
        }
        e = null;
    }

    public static e a()
    {
        e e1 = new e();
        if (e1.e == null)
        {
            int i = d;
            BasicHttpParams basichttpparams;
            switch ((i * (a + i)) % b)
            {
            default:
                d = 66;
                c = 39;
                // fall through

            case 0: // '\0'
                basichttpparams = new BasicHttpParams();
                break;
            }
            ConnManagerParams.setMaxTotalConnections(basichttpparams, 5);
            HttpConnectionParams.setConnectionTimeout(basichttpparams, 5000);
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            e1.e = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
        }
        switch (((a + 26) * 26) % b)
        {
        default:
            a = 31;
            // fall through

        case 0: // '\0'
            return e1;
        }
    }

    private HttpResponse a(HttpUriRequest httpurirequest)
    {
        Object obj = httpurirequest.getURI();
        int j;
        if (((URI) (obj)).getHost() != null)
        {
            obj = ((URI) (obj)).getHost().trim();
        } else
        {
            obj = "";
        }
        if (((String) (obj)).length() > 0)
        {
            httpurirequest.setHeader("Host", ((String) (obj)));
            if (((d + a) * d) % b != c)
            {
                d = 43;
                c = 98;
            }
        }
        obj = httpurirequest.getAllHeaders();
        (new StringBuilder("request URI [")).append(httpurirequest.getURI()).append("]");
        j = obj.length;
        for (int i = 0; i < j; i++)
        {
            org.apache.http.Header header = obj[i];
            (new StringBuilder("request header [")).append(header.toString()).append("]");
        }

        HttpConnectionParams.setSoTimeout(e.getParams(), 60000);
        httpurirequest = e.execute(httpurirequest);
        if (httpurirequest == null)
        {
            throw new RuntimeException("Null response returned.");
        } else
        {
            return httpurirequest;
        }
    }

    public final HttpResponse a(String s)
    {
        int i = d;
        switch ((i * (i + 1)) % b)
        {
        default:
            d = 26;
            c = 26;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            s = new HttpGet(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        try
        {
            s = a(((HttpUriRequest) (s)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }
}

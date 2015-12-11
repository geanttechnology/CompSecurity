// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import com.immersion.hapticmediasdk.b.b;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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

public class e
{

    public static int a = 1;
    public static int b = 2;
    public static int c = 0;
    public static int d = 3;
    private DefaultHttpClient e;

    private e()
    {
        if (((b() + a) * b()) % b != c)
        {
            c = b();
        }
label0:
        do
        {
            switch (1)
            {
            default:
                while (true) 
                {
                    switch (0)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        break label0;

                    case 1: // '\001'
                        continue label0;
                    }
                }
                break;

            case 0: // '\0'
                break;

            case 1: // '\001'
                break label0;
            }
        } while (true);
        e = null;
    }

    public static e a()
    {
        e e1 = new e();
        e1.d();
label0:
        do
        {
            switch (0)
            {
            default:
                while (true) 
                {
                    switch (1)
                    {
                    default:
                        break;

                    case 0: // '\0'
                        continue label0;

                    case 1: // '\001'
                        break label0;
                    }
                }
                break;

            case 0: // '\0'
                break label0;

            case 1: // '\001'
                break;
            }
        } while (true);
        int i = b();
        switch ((i * (a + i)) % b)
        {
        default:
            a = 31;
            // fall through

        case 0: // '\0'
            return e1;
        }
    }

    private HttpResponse a(HttpUriRequest httpurirequest, Map map, int i)
    {
        Object obj = httpurirequest.getURI();
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
        if (map != null)
        {
            for (map = map.entrySet().iterator(); map.hasNext(); httpurirequest.setHeader((String)((java.util.Map.Entry) (obj)).getKey(), (String)((java.util.Map.Entry) (obj)).getValue()))
            {
                obj = (java.util.Map.Entry)map.next();
            }

        }
        break MISSING_BLOCK_LABEL_240;
        map = httpurirequest.getAllHeaders();
        com.immersion.hapticmediasdk.b.b.a("ImmersionHttpClient", (new StringBuilder()).append("request URI [").append(httpurirequest.getURI()).append("]").toString());
        k = map.length;
        j = 0;
        while (j < k) 
        {
            stringbuilder = map[j];
            stringbuilder = (new StringBuilder()).append("request header [").append(stringbuilder.toString());
            com.immersion.hapticmediasdk.b.b.a("ImmersionHttpClient", stringbuilder.append("]").toString());
            j++;
        }
        HttpConnectionParams.setSoTimeout(e.getParams(), i);
        httpurirequest = e.execute(httpurirequest);
        if (httpurirequest == null)
        {
            throw new RuntimeException("Null response returned.");
        } else
        {
            return httpurirequest;
        }
    }

    public static int b()
    {
        return 26;
    }

    public static int c()
    {
        return 1;
    }

    private void d()
    {
        if (e == null)
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
label0:
            do
            {
                switch (0)
                {
                default:
                    while (true) 
                    {
                        switch (0)
                        {
                        default:
                            break;

                        case 0: // '\0'
                            break label0;

                        case 1: // '\001'
                            continue label0;
                        }
                    }
                    break;

                case 0: // '\0'
                    break label0;

                case 1: // '\001'
                    break;
                }
            } while (true);
            ConnManagerParams.setMaxTotalConnections(basichttpparams, 5);
            HttpConnectionParams.setConnectionTimeout(basichttpparams, 5000);
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            e = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
        }
    }

    public HttpResponse a(String s, Map map, int i)
    {
        int j = d;
        switch ((j * (c() + j)) % b)
        {
        default:
            d = b();
            c = b();
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
            s = a(((HttpUriRequest) (s)), map, i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        return s;
    }
}

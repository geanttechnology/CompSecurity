// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            dy, cn, dz

class bu extends dy
{

    private static final String s = com/amazon/device/ads/bu.getSimpleName();
    private HttpURLConnection t;

    bu()
    {
    }

    private dy.g a(HttpURLConnection httpurlconnection)
    {
        dy.g g = new dy.g(this);
        try
        {
            g.a = httpurlconnection.getResponseCode();
            g.b = httpurlconnection.getResponseMessage();
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            super.r.d("Socket Timeout while getting the response status code: %s", new Object[] {
                httpurlconnection.getMessage()
            });
            throw new dy.c(this, dy.f.b, "Socket Timeout while getting the response status code", httpurlconnection);
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            super.r.d("IOException while getting the response status code: %s", new Object[] {
                httpurlconnection.getMessage()
            });
            throw new dy.c(this, dy.f.a, "IOException while getting the response status code", httpurlconnection);
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            super.r.d("IndexOutOfBoundsException while getting the response status code: %s", new Object[] {
                httpurlconnection.getMessage()
            });
            throw new dy.c(this, dy.f.c, "IndexOutOfBoundsException while getting the response status code", httpurlconnection);
        }
        if (g.a == 200)
        {
            try
            {
                g.a(httpurlconnection.getInputStream());
            }
            // Misplaced declaration of an exception variable
            catch (HttpURLConnection httpurlconnection)
            {
                super.r.d("IOException while reading the input stream from response: %s", new Object[] {
                    httpurlconnection.getMessage()
                });
                throw new dy.c(this, dy.f.a, "IOException while reading the input stream from response", httpurlconnection);
            }
        }
        return g;
    }

    protected final dy.g a(URL url)
    {
        if (t != null)
        {
            a();
        }
        Iterator iterator;
        try
        {
            t = (HttpURLConnection)url.openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            super.r.d("Problem while opening the URL connection: %s", new Object[] {
                url.getMessage()
            });
            throw new dy.c(this, dy.f.a, "Problem while opening the URL connection", url);
        }
        url = t;
        try
        {
            url.setRequestMethod(super.f.name());
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            super.r.d("Invalid client protocol: %s", new Object[] {
                url.getMessage()
            });
            throw new dy.c(this, dy.f.d, "Invalid client protocol", url);
        }
        iterator = j.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (entry.getValue() != null && !((String)entry.getValue()).equals(""))
            {
                url.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
            }
        } while (true);
        url.setConnectTimeout(super.g);
        url.setReadTimeout(super.g);
        a(url.getURL().toString());
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[dy.a.values().length];
                try
                {
                    a[dy.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[dy.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[super.f.ordinal()];
        JVM INSTR tableswitch 1 2: default 252
    //                   1 268
    //                   2 276;
           goto _L1 _L2 _L3
_L1:
        Object obj;
        Object obj1;
        StringBuilder stringbuilder;
        java.util.Map.Entry entry1;
        try
        {
            t.connect();
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            super.r.d("Socket timed out while connecting to URL: %s", new Object[] {
                url.getMessage()
            });
            throw new dy.c(this, dy.f.b, "Socket timed out while connecting to URL", url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            super.r.d("Problem while connecting to URL: %s", new Object[] {
                url.getMessage()
            });
            throw new dy.c(this, dy.f.a, "Probem while connecting to URL", url);
        }
        return a(t);
_L2:
        url.setDoOutput(false);
          goto _L1
_L3:
        url.setDoOutput(true);
        stringbuilder = new StringBuilder();
        if (a != null)
        {
            stringbuilder.append(a);
        } else
        if (l != null && !l.isEmpty())
        {
            for (obj = l.entrySet().iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append((String)entry1.getKey()).append("=").append(dz.a((String)entry1.getValue())).append("&"))
            {
                entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

            stringbuilder.deleteCharAt(stringbuilder.lastIndexOf("&"));
        }
        if (m && g() != null)
        {
            super.r.b("Request Body: %s", new Object[] {
                g()
            });
        }
        obj = new OutputStreamWriter(url.getOutputStream(), "UTF-8");
        url = ((URL) (obj));
        ((OutputStreamWriter) (obj)).write(stringbuilder.toString());
        try
        {
            ((OutputStreamWriter) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            super.r.d("Problem while closing output stream writer for request body: %s", new Object[] {
                url.getMessage()
            });
            throw new dy.c(this, dy.f.a, "Problem while closing output stream writer for request body", url);
        }
          goto _L1
        obj1;
        obj = null;
_L7:
        url = ((URL) (obj));
        super.r.d("Problem while creating output steam for request body: %s", new Object[] {
            ((IOException) (obj1)).getMessage()
        });
        url = ((URL) (obj));
        throw new dy.c(this, dy.f.a, "Problem while creating output steam for request body", ((Throwable) (obj1)));
        obj1;
        obj = url;
        url = ((URL) (obj1));
_L5:
        if (obj != null)
        {
            try
            {
                ((OutputStreamWriter) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                super.r.d("Problem while closing output stream writer for request body: %s", new Object[] {
                    url.getMessage()
                });
                throw new dy.c(this, dy.f.a, "Problem while closing output stream writer for request body", url);
            }
        }
        throw url;
        url;
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected final void a()
    {
        if (t != null)
        {
            t.disconnect();
            t = null;
        }
    }

    protected final String b()
    {
        return s;
    }

}

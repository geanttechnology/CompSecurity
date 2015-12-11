// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.h.d.a;
import com.shazam.h.d.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

// Referenced classes of package com.shazam.h:
//            j, y, l, e, 
//            n, k, b, r, 
//            q, x, o

final class m
{

    private final e a;
    private final q b;

    m(e e1, q q1)
    {
        a = e1;
        b = q1;
    }

    private static j a(k k1, URL url, Exception exception)
    {
        StringBuilder stringbuilder = (new StringBuilder("Error when executing ")).append(k1).append(" request to: ");
        if (url != null)
        {
            k1 = url.toString();
        } else
        {
            k1 = "null";
        }
        return new j(stringbuilder.append(k1).toString(), exception);
    }

    private static InputStream a(HttpURLConnection httpurlconnection)
    {
label0:
        {
            InputStream inputstream;
            try
            {
                inputstream = httpurlconnection.getInputStream();
                if (!"gzip".equals(httpurlconnection.getContentEncoding()))
                {
                    break label0;
                }
                httpurlconnection = new GZIPInputStream(inputstream);
            }
            // Misplaced declaration of an exception variable
            catch (HttpURLConnection httpurlconnection)
            {
                return null;
            }
            return httpurlconnection;
        }
        return inputstream;
    }

    static String a(y y1)
    {
        ArrayList arraylist = new ArrayList();
        java.util.Map.Entry entry;
        for (y1 = y1.b.entrySet().iterator(); y1.hasNext(); arraylist.add(new a((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)y1.next();
        }

        return c.a(arraylist, "UTF-8");
    }

    private static void a(l l1, HttpURLConnection httpurlconnection)
    {
        java.util.Map.Entry entry;
        for (l1 = l1.d.entrySet().iterator(); l1.hasNext(); httpurlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)l1.next();
        }

    }

    private void a(URLConnection urlconnection)
    {
        for (Iterator iterator = a.d.iterator(); iterator.hasNext(); ((n)iterator.next()).a(urlconnection)) { }
    }

    private static boolean a(k k1)
    {
        return k1 == k.b || k1 == com.shazam.h.k.c;
    }

    final o a(k k1, URL url, x x1, com.shazam.h.a.a a1, String s)
    {
        l.a a2 = new l.a();
        a2.a = url;
        a2.e = k1;
        a2.b = false;
        k1 = a2.a(a1);
        k1.f = s;
        return a(x1, k1.a());
    }

    final o a(k k1, URL url, x x1, byte abyte0[], r r1)
    {
        b.a a1 = new b.a();
        a1.a = abyte0;
        return a(k1, url, x1, ((com.shazam.h.a.a) (new b(a1, (byte)0))), r1.f);
    }

    public final o a(x x1, l l1)
    {
        URL url;
        k k1;
        url = l1.a;
        k1 = l1.e;
        Object obj1;
        obj1 = l1.a;
        if (l1.e == com.shazam.h.k.a)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Object obj = obj1;
        if (l1.e != com.shazam.h.k.c)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        Object obj2 = l1.c;
        obj = obj1;
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        obj = obj1;
        if (((y) (obj2)).b == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        if (!((y) (obj2)).b.isEmpty())
        {
            break MISSING_BLOCK_LABEL_334;
        }
        obj = obj1;
_L1:
        try
        {
            obj1 = b.a(((URL) (obj)));
            ((HttpURLConnection) (obj1)).setConnectTimeout(a.a);
            ((HttpURLConnection) (obj1)).setReadTimeout(a.b);
            ((HttpURLConnection) (obj1)).setInstanceFollowRedirects(a.c);
            if (l1.b)
            {
                ((HttpURLConnection) (obj1)).addRequestProperty("Cache-Control", "no-cache");
            }
            a(((URLConnection) (obj1)));
            if (l1.f != null)
            {
                ((HttpURLConnection) (obj1)).setRequestProperty("content-type", l1.f);
            }
            a(l1, ((HttpURLConnection) (obj1)));
            ((HttpURLConnection) (obj1)).setRequestMethod(l1.e.name());
            if (a(l1.e))
            {
                ((HttpURLConnection) (obj1)).setDoOutput(true);
            }
            ((HttpURLConnection) (obj1)).connect();
            x1.onConnecting(((URL) (obj)));
            obj = ((HttpURLConnection) (obj1)).getURL();
            if (a(l1.e))
            {
                l1 = l1.g;
                obj2 = ((HttpURLConnection) (obj1)).getOutputStream();
                ((OutputStream) (obj2)).write(l1);
                ((OutputStream) (obj2)).close();
                x1.onRequestSent(((URL) (obj)), l1);
            }
            l1 = a.e;
            obj2 = new o.a();
            obj2.a = ((HttpURLConnection) (obj1)).getResponseCode();
            obj2 = ((o.a) (obj2)).a(((HttpURLConnection) (obj1)).getHeaderFields());
            obj2.b = l1.a(a(((HttpURLConnection) (obj1))));
            l1 = ((o.a) (obj2)).a();
            x1.onResponseReceived(((URL) (obj)), l1);
        }
        // Misplaced declaration of an exception variable
        catch (x x1)
        {
            throw a(k1, url, ((Exception) (x1)));
        }
        // Misplaced declaration of an exception variable
        catch (x x1)
        {
            throw a(k1, url, ((Exception) (x1)));
        }
        return l1;
        obj = com.shazam.b.c.a.a((new StringBuilder()).append(obj1).append("?").append(a(((y) (obj2)))).toString());
          goto _L1
    }
}

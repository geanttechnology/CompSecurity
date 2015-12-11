// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.a.h;
import com.a.a.a.a.o;
import com.a.a.a.a.r;
import com.a.a.a.a.s;
import com.a.a.a.a.v;
import com.a.a.a.a.x;
import com.a.a.a.a.z;
import com.a.a.a.c;
import com.a.a.a.i;
import com.a.a.a.u;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.CacheRequest;
import java.net.CacheResponse;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.a.a:
//            g, h, i, u, 
//            l, m, n, j, 
//            t

public final class f extends ResponseCache
{

    private static final char b[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    final t a = new g(this);
    private final c c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public f(File file, long l1)
    {
        c = com.a.a.a.c.a(file, l1);
    }

    private static h a(URLConnection urlconnection)
    {
        if (urlconnection instanceof o)
        {
            return ((o)urlconnection).b();
        }
        if (urlconnection instanceof r)
        {
            return ((r)urlconnection).a.b();
        } else
        {
            return null;
        }
    }

    static InputStream a(i k)
    {
        return new com.a.a.h(k.c[1], k);
    }

    private static String a(URI uri)
    {
_L2:
        uri = new String(ac1);
        return uri;
        int k = 0;
        char ac[];
        char ac1[];
        int i1;
        int j1;
        try
        {
            uri = MessageDigest.getInstance("MD5").digest(uri.toString().getBytes("UTF-8"));
            ac = b;
            ac1 = new char[uri.length * 2];
            j1 = uri.length;
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            throw new AssertionError(uri);
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            throw new AssertionError(uri);
        }
        i1 = 0;
        while (k < j1) 
        {
            byte byte0 = uri[k];
            int k1 = i1 + 1;
            ac1[i1] = ac[byte0 >> 4 & 0xf];
            i1 = k1 + 1;
            ac1[k1] = ac[byte0 & 0xf];
            k++;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        g = g + 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private static void a(com.a.a.a.f f1)
    {
        if (f1 == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        f1.b();
        return;
        f1;
    }

    static void a(f f1)
    {
        f1.a();
    }

    static void a(f f1, com.a.a.u u1)
    {
        f1.a(u1);
    }

    private void a(com.a.a.u u1)
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        h = h + 1;
        k = i.a[u1.ordinal()];
        k;
        JVM INSTR tableswitch 1 3: default 48
    //                   1 51
    //                   2 69
    //                   3 69;
           goto _L1 _L2 _L3 _L3
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        g = g + 1;
          goto _L1
        u1;
        throw u1;
_L3:
        f = f + 1;
          goto _L1
    }

    static void a(CacheResponse cacheresponse, HttpURLConnection httpurlconnection)
    {
        h h1 = a(((URLConnection) (httpurlconnection)));
        URI uri = h1.h;
        z z1 = h1.f();
        httpurlconnection = new l(uri, h1.i.a.a(z1.q), httpurlconnection);
        if (cacheresponse instanceof m)
        {
            cacheresponse = m.a((m)cacheresponse);
        } else
        {
            cacheresponse = n.a((n)cacheresponse);
        }
        cacheresponse = com.a.a.a.c.a(((i) (cacheresponse)).d, ((i) (cacheresponse)).a, ((i) (cacheresponse)).b);
        if (cacheresponse == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        httpurlconnection.a(cacheresponse);
        cacheresponse.a();
        return;
        cacheresponse;
        cacheresponse = null;
_L2:
        a(((com.a.a.a.f) (cacheresponse)));
        return;
        httpurlconnection;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static boolean a(f f1, String s1, URI uri)
    {
        return f1.a(s1, uri);
    }

    private boolean a(String s1, URI uri)
    {
        if (s1.equals("POST") || s1.equals("PUT") || s1.equals("DELETE"))
        {
            try
            {
                c.b(a(uri));
            }
            // Misplaced declaration of an exception variable
            catch (String s1) { }
            return true;
        } else
        {
            return false;
        }
    }

    static int b(f f1)
    {
        int k = f1.d;
        f1.d = k + 1;
        return k;
    }

    static int c(f f1)
    {
        int k = f1.e;
        f1.e = k + 1;
        return k;
    }

    public final CacheResponse get(URI uri, String s1, Map map)
    {
        Object obj;
        l l1;
        boolean flag;
        obj = a(uri);
        String s2;
        try
        {
            obj = c.a(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        l1 = new l(((i) (obj)).c[0]);
        if (!l1.a.equals(uri.toString()) || !l1.c.equals(s1)) goto _L2; else goto _L1
_L1:
        s1 = new z(uri, l1.d);
        uri = l1.b.a(false);
        s1 = ((z) (s1)).q.iterator();
_L6:
        if (!s1.hasNext()) goto _L4; else goto _L3
_L3:
        s2 = (String)s1.next();
        if (u.a(uri.get(s2), map.get(s2))) goto _L6; else goto _L5
_L5:
        flag = false;
_L11:
        if (!flag) goto _L2; else goto _L7
_L7:
        flag = true;
_L9:
        if (!flag)
        {
            ((i) (obj)).close();
            return null;
        }
        break; /* Loop/switch isn't completed */
_L4:
        flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
        if (l1.a())
        {
            return new n(l1, ((i) (obj)));
        }
        return new m(l1, ((i) (obj)));
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final CacheRequest put(URI uri, URLConnection urlconnection)
    {
        if (urlconnection instanceof HttpURLConnection) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Object obj;
        urlconnection = (HttpURLConnection)urlconnection;
        obj = urlconnection.getRequestMethod();
        if (a(((String) (obj)), uri) || !((String) (obj)).equals("GET")) goto _L1; else goto _L3
_L3:
        obj = a(urlconnection);
        if (obj == null) goto _L1; else goto _L4
_L4:
        z z1 = ((h) (obj)).f();
        if (z1.q.contains("*")) goto _L1; else goto _L5
_L5:
        urlconnection = new l(uri, ((h) (obj)).i.a.a(z1.q), urlconnection);
        uri = c.a(a(uri), -1L);
        if (uri == null) goto _L1; else goto _L6
_L6:
        urlconnection.a(uri);
        urlconnection = new j(this, uri);
        return urlconnection;
        uri;
        uri = null;
_L8:
        a(uri);
        return null;
        urlconnection;
        if (true) goto _L8; else goto _L7
_L7:
    }

}

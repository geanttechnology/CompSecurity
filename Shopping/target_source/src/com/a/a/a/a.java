// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import android.os.SystemClock;
import com.a.a.g;
import com.a.a.i;
import com.a.a.j;
import com.a.a.k;
import com.a.a.m;
import com.a.a.q;
import com.a.a.r;
import com.a.a.s;
import com.a.a.t;
import com.a.a.u;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

// Referenced classes of package com.a.a.a:
//            b, k, f

public class a
    implements g
{

    protected static final boolean a;
    private static int d = 3000;
    private static int e = 4096;
    protected final f b;
    protected final b c;

    public a(f f1)
    {
        this(f1, new b(e));
    }

    public a(f f1, b b1)
    {
        b = f1;
        c = b1;
    }

    protected static Map a(Header aheader[])
    {
        TreeMap treemap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int l = 0; l < aheader.length; l++)
        {
            treemap.put(aheader[l].getName(), aheader[l].getValue());
        }

        return treemap;
    }

    private void a(long l, m m1, byte abyte0[], StatusLine statusline)
    {
        if (a || l > (long)d)
        {
            if (abyte0 != null)
            {
                abyte0 = Integer.valueOf(abyte0.length);
            } else
            {
                abyte0 = "null";
            }
            u.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] {
                m1, Long.valueOf(l), abyte0, Integer.valueOf(statusline.getStatusCode()), Integer.valueOf(m1.getRetryPolicy().b())
            });
        }
    }

    private static void a(String s1, m m1, t t1)
        throws t
    {
        q q1 = m1.getRetryPolicy();
        int l = m1.getTimeoutMs();
        try
        {
            q1.a(t1);
        }
        // Misplaced declaration of an exception variable
        catch (t t1)
        {
            m1.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[] {
                s1, Integer.valueOf(l)
            }));
            throw t1;
        }
        m1.addMarker(String.format("%s-retry [timeout=%s]", new Object[] {
            s1, Integer.valueOf(l)
        }));
    }

    private void a(Map map, com.a.a.b.a a1)
    {
        if (a1 != null)
        {
            if (a1.b != null)
            {
                map.put("If-None-Match", a1.b);
            }
            if (a1.d > 0L)
            {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(a1.d)));
                return;
            }
        }
    }

    private byte[] a(HttpEntity httpentity)
        throws IOException, r
    {
        Object obj;
        Exception exception;
        com.a.a.a.k k1;
        k1 = new com.a.a.a.k(c, (int)httpentity.getContentLength());
        exception = null;
        obj = exception;
        InputStream inputstream = httpentity.getContent();
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        obj = exception;
        throw new r();
        exception;
        byte abyte0[];
        byte abyte1[];
        int l;
        try
        {
            httpentity.consumeContent();
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            u.a("Error occured when calling consumingContent", new Object[0]);
        }
        c.a(((byte []) (obj)));
        k1.close();
        throw exception;
        obj = exception;
        abyte0 = c.a(1024);
_L2:
        obj = abyte0;
        l = inputstream.read(abyte0);
        if (l == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = abyte0;
        k1.write(abyte0, 0, l);
        if (true) goto _L2; else goto _L1
_L1:
        obj = abyte0;
        abyte1 = k1.toByteArray();
        try
        {
            httpentity.consumeContent();
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            u.a("Error occured when calling consumingContent", new Object[0]);
        }
        c.a(abyte0);
        k1.close();
        return abyte1;
    }

    public j a(m m1)
        throws t
    {
        long l1 = SystemClock.elapsedRealtime();
_L5:
        Object obj2;
        Object obj4;
        obj4 = null;
        obj2 = Collections.emptyMap();
        Object obj1;
        HashMap hashmap = new HashMap();
        a(((Map) (hashmap)), m1.getCacheEntry());
        obj1 = b.a(m1, hashmap);
        Object obj = obj2;
        Object obj3 = ((HttpResponse) (obj1)).getStatusLine();
        obj = obj2;
        int l = ((StatusLine) (obj3)).getStatusCode();
        obj = obj2;
        obj4 = a(((HttpResponse) (obj1)).getAllHeaders());
        if (l != 304) goto _L2; else goto _L1
_L1:
        obj = obj4;
        obj2 = m1.getCacheEntry();
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        obj = obj4;
        return new j(304, null, ((Map) (obj4)), true, SystemClock.elapsedRealtime() - l1);
        obj = obj4;
        ((com.a.a.b.a) (obj2)).g.putAll(((Map) (obj4)));
        obj = obj4;
        return new j(304, ((com.a.a.b.a) (obj2)).a, ((com.a.a.b.a) (obj2)).g, true, SystemClock.elapsedRealtime() - l1);
_L8:
        obj = obj4;
        m1.setRedirectUrl((String)((Map) (obj4)).get("Location"));
_L9:
        obj = obj4;
        if (((HttpResponse) (obj1)).getEntity() == null) goto _L4; else goto _L3
_L3:
        obj = obj4;
        obj2 = a(((HttpResponse) (obj1)).getEntity());
        obj = obj2;
_L6:
        a(SystemClock.elapsedRealtime() - l1, m1, ((byte []) (obj)), ((StatusLine) (obj3)));
        if (l >= 200 && l <= 299)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        throw new IOException();
        obj;
        a("socket", m1, ((t) (new s())));
          goto _L5
_L4:
        obj = obj4;
        obj2 = new byte[0];
        obj = obj2;
          goto _L6
        obj2 = new j(l, ((byte []) (obj)), ((Map) (obj4)), false, SystemClock.elapsedRealtime() - l1);
        return ((j) (obj2));
        obj;
        a("connection", m1, ((t) (new s())));
          goto _L5
        obj;
        throw new RuntimeException((new StringBuilder()).append("Bad URL ").append(m1.getUrl()).toString(), ((Throwable) (obj)));
        obj1;
        obj3 = null;
        obj = obj2;
        obj2 = obj4;
_L7:
        if (obj2 != null)
        {
            l = ((HttpResponse) (obj2)).getStatusLine().getStatusCode();
            if (l == 301 || l == 302)
            {
                u.c("Request at %s has been redirected to %s", new Object[] {
                    m1.getOriginUrl(), m1.getUrl()
                });
            } else
            {
                u.c("Unexpected response code %d for %s", new Object[] {
                    Integer.valueOf(l), m1.getUrl()
                });
            }
            if (obj3 != null)
            {
                obj = new j(l, ((byte []) (obj3)), ((Map) (obj)), false, SystemClock.elapsedRealtime() - l1);
                if (l == 401 || l == 403)
                {
                    a("auth", m1, ((t) (new com.a.a.a(((j) (obj))))));
                } else
                if (l == 301 || l == 302)
                {
                    a("redirect", m1, ((t) (new com.a.a.a(((j) (obj))))));
                } else
                {
                    throw new r(((j) (obj)));
                }
            } else
            {
                throw new i(null);
            }
        } else
        {
            throw new k(((Throwable) (obj1)));
        }
          goto _L5
        obj4;
        obj3 = null;
        obj2 = obj1;
        obj1 = obj4;
          goto _L7
        IOException ioexception;
        ioexception;
        obj2 = obj1;
        obj1 = ioexception;
        ioexception = ((IOException) (obj));
        obj = obj4;
          goto _L7
_L2:
        if (l != 301 && l != 302) goto _L9; else goto _L8
    }

    static 
    {
        a = u.b;
    }
}

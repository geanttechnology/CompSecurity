// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d.a;

import android.os.SystemClock;
import com.mopub.d.f;
import com.mopub.d.h;
import com.mopub.d.i;
import com.mopub.d.j;
import com.mopub.d.l;
import com.mopub.d.p;
import com.mopub.d.q;
import com.mopub.d.r;
import com.mopub.d.s;
import com.mopub.d.t;
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

// Referenced classes of package com.mopub.d.a:
//            b, i, e

public final class a
    implements f
{

    protected static final boolean a;
    private static int d = 3000;
    private static int e = 4096;
    protected final e b;
    protected final b c;

    public a(e e1)
    {
        this(e1, new b(e));
    }

    private a(e e1, b b1)
    {
        b = e1;
        c = b1;
    }

    private static Map a(Header aheader[])
    {
        TreeMap treemap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int k = 0; k < aheader.length; k++)
        {
            treemap.put(aheader[k].getName(), aheader[k].getValue());
        }

        return treemap;
    }

    private static void a(String s1, l l1, s s2)
    {
        p p1 = l1.j;
        int k = l1.e();
        try
        {
            p1.a(s2);
        }
        // Misplaced declaration of an exception variable
        catch (s s2)
        {
            l1.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[] {
                s1, Integer.valueOf(k)
            }));
            throw s2;
        }
        l1.a(String.format("%s-retry [timeout=%s]", new Object[] {
            s1, Integer.valueOf(k)
        }));
    }

    private byte[] a(HttpEntity httpentity)
    {
        Object obj;
        Exception exception;
        com.mopub.d.a.i k;
        k = new com.mopub.d.a.i(c, (int)httpentity.getContentLength());
        exception = null;
        obj = exception;
        InputStream inputstream = httpentity.getContent();
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        obj = exception;
        throw new q();
        exception;
        byte abyte0[];
        byte abyte1[];
        int i1;
        try
        {
            httpentity.consumeContent();
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            t.a("Error occured when calling consumingContent", new Object[0]);
        }
        c.a(((byte []) (obj)));
        k.close();
        throw exception;
        obj = exception;
        abyte0 = c.a(1024);
_L2:
        obj = abyte0;
        i1 = inputstream.read(abyte0);
        if (i1 == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = abyte0;
        k.write(abyte0, 0, i1);
        if (true) goto _L2; else goto _L1
_L1:
        obj = abyte0;
        abyte1 = k.toByteArray();
        try
        {
            httpentity.consumeContent();
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            t.a("Error occured when calling consumingContent", new Object[0]);
        }
        c.a(abyte0);
        k.close();
        return abyte1;
    }

    public final i a(l l1)
    {
        long l2 = SystemClock.elapsedRealtime();
_L7:
        Object obj2;
        Object obj4;
        obj4 = null;
        obj2 = Collections.emptyMap();
        Object obj;
        Object obj1;
        obj = new HashMap();
        obj1 = l1.k;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        if (((com.mopub.d.b.a) (obj1)).b != null)
        {
            ((Map) (obj)).put("If-None-Match", ((com.mopub.d.b.a) (obj1)).b);
        }
        if (((com.mopub.d.b.a) (obj1)).c > 0L)
        {
            ((Map) (obj)).put("If-Modified-Since", DateUtils.formatDate(new Date(((com.mopub.d.b.a) (obj1)).c)));
        }
        obj1 = b.a(l1, ((Map) (obj)));
        obj = obj2;
        Object obj3 = ((HttpResponse) (obj1)).getStatusLine();
        obj = obj2;
        int k = ((StatusLine) (obj3)).getStatusCode();
        obj = obj2;
        obj4 = a(((HttpResponse) (obj1)).getAllHeaders());
        if (k != 304)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        obj = obj4;
        obj2 = l1.k;
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        obj = obj4;
        return new i(304, null, ((Map) (obj4)), true, SystemClock.elapsedRealtime() - l2);
        obj = obj4;
        ((com.mopub.d.b.a) (obj2)).f.putAll(((Map) (obj4)));
        obj = obj4;
        return new i(304, ((com.mopub.d.b.a) (obj2)).a, ((com.mopub.d.b.a) (obj2)).f, true, SystemClock.elapsedRealtime() - l2);
        obj = obj4;
        if (((HttpResponse) (obj1)).getEntity() == null) goto _L2; else goto _L1
_L1:
        obj = obj4;
        obj2 = a(((HttpResponse) (obj1)).getEntity());
        obj = obj2;
_L8:
        long l3 = SystemClock.elapsedRealtime() - l2;
        if (!a && l3 <= (long)d) goto _L4; else goto _L3
_L3:
        if (obj == null) goto _L6; else goto _L5
_L5:
        obj2 = Integer.valueOf(obj.length);
_L9:
        t.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] {
            l1, Long.valueOf(l3), obj2, Integer.valueOf(((StatusLine) (obj3)).getStatusCode()), Integer.valueOf(l1.j.b())
        });
          goto _L4
_L11:
        throw new IOException();
        obj;
        a("socket", l1, ((s) (new r())));
          goto _L7
_L2:
        obj = obj4;
        obj2 = new byte[0];
        obj = obj2;
          goto _L8
_L6:
        obj2 = "null";
          goto _L9
_L12:
        obj2 = new i(k, ((byte []) (obj)), ((Map) (obj4)), false, SystemClock.elapsedRealtime() - l2);
        return ((i) (obj2));
        obj;
        a("connection", l1, ((s) (new r())));
          goto _L7
        obj;
        throw new RuntimeException((new StringBuilder("Bad URL ")).append(l1.b).toString(), ((Throwable) (obj)));
        obj1;
        obj3 = null;
        obj = obj2;
        obj2 = obj4;
_L10:
        if (obj2 != null)
        {
            k = ((HttpResponse) (obj2)).getStatusLine().getStatusCode();
            t.c("Unexpected response code %d for %s", new Object[] {
                Integer.valueOf(k), l1.b
            });
            if (obj3 != null)
            {
                obj = new i(k, ((byte []) (obj3)), ((Map) (obj)), false, SystemClock.elapsedRealtime() - l2);
                if (k == 401 || k == 403)
                {
                    a("auth", l1, ((s) (new com.mopub.d.a(((i) (obj))))));
                } else
                {
                    throw new q(((i) (obj)));
                }
            } else
            {
                throw new h((byte)0);
            }
        } else
        {
            throw new j(((Throwable) (obj1)));
        }
          goto _L7
        obj4;
        obj3 = null;
        obj2 = obj1;
        obj1 = obj4;
          goto _L10
        IOException ioexception;
        ioexception;
        obj2 = obj1;
        obj1 = ioexception;
        ioexception = ((IOException) (obj));
        obj = obj4;
          goto _L10
_L4:
        if (k >= 200 && k <= 299) goto _L12; else goto _L11
    }

    static 
    {
        a = t.b;
    }
}

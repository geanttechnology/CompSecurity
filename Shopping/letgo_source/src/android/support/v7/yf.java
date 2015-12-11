// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.SystemClock;
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

// Referenced classes of package android.support.v7:
//            qs, yd, yg, ve, 
//            vz, xs, wu, lp, 
//            yk, tv, wv, lo, 
//            uw, su

public class yf
    implements qs
{

    protected static final boolean a;
    private static int d = 3000;
    private static int e = 4096;
    protected final yk b;
    protected final yg c;

    public yf(yk yk1)
    {
        this(yk1, new yg(e));
    }

    public yf(yk yk1, yg yg1)
    {
        b = yk1;
        c = yg1;
    }

    protected static Map a(Header aheader[])
    {
        TreeMap treemap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < aheader.length; i++)
        {
            treemap.put(aheader[i].getName(), aheader[i].getValue());
        }

        return treemap;
    }

    private void a(long l, ve ve1, byte abyte0[], StatusLine statusline)
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
            yd.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] {
                ve1, Long.valueOf(l), abyte0, Integer.valueOf(statusline.getStatusCode()), Integer.valueOf(ve1.s().b())
            });
        }
    }

    private static void a(String s, ve ve1, xs xs1)
        throws xs
    {
        vz vz1 = ve1.s();
        int i = ve1.r();
        try
        {
            vz1.a(xs1);
        }
        // Misplaced declaration of an exception variable
        catch (xs xs1)
        {
            ve1.b(String.format("%s-timeout-giveup [timeout=%s]", new Object[] {
                s, Integer.valueOf(i)
            }));
            throw xs1;
        }
        ve1.b(String.format("%s-retry [timeout=%s]", new Object[] {
            s, Integer.valueOf(i)
        }));
    }

    private void a(Map map, mo.a a1)
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
        throws IOException, wu
    {
        Object obj;
        Exception exception;
        lp lp1;
        lp1 = new lp(c, (int)httpentity.getContentLength());
        exception = null;
        obj = exception;
        InputStream inputstream = httpentity.getContent();
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        obj = exception;
        throw new wu();
        exception;
        byte abyte0[];
        byte abyte1[];
        int i;
        try
        {
            httpentity.consumeContent();
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            yd.a("Error occured when calling consumingContent", new Object[0]);
        }
        c.a(((byte []) (obj)));
        lp1.close();
        throw exception;
        obj = exception;
        abyte0 = c.a(1024);
_L2:
        obj = abyte0;
        i = inputstream.read(abyte0);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = abyte0;
        lp1.write(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
_L1:
        obj = abyte0;
        abyte1 = lp1.toByteArray();
        try
        {
            httpentity.consumeContent();
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            yd.a("Error occured when calling consumingContent", new Object[0]);
        }
        c.a(abyte0);
        lp1.close();
        return abyte1;
    }

    public tv a(ve ve1)
        throws xs
    {
        long l = SystemClock.elapsedRealtime();
_L3:
        Object obj2;
        Object obj4;
        obj4 = null;
        obj2 = Collections.emptyMap();
        Object obj1;
        HashMap hashmap = new HashMap();
        a(((Map) (hashmap)), ve1.f());
        obj1 = b.a(ve1, hashmap);
        Object obj = obj2;
        Object obj3 = ((HttpResponse) (obj1)).getStatusLine();
        obj = obj2;
        int i = ((StatusLine) (obj3)).getStatusCode();
        obj = obj2;
        obj4 = a(((HttpResponse) (obj1)).getAllHeaders());
        if (i != 304)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj = obj4;
        obj2 = ve1.f();
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        obj = obj4;
        return new tv(304, null, ((Map) (obj4)), true, SystemClock.elapsedRealtime() - l);
        obj = obj4;
        ((mo.a) (obj2)).g.putAll(((Map) (obj4)));
        obj = obj4;
        return new tv(304, ((mo.a) (obj2)).a, ((mo.a) (obj2)).g, true, SystemClock.elapsedRealtime() - l);
        obj = obj4;
        if (((HttpResponse) (obj1)).getEntity() == null) goto _L2; else goto _L1
_L1:
        obj = obj4;
        obj2 = a(((HttpResponse) (obj1)).getEntity());
        obj = obj2;
_L4:
        a(SystemClock.elapsedRealtime() - l, ve1, ((byte []) (obj)), ((StatusLine) (obj3)));
        if (i >= 200 && i <= 299)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        throw new IOException();
        obj;
        a("socket", ve1, ((xs) (new wv())));
          goto _L3
_L2:
        obj = obj4;
        obj2 = new byte[0];
        obj = obj2;
          goto _L4
        obj2 = new tv(i, ((byte []) (obj)), ((Map) (obj4)), false, SystemClock.elapsedRealtime() - l);
        return ((tv) (obj2));
        obj;
        a("connection", ve1, ((xs) (new wv())));
          goto _L3
        obj;
        throw new RuntimeException((new StringBuilder()).append("Bad URL ").append(ve1.d()).toString(), ((Throwable) (obj)));
        obj1;
        obj3 = null;
        obj = obj2;
        obj2 = obj4;
_L5:
        if (obj2 != null)
        {
            int j = ((HttpResponse) (obj2)).getStatusLine().getStatusCode();
            yd.c("Unexpected response code %d for %s", new Object[] {
                Integer.valueOf(j), ve1.d()
            });
            if (obj3 != null)
            {
                obj = new tv(j, ((byte []) (obj3)), ((Map) (obj)), false, SystemClock.elapsedRealtime() - l);
                if (j == 401 || j == 403)
                {
                    a("auth", ve1, ((xs) (new lo(((tv) (obj))))));
                } else
                {
                    throw new wu(((tv) (obj)));
                }
            } else
            {
                throw new su(null);
            }
        } else
        {
            throw new uw(((Throwable) (obj1)));
        }
          goto _L3
        obj4;
        obj3 = null;
        obj2 = obj1;
        obj1 = obj4;
          goto _L5
        IOException ioexception;
        ioexception;
        obj2 = obj1;
        obj1 = ioexception;
        ioexception = ((IOException) (obj));
        obj = obj4;
          goto _L5
    }

    static 
    {
        a = yd.b;
    }
}

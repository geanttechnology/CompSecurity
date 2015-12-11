// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

final class bk
{

    private final ao a;
    private final ab b;
    private final ag c;
    private final Map d = new WeakHashMap();

    bk(ag ag1, ao ao1, ab ab1)
    {
        a = ao1;
        c = ag1;
        b = ab1;
    }

    static ag a(bk bk1)
    {
        return bk1.c;
    }

    static void a(bk bk1, URLConnection urlconnection, long l)
    {
        bk1.a(urlconnection, l);
    }

    private void a(URLConnection urlconnection, long l)
    {
        this;
        JVM INSTR monitorenter ;
        urlconnection = e(urlconnection);
        if (urlconnection == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        bm.b(urlconnection, true);
        bm.b(urlconnection, l);
        if (bm.e(urlconnection) < 0L)
        {
            bm.c(urlconnection, System.currentTimeMillis());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        urlconnection;
        throw urlconnection;
    }

    static ao b(bk bk1)
    {
        return bk1.a;
    }

    private bm e(URLConnection urlconnection)
    {
        if (d.containsKey(urlconnection))
        {
            return (bm)d.get(urlconnection);
        } else
        {
            return null;
        }
    }

    public final void a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator;
        long l;
        l = System.currentTimeMillis();
        iterator = d.keySet().iterator();
_L2:
        URLConnection urlconnection;
        bm bm1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_105;
            }
            urlconnection = (URLConnection)iterator.next();
            bm1 = e(urlconnection);
        } while (bm1 == null);
        if (bm.a(bm1) || !bm.b(bm1) || bm.c(bm1) + 10000L >= l) goto _L2; else goto _L1
_L1:
        bm.a(bm1, true);
        bm.a(bm1, urlconnection);
          goto _L2
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    final void a(URLConnection urlconnection)
    {
        this;
        JVM INSTR monitorenter ;
        urlconnection = e(urlconnection);
        if (urlconnection == null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        bm.b(urlconnection, true);
        this;
        JVM INSTR monitorexit ;
        return;
        urlconnection;
        throw urlconnection;
    }

    final void a(URLConnection urlconnection, Exception exception)
    {
        this;
        JVM INSTR monitorenter ;
        bm bm1 = e(urlconnection);
        if (bm1 != null) goto _L2; else goto _L1
_L1:
        urlconnection = c.a(urlconnection.getURL(), exception);
        if (urlconnection == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        a.b(urlconnection);
_L4:
        b.a(ad.c);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        bm.a(bm1, true);
        urlconnection = c.a(urlconnection.getURL(), exception, bm.d(bm1), System.currentTimeMillis());
        if (urlconnection == null) goto _L4; else goto _L3
_L3:
        a.b(urlconnection);
          goto _L4
        urlconnection;
        throw urlconnection;
    }

    final void b(URLConnection urlconnection)
    {
        this;
        JVM INSTR monitorenter ;
        if (e(urlconnection) != null) goto _L2; else goto _L1
_L1:
        d.put(urlconnection, new bm(this, urlconnection.getURL(), (byte)0));
        if (!(urlconnection instanceof HttpURLConnection)) goto _L2; else goto _L3
_L3:
        HttpURLConnection httpurlconnection = (HttpURLConnection)urlconnection;
        for (Iterator iterator = q.a().entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Iterator iterator1 = ((List)entry.getValue()).iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                httpurlconnection.addRequestProperty((String)entry.getKey(), s);
            }
        }

          goto _L4
        urlconnection;
        bc.a("Agent couldn't add server correlation header because headers have already been sent.");
_L2:
        b.a(ad.a);
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (!bc.a()) goto _L2; else goto _L5
_L5:
        bc.a((new StringBuilder("Agent added server correlation header to request: ")).append(urlconnection.getURL()).toString());
          goto _L2
        urlconnection;
        throw urlconnection;
    }

    final void c(URLConnection urlconnection)
    {
        this;
        JVM INSTR monitorenter ;
        bm bm1 = e(urlconnection);
        if (bm1 == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        bm.a(bm1, System.currentTimeMillis());
        bm.a(bm1, urlconnection);
        b.a(ad.b);
        this;
        JVM INSTR monitorexit ;
        return;
        urlconnection;
        throw urlconnection;
    }

    final void d(URLConnection urlconnection)
    {
        this;
        JVM INSTR monitorenter ;
        bm bm1 = e(urlconnection);
        if (bm1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        boolean flag;
        if (bm.a(bm1))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        flag = bm.f(bm1);
        bm.a(bm1, System.currentTimeMillis());
        bm.a(bm1, true);
        bm.a(bm1, urlconnection);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        b.a(ad.b);
        this;
        JVM INSTR monitorexit ;
        return;
        urlconnection;
        throw urlconnection;
    }

    // Unreferenced inner class bk$1

/* anonymous class */
    final class _cls1 extends bl
    {

        private URLConnection b;

        final InputStream a()
        {
            return b.getInputStream();
        }

            
            {
                b = urlconnection;
                super(bk.this, (byte)0);
            }
    }

}

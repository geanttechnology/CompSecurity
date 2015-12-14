// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.asyncnet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.socialin.asyncnet:
//            c, Request, d

public final class b
{

    private static b a = null;
    private Map b;
    private Map c;
    private LinkedList d;

    private b()
    {
        b = new HashMap();
        c = new HashMap();
        d = new LinkedList();
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
    }

    public static b a()
    {
        com/socialin/asyncnet/b;
        JVM INSTR monitorenter ;
        b b1;
        if (a == null)
        {
            a = new b();
        }
        b1 = a;
        com/socialin/asyncnet/b;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(Request request)
    {
        this;
        JVM INSTR monitorenter ;
        request = (c)b.get(request);
        request.b = true;
        request.a(new Void[0]);
        this;
        JVM INSTR monitorexit ;
        return;
        request;
        throw request;
    }

    private void a(Request request, c c1)
    {
        this;
        JVM INSTR monitorenter ;
        b.remove(request);
        ((Set)c.get(c1.a)).remove(request);
        if (b.size() - d.size() < 50 && d.size() > 0)
        {
            a(b());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        request;
        throw request;
    }

    static void a(b b1, Request request, c c1)
    {
        b1.a(request, c1);
    }

    private Request b()
    {
        this;
        JVM INSTR monitorenter ;
        Request request = (Request)d.removeFirst();
        this;
        JVM INSTR monitorexit ;
        return request;
        Exception exception;
        exception;
        throw exception;
    }

    private void b(Request request)
    {
        this;
        JVM INSTR monitorenter ;
        d.add(request);
        this;
        JVM INSTR monitorexit ;
        return;
        request;
        throw request;
    }

    private void c(Request request)
    {
        this;
        JVM INSTR monitorenter ;
        c c1 = (c)b.get(request);
        if (c1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!c1.b)
        {
            break; /* Loop/switch isn't completed */
        }
        c1.cancel(true);
_L4:
        a(request, c1);
        if (true) goto _L1; else goto _L3
        request;
        throw request;
_L3:
        d.remove(request);
          goto _L4
    }

    public final Request a(Request request, d d1)
    {
        return a(request, null, d1, true);
    }

    public final Request a(Request request, String s, d d1, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (request != null) goto _L2; else goto _L1
_L1:
        d1.onFailure(new NullPointerException(), null);
        request = null;
_L3:
        this;
        JVM INSTR monitorexit ;
        return request;
_L2:
        Set set;
        d1 = new c(this, s, request, d1);
        b.put(request, d1);
        set = (Set)c.get(s);
        d1 = set;
        if (set != null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        d1 = new HashSet();
        c.put(s, d1);
        d1.add(request);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        if (b.size() - d.size() >= 50)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        a(request);
          goto _L3
        request;
        throw request;
        b(request);
          goto _L3
    }

    public final void a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = b.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Request request = (Request)iterator.next();
            if (request.d == i)
            {
                c c1 = (c)b.get(request);
                d.remove(request);
                if (c1.b)
                {
                    c1.cancel(true);
                }
            }
        } while (true);
        break MISSING_BLOCK_LABEL_91;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public final void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = (Set)c.get(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        while (!s.isEmpty()) 
        {
            c((Request)s.iterator().next());
        }
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

}

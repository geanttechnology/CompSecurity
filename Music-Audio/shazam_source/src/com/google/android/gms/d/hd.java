// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.google.android.gms.d:
//            hc

public class hd
    implements hc
{
    final class a
    {

        public final hc.c a;
        public final hc.a b;
        final hd c;

        public a(hc.c c1, hc.a a1)
        {
            c = hd.this;
            super();
            a = c1;
            b = a1;
        }
    }


    private final Object a = new Object();
    protected int b;
    protected final BlockingQueue c = new LinkedBlockingQueue();
    protected Object d;

    public hd()
    {
        b = 0;
    }

    public final void a(hc.c c1, hc.a a1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (b != 1) goto _L2; else goto _L1
_L1:
        c1.a(d);
_L5:
        return;
_L2:
        if (b != -1) goto _L4; else goto _L3
_L3:
        a1.a();
          goto _L5
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
_L4:
        if (b != 0) goto _L5; else goto _L6
_L6:
        c.add(new a(c1, a1));
          goto _L5
    }

    public final void a(Object obj)
    {
        Object obj1 = a;
        obj1;
        JVM INSTR monitorenter ;
        if (b != 0)
        {
            throw new UnsupportedOperationException();
        }
        break MISSING_BLOCK_LABEL_27;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        d = obj;
        b = 1;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((a)iterator.next()).a.a(obj)) { }
        c.clear();
        obj1;
        JVM INSTR monitorexit ;
    }

    public final void d()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (b != 0)
        {
            throw new UnsupportedOperationException();
        }
        break MISSING_BLOCK_LABEL_27;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        b = -1;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((a)iterator.next()).b.a()) { }
        c.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    public final int e()
    {
        return b;
    }
}

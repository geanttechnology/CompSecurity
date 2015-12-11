// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a;

import c.r;
import com.g.b.a.c.a;
import java.io.FileNotFoundException;

// Referenced classes of package com.g.b.a:
//            b, c

public final class <init>
{

    final d a;
    final boolean b[];
    boolean c;
    final b d;
    private boolean e;

    public final r a(int i)
    {
        b b1 = d;
        b1;
        JVM INSTR monitorenter ;
        if (a.f != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Object obj;
        obj;
        b1;
        JVM INSTR monitorexit ;
        throw obj;
        Object obj1;
        if (!a.e)
        {
            b[i] = true;
        }
        obj1 = a.d[i];
        obj1 = com.g.b.a.b.i(d).b(((java.io.File) (obj1)));
        obj1 = new c(((r) (obj1))) {

            final b.a a;

            protected final void a()
            {
                synchronized (a.d)
                {
                    a.c = true;
                }
                return;
                exception;
                b2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = b.a.this;
                super(r);
            }
        };
        b1;
        JVM INSTR monitorexit ;
        return ((r) (obj1));
        obj1;
        obj1 = com.g.b.a.b.b();
        b1;
        JVM INSTR monitorexit ;
        return ((r) (obj1));
    }

    public final void a()
    {
        b b1 = d;
        b1;
        JVM INSTR monitorenter ;
        if (!c)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        com.g.b.a.b.a(d, this, false);
        com.g.b.a.b.a(d, a);
_L2:
        e = true;
        return;
        com.g.b.a.b.a(d, this, true);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        b1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void b()
    {
        synchronized (d)
        {
            com.g.b.a.b.a(d, this, false);
        }
        return;
        exception;
        b1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private nit>(b b1, nit> nit>)
    {
        d = b1;
        super();
        a = nit>;
        if (nit>.e)
        {
            b1 = null;
        } else
        {
            b1 = new boolean[com.g.b.a.b.h(b1)];
        }
        b = b1;
    }

    b(b b1, b b2, byte byte0)
    {
        this(b1, b2);
    }
}

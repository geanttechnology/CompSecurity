// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

// Referenced classes of package com.a.a.a:
//            h, c, g

public final class f
{

    final h a;
    final boolean b[];
    boolean c;
    final c d;
    private boolean e;

    private f(c c1, h h1)
    {
        d = c1;
        super();
        a = h1;
        if (h1.c)
        {
            c1 = null;
        } else
        {
            c1 = new boolean[com.a.a.a.c.f(c1)];
        }
        b = c1;
    }

    f(c c1, h h1, byte byte0)
    {
        this(c1, h1);
    }

    public final OutputStream a(int i)
    {
        c c1 = d;
        c1;
        JVM INSTR monitorenter ;
        if (a.d != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Object obj;
        obj;
        c1;
        JVM INSTR monitorexit ;
        throw obj;
        File file;
        if (!a.c)
        {
            b[i] = true;
        }
        file = a.b(i);
        Object obj1 = new FileOutputStream(file);
_L1:
        obj1 = new g(this, ((OutputStream) (obj1)), (byte)0);
        c1;
        JVM INSTR monitorexit ;
        return ((OutputStream) (obj1));
        obj1;
        com.a.a.a.c.g(d).mkdirs();
        obj1 = new FileOutputStream(file);
          goto _L1
        obj1;
        obj1 = com.a.a.a.c.a();
        c1;
        JVM INSTR monitorexit ;
        return ((OutputStream) (obj1));
    }

    public final void a()
    {
        if (c)
        {
            com.a.a.a.c.a(d, this, false);
            d.b(a.a);
        } else
        {
            com.a.a.a.c.a(d, this, true);
        }
        e = true;
    }

    public final void b()
    {
        com.a.a.a.c.a(d, this, false);
    }
}

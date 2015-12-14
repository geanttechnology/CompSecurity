// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.a.a.a.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

// Referenced classes of package com.nostra13.universalimageloader.a.a.a.a:
//            d, a, c

public final class b
{

    final a a;
    private final d b;
    private final boolean c[];
    private boolean d;
    private boolean e;

    private b(a a1, d d1)
    {
        a = a1;
        super();
        b = d1;
        if (com.nostra13.universalimageloader.a.a.a.a.d.d(d1))
        {
            a1 = null;
        } else
        {
            a1 = new boolean[com.nostra13.universalimageloader.a.a.a.a.a.f(a1)];
        }
        c = a1;
    }

    b(a a1, d d1, a._cls1 _pcls1)
    {
        this(a1, d1);
    }

    static d a(b b1)
    {
        return b1.b;
    }

    static boolean a(b b1, boolean flag)
    {
        b1.d = flag;
        return flag;
    }

    static boolean[] b(b b1)
    {
        return b1.c;
    }

    public OutputStream a(int i)
    {
        a a1 = a;
        a1;
        JVM INSTR monitorenter ;
        if (com.nostra13.universalimageloader.a.a.a.a.d.a(b) != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Object obj;
        obj;
        a1;
        JVM INSTR monitorexit ;
        throw obj;
        File file;
        if (!com.nostra13.universalimageloader.a.a.a.a.d.d(b))
        {
            c[i] = true;
        }
        file = b.b(i);
        Object obj1 = new FileOutputStream(file);
_L1:
        obj1 = new c(this, ((OutputStream) (obj1)), null);
        a1;
        JVM INSTR monitorexit ;
        return ((OutputStream) (obj1));
        obj1;
        com.nostra13.universalimageloader.a.a.a.a.a.g(a).mkdirs();
        obj1 = new FileOutputStream(file);
          goto _L1
        obj1;
        obj1 = com.nostra13.universalimageloader.a.a.a.a.a.b();
        a1;
        JVM INSTR monitorexit ;
        return ((OutputStream) (obj1));
    }

    public void a()
    {
        if (d)
        {
            com.nostra13.universalimageloader.a.a.a.a.a.a(a, this, false);
            a.c(com.nostra13.universalimageloader.a.a.a.a.d.c(b));
        } else
        {
            com.nostra13.universalimageloader.a.a.a.a.a.a(a, this, true);
        }
        e = true;
    }

    public void b()
    {
        com.nostra13.universalimageloader.a.a.a.a.a.a(a, this, false);
    }
}

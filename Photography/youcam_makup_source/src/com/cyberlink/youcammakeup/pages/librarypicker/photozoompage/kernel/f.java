// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import java.io.FileOutputStream;
import java.io.OutputStream;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            h, g, e

public final class f
{

    final e a;
    private final h b;
    private boolean c;

    private f(e e1, h h1)
    {
        a = e1;
        super();
        b = h1;
    }

    f(e e1, h h1, e._cls1 _pcls1)
    {
        this(e1, h1);
    }

    static h a(f f1)
    {
        return f1.b;
    }

    static boolean a(f f1, boolean flag)
    {
        f1.c = flag;
        return flag;
    }

    public OutputStream a(int i)
    {
        e e1 = a;
        e1;
        JVM INSTR monitorenter ;
        if (h.a(b) != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        e1;
        JVM INSTR monitorexit ;
        throw exception;
        g g1 = new g(this, new FileOutputStream(b.b(i)), null);
        e1;
        JVM INSTR monitorexit ;
        return g1;
    }

    public void a()
    {
        if (c)
        {
            e.a(a, this, false);
            a.c(h.c(b));
            return;
        } else
        {
            e.a(a, this, true);
            return;
        }
    }

    public void b()
    {
        e.a(a, this, false);
    }
}

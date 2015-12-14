// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.o;

import java.io.File;
import java.io.IOException;

// Referenced classes of package myobfuscated.o:
//            c, a

public final class b
{

    final c a;
    final boolean b[];
    public boolean c;
    public final a d;

    private b(a a1, c c1)
    {
        d = a1;
        super();
        a = c1;
        if (c1.e)
        {
            a1 = null;
        } else
        {
            a1 = new boolean[myobfuscated.o.a.f(a1)];
        }
        b = a1;
    }

    b(a a1, c c1, byte byte0)
    {
        this(a1, c1);
    }

    public final File a()
    {
        a a1 = d;
        a1;
        JVM INSTR monitorenter ;
        if (a.f != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        a1;
        JVM INSTR monitorexit ;
        throw exception;
        File file;
        if (!a.e)
        {
            b[0] = true;
        }
        file = a.d[0];
        if (!myobfuscated.o.a.g(d).exists())
        {
            myobfuscated.o.a.g(d).mkdirs();
        }
        a1;
        JVM INSTR monitorexit ;
        return file;
    }

    public final void b()
    {
        myobfuscated.o.a.a(d, this, false);
    }

    public final void c()
    {
        if (c)
        {
            break MISSING_BLOCK_LABEL_11;
        }
        b();
        return;
        IOException ioexception;
        ioexception;
    }
}

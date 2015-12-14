// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.FileOutputStream;
import java.io.OutputStream;

public final class zl
{

    final zj a;
    private final zn b;
    private boolean c;

    private zl(zj zj1, zn zn1)
    {
        a = zj1;
        super();
        b = zn1;
    }

    zl(zj zj1, zn zn1, zk zk)
    {
        this(zj1, zn1);
    }

    static zn a(zl zl1)
    {
        return zl1.b;
    }

    static boolean a(zl zl1, boolean flag)
    {
        zl1.c = flag;
        return flag;
    }

    public OutputStream a(int i)
    {
        zj zj1 = a;
        zj1;
        JVM INSTR monitorenter ;
        if (zn.a(b) != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        zj1;
        JVM INSTR monitorexit ;
        throw exception;
        zm zm1 = new zm(this, new FileOutputStream(b.b(i)), null);
        zj1;
        JVM INSTR monitorexit ;
        return zm1;
    }

    public void a()
    {
        if (c)
        {
            zj.a(a, this, false);
            a.c(zn.c(b));
            return;
        } else
        {
            zj.a(a, this, true);
            return;
        }
    }

    public void b()
    {
        zj.a(a, this, false);
    }
}

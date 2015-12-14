// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.FileOutputStream;
import java.io.OutputStream;

public final class fj
{

    final fi a;
    private final fl b;
    private boolean c;

    private fj(fi fi1, fl fl1)
    {
        a = fi1;
        super();
        b = fl1;
    }

    fj(fi fi1, fl fl1, fi._cls1 _pcls1)
    {
        this(fi1, fl1);
    }

    static fl a(fj fj1)
    {
        return fj1.b;
    }

    static boolean a(fj fj1, boolean flag)
    {
        fj1.c = flag;
        return flag;
    }

    public OutputStream a(int i)
    {
        fi fi1 = a;
        fi1;
        JVM INSTR monitorenter ;
        if (fl.a(b) != this)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_31;
        Exception exception;
        exception;
        fi1;
        JVM INSTR monitorexit ;
        throw exception;
        fk fk1 = new fk(this, new FileOutputStream(b.b(i)), null);
        fi1;
        JVM INSTR monitorexit ;
        return fk1;
    }

    public void a()
    {
        if (c)
        {
            fi.a(a, this, false);
            a.c(fl.c(b));
            return;
        } else
        {
            fi.a(a, this, true);
            return;
        }
    }

    public void b()
    {
        fi.a(a, this, false);
    }
}

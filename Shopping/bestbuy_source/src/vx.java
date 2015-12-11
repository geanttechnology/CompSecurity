// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class vx extends wm
{

    private final Object a = new Object();
    private wa b;
    private vw c;

    public vx()
    {
    }

    public void a()
    {
        synchronized (a)
        {
            if (c != null)
            {
                c.k();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int i)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        Exception exception;
        if (i == 3)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        b.a(i);
        b = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(vw vw1)
    {
        synchronized (a)
        {
            c = vw1;
        }
        return;
        vw1;
        obj;
        JVM INSTR monitorexit ;
        throw vw1;
    }

    public void a(wa wa1)
    {
        synchronized (a)
        {
            b = wa1;
        }
        return;
        wa1;
        obj;
        JVM INSTR monitorexit ;
        throw wa1;
    }

    public void b()
    {
        synchronized (a)
        {
            if (c != null)
            {
                c.l();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c()
    {
        synchronized (a)
        {
            if (c != null)
            {
                c.m();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d()
    {
        synchronized (a)
        {
            if (c != null)
            {
                c.n();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void e()
    {
label0:
        {
            synchronized (a)
            {
                if (b == null)
                {
                    break label0;
                }
                b.a(0);
                b = null;
            }
            return;
        }
        if (c != null)
        {
            c.o();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

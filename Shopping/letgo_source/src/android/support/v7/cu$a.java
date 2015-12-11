// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            cu

public class <init>
{

    final cu a;

    public cu a()
    {
        return a;
    }

    public boolean a(Exception exception)
    {
label0:
        {
            synchronized (cu.a(a))
            {
                if (!cu.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        cu.a(a, true);
        cu.a(a, exception);
        cu.a(a).notifyAll();
        cu.c(a);
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean a(Object obj)
    {
label0:
        {
            synchronized (cu.a(a))
            {
                if (!cu.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        cu.a(a, true);
        cu.a(a, obj);
        cu.a(a).notifyAll();
        cu.c(a);
        obj1;
        JVM INSTR monitorexit ;
        return true;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void b(Exception exception)
    {
        if (!a(exception))
        {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        } else
        {
            return;
        }
    }

    public void b(Object obj)
    {
        if (!a(obj))
        {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        } else
        {
            return;
        }
    }

    public boolean b()
    {
label0:
        {
            synchronized (cu.a(a))
            {
                if (!cu.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        cu.a(a, true);
        cu.b(a, true);
        cu.a(a).notifyAll();
        cu.c(a);
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c()
    {
        if (!b())
        {
            throw new IllegalStateException("Cannot cancel a completed task.");
        } else
        {
            return;
        }
    }

    private ception(cu cu1)
    {
        a = cu1;
        super();
    }

    a(cu cu1, a a1)
    {
        this(cu1);
    }
}

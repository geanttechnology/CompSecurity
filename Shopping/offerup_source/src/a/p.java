// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;


// Referenced classes of package a:
//            i

public final class p
{

    final i a;

    private p(i j)
    {
        a = j;
        super();
    }

    p(i j, byte byte0)
    {
        this(j);
    }

    private boolean b(Exception exception)
    {
label0:
        {
            synchronized (i.a(a))
            {
                if (!i.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        i.a(a, true);
        i.a(a, exception);
        i.a(a).notifyAll();
        i.c(a);
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean b(Object obj)
    {
label0:
        {
            synchronized (i.a(a))
            {
                if (!i.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        i.a(a, true);
        i.a(a, obj);
        i.a(a).notifyAll();
        i.c(a);
        obj1;
        JVM INSTR monitorexit ;
        return true;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private boolean c()
    {
label0:
        {
            synchronized (i.a(a))
            {
                if (!i.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        i.a(a, true);
        i.b(a, true);
        i.a(a).notifyAll();
        i.c(a);
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final i a()
    {
        return a;
    }

    public final void a(Exception exception)
    {
        if (!b(exception))
        {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        } else
        {
            return;
        }
    }

    public final void a(Object obj)
    {
        if (!b(obj))
        {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        } else
        {
            return;
        }
    }

    public final void b()
    {
        if (!c())
        {
            throw new IllegalStateException("Cannot cancel a completed task.");
        } else
        {
            return;
        }
    }
}

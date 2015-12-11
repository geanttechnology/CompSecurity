// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;


// Referenced classes of package a:
//            h

public final class o
{

    public final h a;

    private o(h h1)
    {
        a = h1;
        super();
    }

    o(h h1, byte byte0)
    {
        this(h1);
    }

    private boolean b()
    {
label0:
        {
            synchronized (h.a(a))
            {
                if (!h.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        h.c(a);
        h.d(a);
        h.a(a).notifyAll();
        h.e(a);
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean b(Exception exception)
    {
label0:
        {
            synchronized (h.a(a))
            {
                if (!h.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        h.c(a);
        h.a(a, exception);
        h.a(a).notifyAll();
        h.e(a);
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
            synchronized (h.a(a))
            {
                if (!h.b(a))
                {
                    break label0;
                }
            }
            return false;
        }
        h.c(a);
        h.a(a, obj);
        h.a(a).notifyAll();
        h.e(a);
        obj1;
        JVM INSTR monitorexit ;
        return true;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public final void a()
    {
        if (!b())
        {
            throw new IllegalStateException("Cannot cancel a completed task.");
        } else
        {
            return;
        }
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
}

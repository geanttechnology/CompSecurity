// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d;

import e.b.f;
import e.d.a.a;
import e.d.d.a.x;
import e.k;
import java.io.PrintStream;
import java.util.Queue;

// Referenced classes of package e.d.d:
//            c, f, g, q, 
//            a

public final class e
    implements k
{

    public static final int b;
    private static final a c = e.d.a.a.a();
    private static int f;
    private static e.d.d.a g = new e.d.d.f();
    private static e.d.d.a h = new g();
    public volatile Object a;
    private Queue d;
    private final e.d.d.a e;

    e()
    {
        this(((Queue) (new q(b))), b);
    }

    private e(e.d.d.a a1, int i)
    {
        e = a1;
        d = (Queue)a1.a();
    }

    private e(Queue queue, int i)
    {
        d = queue;
        e = null;
    }

    public static e a()
    {
        if (x.a())
        {
            return new e(g, b);
        } else
        {
            return new e();
        }
    }

    public static boolean b(Object obj)
    {
        return e.d.a.a.b(obj);
    }

    public static Object c(Object obj)
    {
        return e.d.a.a.c(obj);
    }

    public static e d()
    {
        if (x.a())
        {
            return new e(h, b);
        } else
        {
            return new e();
        }
    }

    public final void a(Object obj)
    {
        boolean flag = true;
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        Queue queue = d;
        if (queue == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (queue.offer(e.d.a.a.a(obj)))
        {
            flag = false;
        }
_L1:
        this;
        JVM INSTR monitorexit ;
        if (flag1)
        {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        break MISSING_BLOCK_LABEL_64;
        flag1 = true;
        flag = false;
          goto _L1
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (flag)
        {
            throw new f();
        } else
        {
            return;
        }
    }

    public final void b()
    {
        e();
    }

    public final boolean c()
    {
        return d == null;
    }

    public final void e()
    {
        this;
        JVM INSTR monitorenter ;
        Queue queue;
        e.d.d.a a1;
        queue = d;
        a1 = e;
        if (a1 == null || queue == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        queue.clear();
        d = null;
        a1.a(queue);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean f()
    {
        Queue queue = d;
        if (queue == null)
        {
            return true;
        } else
        {
            return queue.isEmpty();
        }
    }

    public final Object g()
    {
        this;
        JVM INSTR monitorenter ;
        Queue queue = d;
        if (queue != null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        Object obj;
        Object obj1;
        obj = queue.poll();
        obj1 = a;
        if (obj != null || obj1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        if (queue.peek() != null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        a = null;
        obj = obj1;
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Object h()
    {
        this;
        JVM INSTR monitorenter ;
        Queue queue = d;
        if (queue != null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        this;
        JVM INSTR monitorexit ;
        return null;
        Object obj;
        Object obj1;
        obj = queue.peek();
        obj1 = a;
        if (obj != null || obj1 == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        if (queue.peek() == null)
        {
            obj = obj1;
        }
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        f = 128;
        if (e.d.d.c.a())
        {
            f = 16;
        }
        String s = System.getProperty("rx.ring-buffer.size");
        if (s != null)
        {
            try
            {
                f = Integer.parseInt(s);
            }
            catch (Exception exception)
            {
                System.err.println((new StringBuilder("Failed to set 'rx.buffer.size' with value ")).append(s).append(" => ").append(exception.getMessage()).toString());
            }
        }
        b = f;
    }
}

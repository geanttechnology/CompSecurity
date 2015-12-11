// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public abstract class awe
    implements awh, awl
{

    private final Object a = new Object();
    public awf b;
    private final CountDownLatch c = new CountDownLatch(1);
    private final ArrayList d = new ArrayList();
    private awo e;
    private volatile awn f;
    private volatile boolean g;
    private boolean h;
    private boolean i;
    private axw j;

    awe()
    {
    }

    static void a(awe awe1)
    {
        synchronized (awe1.a)
        {
            if (!awe1.d())
            {
                awe1.a(awe1.a(Status.b));
                awe1.i = true;
            }
        }
        return;
        awe1;
        obj;
        JVM INSTR monitorexit ;
        throw awe1;
    }

    private void b(awn awn1)
    {
        f = awn1;
        j = null;
        c.countDown();
        f.a_();
        if (e != null)
        {
            b.removeMessages(2);
            if (!h)
            {
                b.a(e, e());
            }
        }
        for (awn1 = d.iterator(); awn1.hasNext(); awn1.next()) { }
        d.clear();
    }

    private boolean d()
    {
        return c.getCount() == 0L;
    }

    private awn e()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        awn awn1;
        Exception exception;
        boolean flag;
        if (!g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.a(flag, "Result has already been consumed.");
        a.a(d(), "Result is not ready.");
        awn1 = f;
        b();
        obj;
        JVM INSTR monitorexit ;
        return awn1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean f()
    {
        boolean flag;
        synchronized (a)
        {
            flag = h;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public abstract awn a(Status status);

    public final void a()
    {
label0:
        {
            synchronized (a)
            {
                if (!h && !g)
                {
                    break label0;
                }
            }
            return;
        }
        a.a(f);
        e = null;
        h = true;
        b(a(Status.c));
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(awn awn1)
    {
        boolean flag1;
label0:
        {
            flag1 = true;
            synchronized (a)
            {
                if (!i && !h)
                {
                    break label0;
                }
                a.a(awn1);
            }
            return;
        }
        boolean flag;
        if (!d())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.a(flag, "Results have already been set");
        if (!g)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        a.a(flag, "Result has already been consumed");
        b(awn1);
        obj;
        JVM INSTR monitorexit ;
        return;
        awn1;
        obj;
        JVM INSTR monitorexit ;
        throw awn1;
    }

    public final void a(awo awo)
    {
label0:
        {
            boolean flag;
            if (!g)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            a.a(flag, "Result has already been consumed.");
            synchronized (a)
            {
                if (!f())
                {
                    break label0;
                }
            }
            return;
        }
        if (!d())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        b.a(awo, e());
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        awo;
        obj;
        JVM INSTR monitorexit ;
        throw awo;
        e = awo;
          goto _L1
    }

    public final void a(Object obj)
    {
        a((awn)obj);
    }

    protected void b()
    {
        g = true;
        f = null;
        e = null;
    }
}

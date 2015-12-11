// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public abstract class qh
    implements qk, qq
{

    protected final qi a;
    private final Object b = new Object();
    private final CountDownLatch c = new CountDownLatch(1);
    private final ArrayList d = new ArrayList();
    private qu e;
    private volatile qt f;
    private volatile boolean g;
    private boolean h;
    private boolean i;
    private adl j;

    protected qh(Looper looper)
    {
        a = new qi(looper);
    }

    static void a(qh qh1)
    {
        qh1.j();
    }

    private void b(qt qt1)
    {
        f = qt1;
        j = null;
        c.countDown();
        qt1 = f.b();
        if (e != null)
        {
            a.a();
            if (!h)
            {
                a.a(e, h());
            }
        }
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((qr)iterator.next()).a(qt1)) { }
        d.clear();
    }

    private qt h()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        qt qt1;
        Exception exception;
        boolean flag;
        if (!g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.a(flag, "Result has already been consumed.");
        ady.a(a(), "Result is not ready.");
        qt1 = f;
        e();
        obj;
        JVM INSTR monitorexit ;
        return qt1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void i()
    {
        synchronized (b)
        {
            if (!a())
            {
                a(a(Status.b));
                i = true;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void j()
    {
        synchronized (b)
        {
            if (!a())
            {
                a(a(Status.d));
                i = true;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected abstract qt a(Status status);

    public volatile void a(Object obj)
    {
        a((qt)obj);
    }

    public final void a(qt qt1)
    {
        boolean flag1;
label0:
        {
            flag1 = true;
            synchronized (b)
            {
                if (!i && !h)
                {
                    break label0;
                }
                qg.a(qt1);
            }
            return;
        }
        boolean flag;
        if (!a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.a(flag, "Results have already been set");
        if (!g)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ady.a(flag, "Result has already been consumed");
        b(qt1);
        obj;
        JVM INSTR monitorexit ;
        return;
        qt1;
        obj;
        JVM INSTR monitorexit ;
        throw qt1;
    }

    public final void a(qu qu)
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
            ady.a(flag, "Result has already been consumed.");
            synchronized (b)
            {
                if (!d())
                {
                    break label0;
                }
            }
            return;
        }
        if (!a())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        a.a(qu, h());
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        qu;
        obj;
        JVM INSTR monitorexit ;
        throw qu;
        e = qu;
          goto _L1
    }

    public final boolean a()
    {
        return c.getCount() == 0L;
    }

    public final qt b()
    {
        boolean flag1 = true;
        boolean flag;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.a(flag, "await must not be called on the UI thread");
        if (!g)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ady.a(flag, "Result has already been consumed");
        try
        {
            c.await();
        }
        catch (InterruptedException interruptedexception)
        {
            i();
        }
        ady.a(a(), "Result is not ready.");
        return h();
    }

    public void c()
    {
label0:
        {
            synchronized (b)
            {
                if (!h && !g)
                {
                    break label0;
                }
            }
            return;
        }
        adl adl1 = j;
        if (adl1 == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        try
        {
            j.a();
        }
        catch (RemoteException remoteexception) { }
        qg.a(f);
        e = null;
        h = true;
        b(a(Status.e));
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean d()
    {
        boolean flag;
        synchronized (b)
        {
            flag = h;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void e()
    {
        g = true;
        f = null;
        e = null;
    }
}

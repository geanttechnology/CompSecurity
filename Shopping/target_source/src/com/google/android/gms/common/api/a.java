// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.android.gms.common.api:
//            e, f, g, Status, 
//            h

public abstract class com.google.android.gms.common.api.a
    implements e
{
    public static class a extends Handler
    {

        public void a()
        {
            removeMessages(2);
        }

        public void a(h h1, g g1)
        {
            sendMessage(obtainMessage(1, new Pair(h1, g1)));
        }

        protected void b(h h1, g g1)
        {
            try
            {
                h1.a(g1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (h h1)
            {
                com.google.android.gms.common.api.a.b(g1);
            }
            throw h1;
        }

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                return;

            case 1: // '\001'
                message = (Pair)message.obj;
                b((h)((Pair) (message)).first, (g)((Pair) (message)).second);
                return;

            case 2: // '\002'
                ((com.google.android.gms.common.api.a)message.obj).a(Status.d);
                break;
            }
        }

        public a()
        {
            this(Looper.getMainLooper());
        }

        public a(Looper looper)
        {
            super(looper);
        }
    }


    protected final a a;
    private final Object b = new Object();
    private final CountDownLatch c = new CountDownLatch(1);
    private final ArrayList d = new ArrayList();
    private h e;
    private volatile g f;
    private volatile boolean g;
    private boolean h;
    private boolean i;
    private b j;

    protected com.google.android.gms.common.api.a(Looper looper)
    {
        a = new a(looper);
    }

    static void b(g g1)
    {
        if (!(g1 instanceof f))
        {
            break MISSING_BLOCK_LABEL_16;
        }
        ((f)g1).a();
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        Log.w("AbstractPendingResult", (new StringBuilder()).append("Unable to release ").append(g1).toString(), runtimeexception);
        return;
    }

    private void c(g g1)
    {
        f = g1;
        j = null;
        c.countDown();
        g1 = f.a();
        if (e != null)
        {
            a.a();
            if (!h)
            {
                a.a(e, g());
            }
        }
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((e.a)iterator.next()).a(g1)) { }
        d.clear();
    }

    private g g()
    {
        boolean flag = true;
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        g g1;
        if (g)
        {
            flag = false;
        }
        u.a(flag, "Result has already been consumed.");
        u.a(a(), "Result is not ready.");
        g1 = f;
        f = null;
        e = null;
        g = true;
        d();
        return g1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(Status status)
    {
        synchronized (b)
        {
            if (!a())
            {
                a(b(status));
                i = true;
            }
        }
        return;
        status;
        obj;
        JVM INSTR monitorexit ;
        throw status;
    }

    public final void a(g g1)
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
                b(g1);
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
        u.a(flag, "Results have already been set");
        if (!g)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        u.a(flag, "Result has already been consumed");
        c(g1);
        obj;
        JVM INSTR monitorexit ;
        return;
        g1;
        obj;
        JVM INSTR monitorexit ;
        throw g1;
    }

    public final boolean a()
    {
        return c.getCount() == 0L;
    }

    public final g b()
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
        u.a(flag, "await must not be called on the UI thread");
        if (!g)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        u.a(flag, "Result has already been consumed");
        try
        {
            c.await();
        }
        catch (InterruptedException interruptedexception)
        {
            a(com.google.android.gms.common.api.Status.b);
        }
        u.a(a(), "Result is not ready.");
        return g();
    }

    protected abstract g b(Status status);

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
        b b1 = j;
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        try
        {
            j.a();
        }
        catch (RemoteException remoteexception) { }
        b(f);
        e = null;
        h = true;
        c(b(Status.e));
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void d()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.common.internal:
//            w

public final class m
    implements android.os.Handler.Callback
{
    public static interface a
    {

        public abstract boolean e();
    }


    public final a a;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public volatile boolean e;
    public final AtomicInteger f = new AtomicInteger(0);
    public boolean g;
    public final Handler h;
    public final Object i = new Object();

    public m(Looper looper, a a1)
    {
        e = false;
        g = false;
        a = a1;
        h = new Handler(looper, this);
    }

    public final void a()
    {
        e = false;
        f.incrementAndGet();
    }

    public final void a(int j)
    {
        boolean flag = false;
        if (Looper.myLooper() == h.getLooper())
        {
            flag = true;
        }
        w.a(flag, "onUnintentionalDisconnection must only be called on the Handler thread");
        h.removeMessages(1);
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        g = true;
        Object obj1 = new ArrayList(b);
        int k = f.get();
        obj1 = ((ArrayList) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            com.google.android.gms.common.api.c.b b1 = (com.google.android.gms.common.api.c.b)((Iterator) (obj1)).next();
            if (!e || f.get() != k)
            {
                break;
            }
            if (b.contains(b1))
            {
                b1.a(j);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_139;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        c.clear();
        g = false;
        obj;
        JVM INSTR monitorexit ;
    }

    public final void a(com.google.android.gms.common.api.c.b b1)
    {
        w.a(b1);
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        if (!b.contains(b1))
        {
            break MISSING_BLOCK_LABEL_74;
        }
        (new StringBuilder("registerConnectionCallbacks(): listener ")).append(b1).append(" is already registered");
_L2:
        if (a.e())
        {
            h.sendMessage(h.obtainMessage(1, b1));
        }
        return;
        b.add(b1);
        if (true) goto _L2; else goto _L1
_L1:
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
    }

    public final void a(com.google.android.gms.common.api.c.c c1)
    {
        w.a(c1);
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        if (!d.contains(c1))
        {
            break MISSING_BLOCK_LABEL_45;
        }
        (new StringBuilder("registerConnectionFailedListener(): listener ")).append(c1).append(" is already registered");
_L2:
        return;
        d.add(c1);
        if (true) goto _L2; else goto _L1
_L1:
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public final boolean handleMessage(Message message)
    {
        if (message.what == 1)
        {
            com.google.android.gms.common.api.c.b b1 = (com.google.android.gms.common.api.c.b)message.obj;
            synchronized (i)
            {
                if (e && a.e() && b.contains(b1))
                {
                    b1.a(null);
                }
            }
            return true;
        } else
        {
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
            return false;
        }
        exception;
        message;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

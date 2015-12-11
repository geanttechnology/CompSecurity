// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.common.internal:
//            u

public final class m
    implements android.os.Handler.Callback
{
    public static interface a
    {

        public abstract boolean b();

        public abstract Bundle c_();
    }


    final ArrayList a = new ArrayList();
    private final a b;
    private final ArrayList c = new ArrayList();
    private final ArrayList d = new ArrayList();
    private volatile boolean e;
    private final AtomicInteger f = new AtomicInteger(0);
    private boolean g;
    private final Handler h;
    private final Object i = new Object();

    public m(Looper looper, a a1)
    {
        e = false;
        g = false;
        b = a1;
        h = new Handler(looper, this);
    }

    public void a()
    {
        e = false;
        f.incrementAndGet();
    }

    public void a(int j)
    {
        h.removeMessages(1);
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        int k;
        g = true;
        obj1 = new ArrayList(c);
        k = f.get();
        obj1 = ((ArrayList) (obj1)).iterator();
_L5:
        if (!((Iterator) (obj1)).hasNext()) goto _L2; else goto _L1
_L1:
        com.google.android.gms.common.api.d.b b1 = (com.google.android.gms.common.api.d.b)((Iterator) (obj1)).next();
        if (e && f.get() == k) goto _L3; else goto _L2
_L2:
        a.clear();
        g = false;
        return;
_L3:
        if (c.contains(b1))
        {
            b1.a(j);
        }
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Bundle bundle)
    {
        boolean flag1 = true;
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        com.google.android.gms.common.api.d.b b1;
        int j;
        boolean flag;
        if (!g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        u.a(flag);
        h.removeMessages(1);
        g = true;
        if (a.size() == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        u.a(flag);
        obj1 = new ArrayList(c);
        j = f.get();
        obj1 = ((ArrayList) (obj1)).iterator();
_L5:
        if (!((Iterator) (obj1)).hasNext()) goto _L2; else goto _L1
_L1:
        b1 = (com.google.android.gms.common.api.d.b)((Iterator) (obj1)).next();
        if (e && b.b() && f.get() == j) goto _L3; else goto _L2
_L2:
        a.clear();
        g = false;
        obj;
        JVM INSTR monitorexit ;
        return;
_L3:
        if (!a.contains(b1))
        {
            b1.a(bundle);
        }
        if (true) goto _L5; else goto _L4
_L4:
        bundle;
        obj;
        JVM INSTR monitorexit ;
        throw bundle;
    }

    public void a(ConnectionResult connectionresult)
    {
        h.removeMessages(1);
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        int j;
        obj1 = new ArrayList(d);
        j = f.get();
        obj1 = ((ArrayList) (obj1)).iterator();
_L2:
        com.google.android.gms.common.api.d.d d1;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_111;
        }
        d1 = (com.google.android.gms.common.api.d.d)((Iterator) (obj1)).next();
        if (!e || f.get() != j)
        {
            return;
        }
        if (d.contains(d1))
        {
            d1.a(connectionresult);
        }
        if (true) goto _L2; else goto _L1
_L1:
        connectionresult;
        obj;
        JVM INSTR monitorexit ;
        throw connectionresult;
        obj;
        JVM INSTR monitorexit ;
    }

    public void a(com.google.android.gms.common.api.d.b b1)
    {
        u.a(b1);
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        if (!c.contains(b1))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        Log.w("GmsClientEvents", (new StringBuilder()).append("registerConnectionCallbacks(): listener ").append(b1).append(" is already registered").toString());
_L2:
        if (b.b())
        {
            h.sendMessage(h.obtainMessage(1, b1));
        }
        return;
        c.add(b1);
        if (true) goto _L2; else goto _L1
_L1:
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
    }

    public void a(com.google.android.gms.common.api.d.d d1)
    {
        u.a(d1);
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        if (!d.contains(d1))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        Log.w("GmsClientEvents", (new StringBuilder()).append("registerConnectionFailedListener(): listener ").append(d1).append(" is already registered").toString());
_L2:
        return;
        d.add(d1);
        if (true) goto _L2; else goto _L1
_L1:
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public void b()
    {
        e = true;
    }

    public void b(com.google.android.gms.common.api.d.b b1)
    {
        u.a(b1);
        Object obj = i;
        obj;
        JVM INSTR monitorenter ;
        if (c.remove(b1)) goto _L2; else goto _L1
_L1:
        Log.w("GmsClientEvents", (new StringBuilder()).append("unregisterConnectionCallbacks(): listener ").append(b1).append(" not found").toString());
_L4:
        return;
_L2:
        if (g)
        {
            a.add(b1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
    }

    public void b(com.google.android.gms.common.api.d.d d1)
    {
        u.a(d1);
        synchronized (i)
        {
            if (!d.remove(d1))
            {
                Log.w("GmsClientEvents", (new StringBuilder()).append("unregisterConnectionFailedListener(): listener ").append(d1).append(" not found").toString());
            }
        }
        return;
        d1;
        obj;
        JVM INSTR monitorexit ;
        throw d1;
    }

    public boolean handleMessage(Message message)
    {
        if (message.what == 1)
        {
            com.google.android.gms.common.api.d.b b1 = (com.google.android.gms.common.api.d.b)message.obj;
            synchronized (i)
            {
                if (e && b.b() && c.contains(b1))
                {
                    b1.a(b.c_());
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

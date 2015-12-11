// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class ade
{

    final ArrayList a = new ArrayList();
    private final adg b;
    private final ArrayList c = new ArrayList();
    private boolean d;
    private final ArrayList e = new ArrayList();
    private final Handler f;

    public ade(Context context, Looper looper, adg adg1)
    {
        d = false;
        b = adg1;
        f = new adf(this, looper);
    }

    static ArrayList a(ade ade1)
    {
        return ade1.c;
    }

    static adg b(ade ade1)
    {
        return ade1.b;
    }

    protected void a()
    {
        synchronized (c)
        {
            a(b.c_());
        }
        return;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(int i)
    {
        f.removeMessages(1);
        ArrayList arraylist = c;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator;
        d = true;
        iterator = (new ArrayList(c)).iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        qo qo1 = (qo)iterator.next();
        if (b.d_()) goto _L3; else goto _L2
_L2:
        d = false;
        return;
_L3:
        if (c.contains(qo1))
        {
            qo1.onConnectionSuspended(i);
        }
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Bundle bundle)
    {
        boolean flag1 = true;
        ArrayList arraylist = c;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator;
        qo qo1;
        boolean flag;
        if (!d)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.a(flag);
        f.removeMessages(1);
        d = true;
        if (a.size() == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ady.a(flag);
        iterator = (new ArrayList(c)).iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        qo1 = (qo)iterator.next();
        if (b.d_() && b.c()) goto _L3; else goto _L2
_L2:
        a.clear();
        d = false;
        arraylist;
        JVM INSTR monitorexit ;
        return;
_L3:
        if (!a.contains(qo1))
        {
            qo1.onConnected(bundle);
        }
        if (true) goto _L5; else goto _L4
_L4:
        bundle;
        arraylist;
        JVM INSTR monitorexit ;
        throw bundle;
    }

    public void a(pp pp)
    {
        f.removeMessages(1);
        ArrayList arraylist = e;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = (new ArrayList(e)).iterator();
_L2:
        pr pr1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        pr1 = (pr)iterator.next();
        if (!b.d_())
        {
            return;
        }
        if (e.contains(pr1))
        {
            pr1.onConnectionFailed(pp);
        }
        if (true) goto _L2; else goto _L1
_L1:
        pp;
        arraylist;
        JVM INSTR monitorexit ;
        throw pp;
        arraylist;
        JVM INSTR monitorexit ;
    }

    public void a(pr pr1)
    {
        ady.a(pr1);
        ArrayList arraylist = e;
        arraylist;
        JVM INSTR monitorenter ;
        if (!e.contains(pr1))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        Log.w("GmsClientEvents", (new StringBuilder()).append("registerConnectionFailedListener(): listener ").append(pr1).append(" is already registered").toString());
_L2:
        return;
        e.add(pr1);
        if (true) goto _L2; else goto _L1
_L1:
        pr1;
        arraylist;
        JVM INSTR monitorexit ;
        throw pr1;
    }

    public void a(qo qo1)
    {
        ady.a(qo1);
        ArrayList arraylist = c;
        arraylist;
        JVM INSTR monitorenter ;
        if (!c.contains(qo1))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        Log.w("GmsClientEvents", (new StringBuilder()).append("registerConnectionCallbacks(): listener ").append(qo1).append(" is already registered").toString());
_L2:
        if (b.c())
        {
            f.sendMessage(f.obtainMessage(1, qo1));
        }
        return;
        c.add(qo1);
        if (true) goto _L2; else goto _L1
_L1:
        qo1;
        arraylist;
        JVM INSTR monitorexit ;
        throw qo1;
    }

    public void b(pr pr1)
    {
        ady.a(pr1);
        synchronized (e)
        {
            if (e != null && !e.remove(pr1))
            {
                Log.w("GmsClientEvents", (new StringBuilder()).append("unregisterConnectionFailedListener(): listener ").append(pr1).append(" not found").toString());
            }
        }
        return;
        pr1;
        arraylist;
        JVM INSTR monitorexit ;
        throw pr1;
    }

    public void b(qo qo1)
    {
        ady.a(qo1);
        ArrayList arraylist = c;
        arraylist;
        JVM INSTR monitorenter ;
        if (c == null) goto _L2; else goto _L1
_L1:
        if (c.remove(qo1)) goto _L4; else goto _L3
_L3:
        Log.w("GmsClientEvents", (new StringBuilder()).append("unregisterConnectionCallbacks(): listener ").append(qo1).append(" not found").toString());
_L2:
        return;
_L4:
        if (d)
        {
            a.add(qo1);
        }
        if (true) goto _L2; else goto _L5
_L5:
        qo1;
        arraylist;
        JVM INSTR monitorexit ;
        throw qo1;
    }
}

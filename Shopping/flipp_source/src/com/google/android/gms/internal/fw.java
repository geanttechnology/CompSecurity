// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.b;
import com.google.android.gms.common.d;
import com.google.android.gms.common.g;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.internal:
//            gg, ha, ge, fx, 
//            fz, gc, gs, ga, 
//            gi, gb, fy, gr

public abstract class fw
    implements b, gg
{

    public static final String e[] = {
        "service_esmobile", "service_googleme"
    };
    final Context a;
    final Handler b;
    boolean c;
    boolean d;
    private IInterface f;
    private final ArrayList g;
    private gb h;
    private final String i[];
    private final ge j;
    private final Object k;

    private transient fw(Context context, com.google.android.gms.common.api.b b1, c c1, String as[])
    {
        g = new ArrayList();
        c = false;
        d = false;
        k = new Object();
        a = (Context)ha.a(context);
        j = new ge(this);
        b = new fx(this, context.getMainLooper());
        i = as;
        b1 = (com.google.android.gms.common.api.b)ha.a(b1);
        as = j;
        ha.a(b1);
        context = ((ge) (as)).b;
        context;
        JVM INSTR monitorenter ;
        if (!((ge) (as)).b.contains(b1)) goto _L2; else goto _L1
_L1:
        Log.w("GmsClientEvents", (new StringBuilder("registerConnectionCallbacks(): listener ")).append(b1).append(" is already registered").toString());
_L7:
        if (((ge) (as)).a.e())
        {
            ((ge) (as)).f.sendMessage(((ge) (as)).f.obtainMessage(1, b1));
        }
        b1 = (c)ha.a(c1);
        c1 = j;
        ha.a(b1);
        context = ((ge) (c1)).e;
        context;
        JVM INSTR monitorenter ;
        if (!((ge) (c1)).e.contains(b1)) goto _L4; else goto _L3
_L3:
        Log.w("GmsClientEvents", (new StringBuilder("registerConnectionFailedListener(): listener ")).append(b1).append(" is already registered").toString());
_L5:
        return;
_L2:
        if (((ge) (as)).d)
        {
            as.b = new ArrayList(((ge) (as)).b);
        }
        ((ge) (as)).b.add(b1);
        continue; /* Loop/switch isn't completed */
        b1;
        context;
        JVM INSTR monitorexit ;
        throw b1;
_L4:
        if (((ge) (c1)).g)
        {
            c1.e = new ArrayList(((ge) (c1)).e);
        }
        ((ge) (c1)).e.add(b1);
          goto _L5
        b1;
        context;
        JVM INSTR monitorexit ;
        throw b1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected transient fw(Context context, com.google.android.gms.common.c c1, d d1, String as[])
    {
        this(context, ((com.google.android.gms.common.api.b) (new fz(c1))), ((c) (new gc(d1))), as);
    }

    static IInterface a(fw fw1, IInterface iinterface)
    {
        fw1.f = iinterface;
        return iinterface;
    }

    static ge a(fw fw1)
    {
        return fw1.j;
    }

    static Object b(fw fw1)
    {
        return fw1.k;
    }

    static ArrayList c(fw fw1)
    {
        return fw1.g;
    }

    static IInterface d(fw fw1)
    {
        return fw1.f;
    }

    static gb e(fw fw1)
    {
        return fw1.h;
    }

    static Context f(fw fw1)
    {
        return fw1.a;
    }

    static gb g(fw fw1)
    {
        fw1.h = null;
        return null;
    }

    protected abstract IInterface a(IBinder ibinder);

    protected abstract String a();

    protected abstract void a(gr gr, ga ga1);

    protected abstract String b();

    protected final void b(IBinder ibinder)
    {
        try
        {
            a(gs.a(ibinder), new ga(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            Log.w("GmsClient", "service died");
        }
    }

    public final void d()
    {
        c = true;
        synchronized (k)
        {
            d = true;
        }
        int l = com.google.android.gms.common.g.a(a);
        if (l != 0)
        {
            b.sendMessage(b.obtainMessage(3, Integer.valueOf(l)));
        } else
        {
            if (h != null)
            {
                Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
                f = null;
                gi.a(a).b(a(), h);
            }
            h = new gb(this);
            if (!gi.a(a).a(a(), h))
            {
                Log.e("GmsClient", (new StringBuilder("unable to connect to service: ")).append(a()).toString());
                b.sendMessage(b.obtainMessage(3, Integer.valueOf(9)));
                return;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean e()
    {
        return f != null;
    }

    public final boolean f()
    {
        boolean flag;
        synchronized (k)
        {
            flag = d;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void g()
    {
        c = false;
        synchronized (k)
        {
            d = false;
        }
        obj = g;
        obj;
        JVM INSTR monitorenter ;
        int i1 = g.size();
        int l = 0;
_L2:
        if (l >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        ((fy)g.get(l)).c();
        l++;
        if (true) goto _L2; else goto _L1
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        g.clear();
        obj;
        JVM INSTR monitorexit ;
        f = null;
        if (h != null)
        {
            gi.a(a).b(a(), h);
            h = null;
            j.a();
        }
        return;
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    protected final void h()
    {
        if (!e())
        {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        } else
        {
            return;
        }
    }

    protected final IInterface i()
    {
        h();
        return f;
    }

    public final boolean j()
    {
        return c;
    }

}

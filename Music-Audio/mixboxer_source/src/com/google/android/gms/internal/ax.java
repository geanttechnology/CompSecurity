// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.c;

// Referenced classes of package com.google.android.gms.internal:
//            au, ct, bb, cu, 
//            x, at, bc, aw, 
//            cs, ay, v

public final class ax
    implements ay.a
{

    private final bb ed;
    private final v eq;
    private final String fR;
    private final long fS;
    private final at fT;
    private final x fU;
    private final cu fV;
    private bc fW;
    private int fX;
    private final Object fx = new Object();
    private final Context mContext;

    public ax(Context context, String s, bb bb1, au au1, at at1, v v, x x1, 
            cu cu1)
    {
        fX = -2;
        mContext = context;
        fR = s;
        ed = bb1;
        long l;
        if (au1.fJ != -1L)
        {
            l = au1.fJ;
        } else
        {
            l = 10000L;
        }
        fS = l;
        fT = at1;
        eq = v;
        fU = x1;
        fV = cu1;
    }

    private bc V()
    {
        ct.t((new StringBuilder()).append("Instantiating mediation adapter: ").append(fR).toString());
        bc bc1;
        try
        {
            bc1 = ed.l(fR);
        }
        catch (RemoteException remoteexception)
        {
            ct.a((new StringBuilder()).append("Could not instantiate mediation adapter: ").append(fR).toString(), remoteexception);
            return null;
        }
        return bc1;
    }

    static bc a(ax ax1, bc bc1)
    {
        ax1.fW = bc1;
        return bc1;
    }

    static Object a(ax ax1)
    {
        return ax1.fx;
    }

    private void a(long l, long l1, long l2, long l3)
    {
        do
        {
            if (fX != -2)
            {
                return;
            }
            b(l, l1, l2, l3);
        } while (true);
    }

    private void a(aw aw1)
    {
        if (fV.iL >= 0x3e8fa0)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        if (fU.eG)
        {
            fW.a(com.google.android.gms.dynamic.c.h(mContext), eq, fT.fH, aw1);
            return;
        }
        try
        {
            fW.a(com.google.android.gms.dynamic.c.h(mContext), fU, eq, fT.fH, aw1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aw aw1)
        {
            ct.b("Could not request ad from mediation adapter.", aw1);
        }
        f(5);
        return;
        if (fU.eG)
        {
            fW.a(com.google.android.gms.dynamic.c.h(mContext), eq, fT.fH, fT.adJson, aw1);
            return;
        }
        fW.a(com.google.android.gms.dynamic.c.h(mContext), fU, eq, fT.fH, fT.adJson, aw1);
        return;
    }

    static void a(ax ax1, aw aw1)
    {
        ax1.a(aw1);
    }

    static int b(ax ax1)
    {
        return ax1.fX;
    }

    private void b(long l, long l1, long l2, long l3)
    {
        long l4 = SystemClock.elapsedRealtime();
        l = l1 - (l4 - l);
        l1 = l3 - (l4 - l2);
        if (l <= 0L || l1 <= 0L)
        {
            ct.t("Timed out waiting for adapter.");
            fX = 3;
            return;
        }
        try
        {
            fx.wait(Math.min(l, l1));
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            fX = -1;
        }
    }

    static bc c(ax ax1)
    {
        return ax1.V();
    }

    static bc d(ax ax1)
    {
        return ax1.fW;
    }

    public ay b(long l, long l1)
    {
        Object obj1;
        synchronized (fx)
        {
            long l2 = SystemClock.elapsedRealtime();
            obj1 = new aw();
            cs.iI.post(new Runnable(((aw) (obj1))) {

                final aw fY;
                final ax fZ;

                public void run()
                {
label0:
                    {
                        synchronized (ax.a(fZ))
                        {
                            if (ax.b(fZ) == -2)
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    ax.a(fZ, com.google.android.gms.internal.ax.c(fZ));
                    if (ax.d(fZ) != null)
                    {
                        break MISSING_BLOCK_LABEL_66;
                    }
                    fZ.f(4);
                    obj2;
                    JVM INSTR monitorexit ;
                    return;
                    exception1;
                    obj2;
                    JVM INSTR monitorexit ;
                    throw exception1;
                    fY.a(fZ);
                    ax.a(fZ, fY);
                    obj2;
                    JVM INSTR monitorexit ;
                }

            
            {
                fZ = ax.this;
                fY = aw1;
                super();
            }
            });
            a(l2, fS, l, l1);
            obj1 = new ay(fT, fW, fR, ((aw) (obj1)), fX);
        }
        return ((ay) (obj1));
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void cancel()
    {
        Object obj = fx;
        obj;
        JVM INSTR monitorenter ;
        if (fW != null)
        {
            fW.destroy();
        }
_L1:
        fX = -1;
        fx.notify();
        return;
        Object obj1;
        obj1;
        ct.b("Could not destroy mediation adapter.", ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public void f(int i)
    {
        synchronized (fx)
        {
            fX = i;
            fx.notify();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

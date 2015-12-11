// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            ct, au, at, ay, 
//            ax, bz, cs, bb, 
//            bc

public final class as
{

    private final bb ed;
    private ax fA;
    private final bz fw;
    private final Object fx = new Object();
    private final au fy;
    private boolean fz;
    private final Context mContext;

    public as(Context context, bz bz1, bb bb, au au1)
    {
        fz = false;
        mContext = context;
        fw = bz1;
        ed = bb;
        fy = au1;
    }

    public ay a(long l, long l1)
    {
        Iterator iterator;
        ct.r("Starting mediation.");
        iterator = fy.fI.iterator();
_L4:
        at at1;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_247;
        }
        at1 = (at)iterator.next();
        ct.t((new StringBuilder()).append("Trying mediation network: ").append(at1.fD).toString());
        iterator1 = at1.fE.iterator();
_L2:
        String s;
label0:
        {
            if (!iterator1.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            s = (String)iterator1.next();
            ay ay1;
            synchronized (fx)
            {
                if (!fz)
                {
                    break label0;
                }
                ay1 = new ay(-1);
            }
            return ay1;
        }
        fA = new ax(mContext, s, ed, fy, at1, fw.hr, fw.em, fw.ej);
        obj;
        JVM INSTR monitorexit ;
        obj = fA.b(l, l1);
        if (((ay) (obj)).ga == 0)
        {
            ct.r("Adapter succeeded.");
            return ((ay) (obj));
        }
        break MISSING_BLOCK_LABEL_219;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (((ay) (obj)).gc != null)
        {
            cs.iI.post(new Runnable(((ay) (obj))) {

                final ay fB;
                final as fC;

                public void run()
                {
                    try
                    {
                        fB.gc.destroy();
                        return;
                    }
                    catch (RemoteException remoteexception)
                    {
                        ct.b("Could not destroy mediation adapter.", remoteexception);
                    }
                }

            
            {
                fC = as.this;
                fB = ay1;
                super();
            }
            });
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (true) goto _L4; else goto _L3
_L3:
        return new ay(1);
    }

    public void cancel()
    {
        synchronized (fx)
        {
            fz = true;
            if (fA != null)
            {
                fA.cancel();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;

public class zzii
{

    private Handler mHandler;
    private HandlerThread zzJh;
    private int zzJi;
    private final Object zzpd = new Object();

    public zzii()
    {
        zzJh = null;
        mHandler = null;
        zzJi = 0;
    }

    static Object zza(zzii zzii1)
    {
        return zzii1.zzpd;
    }

    static int zzb(zzii zzii1)
    {
        return zzii1.zzJi;
    }

    public Looper zzgM()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzJi != 0)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (zzJh != null) goto _L2; else goto _L1
_L1:
        com.google.android.gms.ads.internal.util.client.zzb.v("Starting the looper thread.");
        zzJh = new HandlerThread("LooperProvider");
        zzJh.start();
        mHandler = new Handler(zzJh.getLooper());
        com.google.android.gms.ads.internal.util.client.zzb.v("Looper thread started.");
_L3:
        Looper looper;
        zzJi = zzJi + 1;
        looper = zzJh.getLooper();
        return looper;
_L2:
        com.google.android.gms.ads.internal.util.client.zzb.v("Resuming the looper thread");
        zzpd.notifyAll();
          goto _L3
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        zzx.zzb(zzJh, "Invalid state: mHandlerThread should already been initialized.");
          goto _L3
    }

    public void zzgN()
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        int i;
        boolean flag;
        if (zzJi > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Invalid state: release() called more times than expected.");
        i = zzJi - 1;
        zzJi = i;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        mHandler.post(new Runnable() {

            final zzii zzJj;

            public void run()
            {
                Object obj1 = zzii.zza(zzJj);
                obj1;
                JVM INSTR monitorenter ;
                com.google.android.gms.ads.internal.util.client.zzb.v("Suspending the looper thread");
_L1:
                int j = com.google.android.gms.internal.zzii.zzb(zzJj);
                if (j != 0)
                {
                    break MISSING_BLOCK_LABEL_59;
                }
                zzii.zza(zzJj).wait();
                com.google.android.gms.ads.internal.util.client.zzb.v("Looper thread resumed");
                  goto _L1
                Object obj2;
                obj2;
                com.google.android.gms.ads.internal.util.client.zzb.v("Looper thread interrupted.");
                  goto _L1
                obj2;
                obj1;
                JVM INSTR monitorexit ;
                throw obj2;
                obj1;
                JVM INSTR monitorexit ;
            }

            
            {
                zzJj = zzii.this;
                super();
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

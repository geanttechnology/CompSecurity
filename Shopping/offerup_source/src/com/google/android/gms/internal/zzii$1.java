// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzii

class zzJj
    implements Runnable
{

    final zzii zzJj;

    public void run()
    {
        Object obj = zzii.zza(zzJj);
        obj;
        JVM INSTR monitorenter ;
        zzb.v("Suspending the looper thread");
_L1:
        int i = com.google.android.gms.internal.zzii.zzb(zzJj);
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        zzii.zza(zzJj).wait();
        zzb.v("Looper thread resumed");
          goto _L1
        Object obj1;
        obj1;
        zzb.v("Looper thread interrupted.");
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        JVM INSTR monitorexit ;
    }

    l.client.zzb(zzii zzii1)
    {
        zzJj = zzii1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.internal:
//            zzip, zzin

final class zzJH
    implements Runnable
{

    final AtomicInteger zzJE;
    final int zzJF;
    final zzin zzJG;
    final List zzJH;

    public final void run()
    {
        if (zzJE.incrementAndGet() < zzJF)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        zzJG.zzf(zzip.zzj(zzJH));
        return;
        Object obj;
        obj;
_L2:
        zzb.zzd("Unable to convert list of futures to a future of list", ((Throwable) (obj)));
        return;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    er(AtomicInteger atomicinteger, int i, zzin zzin1, List list)
    {
        zzJE = atomicinteger;
        zzJF = i;
        zzJG = zzin1;
        zzJH = list;
        super();
    }
}

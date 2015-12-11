// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzhk

class zzhw
{

    private final Object zzGQ = new Object();
    private final List zzGR = new ArrayList();
    private final List zzGS = new ArrayList();
    private boolean zzGT;

    public zzhw()
    {
        zzGT = false;
    }

    private void zzc(Runnable runnable)
    {
        com.google.android.gms.internal.zzhk.zza(runnable);
    }

    private void zzd(Runnable runnable)
    {
        zza.zzGF.post(runnable);
    }

    public void zzgy()
    {
label0:
        {
            synchronized (zzGQ)
            {
                if (!zzGT)
                {
                    break label0;
                }
            }
            return;
        }
        for (Iterator iterator = zzGR.iterator(); iterator.hasNext(); zzc((Runnable)iterator.next())) { }
        break MISSING_BLOCK_LABEL_57;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        for (Iterator iterator1 = zzGS.iterator(); iterator1.hasNext(); zzd((Runnable)iterator1.next())) { }
        zzGR.clear();
        zzGS.clear();
        zzGT = true;
        obj;
        JVM INSTR monitorexit ;
    }
}

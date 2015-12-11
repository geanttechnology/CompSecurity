// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Looper;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zze, zzv, zzu

class zzaLY
    implements Runnable
{

    final zze zzaLY;

    public void run()
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            zze.zza(zzaLY).zzzr().zzh(this);
        } else
        {
            boolean flag = zzaLY.zzbp();
            zze.zza(zzaLY, 0L);
            if (flag && zze.zzb(zzaLY))
            {
                zzaLY.run();
                return;
            }
        }
    }

    (zze zze1)
    {
        zzaLY = zze1;
        super();
    }
}

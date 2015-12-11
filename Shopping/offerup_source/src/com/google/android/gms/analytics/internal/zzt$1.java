// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.os.Looper;
import com.google.android.gms.measurement.zzg;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzt, zzf

class zzOa
    implements Runnable
{

    final zzt zzOa;

    public void run()
    {
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            zzt.zza(zzOa).zziw().zzg(this);
        } else
        {
            boolean flag = zzOa.zzbp();
            zzt.zza(zzOa, 0L);
            if (flag && !zzt.zzb(zzOa))
            {
                zzOa.run();
                return;
            }
        }
    }

    (zzt zzt1)
    {
        zzOa = zzt1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzd;

// Referenced classes of package com.google.android.gms.internal:
//            zzja, zziz

class zzKi
    implements Runnable
{

    final zzja zzKi;

    public void run()
    {
        zzKi.zzoM.zzho();
        zzd zzd1 = zzKi.zzoM.zzhc();
        if (zzd1 != null)
        {
            zzd1.zzeG();
        }
        if (com.google.android.gms.internal.zzja.zzd(zzKi) != null)
        {
            com.google.android.gms.internal.zzja.zzd(zzKi).zzbf();
            zzja.zza(zzKi, null);
        }
    }

    b(zzja zzja1)
    {
        zzKi = zzja1;
        super();
    }
}

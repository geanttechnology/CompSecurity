// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzn;

// Referenced classes of package com.google.android.gms.internal:
//            zzgm, zzmi, zzin

class zzDP
    implements Runnable
{

    final zzgm zzDN;
    final zzin zzDO;
    final String zzDP;

    public void run()
    {
        zzDO.zzf(zzgm.zza(zzDN).zzbo().get(zzDP));
    }

    (zzgm zzgm1, zzin zzin1, String s)
    {
        zzDN = zzgm1;
        zzDO = zzin1;
        zzDP = s;
        super();
    }
}

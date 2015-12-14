// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;


// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzm

class zzoB
    implements Runnable
{

    final zzm zzFp;
    final com.google.android.gms.internal.za zzoB;

    public void run()
    {
        zzm.zza(zzFp).zza(zzoB);
        if (zzm.zzb(zzFp) != null)
        {
            zzm.zzb(zzFp).release();
            zzm.zza(zzFp, null);
        }
    }

    a(zzm zzm1, com.google.android.gms.internal.za za)
    {
        zzFp = zzm1;
        zzoB = za;
        super();
    }
}

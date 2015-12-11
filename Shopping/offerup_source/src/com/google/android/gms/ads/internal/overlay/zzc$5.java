// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;


// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzc, zzh

class zzBe
    implements Runnable
{

    final zzc zzBe;

    public void run()
    {
        if (zzc.zza(zzBe) != null)
        {
            zzc.zza(zzBe).onPaused();
            zzc.zza(zzBe).zzeU();
        }
    }

    (zzc zzc1)
    {
        zzBe = zzc1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;


// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzc, zzh

class zzBg
    implements Runnable
{

    final zzc zzBe;
    final String zzBf;
    final String zzBg;

    public void run()
    {
        if (zzc.zza(zzBe) != null)
        {
            zzc.zza(zzBe).zzh(zzBf, zzBg);
        }
    }

    (zzc zzc1, String s, String s1)
    {
        zzBe = zzc1;
        zzBf = s;
        zzBg = s1;
        super();
    }
}

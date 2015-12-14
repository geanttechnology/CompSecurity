// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;


// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzm

class zzFp
    implements Runnable
{

    final zzm zzFp;

    public void run()
    {
        if (zzm.zzb(zzFp) != null)
        {
            zzm.zzb(zzFp).release();
            zzm.zza(zzFp, null);
        }
    }

    (zzm zzm1)
    {
        zzFp = zzm1;
        super();
    }
}

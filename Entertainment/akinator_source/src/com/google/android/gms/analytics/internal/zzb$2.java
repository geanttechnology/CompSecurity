// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzb, zzl

class zzMz
    implements Runnable
{

    final zzb zzMy;
    final boolean zzMz;

    public void run()
    {
        zzb.zza(zzMy).zzI(zzMz);
    }

    (zzb zzb1, boolean flag)
    {
        zzMy = zzb1;
        zzMz = flag;
        super();
    }
}

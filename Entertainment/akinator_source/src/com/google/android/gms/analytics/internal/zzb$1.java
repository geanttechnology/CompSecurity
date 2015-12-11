// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzb, zzl

class zzMx
    implements Runnable
{

    final int zzMx;
    final zzb zzMy;

    public void run()
    {
        zzb.zza(zzMy).zzs((long)zzMx * 1000L);
    }

    (zzb zzb1, int i)
    {
        zzMy = zzb1;
        zzMx = i;
        super();
    }
}

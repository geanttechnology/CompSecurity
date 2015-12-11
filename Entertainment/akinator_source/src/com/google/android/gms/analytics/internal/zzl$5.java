// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzl, zzw

class zzNE
    implements Runnable
{

    final zzw zzMD;
    final zzl zzND;
    final long zzNE;

    public void run()
    {
        zzND.zza(zzMD, zzNE);
    }

    (zzl zzl1, zzw zzw, long l)
    {
        zzND = zzl1;
        zzMD = zzw;
        zzNE = l;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;


// Referenced classes of package com.google.android.gms.cast.internal:
//            zze

class zzXm
    implements Runnable
{

    final zze zzXl;
    final int zzXm;
    final zzXm zzXn;

    public void run()
    {
        if (zze.zzd(zzXl) != null)
        {
            zze.zzd(zzXl).onApplicationDisconnected(zzXm);
        }
    }

    ( , zze zze1, int i)
    {
        zzXn = ;
        zzXl = zze1;
        zzXm = i;
        super();
    }
}

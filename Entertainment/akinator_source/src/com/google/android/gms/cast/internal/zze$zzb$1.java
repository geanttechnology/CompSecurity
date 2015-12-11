// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;


// Referenced classes of package com.google.android.gms.cast.internal:
//            zze

class zzZe
    implements Runnable
{

    final zze zzZd;
    final int zzZe;
    final zzZe zzZf;

    public void run()
    {
        if (zze.zzd(zzZd) != null)
        {
            zze.zzd(zzZd).onApplicationDisconnected(zzZe);
        }
    }

    ( , zze zze1, int i)
    {
        zzZf = ;
        zzZd = zze1;
        zzZe = i;
        super();
    }
}

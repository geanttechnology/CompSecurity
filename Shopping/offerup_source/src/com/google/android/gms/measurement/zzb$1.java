// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement;

import java.util.Comparator;

// Referenced classes of package com.google.android.gms.measurement:
//            zze, zzb

class zzaKO
    implements Comparator
{

    final zzb zzaKO;

    public int compare(Object obj, Object obj1)
    {
        return zza((zze)obj, (zze)obj1);
    }

    public int zza(zze zze1, zze zze2)
    {
        return zze1.getClass().getCanonicalName().compareTo(zze2.getClass().getCanonicalName());
    }

    (zzb zzb)
    {
        zzaKO = zzb;
        super();
    }
}

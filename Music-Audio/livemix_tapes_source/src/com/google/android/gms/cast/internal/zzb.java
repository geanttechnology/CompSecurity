// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzk

public abstract class zzb extends com.google.android.gms.common.api.zzc.zza
{

    public zzb(GoogleApiClient googleapiclient)
    {
        super(zzk.zzQf, googleapiclient);
    }

    public void zzaT(int i)
    {
        zza(zzb(new Status(i)));
    }

    public void zzd(int i, String s)
    {
        zza(zzb(new Status(i, s, null)));
    }
}

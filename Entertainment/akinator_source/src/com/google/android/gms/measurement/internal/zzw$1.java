// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;


// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzw, zzv, EventParcel, AppMetadata

class zzaOh
    implements Runnable
{

    final EventParcel zzaOg;
    final AppMetadata zzaOh;
    final zzw zzaOi;

    public void run()
    {
        zzw.zza(zzaOi).zzb(zzaOg, zzaOh);
    }

    adata(zzw zzw1, EventParcel eventparcel, AppMetadata appmetadata)
    {
        zzaOi = zzw1;
        zzaOg = eventparcel;
        zzaOh = appmetadata;
        super();
    }
}

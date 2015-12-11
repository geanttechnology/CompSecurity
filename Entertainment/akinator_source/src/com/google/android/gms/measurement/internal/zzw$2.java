// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;


// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzw, zzv, AppMetadata, UserAttributeParcel

class zzaOh
    implements Runnable
{

    final AppMetadata zzaOh;
    final zzw zzaOi;
    final UserAttributeParcel zzaOj;

    public void run()
    {
        zzw.zza(zzaOi).zzc(zzaOj, zzaOh);
    }

    adata(zzw zzw1, UserAttributeParcel userattributeparcel, AppMetadata appmetadata)
    {
        zzaOi = zzw1;
        zzaOj = userattributeparcel;
        zzaOh = appmetadata;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzjm, zzjn

private static final class x.zzb extends zzjm
{

    private final com.google.android.gms.common.api.er zzQz;

    public void zza(int i, DataHolder dataholder)
    {
        zzQz.zn(new <init>(i, dataholder));
    }

    public (com.google.android.gms.common.api.er er)
    {
        zzQz = (com.google.android.gms.common.api.Qz)zzx.zzb(er, "Result holder must not be null");
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzjm, zzjn

private static final class x.zzb extends zzjm
{

    private final com.google.android.gms.common.api.nit> zzQz;

    public void zzg(int i, int j)
    {
        Status status = new Status(i);
        zzQz.zn(new <init>(status, j));
    }

    public (com.google.android.gms.common.api. )
    {
        zzQz = (com.google.android.gms.common.api.Qz)zzx.zzb(, "Result holder must not be null");
    }
}

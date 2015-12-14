// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzs, zzaa

private abstract class nt extends zzs
{

    final zzaa zzajb;

    public com.google.android.gms.drive.urce.MetadataResult zzG(Status status)
    {
        return new <init>(status, null);
    }

    public Result zzb(Status status)
    {
        return zzG(status);
    }

    private nt(zzaa zzaa1, GoogleApiClient googleapiclient)
    {
        zzajb = zzaa1;
        super(googleapiclient);
    }

    nt(zzaa zzaa1, GoogleApiClient googleapiclient, nt nt)
    {
        this(zzaa1, googleapiclient);
    }
}

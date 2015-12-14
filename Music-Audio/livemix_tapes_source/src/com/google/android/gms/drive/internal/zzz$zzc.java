// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzs, zzz

private abstract class ent extends zzs
{

    final zzz zzaiX;

    protected com.google.android.gms.drive.ferencesApi.FileUploadPreferencesResult zzF(Status status)
    {
        return new <init>(zzaiX, status, null, null);
    }

    protected Result zzb(Status status)
    {
        return zzF(status);
    }

    public ent(zzz zzz1, GoogleApiClient googleapiclient)
    {
        zzaiX = zzz1;
        super(googleapiclient);
    }
}

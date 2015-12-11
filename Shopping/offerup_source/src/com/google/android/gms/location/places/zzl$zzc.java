// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.location.places:
//            PlaceBuffer

public abstract class nt extends nt
{

    protected PlaceBuffer zzaP(Status status)
    {
        return new PlaceBuffer(DataHolder.zzbu(status.getStatusCode()), null);
    }

    protected Result zzb(Status status)
    {
        return zzaP(status);
    }

    public nt(com.google.android.gms.common.api..zzc zzc, GoogleApiClient googleapiclient)
    {
        super(zzc, googleapiclient);
    }
}

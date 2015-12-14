// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            SnapshotsImpl

private static abstract class <init> extends com.google.android.gms.games.mpl
{

    public com.google.android.gms.games.snapshot.esult zzaB(Status status)
    {
        return new com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult(status) {

            final Status zzQs;
            final SnapshotsImpl.DeleteImpl zzawg;

            public String getSnapshotId()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzawg = SnapshotsImpl.DeleteImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaB(status);
    }

    private _cls1.zzQs(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    _cls1.zzQs(GoogleApiClient googleapiclient, _cls1.zzQs zzqs)
    {
        this(googleapiclient);
    }
}

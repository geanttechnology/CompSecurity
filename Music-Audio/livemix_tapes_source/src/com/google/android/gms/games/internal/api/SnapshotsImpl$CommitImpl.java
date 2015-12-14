// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.SnapshotMetadata;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            SnapshotsImpl

private static abstract class <init> extends com.google.android.gms.games.mpl
{

    public com.google.android.gms.games.snapshot.esult zzaA(Status status)
    {
        return new com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult(status) {

            final Status zzQs;
            final SnapshotsImpl.CommitImpl zzawf;

            public SnapshotMetadata getSnapshotMetadata()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzawf = SnapshotsImpl.CommitImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaA(status);
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

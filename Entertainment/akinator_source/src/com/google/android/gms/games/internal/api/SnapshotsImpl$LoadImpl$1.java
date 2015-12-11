// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            SnapshotsImpl

class zzVb
    implements com.google.android.gms.games.snapshot.sult
{

    final Status zzVb;
    final zzVb zzayF;

    public SnapshotMetadataBuffer getSnapshots()
    {
        return new SnapshotMetadataBuffer(DataHolder.zzbu(14));
    }

    public Status getStatus()
    {
        return zzVb;
    }

    public void release()
    {
    }

    ( , Status status)
    {
        zzayF = ;
        zzVb = status;
        super();
    }
}

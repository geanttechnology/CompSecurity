// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            SnapshotsImpl

class zzVb
    implements com.google.android.gms.games.snapshot.ult
{

    final Status zzVb;
    final zzVb zzayG;

    public String getConflictId()
    {
        return null;
    }

    public Snapshot getConflictingSnapshot()
    {
        return null;
    }

    public SnapshotContents getResolutionSnapshotContents()
    {
        return null;
    }

    public Snapshot getSnapshot()
    {
        return null;
    }

    public Status getStatus()
    {
        return zzVb;
    }

    ( , Status status)
    {
        zzayG = ;
        zzVb = status;
        super();
    }
}

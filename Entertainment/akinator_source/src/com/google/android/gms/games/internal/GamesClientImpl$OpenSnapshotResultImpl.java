// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzawd extends zzawd
    implements com.google.android.gms.games.snapshot.zzawd
{

    private final Snapshot zzawb;
    private final String zzawc;
    private final Snapshot zzawd;
    private final Contents zzawe;
    private final SnapshotContents zzawf;

    public String getConflictId()
    {
        return zzawc;
    }

    public Snapshot getConflictingSnapshot()
    {
        return zzawd;
    }

    public SnapshotContents getResolutionSnapshotContents()
    {
        return zzawf;
    }

    public Snapshot getSnapshot()
    {
        return zzawb;
    }

    (DataHolder dataholder, Contents contents)
    {
        this(dataholder, null, contents, null, null);
    }

    <init>(DataHolder dataholder, String s, Contents contents, Contents contents1, Contents contents2)
    {
        SnapshotMetadataBuffer snapshotmetadatabuffer;
        boolean flag;
        flag = true;
        super(dataholder);
        snapshotmetadatabuffer = new SnapshotMetadataBuffer(dataholder);
        if (snapshotmetadatabuffer.getCount() != 0) goto _L2; else goto _L1
_L1:
        zzawb = null;
        zzawd = null;
_L3:
        snapshotmetadatabuffer.release();
        zzawc = s;
        zzawe = contents2;
        zzawf = new SnapshotContentsEntity(contents2);
        return;
_L2:
        if (snapshotmetadatabuffer.getCount() != 1)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        if (dataholder.getStatusCode() == 4004)
        {
            flag = false;
        }
        zzb.zzZ(flag);
        zzawb = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(0)), new SnapshotContentsEntity(contents));
        zzawd = null;
          goto _L3
        dataholder;
        snapshotmetadatabuffer.release();
        throw dataholder;
        zzawb = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(0)), new SnapshotContentsEntity(contents));
        zzawd = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(1)), new SnapshotContentsEntity(contents1));
          goto _L3
    }
}

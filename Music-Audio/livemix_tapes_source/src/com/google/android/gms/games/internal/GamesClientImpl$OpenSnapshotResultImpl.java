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

private static final class zzatF extends zzatF
    implements com.google.android.gms.games.snapshot.zzatF
{

    private final Snapshot zzatD;
    private final String zzatE;
    private final Snapshot zzatF;
    private final Contents zzatG;
    private final SnapshotContents zzatH;

    public String getConflictId()
    {
        return zzatE;
    }

    public Snapshot getConflictingSnapshot()
    {
        return zzatF;
    }

    public SnapshotContents getResolutionSnapshotContents()
    {
        return zzatH;
    }

    public Snapshot getSnapshot()
    {
        return zzatD;
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
        zzatD = null;
        zzatF = null;
_L3:
        snapshotmetadatabuffer.release();
        zzatE = s;
        zzatG = contents2;
        zzatH = new SnapshotContentsEntity(contents2);
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
        zzb.zzY(flag);
        zzatD = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(0)), new SnapshotContentsEntity(contents));
        zzatF = null;
          goto _L3
        dataholder;
        snapshotmetadatabuffer.release();
        throw dataholder;
        zzatD = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(0)), new SnapshotContentsEntity(contents));
        zzatF = new SnapshotEntity(new SnapshotMetadataEntity(snapshotmetadatabuffer.get(1)), new SnapshotContentsEntity(contents1));
          goto _L3
    }
}

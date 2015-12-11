// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

// Referenced classes of package com.google.android.gms.games.snapshot:
//            SnapshotMetadataChange, SnapshotMetadataChangeEntity, SnapshotMetadata

public static final class 
{

    private Long zzaBH;
    private Long zzaBI;
    private BitmapTeleporter zzaBJ;
    private Uri zzaBK;
    private String zzaqZ;

    public SnapshotMetadataChange build()
    {
        return new SnapshotMetadataChangeEntity(zzaqZ, zzaBH, zzaBJ, zzaBK, zzaBI);
    }

    public zzaBI fromMetadata(SnapshotMetadata snapshotmetadata)
    {
        zzaqZ = snapshotmetadata.getDescription();
        zzaBH = Long.valueOf(snapshotmetadata.getPlayedTime());
        zzaBI = Long.valueOf(snapshotmetadata.getProgressValue());
        if (zzaBH.longValue() == -1L)
        {
            zzaBH = null;
        }
        zzaBK = snapshotmetadata.getCoverImageUri();
        if (zzaBK != null)
        {
            zzaBJ = null;
        }
        return this;
    }

    public zzaBJ setCoverImage(Bitmap bitmap)
    {
        zzaBJ = new BitmapTeleporter(bitmap);
        zzaBK = null;
        return this;
    }

    public zzaBK setDescription(String s)
    {
        zzaqZ = s;
        return this;
    }

    public zzaqZ setPlayedTimeMillis(long l)
    {
        zzaBH = Long.valueOf(l);
        return this;
    }

    public zzaBH setProgressValue(long l)
    {
        zzaBI = Long.valueOf(l);
        return this;
    }

    public ()
    {
    }
}

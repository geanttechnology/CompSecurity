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

    private String zzaoB;
    private Long zzazh;
    private Long zzazi;
    private BitmapTeleporter zzazj;
    private Uri zzazk;

    public SnapshotMetadataChange build()
    {
        return new SnapshotMetadataChangeEntity(zzaoB, zzazh, zzazj, zzazk, zzazi);
    }

    public zzazi fromMetadata(SnapshotMetadata snapshotmetadata)
    {
        zzaoB = snapshotmetadata.getDescription();
        zzazh = Long.valueOf(snapshotmetadata.getPlayedTime());
        zzazi = Long.valueOf(snapshotmetadata.getProgressValue());
        if (zzazh.longValue() == -1L)
        {
            zzazh = null;
        }
        zzazk = snapshotmetadata.getCoverImageUri();
        if (zzazk != null)
        {
            zzazj = null;
        }
        return this;
    }

    public zzazj setCoverImage(Bitmap bitmap)
    {
        zzazj = new BitmapTeleporter(bitmap);
        zzazk = null;
        return this;
    }

    public zzazk setDescription(String s)
    {
        zzaoB = s;
        return this;
    }

    public zzaoB setPlayedTimeMillis(long l)
    {
        zzazh = Long.valueOf(l);
        return this;
    }

    public zzazh setProgressValue(long l)
    {
        zzazi = Long.valueOf(l);
        return this;
    }

    public ()
    {
    }
}

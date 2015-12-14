// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

// Referenced classes of package com.google.android.gms.games.snapshot:
//            SnapshotMetadataChangeEntity, SnapshotMetadata

public abstract class SnapshotMetadataChange
{
    public static final class Builder
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

        public Builder fromMetadata(SnapshotMetadata snapshotmetadata)
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

        public Builder setCoverImage(Bitmap bitmap)
        {
            zzazj = new BitmapTeleporter(bitmap);
            zzazk = null;
            return this;
        }

        public Builder setDescription(String s)
        {
            zzaoB = s;
            return this;
        }

        public Builder setPlayedTimeMillis(long l)
        {
            zzazh = Long.valueOf(l);
            return this;
        }

        public Builder setProgressValue(long l)
        {
            zzazi = Long.valueOf(l);
            return this;
        }

        public Builder()
        {
        }
    }


    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    protected SnapshotMetadataChange()
    {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract Long getProgressValue();

    public abstract BitmapTeleporter zzvc();

}

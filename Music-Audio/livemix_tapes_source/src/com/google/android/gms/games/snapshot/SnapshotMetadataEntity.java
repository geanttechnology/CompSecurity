// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzln;

// Referenced classes of package com.google.android.gms.games.snapshot:
//            SnapshotMetadata, SnapshotMetadataEntityCreator

public final class SnapshotMetadataEntity
    implements SafeParcelable, SnapshotMetadata
{

    public static final android.os.Parcelable.Creator CREATOR = new SnapshotMetadataEntityCreator();
    private final int mVersionCode;
    private final String zzagU;
    private final String zzaoB;
    private final String zzasZ;
    private final GameEntity zzaxY;
    private final Uri zzazk;
    private final PlayerEntity zzazn;
    private final String zzazo;
    private final long zzazp;
    private final long zzazq;
    private final float zzazr;
    private final String zzazs;
    private final boolean zzazt;
    private final long zzazu;

    SnapshotMetadataEntity(int i, GameEntity gameentity, PlayerEntity playerentity, String s, Uri uri, String s1, String s2, 
            String s3, long l, long l1, float f, String s4, 
            boolean flag, long l2)
    {
        mVersionCode = i;
        zzaxY = gameentity;
        zzazn = playerentity;
        zzasZ = s;
        zzazk = uri;
        zzazo = s1;
        zzazr = f;
        zzagU = s2;
        zzaoB = s3;
        zzazp = l;
        zzazq = l1;
        zzazs = s4;
        zzazt = flag;
        zzazu = l2;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotmetadata)
    {
        mVersionCode = 5;
        zzaxY = new GameEntity(snapshotmetadata.getGame());
        zzazn = new PlayerEntity(snapshotmetadata.getOwner());
        zzasZ = snapshotmetadata.getSnapshotId();
        zzazk = snapshotmetadata.getCoverImageUri();
        zzazo = snapshotmetadata.getCoverImageUrl();
        zzazr = snapshotmetadata.getCoverImageAspectRatio();
        zzagU = snapshotmetadata.getTitle();
        zzaoB = snapshotmetadata.getDescription();
        zzazp = snapshotmetadata.getLastModifiedTimestamp();
        zzazq = snapshotmetadata.getPlayedTime();
        zzazs = snapshotmetadata.getUniqueName();
        zzazt = snapshotmetadata.hasChangePending();
        zzazu = snapshotmetadata.getProgressValue();
    }

    static int zza(SnapshotMetadata snapshotmetadata)
    {
        return zzw.hashCode(new Object[] {
            snapshotmetadata.getGame(), snapshotmetadata.getOwner(), snapshotmetadata.getSnapshotId(), snapshotmetadata.getCoverImageUri(), Float.valueOf(snapshotmetadata.getCoverImageAspectRatio()), snapshotmetadata.getTitle(), snapshotmetadata.getDescription(), Long.valueOf(snapshotmetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotmetadata.getPlayedTime()), snapshotmetadata.getUniqueName(), 
            Boolean.valueOf(snapshotmetadata.hasChangePending()), Long.valueOf(snapshotmetadata.getProgressValue())
        });
    }

    static boolean zza(SnapshotMetadata snapshotmetadata, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof SnapshotMetadata) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (snapshotmetadata == obj) goto _L4; else goto _L3
_L3:
        obj = (SnapshotMetadata)obj;
        if (!zzw.equal(((SnapshotMetadata) (obj)).getGame(), snapshotmetadata.getGame()) || !zzw.equal(((SnapshotMetadata) (obj)).getOwner(), snapshotmetadata.getOwner()) || !zzw.equal(((SnapshotMetadata) (obj)).getSnapshotId(), snapshotmetadata.getSnapshotId()) || !zzw.equal(((SnapshotMetadata) (obj)).getCoverImageUri(), snapshotmetadata.getCoverImageUri()) || !zzw.equal(Float.valueOf(((SnapshotMetadata) (obj)).getCoverImageAspectRatio()), Float.valueOf(snapshotmetadata.getCoverImageAspectRatio())) || !zzw.equal(((SnapshotMetadata) (obj)).getTitle(), snapshotmetadata.getTitle()) || !zzw.equal(((SnapshotMetadata) (obj)).getDescription(), snapshotmetadata.getDescription()) || !zzw.equal(Long.valueOf(((SnapshotMetadata) (obj)).getLastModifiedTimestamp()), Long.valueOf(snapshotmetadata.getLastModifiedTimestamp())) || !zzw.equal(Long.valueOf(((SnapshotMetadata) (obj)).getPlayedTime()), Long.valueOf(snapshotmetadata.getPlayedTime())) || !zzw.equal(((SnapshotMetadata) (obj)).getUniqueName(), snapshotmetadata.getUniqueName()) || !zzw.equal(Boolean.valueOf(((SnapshotMetadata) (obj)).hasChangePending()), Boolean.valueOf(snapshotmetadata.hasChangePending())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(Long.valueOf(((SnapshotMetadata) (obj)).getProgressValue()), Long.valueOf(snapshotmetadata.getProgressValue()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(SnapshotMetadata snapshotmetadata)
    {
        return zzw.zzu(snapshotmetadata).zzg("Game", snapshotmetadata.getGame()).zzg("Owner", snapshotmetadata.getOwner()).zzg("SnapshotId", snapshotmetadata.getSnapshotId()).zzg("CoverImageUri", snapshotmetadata.getCoverImageUri()).zzg("CoverImageUrl", snapshotmetadata.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(snapshotmetadata.getCoverImageAspectRatio())).zzg("Description", snapshotmetadata.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(snapshotmetadata.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(snapshotmetadata.getPlayedTime())).zzg("UniqueName", snapshotmetadata.getUniqueName()).zzg("ChangePending", Boolean.valueOf(snapshotmetadata.hasChangePending())).zzg("ProgressValue", Long.valueOf(snapshotmetadata.getProgressValue())).toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public SnapshotMetadata freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public float getCoverImageAspectRatio()
    {
        return zzazr;
    }

    public Uri getCoverImageUri()
    {
        return zzazk;
    }

    public String getCoverImageUrl()
    {
        return zzazo;
    }

    public String getDescription()
    {
        return zzaoB;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzaoB, chararraybuffer);
    }

    public Game getGame()
    {
        return zzaxY;
    }

    public long getLastModifiedTimestamp()
    {
        return zzazp;
    }

    public Player getOwner()
    {
        return zzazn;
    }

    public long getPlayedTime()
    {
        return zzazq;
    }

    public long getProgressValue()
    {
        return zzazu;
    }

    public String getSnapshotId()
    {
        return zzasZ;
    }

    public String getTitle()
    {
        return zzagU;
    }

    public String getUniqueName()
    {
        return zzazs;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public boolean hasChangePending()
    {
        return zzazt;
    }

    public int hashCode()
    {
        return zza(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        SnapshotMetadataEntityCreator.zza(this, parcel, i);
    }

}

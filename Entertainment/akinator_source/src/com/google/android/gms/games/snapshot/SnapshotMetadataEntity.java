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
import com.google.android.gms.internal.zzmo;

// Referenced classes of package com.google.android.gms.games.snapshot:
//            SnapshotMetadata, SnapshotMetadataEntityCreator

public final class SnapshotMetadataEntity
    implements SafeParcelable, SnapshotMetadata
{

    public static final android.os.Parcelable.Creator CREATOR = new SnapshotMetadataEntityCreator();
    private final int mVersionCode;
    private final GameEntity zzaAy;
    private final Uri zzaBK;
    private final PlayerEntity zzaBN;
    private final String zzaBO;
    private final long zzaBP;
    private final long zzaBQ;
    private final float zzaBR;
    private final String zzaBS;
    private final boolean zzaBT;
    private final long zzaBU;
    private final String zzaBV;
    private final String zzajf;
    private final String zzaqZ;
    private final String zzavx;

    SnapshotMetadataEntity(int i, GameEntity gameentity, PlayerEntity playerentity, String s, Uri uri, String s1, String s2, 
            String s3, long l, long l1, float f, String s4, 
            boolean flag, long l2, String s5)
    {
        mVersionCode = i;
        zzaAy = gameentity;
        zzaBN = playerentity;
        zzavx = s;
        zzaBK = uri;
        zzaBO = s1;
        zzaBR = f;
        zzajf = s2;
        zzaqZ = s3;
        zzaBP = l;
        zzaBQ = l1;
        zzaBS = s4;
        zzaBT = flag;
        zzaBU = l2;
        zzaBV = s5;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotmetadata)
    {
        mVersionCode = 6;
        zzaAy = new GameEntity(snapshotmetadata.getGame());
        zzaBN = new PlayerEntity(snapshotmetadata.getOwner());
        zzavx = snapshotmetadata.getSnapshotId();
        zzaBK = snapshotmetadata.getCoverImageUri();
        zzaBO = snapshotmetadata.getCoverImageUrl();
        zzaBR = snapshotmetadata.getCoverImageAspectRatio();
        zzajf = snapshotmetadata.getTitle();
        zzaqZ = snapshotmetadata.getDescription();
        zzaBP = snapshotmetadata.getLastModifiedTimestamp();
        zzaBQ = snapshotmetadata.getPlayedTime();
        zzaBS = snapshotmetadata.getUniqueName();
        zzaBT = snapshotmetadata.hasChangePending();
        zzaBU = snapshotmetadata.getProgressValue();
        zzaBV = snapshotmetadata.getDeviceName();
    }

    static int zza(SnapshotMetadata snapshotmetadata)
    {
        return zzw.hashCode(new Object[] {
            snapshotmetadata.getGame(), snapshotmetadata.getOwner(), snapshotmetadata.getSnapshotId(), snapshotmetadata.getCoverImageUri(), Float.valueOf(snapshotmetadata.getCoverImageAspectRatio()), snapshotmetadata.getTitle(), snapshotmetadata.getDescription(), Long.valueOf(snapshotmetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotmetadata.getPlayedTime()), snapshotmetadata.getUniqueName(), 
            Boolean.valueOf(snapshotmetadata.hasChangePending()), Long.valueOf(snapshotmetadata.getProgressValue()), snapshotmetadata.getDeviceName()
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
        if (!zzw.equal(((SnapshotMetadata) (obj)).getGame(), snapshotmetadata.getGame()) || !zzw.equal(((SnapshotMetadata) (obj)).getOwner(), snapshotmetadata.getOwner()) || !zzw.equal(((SnapshotMetadata) (obj)).getSnapshotId(), snapshotmetadata.getSnapshotId()) || !zzw.equal(((SnapshotMetadata) (obj)).getCoverImageUri(), snapshotmetadata.getCoverImageUri()) || !zzw.equal(Float.valueOf(((SnapshotMetadata) (obj)).getCoverImageAspectRatio()), Float.valueOf(snapshotmetadata.getCoverImageAspectRatio())) || !zzw.equal(((SnapshotMetadata) (obj)).getTitle(), snapshotmetadata.getTitle()) || !zzw.equal(((SnapshotMetadata) (obj)).getDescription(), snapshotmetadata.getDescription()) || !zzw.equal(Long.valueOf(((SnapshotMetadata) (obj)).getLastModifiedTimestamp()), Long.valueOf(snapshotmetadata.getLastModifiedTimestamp())) || !zzw.equal(Long.valueOf(((SnapshotMetadata) (obj)).getPlayedTime()), Long.valueOf(snapshotmetadata.getPlayedTime())) || !zzw.equal(((SnapshotMetadata) (obj)).getUniqueName(), snapshotmetadata.getUniqueName()) || !zzw.equal(Boolean.valueOf(((SnapshotMetadata) (obj)).hasChangePending()), Boolean.valueOf(snapshotmetadata.hasChangePending())) || !zzw.equal(Long.valueOf(((SnapshotMetadata) (obj)).getProgressValue()), Long.valueOf(snapshotmetadata.getProgressValue())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((SnapshotMetadata) (obj)).getDeviceName(), snapshotmetadata.getDeviceName())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(SnapshotMetadata snapshotmetadata)
    {
        return zzw.zzv(snapshotmetadata).zzg("Game", snapshotmetadata.getGame()).zzg("Owner", snapshotmetadata.getOwner()).zzg("SnapshotId", snapshotmetadata.getSnapshotId()).zzg("CoverImageUri", snapshotmetadata.getCoverImageUri()).zzg("CoverImageUrl", snapshotmetadata.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(snapshotmetadata.getCoverImageAspectRatio())).zzg("Description", snapshotmetadata.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(snapshotmetadata.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(snapshotmetadata.getPlayedTime())).zzg("UniqueName", snapshotmetadata.getUniqueName()).zzg("ChangePending", Boolean.valueOf(snapshotmetadata.hasChangePending())).zzg("ProgressValue", Long.valueOf(snapshotmetadata.getProgressValue())).zzg("DeviceName", snapshotmetadata.getDeviceName()).toString();
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
        return zzaBR;
    }

    public Uri getCoverImageUri()
    {
        return zzaBK;
    }

    public String getCoverImageUrl()
    {
        return zzaBO;
    }

    public String getDescription()
    {
        return zzaqZ;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzaqZ, chararraybuffer);
    }

    public String getDeviceName()
    {
        return zzaBV;
    }

    public Game getGame()
    {
        return zzaAy;
    }

    public long getLastModifiedTimestamp()
    {
        return zzaBP;
    }

    public Player getOwner()
    {
        return zzaBN;
    }

    public long getPlayedTime()
    {
        return zzaBQ;
    }

    public long getProgressValue()
    {
        return zzaBU;
    }

    public String getSnapshotId()
    {
        return zzavx;
    }

    public String getTitle()
    {
        return zzajf;
    }

    public String getUniqueName()
    {
        return zzaBS;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public boolean hasChangePending()
    {
        return zzaBT;
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

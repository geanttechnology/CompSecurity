// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.games.snapshot:
//            SnapshotMetadataChange, SnapshotMetadataChangeCreator

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange
    implements SafeParcelable
{

    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int mVersionCode;
    private final Long zzaBI;
    private final Uri zzaBK;
    private final Long zzaBL;
    private BitmapTeleporter zzaBM;
    private final String zzaqZ;

    SnapshotMetadataChangeEntity()
    {
        this(5, null, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int i, String s, Long long1, BitmapTeleporter bitmapteleporter, Uri uri, Long long2)
    {
        boolean flag2 = true;
        boolean flag = true;
        super();
        mVersionCode = i;
        zzaqZ = s;
        zzaBL = long1;
        zzaBM = bitmapteleporter;
        zzaBK = uri;
        zzaBI = long2;
        if (zzaBM != null)
        {
            if (zzaBK != null)
            {
                flag = false;
            }
            zzx.zza(flag, "Cannot set both a URI and an image");
        } else
        if (zzaBK != null)
        {
            boolean flag1;
            if (zzaBM == null)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
            zzx.zza(flag1, "Cannot set both a URI and an image");
            return;
        }
    }

    SnapshotMetadataChangeEntity(String s, Long long1, BitmapTeleporter bitmapteleporter, Uri uri, Long long2)
    {
        this(5, s, long1, bitmapteleporter, uri, long2);
    }

    public int describeContents()
    {
        return 0;
    }

    public Bitmap getCoverImage()
    {
        if (zzaBM == null)
        {
            return null;
        } else
        {
            return zzaBM.zzos();
        }
    }

    public Uri getCoverImageUri()
    {
        return zzaBK;
    }

    public String getDescription()
    {
        return zzaqZ;
    }

    public Long getPlayedTimeMillis()
    {
        return zzaBL;
    }

    public Long getProgressValue()
    {
        return zzaBI;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        SnapshotMetadataChangeCreator.zza(this, parcel, i);
    }

    public BitmapTeleporter zzvS()
    {
        return zzaBM;
    }

}

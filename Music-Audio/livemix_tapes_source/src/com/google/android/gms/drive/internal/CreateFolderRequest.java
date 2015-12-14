// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzn

public class CreateFolderRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    final MetadataBundle zzaib;
    final DriveId zzaid;

    CreateFolderRequest(int i, DriveId driveid, MetadataBundle metadatabundle)
    {
        mVersionCode = i;
        zzaid = (DriveId)zzx.zzv(driveid);
        zzaib = (MetadataBundle)zzx.zzv(metadatabundle);
    }

    public CreateFolderRequest(DriveId driveid, MetadataBundle metadatabundle)
    {
        this(1, driveid, metadatabundle);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzn.zza(this, parcel, i);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzh

public class CloseContentsAndUpdateMetadataRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzh();
    final int mVersionCode;
    final String zzaiX;
    final boolean zzaiY;
    final DriveId zzakc;
    final MetadataBundle zzakd;
    final Contents zzake;
    final int zzakf;
    final int zzakg;
    final boolean zzakh;

    CloseContentsAndUpdateMetadataRequest(int i, DriveId driveid, MetadataBundle metadatabundle, Contents contents, boolean flag, String s, int j, 
            int k, boolean flag1)
    {
        mVersionCode = i;
        zzakc = driveid;
        zzakd = metadatabundle;
        zzake = contents;
        zzaiY = flag;
        zzaiX = s;
        zzakf = j;
        zzakg = k;
        zzakh = flag1;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId driveid, MetadataBundle metadatabundle, int i, boolean flag, ExecutionOptions executionoptions)
    {
        this(1, driveid, metadatabundle, null, executionoptions.zzqT(), executionoptions.zzqS(), executionoptions.zzqU(), i, flag);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh.zza(this, parcel, i);
    }

}

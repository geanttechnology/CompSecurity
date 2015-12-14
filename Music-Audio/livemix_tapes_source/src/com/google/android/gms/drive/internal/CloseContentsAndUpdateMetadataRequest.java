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
//            zzg

public class CloseContentsAndUpdateMetadataRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzg();
    final int mVersionCode;
    final String zzagM;
    final boolean zzagN;
    final DriveId zzahP;
    final MetadataBundle zzahQ;
    final Contents zzahR;
    final int zzahS;
    final int zzahT;
    final boolean zzahU;

    CloseContentsAndUpdateMetadataRequest(int i, DriveId driveid, MetadataBundle metadatabundle, Contents contents, boolean flag, String s, int j, 
            int k, boolean flag1)
    {
        mVersionCode = i;
        zzahP = driveid;
        zzahQ = metadatabundle;
        zzahR = contents;
        zzagN = flag;
        zzagM = s;
        zzahS = j;
        zzahT = k;
        zzahU = flag1;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId driveid, MetadataBundle metadatabundle, int i, boolean flag, ExecutionOptions executionoptions)
    {
        this(1, driveid, metadatabundle, null, executionoptions.zzqm(), executionoptions.zzql(), executionoptions.zzqn(), i, flag);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

}

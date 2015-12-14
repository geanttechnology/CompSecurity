// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzai

public class GetMetadataRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzai();
    final int mVersionCode;
    final DriveId zzahP;
    final boolean zzajq;

    GetMetadataRequest(int i, DriveId driveid, boolean flag)
    {
        mVersionCode = i;
        zzahP = driveid;
        zzajq = flag;
    }

    public GetMetadataRequest(DriveId driveid, boolean flag)
    {
        this(1, driveid, flag);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzai.zza(this, parcel, i);
    }

}

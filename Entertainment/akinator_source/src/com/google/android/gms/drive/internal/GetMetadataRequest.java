// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzaj

public class GetMetadataRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzaj();
    final int mVersionCode;
    final DriveId zzakc;
    final boolean zzalF;

    GetMetadataRequest(int i, DriveId driveid, boolean flag)
    {
        mVersionCode = i;
        zzakc = driveid;
        zzalF = flag;
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
        zzaj.zza(this, parcel, i);
    }

}

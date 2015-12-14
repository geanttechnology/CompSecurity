// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzbi

public class OpenContentsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzbi();
    final int mVersionCode;
    final int zzagr;
    final DriveId zzahP;
    final int zzajV;

    OpenContentsRequest(int i, DriveId driveid, int j, int k)
    {
        mVersionCode = i;
        zzahP = driveid;
        zzagr = j;
        zzajV = k;
    }

    public OpenContentsRequest(DriveId driveid, int i, int j)
    {
        this(1, driveid, i, j);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzbi.zza(this, parcel, i);
    }

}

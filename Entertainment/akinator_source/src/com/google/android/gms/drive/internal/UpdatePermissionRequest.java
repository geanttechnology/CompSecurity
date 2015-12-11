// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzca

public class UpdatePermissionRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzca();
    final int mVersionCode;
    final DriveId zzaiA;
    final String zzaiX;
    final boolean zzajW;
    final String zzajj;
    final int zzamu;

    UpdatePermissionRequest(int i, DriveId driveid, String s, int j, boolean flag, String s1)
    {
        mVersionCode = i;
        zzaiA = driveid;
        zzajj = s;
        zzamu = j;
        zzajW = flag;
        zzaiX = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzca.zza(this, parcel, i);
    }

}

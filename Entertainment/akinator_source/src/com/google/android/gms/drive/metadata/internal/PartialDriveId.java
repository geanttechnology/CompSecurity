// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            zzm

public class PartialDriveId
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzm();
    final int mVersionCode;
    final String zzaiM;
    final long zzaiN;
    final int zzaiO;

    PartialDriveId(int i, String s, long l, int j)
    {
        mVersionCode = i;
        zzaiM = s;
        zzaiN = l;
        zzaiO = j;
    }

    public PartialDriveId(String s, long l, int i)
    {
        this(1, s, l, i);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

    public DriveId zzD(long l)
    {
        return new DriveId(zzaiM, zzaiN, l, zzaiO);
    }

}

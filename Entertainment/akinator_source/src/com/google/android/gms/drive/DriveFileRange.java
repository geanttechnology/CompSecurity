// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.drive:
//            zzc

public class DriveFileRange
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    final int mVersionCode;
    final long zzaiK;
    final long zzaiL;

    DriveFileRange(int i, long l, long l1)
    {
        mVersionCode = i;
        zzaiK = l;
        zzaiL = l1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}

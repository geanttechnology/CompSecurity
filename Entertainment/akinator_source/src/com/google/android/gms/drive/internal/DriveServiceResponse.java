// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzq;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzad

public class DriveServiceResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzad();
    final int mVersionCode;
    final IBinder zzals;

    DriveServiceResponse(int i, IBinder ibinder)
    {
        mVersionCode = i;
        zzals = ibinder;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzad.zza(this, parcel, i);
    }

    public zzq zzrr()
    {
        return com.google.android.gms.common.internal.zzq.zza.zzaI(zzals);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zzh

public static class lng
    implements SafeParcelable
{

    public static final zzh CREATOR = new zzh();
    public double lat;
    public double lng;
    final int versionCode;

    public int describeContents()
    {
        zzh zzh1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh zzh1 = CREATOR;
        zzh.zza(this, parcel, i);
    }


    public arcelable()
    {
        versionCode = 1;
    }

    public versionCode(int i, double d, double d1)
    {
        versionCode = i;
        lat = d;
        lng = d1;
    }
}

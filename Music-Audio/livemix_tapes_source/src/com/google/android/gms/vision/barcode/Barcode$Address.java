// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zza

public static class addressLines
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    public static final int HOME = 2;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    public String addressLines[];
    public int type;
    final int versionCode;

    public int describeContents()
    {
        zza zza1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza zza1 = CREATOR;
        zza.zza(this, parcel, i);
    }


    public Parcelable()
    {
        versionCode = 1;
    }

    public versionCode(int i, int j, String as[])
    {
        versionCode = i;
        type = j;
        addressLines = as;
    }
}

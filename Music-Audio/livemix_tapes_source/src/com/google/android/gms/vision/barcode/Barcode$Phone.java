// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zzj

public static class number
    implements SafeParcelable
{

    public static final zzj CREATOR = new zzj();
    public static final int FAX = 3;
    public static final int HOME = 2;
    public static final int MOBILE = 4;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    public String number;
    public int type;
    final int versionCode;

    public int describeContents()
    {
        zzj zzj1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj zzj1 = CREATOR;
        zzj.zza(this, parcel, i);
    }


    public feParcelable()
    {
        versionCode = 1;
    }

    public versionCode(int i, int j, String s)
    {
        versionCode = i;
        type = j;
        number = s;
    }
}

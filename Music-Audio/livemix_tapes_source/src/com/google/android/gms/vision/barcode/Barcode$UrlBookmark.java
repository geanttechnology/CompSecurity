// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zzl

public static class url
    implements SafeParcelable
{

    public static final zzl CREATOR = new zzl();
    public String title;
    public String url;
    final int versionCode;

    public int describeContents()
    {
        zzl zzl1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzl zzl1 = CREATOR;
        zzl.zza(this, parcel, i);
    }


    public elable()
    {
        versionCode = 1;
    }

    public versionCode(int i, String s, String s1)
    {
        versionCode = i;
        title = s;
        url = s1;
    }
}

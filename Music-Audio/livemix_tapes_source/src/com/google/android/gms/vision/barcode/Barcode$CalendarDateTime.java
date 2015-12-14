// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zzc

public static class rawValue
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    public int day;
    public int hours;
    public boolean isUtc;
    public int minutes;
    public int month;
    public String rawValue;
    public int seconds;
    final int versionCode;
    public int year;

    public int describeContents()
    {
        zzc zzc1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc zzc1 = CREATOR;
        zzc.zza(this, parcel, i);
    }


    public e()
    {
        versionCode = 1;
    }

    public versionCode(int i, int j, int k, int l, int i1, int j1, int k1, 
            boolean flag, String s)
    {
        versionCode = i;
        year = j;
        month = k;
        day = l;
        hours = i1;
        minutes = j1;
        seconds = k1;
        isUtc = flag;
        rawValue = s;
    }
}

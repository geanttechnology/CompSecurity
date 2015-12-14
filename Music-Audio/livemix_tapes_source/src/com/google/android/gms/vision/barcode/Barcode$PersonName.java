// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zzi

public static class suffix
    implements SafeParcelable
{

    public static final zzi CREATOR = new zzi();
    public String first;
    public String formattedName;
    public String last;
    public String middle;
    public String prefix;
    public String pronunciation;
    public String suffix;
    final int versionCode;

    public int describeContents()
    {
        zzi zzi1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzi zzi1 = CREATOR;
        zzi.zza(this, parcel, i);
    }


    public celable()
    {
        versionCode = 1;
    }

    public versionCode(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
    {
        versionCode = i;
        formattedName = s;
        pronunciation = s1;
        prefix = s2;
        first = s3;
        middle = s4;
        last = s5;
        suffix = s6;
    }
}

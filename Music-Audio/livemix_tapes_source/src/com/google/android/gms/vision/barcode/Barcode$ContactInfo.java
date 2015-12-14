// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zze

public static class addresses
    implements SafeParcelable
{

    public static final zze CREATOR = new zze();
    public CREATOR addresses[];
    public CREATOR emails[];
    public CREATOR name;
    public String organization;
    public CREATOR phones[];
    public String title;
    public String urls[];
    final int versionCode;

    public int describeContents()
    {
        zze zze1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze zze1 = CREATOR;
        zze.zza(this, parcel, i);
    }


    public elable()
    {
        versionCode = 1;
    }

    public versionCode(int i, versionCode versioncode, String s, String s1, versionCode aversioncode[], versionCode aversioncode1[], String as[], 
            versionCode aversioncode2[])
    {
        versionCode = i;
        name = versioncode;
        organization = s;
        title = s1;
        phones = aversioncode;
        emails = aversioncode1;
        urls = as;
        addresses = aversioncode2;
    }
}

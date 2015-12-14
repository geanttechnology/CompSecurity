// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zzm

public static class encryptionType
    implements SafeParcelable
{

    public static final zzm CREATOR = new zzm();
    public static final int OPEN = 1;
    public static final int WEP = 3;
    public static final int WPA = 2;
    public int encryptionType;
    public String password;
    public String ssid;
    final int versionCode;

    public int describeContents()
    {
        zzm zzm1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm zzm1 = CREATOR;
        zzm.zza(this, parcel, i);
    }


    public afeParcelable()
    {
        versionCode = 1;
    }

    public versionCode(int i, String s, String s1, int j)
    {
        versionCode = i;
        ssid = s;
        password = s1;
        encryptionType = j;
    }
}

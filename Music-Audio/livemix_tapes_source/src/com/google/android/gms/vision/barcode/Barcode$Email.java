// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zzg

public static class body
    implements SafeParcelable
{

    public static final zzg CREATOR = new zzg();
    public static final int HOME = 2;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    public String address;
    public String body;
    public String subject;
    public int type;
    final int versionCode;

    public int describeContents()
    {
        zzg zzg1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg zzg1 = CREATOR;
        zzg.zza(this, parcel, i);
    }


    public feParcelable()
    {
        versionCode = 1;
    }

    public versionCode(int i, int j, String s, String s1, String s2)
    {
        versionCode = i;
        type = j;
        address = s;
        subject = s1;
        body = s2;
    }
}

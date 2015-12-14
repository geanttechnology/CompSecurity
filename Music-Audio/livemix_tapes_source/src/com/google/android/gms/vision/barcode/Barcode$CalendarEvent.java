// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode, zzd

public static class end
    implements SafeParcelable
{

    public static final zzd CREATOR = new zzd();
    public String description;
    public me end;
    public String location;
    public String organizer;
    public me start;
    public String status;
    public String summary;
    final int versionCode;

    public int describeContents()
    {
        zzd zzd1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd zzd1 = CREATOR;
        zzd.zza(this, parcel, i);
    }


    public me()
    {
        versionCode = 1;
    }

    public me(int i, String s, String s1, String s2, String s3, String s4, me me, 
            me me1)
    {
        versionCode = i;
        summary = s;
        description = s1;
        location = s2;
        organizer = s3;
        status = s4;
        start = me;
        end = me1;
    }
}

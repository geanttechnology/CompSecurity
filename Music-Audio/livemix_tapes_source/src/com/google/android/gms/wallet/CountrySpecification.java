// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zzc

public class CountrySpecification
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    String zzFF;

    CountrySpecification(int i, String s)
    {
        mVersionCode = i;
        zzFF = s;
    }

    public CountrySpecification(String s)
    {
        mVersionCode = 1;
        zzFF = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCountryCode()
    {
        return zzFF;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}

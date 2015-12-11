// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zza

public final class Address
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzGw;
    String zzaDk;
    String zzaDl;
    String zzaDm;
    String zzaDr;
    boolean zzaDt;
    String zzaDu;
    String zzbcg;
    String zzbch;

    Address()
    {
        mVersionCode = 1;
    }

    Address(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, boolean flag, String s9)
    {
        mVersionCode = i;
        name = s;
        zzaDk = s1;
        zzaDl = s2;
        zzaDm = s3;
        zzGw = s4;
        zzbcg = s5;
        zzbch = s6;
        zzaDr = s7;
        phoneNumber = s8;
        zzaDt = flag;
        zzaDu = s9;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final String getAddress1()
    {
        return zzaDk;
    }

    public final String getAddress2()
    {
        return zzaDl;
    }

    public final String getAddress3()
    {
        return zzaDm;
    }

    public final String getCity()
    {
        return zzbcg;
    }

    public final String getCompanyName()
    {
        return zzaDu;
    }

    public final String getCountryCode()
    {
        return zzGw;
    }

    public final String getName()
    {
        return name;
    }

    public final String getPhoneNumber()
    {
        return phoneNumber;
    }

    public final String getPostalCode()
    {
        return zzaDr;
    }

    public final String getState()
    {
        return zzbch;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final boolean isPostBox()
    {
        return zzaDt;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}

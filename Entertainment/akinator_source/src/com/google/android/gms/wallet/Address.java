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

    public int describeContents()
    {
        return 0;
    }

    public String getAddress1()
    {
        return zzaDk;
    }

    public String getAddress2()
    {
        return zzaDl;
    }

    public String getAddress3()
    {
        return zzaDm;
    }

    public String getCity()
    {
        return zzbcg;
    }

    public String getCompanyName()
    {
        return zzaDu;
    }

    public String getCountryCode()
    {
        return zzGw;
    }

    public String getName()
    {
        return name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getPostalCode()
    {
        return zzaDr;
    }

    public String getState()
    {
        return zzbch;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public boolean isPostBox()
    {
        return zzaDt;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}

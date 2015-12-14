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
    String zzFF;
    String zzaAC;
    String zzaAD;
    String zzaAE;
    String zzaAJ;
    boolean zzaAL;
    String zzaAM;
    String zzaVZ;
    String zzaWa;

    Address()
    {
        mVersionCode = 1;
    }

    Address(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, boolean flag, String s9)
    {
        mVersionCode = i;
        name = s;
        zzaAC = s1;
        zzaAD = s2;
        zzaAE = s3;
        zzFF = s4;
        zzaVZ = s5;
        zzaWa = s6;
        zzaAJ = s7;
        phoneNumber = s8;
        zzaAL = flag;
        zzaAM = s9;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAddress1()
    {
        return zzaAC;
    }

    public String getAddress2()
    {
        return zzaAD;
    }

    public String getAddress3()
    {
        return zzaAE;
    }

    public String getCity()
    {
        return zzaVZ;
    }

    public String getCompanyName()
    {
        return zzaAM;
    }

    public String getCountryCode()
    {
        return zzFF;
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
        return zzaAJ;
    }

    public String getState()
    {
        return zzaWa;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public boolean isPostBox()
    {
        return zzaAL;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

}

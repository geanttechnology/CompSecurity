// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.identity.intents.model:
//            zzb

public final class UserAddress
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzFF;
    String zzaAC;
    String zzaAD;
    String zzaAE;
    String zzaAF;
    String zzaAG;
    String zzaAH;
    String zzaAI;
    String zzaAJ;
    String zzaAK;
    boolean zzaAL;
    String zzaAM;
    String zzaAN;

    UserAddress()
    {
        mVersionCode = 1;
    }

    UserAddress(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, String s10, String s11, boolean flag, 
            String s12, String s13)
    {
        mVersionCode = i;
        name = s;
        zzaAC = s1;
        zzaAD = s2;
        zzaAE = s3;
        zzaAF = s4;
        zzaAG = s5;
        zzaAH = s6;
        zzaAI = s7;
        zzFF = s8;
        zzaAJ = s9;
        zzaAK = s10;
        phoneNumber = s11;
        zzaAL = flag;
        zzaAM = s12;
        zzaAN = s13;
    }

    public static UserAddress fromIntent(Intent intent)
    {
        if (intent == null || !intent.hasExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS"))
        {
            return null;
        } else
        {
            return (UserAddress)intent.getParcelableExtra("com.google.android.gms.identity.intents.EXTRA_ADDRESS");
        }
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

    public String getAddress4()
    {
        return zzaAF;
    }

    public String getAddress5()
    {
        return zzaAG;
    }

    public String getAdministrativeArea()
    {
        return zzaAH;
    }

    public String getCompanyName()
    {
        return zzaAM;
    }

    public String getCountryCode()
    {
        return zzFF;
    }

    public String getEmailAddress()
    {
        return zzaAN;
    }

    public String getLocality()
    {
        return zzaAI;
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

    public String getSortingCode()
    {
        return zzaAK;
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
        zzb.zza(this, parcel, i);
    }

}

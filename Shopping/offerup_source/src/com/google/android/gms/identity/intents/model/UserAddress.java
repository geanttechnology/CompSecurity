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
    String zzGw;
    String zzaDk;
    String zzaDl;
    String zzaDm;
    String zzaDn;
    String zzaDo;
    String zzaDp;
    String zzaDq;
    String zzaDr;
    String zzaDs;
    boolean zzaDt;
    String zzaDu;
    String zzaDv;

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
        zzaDk = s1;
        zzaDl = s2;
        zzaDm = s3;
        zzaDn = s4;
        zzaDo = s5;
        zzaDp = s6;
        zzaDq = s7;
        zzGw = s8;
        zzaDr = s9;
        zzaDs = s10;
        phoneNumber = s11;
        zzaDt = flag;
        zzaDu = s12;
        zzaDv = s13;
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

    public final String getAddress4()
    {
        return zzaDn;
    }

    public final String getAddress5()
    {
        return zzaDo;
    }

    public final String getAdministrativeArea()
    {
        return zzaDp;
    }

    public final String getCompanyName()
    {
        return zzaDu;
    }

    public final String getCountryCode()
    {
        return zzGw;
    }

    public final String getEmailAddress()
    {
        return zzaDv;
    }

    public final String getLocality()
    {
        return zzaDq;
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

    public final String getSortingCode()
    {
        return zzaDs;
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
        zzb.zza(this, parcel, i);
    }

}

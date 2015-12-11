// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            a

public final class Address
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    String Ga;
    String Gb;
    String Gc;
    String Gd;
    String Ge;
    String Gf;
    String Gg;
    boolean Gh;
    String Gi;
    String id;
    private final int kg;
    String name;

    Address()
    {
        kg = 1;
    }

    Address(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, boolean flag, String s9)
    {
        kg = i;
        name = s;
        Ga = s1;
        Gb = s2;
        Gc = s3;
        id = s4;
        Gd = s5;
        Ge = s6;
        Gf = s7;
        Gg = s8;
        Gh = flag;
        Gi = s9;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAddress1()
    {
        return Ga;
    }

    public String getAddress2()
    {
        return Gb;
    }

    public String getAddress3()
    {
        return Gc;
    }

    public String getCity()
    {
        return Gd;
    }

    public String getCompanyName()
    {
        return Gi;
    }

    public String getCountryCode()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPhoneNumber()
    {
        return Gg;
    }

    public String getPostalCode()
    {
        return Gf;
    }

    public String getState()
    {
        return Ge;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public boolean isPostBox()
    {
        return Gh;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        a.a(this, parcel, i);
    }

}

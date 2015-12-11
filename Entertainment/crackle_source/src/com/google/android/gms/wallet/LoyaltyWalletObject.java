// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            g

public final class LoyaltyWalletObject
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new g();
    String GA;
    String GB;
    String GC;
    String GD;
    String GE;
    String GF;
    String GG;
    String GH;
    private final int kg;

    LoyaltyWalletObject()
    {
        kg = 3;
    }

    LoyaltyWalletObject(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7)
    {
        kg = i;
        GA = s;
        GB = s1;
        GC = s2;
        GD = s3;
        GE = s4;
        GF = s5;
        GG = s6;
        GH = s7;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAccountId()
    {
        return GB;
    }

    public String getAccountName()
    {
        return GE;
    }

    public String getBarcodeAlternateText()
    {
        return GF;
    }

    public String getBarcodeType()
    {
        return GG;
    }

    public String getBarcodeValue()
    {
        return GH;
    }

    public String getId()
    {
        return GA;
    }

    public String getIssuerName()
    {
        return GC;
    }

    public String getProgramName()
    {
        return GD;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        g.a(this, parcel, i);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            h, LoyaltyWalletObject, OfferWalletObject, Address

public final class MaskedWallet
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new h();
    LoyaltyWalletObject GI[];
    OfferWalletObject GJ[];
    String Gn;
    String Go;
    String Gq;
    Address Gr;
    Address Gs;
    String Gt[];
    private final int kg;

    MaskedWallet()
    {
        kg = 2;
    }

    MaskedWallet(int i, String s, String s1, String as[], String s2, Address address, Address address1, 
            LoyaltyWalletObject aloyaltywalletobject[], OfferWalletObject aofferwalletobject[])
    {
        kg = i;
        Gn = s;
        Go = s1;
        Gt = as;
        Gq = s2;
        Gr = address;
        Gs = address1;
        GI = aloyaltywalletobject;
        GJ = aofferwalletobject;
    }

    public int describeContents()
    {
        return 0;
    }

    public Address getBillingAddress()
    {
        return Gr;
    }

    public String getEmail()
    {
        return Gq;
    }

    public String getGoogleTransactionId()
    {
        return Gn;
    }

    public LoyaltyWalletObject[] getLoyaltyWalletObjects()
    {
        return GI;
    }

    public String getMerchantTransactionId()
    {
        return Go;
    }

    public OfferWalletObject[] getOfferWalletObjects()
    {
        return GJ;
    }

    public String[] getPaymentDescriptions()
    {
        return Gt;
    }

    public Address getShippingAddress()
    {
        return Gs;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        h.a(this, parcel, i);
    }

}

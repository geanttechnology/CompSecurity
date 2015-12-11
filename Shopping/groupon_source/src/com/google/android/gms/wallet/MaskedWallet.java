// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

// Referenced classes of package com.google.android.gms.wallet:
//            zzk, Address, InstrumentInfo, LoyaltyWalletObject, 
//            OfferWalletObject

public final class MaskedWallet
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    private final int zzCY;
    String zzaQm;
    String zzaQn;
    String zzaQp;
    Address zzaQq;
    Address zzaQr;
    String zzaQs[];
    UserAddress zzaQt;
    UserAddress zzaQu;
    InstrumentInfo zzaQv[];
    LoyaltyWalletObject zzaRf[];
    OfferWalletObject zzaRg[];

    private MaskedWallet()
    {
        zzCY = 2;
    }

    MaskedWallet(int i, String s, String s1, String as[], String s2, Address address, Address address1, 
            LoyaltyWalletObject aloyaltywalletobject[], OfferWalletObject aofferwalletobject[], UserAddress useraddress, UserAddress useraddress1, InstrumentInfo ainstrumentinfo[])
    {
        zzCY = i;
        zzaQm = s;
        zzaQn = s1;
        zzaQs = as;
        zzaQp = s2;
        zzaQq = address;
        zzaQr = address1;
        zzaRf = aloyaltywalletobject;
        zzaRg = aofferwalletobject;
        zzaQt = useraddress;
        zzaQu = useraddress1;
        zzaQv = ainstrumentinfo;
    }

    public int describeContents()
    {
        return 0;
    }

    public Address getBillingAddress()
    {
        return zzaQq;
    }

    public String getEmail()
    {
        return zzaQp;
    }

    public String getGoogleTransactionId()
    {
        return zzaQm;
    }

    public String getMerchantTransactionId()
    {
        return zzaQn;
    }

    public String[] getPaymentDescriptions()
    {
        return zzaQs;
    }

    public Address getShippingAddress()
    {
        return zzaQr;
    }

    public int getVersionCode()
    {
        return zzCY;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import com.google.android.gms.identity.intents.model.UserAddress;

// Referenced classes of package com.google.android.gms.wallet:
//            MaskedWallet, Address, InstrumentInfo, LoyaltyWalletObject, 
//            OfferWalletObject

public final class <init>
{

    final MaskedWallet zzbdk;

    public MaskedWallet build()
    {
        return zzbdk;
    }

    public zzbdk setBillingAddress(Address address)
    {
        zzbdk.zzbct = address;
        return this;
    }

    public ddress setBuyerBillingAddress(UserAddress useraddress)
    {
        zzbdk.zzbcw = useraddress;
        return this;
    }

    public ddress setBuyerShippingAddress(UserAddress useraddress)
    {
        zzbdk.zzbcx = useraddress;
        return this;
    }

    public zzbdk setEmail(String s)
    {
        zzbdk.zzbcs = s;
        return this;
    }

    public zzbdk setGoogleTransactionId(String s)
    {
        zzbdk.zzbcp = s;
        return this;
    }

    public zzbdk setInstrumentInfos(InstrumentInfo ainstrumentinfo[])
    {
        zzbdk.zzbcy = ainstrumentinfo;
        return this;
    }

    public zzbdk setMerchantTransactionId(String s)
    {
        zzbdk.zzbcq = s;
        return this;
    }

    public zzbdk setPaymentDescriptions(String as[])
    {
        zzbdk.zzbcv = as;
        return this;
    }

    public zzbdk setShippingAddress(Address address)
    {
        zzbdk.zzbcu = address;
        return this;
    }

    public zzbdk zza(LoyaltyWalletObject aloyaltywalletobject[])
    {
        zzbdk.zzbdi = aloyaltywalletobject;
        return this;
    }

    public zzbdk zza(OfferWalletObject aofferwalletobject[])
    {
        zzbdk.zzbdj = aofferwalletobject;
        return this;
    }

    private ddress(MaskedWallet maskedwallet)
    {
        zzbdk = maskedwallet;
        super();
    }

    zzbdk(MaskedWallet maskedwallet, zzbdk zzbdk1)
    {
        this(maskedwallet);
    }
}

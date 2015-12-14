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

    final MaskedWallet zzaXd;

    public MaskedWallet build()
    {
        return zzaXd;
    }

    public zzaXd setBillingAddress(Address address)
    {
        zzaXd.zzaWm = address;
        return this;
    }

    public ddress setBuyerBillingAddress(UserAddress useraddress)
    {
        zzaXd.zzaWp = useraddress;
        return this;
    }

    public ddress setBuyerShippingAddress(UserAddress useraddress)
    {
        zzaXd.zzaWq = useraddress;
        return this;
    }

    public zzaXd setEmail(String s)
    {
        zzaXd.zzaWl = s;
        return this;
    }

    public zzaXd setGoogleTransactionId(String s)
    {
        zzaXd.zzaWi = s;
        return this;
    }

    public zzaXd setInstrumentInfos(InstrumentInfo ainstrumentinfo[])
    {
        zzaXd.zzaWr = ainstrumentinfo;
        return this;
    }

    public zzaXd setMerchantTransactionId(String s)
    {
        zzaXd.zzaWj = s;
        return this;
    }

    public zzaXd setPaymentDescriptions(String as[])
    {
        zzaXd.zzaWo = as;
        return this;
    }

    public zzaXd setShippingAddress(Address address)
    {
        zzaXd.zzaWn = address;
        return this;
    }

    public zzaXd zza(LoyaltyWalletObject aloyaltywalletobject[])
    {
        zzaXd.zzaXb = aloyaltywalletobject;
        return this;
    }

    public zzaXd zza(OfferWalletObject aofferwalletobject[])
    {
        zzaXd.zzaXc = aofferwalletobject;
        return this;
    }

    private ddress(MaskedWallet maskedwallet)
    {
        zzaXd = maskedwallet;
        super();
    }

    zzaXd(MaskedWallet maskedwallet, zzaXd zzaxd)
    {
        this(maskedwallet);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;


// Referenced classes of package com.google.android.gms.wallet:
//            MaskedWalletRequest, CountrySpecification, Cart

public final class <init>
{

    final MaskedWalletRequest GU;

    public MaskedWalletRequest build()
    {
        return GU;
    }

    public GU setAllowDebitCard(boolean flag)
    {
        GU.GT = flag;
        return this;
    }

    public GU setAllowPrepaidCard(boolean flag)
    {
        GU.GS = flag;
        return this;
    }

    public GU setAllowedShippingCountrySpecifications(CountrySpecification acountryspecification[])
    {
        GU.GR = acountryspecification;
        return this;
    }

    public GU setCart(Cart cart)
    {
        GU.Gu = cart;
        return this;
    }

    public GU setCurrencyCode(String s)
    {
        GU.Gk = s;
        return this;
    }

    public GU setEstimatedTotalPrice(String s)
    {
        GU.GN = s;
        return this;
    }

    public GU setIsBillingAgreement(boolean flag)
    {
        GU.GQ = flag;
        return this;
    }

    public GU setMerchantName(String s)
    {
        GU.GO = s;
        return this;
    }

    public GU setMerchantTransactionId(String s)
    {
        GU.Go = s;
        return this;
    }

    public GU setPhoneNumberRequired(boolean flag)
    {
        GU.GK = flag;
        return this;
    }

    public GU setShippingAddressRequired(boolean flag)
    {
        GU.GL = flag;
        return this;
    }

    public GU setShouldRetrieveWalletObjects(boolean flag)
    {
        GU.GP = flag;
        return this;
    }

    public GU setUseMinimalBillingAddress(boolean flag)
    {
        GU.GM = flag;
        return this;
    }

    private (MaskedWalletRequest maskedwalletrequest)
    {
        GU = maskedwalletrequest;
        super();
    }

    GU(MaskedWalletRequest maskedwalletrequest, GU gu)
    {
        this(maskedwalletrequest);
    }
}

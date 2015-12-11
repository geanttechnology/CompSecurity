// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.wallet:
//            MaskedWalletRequest, Cart, PaymentMethodTokenizationParameters

public final class <init>
{

    final MaskedWalletRequest zzbdy;

    public final <init> addAllowedCardNetwork(int i)
    {
        if (zzbdy.zzbdx == null)
        {
            zzbdy.zzbdx = new ArrayList();
        }
        zzbdy.zzbdx.add(Integer.valueOf(i));
        return this;
    }

    public final zzbdy addAllowedCardNetworks(Collection collection)
    {
        if (collection != null)
        {
            if (zzbdy.zzbdx == null)
            {
                zzbdy.zzbdx = new ArrayList();
            }
            zzbdy.zzbdx.addAll(collection);
        }
        return this;
    }

    public final fication addAllowedCountrySpecificationForShipping(CountrySpecification countryspecification)
    {
        if (zzbdy.zzbdv == null)
        {
            zzbdy.zzbdv = new ArrayList();
        }
        zzbdy.zzbdv.add(countryspecification);
        return this;
    }

    public final zzbdy addAllowedCountrySpecificationsForShipping(Collection collection)
    {
        if (collection != null)
        {
            if (zzbdy.zzbdv == null)
            {
                zzbdy.zzbdv = new ArrayList();
            }
            zzbdy.zzbdv.addAll(collection);
        }
        return this;
    }

    public final MaskedWalletRequest build()
    {
        return zzbdy;
    }

    public final zzbdy setAllowDebitCard(boolean flag)
    {
        zzbdy.zzbdu = flag;
        return this;
    }

    public final zzbdy setAllowPrepaidCard(boolean flag)
    {
        zzbdy.zzbdt = flag;
        return this;
    }

    public final zzbdy setCart(Cart cart)
    {
        zzbdy.zzbcA = cart;
        return this;
    }

    public final zzbdy setCurrencyCode(String s)
    {
        zzbdy.zzbcj = s;
        return this;
    }

    public final zzbdy setEstimatedTotalPrice(String s)
    {
        zzbdy.zzbdo = s;
        return this;
    }

    public final zzbdy setIsBillingAgreement(boolean flag)
    {
        zzbdy.zzbdr = flag;
        return this;
    }

    public final zzbdy setMerchantName(String s)
    {
        zzbdy.zzbdp = s;
        return this;
    }

    public final zzbdy setMerchantTransactionId(String s)
    {
        zzbdy.zzbcq = s;
        return this;
    }

    public final ameters setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentmethodtokenizationparameters)
    {
        zzbdy.zzbdw = paymentmethodtokenizationparameters;
        return this;
    }

    public final zzbdy setPhoneNumberRequired(boolean flag)
    {
        zzbdy.zzbdl = flag;
        return this;
    }

    public final zzbdy setShippingAddressRequired(boolean flag)
    {
        zzbdy.zzbdm = flag;
        return this;
    }

    public final zzbdy setUseMinimalBillingAddress(boolean flag)
    {
        zzbdy.zzbdn = flag;
        return this;
    }

    private ameters(MaskedWalletRequest maskedwalletrequest)
    {
        zzbdy = maskedwalletrequest;
        super();
    }

    zzbdy(MaskedWalletRequest maskedwalletrequest, zzbdy zzbdy1)
    {
        this(maskedwalletrequest);
    }
}

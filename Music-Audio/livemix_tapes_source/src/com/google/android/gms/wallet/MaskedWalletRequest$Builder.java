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

    final MaskedWalletRequest zzaXr;

    public <init> addAllowedCardNetwork(int i)
    {
        if (zzaXr.zzaXq == null)
        {
            zzaXr.zzaXq = new ArrayList();
        }
        zzaXr.zzaXq.add(Integer.valueOf(i));
        return this;
    }

    public zzaXr addAllowedCardNetworks(Collection collection)
    {
        if (collection != null)
        {
            if (zzaXr.zzaXq == null)
            {
                zzaXr.zzaXq = new ArrayList();
            }
            zzaXr.zzaXq.addAll(collection);
        }
        return this;
    }

    public fication addAllowedCountrySpecificationForShipping(CountrySpecification countryspecification)
    {
        if (zzaXr.zzaXo == null)
        {
            zzaXr.zzaXo = new ArrayList();
        }
        zzaXr.zzaXo.add(countryspecification);
        return this;
    }

    public zzaXr addAllowedCountrySpecificationsForShipping(Collection collection)
    {
        if (collection != null)
        {
            if (zzaXr.zzaXo == null)
            {
                zzaXr.zzaXo = new ArrayList();
            }
            zzaXr.zzaXo.addAll(collection);
        }
        return this;
    }

    public MaskedWalletRequest build()
    {
        return zzaXr;
    }

    public zzaXr setAllowDebitCard(boolean flag)
    {
        zzaXr.zzaXn = flag;
        return this;
    }

    public zzaXr setAllowPrepaidCard(boolean flag)
    {
        zzaXr.zzaXm = flag;
        return this;
    }

    public zzaXr setCart(Cart cart)
    {
        zzaXr.zzaWt = cart;
        return this;
    }

    public zzaXr setCurrencyCode(String s)
    {
        zzaXr.zzaWc = s;
        return this;
    }

    public zzaXr setEstimatedTotalPrice(String s)
    {
        zzaXr.zzaXh = s;
        return this;
    }

    public zzaXr setIsBillingAgreement(boolean flag)
    {
        zzaXr.zzaXk = flag;
        return this;
    }

    public zzaXr setMerchantName(String s)
    {
        zzaXr.zzaXi = s;
        return this;
    }

    public zzaXr setMerchantTransactionId(String s)
    {
        zzaXr.zzaWj = s;
        return this;
    }

    public ameters setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentmethodtokenizationparameters)
    {
        zzaXr.zzaXp = paymentmethodtokenizationparameters;
        return this;
    }

    public zzaXr setPhoneNumberRequired(boolean flag)
    {
        zzaXr.zzaXe = flag;
        return this;
    }

    public zzaXr setShippingAddressRequired(boolean flag)
    {
        zzaXr.zzaXf = flag;
        return this;
    }

    public zzaXr setUseMinimalBillingAddress(boolean flag)
    {
        zzaXr.zzaXg = flag;
        return this;
    }

    private ameters(MaskedWalletRequest maskedwalletrequest)
    {
        zzaXr = maskedwalletrequest;
        super();
    }

    zzaXr(MaskedWalletRequest maskedwalletrequest, zzaXr zzaxr)
    {
        this(maskedwalletrequest);
    }
}

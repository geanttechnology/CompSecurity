// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.wallet:
//            zzl, Cart, CountrySpecification, PaymentMethodTokenizationParameters

public final class MaskedWalletRequest
    implements SafeParcelable
{
    public final class Builder
    {

        final MaskedWalletRequest zzaXr;

        public Builder addAllowedCardNetwork(int i)
        {
            if (zzaXr.zzaXq == null)
            {
                zzaXr.zzaXq = new ArrayList();
            }
            zzaXr.zzaXq.add(Integer.valueOf(i));
            return this;
        }

        public Builder addAllowedCardNetworks(Collection collection)
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

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countryspecification)
        {
            if (zzaXr.zzaXo == null)
            {
                zzaXr.zzaXo = new ArrayList();
            }
            zzaXr.zzaXo.add(countryspecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection collection)
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

        public Builder setAllowDebitCard(boolean flag)
        {
            zzaXr.zzaXn = flag;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean flag)
        {
            zzaXr.zzaXm = flag;
            return this;
        }

        public Builder setCart(Cart cart)
        {
            zzaXr.zzaWt = cart;
            return this;
        }

        public Builder setCurrencyCode(String s)
        {
            zzaXr.zzaWc = s;
            return this;
        }

        public Builder setEstimatedTotalPrice(String s)
        {
            zzaXr.zzaXh = s;
            return this;
        }

        public Builder setIsBillingAgreement(boolean flag)
        {
            zzaXr.zzaXk = flag;
            return this;
        }

        public Builder setMerchantName(String s)
        {
            zzaXr.zzaXi = s;
            return this;
        }

        public Builder setMerchantTransactionId(String s)
        {
            zzaXr.zzaWj = s;
            return this;
        }

        public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentmethodtokenizationparameters)
        {
            zzaXr.zzaXp = paymentmethodtokenizationparameters;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean flag)
        {
            zzaXr.zzaXe = flag;
            return this;
        }

        public Builder setShippingAddressRequired(boolean flag)
        {
            zzaXr.zzaXf = flag;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean flag)
        {
            zzaXr.zzaXg = flag;
            return this;
        }

        private Builder()
        {
            zzaXr = MaskedWalletRequest.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new zzl();
    private final int mVersionCode;
    String zzaWc;
    String zzaWj;
    Cart zzaWt;
    boolean zzaXe;
    boolean zzaXf;
    boolean zzaXg;
    String zzaXh;
    String zzaXi;
    boolean zzaXj;
    boolean zzaXk;
    com.google.android.gms.wallet.CountrySpecification zzaXl[];
    boolean zzaXm;
    boolean zzaXn;
    ArrayList zzaXo;
    PaymentMethodTokenizationParameters zzaXp;
    ArrayList zzaXq;

    MaskedWalletRequest()
    {
        mVersionCode = 3;
        zzaXm = true;
        zzaXn = true;
    }

    MaskedWalletRequest(int i, String s, boolean flag, boolean flag1, boolean flag2, String s1, String s2, 
            String s3, Cart cart, boolean flag3, boolean flag4, com.google.android.gms.wallet.CountrySpecification acountryspecification[], boolean flag5, boolean flag6, 
            ArrayList arraylist, PaymentMethodTokenizationParameters paymentmethodtokenizationparameters, ArrayList arraylist1)
    {
        mVersionCode = i;
        zzaWj = s;
        zzaXe = flag;
        zzaXf = flag1;
        zzaXg = flag2;
        zzaXh = s1;
        zzaWc = s2;
        zzaXi = s3;
        zzaWt = cart;
        zzaXj = flag3;
        zzaXk = flag4;
        zzaXl = acountryspecification;
        zzaXm = flag5;
        zzaXn = flag6;
        zzaXo = arraylist;
        zzaXp = paymentmethodtokenizationparameters;
        zzaXq = arraylist1;
    }

    public static Builder newBuilder()
    {
        MaskedWalletRequest maskedwalletrequest = new MaskedWalletRequest();
        maskedwalletrequest.getClass();
        return maskedwalletrequest. new Builder();
    }

    public boolean allowDebitCard()
    {
        return zzaXn;
    }

    public boolean allowPrepaidCard()
    {
        return zzaXm;
    }

    public int describeContents()
    {
        return 0;
    }

    public ArrayList getAllowedCardNetworks()
    {
        return zzaXq;
    }

    public ArrayList getAllowedCountrySpecificationsForShipping()
    {
        return zzaXo;
    }

    public com.google.android.gms.wallet.CountrySpecification[] getAllowedShippingCountrySpecifications()
    {
        return zzaXl;
    }

    public Cart getCart()
    {
        return zzaWt;
    }

    public String getCurrencyCode()
    {
        return zzaWc;
    }

    public String getEstimatedTotalPrice()
    {
        return zzaXh;
    }

    public String getMerchantName()
    {
        return zzaXi;
    }

    public String getMerchantTransactionId()
    {
        return zzaWj;
    }

    public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters()
    {
        return zzaXp;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public boolean isBillingAgreement()
    {
        return zzaXk;
    }

    public boolean isPhoneNumberRequired()
    {
        return zzaXe;
    }

    public boolean isShippingAddressRequired()
    {
        return zzaXf;
    }

    public boolean useMinimalBillingAddress()
    {
        return zzaXg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzl.zza(this, parcel, i);
    }

}

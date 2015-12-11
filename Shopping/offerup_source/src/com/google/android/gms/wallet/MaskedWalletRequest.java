// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.wallet:
//            zzl, Cart, CountrySpecification, PaymentMethodTokenizationParameters

public final class MaskedWalletRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzl();
    private final int mVersionCode;
    Cart zzbcA;
    String zzbcj;
    String zzbcq;
    boolean zzbdl;
    boolean zzbdm;
    boolean zzbdn;
    String zzbdo;
    String zzbdp;
    boolean zzbdq;
    boolean zzbdr;
    com.google.android.gms.wallet.CountrySpecification zzbds[];
    boolean zzbdt;
    boolean zzbdu;
    ArrayList zzbdv;
    PaymentMethodTokenizationParameters zzbdw;
    ArrayList zzbdx;

    MaskedWalletRequest()
    {
        mVersionCode = 3;
        zzbdt = true;
        zzbdu = true;
    }

    MaskedWalletRequest(int i, String s, boolean flag, boolean flag1, boolean flag2, String s1, String s2, 
            String s3, Cart cart, boolean flag3, boolean flag4, CountrySpecification acountryspecification[], boolean flag5, boolean flag6, 
            ArrayList arraylist, PaymentMethodTokenizationParameters paymentmethodtokenizationparameters, ArrayList arraylist1)
    {
        mVersionCode = i;
        zzbcq = s;
        zzbdl = flag;
        zzbdm = flag1;
        zzbdn = flag2;
        zzbdo = s1;
        zzbcj = s2;
        zzbdp = s3;
        zzbcA = cart;
        zzbdq = flag3;
        zzbdr = flag4;
        zzbds = acountryspecification;
        zzbdt = flag5;
        zzbdu = flag6;
        zzbdv = arraylist;
        zzbdw = paymentmethodtokenizationparameters;
        zzbdx = arraylist1;
    }

    public static Builder newBuilder()
    {
        MaskedWalletRequest maskedwalletrequest = new MaskedWalletRequest();
        maskedwalletrequest.getClass();
        return maskedwalletrequest. new Builder(null);
    }

    public final boolean allowDebitCard()
    {
        return zzbdu;
    }

    public final boolean allowPrepaidCard()
    {
        return zzbdt;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final ArrayList getAllowedCardNetworks()
    {
        return zzbdx;
    }

    public final ArrayList getAllowedCountrySpecificationsForShipping()
    {
        return zzbdv;
    }

    public final com.google.android.gms.wallet.CountrySpecification[] getAllowedShippingCountrySpecifications()
    {
        return zzbds;
    }

    public final Cart getCart()
    {
        return zzbcA;
    }

    public final String getCurrencyCode()
    {
        return zzbcj;
    }

    public final String getEstimatedTotalPrice()
    {
        return zzbdo;
    }

    public final String getMerchantName()
    {
        return zzbdp;
    }

    public final String getMerchantTransactionId()
    {
        return zzbcq;
    }

    public final PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters()
    {
        return zzbdw;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final boolean isBillingAgreement()
    {
        return zzbdr;
    }

    public final boolean isPhoneNumberRequired()
    {
        return zzbdl;
    }

    public final boolean isShippingAddressRequired()
    {
        return zzbdm;
    }

    public final boolean useMinimalBillingAddress()
    {
        return zzbdn;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzl.zza(this, parcel, i);
    }


    private class Builder
    {

        final MaskedWalletRequest zzbdy;

        public final Builder addAllowedCardNetwork(int i)
        {
            if (zzbdy.zzbdx == null)
            {
                zzbdy.zzbdx = new ArrayList();
            }
            zzbdy.zzbdx.add(Integer.valueOf(i));
            return this;
        }

        public final Builder addAllowedCardNetworks(Collection collection)
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

        public final Builder addAllowedCountrySpecificationForShipping(CountrySpecification countryspecification)
        {
            if (zzbdy.zzbdv == null)
            {
                zzbdy.zzbdv = new ArrayList();
            }
            zzbdy.zzbdv.add(countryspecification);
            return this;
        }

        public final Builder addAllowedCountrySpecificationsForShipping(Collection collection)
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

        public final Builder setAllowDebitCard(boolean flag)
        {
            zzbdy.zzbdu = flag;
            return this;
        }

        public final Builder setAllowPrepaidCard(boolean flag)
        {
            zzbdy.zzbdt = flag;
            return this;
        }

        public final Builder setCart(Cart cart)
        {
            zzbdy.zzbcA = cart;
            return this;
        }

        public final Builder setCurrencyCode(String s)
        {
            zzbdy.zzbcj = s;
            return this;
        }

        public final Builder setEstimatedTotalPrice(String s)
        {
            zzbdy.zzbdo = s;
            return this;
        }

        public final Builder setIsBillingAgreement(boolean flag)
        {
            zzbdy.zzbdr = flag;
            return this;
        }

        public final Builder setMerchantName(String s)
        {
            zzbdy.zzbdp = s;
            return this;
        }

        public final Builder setMerchantTransactionId(String s)
        {
            zzbdy.zzbcq = s;
            return this;
        }

        public final Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentmethodtokenizationparameters)
        {
            zzbdy.zzbdw = paymentmethodtokenizationparameters;
            return this;
        }

        public final Builder setPhoneNumberRequired(boolean flag)
        {
            zzbdy.zzbdl = flag;
            return this;
        }

        public final Builder setShippingAddressRequired(boolean flag)
        {
            zzbdy.zzbdm = flag;
            return this;
        }

        public final Builder setUseMinimalBillingAddress(boolean flag)
        {
            zzbdy.zzbdn = flag;
            return this;
        }

        private Builder()
        {
            zzbdy = MaskedWalletRequest.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }

}

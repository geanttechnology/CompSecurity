// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            i, CountrySpecification, Cart

public final class MaskedWalletRequest
    implements SafeParcelable
{
    public final class Builder
    {

        final MaskedWalletRequest GU;

        public MaskedWalletRequest build()
        {
            return GU;
        }

        public Builder setAllowDebitCard(boolean flag)
        {
            GU.GT = flag;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean flag)
        {
            GU.GS = flag;
            return this;
        }

        public Builder setAllowedShippingCountrySpecifications(CountrySpecification acountryspecification[])
        {
            GU.GR = acountryspecification;
            return this;
        }

        public Builder setCart(Cart cart)
        {
            GU.Gu = cart;
            return this;
        }

        public Builder setCurrencyCode(String s)
        {
            GU.Gk = s;
            return this;
        }

        public Builder setEstimatedTotalPrice(String s)
        {
            GU.GN = s;
            return this;
        }

        public Builder setIsBillingAgreement(boolean flag)
        {
            GU.GQ = flag;
            return this;
        }

        public Builder setMerchantName(String s)
        {
            GU.GO = s;
            return this;
        }

        public Builder setMerchantTransactionId(String s)
        {
            GU.Go = s;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean flag)
        {
            GU.GK = flag;
            return this;
        }

        public Builder setShippingAddressRequired(boolean flag)
        {
            GU.GL = flag;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean flag)
        {
            GU.GP = flag;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean flag)
        {
            GU.GM = flag;
            return this;
        }

        private Builder()
        {
            GU = MaskedWalletRequest.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new i();
    boolean GK;
    boolean GL;
    boolean GM;
    String GN;
    String GO;
    boolean GP;
    boolean GQ;
    CountrySpecification GR[];
    boolean GS;
    boolean GT;
    String Gk;
    String Go;
    Cart Gu;
    private final int kg;

    MaskedWalletRequest()
    {
        kg = 3;
        GS = true;
        GT = true;
    }

    MaskedWalletRequest(int j, String s, boolean flag, boolean flag1, boolean flag2, String s1, String s2, 
            String s3, Cart cart, boolean flag3, boolean flag4, CountrySpecification acountryspecification[], boolean flag5, boolean flag6)
    {
        kg = j;
        Go = s;
        GK = flag;
        GL = flag1;
        GM = flag2;
        GN = s1;
        Gk = s2;
        GO = s3;
        Gu = cart;
        GP = flag3;
        GQ = flag4;
        GR = acountryspecification;
        GS = flag5;
        GT = flag6;
    }

    public static Builder newBuilder()
    {
        MaskedWalletRequest maskedwalletrequest = new MaskedWalletRequest();
        maskedwalletrequest.getClass();
        return maskedwalletrequest. new Builder();
    }

    public boolean allowDebitCard()
    {
        return GT;
    }

    public boolean allowPrepaidCard()
    {
        return GS;
    }

    public int describeContents()
    {
        return 0;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications()
    {
        return GR;
    }

    public Cart getCart()
    {
        return Gu;
    }

    public String getCurrencyCode()
    {
        return Gk;
    }

    public String getEstimatedTotalPrice()
    {
        return GN;
    }

    public String getMerchantName()
    {
        return GO;
    }

    public String getMerchantTransactionId()
    {
        return Go;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public boolean isBillingAgreement()
    {
        return GQ;
    }

    public boolean isPhoneNumberRequired()
    {
        return GK;
    }

    public boolean isShippingAddressRequired()
    {
        return GL;
    }

    public boolean shouldRetrieveWalletObjects()
    {
        return GP;
    }

    public boolean useMinimalBillingAddress()
    {
        return GM;
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        i.a(this, parcel, j);
    }

}

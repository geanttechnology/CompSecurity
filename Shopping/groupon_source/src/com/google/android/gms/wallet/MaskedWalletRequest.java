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
    public final class Builder
    {

        final MaskedWalletRequest zzaRv;

        public MaskedWalletRequest build()
        {
            return zzaRv;
        }

        public Builder setCart(Cart cart)
        {
            zzaRv.zzaQx = cart;
            return this;
        }

        public Builder setCurrencyCode(String s)
        {
            zzaRv.zzaQg = s;
            return this;
        }

        public Builder setEstimatedTotalPrice(String s)
        {
            zzaRv.zzaRl = s;
            return this;
        }

        public Builder setMerchantName(String s)
        {
            zzaRv.zzaRm = s;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean flag)
        {
            zzaRv.zzaRi = flag;
            return this;
        }

        public Builder setShippingAddressRequired(boolean flag)
        {
            zzaRv.zzaRj = flag;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean flag)
        {
            zzaRv.zzaRn = flag;
            return this;
        }

        private Builder()
        {
            zzaRv = MaskedWalletRequest.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new zzl();
    private final int zzCY;
    String zzaQg;
    String zzaQn;
    Cart zzaQx;
    boolean zzaRi;
    boolean zzaRj;
    boolean zzaRk;
    String zzaRl;
    String zzaRm;
    boolean zzaRn;
    boolean zzaRo;
    CountrySpecification zzaRp[];
    boolean zzaRq;
    boolean zzaRr;
    ArrayList zzaRs;
    PaymentMethodTokenizationParameters zzaRt;
    ArrayList zzaRu;

    MaskedWalletRequest()
    {
        zzCY = 3;
        zzaRq = true;
        zzaRr = true;
    }

    MaskedWalletRequest(int i, String s, boolean flag, boolean flag1, boolean flag2, String s1, String s2, 
            String s3, Cart cart, boolean flag3, boolean flag4, CountrySpecification acountryspecification[], boolean flag5, boolean flag6, 
            ArrayList arraylist, PaymentMethodTokenizationParameters paymentmethodtokenizationparameters, ArrayList arraylist1)
    {
        zzCY = i;
        zzaQn = s;
        zzaRi = flag;
        zzaRj = flag1;
        zzaRk = flag2;
        zzaRl = s1;
        zzaQg = s2;
        zzaRm = s3;
        zzaQx = cart;
        zzaRn = flag3;
        zzaRo = flag4;
        zzaRp = acountryspecification;
        zzaRq = flag5;
        zzaRr = flag6;
        zzaRs = arraylist;
        zzaRt = paymentmethodtokenizationparameters;
        zzaRu = arraylist1;
    }

    public static Builder newBuilder()
    {
        MaskedWalletRequest maskedwalletrequest = new MaskedWalletRequest();
        maskedwalletrequest.getClass();
        return maskedwalletrequest. new Builder();
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return zzCY;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzl.zza(this, parcel, i);
    }

}

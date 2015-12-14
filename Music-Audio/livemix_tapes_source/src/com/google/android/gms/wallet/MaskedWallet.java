// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.identity.intents.model.UserAddress;

// Referenced classes of package com.google.android.gms.wallet:
//            zzk, Address, InstrumentInfo, LoyaltyWalletObject, 
//            OfferWalletObject

public final class MaskedWallet
    implements SafeParcelable
{
    public final class Builder
    {

        final MaskedWallet zzaXd;

        public MaskedWallet build()
        {
            return zzaXd;
        }

        public Builder setBillingAddress(Address address)
        {
            zzaXd.zzaWm = address;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress useraddress)
        {
            zzaXd.zzaWp = useraddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress useraddress)
        {
            zzaXd.zzaWq = useraddress;
            return this;
        }

        public Builder setEmail(String s)
        {
            zzaXd.zzaWl = s;
            return this;
        }

        public Builder setGoogleTransactionId(String s)
        {
            zzaXd.zzaWi = s;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo ainstrumentinfo[])
        {
            zzaXd.zzaWr = ainstrumentinfo;
            return this;
        }

        public Builder setMerchantTransactionId(String s)
        {
            zzaXd.zzaWj = s;
            return this;
        }

        public Builder setPaymentDescriptions(String as[])
        {
            zzaXd.zzaWo = as;
            return this;
        }

        public Builder setShippingAddress(Address address)
        {
            zzaXd.zzaWn = address;
            return this;
        }

        public Builder zza(LoyaltyWalletObject aloyaltywalletobject[])
        {
            zzaXd.zzaXb = aloyaltywalletobject;
            return this;
        }

        public Builder zza(OfferWalletObject aofferwalletobject[])
        {
            zzaXd.zzaXc = aofferwalletobject;
            return this;
        }

        private Builder()
        {
            zzaXd = MaskedWallet.this;
            super();
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    private final int mVersionCode;
    String zzaWi;
    String zzaWj;
    String zzaWl;
    Address zzaWm;
    Address zzaWn;
    String zzaWo[];
    UserAddress zzaWp;
    UserAddress zzaWq;
    InstrumentInfo zzaWr[];
    LoyaltyWalletObject zzaXb[];
    OfferWalletObject zzaXc[];

    private MaskedWallet()
    {
        mVersionCode = 2;
    }

    MaskedWallet(int i, String s, String s1, String as[], String s2, Address address, Address address1, 
            LoyaltyWalletObject aloyaltywalletobject[], OfferWalletObject aofferwalletobject[], UserAddress useraddress, UserAddress useraddress1, InstrumentInfo ainstrumentinfo[])
    {
        mVersionCode = i;
        zzaWi = s;
        zzaWj = s1;
        zzaWo = as;
        zzaWl = s2;
        zzaWm = address;
        zzaWn = address1;
        zzaXb = aloyaltywalletobject;
        zzaXc = aofferwalletobject;
        zzaWp = useraddress;
        zzaWq = useraddress1;
        zzaWr = ainstrumentinfo;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedwallet)
    {
        zzx.zzv(maskedwallet);
        return zzCh().setGoogleTransactionId(maskedwallet.getGoogleTransactionId()).setMerchantTransactionId(maskedwallet.getMerchantTransactionId()).setPaymentDescriptions(maskedwallet.getPaymentDescriptions()).setInstrumentInfos(maskedwallet.getInstrumentInfos()).setEmail(maskedwallet.getEmail()).zza(maskedwallet.zzCi()).zza(maskedwallet.zzCj()).setBuyerBillingAddress(maskedwallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedwallet.getBuyerShippingAddress());
    }

    public static Builder zzCh()
    {
        MaskedWallet maskedwallet = new MaskedWallet();
        maskedwallet.getClass();
        return maskedwallet. new Builder();
    }

    public int describeContents()
    {
        return 0;
    }

    public Address getBillingAddress()
    {
        return zzaWm;
    }

    public UserAddress getBuyerBillingAddress()
    {
        return zzaWp;
    }

    public UserAddress getBuyerShippingAddress()
    {
        return zzaWq;
    }

    public String getEmail()
    {
        return zzaWl;
    }

    public String getGoogleTransactionId()
    {
        return zzaWi;
    }

    public InstrumentInfo[] getInstrumentInfos()
    {
        return zzaWr;
    }

    public String getMerchantTransactionId()
    {
        return zzaWj;
    }

    public String[] getPaymentDescriptions()
    {
        return zzaWo;
    }

    public Address getShippingAddress()
    {
        return zzaWn;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

    public LoyaltyWalletObject[] zzCi()
    {
        return zzaXb;
    }

    public OfferWalletObject[] zzCj()
    {
        return zzaXc;
    }

}

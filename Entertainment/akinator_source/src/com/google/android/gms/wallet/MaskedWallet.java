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

        final MaskedWallet zzbdk;

        public MaskedWallet build()
        {
            return zzbdk;
        }

        public Builder setBillingAddress(Address address)
        {
            zzbdk.zzbct = address;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress useraddress)
        {
            zzbdk.zzbcw = useraddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress useraddress)
        {
            zzbdk.zzbcx = useraddress;
            return this;
        }

        public Builder setEmail(String s)
        {
            zzbdk.zzbcs = s;
            return this;
        }

        public Builder setGoogleTransactionId(String s)
        {
            zzbdk.zzbcp = s;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo ainstrumentinfo[])
        {
            zzbdk.zzbcy = ainstrumentinfo;
            return this;
        }

        public Builder setMerchantTransactionId(String s)
        {
            zzbdk.zzbcq = s;
            return this;
        }

        public Builder setPaymentDescriptions(String as[])
        {
            zzbdk.zzbcv = as;
            return this;
        }

        public Builder setShippingAddress(Address address)
        {
            zzbdk.zzbcu = address;
            return this;
        }

        public Builder zza(LoyaltyWalletObject aloyaltywalletobject[])
        {
            zzbdk.zzbdi = aloyaltywalletobject;
            return this;
        }

        public Builder zza(OfferWalletObject aofferwalletobject[])
        {
            zzbdk.zzbdj = aofferwalletobject;
            return this;
        }

        private Builder()
        {
            zzbdk = MaskedWallet.this;
            super();
        }

        Builder(_cls1 _pcls1)
        {
            this();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    private final int mVersionCode;
    String zzbcp;
    String zzbcq;
    String zzbcs;
    Address zzbct;
    Address zzbcu;
    String zzbcv[];
    UserAddress zzbcw;
    UserAddress zzbcx;
    InstrumentInfo zzbcy[];
    LoyaltyWalletObject zzbdi[];
    OfferWalletObject zzbdj[];

    private MaskedWallet()
    {
        mVersionCode = 2;
    }

    MaskedWallet(int i, String s, String s1, String as[], String s2, Address address, Address address1, 
            LoyaltyWalletObject aloyaltywalletobject[], OfferWalletObject aofferwalletobject[], UserAddress useraddress, UserAddress useraddress1, InstrumentInfo ainstrumentinfo[])
    {
        mVersionCode = i;
        zzbcp = s;
        zzbcq = s1;
        zzbcv = as;
        zzbcs = s2;
        zzbct = address;
        zzbcu = address1;
        zzbdi = aloyaltywalletobject;
        zzbdj = aofferwalletobject;
        zzbcw = useraddress;
        zzbcx = useraddress1;
        zzbcy = ainstrumentinfo;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedwallet)
    {
        zzx.zzw(maskedwallet);
        return zzEC().setGoogleTransactionId(maskedwallet.getGoogleTransactionId()).setMerchantTransactionId(maskedwallet.getMerchantTransactionId()).setPaymentDescriptions(maskedwallet.getPaymentDescriptions()).setInstrumentInfos(maskedwallet.getInstrumentInfos()).setEmail(maskedwallet.getEmail()).zza(maskedwallet.zzED()).zza(maskedwallet.zzEE()).setBuyerBillingAddress(maskedwallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedwallet.getBuyerShippingAddress());
    }

    public static Builder zzEC()
    {
        MaskedWallet maskedwallet = new MaskedWallet();
        maskedwallet.getClass();
        return maskedwallet. new Builder(null);
    }

    public int describeContents()
    {
        return 0;
    }

    public Address getBillingAddress()
    {
        return zzbct;
    }

    public UserAddress getBuyerBillingAddress()
    {
        return zzbcw;
    }

    public UserAddress getBuyerShippingAddress()
    {
        return zzbcx;
    }

    public String getEmail()
    {
        return zzbcs;
    }

    public String getGoogleTransactionId()
    {
        return zzbcp;
    }

    public InstrumentInfo[] getInstrumentInfos()
    {
        return zzbcy;
    }

    public String getMerchantTransactionId()
    {
        return zzbcq;
    }

    public String[] getPaymentDescriptions()
    {
        return zzbcv;
    }

    public Address getShippingAddress()
    {
        return zzbcu;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

    public LoyaltyWalletObject[] zzED()
    {
        return zzbdi;
    }

    public OfferWalletObject[] zzEE()
    {
        return zzbdj;
    }

}

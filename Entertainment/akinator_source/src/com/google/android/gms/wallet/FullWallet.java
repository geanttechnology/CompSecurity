// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

// Referenced classes of package com.google.android.gms.wallet:
//            zze, ProxyCard, Address, InstrumentInfo, 
//            PaymentMethodToken

public final class FullWallet
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    private final int mVersionCode;
    String zzbcp;
    String zzbcq;
    ProxyCard zzbcr;
    String zzbcs;
    Address zzbct;
    Address zzbcu;
    String zzbcv[];
    UserAddress zzbcw;
    UserAddress zzbcx;
    InstrumentInfo zzbcy[];
    PaymentMethodToken zzbcz;

    private FullWallet()
    {
        mVersionCode = 1;
    }

    FullWallet(int i, String s, String s1, ProxyCard proxycard, String s2, Address address, Address address1, 
            String as[], UserAddress useraddress, UserAddress useraddress1, InstrumentInfo ainstrumentinfo[], PaymentMethodToken paymentmethodtoken)
    {
        mVersionCode = i;
        zzbcp = s;
        zzbcq = s1;
        zzbcr = proxycard;
        zzbcs = s2;
        zzbct = address;
        zzbcu = address1;
        zzbcv = as;
        zzbcw = useraddress;
        zzbcx = useraddress1;
        zzbcy = ainstrumentinfo;
        zzbcz = paymentmethodtoken;
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

    public PaymentMethodToken getPaymentMethodToken()
    {
        return zzbcz;
    }

    public ProxyCard getProxyCard()
    {
        return zzbcr;
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
        zze.zza(this, parcel, i);
    }

}

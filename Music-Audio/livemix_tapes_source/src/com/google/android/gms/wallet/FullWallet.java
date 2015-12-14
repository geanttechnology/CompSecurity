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
    String zzaWi;
    String zzaWj;
    ProxyCard zzaWk;
    String zzaWl;
    Address zzaWm;
    Address zzaWn;
    String zzaWo[];
    UserAddress zzaWp;
    UserAddress zzaWq;
    InstrumentInfo zzaWr[];
    PaymentMethodToken zzaWs;

    private FullWallet()
    {
        mVersionCode = 1;
    }

    FullWallet(int i, String s, String s1, ProxyCard proxycard, String s2, Address address, Address address1, 
            String as[], UserAddress useraddress, UserAddress useraddress1, InstrumentInfo ainstrumentinfo[], PaymentMethodToken paymentmethodtoken)
    {
        mVersionCode = i;
        zzaWi = s;
        zzaWj = s1;
        zzaWk = proxycard;
        zzaWl = s2;
        zzaWm = address;
        zzaWn = address1;
        zzaWo = as;
        zzaWp = useraddress;
        zzaWq = useraddress1;
        zzaWr = ainstrumentinfo;
        zzaWs = paymentmethodtoken;
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

    public PaymentMethodToken getPaymentMethodToken()
    {
        return zzaWs;
    }

    public ProxyCard getProxyCard()
    {
        return zzaWk;
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
        zze.zza(this, parcel, i);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            d, ProxyCard, Address

public final class FullWallet
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new d();
    String Gn;
    String Go;
    ProxyCard Gp;
    String Gq;
    Address Gr;
    Address Gs;
    String Gt[];
    private final int kg;

    FullWallet()
    {
        kg = 1;
    }

    FullWallet(int i, String s, String s1, ProxyCard proxycard, String s2, Address address, Address address1, 
            String as[])
    {
        kg = i;
        Gn = s;
        Go = s1;
        Gp = proxycard;
        Gq = s2;
        Gr = address;
        Gs = address1;
        Gt = as;
    }

    public int describeContents()
    {
        return 0;
    }

    public Address getBillingAddress()
    {
        return Gr;
    }

    public String getEmail()
    {
        return Gq;
    }

    public String getGoogleTransactionId()
    {
        return Gn;
    }

    public String getMerchantTransactionId()
    {
        return Go;
    }

    public String[] getPaymentDescriptions()
    {
        return Gt;
    }

    public ProxyCard getProxyCard()
    {
        return Gp;
    }

    public Address getShippingAddress()
    {
        return Gs;
    }

    public int getVersionCode()
    {
        return kg;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        d.a(this, parcel, i);
    }

}

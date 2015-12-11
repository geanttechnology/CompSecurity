// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            h, Address, LoyaltyWalletObject, OfferWalletObject

public final class MaskedWallet
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new h();
    final int a;
    String b;
    String c;
    String d[];
    String e;
    Address f;
    Address g;
    LoyaltyWalletObject h[];
    OfferWalletObject i[];

    MaskedWallet()
    {
        a = 2;
    }

    MaskedWallet(int j, String s, String s1, String as[], String s2, Address address, Address address1, 
            LoyaltyWalletObject aloyaltywalletobject[], OfferWalletObject aofferwalletobject[])
    {
        a = j;
        b = s;
        c = s1;
        d = as;
        e = s2;
        f = address;
        g = address1;
        h = aloyaltywalletobject;
        i = aofferwalletobject;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int j)
    {
        com.google.android.gms.wallet.h.a(this, parcel, j);
    }

}

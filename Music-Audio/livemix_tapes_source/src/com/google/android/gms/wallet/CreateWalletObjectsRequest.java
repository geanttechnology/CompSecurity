// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.wallet:
//            zzd, LoyaltyWalletObject, OfferWalletObject, GiftCardWalletObject

public final class CreateWalletObjectsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    private final int mVersionCode;
    LoyaltyWalletObject zzaWf;
    OfferWalletObject zzaWg;
    GiftCardWalletObject zzaWh;

    CreateWalletObjectsRequest()
    {
        mVersionCode = 3;
    }

    CreateWalletObjectsRequest(int i, LoyaltyWalletObject loyaltywalletobject, OfferWalletObject offerwalletobject, GiftCardWalletObject giftcardwalletobject)
    {
        mVersionCode = i;
        zzaWf = loyaltywalletobject;
        zzaWg = offerwalletobject;
        zzaWh = giftcardwalletobject;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

}

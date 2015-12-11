// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            BuyRequest, Person, OfferUpBoolean

final class n
    implements android.os.eator
{

    public final BuyRequest createFromParcel(Parcel parcel)
    {
        BuyRequest buyrequest = new BuyRequest();
        buyrequest.id = parcel.readInt();
        buyrequest.soldDate = parcel.readString();
        buyrequest.reviewDate = parcel.readString();
        buyrequest.requestDate = parcel.readString();
        buyrequest.offer = parcel.readString();
        buyrequest.paymentStatus = parcel.readInt();
        buyrequest.seller = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
        buyrequest.buyer = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
        buyrequest.requestStatus = parcel.readInt();
        buyrequest.paymentReleasePin = parcel.readInt();
        buyrequest.requirePayments = (new OfferUpBoolean(parcel.readInt())).value;
        return buyrequest;
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final BuyRequest[] newArray(int i)
    {
        return new BuyRequest[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    n()
    {
    }
}

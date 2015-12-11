// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;

// Referenced classes of package com.offerup.android.dto:
//            CreditCard, OfferUpBoolean

final class n
    implements android.os.eator
{

    public final CreditCard createFromParcel(Parcel parcel)
    {
        CreditCard creditcard = new CreditCard();
        creditcard.expirationMonth = parcel.readString();
        creditcard.expirationYear = parcel.readString();
        creditcard.cardType = parcel.readString();
        creditcard.displayName = parcel.readString();
        creditcard.lastFour = parcel.readString();
        creditcard.expired = (new OfferUpBoolean(parcel.readInt())).value;
        return creditcard;
    }

    public final volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public final CreditCard[] newArray(int i)
    {
        return new CreditCard[i];
    }

    public final volatile Object[] newArray(int i)
    {
        return newArray(i);
    }

    n()
    {
    }
}

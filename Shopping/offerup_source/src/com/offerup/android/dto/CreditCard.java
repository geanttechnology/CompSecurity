// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class CreditCard
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    String cardType;
    String displayName;
    String expirationMonth;
    String expirationYear;
    boolean expired;
    String lastFour;

    public CreditCard()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCardType()
    {
        return cardType;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getExpirationMonth()
    {
        return expirationMonth;
    }

    public String getExpirationYear()
    {
        return expirationYear;
    }

    public String getLastFour()
    {
        return lastFour;
    }

    public boolean isExpired()
    {
        return expired;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(expirationMonth);
        parcel.writeString(expirationYear);
        parcel.writeString(cardType);
        parcel.writeString(displayName);
        parcel.writeString(lastFour);
        if (expired)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
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

        _cls1()
        {
        }
    }

}

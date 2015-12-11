// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.model.guest.interfaces.AppliedGiftCard;
import java.math.BigDecimal;

public class TGTAppliedGiftCard
    implements AppliedGiftCard
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAppliedGiftCard a(Parcel parcel)
        {
            return new TGTAppliedGiftCard(parcel);
        }

        public TGTAppliedGiftCard[] a(int i)
        {
            return new TGTAppliedGiftCard[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private BigDecimal mAppliedAmount;
    private String mCardLast4Digits;

    TGTAppliedGiftCard()
    {
    }

    private TGTAppliedGiftCard(Parcel parcel)
    {
        mAppliedAmount = (BigDecimal)parcel.readSerializable();
        mCardLast4Digits = parcel.readString();
    }


    public BigDecimal a()
    {
        return mAppliedAmount;
    }

    public void a(String s)
    {
        mCardLast4Digits = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mAppliedAmount = bigdecimal;
    }

    public String b()
    {
        return mCardLast4Digits;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mAppliedAmount);
        parcel.writeString(mCardLast4Digits);
    }

}

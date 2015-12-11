// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.AppliedGiftCard;
import com.target.mothership.util.c;
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
    private BigDecimal mPaymentInstructionAmount;
    private String mPaymentInstructionId;
    private BigDecimal mRemainingBalance;

    TGTAppliedGiftCard()
    {
    }

    private TGTAppliedGiftCard(Parcel parcel)
    {
        mPaymentInstructionId = parcel.readString();
        mPaymentInstructionAmount = (BigDecimal)parcel.readSerializable();
        mRemainingBalance = (BigDecimal)parcel.readSerializable();
    }


    public void a(String s)
    {
        mPaymentInstructionId = s;
    }

    public void b(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mPaymentInstructionAmount = s;
    }

    public void c(String s)
    {
        if (s != null)
        {
            s = new BigDecimal(s);
        } else
        {
            s = c.ZERO;
        }
        mRemainingBalance = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mPaymentInstructionId);
        parcel.writeSerializable(mPaymentInstructionAmount);
        parcel.writeSerializable(mRemainingBalance);
    }

}

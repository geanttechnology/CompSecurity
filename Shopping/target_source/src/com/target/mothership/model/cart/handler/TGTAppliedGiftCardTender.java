// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.common.AppliedGiftCardTender;
import com.target.mothership.model.guest.handler.TGTPaymentTender;
import java.math.BigDecimal;
import java.util.Currency;

public class TGTAppliedGiftCardTender extends TGTPaymentTender
    implements AppliedGiftCardTender
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAppliedGiftCardTender a(Parcel parcel)
        {
            return new TGTAppliedGiftCardTender(parcel);
        }

        public TGTAppliedGiftCardTender[] a(int i)
        {
            return new TGTAppliedGiftCardTender[i];
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
    private BigDecimal mBalance;
    private Currency mCurrency;
    private String mInstructionId;
    private String mLast4CardNumber;

    TGTAppliedGiftCardTender()
    {
    }

    private TGTAppliedGiftCardTender(Parcel parcel)
    {
        super(parcel);
        mLast4CardNumber = parcel.readString();
        mBalance = (BigDecimal)parcel.readSerializable();
        mInstructionId = parcel.readString();
        mAppliedAmount = (BigDecimal)parcel.readSerializable();
        mCurrency = (Currency)parcel.readSerializable();
    }


    public void a(String s)
    {
        mLast4CardNumber = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mBalance = bigdecimal;
    }

    public void a(Currency currency)
    {
        mCurrency = currency;
    }

    public String b()
    {
        return mLast4CardNumber;
    }

    public void b(String s)
    {
        mInstructionId = s;
    }

    public void b(BigDecimal bigdecimal)
    {
        mAppliedAmount = bigdecimal;
    }

    public String c()
    {
        return mInstructionId;
    }

    public BigDecimal d()
    {
        return mAppliedAmount;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(mLast4CardNumber);
        parcel.writeSerializable(mBalance);
        parcel.writeString(mInstructionId);
        parcel.writeSerializable(mAppliedAmount);
        parcel.writeSerializable(mCurrency);
    }

}

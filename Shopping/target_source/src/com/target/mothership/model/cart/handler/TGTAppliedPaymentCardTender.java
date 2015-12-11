// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.model.common.TGTPaymentCardTender;
import java.math.BigDecimal;
import java.util.Currency;

public class TGTAppliedPaymentCardTender extends TGTPaymentCardTender
    implements AppliedPaymentCardTender
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAppliedPaymentCardTender a(Parcel parcel)
        {
            return new TGTAppliedPaymentCardTender(parcel);
        }

        public TGTAppliedPaymentCardTender[] a(int i)
        {
            return new TGTAppliedPaymentCardTender[i];
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
    private Currency mCurrency;
    private String mInstructionId;

    public TGTAppliedPaymentCardTender()
    {
    }

    public TGTAppliedPaymentCardTender(Parcel parcel)
    {
        super(parcel);
        mInstructionId = parcel.readString();
        mAppliedAmount = (BigDecimal)parcel.readSerializable();
        mCurrency = (Currency)parcel.readSerializable();
    }

    public void a(String s)
    {
        mInstructionId = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mAppliedAmount = bigdecimal;
    }

    public void a(Currency currency)
    {
        mCurrency = currency;
    }

    public BigDecimal b()
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
        parcel.writeString(mInstructionId);
        parcel.writeSerializable(mAppliedAmount);
        parcel.writeSerializable(mCurrency);
    }

}

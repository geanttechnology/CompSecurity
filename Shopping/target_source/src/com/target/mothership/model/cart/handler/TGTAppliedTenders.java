// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class TGTAppliedTenders
    implements AppliedTenders
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAppliedTenders a(Parcel parcel)
        {
            return new TGTAppliedTenders(parcel);
        }

        public TGTAppliedTenders[] a(int i)
        {
            return new TGTAppliedTenders[i];
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
    private List mAppliedGiftCardTenders;
    private AppliedPaymentCardTender mAppliedPaymentCardTender;
    private BigDecimal mRemainingBalance;

    TGTAppliedTenders()
    {
    }

    private TGTAppliedTenders(Parcel parcel)
    {
        mRemainingBalance = (BigDecimal)parcel.readSerializable();
        mAppliedPaymentCardTender = (AppliedPaymentCardTender)parcel.readParcelable(com/target/mothership/model/common/AppliedPaymentCardTender.getClassLoader());
        mAppliedGiftCardTenders = new ArrayList();
        parcel.readList(mAppliedGiftCardTenders, com/target/mothership/model/cart/handler/TGTAppliedTenders.getClassLoader());
    }


    public BigDecimal a()
    {
        return mRemainingBalance;
    }

    public void a(AppliedPaymentCardTender appliedpaymentcardtender)
    {
        mAppliedPaymentCardTender = appliedpaymentcardtender;
    }

    public void a(String s)
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

    public void a(List list)
    {
        mAppliedGiftCardTenders = list;
    }

    public List b()
    {
        return mAppliedGiftCardTenders;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeSerializable(mRemainingBalance);
        parcel.writeParcelable(mAppliedPaymentCardTender, i);
        parcel.writeList(mAppliedGiftCardTenders);
    }

}

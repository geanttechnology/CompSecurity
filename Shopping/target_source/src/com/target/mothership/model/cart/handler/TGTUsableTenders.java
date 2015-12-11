// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.cart.interfaces.UsableTenders;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.util.c;
import com.target.mothership.util.k;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class TGTUsableTenders
    implements UsableTenders
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTUsableTenders a(Parcel parcel)
        {
            return new TGTUsableTenders(parcel);
        }

        public TGTUsableTenders[] a(int i)
        {
            return new TGTUsableTenders[i];
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
    private String mCartOrderId;
    private String mCustomerOrderNumber;
    private List mGuestAddressList;
    private BigDecimal mRemainingBalance;
    private List mUsablePaymentCardTenders;

    TGTUsableTenders()
    {
    }

    private TGTUsableTenders(Parcel parcel)
    {
        mCustomerOrderNumber = parcel.readString();
        mCartOrderId = parcel.readString();
        mRemainingBalance = (BigDecimal)parcel.readSerializable();
        mUsablePaymentCardTenders = new ArrayList();
        parcel.readList(mUsablePaymentCardTenders, com/target/mothership/model/cart/handler/TGTUsableTenders.getClassLoader());
        mAppliedPaymentCardTender = (AppliedPaymentCardTender)parcel.readParcelable(com/target/mothership/model/common/AppliedPaymentCardTender.getClassLoader());
        mAppliedGiftCardTenders = new ArrayList();
        parcel.readList(mAppliedGiftCardTenders, com/target/mothership/model/cart/handler/TGTUsableTenders.getClassLoader());
        mGuestAddressList = new ArrayList();
        parcel.readList(mGuestAddressList, com/target/mothership/model/cart/handler/TGTUsableTenders.getClassLoader());
    }


    public List a()
    {
        return mUsablePaymentCardTenders;
    }

    public void a(AppliedPaymentCardTender appliedpaymentcardtender)
    {
        mAppliedPaymentCardTender = appliedpaymentcardtender;
    }

    public void a(String s)
    {
        mCustomerOrderNumber = s;
    }

    public void a(List list)
    {
        mUsablePaymentCardTenders = list;
    }

    public e b()
    {
        return k.a(mAppliedPaymentCardTender);
    }

    public void b(String s)
    {
        mCartOrderId = s;
    }

    public void b(List list)
    {
        mAppliedGiftCardTenders = list;
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

    public void c(List list)
    {
        mGuestAddressList = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mCustomerOrderNumber);
        parcel.writeString(mCartOrderId);
        parcel.writeSerializable(mRemainingBalance);
        parcel.writeList(mUsablePaymentCardTenders);
        parcel.writeParcelable(mAppliedPaymentCardTender, i);
        parcel.writeList(mAppliedGiftCardTenders);
        parcel.writeList(mGuestAddressList);
    }

}

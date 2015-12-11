// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import com.target.mothership.common.tender.a;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.AppliedPaymentCard;
import java.math.BigDecimal;

public class TGTAppliedPaymentCard
    implements AppliedPaymentCard
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTAppliedPaymentCard a(Parcel parcel)
        {
            return new TGTAppliedPaymentCard(parcel);
        }

        public TGTAppliedPaymentCard[] a(int i)
        {
            return new TGTAppliedPaymentCard[i];
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
    private GuestAddress mBillingAddress;
    private String mCardLast4Digits;
    private a mCardType;

    TGTAppliedPaymentCard()
    {
    }

    private TGTAppliedPaymentCard(Parcel parcel)
    {
        mBillingAddress = (GuestAddress)parcel.readParcelable(com/target/mothership/model/common/GuestAddress.getClassLoader());
        int i = parcel.readInt();
        a a1;
        if (i == -1)
        {
            a1 = null;
        } else
        {
            a1 = com.target.mothership.common.tender.a.values()[i];
        }
        mCardType = a1;
        mAppliedAmount = (BigDecimal)parcel.readSerializable();
        mCardLast4Digits = parcel.readString();
    }


    public a a()
    {
        return mCardType;
    }

    public void a(a a1)
    {
        mCardType = a1;
    }

    public void a(GuestAddress guestaddress)
    {
        mBillingAddress = guestaddress;
    }

    public void a(String s)
    {
        mCardLast4Digits = s;
    }

    public void a(BigDecimal bigdecimal)
    {
        mAppliedAmount = bigdecimal;
    }

    public BigDecimal b()
    {
        return mAppliedAmount;
    }

    public String c()
    {
        return mCardLast4Digits;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mBillingAddress, i);
        if (mCardType == null)
        {
            i = -1;
        } else
        {
            i = mCardType.ordinal();
        }
        parcel.writeInt(i);
        parcel.writeSerializable(mAppliedAmount);
        parcel.writeString(mCardLast4Digits);
    }

}

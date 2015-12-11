// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.os.Parcel;
import com.target.mothership.common.tender.a;
import com.target.mothership.model.cart.interfaces.OrderCompletionPaymentDetails;
import com.target.mothership.model.common.GuestAddress;

public class TGTOrderCompletionPaymentDetails
    implements OrderCompletionPaymentDetails
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTOrderCompletionPaymentDetails a(Parcel parcel)
        {
            return new TGTOrderCompletionPaymentDetails(parcel);
        }

        public TGTOrderCompletionPaymentDetails[] a(int i)
        {
            return new TGTOrderCompletionPaymentDetails[i];
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
    private GuestAddress mBillingAddress;
    private String mCardNumber;
    private a mCardType;

    TGTOrderCompletionPaymentDetails()
    {
    }

    private TGTOrderCompletionPaymentDetails(Parcel parcel)
    {
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
        mCardNumber = parcel.readString();
        mBillingAddress = (GuestAddress)parcel.readParcelable(com/target/mothership/model/common/GuestAddress.getClassLoader());
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
        mCardNumber = s;
    }

    public GuestAddress b()
    {
        return mBillingAddress;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        int j;
        if (mCardType == null)
        {
            j = -1;
        } else
        {
            j = mCardType.ordinal();
        }
        parcel.writeInt(j);
        parcel.writeString(mCardNumber);
        parcel.writeParcelable(mBillingAddress, i);
    }

}

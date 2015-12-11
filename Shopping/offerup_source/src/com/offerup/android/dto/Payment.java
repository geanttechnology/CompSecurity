// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import b.a.a;

// Referenced classes of package com.offerup.android.dto:
//            Order, PaymentMethod

public class Payment
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    String amount;
    long id;
    String offerupCommission;
    Order order;
    a paymentDate;
    PaymentMethod paymentMethod;
    String sellerPayout;
    String transactionNumber;

    public Payment()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAmount()
    {
        return amount;
    }

    public long getId()
    {
        return id;
    }

    public String getOfferupCommission()
    {
        return offerupCommission;
    }

    public Order getOrder()
    {
        return order;
    }

    public a getPaymentDate()
    {
        return paymentDate;
    }

    public PaymentMethod getPaymentMethod()
    {
        return paymentMethod;
    }

    public String getSellerPayout()
    {
        return sellerPayout;
    }

    public String getTransactionNumber()
    {
        return transactionNumber;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(id);
        parcel.writeString(amount);
        parcel.writeSerializable(paymentDate);
        parcel.writeParcelable(paymentMethod, i);
        parcel.writeString(transactionNumber);
        parcel.writeParcelable(order, i);
        parcel.writeString(sellerPayout);
        parcel.writeString(offerupCommission);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Payment createFromParcel(Parcel parcel)
        {
            Payment payment = new Payment();
            payment.id = parcel.readLong();
            payment.amount = parcel.readString();
            payment.paymentDate = (a)parcel.readSerializable();
            payment.paymentMethod = (PaymentMethod)parcel.readParcelable(com/offerup/android/dto/PaymentMethod.getClassLoader());
            payment.transactionNumber = parcel.readString();
            payment.order = (Order)parcel.readParcelable(com/offerup/android/dto/Order.getClassLoader());
            payment.sellerPayout = parcel.readString();
            payment.offerupCommission = parcel.readString();
            return payment;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Payment[] newArray(int i)
        {
            return new Payment[i];
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

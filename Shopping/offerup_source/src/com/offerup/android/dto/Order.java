// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import b.a.a;

// Referenced classes of package com.offerup.android.dto:
//            Person, Item

public class Order
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    Person buyer;
    String finalPrice;
    long id;
    Item item;
    String offer;
    a orderCreated;
    int paymentStatus;
    a requestDate;
    int requestStatus;
    a reviewDate;
    Person seller;
    a soldDate;

    public Order()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public Person getBuyer()
    {
        return buyer;
    }

    public String getFinalPrice()
    {
        return finalPrice;
    }

    public long getId()
    {
        return id;
    }

    public Item getItem()
    {
        return item;
    }

    public String getOffer()
    {
        return offer;
    }

    public a getOrderCreated()
    {
        return orderCreated;
    }

    public int getPaymentStatus()
    {
        return paymentStatus;
    }

    public a getRequestDate()
    {
        return requestDate;
    }

    public int getRequestStatus()
    {
        return requestStatus;
    }

    public a getReviewDate()
    {
        return reviewDate;
    }

    public Person getSeller()
    {
        return seller;
    }

    public a getSoldDate()
    {
        return soldDate;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(id);
        parcel.writeParcelable(buyer, i);
        parcel.writeParcelable(item, i);
        parcel.writeString(offer);
        parcel.writeString(finalPrice);
        parcel.writeInt(paymentStatus);
        parcel.writeSerializable(requestDate);
        parcel.writeInt(requestStatus);
        parcel.writeSerializable(reviewDate);
        parcel.writeParcelable(seller, i);
        parcel.writeSerializable(soldDate);
        parcel.writeSerializable(orderCreated);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Order createFromParcel(Parcel parcel)
        {
            Order order = new Order();
            order.id = parcel.readLong();
            order.buyer = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
            order.item = (Item)parcel.readParcelable(com/offerup/android/dto/Item.getClassLoader());
            order.offer = parcel.readString();
            order.finalPrice = parcel.readString();
            order.paymentStatus = parcel.readInt();
            order.requestDate = (a)parcel.readSerializable();
            order.requestStatus = parcel.readInt();
            order.reviewDate = (a)parcel.readSerializable();
            order.seller = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
            order.soldDate = (a)parcel.readSerializable();
            order.orderCreated = (a)parcel.readSerializable();
            return order;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Order[] newArray(int i)
        {
            return new Order[i];
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.dto:
//            Person

public class BuyRequest
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    Person buyer;
    long id;
    String offer;
    int paymentReleasePin;
    int paymentStatus;
    String requestDate;
    int requestStatus;
    boolean requirePayments;
    String reviewDate;
    Person seller;
    String soldDate;

    public BuyRequest()
    {
        paymentStatus = -1;
        requestStatus = -1;
    }

    public int describeContents()
    {
        return 0;
    }

    public Person getBuyer()
    {
        return buyer;
    }

    public long getId()
    {
        return id;
    }

    public String getOffer()
    {
        if (StringUtils.isNotEmpty(offer) && offer.contains(".00"))
        {
            return offer.substring(0, offer.lastIndexOf(".00"));
        } else
        {
            return offer;
        }
    }

    public int getPaymentReleasePin()
    {
        return paymentReleasePin;
    }

    public int getPaymentStatus()
    {
        return paymentStatus;
    }

    public String getRequestDate()
    {
        return requestDate;
    }

    public int getRequestStatus()
    {
        return requestStatus;
    }

    public String getReviewDate()
    {
        return reviewDate;
    }

    public Person getSeller()
    {
        return seller;
    }

    public String getSoldDate()
    {
        return soldDate;
    }

    public boolean isRequirePayments()
    {
        return requirePayments;
    }

    public void setOffer(String s)
    {
        offer = s;
    }

    public void setPaymentStatus(int i)
    {
        paymentStatus = i;
    }

    public void setRequestDate(String s)
    {
        requestDate = s;
    }

    public void setReviewDate(String s)
    {
        reviewDate = s;
    }

    public void setSeller(Person person)
    {
        seller = person;
    }

    public void setSoldDate(String s)
    {
        soldDate = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(id);
        parcel.writeString(soldDate);
        parcel.writeString(reviewDate);
        parcel.writeString(requestDate);
        parcel.writeString(offer);
        parcel.writeInt(paymentStatus);
        parcel.writeParcelable(seller, i);
        parcel.writeParcelable(buyer, i);
        parcel.writeInt(requestStatus);
        parcel.writeInt(paymentReleasePin);
        if (requirePayments)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final BuyRequest createFromParcel(Parcel parcel)
        {
            BuyRequest buyrequest = new BuyRequest();
            buyrequest.id = parcel.readInt();
            buyrequest.soldDate = parcel.readString();
            buyrequest.reviewDate = parcel.readString();
            buyrequest.requestDate = parcel.readString();
            buyrequest.offer = parcel.readString();
            buyrequest.paymentStatus = parcel.readInt();
            buyrequest.seller = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
            buyrequest.buyer = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
            buyrequest.requestStatus = parcel.readInt();
            buyrequest.paymentReleasePin = parcel.readInt();
            buyrequest.requirePayments = (new OfferUpBoolean(parcel.readInt())).value;
            return buyrequest;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final BuyRequest[] newArray(int i)
        {
            return new BuyRequest[i];
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

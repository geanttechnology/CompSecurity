// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            CurrencyAmount, Address

public class BestOffer
    implements Parcelable
{
    public static final class BestOfferStatus
    {

        public static final String ACCEPTED = "Accepted";
        public static final String ACTIVE = "Active";
        public static final String ADMIN_ENDED = "AdminEnded";
        public static final String ALL = "All";
        public static final String COUNTERED = "Countered";
        public static final String DECLINED = "Declined";
        public static final String EXPIRED = "Expired";
        public static final String PENDING = "Pending";
        public static final String RETRACTED = "Retracted";

        public BestOfferStatus()
        {
        }
    }

    public static final class BestOfferType
    {

        public static final String BUYER_BEST_OFFER = "BuyerBestOffer";
        public static final String BUYER_COUNTER_OFFER = "BuyerCounterOffer";
        public static final String SELLER_COUNTER_OFFER = "SellerCounterOffer";

        public BestOfferType()
        {
        }
    }


    public static final int ALLOWED_OFFERS_PER_ITEM = 3;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public BestOffer createFromParcel(Parcel parcel)
        {
            return new BestOffer(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public BestOffer[] newArray(int i)
        {
            return new BestOffer[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Address buyerAddress;
    public String buyerFeedbackScore;
    public String buyerId;
    public String buyerMessage;
    public String codeType;
    public CurrencyAmount currentOffer;
    public Date expirationDate;
    public String id;
    public int quantity;
    public String sellerMessage;
    public String status;

    public BestOffer()
    {
    }

    public BestOffer(Parcel parcel)
    {
        Object obj = getClass().getClassLoader();
        id = parcel.readString();
        buyerId = parcel.readString();
        buyerFeedbackScore = parcel.readString();
        buyerMessage = parcel.readString();
        sellerMessage = parcel.readString();
        quantity = parcel.readInt();
        currentOffer = (CurrencyAmount)parcel.readParcelable(((ClassLoader) (obj)));
        long l = parcel.readLong();
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = new Date(l);
        }
        expirationDate = ((Date) (obj));
        codeType = parcel.readString();
        status = parcel.readString();
        if (parcel.readInt() == 1)
        {
            buyerAddress = (Address)Address.CREATOR.createFromParcel(parcel);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Date submissionDate()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expirationDate);
        calendar.add(5, -2);
        return calendar.getTime();
    }

    public long timeLeft()
    {
        long l = EbayResponse.currentHostTime();
        if (expirationDate != null)
        {
            return expirationDate.getTime() - l;
        } else
        {
            return 0L;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(buyerId);
        parcel.writeString(buyerFeedbackScore);
        parcel.writeString(buyerMessage);
        parcel.writeString(sellerMessage);
        parcel.writeInt(quantity);
        parcel.writeParcelable(currentOffer, i);
        long l;
        if (expirationDate == null)
        {
            l = -1L;
        } else
        {
            l = expirationDate.getTime();
        }
        parcel.writeLong(l);
        parcel.writeString(codeType);
        parcel.writeString(status);
        if (buyerAddress != null)
        {
            parcel.writeInt(1);
            buyerAddress.writeToParcel(parcel, i);
            return;
        } else
        {
            parcel.writeInt(0);
            return;
        }
    }

}

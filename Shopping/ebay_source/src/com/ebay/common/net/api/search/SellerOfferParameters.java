// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.os.Parcel;
import android.os.Parcelable;

public final class SellerOfferParameters
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SellerOfferParameters createFromParcel(Parcel parcel)
        {
            return new SellerOfferParameters(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SellerOfferParameters[] newArray(int i)
        {
            return new SellerOfferParameters[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String offerId;
    public final String offerType;
    public final String seedCategoryId;
    public final String sellerName;

    private SellerOfferParameters(Parcel parcel)
    {
        sellerName = parcel.readString();
        offerType = parcel.readString();
        offerId = parcel.readString();
        seedCategoryId = parcel.readString();
    }


    public SellerOfferParameters(SellerOfferParameters sellerofferparameters)
    {
        this(sellerofferparameters.offerType, sellerofferparameters.offerId, sellerofferparameters.sellerName, sellerofferparameters.seedCategoryId);
    }

    public SellerOfferParameters(String s, String s1, String s2, String s3)
    {
        offerType = s;
        offerId = s1;
        sellerName = s2;
        seedCategoryId = s3;
    }

    public SellerOfferParameters clone()
    {
        return new SellerOfferParameters(offerType, offerId, sellerName, seedCategoryId);
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(sellerName);
        parcel.writeString(offerType);
        parcel.writeString(offerId);
        parcel.writeString(seedCategoryId);
    }

}

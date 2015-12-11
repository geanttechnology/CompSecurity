// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class FindProductReviewsAndGuidesData extends BaseApiResponse
    implements Parcelable
{
    public static class ProductId
    {

        public String type;
        public String value;

        public ProductId()
        {
        }

        public ProductId(String s, String s1)
        {
            value = s;
            type = s1;
        }
    }

    public static class Review
    {

        public Date creationTime;
        public Integer rating;
        public String text;
        public String title;
        public String userId;

        public Review()
        {
        }
    }

    public static class ReviewDetails
    {

        public float averageRating;
        public List reviews;

        public ReviewDetails()
        {
            reviews = new LinkedList();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FindProductReviewsAndGuidesData createFromParcel(Parcel parcel)
        {
            return (FindProductReviewsAndGuidesData)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/FindProductReviewsAndGuidesData);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public FindProductReviewsAndGuidesData[] newArray(int i)
        {
            return new FindProductReviewsAndGuidesData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public int pageNumber;
    public ProductId productId;
    public int reviewCount;
    public ReviewDetails reviewDetails;
    public int totalPages;

    public FindProductReviewsAndGuidesData()
    {
        reviewDetails = new ReviewDetails();
    }

}

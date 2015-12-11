// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.guidesandreviews;

import com.ebay.nautilus.domain.data.BaseListingType;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

public class Reviews extends BaseApiResponse
{
    public static final class RatingHistogram
    {

        public int count;
        public String rating;

        public RatingHistogram()
        {
        }
    }

    public static final class Review extends BaseListingType
    {

        public com.ebay.nautilus.domain.data.BaseListingType.UserIdentifier author;
        public int count;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text description;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime lastModifiedDate;
        public Double rating;
        public String reviewId;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;

        public Review()
        {
        }
    }


    public double averageRating;
    public int count;
    public List members;
    public String productId;
    public String productType;
    public List ratingHistograms;

    public Reviews()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b;

import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.c;
import com.target.mothership.common.product.q;
import com.target.mothership.services.e.i.b;
import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

public class g
{

    private static final String YES = "Y";
    private String mAvailabilityString;
    private String mBrand;
    private String mCallOutMessage;
    private c mChannel;
    private String mChannelString;
    private String mColor;
    private String mListPrice;
    private String mMapPrice;
    private String mMaxPrice;
    private String mMaxSalePrice;
    private String mMinPrice;
    private String mMinSalePrice;
    private String mParentTcin;
    private String mPickUpInStoreString;
    private String mPriceCodeString;
    private URL mProductImage;
    private URL mProductLink;
    private String mProductTitle;
    private List mPromoDescriptions;
    private String mRatingString;
    private String mRegularPrice;
    private String mRelationshipTypeString;
    private String mReviewsString;
    private String mSalePrice;
    private String mSoiPriceDisplayString;
    private String mTcinString;

    public g()
    {
    }

    public q a()
    {
        if (com.target.mothership.util.o.g(mRelationshipTypeString))
        {
            return com.target.mothership.common.product.q.a(mRelationshipTypeString);
        } else
        {
            return q.NONE;
        }
    }

    public Tcin b()
    {
        return new Tcin(mTcinString);
    }

    public String c()
    {
        return mProductTitle;
    }

    public String d()
    {
        return mRegularPrice;
    }

    public String e()
    {
        return mMinSalePrice;
    }

    public String f()
    {
        return mMaxSalePrice;
    }

    public String g()
    {
        return mSalePrice;
    }

    public String h()
    {
        return mMaxPrice;
    }

    public String i()
    {
        return mMinPrice;
    }

    public c j()
    {
        if (mChannel == null)
        {
            mChannel = (new b()).a(mChannelString);
        }
        return mChannel;
    }

    public boolean k()
    {
        return com.target.mothership.util.o.g(mPickUpInStoreString) && "Y".equalsIgnoreCase(mPickUpInStoreString);
    }

    public URL l()
    {
        return mProductImage;
    }

    public BigDecimal m()
    {
        if (com.target.mothership.util.o.g(mRatingString))
        {
            return new BigDecimal(mRatingString);
        } else
        {
            return BigDecimal.ZERO;
        }
    }

    public int n()
    {
        if (com.target.mothership.util.o.g(mReviewsString))
        {
            return Integer.parseInt(mReviewsString);
        } else
        {
            return 0;
        }
    }

    public boolean o()
    {
        return com.target.mothership.util.o.g(mAvailabilityString) && "Y".equalsIgnoreCase(mAvailabilityString);
    }

    public String p()
    {
        return mCallOutMessage;
    }

    public List q()
    {
        return mPromoDescriptions;
    }

    public String r()
    {
        return mBrand;
    }

    public String s()
    {
        return mParentTcin;
    }
}

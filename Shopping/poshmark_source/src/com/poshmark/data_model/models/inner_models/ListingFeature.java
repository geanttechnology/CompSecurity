// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;

import com.poshmark.utils.CurrencyUtils;
import java.math.BigDecimal;

// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            Feature

public class ListingFeature extends Feature
{
    class Fee
    {

        BigDecimal commission;
        BigDecimal minimum_fee;
        final ListingFeature this$0;

        BigDecimal getCommission()
        {
            if (commission == null)
            {
                return new BigDecimal(20D);
            } else
            {
                return commission;
            }
        }

        BigDecimal getMinimumFee()
        {
            if (minimum_fee == null)
            {
                return new BigDecimal(0);
            } else
            {
                return minimum_fee;
            }
        }

        Fee()
        {
            this$0 = ListingFeature.this;
            super();
        }
    }


    Fee fee;
    BigDecimal minimum_listing_price;
    BigDecimal minimum_selling_price;

    public ListingFeature()
    {
    }

    public BigDecimal getFeeForListingPrice(BigDecimal bigdecimal)
    {
        if (fee == null)
        {
            fee = new Fee();
        }
        if (bigdecimal == null)
        {
            bigdecimal = fee.getMinimumFee();
        } else
        {
            BigDecimal bigdecimal1 = bigdecimal.multiply(fee.getCommission().divide(new BigDecimal(100)));
            BigDecimal bigdecimal2 = fee.getMinimumFee();
            bigdecimal = bigdecimal1;
            if (bigdecimal1.compareTo(bigdecimal2) != 1)
            {
                return bigdecimal2;
            }
        }
        return bigdecimal;
    }

    public String getFormattedMinimumSellingPrice()
    {
        BigDecimal bigdecimal = getMinimumSellingPrice();
        return (new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(bigdecimal.toString()).toString();
    }

    public BigDecimal getMinimumListingPrice()
    {
        if (minimum_listing_price == null)
        {
            return new BigDecimal(0);
        } else
        {
            return minimum_listing_price;
        }
    }

    public BigDecimal getMinimumSellingPrice()
    {
        if (minimum_selling_price == null)
        {
            return new BigDecimal(3);
        } else
        {
            return minimum_selling_price;
        }
    }

    public boolean isEnabled()
    {
        return true;
    }

    public boolean isValidListingPrice(String s)
    {
        return (new BigDecimal(s)).compareTo(minimum_listing_price) != -1;
    }

    public boolean isValidSellingPrice(String s)
    {
        return (new BigDecimal(s)).compareTo(minimum_selling_price) != -1;
    }
}

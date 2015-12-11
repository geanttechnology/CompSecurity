// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.PIException;
import com.pointinside.analytics.BaseAnalyticsData;

// Referenced classes of package com.pointinside.products:
//            SearchResult

public final class SearchAnalyticsData extends BaseAnalyticsData
{
    public static final class Builder extends com.pointinside.analytics.BaseAnalyticsData.Builder
    {

        private boolean isBoosted;
        private String itemId;
        private BaseProduct.PIProductsProductType itemType;
        private int resultNumber;
        private SearchResult selectedItem;

        public SearchAnalyticsData build()
            throws PIException
        {
            if (itemId == null)
            {
                throw new PIException("itemId must be set before calling build()");
            }
            if (itemType == null)
            {
                throw new PIException("itemType must be set before calling build()");
            } else
            {
                selectedItem = new SearchResult(itemType, itemId, isBoosted);
                return new SearchAnalyticsData(this);
            }
        }

        protected volatile com.pointinside.analytics.BaseAnalyticsData.Builder getThis()
        {
            return getThis();
        }

        protected Builder getThis()
        {
            return this;
        }

        public Builder setIsBoosted(boolean flag)
        {
            isBoosted = flag;
            return getThis();
        }

        public Builder setItemId(String s)
        {
            itemId = s;
            return getThis();
        }

        public Builder setItemType(BaseProduct.PIProductsProductType piproductsproducttype)
        {
            itemType = piproductsproducttype;
            return getThis();
        }

        public Builder setResultNumber(int i)
        {
            resultNumber = i;
            return getThis();
        }



        public Builder()
        {
        }
    }


    public final int resultNumber;
    public final SearchResult selectedItem;

    private SearchAnalyticsData(Builder builder)
    {
        super(builder);
        selectedItem = builder.selectedItem;
        resultNumber = builder.resultNumber;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.analytics.BaseAnalyticsData;
import com.pointinside.analytics.CommonAnalyticsData;
import java.util.List;

// Referenced classes of package com.pointinside.products:
//            AutocompleteSuggestion

class AutocompleteAnalyticsData extends BaseAnalyticsData
{
    public static final class Builder extends com.pointinside.analytics.BaseAnalyticsData.Builder
    {

        List allItems;
        int resultNumber;
        AutocompleteSuggestion selectedItem;

        public Builder allItems(List list)
        {
            allItems = list;
            return this;
        }

        public AutocompleteAnalyticsData build()
        {
            return new AutocompleteAnalyticsData(this);
        }

        public Builder commonAnalyticData(CommonAnalyticsData commonanalyticsdata)
        {
            if (commonanalyticsdata != null)
            {
                custData(commonanalyticsdata.custData);
                location(commonanalyticsdata.getLocation());
                proximity(commonanalyticsdata.proximity);
            }
            return this;
        }

        protected volatile com.pointinside.analytics.BaseAnalyticsData.Builder getThis()
        {
            return getThis();
        }

        protected Builder getThis()
        {
            return this;
        }

        public Builder resultNumber(int i)
        {
            resultNumber = i;
            return this;
        }

        public Builder selectedItem(AutocompleteSuggestion autocompletesuggestion)
        {
            selectedItem = autocompletesuggestion;
            return this;
        }

        public Builder()
        {
        }
    }


    final List allItems;
    final int resultNumber;
    final AutocompleteSuggestion selectedItem;

    private AutocompleteAnalyticsData(Builder builder)
    {
        super(builder);
        selectedItem = builder.selectedItem;
        resultNumber = builder.resultNumber;
        allItems = builder.allItems;
    }

}

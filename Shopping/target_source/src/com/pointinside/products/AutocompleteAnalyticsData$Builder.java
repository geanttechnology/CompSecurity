// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import com.pointinside.analytics.CommonAnalyticsData;
import java.util.List;

// Referenced classes of package com.pointinside.products:
//            AutocompleteAnalyticsData, AutocompleteSuggestion

public static final class  extends com.pointinside.analytics.A
{

    List allItems;
    int resultNumber;
    AutocompleteSuggestion selectedItem;

    public  allItems(List list)
    {
        allItems = list;
        return this;
    }

    public AutocompleteAnalyticsData build()
    {
        return new AutocompleteAnalyticsData(this, null);
    }

    public allItems commonAnalyticData(CommonAnalyticsData commonanalyticsdata)
    {
        if (commonanalyticsdata != null)
        {
            custData(commonanalyticsdata.custData);
            location(commonanalyticsdata.getLocation());
            proximity(commonanalyticsdata.proximity);
        }
        return this;
    }

    protected volatile com.pointinside.analytics.roximity getThis()
    {
        return getThis();
    }

    protected getThis getThis()
    {
        return this;
    }

    public getThis resultNumber(int i)
    {
        resultNumber = i;
        return this;
    }

    public resultNumber selectedItem(AutocompleteSuggestion autocompletesuggestion)
    {
        selectedItem = autocompletesuggestion;
        return this;
    }

    public ()
    {
    }
}

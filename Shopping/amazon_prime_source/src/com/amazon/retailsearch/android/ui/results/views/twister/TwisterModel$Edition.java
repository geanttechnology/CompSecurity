// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.twister;

import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.twister:
//            TwisterModel

protected class styledRentalPrices
{

    public String asin;
    protected String price;
    protected RetailSearchResultItem resultItem;
    protected String srdsBadgeId;
    protected List styledPrice;
    protected List styledRentalPrices;
    protected String text;
    final TwisterModel this$0;

    public m(String s, String s1, String s2, RetailSearchResultItem retailsearchresultitem, List list, List list1)
    {
        this$0 = TwisterModel.this;
        super();
        text = s;
        price = s1;
        srdsBadgeId = s2;
        resultItem = retailsearchresultitem;
        styledPrice = list;
        styledRentalPrices = list1;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemSelectionListener;
import com.amazon.retailsearch.interaction.UserInteractionListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            SplitProduct

private class asin
    implements ResultItemSelectionListener
{

    private String asin;
    final SplitProduct this$0;

    public void onResultItemSelected(RetailSearchResultItem retailsearchresultitem)
    {
        if (asin != null && asin.equals(SplitProduct.access$100(SplitProduct.this)))
        {
            SplitProduct.access$200(SplitProduct.this, asin, retailsearchresultitem.getAsin());
        }
        userInteractionListener.removeListener(this);
    }

    public stener(String s)
    {
        this$0 = SplitProduct.this;
        super();
        asin = s;
    }
}

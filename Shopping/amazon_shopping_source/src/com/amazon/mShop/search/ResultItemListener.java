// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.res.Resources;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemSelectionListener;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.search:
//            SearchActivity

class ResultItemListener
    implements ResultItemSelectionListener
{

    private final SearchActivity searchActivity;

    public ResultItemListener(SearchActivity searchactivity)
    {
        searchActivity = searchactivity;
    }

    protected SearchActivity getSearchActivity()
    {
        return searchActivity;
    }

    public void onResultItemSelected(RetailSearchResultItem retailsearchresultitem)
    {
        while (retailsearchresultitem == null || openView(retailsearchresultitem)) 
        {
            return;
        }
        openUdp(retailsearchresultitem);
    }

    protected void openUdp(RetailSearchResultItem retailsearchresultitem)
    {
        if (Util.isEmpty(retailsearchresultitem.getDetailPageUrlPath()))
        {
            return;
        }
        String s1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentUdpUrl");
        String s = s1;
        if (Util.isEmpty(s1))
        {
            s = searchActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.product_details_web_page_url);
        }
        if ("points_stored_value".equals(retailsearchresultitem.getProductGroup()))
        {
            ActivityUtils.startAppstoreActivityToBuyCoins(searchActivity, retailsearchresultitem.getAsin());
            return;
        } else
        {
            retailsearchresultitem = (new StringBuilder()).append(s).append(retailsearchresultitem.getDetailPageUrlPath()).toString();
            ActivityUtils.goToUdp(searchActivity, retailsearchresultitem, ClickStreamTag.ORIGIN_SEARCH, -1);
            return;
        }
    }

    protected boolean openView(RetailSearchResultItem retailsearchresultitem)
    {
        return false;
    }
}

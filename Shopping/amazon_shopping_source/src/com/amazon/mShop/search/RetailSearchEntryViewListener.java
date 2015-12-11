// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.UIUtils;
import com.amazon.retailsearch.android.api.query.Query;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.entry.SearchEntryViewListener;

// Referenced classes of package com.amazon.mShop.search:
//            SearchActivity, SearchIntentBuilder

public class RetailSearchEntryViewListener
    implements SearchEntryViewListener
{

    private SearchActivity mSearchActivity;

    public RetailSearchEntryViewListener(SearchActivity searchactivity)
    {
        mSearchActivity = searchactivity;
    }

    private boolean isPerformCommonSearch(String s)
    {
        return !"BARCODE_SEARCH_QUERY_KEYWORD".equals(s) && !"IMAGE_SEARCH_QUERY_KEYWORD".equals(s) && !"VOICE_SEARCH_QUERY_KEYWORD".equals(s);
    }

    private void logSearchRefMarker()
    {
        RefMarkerObserver.logRefMarker("sr_txt");
    }

    protected String getCurrentDepartmentFilter()
    {
        return SearchActivity.getCurrentDepartmentFilter();
    }

    public boolean onDispatchKeyEventPreIme(KeyEvent keyevent, Context context)
    {
        if (mSearchActivity.menuDispatchedKeyEvent(keyevent))
        {
            return true;
        }
        if (keyevent.getKeyCode() == 4 && mSearchActivity != null && UIUtils.isPortrait(context) && keyevent.getAction() == 0)
        {
            mSearchActivity.popView();
            return true;
        } else
        {
            return false;
        }
    }

    public void onQueryCleared()
    {
        SearchActivity.setPreviousSearchTerm("");
    }

    public volatile void onQuerySubmit(Query query)
    {
        onQuerySubmit((RetailSearchQuery)query);
    }

    public void onQuerySubmit(RetailSearchQuery retailsearchquery)
    {
        if (retailsearchquery == null || TextUtils.isEmpty(retailsearchquery.getKeywords()))
        {
            return;
        }
        if (!isPerformCommonSearch(retailsearchquery.getKeywords())) goto _L2; else goto _L1
_L1:
        String s;
        String s1;
        if (retailsearchquery.isAps())
        {
            s = getCurrentDepartmentFilter();
        } else
        {
            s = retailsearchquery.getAlias();
        }
        logSearchRefMarker();
        if (mSearchActivity.getClickStreamOrigin() != null)
        {
            s1 = mSearchActivity.getClickStreamOrigin();
        } else
        {
            s1 = ClickStreamTag.ORIGIN_SEARCH.getTag();
        }
        retailsearchquery = (new SearchIntentBuilder(mSearchActivity)).retailSearchQuery(retailsearchquery).query(retailsearchquery.getKeywords()).filter(s).categoryName(s).clickStreamOrigin(s1).build();
_L4:
        mSearchActivity.doSearch(retailsearchquery);
        return;
_L2:
        Intent intent = new Intent(mSearchActivity, com/amazon/mShop/search/SearchActivity);
        intent.setData(Uri.parse(retailsearchquery.getKeywords()).buildUpon().build());
        intent.setAction("android.intent.action.VIEW");
        retailsearchquery = intent;
        if ("BARCODE_SEARCH_QUERY_KEYWORD".equals(intent.getDataString()))
        {
            intent.putExtra("REFMARKER", "sr_scan");
            retailsearchquery = intent;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}

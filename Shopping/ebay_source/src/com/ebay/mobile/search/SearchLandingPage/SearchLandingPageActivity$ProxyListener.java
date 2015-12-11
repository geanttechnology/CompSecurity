// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;

import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import com.ebay.common.Preferences;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.model.SourceIdentification;

// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchLandingPageActivity

private class <init>
    implements android.support.v7.widget..ProxyListener
{

    final SearchLandingPageActivity this$0;

    public boolean onQueryTextChange(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            if (!SearchLandingPageActivity.access$200(SearchLandingPageActivity.this).isShown())
            {
                refreshLayout.setVisibility(0);
                SearchLandingPageActivity.access$200(SearchLandingPageActivity.this).setVisibility(0);
            }
            if (!SearchLandingPageActivity.access$300(SearchLandingPageActivity.this).isShown() && SearchLandingPageActivity.access$400(SearchLandingPageActivity.this))
            {
                SearchLandingPageActivity.access$500(SearchLandingPageActivity.this, true);
            }
            if (suggestionListView.isShown())
            {
                suggestionListView.setVisibility(8);
                isSuggestionVisible = false;
            }
            suggestionList = null;
            MyApp.getPrefs().removeUserPref("searchLastKeywords");
        } else
        {
            if (SearchLandingPageActivity.access$200(SearchLandingPageActivity.this).isShown() || isSuggestionVisible)
            {
                SearchLandingPageActivity.access$200(SearchLandingPageActivity.this).setVisibility(8);
                refreshLayout.setVisibility(8);
            }
            if (SearchLandingPageActivity.access$300(SearchLandingPageActivity.this).isShown())
            {
                SearchLandingPageActivity.access$500(SearchLandingPageActivity.this, false);
            }
            MyApp.getPrefs().setUserPref("searchLastKeywords", s);
            SearchLandingPageActivity.access$600(SearchLandingPageActivity.this, s);
        }
        if (SearchLandingPageActivity.access$700(SearchLandingPageActivity.this) != null && !SearchLandingPageActivity.access$700(SearchLandingPageActivity.this).query.equals(s))
        {
            SearchLandingPageActivity.access$702(SearchLandingPageActivity.this, null);
        }
        return true;
    }

    public boolean onQueryTextSubmit(String s)
    {
        boolean flag = false;
        if (SearchLandingPageActivity.access$700(SearchLandingPageActivity.this) != null)
        {
            s = new SourceIdentification("EnterSearch", "sm", "utq");
            ActivityStarter.startSearch(SearchLandingPageActivity.this, SearchLandingPageActivity.access$700(SearchLandingPageActivity.this).query, SearchLandingPageActivity.access$700(SearchLandingPageActivity.this).userQuery, SearchLandingPageActivity.access$700(SearchLandingPageActivity.this).categoryName, SearchLandingPageActivity.access$700(SearchLandingPageActivity.this).categoryId, s);
            SearchLandingPageActivity.access$702(SearchLandingPageActivity.this, null);
            flag = true;
        }
        finish();
        return flag;
    }

    private Info()
    {
        this$0 = SearchLandingPageActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

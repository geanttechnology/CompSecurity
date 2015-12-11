// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchResultState;
import com.ebay.common.view.SearchCompositeRecyclerAdapter;
import com.ebay.mobile.sitespeed.SiteSpeedActivityUtil;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.data.SiteSpeedData;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragment, SearchViewManager

private class <init> extends com.ebay.common.content.dm.t>
{

    private boolean deliverContentEvents;
    final SearchResultFragment this$0;

    private void setDeliverContentEvents(boolean flag)
    {
        deliverContentEvents = flag;
    }

    public void onAdsLoaded(SearchResultState searchresultstate)
    {
        if (SearchResultFragment.access$400(SearchResultFragment.this) != null)
        {
            searchresultstate = searchresultstate.getSearchAds();
            SiteSpeedData sitespeeddata = SiteSpeedActivityUtil.getSiteSpeedData(getBaseActivity());
            int i;
            if (searchresultstate == null)
            {
                i = 0;
            } else
            {
                i = ((com.ebay.common.net.api.search.ontentEvents) (searchresultstate)).ontentEvents.size();
            }
            sitespeeddata.addExtendedData("i_ac", String.valueOf(i));
            sitespeeddata.setEventName((new StringBuilder()).append(sitespeeddata.eventName).append("WithAds").toString());
            SiteSpeedActivityUtil.allLoaded(getBaseActivity());
            if (searchresultstate != null)
            {
                SearchResultFragment.access$200(SearchResultFragment.this).adsLoaded(searchresultstate, SearchResultFragment.access$700(SearchResultFragment.this));
                return;
            }
        }
    }

    public void onPopularSearchesAvailable(ArrayList arraylist, int i)
    {
        SearchResultFragment.access$1200(SearchResultFragment.this, arraylist, true);
    }

    public void onSearchComplete(SearchResultState searchresultstate)
    {
        SearchResultFragment.access$402(SearchResultFragment.this, searchresultstate);
        SearchResultFragment.this.onSearchComplete(SearchResultFragment.access$400(SearchResultFragment.this));
        SearchResultFragment.access$800(SearchResultFragment.this);
    }

    public void onSearchContentChanged(ListContent listcontent)
    {
        if (deliverContentEvents)
        {
            Object obj = listcontent.getStatus();
            if (((ResultStatus) (obj)).hasError())
            {
                if (((ResultStatus) (obj)).canRetry())
                {
                    showPagedListRetryDialog();
                    return;
                } else
                {
                    SearchResultFragment.access$900(SearchResultFragment.this, ((ResultStatus) (obj)));
                    return;
                }
            }
            obj = SearchResultFragment.access$200(SearchResultFragment.this).getListAdapter();
            ArrayList arraylist = new ArrayList(listcontent.getList());
            int i = listcontent.getTotalItemCount();
            int j = listcontent.getPagesLoaded();
            if (obj != null)
            {
                ((SearchCompositeRecyclerAdapter) (obj)).setList(0, ((SearchCompositeRecyclerAdapter) (obj)).newSection(0, "", arraylist, i, SearchResultFragment.access$1000(SearchResultFragment.this), j, SearchResultFragment.access$1100(SearchResultFragment.this)));
                return;
            }
        }
    }

    public void onSearchStarted(SearchParameters searchparameters)
    {
        SearchResultFragment.access$200(SearchResultFragment.this).searchStarted(searchparameters);
    }


    private ()
    {
        this$0 = SearchResultFragment.this;
        super();
        deliverContentEvents = true;
    }

    deliverContentEvents(deliverContentEvents delivercontentevents)
    {
        this();
    }
}

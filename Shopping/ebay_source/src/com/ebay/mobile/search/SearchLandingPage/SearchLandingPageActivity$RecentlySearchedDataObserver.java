// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;

import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import com.ebay.app.ModalProgressFragment;
import com.ebay.mobile.recents.RecentsDataManager;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.PdsSearchItemAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchLandingPageActivity, SearchLandingPageAdapter

private final class <init> extends com.ebay.mobile.recents.chedDataObserver
{

    final SearchLandingPageActivity this$0;

    public void onAllSearchItemDeleteComplete(RecentsDataManager recentsdatamanager, Content content)
    {
        ModalProgressFragment.hide(getFragmentManager());
        recentsdatamanager = searchLandingPageAdapter.getList(0);
        if (recentsdatamanager != null && ((com.ebay.nautilus.shell.widget.apter) (recentsdatamanager)).apter != null)
        {
            SearchLandingPageActivity.access$1000(SearchLandingPageActivity.this, 0);
        }
    }

    public void onGetRecentlySearchedData(RecentsDataManager recentsdatamanager, Content content)
    {
        if (!isFinishing())
        {
            if (content != null && content.getData() != null)
            {
                recentsdatamanager = new ArrayList();
                PdsSearchItemAttribute pdssearchitemattribute;
                this._cls0 _lcls0;
                for (content = ((List)content.getData()).iterator(); content.hasNext(); recentsdatamanager.add(new this._cls0(pdssearchitemattribute.attributeValue, CENT_SEARCH, SearchLandingPageActivity.access$900(SearchLandingPageActivity.this, pdssearchitemattribute), _lcls0)))
                {
                    pdssearchitemattribute = (PdsSearchItemAttribute)content.next();
                    _lcls0 = new t>();
                    if (!TextUtils.isEmpty(pdssearchitemattribute.categoryId))
                    {
                        _lcls0.goryId = Long.valueOf(pdssearchitemattribute.categoryId).longValue();
                    }
                    if (!SearchLandingPageActivity.access$800(SearchLandingPageActivity.this).isEmpty())
                    {
                        _lcls0.ileImgUrl = (String)SearchLandingPageActivity.access$800(SearchLandingPageActivity.this).get(pdssearchitemattribute.attributeValue);
                    }
                }

                searchLandingPageAdapter.updateAdapterData(0, recentsdatamanager);
            } else
            {
                SearchLandingPageActivity.access$1000(SearchLandingPageActivity.this, 0);
            }
            if (refreshLayout.isRefreshing() && dismissSwipeToRefreshTask != null && dismissSwipeToRefreshTask.peToRefreshLatch != null)
            {
                dismissSwipeToRefreshTask.peToRefreshLatch.countDown();
                return;
            }
        }
    }

    private ()
    {
        this$0 = SearchLandingPageActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

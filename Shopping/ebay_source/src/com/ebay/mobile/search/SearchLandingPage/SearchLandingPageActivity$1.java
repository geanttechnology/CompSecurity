// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.SearchLandingPage;

import com.ebay.common.UserCache;
import com.ebay.mobile.notifications.ItemCache;

// Referenced classes of package com.ebay.mobile.search.SearchLandingPage:
//            SearchLandingPageActivity

class this._cls0
    implements Runnable
{

    final SearchLandingPageActivity this$0;

    public void run()
    {
        SearchLandingPageActivity.access$1102(SearchLandingPageActivity.this, SearchLandingPageActivity.access$1200(SearchLandingPageActivity.this).getSavedSearches());
        SearchLandingPageActivity.access$1300(SearchLandingPageActivity.this).refreshSavedSearchList();
    }

    ()
    {
        this$0 = SearchLandingPageActivity.this;
        super();
    }
}

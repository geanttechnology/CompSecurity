// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.interaction.PrefetchingManager;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            DisplayStateChangeListener, RetailSearchEditTextWatcher

class val.query
    implements DisplayStateChangeListener
{

    final RetailSearchEditTextWatcher this$0;
    final RetailSearchQuery val$query;

    public void onHide()
    {
        prefetchingManager.cancelPreviousSearchBoxPrefetchingRequests();
    }

    public void onShow()
    {
        prefetchingManager.prefetchForSearchBox(val$query);
    }

    ()
    {
        this$0 = final_retailsearchedittextwatcher;
        val$query = RetailSearchQuery.this;
        super();
    }
}

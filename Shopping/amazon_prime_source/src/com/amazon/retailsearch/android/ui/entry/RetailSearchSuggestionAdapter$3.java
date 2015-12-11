// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import com.amazon.retailsearch.interaction.PrefetchingManager;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            DisplayStateChangeListener, RetailSearchSuggestionAdapter, SuggestionsItemListener

class val.position
    implements DisplayStateChangeListener
{

    final RetailSearchSuggestionAdapter this$0;
    final boolean val$isA9Suggestion;
    final int val$position;

    public void onHide()
    {
        prefetchingManager.cancelPreviousISSPrefetchingRequests();
    }

    public void onShow()
    {
        if (RetailSearchSuggestionAdapter.access$000(RetailSearchSuggestionAdapter.this) != null && val$isA9Suggestion)
        {
            RetailSearchSuggestionAdapter.access$000(RetailSearchSuggestionAdapter.this).onA9SuggestionShow();
        }
        if (prefetchingManager.isPrefetchingEnabled() && !prefetchingManager.isOutOfBudget() && RetailSearchSuggestionAdapter.access$100(RetailSearchSuggestionAdapter.this).size() > val$position)
        {
            com.amazon.retailsearch.android.api.query.RetailSearchQuery retailsearchquery = generateQuery(val$position);
            PrefetchingManager prefetchingmanager = prefetchingManager;
            int i;
            if (RetailSearchSuggestionAdapter.access$200(RetailSearchSuggestionAdapter.this))
            {
                i = val$position - 1;
            } else
            {
                i = val$position;
            }
            prefetchingmanager.prefetchForISS(retailsearchquery, i);
        }
    }

    ()
    {
        this$0 = final_retailsearchsuggestionadapter;
        val$isA9Suggestion = flag;
        val$position = I.this;
        super();
    }
}

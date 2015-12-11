// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import com.amazon.retailsearch.android.api.display.input.listeners.ISSListener;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.interaction.PrefetchingManager;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionFilterListener, RetailSearchEditTextWatcher, SuggestionRowModifier, RetailSearchSuggestionAdapter

public class this._cls0
    implements RetailSearchSuggestionFilterListener
{

    final RetailSearchEditTextWatcher this$0;

    public void afterConstructRows(List list)
    {
        if (RetailSearchEditTextWatcher.access$200(RetailSearchEditTextWatcher.this) == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        RetailSearchEditTextWatcher.access$200(RetailSearchEditTextWatcher.this).preRenderSuggestions(new SuggestionRowModifier(list));
        return;
        list;
        RetailSearchEditTextWatcher.access$300(RetailSearchEditTextWatcher.this).error("An exception occurred while modifying the suggestions.", list);
        return;
    }

    public void afterPublishResults(String s, List list)
    {
        if (RetailSearchEditTextWatcher.access$100(RetailSearchEditTextWatcher.this) != null)
        {
            RetailSearchEditTextWatcher.access$100(RetailSearchEditTextWatcher.this).updateSuggestionContent(s, list);
            RetailSearchEditTextWatcher.access$100(RetailSearchEditTextWatcher.this).notifyDataSetChanged();
        }
        prefetchingManager.cancelPreviousISSPrefetchingRequests();
    }

    public void beforePerformFiltering()
    {
    }

    public void beforePublishResults(List list, boolean flag)
    {
    }

    public Y()
    {
        this$0 = RetailSearchEditTextWatcher.this;
        super();
    }
}

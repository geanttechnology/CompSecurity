// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.text.TextUtils;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryContext;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilter;
import com.amazon.retailsearch.android.ui.entry.SuggestionsItemListener;
import com.amazon.retailsearch.data.SuggestionDataProvider;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry, SearchEntryAutocompleteTextView

public class searchBoxLogger
    implements SuggestionsItemListener
{

    private RetailSearchSuggestionFilter filter;
    SearchBoxLogger searchBoxLogger;
    final ClearableAutocompleteSearchEntry this$0;

    public void onA9SuggestionShow()
    {
        synchronized (ClearableAutocompleteSearchEntry.access$400(ClearableAutocompleteSearchEntry.this))
        {
            if (!ClearableAutocompleteSearchEntry.access$400(ClearableAutocompleteSearchEntry.this).isFirstSuggestionLogged())
            {
                searchBoxLogger.searchSuggestionsFirstEntryShowed();
                ClearableAutocompleteSearchEntry.access$400(ClearableAutocompleteSearchEntry.this).setIsFirstSuggestionLogged(true);
            }
        }
        return;
        exception;
        retailsearchentrycontext;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onDeletePastSearchesClick(final String id, final String deleteURL)
    {
        (new Thread(new Runnable() {

            final ClearableAutocompleteSearchEntry.SearchSuggestionsItemListener this$1;
            final String val$deleteURL;
            final String val$id;

            public void run()
            {
                ClearableAutocompleteSearchEntry.access$1200(this$0).deletePastSearches(id, deleteURL);
                if (filter != null)
                {
                    ClearableAutocompleteSearchEntry.access$400(this$0).setForceUpdatePastSearches(true);
                    filter.filter(ClearableAutocompleteSearchEntry.access$000(this$0).getText());
                }
            }

            
            {
                this$1 = ClearableAutocompleteSearchEntry.SearchSuggestionsItemListener.this;
                id = s;
                deleteURL = s1;
                super();
            }
        })).start();
    }

    public void onQueryBuilderClick(String s)
    {
        if (!TextUtils.isEmpty(s) && ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).getText() != null && !s.equals(ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).getText().toString()))
        {
            ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).setText((new StringBuilder()).append(s).append(" ").toString());
            ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).setSelection(s.length() + 1);
        }
    }

    public void setFilter(RetailSearchSuggestionFilter retailsearchsuggestionfilter)
    {
        filter = retailsearchsuggestionfilter;
    }


    public _cls1.val.deleteURL()
    {
        this$0 = ClearableAutocompleteSearchEntry.this;
        super();
        searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.input;

import android.text.TextUtils;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.ui.ClearableAutoCompleteTextView;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryContext;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilter;
import com.amazon.retailsearch.android.ui.entry.SuggestionsItemListener;
import com.amazon.retailsearch.data.SuggestionDataProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;

// Referenced classes of package com.amazon.retailsearch.android.ui.input:
//            RetailSearchQueryEntry

public static class entryContext
    implements SuggestionsItemListener
{

    private ClearableAutoCompleteTextView autoCompleteTextView;
    private RetailSearchEntryContext entryContext;
    private RetailSearchSuggestionFilter filter;
    SearchBoxLogger searchBoxLogger;
    private SuggestionDataProvider suggestionDataProvider;

    public void onA9SuggestionShow()
    {
        synchronized (entryContext)
        {
            if (!entryContext.isISSLatencyLogged())
            {
                searchBoxLogger.searchSuggestionsFirstEntryShowed();
                entryContext.setISSLatencyLogged(true);
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

            final RetailSearchQueryEntry.SearchSuggestionsItemListener this$0;
            final String val$deleteURL;
            final String val$id;

            public void run()
            {
                suggestionDataProvider.deletePastSearches(id, deleteURL);
                if (filter != null)
                {
                    entryContext.setForceUpdatePastSearches(true);
                    filter.filter(autoCompleteTextView.getText());
                }
            }

            
            {
                this$0 = RetailSearchQueryEntry.SearchSuggestionsItemListener.this;
                id = s;
                deleteURL = s1;
                super();
            }
        })).start();
    }

    public void onQueryBuilderClick(String s)
    {
        if (!TextUtils.isEmpty(s) && autoCompleteTextView.getText() != null && !s.equals(autoCompleteTextView.getText().toString()))
        {
            autoCompleteTextView.setText((new StringBuilder()).append(s).append(" ").toString());
            autoCompleteTextView.setSelection(s.length() + 1);
        }
    }

    public void setFilter(RetailSearchSuggestionFilter retailsearchsuggestionfilter)
    {
        filter = retailsearchsuggestionfilter;
    }





    public _cls1.val.deleteURL(ClearableAutoCompleteTextView clearableautocompletetextview, SuggestionDataProvider suggestiondataprovider, RetailSearchEntryContext retailsearchentrycontext)
    {
        searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
        RetailSearchDaggerGraphController.inject(this);
        autoCompleteTextView = clearableautocompletetextview;
        suggestionDataProvider = suggestiondataprovider;
        entryContext = retailsearchentrycontext;
    }
}

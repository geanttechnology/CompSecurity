// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.text.TextUtils;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.data.ISuggestionDataProvider;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            SuggestionsItemListener, RetailSearchEditTextWatcher, RetailSearchEntryContext, RetailSearchEditText, 
//            RetailSearchSuggestionFilter

public class suggestionDataProvider
    implements SuggestionsItemListener
{

    SearchBoxLogger searchBoxLogger;
    private ISuggestionDataProvider suggestionDataProvider;
    final RetailSearchEditTextWatcher this$0;

    public void onA9SuggestionShow()
    {
        synchronized (RetailSearchEditTextWatcher.access$600(RetailSearchEditTextWatcher.this))
        {
            if (!RetailSearchEditTextWatcher.access$600(RetailSearchEditTextWatcher.this).isFirstSuggestionLogged())
            {
                searchBoxLogger.searchSuggestionsFirstEntryShowed();
                RetailSearchEditTextWatcher.access$600(RetailSearchEditTextWatcher.this).setIsFirstSuggestionLogged(true);
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

            final RetailSearchEditTextWatcher.SearchSuggestionsItemListener this$1;
            final String val$deleteURL;
            final String val$id;

            public void run()
            {
                suggestionDataProvider.deletePastSearches(id, deleteURL);
                if (RetailSearchEditTextWatcher.access$500(this$0) != null)
                {
                    RetailSearchEditTextWatcher.access$600(this$0).setForceUpdatePastSearches(true);
                    RetailSearchEditTextWatcher.access$500(this$0).filter(mSearchEditText.getText());
                }
            }

            
            {
                this$1 = RetailSearchEditTextWatcher.SearchSuggestionsItemListener.this;
                id = s;
                deleteURL = s1;
                super();
            }
        })).start();
        searchBoxLogger.recordRecentSearchCleared();
    }

    public void onQueryBuilderClick(String s)
    {
        if (!TextUtils.isEmpty(s) && mSearchEditText.getText() != null && !s.equals(mSearchEditText.getText().toString()))
        {
            mSearchEditText.setText((new StringBuilder()).append(s).append(" ").toString());
            mSearchEditText.setSelection(s.length() + 1);
            searchBoxLogger.recordQueryBuilderUsage();
        }
    }


    public _cls1.val.deleteURL(ISuggestionDataProvider isuggestiondataprovider)
    {
        this$0 = RetailSearchEditTextWatcher.this;
        super();
        searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
        suggestionDataProvider = isuggestiondataprovider;
    }
}

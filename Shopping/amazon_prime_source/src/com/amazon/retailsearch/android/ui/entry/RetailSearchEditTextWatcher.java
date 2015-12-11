// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.amazon.retailsearch.android.api.display.input.listeners.ISSListener;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.api.query.Query;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.data.ISuggestionDataProvider;
import com.amazon.retailsearch.data.SuggestionDataProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.PrefetchingManager;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.metrics.IssLogger;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionFilter, RetailSearchSuggestionAdapter, RetailSearchEntryContext, TransientSearchChangeListener, 
//            RetailSearchEditText, RetailSearchSuggestionFilterListener, SuggestionRowModifier, SuggestionsItemListener, 
//            DisplayStateChangeListener

public class RetailSearchEditTextWatcher
    implements TextWatcher
{
    public class FilterListener
        implements RetailSearchSuggestionFilterListener
    {

        final RetailSearchEditTextWatcher this$0;

        public void afterConstructRows(List list)
        {
            if (issListener == null)
            {
                break MISSING_BLOCK_LABEL_30;
            }
            issListener.preRenderSuggestions(new SuggestionRowModifier(list));
            return;
            list;
            retailSearchLogger.error("An exception occurred while modifying the suggestions.", list);
            return;
        }

        public void afterPublishResults(String s, List list)
        {
            if (adapter != null)
            {
                adapter.updateSuggestionContent(s, list);
                adapter.notifyDataSetChanged();
            }
            prefetchingManager.cancelPreviousISSPrefetchingRequests();
        }

        public void beforePerformFiltering()
        {
        }

        public void beforePublishResults(List list, boolean flag)
        {
        }

        public FilterListener()
        {
            this$0 = RetailSearchEditTextWatcher.this;
            super();
        }
    }

    public class SearchSuggestionsItemListener
        implements SuggestionsItemListener
    {

        SearchBoxLogger searchBoxLogger;
        private ISuggestionDataProvider suggestionDataProvider;
        final RetailSearchEditTextWatcher this$0;

        public void onA9SuggestionShow()
        {
            synchronized (entryContext)
            {
                if (!entryContext.isFirstSuggestionLogged())
                {
                    searchBoxLogger.searchSuggestionsFirstEntryShowed();
                    entryContext.setIsFirstSuggestionLogged(true);
                }
            }
            return;
            exception;
            retailsearchentrycontext;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onDeletePastSearchesClick(final String id, String s)
        {
            (new Thread(s. new Runnable() {

                final SearchSuggestionsItemListener this$1;
                final String val$deleteURL;
                final String val$id;

                public void run()
                {
                    suggestionDataProvider.deletePastSearches(id, deleteURL);
                    if (mFilter != null)
                    {
                        entryContext.setForceUpdatePastSearches(true);
                        mFilter.filter(mSearchEditText.getText());
                    }
                }

            
            {
                this$1 = final_searchsuggestionsitemlistener;
                id = s;
                deleteURL = String.this;
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


        public SearchSuggestionsItemListener(ISuggestionDataProvider isuggestiondataprovider)
        {
            this$0 = RetailSearchEditTextWatcher.this;
            super();
            searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
            suggestionDataProvider = isuggestiondataprovider;
        }
    }


    private RetailSearchSuggestionAdapter adapter;
    private final RetailSearchEntryContext entryContext;
    private ISSListener issListener;
    private QuerySubmitListener listener;
    protected final Context mContext;
    private RetailSearchSuggestionFilter mFilter;
    protected boolean mFirstPreCheck;
    private final String mSearchAlias;
    protected final RetailSearchEditText mSearchEditText;
    private final boolean mSkipDepartmentResultsFromISS;
    private final ListView mSuggstionsListView;
    RetailSearchAndroidPlatform platform;
    PrefetchingManager prefetchingManager;
    private RetailSearchLogger retailSearchLogger;
    private SearchBoxLogger searchBoxLogger;
    private TransientSearchChangeListener transientSearchChangeListener;

    public RetailSearchEditTextWatcher(Context context, ListView listview, RetailSearchEntryContext retailsearchentrycontext, RetailSearchEditText retailsearchedittext, String s)
    {
        this(context, listview, retailsearchentrycontext, retailsearchedittext, s, false);
    }

    public RetailSearchEditTextWatcher(Context context, ListView listview, RetailSearchEntryContext retailsearchentrycontext, RetailSearchEditText retailsearchedittext, String s, boolean flag)
    {
        mFilter = null;
        mFirstPreCheck = false;
        searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
        mContext = context;
        mSuggstionsListView = listview;
        mSearchEditText = retailsearchedittext;
        mSearchAlias = s;
        mSkipDepartmentResultsFromISS = flag;
        entryContext = retailsearchentrycontext;
        mSuggstionsListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RetailSearchEditTextWatcher this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                UIUtils.closeSoftKeyboard(mSearchEditText);
                if (listener != null)
                {
                    adapterview = adapter.generateQuery(i);
                    listener.onQuerySubmit(adapterview);
                    mSearchEditText.setText(adapterview.getKeywords());
                    setForceUpdatePastSearches(true);
                }
            }

            
            {
                this$0 = RetailSearchEditTextWatcher.this;
                super();
            }
        });
        context = new SuggestionDataProvider(mContext);
        listview = new FilterListener();
        mFilter = new RetailSearchSuggestionFilter(context, mSearchAlias, mSearchEditText, retailsearchentrycontext, listview, mSkipDepartmentResultsFromISS);
        context = new SearchSuggestionsItemListener(context);
        listview = new QuerySubmitListener() {

            final RetailSearchEditTextWatcher this$0;

            public volatile void onQuerySubmit(Query query)
            {
                onQuerySubmit((RetailSearchQuery)query);
            }

            public void onQuerySubmit(RetailSearchQuery retailsearchquery)
            {
                if (listener != null)
                {
                    UIUtils.closeSoftKeyboard(mSearchEditText);
                    listener.onQuerySubmit(retailsearchquery);
                }
            }

            
            {
                this$0 = RetailSearchEditTextWatcher.this;
                super();
            }
        };
        adapter = new RetailSearchSuggestionAdapter(mContext, context, listview, retailsearchentrycontext, mFilter);
        mSuggstionsListView.setAdapter(adapter);
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public List getSearchSuggestionRows()
    {
        if (mSuggstionsListView == null || mSuggstionsListView.getAdapter() == null)
        {
            return null;
        } else
        {
            return ((RetailSearchSuggestionAdapter)mSuggstionsListView.getAdapter()).getSuggestionRows();
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (entryContext != null && !entryContext.isFirstKeystrokeLogged() && !TextUtils.isEmpty(charsequence))
        {
            searchBoxLogger.searchSuggestionsFirstKeyStroke();
            entryContext.setIsFirstKeystrokeLogged(true);
        }
        updateSuggestions(charsequence, false);
    }

    public void setForceUpdatePastSearches(boolean flag)
    {
        if (entryContext != null)
        {
            entryContext.setForceUpdatePastSearches(flag);
        }
    }

    public void setListener(ISSListener isslistener)
    {
        issListener = isslistener;
    }

    public void setListener(QuerySubmitListener querysubmitlistener)
    {
        listener = querysubmitlistener;
    }

    public void setListener(TransientSearchChangeListener transientsearchchangelistener)
    {
        transientSearchChangeListener = transientsearchchangelistener;
    }

    public void updateCurrentDepartmentName(String s)
    {
        if (entryContext != null)
        {
            entryContext.setCurrentDepartmentName(s);
        }
    }

    protected void updateSuggestions(CharSequence charsequence, boolean flag)
    {
        final RetailSearchQuery query;
        if (charsequence == null || TextUtils.isEmpty(charsequence.toString().trim()))
        {
            String s = "";
            Object obj = null;
            query = obj;
            charsequence = s;
            if (transientSearchChangeListener != null)
            {
                transientSearchChangeListener.onQueryCleared();
                charsequence = s;
                query = obj;
            }
        } else
        {
            query = new RetailSearchQuery(charsequence.toString());
            try
            {
                query.setRefTag(IssLogger.computeSubmitQueryRefTag(adapter.getSuggestionRows(), charsequence.toString()));
            }
            catch (Exception exception)
            {
                retailSearchLogger.error("exception occured while calculating the search box ref-tag", exception);
            }
        }
        prefetchingManager.cancelPreviousSearchBoxPrefetchingRequests();
        prefetchingManager.prefetchForSearchBox(query);
        mSearchEditText.setDisplayStateChangeListener(new DisplayStateChangeListener() {

            final RetailSearchEditTextWatcher this$0;
            final RetailSearchQuery val$query;

            public void onHide()
            {
                prefetchingManager.cancelPreviousSearchBoxPrefetchingRequests();
            }

            public void onShow()
            {
                prefetchingManager.prefetchForSearchBox(query);
            }

            
            {
                this$0 = RetailSearchEditTextWatcher.this;
                query = retailsearchquery;
                super();
            }
        });
        mFilter.filter(charsequence);
    }






}

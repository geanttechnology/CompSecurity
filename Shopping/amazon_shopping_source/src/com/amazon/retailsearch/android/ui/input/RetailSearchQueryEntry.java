// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.display.input.SearchEntry;
import com.amazon.retailsearch.android.api.display.input.listeners.KeyPreImeListener;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.api.query.QuerySource;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.ClearButtonEventListener;
import com.amazon.retailsearch.android.ui.ClearableAutoCompleteTextView;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryContext;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionAdapter;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilter;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilterListener;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionRow;
import com.amazon.retailsearch.android.ui.entry.SuggestionsItemListener;
import com.amazon.retailsearch.data.SuggestionDataProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.metrics.IssLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RetailSearchQueryEntry extends LinearLayout
    implements SearchEntry
{
    public static class FilterListener
        implements RetailSearchSuggestionFilterListener
    {

        private RetailSearchSuggestionAdapter adapter;
        private ClearableAutoCompleteTextView autoCompleteTextView;
        RetailSearchAndroidPlatform platform;
        private Drawable searchMagnifier;
        private Drawable workingSpinner;

        public void afterPublishResults(String s, List list)
        {
            if (adapter != null)
            {
                adapter.updateSuggestionContent(s, list);
                adapter.notifyDataSetChanged();
            }
        }

        public void beforePerformFiltering()
        {
            platform.invokeLater(new Runnable() {

                final FilterListener this$0;

                public void run()
                {
                    if (autoCompleteTextView != null && workingSpinner != null)
                    {
                        autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(searchMagnifier, null, workingSpinner, null);
                        workingSpinner.setVisible(true, false);
                    }
                }

            
            {
                this$0 = FilterListener.this;
                super();
            }
            });
        }

        public void beforePublishResults(List list, boolean flag)
        {
            if ((list == null || flag) && autoCompleteTextView != null && workingSpinner != null)
            {
                workingSpinner.setVisible(false, false);
                autoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(searchMagnifier, null, null, null);
            }
        }

        public void setAdapter(RetailSearchSuggestionAdapter retailsearchsuggestionadapter)
        {
            adapter = retailsearchsuggestionadapter;
        }




        public FilterListener(ClearableAutoCompleteTextView clearableautocompletetextview, Drawable drawable, Drawable drawable1)
        {
            RetailSearchDaggerGraphController.inject(this);
            autoCompleteTextView = clearableautocompletetextview;
            workingSpinner = drawable;
            searchMagnifier = drawable1;
        }
    }

    public static class SearchSuggestionsItemListener
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

        public void onDeletePastSearchesClick(final String id, String s)
        {
            (new Thread(s. new Runnable() {

                final SearchSuggestionsItemListener this$0;
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
                this$0 = final_searchsuggestionsitemlistener;
                id = s;
                deleteURL = String.this;
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





        public SearchSuggestionsItemListener(ClearableAutoCompleteTextView clearableautocompletetextview, SuggestionDataProvider suggestiondataprovider, RetailSearchEntryContext retailsearchentrycontext)
        {
            searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
            RetailSearchDaggerGraphController.inject(this);
            autoCompleteTextView = clearableautocompletetextview;
            suggestionDataProvider = suggestiondataprovider;
            entryContext = retailsearchentrycontext;
        }
    }


    public static final String TAG = com/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry.getName();
    private RetailSearchSuggestionAdapter adapter;
    private RetailSearchEntryContext entryContext;
    private RetailSearchSuggestionFilter filter;
    private ClearableAutoCompleteTextView mAutoCompleteTextView;
    private InputMethodManager mInputManager;
    private final Set mQueryListeners;
    private Drawable searchMagnifier;
    private SuggestionDataProvider suggestionDataProvider;
    private Drawable workingSpinner;

    public RetailSearchQueryEntry(Context context)
    {
        this(context, null);
    }

    public RetailSearchQueryEntry(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RetailSearchQueryEntry(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mQueryListeners = new HashSet();
        suggestionDataProvider = new SuggestionDataProvider(context);
        mInputManager = (InputMethodManager)context.getSystemService("input_method");
        workingSpinner = context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_search_spinner);
        searchMagnifier = context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_search_bar_mag_glass);
        entryContext = new RetailSearchEntryContext();
        setUpViews();
        setUpAutoComplete();
        processAttributes(attributeset, i);
        setAddStatesFromChildren(true);
        setFocusable(false);
    }

    private void processAttributes(AttributeSet attributeset, int i)
    {
    }

    private void resetDropDownAnchor()
    {
        mAutoCompleteTextView.setDropDownAnchor(getId());
    }

    private void setUpAutoComplete()
    {
        mAutoCompleteTextView.setThreshold(0);
        mAutoCompleteTextView.enableClearTextButton(true);
        mAutoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(searchMagnifier, null, null, null);
        mAutoCompleteTextView.setHint(getResources().getString(com.amazon.retailsearch.R.string.rs_search));
        mAutoCompleteTextView.setClearTextButtonPadding(0, getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_action_bar_clear_button_padding_left));
        FilterListener filterlistener = new FilterListener(mAutoCompleteTextView, workingSpinner, searchMagnifier);
        SearchSuggestionsItemListener searchsuggestionsitemlistener = new SearchSuggestionsItemListener(mAutoCompleteTextView, suggestionDataProvider, entryContext);
        filter = new RetailSearchSuggestionFilter(suggestionDataProvider, "aps", mAutoCompleteTextView, entryContext, filterlistener);
        adapter = new RetailSearchSuggestionAdapter(getContext(), searchsuggestionsitemlistener, null);
        filterlistener.setAdapter(adapter);
        searchsuggestionsitemlistener.setFilter(filter);
        adapter.setFilter(filter);
        mAutoCompleteTextView.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final RetailSearchQueryEntry this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if ((i == 3 || keyevent == null || keyevent.getKeyCode() == 66) && mAutoCompleteTextView.getText() != null)
                {
                    if (!TextUtils.isEmpty(textview = mAutoCompleteTextView.getText().toString()))
                    {
                        if (textview.matches("^(\\*|\\s)*$"))
                        {
                            mAutoCompleteTextView.setText("");
                            return false;
                        }
                        textview = mAutoCompleteTextView.getText().toString();
                        QuerySubmitListener querysubmitlistener;
                        RetailSearchQuery retailsearchquery;
                        for (keyevent = mQueryListeners.iterator(); keyevent.hasNext(); querysubmitlistener.onQuerySubmit(retailsearchquery))
                        {
                            querysubmitlistener = (QuerySubmitListener)keyevent.next();
                            retailsearchquery = new RetailSearchQuery(textview);
                            retailsearchquery.setRawUserInput(textview);
                            retailsearchquery.setSource(QuerySource.NAV_BAR_INPUT);
                        }

                        return true;
                    }
                }
                return false;
            }

            
            {
                this$0 = RetailSearchQueryEntry.this;
                super();
            }
        });
        mAutoCompleteTextView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RetailSearchQueryEntry this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                view = (RetailSearchSuggestionRow)adapterview.getItemAtPosition(i);
                if (mQueryListeners != null)
                {
                    adapterview = Uri.parse(view.getIntentData()).buildUpon().build();
                    String s = adapterview.getQueryParameter("paramText");
                    String s1 = adapterview.getQueryParameter("paramSuggestionDepartmentFilter");
                    if (mAutoCompleteTextView.getText() == null)
                    {
                        adapterview = "";
                    } else
                    {
                        adapterview = mAutoCompleteTextView.getText().toString();
                    }
                    mAutoCompleteTextView.setText(s);
                    adapterview = new RetailSearchQuery(s1, s, adapterview, IssLogger.createLogData(view, entryContext.getSearchAlias(), s1, s, adapterview));
                    for (view = mQueryListeners.iterator(); view.hasNext(); ((QuerySubmitListener)view.next()).onQuerySubmit(adapterview)) { }
                }
            }

            
            {
                this$0 = RetailSearchQueryEntry.this;
                super();
            }
        });
        mAutoCompleteTextView.setClearButtonEventListener(new ClearButtonEventListener() {

            final RetailSearchQueryEntry this$0;

            public void onTextCleared()
            {
                openSearch();
            }

            
            {
                this$0 = RetailSearchQueryEntry.this;
                super();
            }
        });
    }

    private void setUpViews()
    {
        LayoutInflater.from(getContext()).inflate(com.amazon.retailsearch.R.layout.retail_search_query_entry, this, true);
        setOrientation(0);
        setGravity(16);
        mAutoCompleteTextView = (ClearableAutoCompleteTextView)findViewById(com.amazon.retailsearch.R.id.query_entry_autocomplete_text_view);
        resetDropDownAnchor();
    }

    public void addListener(android.view.View.OnFocusChangeListener onfocuschangelistener)
    {
        mAutoCompleteTextView.setOnFocusChangeListener(onfocuschangelistener);
    }

    public void addListener(QuerySubmitListener querysubmitlistener)
    {
        mQueryListeners.add(querysubmitlistener);
    }

    public void clearInputFocus()
    {
        mAutoCompleteTextView.clearFocus();
    }

    public void dismissSearch()
    {
        mInputManager.hideSoftInputFromWindow(getWindowToken(), 0);
        mAutoCompleteTextView.clearFocus();
    }

    public com.amazon.retailsearch.android.api.display.input.SearchEntry.ViewInfo getSearchBoxInfo()
    {
        com.amazon.retailsearch.android.api.display.input.SearchEntry.ViewInfo viewinfo = new com.amazon.retailsearch.android.api.display.input.SearchEntry.ViewInfo();
        int ai[] = new int[2];
        mAutoCompleteTextView.getLocationOnScreen(ai);
        viewinfo.setCoords(ai);
        viewinfo.setWidth(mAutoCompleteTextView.getWidth());
        viewinfo.setHeight(mAutoCompleteTextView.getHeight());
        return viewinfo;
    }

    public android.view.ViewGroup.LayoutParams getViewLayoutParams()
    {
        return getLayoutParams();
    }

    public boolean hasFocus()
    {
        return mAutoCompleteTextView.hasFocus();
    }

    public void hide()
    {
        setVisibility(8);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mAutoCompleteTextView.setAdapter(adapter);
    }

    public void onBackPressed()
    {
    }

    public void onDestroy()
    {
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public void onStart()
    {
    }

    public void onStop()
    {
    }

    public void openSearch()
    {
        mAutoCompleteTextView.requestFocus();
        mInputManager.showSoftInput(mAutoCompleteTextView, 0);
    }

    public void removeListener(android.view.View.OnFocusChangeListener onfocuschangelistener)
    {
        mAutoCompleteTextView.setOnFocusChangeListener(null);
    }

    public void removeListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        mAutoCompleteTextView.setOnLongClickListener(null);
    }

    public void removeListener(KeyPreImeListener keypreimelistener)
    {
        mAutoCompleteTextView.removeKeyPreImeListener();
    }

    public void removeListener(QuerySubmitListener querysubmitlistener)
    {
        mQueryListeners.remove(querysubmitlistener);
    }

    public void requestSearchBoxFocus()
    {
        mAutoCompleteTextView.requestFocus();
        mInputManager.showSoftInput(mAutoCompleteTextView, 0);
    }

    public void setListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        mAutoCompleteTextView.setOnLongClickListener(onlongclicklistener);
    }

    public void setListener(KeyPreImeListener keypreimelistener)
    {
        mAutoCompleteTextView.setKeyPreImeListener(keypreimelistener);
    }

    public void setQuery(String s)
    {
        mAutoCompleteTextView.setAdapter((RetailSearchSuggestionAdapter)null);
        mAutoCompleteTextView.setText(s);
        mAutoCompleteTextView.setAdapter(adapter);
        entryContext.setForceUpdatePastSearches(true);
    }

    public void setViewLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        setLayoutParams(layoutparams);
    }

    public void show()
    {
        setVisibility(0);
    }




}

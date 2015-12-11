// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.display.input.SearchEntry;
import com.amazon.retailsearch.android.api.display.input.listeners.ISSListener;
import com.amazon.retailsearch.android.api.display.input.listeners.KeyPreImeListener;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.api.query.QuerySource;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryContext;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionAdapter;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilter;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionFilterListener;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionRow;
import com.amazon.retailsearch.android.ui.entry.SuggestionRowModifier;
import com.amazon.retailsearch.android.ui.entry.SuggestionsItemListener;
import com.amazon.retailsearch.data.SuggestionDataProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.metrics.IssLogger;
import com.amazon.retailsearch.util.UrlUtils;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            SearchEntryAutocompleteTextView, ClearButtonEventListener

public class ClearableAutocompleteSearchEntry extends RelativeLayout
    implements SearchEntry
{
    public class FilterListener
        implements RetailSearchSuggestionFilterListener
    {

        private RetailSearchSuggestionAdapter adapter;
        final ClearableAutocompleteSearchEntry this$0;

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
        }

        public void beforePerformFiltering()
        {
            platform.invokeLater(new Runnable() {

                final FilterListener this$1;

                public void run()
                {
                    if (workingSpinner != null)
                    {
                        mAutoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(searchMagnifier, null, workingSpinner, null);
                        workingSpinner.setVisible(true, false);
                    }
                }

            
            {
                this$1 = FilterListener.this;
                super();
            }
            });
        }

        public void beforePublishResults(List list, boolean flag)
        {
            if ((list == null || flag) && workingSpinner != null)
            {
                workingSpinner.setVisible(false, false);
                mAutoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(searchMagnifier, null, null, null);
            }
        }

        public void setAdapter(RetailSearchSuggestionAdapter retailsearchsuggestionadapter)
        {
            adapter = retailsearchsuggestionadapter;
        }

        public FilterListener()
        {
            this$0 = ClearableAutocompleteSearchEntry.this;
            super();
        }
    }

    public class SearchSuggestionsItemListener
        implements SuggestionsItemListener
    {

        private RetailSearchSuggestionFilter filter;
        SearchBoxLogger searchBoxLogger;
        final ClearableAutocompleteSearchEntry this$0;

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
                    if (filter != null)
                    {
                        entryContext.setForceUpdatePastSearches(true);
                        filter.filter(mAutoCompleteTextView.getText());
                    }
                }

            
            {
                this$1 = final_searchsuggestionsitemlistener;
                id = s;
                deleteURL = String.this;
                super();
            }
            })).start();
        }

        public void onQueryBuilderClick(String s)
        {
            if (!TextUtils.isEmpty(s) && mAutoCompleteTextView.getText() != null && !s.equals(mAutoCompleteTextView.getText().toString()))
            {
                mAutoCompleteTextView.setText((new StringBuilder()).append(s).append(" ").toString());
                mAutoCompleteTextView.setSelection(s.length() + 1);
            }
        }

        public void setFilter(RetailSearchSuggestionFilter retailsearchsuggestionfilter)
        {
            filter = retailsearchsuggestionfilter;
        }


        public SearchSuggestionsItemListener()
        {
            this$0 = ClearableAutocompleteSearchEntry.this;
            super();
            searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
        }
    }


    private RetailSearchSuggestionAdapter adapter;
    private ClearButtonEventListener clearButtonEventListener;
    private RetailSearchEntryContext entryContext;
    private RetailSearchSuggestionFilter filter;
    private InputMethodManager inputManager;
    private ISSListener issListener;
    private KeyPreImeListener keyPreImeListener;
    private SearchEntryAutocompleteTextView mAutoCompleteTextView;
    private ImageView mClearTextButton;
    private final Set mQueryListeners;
    RetailSearchAndroidPlatform platform;
    private RetailSearchLogger retailSearchLogger;
    private SearchBoxLogger searchBoxLogger;
    private Drawable searchMagnifier;
    private String searchUri;
    private SuggestionDataProvider suggestionDataProvider;
    private Drawable workingSpinner;

    public ClearableAutocompleteSearchEntry(Context context)
    {
        this(context, null);
    }

    public ClearableAutocompleteSearchEntry(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ClearableAutocompleteSearchEntry(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mQueryListeners = new HashSet();
        init(context);
    }

    private void init(Context context)
    {
        if (isInEditMode())
        {
            return;
        } else
        {
            retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
            searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
            suggestionDataProvider = new SuggestionDataProvider(context);
            entryContext = new RetailSearchEntryContext();
            inputManager = (InputMethodManager)context.getSystemService("input_method");
            workingSpinner = context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_search_spinner);
            searchMagnifier = context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_search_bar_aui_mag_glass);
            RetailSearchDaggerGraphController.inject(this);
            return;
        }
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
        clearFocus();
    }

    public void dismissSearch()
    {
        inputManager.hideSoftInputFromWindow(getWindowToken(), 0);
        mAutoCompleteTextView.clearFocus();
    }

    public com.amazon.retailsearch.android.api.display.input.SearchEntry.ViewInfo getSearchBoxInfo()
    {
        com.amazon.retailsearch.android.api.display.input.SearchEntry.ViewInfo viewinfo = new com.amazon.retailsearch.android.api.display.input.SearchEntry.ViewInfo();
        int ai[] = new int[2];
        getLocationOnScreen(ai);
        viewinfo.setCoords(ai);
        viewinfo.setWidth(getWidth());
        viewinfo.setHeight(getHeight());
        return viewinfo;
    }

    public android.view.ViewGroup.LayoutParams getViewLayoutParams()
    {
        return getLayoutParams();
    }

    public boolean hasFocus()
    {
        return super.hasFocus();
    }

    public void hide()
    {
        setVisibility(8);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (mAutoCompleteTextView != null)
        {
            mAutoCompleteTextView.setAdapter(adapter);
        }
    }

    public void onBackPressed()
    {
    }

    public void onDestroy()
    {
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        if (isInEditMode())
        {
            return;
        }
        mAutoCompleteTextView = (SearchEntryAutocompleteTextView)findViewById(com.amazon.retailsearch.R.id.query_entry_autocomplete_text_view);
        mClearTextButton = (ImageView)findViewById(com.amazon.retailsearch.R.id.query_entry_clear_button);
        mAutoCompleteTextView.setCompoundDrawablesWithIntrinsicBounds(searchMagnifier, null, null, null);
        FilterListener filterlistener = new FilterListener();
        SearchSuggestionsItemListener searchsuggestionsitemlistener = new SearchSuggestionsItemListener();
        filter = new RetailSearchSuggestionFilter(suggestionDataProvider, "aps", mAutoCompleteTextView, entryContext, filterlistener);
        adapter = new RetailSearchSuggestionAdapter(getContext(), searchsuggestionsitemlistener, null, entryContext, filter);
        filterlistener.setAdapter(adapter);
        searchsuggestionsitemlistener.setFilter(filter);
        mAutoCompleteTextView.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final ClearableAutocompleteSearchEntry this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if ((i == 3 || keyevent == null || keyevent.getKeyCode() == 66) && mAutoCompleteTextView.getText() != null)
                {
                    if (!TextUtils.isEmpty(keyevent = mAutoCompleteTextView.getText().toString().trim()))
                    {
                        if (keyevent.matches("^(\\*|\\s)*$"))
                        {
                            mAutoCompleteTextView.setText("");
                            return false;
                        }
                        textview = new RetailSearchQuery(keyevent);
                        if (searchUri != null)
                        {
                            try
                            {
                                textview.setSearchUrl(UrlUtils.getSearchUrl(searchUri, keyevent));
                            }
                            catch (UnsupportedEncodingException unsupportedencodingexception) { }
                        }
                        textview.setRawUserInput(keyevent);
                        textview.setSource(QuerySource.NAV_BAR_INPUT);
                        textview.setRefTag(IssLogger.computeSubmitQueryRefTag(adapter.getSuggestionRows(), keyevent));
                        for (keyevent = mQueryListeners.iterator(); keyevent.hasNext(); ((QuerySubmitListener)keyevent.next()).onQuerySubmit(textview)) { }
                        searchUri = null;
                        return true;
                    }
                }
                return false;
            }

            
            {
                this$0 = ClearableAutocompleteSearchEntry.this;
                super();
            }
        });
        mAutoCompleteTextView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ClearableAutocompleteSearchEntry this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                view = (RetailSearchSuggestionRow)adapterview.getItemAtPosition(i);
                if (mQueryListeners != null)
                {
                    String s = view.getSuggestion();
                    String s1 = view.getSearchAlias();
                    if (view.getQuery() == null)
                    {
                        adapterview = "";
                    } else
                    {
                        adapterview = view.getQuery();
                    }
                    mAutoCompleteTextView.setText(s);
                    view = new RetailSearchQuery(s1, s, adapterview, IssLogger.createLogData(view, entryContext.getSearchAlias(), s1, s, adapterview));
                    view.setRefTag(IssLogger.computeSelectRefTag(adapter.getSuggestionRows(), i, adapterview));
                    for (adapterview = mQueryListeners.iterator(); adapterview.hasNext(); ((QuerySubmitListener)adapterview.next()).onQuerySubmit(view)) { }
                }
            }

            
            {
                this$0 = ClearableAutocompleteSearchEntry.this;
                super();
            }
        });
        mAutoCompleteTextView.addTextChangedListener(new TextWatcher() {

            final ClearableAutocompleteSearchEntry this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (!TextUtils.isEmpty(charsequence))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i != 0)
                {
                    mClearTextButton.setVisibility(0);
                } else
                {
                    mClearTextButton.setVisibility(8);
                }
                if (entryContext != null && !entryContext.isFirstKeystrokeLogged() && i != 0)
                {
                    searchBoxLogger.searchSuggestionsFirstKeyStroke();
                    entryContext.setIsFirstKeystrokeLogged(true);
                }
            }

            
            {
                this$0 = ClearableAutocompleteSearchEntry.this;
                super();
            }
        });
        mClearTextButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ClearableAutocompleteSearchEntry this$0;

            public void onClick(View view)
            {
                mAutoCompleteTextView.setText("");
                if (clearButtonEventListener != null)
                {
                    clearButtonEventListener.onTextCleared();
                }
            }

            
            {
                this$0 = ClearableAutocompleteSearchEntry.this;
                super();
            }
        });
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mAutoCompleteTextView.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

                final ClearableAutocompleteSearchEntry this$0;

                public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                        int k1, int l1)
                {
                    if (i == 0 && j == 0 && k == 0 && l == 0)
                    {
                        return;
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 21)
                    {
                        mAutoCompleteTextView.setDropDownBackgroundResource(com.amazon.retailsearch.R.drawable.retail_search_dropdown_border);
                    }
                    mAutoCompleteTextView.setDropDownWidth((mAutoCompleteTextView.getWidth() + mClearTextButton.getWidth()) - mClearTextButton.getPaddingRight());
                }

            
            {
                this$0 = ClearableAutocompleteSearchEntry.this;
                super();
            }
            });
        }
        setClearButtonEventListener(new ClearButtonEventListener() {

            final ClearableAutocompleteSearchEntry this$0;

            public void onTextCleared()
            {
                openSearch();
            }

            
            {
                this$0 = ClearableAutocompleteSearchEntry.this;
                super();
            }
        });
        post(new Runnable() {

            final ClearableAutocompleteSearchEntry this$0;

            public void run()
            {
                mAutoCompleteTextView.setPadding(mAutoCompleteTextView.getPaddingLeft(), mAutoCompleteTextView.getPaddingTop(), mAutoCompleteTextView.getPaddingRight() + mClearTextButton.getWidth(), mAutoCompleteTextView.getPaddingBottom());
                mClearTextButton.setVisibility(8);
            }

            
            {
                this$0 = ClearableAutocompleteSearchEntry.this;
                super();
            }
        });
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (keyPreImeListener != null && keyPreImeListener.onKeyPreIme(i, keyevent))
        {
            return true;
        } else
        {
            return super.onKeyPreIme(i, keyevent);
        }
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
        inputManager.showSoftInput(this, 0);
    }

    public void removeKeyPreImeListener()
    {
        keyPreImeListener = null;
    }

    public void removeListener(android.view.View.OnFocusChangeListener onfocuschangelistener)
    {
        mAutoCompleteTextView.setOnFocusChangeListener(null);
    }

    public void removeListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        mAutoCompleteTextView.setOnLongClickListener(null);
    }

    public void removeListener(ISSListener isslistener)
    {
        issListener = null;
    }

    public void removeListener(KeyPreImeListener keypreimelistener)
    {
        removeKeyPreImeListener();
    }

    public void removeListener(QuerySubmitListener querysubmitlistener)
    {
        mQueryListeners.remove(querysubmitlistener);
    }

    public void requestSearchBoxFocus()
    {
        requestFocus();
        inputManager.showSoftInput(this, 0);
    }

    public void setClearButtonEventListener(ClearButtonEventListener clearbuttoneventlistener)
    {
        clearButtonEventListener = clearbuttoneventlistener;
    }

    public void setHint(String s)
    {
        mAutoCompleteTextView.setHint(s);
        mAutoCompleteTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
    }

    public void setKeyPreImeListener(KeyPreImeListener keypreimelistener)
    {
        keyPreImeListener = keypreimelistener;
    }

    public void setListener(android.view.View.OnLongClickListener onlongclicklistener)
    {
        mAutoCompleteTextView.setOnLongClickListener(onlongclicklistener);
    }

    public void setListener(ISSListener isslistener)
    {
        issListener = isslistener;
    }

    public void setListener(KeyPreImeListener keypreimelistener)
    {
        setKeyPreImeListener(keypreimelistener);
    }

    public void setQuery(String s)
    {
        mAutoCompleteTextView.setAdapter((RetailSearchSuggestionAdapter)null);
        mAutoCompleteTextView.setText(s);
        mAutoCompleteTextView.setAdapter(adapter);
        entryContext.setForceUpdatePastSearches(true);
    }

    public void setSearchUri(String s)
    {
        searchUri = s;
    }

    public void setViewLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        setLayoutParams(layoutparams);
    }

    public void show()
    {
        setVisibility(0);
    }





/*
    static String access$102(ClearableAutocompleteSearchEntry clearableautocompletesearchentry, String s)
    {
        clearableautocompletesearchentry.searchUri = s;
        return s;
    }

*/










}

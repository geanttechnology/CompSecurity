// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.SearchView;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.controllers.SavedSearchController;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.adapters.SearchSuggestionsAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.SearchSuggestionsManager;
import com.poshmark.data_model.models.SuggestedSearchItem;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.PMSearchBoxTimer;
import com.poshmark.utils.PMSearchViewListener;
import com.poshmark.utils.SearchFilterModel;

public class PMSearchView extends SearchView
{

    Activity activity;
    SearchSuggestionsAdapter adapter;
    boolean bShowRecentsByDefault;
    android.view.View.OnClickListener clearAllButtonListener;
    String currentSearchString;
    PMSearchViewListener parentListener;
    AutoCompleteTextView searchEditText;
    android.widget.SearchView.OnQueryTextListener searchListener;
    android.widget.SearchView.OnSuggestionListener suggestionListener;
    SearchSuggestionsManager suggestionsData;

    public PMSearchView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bShowRecentsByDefault = true;
        searchListener = new android.widget.SearchView.OnQueryTextListener() {

            final PMSearchView this$0;

            public boolean onQueryTextChange(String s)
            {
                if ((s == null || s.length() == 0) && parentListener != null)
                {
                    parentListener.clearSearchString();
                }
                return false;
            }

            public boolean onQueryTextSubmit(String s)
            {
                SuggestedSearchItem suggestedsearchitem = new SuggestedSearchItem();
                suggestedsearchitem.kw = s.trim();
                suggestedsearchitem.type = "kw";
                launchSearch(suggestedsearchitem, true);
                setQuery(null, false);
                return true;
            }

            
            {
                this$0 = PMSearchView.this;
                super();
            }
        };
        suggestionListener = new android.widget.SearchView.OnSuggestionListener() {

            final PMSearchView this$0;

            public boolean onSuggestionClick(int i)
            {
                Object obj = (CustomMatrixCursor)adapter.getCursor();
                if (((CustomMatrixCursor) (obj)).moveToPosition(i))
                {
                    obj = (SuggestedSearchItem)((CustomMatrixCursor) (obj)).get(((CustomMatrixCursor) (obj)).getColumnIndex(PMData.DATA_COL));
                    setQuery(null, false);
                    launchSearch(((SuggestedSearchItem) (obj)), false);
                }
                return true;
            }

            public boolean onSuggestionSelect(int i)
            {
                return false;
            }

            
            {
                this$0 = PMSearchView.this;
                super();
            }
        };
        clearAllButtonListener = new android.view.View.OnClickListener() {

            final PMSearchView this$0;

            public void onClick(View view)
            {
                SavedSearchController.getGlobalSavedSearchController().clearAll();
                setQuery(getQuery(), false);
            }

            
            {
                this$0 = PMSearchView.this;
                super();
            }
        };
        activity = (Activity)context;
        adapter = new SearchSuggestionsAdapter(context, null, 0x80000000, clearAllButtonListener);
        setupSearchBar();
    }

    private void setupSearchBar()
    {
        setSearchableInfo(((SearchManager)activity.getSystemService("search")).getSearchableInfo(activity.getComponentName()));
        suggestionsData = new SearchSuggestionsManager();
        suggestionsData.setListAdapter(adapter);
        updateAutoCompleteView();
        setSuggestionsAdapter(adapter);
        setOnQueryTextListener(searchListener);
        setOnSuggestionListener(suggestionListener);
        clearFocus();
        int i = activity.getResources().getIdentifier("android:id/search_src_text", null, null);
        if (i != 0)
        {
            clearFocus();
            searchEditText = (AutoCompleteTextView)findViewById(i);
        }
    }

    private void updateAutoCompleteView()
    {
        adapter.setFilterQueryProvider(new FilterQueryProvider() {

            final PMSearchView this$0;

            public Cursor runQuery(CharSequence charsequence)
            {
                charsequence = adapter.getCursor();
                String s = getQuery().toString();
                if (s != null)
                {
                    s = s.toString().trim();
                    if (s.length() > 0)
                    {
                        currentSearchString = s;
                        new PMSearchBoxTimer(50, true, s, s. new com.poshmark.utils.PMSearchBoxTimer.PMSearchTimerTaskCallback() {

                            final _cls1 this$1;
                            final String val$newText;

                            public void timerCallback(String s)
                            {
                                if (currentSearchString.equals(s))
                                {
                                    suggestionsData.fillFilteredCursor(newText);
                                }
                            }

            
            {
                this$1 = final__pcls1;
                newText = String.this;
                super();
            }
                        });
                        return charsequence;
                    }
                    if (bShowRecentsByDefault)
                    {
                        return suggestionsData.fillCursorWithRecents();
                    }
                    if (charsequence != null)
                    {
                        charsequence.close();
                    }
                    return new CustomMatrixCursor(new String[] {
                        PMData.ID_COL, PMData.DATA_COL
                    });
                }
                if (bShowRecentsByDefault)
                {
                    return suggestionsData.fillCursorWithRecents();
                }
                if (charsequence != null)
                {
                    charsequence.close();
                }
                return new CustomMatrixCursor(new String[] {
                    PMData.ID_COL, PMData.DATA_COL
                });
            }

            
            {
                this$0 = PMSearchView.this;
                super();
            }
        });
    }

    public void commit()
    {
    }

    public String getUserInput()
    {
        return currentSearchString;
    }

    public void launchSearch(SuggestedSearchItem suggestedsearchitem, boolean flag)
    {
        Object obj = adapter.getCursor();
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        boolean flag1 = GlobalDbController.getGlobalDbController().isKeywordInSavedSearches(suggestedsearchitem.kw);
        GlobalDbController.getGlobalDbController().addNewSearchToSavedSearches(suggestedsearchitem.kw);
        obj = new SearchFilterModel();
        ((SearchFilterModel) (obj)).setAvailability("available");
        UserStateSummary userstatesummary = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
        if (userstatesummary != null && userstatesummary.user_info.isMySizeAvailable())
        {
            ((SearchFilterModel) (obj)).enableMySizeFilter(true);
        }
        ((SearchFilterModel) (obj)).setQueryText(suggestedsearchitem.kw);
        ((SearchFilterModel) (obj)).setSearchTrigger("sl");
        ((SearchFilterModel) (obj)).setFacet("category_v2");
        ((SearchFilterModel) (obj)).setFacet("brand");
        ((SearchFilterModel) (obj)).setFacet("size");
        suggestedsearchitem = (PMContainerActivity)activity;
        suggestedsearchitem = new Bundle();
        suggestedsearchitem.putString("SEARCH_TRIGGER", "sl");
        if (flag)
        {
            suggestedsearchitem.putString("KEYWORD_SOURCE", "dir");
        } else
        if (flag1)
        {
            suggestedsearchitem.putString("KEYWORD_SOURCE", "hst");
        } else
        {
            suggestedsearchitem.putString("KEYWORD_SOURCE", "ac");
        }
        if (parentListener != null)
        {
            parentListener.fireKeywordSearch(suggestedsearchitem, ((SearchFilterModel) (obj)), false);
        }
    }

    public void setParentListener(PMSearchViewListener pmsearchviewlistener)
    {
        parentListener = pmsearchviewlistener;
    }

    public void setSilentText(String s)
    {
        clearFocus();
        setSuggestionsAdapter(null);
        setQuery(s, false);
        setSuggestionsAdapter(adapter);
    }

    public void setupEditView()
    {
        int i = activity.getResources().getIdentifier("android:id/search_src_text", null, null);
        if (i != 0)
        {
            EditText edittext = (EditText)findViewById(i);
            edittext.setTextColor(getResources().getColor(0x7f090035));
            edittext.setHintTextColor(getResources().getColor(0x7f090039));
            edittext.setInputType(16384);
            edittext.setTextSize(2, 13F);
        }
    }

    public void showRecentsAsDefault(boolean flag)
    {
        bShowRecentsByDefault = flag;
        searchEditText.showDropDown();
    }
}

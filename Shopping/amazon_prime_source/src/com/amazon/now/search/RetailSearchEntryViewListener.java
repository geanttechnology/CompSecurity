// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.search;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.amazon.now.permissions.PermissionsHelper;
import com.amazon.now.util.LocationUtil;
import com.amazon.retailsearch.android.api.query.Query;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionRow;
import com.amazon.retailsearch.android.ui.entry.SearchEntryViewListener;
import com.amazon.retailsearch.android.ui.entry.SuggestionRowModifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.amazon.now.search:
//            SearchActivity, SearchIntentBuilder

public class RetailSearchEntryViewListener
    implements SearchEntryViewListener
{

    private SearchActivity mSearchActivity;

    public RetailSearchEntryViewListener(SearchActivity searchactivity)
    {
        mSearchActivity = searchactivity;
    }

    protected String getCurrentDepartmentFilter()
    {
        return SearchActivity.getCurrentDepartmentFilter();
    }

    public boolean onDispatchKeyEventPreIme(KeyEvent keyevent, Context context)
    {
        if (keyevent.getKeyCode() == 4 && mSearchActivity != null && keyevent.getAction() == 0)
        {
            mSearchActivity.popView();
        }
        return false;
    }

    public void onQueryCleared()
    {
        SearchActivity.setPreviousSearchTerm("");
    }

    public volatile void onQuerySubmit(Query query)
    {
        onQuerySubmit((RetailSearchQuery)query);
    }

    public void onQuerySubmit(RetailSearchQuery retailsearchquery)
    {
        if (retailsearchquery == null || TextUtils.isEmpty(retailsearchquery.getKeywords()))
        {
            return;
        }
        if (retailsearchquery.getKeywords().equals("VOICE_SEARCH_QUERY_KEYWORD"))
        {
            PermissionsHelper.launchVoiceSearch(mSearchActivity);
            return;
        }
        String s;
        if (retailsearchquery.isAps())
        {
            s = getCurrentDepartmentFilter();
        } else
        {
            s = retailsearchquery.getAlias();
        }
        retailsearchquery = (new SearchIntentBuilder(mSearchActivity)).retailSearchQuery(retailsearchquery).query(retailsearchquery.getKeywords()).filter(s).categoryName(s).build();
        mSearchActivity.doSearch(retailsearchquery);
    }

    public void preRenderSuggestions(SuggestionRowModifier suggestionrowmodifier)
    {
        final List whitelist = LocationUtil.getSearchAliasWhitelist();
        if (whitelist == null || LocationUtil.getStoreCount() == 0)
        {
            return;
        }
        Object obj = new LinkedList();
        Iterator iterator = suggestionrowmodifier.getList().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            RetailSearchSuggestionRow retailsearchsuggestionrow = (RetailSearchSuggestionRow)iterator.next();
            if (!whitelist.contains(retailsearchsuggestionrow.getSearchAlias()))
            {
                ((List) (obj)).add(retailsearchsuggestionrow);
            }
        } while (true);
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); suggestionrowmodifier.remove((RetailSearchSuggestionRow)((Iterator) (obj)).next())) { }
        suggestionrowmodifier.sort(new Comparator() {

            final RetailSearchEntryViewListener this$0;
            final List val$whitelist;

            public int compare(RetailSearchSuggestionRow retailsearchsuggestionrow1, RetailSearchSuggestionRow retailsearchsuggestionrow2)
            {
                if (retailsearchsuggestionrow1.getSuggestionType() == com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.PAST_SEARCHES || retailsearchsuggestionrow1.getSuggestionType() == com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED)
                {
                    return -1;
                }
                if (retailsearchsuggestionrow2.getSuggestionType() == com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.PAST_SEARCHES || retailsearchsuggestionrow2.getSuggestionType() == com.amazon.retailsearch.data.SuggestionDataItem.SuggestionType.MERGED)
                {
                    return 1;
                } else
                {
                    return whitelist.indexOf(retailsearchsuggestionrow1.getSearchAlias()) - whitelist.indexOf(retailsearchsuggestionrow2.getSearchAlias());
                }
            }

            public volatile int compare(Object obj1, Object obj2)
            {
                return compare((RetailSearchSuggestionRow)obj1, (RetailSearchSuggestionRow)obj2);
            }

            
            {
                this$0 = RetailSearchEntryViewListener.this;
                whitelist = list;
                super();
            }
        });
    }
}

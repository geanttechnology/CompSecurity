// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemBuildListener;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemFocusListener;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemSelectionListener;
import com.amazon.retailsearch.android.api.display.results.listeners.SearchChangedListener;
import com.amazon.retailsearch.android.api.display.results.listeners.SearchPageLoadListener;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.data.SearchTask;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.metrics.DetailPageType;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.retailsearch.util.UrlUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            UserInteractionListener, SearchDataSource

public class SearchUserInteractionListener
    implements UserInteractionListener
{

    SearchDataSource dataSource;
    UserPreferenceManager preferenceManager;
    private Set resultItemBuildListeners;
    private Set resultItemFocusListeners;
    private Set resultItemSelectionListeners;
    private RetailSearchLogger retailSearchLogger;
    private Set searchChangedListener;
    private Set searchPageLoadListeners;
    private String selectedAsin;

    public SearchUserInteractionListener()
    {
        resultItemSelectionListeners = new HashSet(1);
        resultItemBuildListeners = new HashSet(1);
        searchPageLoadListeners = new HashSet(1);
        resultItemFocusListeners = new HashSet();
        searchChangedListener = new HashSet();
        selectedAsin = null;
        RetailSearchDaggerGraphController.inject(this);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
    }

    public void addListener(ResultItemBuildListener resultitembuildlistener)
    {
        resultItemBuildListeners.add(resultitembuildlistener);
    }

    public void addListener(ResultItemFocusListener resultitemfocuslistener)
    {
        resultItemFocusListeners.add(resultitemfocuslistener);
    }

    public void addListener(ResultItemSelectionListener resultitemselectionlistener)
    {
        resultItemSelectionListeners.add(resultitemselectionlistener);
    }

    public void addListener(SearchChangedListener searchchangedlistener)
    {
        searchChangedListener.add(searchchangedlistener);
    }

    public void addListener(SearchPageLoadListener searchpageloadlistener)
    {
        searchPageLoadListeners.add(searchpageloadlistener);
    }

    public void endPage(View view)
    {
        for (Iterator iterator = searchPageLoadListeners.iterator(); iterator.hasNext(); ((SearchPageLoadListener)iterator.next()).endPage(view)) { }
    }

    public String getSelectedAsin()
    {
        return selectedAsin;
    }

    public void removeAllListeners()
    {
        resultItemSelectionListeners.clear();
        resultItemBuildListeners.clear();
        searchPageLoadListeners.clear();
        resultItemFocusListeners.clear();
        searchChangedListener.clear();
        selectedAsin = null;
    }

    public void removeListener(ResultItemBuildListener resultitembuildlistener)
    {
        resultItemSelectionListeners.remove(resultitembuildlistener);
    }

    public void removeListener(ResultItemFocusListener resultitemfocuslistener)
    {
        resultItemFocusListeners.remove(resultitemfocuslistener);
    }

    public void removeListener(ResultItemSelectionListener resultitemselectionlistener)
    {
        resultItemSelectionListeners.remove(resultitemselectionlistener);
    }

    public void removeListener(SearchChangedListener searchchangedlistener)
    {
        searchChangedListener.remove(searchchangedlistener);
    }

    public void removeListener(SearchPageLoadListener searchpageloadlistener)
    {
        searchPageLoadListeners.remove(searchpageloadlistener);
    }

    public void resultItemBuilt(ViewGroup viewgroup, ImageView imageview, String s)
    {
        for (Iterator iterator = resultItemBuildListeners.iterator(); iterator.hasNext(); ((ResultItemBuildListener)iterator.next()).onResultItemBuilt(viewgroup, imageview, s)) { }
    }

    public void resultItemSelected(RetailSearchResultItem retailsearchresultitem, DetailPageType detailpagetype)
    {
        String s;
        int j;
        if (retailsearchresultitem != null)
        {
            s = retailsearchresultitem.getAsin();
        } else
        {
            s = null;
        }
        selectedAsin = s;
        retailSearchLogger.recordDetailPageTransition(preferenceManager.getViewType().getName(), detailpagetype);
        detailpagetype = ((DetailPageType) (resultItemSelectionListeners.toArray()));
        j = detailpagetype.length;
        for (int i = 0; i < j; i++)
        {
            ((ResultItemSelectionListener)detailpagetype[i]).onResultItemSelected(retailsearchresultitem);
        }

    }

    public void retrySearch()
    {
        dataSource.getCurrentSearch().retry();
    }

    public void search(String s)
    {
        dataSource.submitQuery(s);
        dataSource.stageLastQuery();
        s = UrlUtils.getKeywords(s);
        if (!TextUtils.isEmpty(s))
        {
            Iterator iterator = searchChangedListener.iterator();
            while (iterator.hasNext()) 
            {
                ((SearchChangedListener)iterator.next()).onKeywordChanged(s);
            }
        }
    }

    public void startPage(View view, int i)
    {
        for (Iterator iterator = searchPageLoadListeners.iterator(); iterator.hasNext(); ((SearchPageLoadListener)iterator.next()).startPage(view, i)) { }
    }
}

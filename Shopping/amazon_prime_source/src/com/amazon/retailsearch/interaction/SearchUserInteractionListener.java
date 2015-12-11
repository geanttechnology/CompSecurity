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
import com.amazon.retailsearch.android.api.display.results.listeners.SearchQuerySubmitListener;
import com.amazon.retailsearch.android.api.display.results.listeners.UrlLoadListener;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.buttons.AddToCartState;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.data.SearchTask;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.metrics.DetailPageType;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.retailsearch.util.UrlUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            UserInteractionListener, AddToCartInteractionListener, SearchDataSource

public class SearchUserInteractionListener
    implements UserInteractionListener
{

    private Set addToCartInteractionListener;
    SearchDataSource dataSource;
    UserPreferenceManager preferenceManager;
    private Set resultItemBuildListeners;
    private Set resultItemFocusListeners;
    private Set resultItemSelectionListeners;
    private RetailSearchLogger retailSearchLogger;
    private Set searchChangedListener;
    private Set searchPageLoadListeners;
    private Set searchQuerySubmitListeners;
    private String selectedAsin;
    private Set urlLoadListeners;

    public SearchUserInteractionListener()
    {
        resultItemSelectionListeners = new HashSet(1);
        resultItemBuildListeners = new HashSet(1);
        searchPageLoadListeners = new HashSet(1);
        resultItemFocusListeners = new HashSet(1);
        searchChangedListener = new HashSet(1);
        addToCartInteractionListener = new HashSet(1);
        urlLoadListeners = new HashSet(1);
        searchQuerySubmitListeners = new HashSet(1);
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

    public void addListener(SearchQuerySubmitListener searchquerysubmitlistener)
    {
        searchQuerySubmitListeners.add(searchquerysubmitlistener);
    }

    public void addListener(UrlLoadListener urlloadlistener)
    {
        urlLoadListeners.add(urlloadlistener);
    }

    public void addListener(AddToCartInteractionListener addtocartinteractionlistener)
    {
        addToCartInteractionListener.add(addtocartinteractionlistener);
    }

    public void addToCart(String s, String s1, String s2, String s3, String s4, int i, AddToCartInteractionListener.SearchCartCallback searchcartcallback)
    {
        retailSearchLogger.recordInlineAddToCartInvoked();
        AddToCartInteractionListener aaddtocartinteractionlistener[] = (AddToCartInteractionListener[])addToCartInteractionListener.toArray(new AddToCartInteractionListener[0]);
        int k = aaddtocartinteractionlistener.length;
        for (int j = 0; j < k; j++)
        {
            aaddtocartinteractionlistener[j].addToCart(s, s1, s2, s3, s4, i, searchcartcallback);
        }

    }

    public void endPage(View view)
    {
        SearchPageLoadListener asearchpageloadlistener[] = (SearchPageLoadListener[])searchPageLoadListeners.toArray(new SearchPageLoadListener[0]);
        int j = asearchpageloadlistener.length;
        for (int i = 0; i < j; i++)
        {
            asearchpageloadlistener[i].endPage(view);
        }

    }

    public void endResult()
    {
        SearchPageLoadListener asearchpageloadlistener[] = (SearchPageLoadListener[])searchPageLoadListeners.toArray(new SearchPageLoadListener[0]);
        int j = asearchpageloadlistener.length;
        for (int i = 0; i < j; i++)
        {
            asearchpageloadlistener[i].endResult();
        }

    }

    public String getSelectedAsin()
    {
        return selectedAsin;
    }

    public void loadUrl(String s)
    {
        UrlLoadListener aurlloadlistener[] = (UrlLoadListener[])urlLoadListeners.toArray(new UrlLoadListener[0]);
        int j = aurlloadlistener.length;
        for (int i = 0; i < j; i++)
        {
            aurlloadlistener[i].onUrlLoad(s);
        }

    }

    public void removeAllListeners()
    {
        resultItemSelectionListeners.clear();
        resultItemBuildListeners.clear();
        searchPageLoadListeners.clear();
        resultItemFocusListeners.clear();
        searchChangedListener.clear();
        addToCartInteractionListener.clear();
        urlLoadListeners.clear();
        searchQuerySubmitListeners.clear();
        selectedAsin = null;
    }

    public void removeListener(ResultItemBuildListener resultitembuildlistener)
    {
        resultItemBuildListeners.remove(resultitembuildlistener);
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

    public void removeListener(SearchQuerySubmitListener searchquerysubmitlistener)
    {
        searchQuerySubmitListeners.remove(searchquerysubmitlistener);
    }

    public void removeListener(UrlLoadListener urlloadlistener)
    {
        urlLoadListeners.remove(urlloadlistener);
    }

    public void removeListener(AddToCartInteractionListener addtocartinteractionlistener)
    {
        addToCartInteractionListener.remove(addtocartinteractionlistener);
    }

    public void resultItemBuilt(ViewGroup viewgroup, ImageView imageview, String s)
    {
        ResultItemBuildListener aresultitembuildlistener[] = (ResultItemBuildListener[])resultItemBuildListeners.toArray(new ResultItemBuildListener[0]);
        int j = aresultitembuildlistener.length;
        for (int i = 0; i < j; i++)
        {
            aresultitembuildlistener[i].onResultItemBuilt(viewgroup, imageview, s);
        }

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
        retailSearchLogger.recordDetailPageTransition(preferenceManager.getResultLayoutType().getName(), detailpagetype);
        detailpagetype = (ResultItemSelectionListener[])resultItemSelectionListeners.toArray(new ResultItemSelectionListener[0]);
        j = detailpagetype.length;
        for (int i = 0; i < j; i++)
        {
            detailpagetype[i].onResultItemSelected(retailsearchresultitem);
        }

    }

    public void retrySearch()
    {
        dataSource.getCurrentSearch().retry();
    }

    public void search(String s)
    {
        dataSource.submitQuery(s);
        for (Iterator iterator = searchQuerySubmitListeners.iterator(); iterator.hasNext(); ((SearchQuerySubmitListener)iterator.next()).onQuerySubmit(s)) { }
        dataSource.stageLastQuery();
        String s1 = UrlUtils.getKeywords(s);
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = "";
        }
        for (Iterator iterator1 = searchChangedListener.iterator(); iterator1.hasNext(); ((SearchChangedListener)iterator1.next()).onKeywordChanged(s)) { }
    }

    public void startPage(View view, int i)
    {
        SearchPageLoadListener asearchpageloadlistener[] = (SearchPageLoadListener[])searchPageLoadListeners.toArray(new SearchPageLoadListener[0]);
        int k = asearchpageloadlistener.length;
        for (int j = 0; j < k; j++)
        {
            asearchpageloadlistener[j].startPage(view, i);
        }

    }

    public void startResult()
    {
        SearchPageLoadListener asearchpageloadlistener[] = (SearchPageLoadListener[])searchPageLoadListeners.toArray(new SearchPageLoadListener[0]);
        int j = asearchpageloadlistener.length;
        for (int i = 0; i < j; i++)
        {
            asearchpageloadlistener[i].startResult();
        }

    }

    public void updateCartState(String s, String s1, String s2, AddToCartState addtocartstate)
    {
        AddToCartInteractionListener aaddtocartinteractionlistener[] = (AddToCartInteractionListener[])addToCartInteractionListener.toArray(new AddToCartInteractionListener[0]);
        int j = aaddtocartinteractionlistener.length;
        for (int i = 0; i < j; i++)
        {
            aaddtocartinteractionlistener[i].updateCartState(s, s1, s2, addtocartstate);
        }

    }

    public void updateQuantity(String s, String s1, String s2, String s3, int i, AddToCartInteractionListener.SearchCartCallback searchcartcallback)
    {
        AddToCartInteractionListener aaddtocartinteractionlistener[] = (AddToCartInteractionListener[])addToCartInteractionListener.toArray(new AddToCartInteractionListener[0]);
        int k = aaddtocartinteractionlistener.length;
        for (int j = 0; j < k; j++)
        {
            aaddtocartinteractionlistener[j].updateQuantity(s, s1, s2, s3, i, searchcartcallback);
        }

    }
}

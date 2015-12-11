// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.widget.AdapterView;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.PreloadImages;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.RelatedSearches;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout, StackView, StackLayoutState

private class <init> extends com.amazon.retailsearch.data.Listener
{

    final StackLayout this$0;

    public void categoryCorrected(CategoryCorrected categorycorrected)
    {
        int _tmp = StackLayout.access$1108(StackLayout.this);
        addCategoryCorrected(categorycorrected, StackLayout.access$1100(StackLayout.this));
        update();
    }

    public void clearError()
    {
        StackLayout.this.clearError();
        update();
    }

    public void didYouMean(DidYouMean didyoumean)
    {
        addDidYouMean(didyoumean);
        update();
    }

    public void endPage()
    {
        hideProgressBar();
        userInteractionListener.endPage(getProgressBar());
        if (StackLayout.access$1000(StackLayout.this) && loaderScrollListener != null)
        {
            loaderScrollListener.processView((AdapterView)stackView, true);
        }
    }

    public void endResult()
    {
        StackLayout.this.endResult();
        update();
    }

    public void error(Exception exception)
    {
        addError(exception);
        update();
    }

    public void fkmr(FKMR fkmr1)
    {
        int _tmp = StackLayout.access$1108(StackLayout.this);
        addFkmr(fkmr1, StackLayout.access$1100(StackLayout.this));
        update();
    }

    public void noResultsSet(NoResultsSet noresultsset)
    {
        addNoResultsSet(noresultsset);
        update();
    }

    public void preloadImages(PreloadImages preloadimages)
    {
        StackLayout.this.preloadImages(preloadimages);
    }

    public void product(Product product1)
    {
        addProductWrapper(product1);
        showProducts(false);
        update();
    }

    public void ready()
    {
        if (StackLayout.access$1000(StackLayout.this) && stackView.getView() != null)
        {
            loadAtBottom(stackView.getFirstVisiblePosition(), stackView.getLastVisiblePosition());
        }
    }

    public void relatedSearches(RelatedSearches relatedsearches)
    {
        addRelatedSearches(relatedsearches);
        update();
    }

    public void spellCorrected(SpellCorrected spellcorrected)
    {
        int _tmp = StackLayout.access$1108(StackLayout.this);
        addSpellCorrected(spellcorrected, StackLayout.access$1100(StackLayout.this));
        update();
    }

    public void startPage()
    {
        StackLayout.this.startPage();
        showProgressBar();
        update();
        userInteractionListener.startPage(getProgressBar(), StackLayout.access$500(StackLayout.this).getProductCount());
    }

    public void wordSplitter(SpellCorrected spellcorrected)
    {
        int _tmp = StackLayout.access$1108(StackLayout.this);
        addWordSplitter(spellcorrected, StackLayout.access$1100(StackLayout.this));
        update();
    }

    private ollListener()
    {
        this$0 = StackLayout.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

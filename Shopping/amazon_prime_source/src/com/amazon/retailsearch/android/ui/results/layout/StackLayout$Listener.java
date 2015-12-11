// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import android.widget.AdapterView;
import com.amazon.retailsearch.android.ui.results.layout.model.ImageSparkleModel;
import com.amazon.retailsearch.android.ui.results.layout.model.MixedCorrectionsModel;
import com.amazon.retailsearch.android.ui.results.layout.view.ResultsCountView;
import com.amazon.retailsearch.data.search.SearchLoaderLogger;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.PreloadImages;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.QuartzBacklink;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.RelatedSearches;
import com.amazon.searchapp.retailsearch.model.ResultsMetadata;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout, StackView, StackLayoutState

private class <init> extends com.amazon.retailsearch.data.Listener
{

    final StackLayout this$0;

    public void categoryCorrected(CategoryCorrected categorycorrected)
    {
        int _tmp = StackLayout.access$1408(StackLayout.this);
        addCategoryCorrected(categorycorrected, StackLayout.access$1400(StackLayout.this));
        update();
    }

    public void clearError()
    {
        StackLayout.this.clearError();
        update();
    }

    public void didYouMean(DidYouMean didyoumean)
    {
        StackLayout.access$1100(StackLayout.this).setDidYouMean(didyoumean);
        addMixedCorrections(StackLayout.access$1100(StackLayout.this));
        update();
    }

    public void endPage()
    {
        hideProgressBar();
        userInteractionListener.endPage(getProgressBar());
        if (StackLayout.access$1300(StackLayout.this) && loaderScrollListener != null)
        {
            loaderScrollListener.processView((AdapterView)stackView, true);
        }
    }

    public void endParse(SearchResult searchresult)
    {
        super.endParse(searchresult);
        if (searchDataSource.getSearchLoaderLogger() != null)
        {
            searchDataSource.getSearchLoaderLogger().endParse();
        }
    }

    public void endResult()
    {
        StackLayout.this.endResult();
        update();
        userInteractionListener.endResult();
    }

    public void error(Exception exception)
    {
        addError(exception);
        update();
    }

    public void fkmr(FKMR fkmr1)
    {
        int _tmp = StackLayout.access$1408(StackLayout.this);
        addFkmr(fkmr1, StackLayout.access$1400(StackLayout.this));
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

    public void quartzBackLink(QuartzBacklink quartzbacklink)
    {
        StackLayout.access$1100(StackLayout.this).setQuartzBacklink(quartzbacklink);
        addMixedCorrections(StackLayout.access$1100(StackLayout.this));
        update();
    }

    public void ready()
    {
        if (StackLayout.access$1300(StackLayout.this) && stackView.getView() != null)
        {
            loadAtBottom(stackView.getFirstVisiblePosition(), stackView.getLastVisiblePosition());
        }
    }

    public void refinements(Refinements refinements1)
    {
        StackLayout.access$902(StackLayout.this, refinements1);
        if (!StackLayout.access$1200(StackLayout.this).isEmpty())
        {
            Iterator iterator = StackLayout.access$1200(StackLayout.this).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ImageSparkleModel imagesparklemodel = (ImageSparkleModel)iterator.next();
                boolean flag = imagesparklemodel.shouldDisplay();
                imagesparklemodel.computeShouldDisplay(refinements1);
                if (flag != imagesparklemodel.shouldDisplay())
                {
                    StackLayout.access$1502(StackLayout.this, true);
                }
            } while (true);
            StackLayout.access$1200(StackLayout.this).clear();
            update();
        }
    }

    public void relatedSearches(RelatedSearches relatedsearches)
    {
        addRelatedSearches(relatedsearches);
        StackLayout.access$1600(StackLayout.this);
        update();
    }

    public void resultMetadata(ResultsMetadata resultsmetadata)
    {
        if (!ResultsCountView.isValidMetaData(resultsmetadata) || !StackLayout.access$1700(StackLayout.this) || StackLayout.access$500(StackLayout.this) == null || StackLayout.access$500(StackLayout.this).getResultsCount() != null)
        {
            return;
        } else
        {
            addResultsCount(resultsmetadata);
            update();
            return;
        }
    }

    public void spellCorrected(SpellCorrected spellcorrected)
    {
        int _tmp = StackLayout.access$1408(StackLayout.this);
        addSpellCorrected(spellcorrected, StackLayout.access$1400(StackLayout.this));
        update();
    }

    public void startPage()
    {
        StackLayout.this.startPage();
        showProgressBar();
        update();
        userInteractionListener.startPage(getProgressBar(), StackLayout.access$500(StackLayout.this).getProductCount());
    }

    public void startResult()
    {
        StackLayout.access$902(StackLayout.this, null);
        StackLayout.access$1002(StackLayout.this, null);
        StackLayout.access$1102(StackLayout.this, new MixedCorrectionsModel());
        StackLayout.access$1200(StackLayout.this).clear();
        userInteractionListener.startResult();
    }

    public void trackingInfo(TrackingInfo trackinginfo)
    {
        if (trackinginfo == null)
        {
            return;
        } else
        {
            StackLayout.access$1802(StackLayout.this, trackinginfo.getStore());
            return;
        }
    }

    public void widgets(List list)
    {
        addWidgets(list);
        update();
    }

    public void wordSplitter(SpellCorrected spellcorrected)
    {
        int _tmp = StackLayout.access$1408(StackLayout.this);
        addWordSplitter(spellcorrected, StackLayout.access$1400(StackLayout.this));
        update();
    }

    private ()
    {
        this$0 = StackLayout.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

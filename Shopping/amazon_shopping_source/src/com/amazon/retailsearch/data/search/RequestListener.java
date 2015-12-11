// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;

import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.data.IRetailSearchDataProvider;
import com.amazon.retailsearch.data.assets.AssetFetchType;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.AbstractSearchListener;
import com.amazon.searchapp.retailsearch.client.SearchServiceCall;
import com.amazon.searchapp.retailsearch.model.Breadcrumb;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.DidYouMean;
import com.amazon.searchapp.retailsearch.model.DisplaySettings;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.Page;
import com.amazon.searchapp.retailsearch.model.Pagination;
import com.amazon.searchapp.retailsearch.model.PreloadImages;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.RelatedSearches;
import com.amazon.searchapp.retailsearch.model.ResultsMetadata;
import com.amazon.searchapp.retailsearch.model.SearchResources;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import com.amazon.searchapp.retailsearch.model.Sort;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import dagger.Lazy;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.data.search:
//            ResultStream, SearchLoader, ResultEvent, ResultStreamListener, 
//            ResultModel

public class RequestListener extends AbstractSearchListener
{

    private static final String NEXT_PAGE_TAG = "next";
    private final ResultStream resultStream;
    Lazy retailSearchDataProvider;
    private final SearchLoader searchLoader;
    private RetailSearchLogger searchLogger;
    private SearchServiceCall serviceCall;

    public RequestListener(SearchLoader searchloader, ResultStream resultstream)
    {
        searchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        searchLoader = searchloader;
        resultStream = resultstream;
        RetailSearchDaggerGraphController.inject(this);
    }

    private void addRecord(ResultEvent resultevent)
    {
        resultStream.addRecord(resultevent);
    }

    public void breadcrumb(Breadcrumb breadcrumb1)
    {
        addRecord(new ResultModel(breadcrumb1) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.breadcrumb((Breadcrumb)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(breadcrumb1);
            }
        });
    }

    public void categoryCorrected(CategoryCorrected categorycorrected)
    {
        addRecord(new ResultModel(categorycorrected) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.categoryCorrected((CategoryCorrected)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(categorycorrected);
            }
        });
    }

    public void didYouMean(DidYouMean didyoumean)
    {
        addRecord(new ResultModel(didyoumean) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.didYouMean((DidYouMean)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(didyoumean);
            }
        });
    }

    public void displaySettings(DisplaySettings displaysettings)
    {
        addRecord(new ResultModel(displaysettings) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.displaySettings((DisplaySettings)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(displaysettings);
            }
        });
    }

    public void endParse(SearchResult searchresult)
    {
        searchLogger.searchSRDSResponseEndParse();
        searchLogger.searchSRDSCompleted();
    }

    public void endRequest()
    {
        ((IRetailSearchDataProvider)retailSearchDataProvider.get()).fetchAssets(AssetFetchType.POST_SEARCH_PAGE_LOAD);
        if (ResultStream.Status.Error.equals(resultStream.getStatus()))
        {
            addRecord(new ResultEvent() {

                final RequestListener this$0;

                public void send(ResultStreamListener resultstreamlistener)
                {
                    resultstreamlistener.endPage();
                }

            
            {
                this$0 = RequestListener.this;
                super();
            }
            });
            return;
        }
        if (searchLoader.getNextUrl() == null)
        {
            resultStream.setStatus(ResultStream.Status.Done);
        }
        resultStream.setPageCount(resultStream.getPageCount() + 1);
        addRecord(new ResultEvent() {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.endPage();
            }

            
            {
                this$0 = RequestListener.this;
                super();
            }
        });
        if (ResultStream.Status.Done.equals(resultStream.getStatus()))
        {
            addRecord(new ResultEvent() {

                final RequestListener this$0;

                public void send(ResultStreamListener resultstreamlistener)
                {
                    resultstreamlistener.endResult();
                }

            
            {
                this$0 = RequestListener.this;
                super();
            }
            });
        }
        searchLoader.setLoading(false);
        (new ResultEvent() {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.ready();
            }

            
            {
                this$0 = RequestListener.this;
                super();
            }
        }).send(resultStream.getListeners());
    }

    public void error(Exception exception)
    {
        searchLogger.searchSRDSError("Search request error", exception, serviceCall);
        resultStream.setStatus(ResultStream.Status.Error);
        searchLoader.setLoading(false);
        addRecord(new ResultModel(exception) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.error((Exception)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(exception);
            }
        });
    }

    public void fkmr(FKMR fkmr1)
    {
        addRecord(new ResultModel(fkmr1) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.fkmr((FKMR)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(fkmr1);
            }
        });
    }

    public void noResultsSet(NoResultsSet noresultsset)
    {
        addRecord(new ResultModel(noresultsset) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.noResultsSet((NoResultsSet)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(noresultsset);
            }
        });
    }

    public void pagination(Pagination pagination1)
    {
label0:
        {
            if (pagination1 == null || pagination1.getPages() == null)
            {
                break label0;
            }
            Iterator iterator = pagination1.getPages().iterator();
            Page page;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                page = (Page)iterator.next();
            } while (page == null || !"next".equals(page.getType()));
            searchLoader.setNextUrl(page.getLink().getUrl());
        }
        addRecord(new ResultModel(pagination1) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.pagination((Pagination)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(pagination1);
            }
        });
    }

    public void preloadImages(PreloadImages preloadimages)
    {
        addRecord(new ResultModel(preloadimages) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.preloadImages((PreloadImages)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(preloadimages);
            }
        });
    }

    public void product(Product product1)
    {
        addRecord(new ResultModel(product1) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.product((Product)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(product1);
            }
        });
    }

    public void refinements(Refinements refinements1)
    {
        addRecord(new ResultModel(refinements1) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.refinements((Refinements)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(refinements1);
            }
        });
    }

    public void relatedSearches(RelatedSearches relatedsearches)
    {
        addRecord(new ResultModel(relatedsearches) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.relatedSearches((RelatedSearches)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(relatedsearches);
            }
        });
    }

    public void resources(SearchResources searchresources)
    {
        addRecord(new ResultModel(searchresources) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.resources((SearchResources)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(searchresources);
            }
        });
    }

    public void result(SearchResult searchresult)
    {
        addRecord(new ResultModel(searchresult) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.result(get());
            }

            
            {
                this$0 = RequestListener.this;
                super(searchresult);
            }
        });
    }

    public volatile void result(Object obj)
    {
        result((SearchResult)obj);
    }

    public void resultMetadata(ResultsMetadata resultsmetadata)
    {
        addRecord(new ResultModel(resultsmetadata) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.resultMetadata((ResultsMetadata)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(resultsmetadata);
            }
        });
    }

    void setServiceCall(SearchServiceCall searchservicecall)
    {
        serviceCall = searchservicecall;
    }

    public void sort(Sort sort1)
    {
        addRecord(new ResultModel(sort1) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.sort((Sort)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(sort1);
            }
        });
    }

    public void spellCorrected(SpellCorrected spellcorrected)
    {
        addRecord(new ResultModel(spellcorrected) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.spellCorrected((SpellCorrected)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(spellcorrected);
            }
        });
    }

    public void startParse(SearchResult searchresult)
    {
        searchLogger.searchFirstByteReceived();
        searchLogger.searchSRDSResponseBeginParse();
    }

    public void startRequest()
    {
        searchLogger.searchSRDSStarted();
        resultStream.setStatus(ResultStream.Status.None);
        searchLoader.setNextUrl(null);
        int i = resultStream.getPageCount();
        searchLoader.setPageStartIndex(resultStream.getContent().size());
        if (i == 0)
        {
            addRecord(new ResultEvent() {

                final RequestListener this$0;

                public void send(ResultStreamListener resultstreamlistener)
                {
                    resultstreamlistener.startResult();
                }

            
            {
                this$0 = RequestListener.this;
                super();
            }
            });
        }
        addRecord(new ResultEvent() {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.startPage();
            }

            
            {
                this$0 = RequestListener.this;
                super();
            }
        });
    }

    public void trackingInfo(TrackingInfo trackinginfo)
    {
        addRecord(new ResultModel(trackinginfo) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.trackingInfo((TrackingInfo)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(trackinginfo);
            }
        });
    }

    public void wordSplitter(SpellCorrected spellcorrected)
    {
        addRecord(new ResultModel(spellcorrected) {

            final RequestListener this$0;

            public void send(ResultStreamListener resultstreamlistener)
            {
                resultstreamlistener.wordSplitter((SpellCorrected)get());
            }

            
            {
                this$0 = RequestListener.this;
                super(spellcorrected);
            }
        });
    }
}

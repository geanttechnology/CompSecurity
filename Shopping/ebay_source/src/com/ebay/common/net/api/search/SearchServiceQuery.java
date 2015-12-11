// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.content.Context;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.SellerOffer;
import com.ebay.common.net.api.search.idealmodel.RegularSrpListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItem;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.HttpError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchPagedListManager, SearchParameters, SearchConfiguration, SearchServiceRequestV2, 
//            SearchServiceRequestV1, SearchServiceResponse, SearchServiceRequest, SearchServiceResponseV2, 
//            ISearchEventTracker

class SearchServiceQuery extends SearchPagedListManager
{

    private EbayAspectHistogram aspects;
    private EbayCategoryHistogram categories;
    private final SearchConfiguration config;
    private final EbayContext context;
    private ArrayList expansions;
    private boolean hasLocalItems;
    private int numberOfRegularItemsSeen;
    private List rewrites;
    private ISearchEventTracker searchTracker;
    private SellerOffer sellerOffer;
    private int totalNumberOfItemsWithDupes;

    public SearchServiceQuery(EbayContext ebaycontext, SearchParameters searchparameters, ISearchEventTracker isearcheventtracker, SearchConfiguration searchconfiguration)
    {
        super(searchparameters.maxCountPerPage, searchparameters);
        categories = null;
        aspects = null;
        sellerOffer = null;
        context = ebaycontext;
        searchTracker = isearcheventtracker;
        config = searchconfiguration;
    }

    private SearchServiceRequest getRequest(int i)
    {
        if (config.isUseSearchServiceV2)
        {
            return new SearchServiceRequestV2(params, i, searchTracker, config, numberOfRegularItemsSeen);
        } else
        {
            return new SearchServiceRequestV1(params, i, searchTracker, config);
        }
    }

    private void mergeHistograms(EbayAspectHistogram ebayaspecthistogram, EbayAspectHistogram ebayaspecthistogram1)
    {
        Iterator iterator = ebayaspecthistogram.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)iterator.next();
            boolean flag1 = false;
            Iterator iterator1 = ebayaspecthistogram1.iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!iterator1.hasNext())
                {
                    break;
                }
                com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect1 = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)iterator1.next();
                if (!aspect.name.equals(aspect1.name))
                {
                    continue;
                }
                flag1 = true;
                iterator1 = aspect.iterator();
                do
                {
                    flag = flag1;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)iterator1.next();
                    if (aspectvalue.checked)
                    {
                        Iterator iterator2 = aspect1.iterator();
                        while (iterator2.hasNext()) 
                        {
                            com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue1 = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)iterator2.next();
                            if (aspectvalue1.serviceValue.equals(aspectvalue.serviceValue))
                            {
                                aspectvalue1.checked = true;
                            }
                        }
                    }
                } while (true);
                break;
            } while (true);
            if (!flag)
            {
                int i;
                if (ebayaspecthistogram.indexOf(aspect) < ebayaspecthistogram1.size())
                {
                    i = ebayaspecthistogram.indexOf(aspect);
                } else
                {
                    i = 0;
                }
                ebayaspecthistogram1.add(i, aspect);
            }
        } while (true);
    }

    private SearchServiceResponse sendAndTrack(int i)
        throws InterruptedException
    {
        SearchServiceRequest searchservicerequest = getRequest(i);
        SearchServiceResponse searchserviceresponse = (SearchServiceResponse)context.getConnector().sendRequest(searchservicerequest);
        if (!searchserviceresponse.getResultStatus().hasError())
        {
            trackResponse(searchserviceresponse, searchservicerequest.getPageNumber());
        }
        setLastResultStatus(searchserviceresponse.getResultStatus());
        if (searchserviceresponse instanceof SearchServiceResponseV2)
        {
            i = numberOfRegularItemsSeen;
            numberOfRegularItemsSeen = ((SearchServiceResponseV2)searchserviceresponse).numberOfRegularItemsSeen + i;
        }
        return searchserviceresponse;
    }

    private EbayAspectHistogram suppressSingleValueAspects(EbayAspectHistogram ebayaspecthistogram)
    {
        if (ebayaspecthistogram != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((EbayAspectHistogram) (obj));
_L2:
        Iterator iterator = ebayaspecthistogram.iterator();
        do
        {
            obj = ebayaspecthistogram;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)iterator.next();
            if (((com.ebay.common.model.search.EbayAspectHistogram.Aspect) (obj)).size() < 2)
            {
                obj.suppressDisplay = true;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void trackResponse(SearchServiceResponse searchserviceresponse, int i)
    {
        if (searchTracker != null)
        {
            searchTracker.trackResponse((Context)context.getExtension(android/content/Context), i, searchserviceresponse);
        }
    }

    public void fill(ArrayList arraylist, int i)
        throws IOException, InterruptedException
    {
        SearchServiceResponse searchserviceresponse = sendAndTrack(i);
        if (!searchserviceresponse.getResultStatus().hasError())
        {
            rerankTrackableRows(arraylist);
            searchserviceresponse.fill(arraylist);
            totalNumberOfItems = searchserviceresponse.getTotalCount();
        }
    }

    public EbayAspectHistogram getAspects()
    {
        EbayAspectHistogram ebayaspecthistogram1;
        if (params.aspectHistogram == null)
        {
            ebayaspecthistogram1 = suppressSingleValueAspects(aspects);
        } else
        {
            EbayAspectHistogram ebayaspecthistogram2 = suppressSingleValueAspects(params.aspectHistogram);
            ebayaspecthistogram1 = ebayaspecthistogram2;
            if (ebayaspecthistogram2.mergeStrategy != com.ebay.common.model.search.EbayAspectHistogram.HistoMergeStrategy.RETAIN)
            {
                ebayaspecthistogram1 = aspects;
                EbayAspectHistogram ebayaspecthistogram = ebayaspecthistogram1;
                if (ebayaspecthistogram2.mergeStrategy == com.ebay.common.model.search.EbayAspectHistogram.HistoMergeStrategy.MERGE_SUPPRESS)
                {
                    ebayaspecthistogram = suppressSingleValueAspects(ebayaspecthistogram1);
                }
                ebayaspecthistogram1 = ebayaspecthistogram2;
                if (ebayaspecthistogram != null)
                {
                    mergeHistograms(ebayaspecthistogram2, ebayaspecthistogram);
                    return ebayaspecthistogram;
                }
            }
        }
        return ebayaspecthistogram1;
    }

    public EbayCategoryHistogram getCategories()
    {
        return categories;
    }

    public ArrayList getExpansions()
    {
        return expansions;
    }

    public int getPageSize()
    {
        return params.maxCountPerPage;
    }

    public List getRewrites()
    {
        return rewrites;
    }

    public SellerOffer getSellerOffer()
    {
        return sellerOffer;
    }

    public int getTotalCount()
    {
        return totalNumberOfItems;
    }

    public int getTotalCountWithDupes()
    {
        return totalNumberOfItemsWithDupes;
    }

    public boolean hasLocalItems()
    {
        return hasLocalItems;
    }

    protected boolean isErrorRetriable(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        if (message instanceof HttpError)
        {
            return false;
        } else
        {
            return super.isErrorRetriable(message);
        }
    }

    public void query()
        throws InterruptedException
    {
        SearchServiceResponse searchserviceresponse = sendAndTrack(1);
        totalNumberOfItems = searchserviceresponse.getTotalCount();
        totalNumberOfItemsWithDupes = searchserviceresponse.getTotalCountWithDupes();
        firstPage = searchserviceresponse.getPage();
        categories = searchserviceresponse.getCategories();
        aspects = searchserviceresponse.getAspects();
        expansions = searchserviceresponse.getExpansions();
        sellerOffer = searchserviceresponse.getSellerOffer();
        rewrites = searchserviceresponse.getRewrites();
        highestPageIndex = 50;
        if (firstPage == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        rerankTrackableRows(firstPage);
        j = firstPage.size();
        i = 0;
_L7:
        if (i >= j) goto _L2; else goto _L3
_L3:
        SrpListItem srplistitem = (SrpListItem)firstPage.get(i);
        if (!srplistitem.itemType.equals(com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.REGULAR) || !((RegularSrpListItem)srplistitem).isLocalItem()) goto _L5; else goto _L4
_L4:
        hasLocalItems = true;
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }
}

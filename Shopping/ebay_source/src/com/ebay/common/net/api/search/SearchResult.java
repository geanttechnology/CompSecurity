// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import com.ebay.common.model.ListResult;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.SellerOffer;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchParameters

public class SearchResult
{
    public static final class RedLaserCorrectedSearch
    {

        private final SearchParameters searchParameters;

        public String getKeywords()
        {
            return searchParameters.keywords;
        }

        public SearchParameters getSearchParameters()
        {
            return searchParameters;
        }

        public RedLaserCorrectedSearch(SearchParameters searchparameters)
        {
            searchParameters = searchparameters;
        }
    }

    public static interface SearchResultContentObserver
    {

        public abstract void onSearchContentChanged(ListContent listcontent);
    }

    public static interface SearchResultContentQuery
    {

        public abstract List getDataList();

        public abstract int getHigestPageLoaded();

        public abstract ResultStatus getLastResultStatus();

        public abstract void loadPage(int i);

        public abstract void setObserver(SearchResultContentObserver searchresultcontentobserver);
    }


    public final EbayAspectHistogram aspects;
    private boolean bopisCorrectedSearch;
    public final EbayCategoryHistogram categories;
    private final SearchParameters correctedSearchParameters;
    private boolean eBayNowCorrectedSearch;
    public final ArrayList expansions;
    public final boolean hasLocalItems;
    private boolean invalidPostalCodeCorrectedSearch;
    public final boolean isSellerItems;
    public final ListResult list;
    private RedLaserCorrectedSearch redLaserCorrectedSearch;
    public final SearchResultContentQuery resultOwner;
    public final ResultStatus resultStatus;
    private final SearchParameters searchParameters;
    public final String searchUrl;
    public final SellerOffer sellerOffer;
    public final int totalItemCount;
    public final int totalItemCountWithDupes;

    public SearchResult(int i, int j, List list1, SearchParameters searchparameters, boolean flag, SellerOffer selleroffer, EbayCategoryHistogram ebaycategoryhistogram, 
            EbayAspectHistogram ebayaspecthistogram, String s, ArrayList arraylist, SearchResultContentQuery searchresultcontentquery, SearchParameters searchparameters1)
    {
        list = new ListResult(i, new ArrayList(list1));
        searchParameters = searchparameters;
        boolean flag1;
        if (!TextUtils.isEmpty(searchparameters.sellerId))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        isSellerItems = flag1;
        hasLocalItems = flag;
        sellerOffer = selleroffer;
        categories = ebaycategoryhistogram;
        aspects = ebayaspecthistogram;
        searchUrl = s;
        expansions = arraylist;
        resultOwner = searchresultcontentquery;
        correctedSearchParameters = searchparameters1;
        totalItemCount = i;
        totalItemCountWithDupes = j;
        list1 = searchresultcontentquery.getLastResultStatus();
        if (list1 != null)
        {
            resultStatus = list1;
            return;
        } else
        {
            resultStatus = ResultStatus.SUCCESS;
            return;
        }
    }

    public SearchResult(ResultStatus resultstatus)
    {
        list = new ListResult(0, Collections.emptyList());
        resultStatus = resultstatus;
        searchParameters = null;
        isSellerItems = false;
        hasLocalItems = false;
        sellerOffer = null;
        categories = null;
        aspects = null;
        searchUrl = null;
        expansions = null;
        resultOwner = null;
        correctedSearchParameters = null;
        totalItemCount = 0;
        totalItemCountWithDupes = 0;
    }

    public void clearBopisCorrectedSearch()
    {
        bopisCorrectedSearch = false;
    }

    public void clearEbayNowMetroCorrectedSearch()
    {
        eBayNowCorrectedSearch = false;
    }

    public void clearPostalCodeCorrectedSearch()
    {
        invalidPostalCodeCorrectedSearch = false;
    }

    public boolean getBopisMetroCorrectedSearch()
    {
        return bopisCorrectedSearch;
    }

    public boolean getEbayNowMetroCorrectedSearch()
    {
        return eBayNowCorrectedSearch;
    }

    public boolean getInvalidPostalCodeCorrectedSearch()
    {
        return invalidPostalCodeCorrectedSearch;
    }

    public String getKeywords()
    {
        return getSearchParameters().keywords;
    }

    public SearchParameters getOriginalSearchParameters()
    {
        return searchParameters;
    }

    public String getProductId()
    {
        return getSearchParameters().productId;
    }

    public String getProductType()
    {
        return getSearchParameters().productIdType;
    }

    public RedLaserCorrectedSearch getRedLaserCorrectedSearch()
    {
        return redLaserCorrectedSearch;
    }

    public SearchParameters getSearchParameters()
    {
        if (correctedSearchParameters != null)
        {
            return correctedSearchParameters;
        } else
        {
            return searchParameters;
        }
    }

    public boolean isBarcodeSearch()
    {
        return getSearchParameters().productId != null && getSearchParameters().productIdType != null;
    }

    public void setBopisMetroCorrectedSearch()
    {
        bopisCorrectedSearch = true;
    }

    public void setEbayNowMetroCorrectedSearch()
    {
        eBayNowCorrectedSearch = true;
    }

    public void setInvalidPostalCodeCorrectedSearch()
    {
        invalidPostalCodeCorrectedSearch = true;
    }

    public void setRedLaserCorrectedSearch(RedLaserCorrectedSearch redlasercorrectedsearch)
    {
        redLaserCorrectedSearch = redlasercorrectedsearch;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import com.ebay.common.net.api.finding.PagedList;
import com.ebay.common.net.api.findproduct.FindProductService;
import com.ebay.common.net.api.findproduct.FindProductsRequest;
import com.ebay.common.net.api.findproduct.FindProductsResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ProductsPagedListLoader extends FwNetLoader
{
    private static class FindProductsQuery
        implements com.ebay.common.net.api.finding.PagedList.Query
    {

        private final String categoryId;
        private final EbayContext context;
        private final FindProductService findProductService;
        private ArrayList firstPage;
        private final String keywords;

        public void fill(ArrayList arraylist, int i, int j)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            if (i == 0 && firstPage != null)
            {
                for (Iterator iterator = firstPage.iterator(); iterator.hasNext(); arraylist.add(ProductsPagedListLoader.convertProduct((com.ebay.common.net.api.findproduct.FindProductsResponse.ProductResult)iterator.next()))) { }
            } else
            {
                Object obj = (FindProductsResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, new FindProductsRequest(findProductService, categoryId, keywords, 25, i));
                if (!((FindProductsResponse) (obj)).hasSuccessResponseCode())
                {
                    throw new com.ebay.nautilus.kernel.net.Connector.HostErrorException(((FindProductsResponse) (obj)).responseCode, ((FindProductsResponse) (obj)).responseMessage);
                }
                for (obj = ((FindProductsResponse) (obj)).results.iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(ProductsPagedListLoader.convertProduct((com.ebay.common.net.api.findproduct.FindProductsResponse.ProductResult)((Iterator) (obj)).next()))) { }
            }
        }

        public int query()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            int i = 0;
            FindProductsResponse findproductsresponse = (FindProductsResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, new FindProductsRequest(findProductService, categoryId, keywords, 25, 0));
            if (findproductsresponse != null)
            {
                firstPage = findproductsresponse.results;
                i = findproductsresponse.matchCount;
            }
            return i;
        }

        public FindProductsQuery(EbayContext ebaycontext, FindProductService findproductservice, String s, String s1)
        {
            firstPage = null;
            context = ebaycontext;
            findProductService = findproductservice;
            categoryId = s;
            keywords = s1;
        }
    }


    private static final int PAGE_SIZE = 25;
    private final String categoryId;
    private final FindProductService findProductService;
    public final String keywords;
    public PagedList list;

    public ProductsPagedListLoader(EbayContext ebaycontext, FindProductService findproductservice, String s, String s1)
    {
        super(ebaycontext);
        findProductService = findproductservice;
        categoryId = s;
        keywords = s1;
    }

    public static SmartboxResultsAdapter.SmartboxResult convertProduct(com.ebay.common.net.api.findproduct.FindProductsResponse.ProductResult productresult)
    {
        SmartboxResultsAdapter.SmartboxResult smartboxresult = new SmartboxResultsAdapter.SmartboxResult();
        smartboxresult.epid = productresult.id;
        smartboxresult.imageUrl = productresult.stockPhotoUrl;
        if (smartboxresult.imageUrl != null && smartboxresult.imageUrl.contains("_6.JPG"))
        {
            smartboxresult.imageUrl = smartboxresult.imageUrl.replace("_6.JPG", "_7.JPG");
        }
        smartboxresult.text = productresult.title;
        return smartboxresult;
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        list = new PagedList(new FindProductsQuery(getEbayContext(), findProductService, categoryId, keywords), 25, 5, 1);
        list.startQuery();
    }
}

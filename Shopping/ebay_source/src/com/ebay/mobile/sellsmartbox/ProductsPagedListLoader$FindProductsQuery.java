// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sellsmartbox;

import com.ebay.common.net.api.findproduct.FindProductService;
import com.ebay.common.net.api.findproduct.FindProductsRequest;
import com.ebay.common.net.api.findproduct.FindProductsResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.sellsmartbox:
//            ProductsPagedListLoader

private static class keywords
    implements com.ebay.common.net.api.finding.words
{

    private final String categoryId;
    private final EbayContext context;
    private final FindProductService findProductService;
    private ArrayList firstPage;
    private final String keywords;

    public void fill(ArrayList arraylist, int i, int j)
        throws com.ebay.nautilus.kernel.net.keywords, com.ebay.nautilus.kernel.net.keywords, com.ebay.nautilus.kernel.net.keywords, IOException, InterruptedException
    {
        if (i == 0 && firstPage != null)
        {
            for (Iterator iterator = firstPage.iterator(); iterator.hasNext(); arraylist.add(ProductsPagedListLoader.convertProduct((com.ebay.common.net.api.findproduct.ge)iterator.next()))) { }
        } else
        {
            Object obj = (FindProductsResponse)com.ebay.nautilus.kernel.net.firstPage(context, new FindProductsRequest(findProductService, categoryId, keywords, 25, i));
            if (!((FindProductsResponse) (obj)).hasSuccessResponseCode())
            {
                throw new com.ebay.nautilus.kernel.net.onseCode(((FindProductsResponse) (obj)).responseCode, ((FindProductsResponse) (obj)).responseMessage);
            }
            for (obj = ((FindProductsResponse) (obj)).results.iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(ProductsPagedListLoader.convertProduct((com.ebay.common.net.api.findproduct.e)((Iterator) (obj)).next()))) { }
        }
    }

    public int query()
        throws com.ebay.nautilus.kernel.net.e, com.ebay.nautilus.kernel.net.e, com.ebay.nautilus.kernel.net.e, IOException, InterruptedException
    {
        int i = 0;
        FindProductsResponse findproductsresponse = (FindProductsResponse)com.ebay.nautilus.kernel.net.e(context, new FindProductsRequest(findProductService, categoryId, keywords, 25, 0));
        if (findproductsresponse != null)
        {
            firstPage = findproductsresponse.results;
            i = findproductsresponse.matchCount;
        }
        return i;
    }

    public (EbayContext ebaycontext, FindProductService findproductservice, String s, String s1)
    {
        firstPage = null;
        context = ebaycontext;
        findProductService = findproductservice;
        categoryId = s;
        keywords = s1;
    }
}

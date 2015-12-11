// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.catalog;

import com.ebay.common.net.api.findproduct.FindProductService;
import com.ebay.common.net.api.findproduct.FindProductsByIdsRequest;
import com.ebay.common.net.api.findproduct.FindProductsByIdsResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.catalog:
//            MatchProductRequest, MatchProductResponse, CatalogMatchProductService

public class MatchProductLoader extends FwNetLoader
{

    private final String categoryId;
    public final String keywords;
    private final CatalogMatchProductService matchService;
    private final FindProductService productService;
    public ArrayList results;

    public MatchProductLoader(EbayContext ebaycontext, CatalogMatchProductService catalogmatchproductservice, FindProductService findproductservice, String s, String s1)
    {
        super(ebaycontext);
        productService = findproductservice;
        matchService = catalogmatchproductservice;
        categoryId = s;
        keywords = s1;
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        MatchProductResponse matchproductresponse = (MatchProductResponse)sendRequest(new MatchProductRequest(matchService, categoryId, keywords));
        if (matchproductresponse != null && matchproductresponse.results.size() > 0)
        {
            results = ((FindProductsByIdsResponse)sendRequest(new FindProductsByIdsRequest(productService, matchproductresponse.results))).results;
        }
    }
}

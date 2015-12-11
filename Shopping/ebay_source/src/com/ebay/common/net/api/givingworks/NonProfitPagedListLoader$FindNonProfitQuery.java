// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.common.model.givingworks.NonprofitData;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            NonProfitPagedListLoader, FindNonProfitRequest, FindNonProfitResponse

private static class keywords
    implements com.ebay.common.net.api.finding.ery
{

    private final EbayContext context;
    private List firstPage;
    private final String keywords;
    private final EbaySite site;

    public void fill(ArrayList arraylist, int i, int j)
        throws com.ebay.nautilus.kernel.net.tQuery, com.ebay.nautilus.kernel.net.tQuery, com.ebay.nautilus.kernel.net.tQuery, IOException, InterruptedException
    {
        if (i == 0 && firstPage != null)
        {
            arraylist.addAll(firstPage);
            return;
        }
        i = (int)Math.ceil(Double.valueOf(i + 1).doubleValue() / 25D);
        FindNonProfitResponse findnonprofitresponse = (FindNonProfitResponse)com.ebay.nautilus.kernel.net.tQuery.firstPage(context, new FindNonProfitRequest(site, keywords, 25, i));
        if (!findnonprofitresponse.hasSuccessResponseCode())
        {
            throw new com.ebay.nautilus.kernel.net.nseCode(findnonprofitresponse.responseCode, findnonprofitresponse.responseMessage);
        } else
        {
            arraylist.addAll(findnonprofitresponse.nonProfitData.nonprofits);
            return;
        }
    }

    public int query()
        throws com.ebay.nautilus.kernel.net.tQuery, com.ebay.nautilus.kernel.net.tQuery, com.ebay.nautilus.kernel.net.tQuery, IOException, InterruptedException
    {
        FindNonProfitResponse findnonprofitresponse = (FindNonProfitResponse)com.ebay.nautilus.kernel.net.tQuery(context, new FindNonProfitRequest(site, keywords, 25, 1));
        if (findnonprofitresponse != null && findnonprofitresponse.nonProfitData != null)
        {
            firstPage = findnonprofitresponse.nonProfitData.nonprofits;
            return findnonprofitresponse.nonProfitData.paginationOutput.firstPage;
        } else
        {
            return 0;
        }
    }

    public (EbayContext ebaycontext, EbaySite ebaysite, String s)
    {
        firstPage = null;
        context = ebaycontext;
        site = ebaysite;
        keywords = s;
    }
}

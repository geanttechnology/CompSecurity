// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.common.model.givingworks.NonprofitData;
import com.ebay.common.net.api.finding.PagedList;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            FindNonProfitRequest, FindNonProfitResponse

public class NonProfitPagedListLoader extends FwNetLoader
{
    private static class FindNonProfitQuery
        implements com.ebay.common.net.api.finding.PagedList.Query
    {

        private final EbayContext context;
        private List firstPage;
        private final String keywords;
        private final EbaySite site;

        public void fill(ArrayList arraylist, int i, int j)
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            if (i == 0 && firstPage != null)
            {
                arraylist.addAll(firstPage);
                return;
            }
            i = (int)Math.ceil(Double.valueOf(i + 1).doubleValue() / 25D);
            FindNonProfitResponse findnonprofitresponse = (FindNonProfitResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, new FindNonProfitRequest(site, keywords, 25, i));
            if (!findnonprofitresponse.hasSuccessResponseCode())
            {
                throw new com.ebay.nautilus.kernel.net.Connector.HostErrorException(findnonprofitresponse.responseCode, findnonprofitresponse.responseMessage);
            } else
            {
                arraylist.addAll(findnonprofitresponse.nonProfitData.nonprofits);
                return;
            }
        }

        public int query()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
        {
            FindNonProfitResponse findnonprofitresponse = (FindNonProfitResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(context, new FindNonProfitRequest(site, keywords, 25, 1));
            if (findnonprofitresponse != null && findnonprofitresponse.nonProfitData != null)
            {
                firstPage = findnonprofitresponse.nonProfitData.nonprofits;
                return findnonprofitresponse.nonProfitData.paginationOutput.totalEntries;
            } else
            {
                return 0;
            }
        }

        public FindNonProfitQuery(EbayContext ebaycontext, EbaySite ebaysite, String s)
        {
            firstPage = null;
            context = ebaycontext;
            site = ebaysite;
            keywords = s;
        }
    }


    private static final int PAGE_SIZE = 25;
    public final String keywords;
    public PagedList list;
    private final EbaySite site;

    public NonProfitPagedListLoader(EbayContext ebaycontext, EbaySite ebaysite, String s)
    {
        super(ebaycontext);
        site = ebaysite;
        keywords = s;
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        list = new PagedList(new FindNonProfitQuery(getEbayContext(), site, keywords), 25, 5, 1);
        list.startQuery();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.common.model.givingworks.NonprofitData;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            FindNonProfitByIdRequest, FindNonProfitResponse

public class NonProfitLoader extends FwNetLoader
{

    public com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonProfit;
    public final String nonprofitId;
    private final EbaySite site;

    public NonProfitLoader(EbayContext ebaycontext, EbaySite ebaysite, String s)
    {
        super(ebaycontext);
        site = ebaysite;
        nonprofitId = s;
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        Object obj = (FindNonProfitResponse)sendRequest(new FindNonProfitByIdRequest(site, nonprofitId));
        if (obj != null && ((FindNonProfitResponse) (obj)).nonProfitData != null && ((FindNonProfitResponse) (obj)).nonProfitData.nonprofits != null && ((FindNonProfitResponse) (obj)).nonProfitData.nonprofits.size() > 0)
        {
            obj = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)((FindNonProfitResponse) (obj)).nonProfitData.nonprofits.get(0);
            if (((com.ebay.common.model.givingworks.NonprofitData.Nonprofit) (obj)).nonprofitId.equals(nonprofitId))
            {
                nonProfit = ((com.ebay.common.model.givingworks.NonprofitData.Nonprofit) (obj));
            }
        }
    }
}

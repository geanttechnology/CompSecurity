// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class RequestTokenForServiceNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final EbaySite site;
    private final String username;

    public RequestTokenForServiceNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, EbaySite ebaysite, String s)
    {
        super(ebaycontext);
        api = ebaycartapi;
        username = s;
        site = ebaysite;
    }

    protected EbayRequest createRequest()
    {
        return new RequestTokenForService.RequestTokenForServiceRequest(api, site.idString, username);
    }

    protected void doInBackgroundInternal()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, IOException, InterruptedException
    {
        super.doInBackgroundInternal();
        if (response != null)
        {
            ((RequestTokenForService.RequestTokenForServiceResponse)response).ackCode = 1;
        }
    }
}

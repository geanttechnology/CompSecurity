// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetOrderShippingInfoRequest

public class GetOrderShippingInfoNetLoader extends EbaySimpleNetLoader
{

    private final String iafToken;
    private final String itemId;
    private final EbaySite site;
    private final String transactionId;

    public GetOrderShippingInfoNetLoader(EbayContext ebaycontext, String s, EbaySite ebaysite, String s1, String s2)
    {
        super(ebaycontext);
        iafToken = s;
        site = ebaysite;
        itemId = s1;
        transactionId = s2;
    }

    protected EbayRequest createRequest()
    {
        return new GetOrderShippingInfoRequest(iafToken, site, itemId, transactionId);
    }
}

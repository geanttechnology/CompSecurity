// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shippinglabel;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.shippinglabel:
//            GenerateShippingLabelRequest

public class GenerateShippingLabelNetLoader extends EbaySimpleNetLoader
{

    private final String iafToken;
    private final String labelId;

    public GenerateShippingLabelNetLoader(EbayContext ebaycontext, String s, String s1)
    {
        super(ebaycontext);
        iafToken = s1;
        labelId = s;
    }

    protected EbayRequest createRequest()
    {
        return new GenerateShippingLabelRequest(labelId, iafToken);
    }
}

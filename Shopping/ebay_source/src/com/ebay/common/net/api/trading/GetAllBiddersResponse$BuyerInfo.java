// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetAllBiddersResponse

private final class buyerInfo extends com.ebay.nautilus.kernel.util.o
{

    private final com.ebay.common.model.hippingAddress buyerInfo;
    final GetAllBiddersResponse this$0;

    public com.ebay.nautilus.kernel.util.o get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ShippingAddress".equals(s1))
        {
            return new dress(GetAllBiddersResponse.this, buyerInfo.hippingAddress);
        } else
        {
            return super.ddress(s, s1, s2, attributes);
        }
    }

    public dress(com.ebay.common.model.BuyerInfo buyerinfo)
    {
        this$0 = GetAllBiddersResponse.this;
        super();
        buyerInfo = buyerinfo;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayOrder;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class order extends com.ebay.nautilus.kernel.util.y
{

    private final EbayOrder order;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.y get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Transaction".equals(s1))
        {
            return new >(GetOrdersResponse.this, order);
        } else
        {
            return super.order(s, s1, s2, attributes);
        }
    }

    public (EbayOrder ebayorder)
    {
        this$0 = GetOrdersResponse.this;
        super();
        order = ebayorder;
        order.transactions = new ArrayList();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.OrderItemTransaction;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class currentTx extends com.ebay.nautilus.kernel.util.s
{

    private final OrderItemTransaction currentTx;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "SellerShipmentToLogisticsProvider".equals(s1))
        {
            return new sProvider(GetOrdersResponse.this, currentTx);
        } else
        {
            return super.currentTx(s, s1, s2, attributes);
        }
    }

    public sProvider(OrderItemTransaction orderitemtransaction)
    {
        this$0 = GetOrdersResponse.this;
        super();
        currentTx = orderitemtransaction;
    }
}

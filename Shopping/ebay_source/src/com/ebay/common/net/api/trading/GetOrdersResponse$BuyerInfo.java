// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.OrderItemTransaction;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class itemTransaction extends com.ebay.nautilus.kernel.util.o
{

    private final OrderItemTransaction itemTransaction;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.o get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ShippingAddress".equals(s1))
        {
            return new dress(GetOrdersResponse.this, itemTransaction);
        } else
        {
            return super.itemTransaction(s, s1, s2, attributes);
        }
    }

    public dress(OrderItemTransaction orderitemtransaction)
    {
        this$0 = GetOrdersResponse.this;
        super();
        itemTransaction = orderitemtransaction;
    }
}

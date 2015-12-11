// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransactionVariation;
import com.ebay.common.model.OrderItemTransaction;
import com.ebay.nautilus.domain.data.NameValue;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class currentTx extends com.ebay.nautilus.kernel.util.t
{

    final OrderItemTransaction currentTx;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            final NameValue nameValue = (NameValue)currentTx.variation.nameValueList.get(currentTx.variation.nameValueList.size() - 1);
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.NameValueList this$1;
                    final NameValue val$nameValue;

                    public void text(String s3)
                        throws SAXException
                    {
                        nameValue.setName(s3);
                    }

            
            {
                this$1 = GetOrdersResponse.NameValueList.this;
                nameValue = namevalue;
                super();
            }
                };
            }
            if ("Value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.NameValueList this$1;
                    final NameValue val$nameValue;

                    public void text(String s3)
                        throws SAXException
                    {
                        nameValue.addValue(s3);
                    }

            
            {
                this$1 = GetOrdersResponse.NameValueList.this;
                nameValue = namevalue;
                super();
            }
                };
            }
        }
        return super.t(s, s1, s2, attributes);
    }

    public _cls2.val.nameValue(OrderItemTransaction orderitemtransaction)
    {
        this$0 = GetOrdersResponse.this;
        super();
        currentTx = orderitemtransaction;
        currentTx.variation.nameValueList.add(new NameValue());
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

final class orderId extends com.ebay.nautilus.kernel.util.rray.Order
{

    public String orderId;
    final orderId this$0;

    public com.ebay.nautilus.kernel.util.rray.Order get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        Object obj;
        if ("OrderID".equals(s1))
        {
            obj = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Order this$1;

                public void text(String s3)
                    throws SAXException
                {
                    orderId = s3;
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.ListElement.OrderTransactionArray.Order.this;
                super();
            }
            };
        } else
        {
            obj = this;
            if (!"TransactionArray".equals(s1))
            {
                if ("Transaction".equals(s1))
                {
                    s = new MyEbayListItem();
                    this._cls0.this.orderId.add(s);
                    s.orderId = orderId;
                    return new ction(s, orderId);
                } else
                {
                    return super.orderId(s, s1, s2, attributes);
                }
            }
        }
        return ((com.ebay.nautilus.kernel.util.rray.Order.orderId) (obj));
    }

    _cls1.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
        orderId = null;
    }
}

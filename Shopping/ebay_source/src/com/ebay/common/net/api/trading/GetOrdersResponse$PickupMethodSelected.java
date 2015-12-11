// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayOrder;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class order extends com.ebay.nautilus.kernel.util.d
{

    private final EbayOrder order;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.d get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("PickupMethod".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.PickupMethodSelected this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.selectedMethod = s3;
                }

            
            {
                this$1 = GetOrdersResponse.PickupMethodSelected.this;
                super();
            }
            };
        }
        if ("PickupStoreID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.PickupMethodSelected this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.storeId = s3;
                }

            
            {
                this$1 = GetOrdersResponse.PickupMethodSelected.this;
                super();
            }
            };
        }
        if ("PickupStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.PickupMethodSelected this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.pickupStatus = OrderPickupStatus.getByName(s3);
                }

            
            {
                this$1 = GetOrdersResponse.PickupMethodSelected.this;
                super();
            }
            };
        }
        if ("MerchantPickupCode".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.PickupMethodSelected this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.merchantPickupCode = s3;
                }

            
            {
                this$1 = GetOrdersResponse.PickupMethodSelected.this;
                super();
            }
            };
        } else
        {
            return super.d(s, s1, s2, attributes);
        }
    }


    public _cls4.this._cls1(EbayOrder ebayorder)
    {
        this$0 = GetOrdersResponse.this;
        super();
        order = ebayorder;
    }
}

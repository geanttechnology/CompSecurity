// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class tx extends com.ebay.nautilus.kernel.util.d
{

    final GetItemTransactionsResponse this$0;
    private final ItemTransaction tx;

    public com.ebay.nautilus.kernel.util.d get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("PickupMethod".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetItemTransactionsResponse.PickupMethodSelected this$1;

                public void text(String s3)
                    throws SAXException
                {
                    tx.selectedMethod = s3;
                }

            
            {
                this$1 = GetItemTransactionsResponse.PickupMethodSelected.this;
                super();
            }
            };
        }
        if ("PickupStoreID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetItemTransactionsResponse.PickupMethodSelected this$1;

                public void text(String s3)
                    throws SAXException
                {
                    tx.storeId = s3;
                }

            
            {
                this$1 = GetItemTransactionsResponse.PickupMethodSelected.this;
                super();
            }
            };
        }
        if ("PickupStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetItemTransactionsResponse.PickupMethodSelected this$1;

                public void text(String s3)
                    throws SAXException
                {
                    tx.pickupStatus = OrderPickupStatus.getByName(s3);
                }

            
            {
                this$1 = GetItemTransactionsResponse.PickupMethodSelected.this;
                super();
            }
            };
        }
        if ("MerchantPickupCode".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetItemTransactionsResponse.PickupMethodSelected this$1;

                public void text(String s3)
                    throws SAXException
                {
                    tx.merchantPickupCode = s3;
                }

            
            {
                this$1 = GetItemTransactionsResponse.PickupMethodSelected.this;
                super();
            }
            };
        } else
        {
            return super.d(s, s1, s2, attributes);
        }
    }


    public _cls4.this._cls1(ItemTransaction itemtransaction)
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
        tx = itemtransaction;
    }
}

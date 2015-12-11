// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayOrder;
import com.ebay.common.model.OrderItemTransaction;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class currentTx extends com.ebay.nautilus.kernel.util.n
{

    final OrderItemTransaction currentTx = new OrderItemTransaction();
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.n get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Buyer".equals(s1))
            {
                return new (GetOrdersResponse.this, currentTx);
            }
            if ("Status".equals(s1))
            {
                return new >(GetOrdersResponse.this, currentTx);
            }
            if ("ShippingServiceSelected".equals(s1))
            {
                return new iceSelected(GetOrdersResponse.this, currentTx);
            }
            if ("ShippingDetails".equals(s1))
            {
                return new ils(GetOrdersResponse.this, currentTx);
            }
            if ("ContainingOrder".equals(s1))
            {
                return new der(GetOrdersResponse.this, currentTx);
            }
            if ("Variation".equals(s1))
            {
                return new nit>(GetOrdersResponse.this, currentTx);
            }
            if ("TransactionID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.Transaction this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.transactionId = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.Transaction.this;
                super();
            }
                };
            }
            if ("QuantityPurchased".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetOrdersResponse.Transaction this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        currentTx.quantityPurchased = i;
                    }

            
            {
                this$1 = GetOrdersResponse.Transaction.this;
                super();
            }
                };
            }
            if ("TransactionPrice".equals(s1))
            {
                s = currentTx;
                s1 = new ItemCurrency();
                s.transactionPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ConvertedTransactionPrice".equals(s1))
            {
                s = currentTx;
                s1 = new ItemCurrency();
                s.convertedTransactionPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("AmountPaid".equals(s1))
            {
                s = currentTx;
                s1 = new ItemCurrency();
                s.amountPaid = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ConvertedAmountPaid".equals(s1))
            {
                s = currentTx;
                s1 = new ItemCurrency();
                s.convertedAmountPaid = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("CreatedDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.Transaction this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.createdDate = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetOrdersResponse.Transaction.this;
                super();
            }
                };
            }
            if ("OrderLineItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.Transaction this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.orderLineItemId = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.Transaction.this;
                super();
            }
                };
            }
            if ("IsMultiLegShipping".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetOrdersResponse.Transaction this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        currentTx.multiLeg = flag;
                    }

            
            {
                this$1 = GetOrdersResponse.Transaction.this;
                super();
            }
                };
            }
            if ("MultiLegShippingDetails".equals(s1))
            {
                return new pingDetails(GetOrdersResponse.this, currentTx);
            }
            if ("Item".equals(s1))
            {
                return new currentTx(GetOrdersResponse.this, currentTx);
            }
        }
        return super.currentTx(s, s1, s2, attributes);
    }

    public (EbayOrder ebayorder)
    {
        this$0 = GetOrdersResponse.this;
        super();
        ebayorder.transactions.add(currentTx);
    }
}

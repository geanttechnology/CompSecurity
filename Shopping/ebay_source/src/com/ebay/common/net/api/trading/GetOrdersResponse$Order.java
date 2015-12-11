// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayOrder;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class order extends com.ebay.nautilus.kernel.util.r
{

    private final EbayOrder order;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.r get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("OrderID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.Order this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.id = s3;
                }

            
            {
                this$1 = GetOrdersResponse.Order.this;
                super();
            }
            };
        }
        if ("OrderStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.Order this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.status = s3;
                }

            
            {
                this$1 = GetOrdersResponse.Order.this;
                super();
            }
            };
        }
        if ("AdjustmentAmount".equals(s1))
        {
            s = order;
            s1 = new ItemCurrency();
            s.adjustmentAmount = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("AmountPaid".equals(s1))
        {
            s = order;
            s1 = new ItemCurrency();
            s.amountPaid = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("AmountSaved".equals(s1))
        {
            s = order;
            s1 = new ItemCurrency();
            s.amountSaved = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("PaymentMethods".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.Order this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.paymentMethods = s3;
                }

            
            {
                this$1 = GetOrdersResponse.Order.this;
                super();
            }
            };
        }
        if ("SellerEmail".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.Order this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.sellerEmail = s3;
                }

            
            {
                this$1 = GetOrdersResponse.Order.this;
                super();
            }
            };
        }
        if ("Subtotal".equals(s1))
        {
            s = order;
            s1 = new ItemCurrency();
            s.subtotal = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("Total".equals(s1))
        {
            s = order;
            s1 = new ItemCurrency();
            s.total = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("TransactionArray".equals(s1))
        {
            return new ctionArray(GetOrdersResponse.this, order);
        }
        if ("CreatedTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.Order this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.creationDate = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$1 = GetOrdersResponse.Order.this;
                super();
            }
            };
        }
        if ("PickupDetails".equals(s1))
        {
            return new Details(GetOrdersResponse.this, order);
        }
        if ("PickupMethodSelected".equals(s1))
        {
            return new MethodSelected(GetOrdersResponse.this, order);
        }
        if ("PaymentHoldStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.Order this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.paymentHoldStatus = s3;
                }

            
            {
                this$1 = GetOrdersResponse.Order.this;
                super();
            }
            };
        }
        if ("ShippingServiceSelectedOrder".equals(s1))
        {
            return new ngServiceSelectedOrder(GetOrdersResponse.this, order);
        }
        if ("CheckoutStatus".equals(s1))
        {
            return new utStatus(GetOrdersResponse.this, order);
        }
        if ("MonetaryDetails".equals(s1))
        {
            return new ryDetails(GetOrdersResponse.this, order);
        }
        if ("PaidTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetOrdersResponse.Order this$1;

                public void text(String s3)
                    throws SAXException
                {
                    order.paidTime = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$1 = GetOrdersResponse.Order.this;
                super();
            }
            };
        } else
        {
            return super.r(s, s1, s2, attributes);
        }
    }


    public it>(EbayOrder ebayorder)
    {
        this$0 = GetOrdersResponse.this;
        super();
        order = ebayorder;
    }
}

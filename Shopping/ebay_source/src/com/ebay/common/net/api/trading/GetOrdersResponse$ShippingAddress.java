// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.OrderItemTransaction;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class itemTransaction extends com.ebay.nautilus.kernel.util.s
{

    private final OrderItemTransaction itemTransaction;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("CityName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemTransaction.buyerCityName = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingAddress.this;
                super();
            }
                };
            }
            if ("Street".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemTransaction.buyerStreet = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingAddress.this;
                super();
            }
                };
            }
            if ("Street1".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemTransaction.buyerStreet1 = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingAddress.this;
                super();
            }
                };
            }
            if ("Street2".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemTransaction.buyerStreet2 = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingAddress.this;
                super();
            }
                };
            }
            if ("Country".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemTransaction.buyerCountry = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingAddress.this;
                super();
            }
                };
            }
            if ("CountryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemTransaction.buyerCountryName = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingAddress.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemTransaction.buyerName = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingAddress.this;
                super();
            }
                };
            }
            if ("Phone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemTransaction.buyerPhone = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingAddress.this;
                super();
            }
                };
            }
            if ("PostalCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemTransaction.buyerPostalCode = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingAddress.this;
                super();
            }
                };
            }
            if ("StateOrProvince".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShippingAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemTransaction.buyerStateOrProvince = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShippingAddress.this;
                super();
            }
                };
            }
        }
        return super.s(s, s1, s2, attributes);
    }


    public _cls9.this._cls1(OrderItemTransaction orderitemtransaction)
    {
        this$0 = GetOrdersResponse.this;
        super();
        itemTransaction = orderitemtransaction;
    }
}

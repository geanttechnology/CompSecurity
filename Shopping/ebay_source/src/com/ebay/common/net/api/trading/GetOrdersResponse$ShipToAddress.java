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
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("AddressId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegAddressId = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("AddressOwner".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegAddressOwner = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("AddressUsage".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegAddressUsage = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("CityName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegCityName = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("Country".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegCountry = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("CountryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegCountryName = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("ExternalAddressId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegExternalAddressId = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegName = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("Phone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegPhone = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("PostalCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegPostalCode = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("ReferenceID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegReferenceId = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("StateOrProvince".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegStateOrProvince = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("Street1".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegStreet1 = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("Street2".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetOrdersResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        currentTx.multiLegStreet2 = s3;
                    }

            
            {
                this$1 = GetOrdersResponse.ShipToAddress.this;
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
        currentTx = orderitemtransaction;
    }
}

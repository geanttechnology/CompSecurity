// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.s
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("AddressId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegAddressId = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("AddressOwner".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegAddressOwner = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("AddressUsage".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegAddressUsage = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("CityName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegCityName = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("Country".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegCountry = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("CountryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegCountryName = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("ExternalAddressId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegExternalAddressId = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegName = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("Phone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegPhone = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("PostalCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegPostalCode = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("ReferenceID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegReferenceId = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("StateOrProvince".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegStateOrProvince = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("Street1".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegStreet1 = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
            if ("Street2".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShipToAddress this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).multiLegStreet2 = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShipToAddress.this;
                super();
            }
                };
            }
        }
        return super.s(s, s1, s2, attributes);
    }

    private _cls9.this._cls1()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

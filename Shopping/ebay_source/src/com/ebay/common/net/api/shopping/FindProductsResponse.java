// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shopping;

import com.ebay.common.model.EbayProduct;
import com.ebay.common.model.EbayProductDomain;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class FindProductsResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FindProductsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(FindProductsResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(FindProductsResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(FindProductsResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("Product".equals(s1))
                {
                    return new Product();
                }
                if ("DomainHistogram".equals(s1))
                {
                    return new DomainHistogram();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = FindProductsResponse.this;
            super();
        }

    }

    private final class RootElement.DomainHistogram extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Domain".equals(s1))
            {
                return new Domain();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.DomainHistogram()
        {
            this$1 = RootElement.this;
            super();
        }

    }

    public final class RootElement.DomainHistogram.Domain extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayProductDomain domain = new EbayProductDomain();
        final RootElement.DomainHistogram this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Count".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final RootElement.DomainHistogram.Domain this$3;

                        protected void setValue(long l)
                            throws SAXException
                        {
                            domain.count = l;
                        }

            
            {
                this$3 = RootElement.DomainHistogram.Domain.this;
                super();
            }
                    };
                }
                if ("Name".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.DomainHistogram.Domain this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            domain.name = s;
                        }

            
            {
                this$3 = RootElement.DomainHistogram.Domain.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.DomainHistogram.Domain()
        {
            this$2 = RootElement.DomainHistogram.this;
            super();
            domainHistogram.add(domain);
        }
    }

    private final class RootElement.Product extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayProduct product = new EbayProduct();
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Title".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.Product this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            product.title = s;
                        }

            
            {
                this$2 = RootElement.Product.this;
                super();
            }
                    };
                }
                if ("ProductID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.Product this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            product.epid = s;
                        }

            
            {
                this$2 = RootElement.Product.this;
                super();
            }
                    };
                }
                if ("StockPhotoURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.Product this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            product.stockPhotoUrl = s;
                        }

            
            {
                this$2 = RootElement.Product.this;
                super();
            }
                    };
                }
                if ("DetailsURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.Product this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            product.detailsUrl = s;
                        }

            
            {
                this$2 = RootElement.Product.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.Product()
        {
            this$1 = RootElement.this;
            super();
            products.add(product);
        }
    }


    public final ArrayList domainHistogram = new ArrayList();
    public final ArrayList products = new ArrayList();

    public FindProductsResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}

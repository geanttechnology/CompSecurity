// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.product;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetProductDetailsReponse extends EbayResponse
{
    private final class Body extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetProductDetailsReponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getProductDetailsResponse".equals(s1))
            {
                return new ResponseNode();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Body()
        {
            this$0 = GetProductDetailsReponse.this;
            super();
        }

    }

    private final class Product extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetProductDetailsReponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("productIdentifier".equals(s1))
            {
                return new ProductIdentifier();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Product()
        {
            this$0 = GetProductDetailsReponse.this;
            super();
        }

    }

    private final class ProductError extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayResponseError error = new EbayResponseError();
        final GetProductDetailsReponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ProductError this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        error.code = s;
                    }

            
            {
                this$1 = ProductError.this;
                super();
            }
                };
            }
            if ("message".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ProductError this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        error.shortMessage = s;
                    }

            
            {
                this$1 = ProductError.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public ProductError()
        {
            this$0 = GetProductDetailsReponse.this;
            super();
            addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                error
            });
        }
    }

    private final class ProductErrorMessage extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetProductDetailsReponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("error".equals(s1))
            {
                return new ProductError();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ProductErrorMessage()
        {
            this$0 = GetProductDetailsReponse.this;
            super();
        }

    }

    private final class ProductIdentifier extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetProductDetailsReponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ePID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ProductIdentifier this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        epid = s;
                    }

            
            {
                this$1 = ProductIdentifier.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ProductIdentifier()
        {
            this$0 = GetProductDetailsReponse.this;
            super();
        }

    }

    private final class ResponseNode extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetProductDetailsReponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(GetProductDetailsReponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(GetProductDetailsReponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ProductErrorMessage();
            }
            if ("product".equals(s1))
            {
                return new Product();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseNode()
        {
            this$0 = GetProductDetailsReponse.this;
            super();
        }

    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetProductDetailsReponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.w3.org/2003/05/soap-envelope".equals(s) && "Body".equals(s1))
            {
                return new Body();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = GetProductDetailsReponse.this;
            super();
        }

    }


    public String epid;

    public GetProductDetailsReponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}

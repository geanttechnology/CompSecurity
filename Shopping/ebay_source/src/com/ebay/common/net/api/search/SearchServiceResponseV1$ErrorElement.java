// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class error extends com.ebay.nautilus.kernel.util.
{
    private final class CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final SearchServiceResponseV1.ErrorElement this$1;

        public void text(String s)
            throws SAXException
        {
            if ("Application".equals(s))
            {
                error.category = 1;
            } else
            {
                if ("Request".equals(s))
                {
                    error.category = 2;
                    return;
                }
                if ("System".equals(s))
                {
                    error.category = 3;
                    return;
                }
            }
        }

        private CategoryElement()
        {
            this$1 = SearchServiceResponseV1.ErrorElement.this;
            super();
        }

        CategoryElement(SearchServiceResponseV1._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ParameterElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter;
        final SearchServiceResponseV1.ErrorElement this$1;

        public void text(String s)
            throws SAXException
        {
            parameter.value = s;
        }

        public ParameterElement(com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter1, Attributes attributes)
        {
            this$1 = SearchServiceResponseV1.ErrorElement.this;
            super();
            parameter = parameter1;
            int j = attributes.getLength();
            for (int i = 0; i < j; i++)
            {
                if (attributes.getLocalName(i).equals("name"))
                {
                    parameter1.name = attributes.getValue(i);
                }
            }

        }
    }

    private final class SeverityElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final SearchServiceResponseV1.ErrorElement this$1;

        public void text(String s)
            throws SAXException
        {
            if ("Error".equals(s))
            {
                ackCode = -1;
                error.severity = 1;
            } else
            if ("Warning".equals(s))
            {
                error.severity = 2;
                return;
            }
        }

        private SeverityElement()
        {
            this$1 = SearchServiceResponseV1.ErrorElement.this;
            super();
        }

        SeverityElement(SearchServiceResponseV1._cls1 _pcls1)
        {
            this();
        }
    }


    private final com.ebay.nautilus.domain.net.er error;
    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("errorId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ErrorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    error.code = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.ErrorElement.this;
                super();
            }
            };
        }
        if ("category".equals(s1))
        {
            return new CategoryElement(null);
        }
        if ("severity".equals(s1))
        {
            return new SeverityElement(null);
        }
        if ("domain".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ErrorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    error.domain = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.ErrorElement.this;
                super();
            }
            };
        }
        if ("subdomain".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ErrorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    error.subdomain = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.ErrorElement.this;
                super();
            }
            };
        }
        if ("exceptionId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ErrorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    error.exceptionId = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.ErrorElement.this;
                super();
            }
            };
        }
        if ("message".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ErrorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    com.ebay.nautilus.domain.net.EbayResponseError.LongDetails longdetails = error;
                    error.shortMessage = s3;
                    longdetails.longMessage = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.ErrorElement.this;
                super();
            }
            };
        }
        if ("parameter".equals(s1))
        {
            if (error.ers == null)
            {
                error.ers = new ArrayList();
            }
            s = new com.ebay.nautilus.domain.net.er();
            error.ers.add(s);
            return new ParameterElement(s, attributes);
        } else
        {
            return super.r(s, s1, s2, attributes);
        }
    }


    public _cls5.this._cls1(com.ebay.nautilus.domain.net.t t)
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        error = t;
    }
}

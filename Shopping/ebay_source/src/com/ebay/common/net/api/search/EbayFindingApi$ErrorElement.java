// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.net.EbayResponse;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi

private static final class error extends com.ebay.nautilus.kernel.util.
{
    private final class CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final EbayFindingApi.ErrorElement this$0;

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
            this$0 = EbayFindingApi.ErrorElement.this;
            super();
        }

        CategoryElement(EbayFindingApi._cls1 _pcls1)
        {
            this();
        }
    }

    private final class MessageElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final EbayFindingApi.ErrorElement this$0;

        public void text(String s)
            throws SAXException
        {
            com.ebay.nautilus.domain.net.EbayResponseError.LongDetails longdetails = error;
            error.shortMessage = s;
            longdetails.longMessage = s;
        }

        private MessageElement()
        {
            this$0 = EbayFindingApi.ErrorElement.this;
            super();
        }

        MessageElement(EbayFindingApi._cls1 _pcls1)
        {
            this();
        }
    }

    private static final class ParameterElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter;

        public void text(String s)
            throws SAXException
        {
            parameter.value = s;
        }

        public ParameterElement(com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter1, Attributes attributes)
        {
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

        final EbayFindingApi.ErrorElement this$0;

        public void text(String s)
            throws SAXException
        {
            if ("Error".equals(s))
            {
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
            this$0 = EbayFindingApi.ErrorElement.this;
            super();
        }

        SeverityElement(EbayFindingApi._cls1 _pcls1)
        {
            this();
        }
    }


    private final com.ebay.nautilus.domain.net.s error = new com.ebay.nautilus.domain.net.s();

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("errorId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final EbayFindingApi.ErrorElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    error.code = s3;
                }

            
            {
                this$0 = EbayFindingApi.ErrorElement.this;
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

                final EbayFindingApi.ErrorElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    error.domain = s3;
                }

            
            {
                this$0 = EbayFindingApi.ErrorElement.this;
                super();
            }
            };
        }
        if ("subdomain".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final EbayFindingApi.ErrorElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    error.subdomain = s3;
                }

            
            {
                this$0 = EbayFindingApi.ErrorElement.this;
                super();
            }
            };
        }
        if ("exceptionId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final EbayFindingApi.ErrorElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    error.exceptionId = s3;
                }

            
            {
                this$0 = EbayFindingApi.ErrorElement.this;
                super();
            }
            };
        }
        if ("message".equals(s1))
        {
            return new MessageElement(null);
        }
        if ("parameter".equals(s1))
        {
            if (error.parameters == null)
            {
                error.parameters = new ArrayList();
            }
            s = new com.ebay.nautilus.domain.net.s.Parameter();
            error.parameters.add(s);
            return new ParameterElement(s, attributes);
        } else
        {
            return super.Parameter(s, s1, s2, attributes);
        }
    }


    public (EbayResponse ebayresponse, String s)
    {
        ebayresponse.addResultMessage(new com.ebay.nautilus.kernel.content.this._cls0[] {
            error
        });
    }
}

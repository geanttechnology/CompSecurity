// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class error extends com.ebay.nautilus.kernel.util.
{
    private final class CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final SearchServiceResponseV2.ErrorElement this$1;

        public void text(String s)
            throws SAXException
        {
            byte byte0 = -1;
            s.hashCode();
            JVM INSTR lookupswitch 3: default 40
        //                       -1803461041: 97
        //                       -1534621073: 83
        //                       -1072845520: 69;
               goto _L1 _L2 _L3 _L4
_L1:
            break; /* Loop/switch isn't completed */
_L2:
            break MISSING_BLOCK_LABEL_97;
_L5:
            switch (byte0)
            {
            default:
                return;

            case 0: // '\0'
                error.category = 1;
                return;

            case 1: // '\001'
                error.category = 2;
                return;

            case 2: // '\002'
                error.category = 3;
                break;
            }
            break MISSING_BLOCK_LABEL_146;
_L4:
            if (s.equals("Application"))
            {
                byte0 = 0;
            }
              goto _L5
_L3:
            if (s.equals("Request"))
            {
                byte0 = 1;
            }
              goto _L5
            if (s.equals("System"))
            {
                byte0 = 2;
            }
              goto _L5
        }

        private CategoryElement()
        {
            this$1 = SearchServiceResponseV2.ErrorElement.this;
            super();
        }

        CategoryElement(SearchServiceResponseV2._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ParameterElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter;
        final SearchServiceResponseV2.ErrorElement this$1;

        public void text(String s)
            throws SAXException
        {
            parameter.value = s;
        }

        public ParameterElement(com.ebay.nautilus.domain.net.EbayResponseError.LongDetails.Parameter parameter1, Attributes attributes)
        {
            this$1 = SearchServiceResponseV2.ErrorElement.this;
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

        final SearchServiceResponseV2.ErrorElement this$1;

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
            this$1 = SearchServiceResponseV2.ErrorElement.this;
            super();
        }

        SeverityElement(SearchServiceResponseV2._cls1 _pcls1)
        {
            this();
        }
    }


    final com.ebay.nautilus.domain.net.er error;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("errorId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ErrorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    error.code = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.ErrorElement.this;
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

                final SearchServiceResponseV2.ErrorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    error.domain = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.ErrorElement.this;
                super();
            }
            };
        }
        if ("subdomain".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ErrorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    error.subdomain = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.ErrorElement.this;
                super();
            }
            };
        }
        if ("exceptionId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ErrorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    error.exceptionId = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.ErrorElement.this;
                super();
            }
            };
        }
        if ("message".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ErrorElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    com.ebay.nautilus.domain.net.EbayResponseError.LongDetails longdetails = error;
                    error.shortMessage = s3;
                    longdetails.longMessage = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.ErrorElement.this;
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
        this$0 = SearchServiceResponseV2.this;
        super();
        error = t;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            ErrorMessageElement, EbayResponse

private static final class error extends com.ebay.nautilus.kernel.util.rror
{
    private final class ActionToTakeElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorMessageElement.ErrorElement this$0;

        public void text(String s)
            throws SAXException
        {
            if ("CONSULTTECHSUPPORT".equalsIgnoreCase(s))
            {
                error.actionToTake = EbayResponseError.RecommendedAction.CONSULTTECHSUPPORT;
            } else
            {
                if ("RETRY".equalsIgnoreCase(s))
                {
                    error.actionToTake = EbayResponseError.RecommendedAction.RETRY;
                    return;
                }
                if ("CORRECTINPUTDATA".equalsIgnoreCase(s))
                {
                    error.actionToTake = EbayResponseError.RecommendedAction.CORRECTINPUTDATA;
                    return;
                }
            }
        }

        private ActionToTakeElement()
        {
            this$0 = ErrorMessageElement.ErrorElement.this;
            super();
        }

        ActionToTakeElement(ErrorMessageElement._cls1 _pcls1)
        {
            this();
        }
    }

    private final class CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorMessageElement.ErrorElement this$0;

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
            this$0 = ErrorMessageElement.ErrorElement.this;
            super();
        }

        CategoryElement(ErrorMessageElement._cls1 _pcls1)
        {
            this();
        }
    }

    private final class MessageElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorMessageElement.ErrorElement this$0;

        public void text(String s)
            throws SAXException
        {
            EbayResponseError.LongDetails longdetails = error;
            error.shortMessage = s;
            longdetails.longMessage = s;
        }

        private MessageElement()
        {
            this$0 = ErrorMessageElement.ErrorElement.this;
            super();
        }

        MessageElement(ErrorMessageElement._cls1 _pcls1)
        {
            this();
        }
    }

    private static final class ParameterElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final EbayResponseError.LongDetails.Parameter parameter;

        public void text(String s)
            throws SAXException
        {
            parameter.value = s;
        }

        public ParameterElement(EbayResponseError.LongDetails.Parameter parameter1, Attributes attributes)
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

        final ErrorMessageElement.ErrorElement this$0;

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
            this$0 = ErrorMessageElement.ErrorElement.this;
            super();
        }

        SeverityElement(ErrorMessageElement._cls1 _pcls1)
        {
            this();
        }
    }


    private final ActionToTakeElement error = new it>();

    public com.ebay.nautilus.kernel.util.rity get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("errorId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ErrorMessageElement.ErrorElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    error.code = s3;
                }

            
            {
                this$0 = ErrorMessageElement.ErrorElement.this;
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

                final ErrorMessageElement.ErrorElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    error.domain = s3;
                }

            
            {
                this$0 = ErrorMessageElement.ErrorElement.this;
                super();
            }
            };
        }
        if ("subdomain".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ErrorMessageElement.ErrorElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    error.subdomain = s3;
                }

            
            {
                this$0 = ErrorMessageElement.ErrorElement.this;
                super();
            }
            };
        }
        if ("exceptionId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final ErrorMessageElement.ErrorElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    error.exceptionId = s3;
                }

            
            {
                this$0 = ErrorMessageElement.ErrorElement.this;
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
            if (error.ameters == null)
            {
                error.ameters = new ArrayList();
            }
            s = new ameter();
            error.ameters.add(s);
            return new ParameterElement(s, attributes);
        }
        if ("actionToTake".equals(s1))
        {
            return new ActionToTakeElement(null);
        } else
        {
            return super.ctionToTakeElement(s, s1, s2, attributes);
        }
    }


    public _cls4.this._cls0(EbayResponse ebayresponse, String s)
    {
        ebayresponse.addResultMessage(new com.ebay.nautilus.kernel.content.is._cls0[] {
            error
        });
    }
}

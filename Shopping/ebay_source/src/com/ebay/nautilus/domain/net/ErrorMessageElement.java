// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayResponse

public final class ErrorMessageElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
{
    private static final class ErrorElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayResponseError.LongDetails error = new EbayResponseError.LongDetails();

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("errorId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        error.code = s;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("category".equals(s1))
            {
                return new CategoryElement();
            }
            if ("severity".equals(s1))
            {
                return new SeverityElement();
            }
            if ("domain".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        error.domain = s;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("subdomain".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        error.subdomain = s;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("exceptionId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        error.exceptionId = s;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("message".equals(s1))
            {
                return new MessageElement();
            }
            if ("parameter".equals(s1))
            {
                if (error.parameters == null)
                {
                    error.parameters = new ArrayList();
                }
                s = new EbayResponseError.LongDetails.Parameter();
                error.parameters.add(s);
                return new ParameterElement(s, attributes);
            }
            if ("actionToTake".equals(s1))
            {
                return new ActionToTakeElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public ErrorElement(EbayResponse ebayresponse, String s)
        {
            ebayresponse.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                error
            });
        }
    }

    private final class ErrorElement.ActionToTakeElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorElement this$0;

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

        private ErrorElement.ActionToTakeElement()
        {
            this$0 = ErrorElement.this;
            super();
        }

    }

    private final class ErrorElement.CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorElement this$0;

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

        private ErrorElement.CategoryElement()
        {
            this$0 = ErrorElement.this;
            super();
        }

    }

    private final class ErrorElement.MessageElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorElement this$0;

        public void text(String s)
            throws SAXException
        {
            EbayResponseError.LongDetails longdetails = error;
            error.shortMessage = s;
            longdetails.longMessage = s;
        }

        private ErrorElement.MessageElement()
        {
            this$0 = ErrorElement.this;
            super();
        }

    }

    private static final class ErrorElement.ParameterElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final EbayResponseError.LongDetails.Parameter parameter;

        public void text(String s)
            throws SAXException
        {
            parameter.value = s;
        }

        public ErrorElement.ParameterElement(EbayResponseError.LongDetails.Parameter parameter1, Attributes attributes)
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

    private final class ErrorElement.SeverityElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorElement this$0;

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

        private ErrorElement.SeverityElement()
        {
            this$0 = ErrorElement.this;
            super();
        }

    }


    private final String namespace;
    private final EbayResponse response;

    public ErrorMessageElement(EbayResponse ebayresponse, String s)
    {
        namespace = s;
        response = ebayresponse;
    }

    public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (namespace.equals(s) && "error".equals(s1))
        {
            return new ErrorElement(response, namespace);
        } else
        {
            return super.get(s, s1, s2, attributes);
        }
    }
}

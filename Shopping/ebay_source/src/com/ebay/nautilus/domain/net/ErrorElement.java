// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayResponse

public final class ErrorElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
{
    private final class ClassificationElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorElement this$0;

        public void text(String s)
            throws SAXException
        {
            if ("RequestError".equals(s))
            {
                error.category = 2;
            } else
            {
                if ("SystemError".equals(s))
                {
                    error.category = 3;
                    return;
                }
                if ("CustomCode".equals(s))
                {
                    error.category = -1;
                    return;
                }
            }
        }

        private ClassificationElement()
        {
            this$0 = ErrorElement.this;
            super();
        }

    }

    private static final class Parameter extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final String namespace;
        private final Value value;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (namespace.equals(s) && "Value".equals(s1))
            {
                return value;
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public Parameter(String s, ArrayList arraylist, Attributes attributes)
        {
            namespace = s;
            int i = -1;
            byte byte0 = i;
            if (attributes != null)
            {
                int l = attributes.getLength();
                int k = 0;
                do
                {
                    byte0 = i;
                    if (k >= l)
                    {
                        break;
                    }
                    s = attributes.getLocalName(k);
                    String s1 = attributes.getValue(k);
                    if ("ParamID".equals(s))
                    {
                        i = Integer.parseInt(s1);
                    }
                    k++;
                } while (true);
            }
            value = new Value(arraylist, byte0);
            if (byte0 != -1)
            {
                int j = byte0 + 1;
                arraylist.ensureCapacity(j);
                for (; arraylist.size() < j; arraylist.add("")) { }
            }
        }
    }

    static final class Parameter.Value extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final int index;
        private final ArrayList parameters;

        public void text(String s)
            throws SAXException
        {
            if (index != -1)
            {
                parameters.set(index, s);
                return;
            } else
            {
                parameters.add(s);
                return;
            }
        }

        public Parameter.Value(ArrayList arraylist, int i)
        {
            parameters = arraylist;
            index = i;
        }
    }

    private final class SeverityElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final ErrorElement this$0;

        public void text(String s)
            throws SAXException
        {
            if ("Error".equals(s))
            {
                error.severity = 1;
            } else
            {
                if ("Warning".equals(s))
                {
                    error.severity = 2;
                    return;
                }
                if ("CustomCode".equals(s))
                {
                    error.severity = -1;
                    return;
                }
            }
        }

        private SeverityElement()
        {
            this$0 = ErrorElement.this;
            super();
        }

    }


    private final EbayResponseError.ShortDetails error = new EbayResponseError.ShortDetails();
    private final String namespace;

    public ErrorElement(EbayResponse ebayresponse, String s)
    {
        namespace = s;
        ebayresponse.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
            error
        });
    }

    public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (namespace.equals(s))
        {
            if ("ErrorClassification".equals(s1))
            {
                return new ClassificationElement();
            }
            if ("ErrorCode".equals(s1) || "errorId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        error.code = s3;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("SeverityCode".equals(s1))
            {
                return new SeverityElement();
            }
            if ("ShortMessage".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        error.shortMessage = s3;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("LongMessage".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        error.longMessage = s3;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("ErrorParameters".equals(s1))
            {
                return new Parameter(namespace, error.parameters, attributes);
            }
            if ("UserDisplayHint".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final ErrorElement this$0;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        error.userDisplay = flag;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
            if ("message".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ErrorElement this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        error.shortMessage = s3;
                        error.longMessage = s3;
                    }

            
            {
                this$0 = ErrorElement.this;
                super();
            }
                };
            }
        }
        return super.get(s, s1, s2, attributes);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mftd;

import com.ebay.common.model.mftd.MessageList;
import com.ebay.common.model.mftd.MessageListResult;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.mftd:
//            GetMFTD

private static final class listResult extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMFTD.GetMFTDResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getMessagesForTheDayResponse".equals(s1))
            {
                return new ResponseElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$0 = GetMFTD.GetMFTDResponse.this;
            super();
        }

        BodyElement(GetMFTD._cls1 _pcls1)
        {
            this();
        }
    }

    private final class MainElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        MessageList ml;
        final GetMFTD.GetMFTDResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("messageId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final MainElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        ml.messageId = i;
                    }

            
            {
                this$1 = MainElement.this;
                super();
            }
                };
            }
            if ("message".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final MainElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        ml.message = s;
                    }

            
            {
                this$1 = MainElement.this;
                super();
            }
                };
            }
            if ("messageType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final MainElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        ml.messageType = s;
                    }

            
            {
                this$1 = MainElement.this;
                super();
            }
                };
            }
            if ("contentType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final MainElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        ml.contentType = s;
                    }

            
            {
                this$1 = MainElement.this;
                super();
            }
                };
            }
            if ("maxNumberOfViews".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final MainElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        ml.maxNumberOfViews = i;
                    }

            
            {
                this$1 = MainElement.this;
                super();
            }
                };
            }
            if ("validFromTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final MainElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        try
                        {
                            ml.validFromTime = EbayDateFormat.parse(s);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            throw new SAXNotRecognizedException(s.getLocalizedMessage());
                        }
                    }

            
            {
                this$1 = MainElement.this;
                super();
            }
                };
            }
            if ("validToTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final MainElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        try
                        {
                            ml.validToTime = EbayDateFormat.parse(s);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            throw new SAXNotRecognizedException(s.getLocalizedMessage());
                        }
                    }

            
            {
                this$1 = MainElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        protected MainElement(MessageList messagelist)
        {
            this$0 = GetMFTD.GetMFTDResponse.this;
            super();
            ml = messagelist;
        }
    }

    private final class ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMFTD.GetMFTDResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(GetMFTD.GetMFTDResponse.this);
            }
            if ("version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        listResult.version = s;
                    }

            
            {
                this$1 = ResponseElement.this;
                super();
            }
                };
            }
            if ("timestamp".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        try
                        {
                            listResult.timestamp = EbayDateFormat.parse(s);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            throw new SAXNotRecognizedException(s.getLocalizedMessage());
                        }
                    }

            
            {
                this$1 = ResponseElement.this;
                super();
            }
                };
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(GetMFTD.GetMFTDResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
            }
            if ("messageList".equals(s1))
            {
                s = new MessageList();
                messageList.add(s);
                return new MainElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseElement()
        {
            this$0 = GetMFTD.GetMFTDResponse.this;
            super();
        }

        ResponseElement(GetMFTD._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMFTD.GetMFTDResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new BodyElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = GetMFTD.GetMFTDResponse.this;
            super();
        }

        RootElement(GetMFTD._cls1 _pcls1)
        {
            this();
        }
    }


    MessageListResult listResult;
    private final List messageList;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.ataException
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }


    protected RootElement()
    {
        listResult = new MessageListResult();
        messageList = listResult.list;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mftd;

import com.ebay.common.model.mftd.MessageList;
import com.ebay.common.model.mftd.MessageListResult;
import com.ebay.common.net.EbayRequestHelper;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xmlpull.v1.XmlSerializer;

public class GetMFTD
{
    private static class GetMFTDRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private static final String CID_TAG = "clientId";
        private static final String CLIENT_ID = "AEAPP";
        private static final String CLIENT_VERSION_TAG = "clientVersion";
        private static final String LANGUAGE_TAG = "language";
        private static final String operationName = "getMessagesForTheDay";

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            xmlserializer.setPrefix("soap", "http://schemas.xmlsoap.org/soap/envelope/");
            xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/mobile/v1/services");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "getMessagesForTheDayRequest");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "clientId", "AEAPP");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "clientVersion", GetMFTD.mftdClientVersion);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "language", Locale.getDefault().getLanguage());
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "getMessagesForTheDayRequest");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(EbaySettings.appListApi);
        }

        public GetMFTDResponse getResponse()
        {
            return new GetMFTDResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public GetMFTDRequest(String s, EbaySite ebaysite)
        {
            super("MessagesForTheDayService", true, "getMessagesForTheDay");
            super.iafToken = null;
            super.soaGlobalId = ebaysite.idString;
            super.soaMessageProtocol = "SOAP12";
            super.dataFormat = "XML";
            super.soaContentType = "text/xml";
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        }
    }

    private static final class GetMFTDResponse extends EbayResponse
    {

        MessageListResult listResult;
        private final List messageList;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }


        protected GetMFTDResponse()
        {
            listResult = new MessageListResult();
            messageList = listResult.list;
        }
    }

    private final class GetMFTDResponse.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMFTDResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getMessagesForTheDayResponse".equals(s1))
            {
                return new GetMFTDResponse.ResponseElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetMFTDResponse.BodyElement()
        {
            this$0 = GetMFTDResponse.this;
            super();
        }

    }

    private final class GetMFTDResponse.MainElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        MessageList ml;
        final GetMFTDResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("messageId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetMFTDResponse.MainElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        ml.messageId = i;
                    }

            
            {
                this$1 = GetMFTDResponse.MainElement.this;
                super();
            }
                };
            }
            if ("message".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMFTDResponse.MainElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        ml.message = s;
                    }

            
            {
                this$1 = GetMFTDResponse.MainElement.this;
                super();
            }
                };
            }
            if ("messageType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMFTDResponse.MainElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        ml.messageType = s;
                    }

            
            {
                this$1 = GetMFTDResponse.MainElement.this;
                super();
            }
                };
            }
            if ("contentType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMFTDResponse.MainElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        ml.contentType = s;
                    }

            
            {
                this$1 = GetMFTDResponse.MainElement.this;
                super();
            }
                };
            }
            if ("maxNumberOfViews".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetMFTDResponse.MainElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        ml.maxNumberOfViews = i;
                    }

            
            {
                this$1 = GetMFTDResponse.MainElement.this;
                super();
            }
                };
            }
            if ("validFromTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMFTDResponse.MainElement this$1;

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
                this$1 = GetMFTDResponse.MainElement.this;
                super();
            }
                };
            }
            if ("validToTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMFTDResponse.MainElement this$1;

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
                this$1 = GetMFTDResponse.MainElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        protected GetMFTDResponse.MainElement(MessageList messagelist)
        {
            this$0 = GetMFTDResponse.this;
            super();
            ml = messagelist;
        }
    }

    private final class GetMFTDResponse.ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMFTDResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(GetMFTDResponse.this);
            }
            if ("version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMFTDResponse.ResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        listResult.version = s;
                    }

            
            {
                this$1 = GetMFTDResponse.ResponseElement.this;
                super();
            }
                };
            }
            if ("timestamp".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMFTDResponse.ResponseElement this$1;

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
                this$1 = GetMFTDResponse.ResponseElement.this;
                super();
            }
                };
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(GetMFTDResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
            }
            if ("messageList".equals(s1))
            {
                s = new MessageList();
                messageList.add(s);
                return new GetMFTDResponse.MainElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetMFTDResponse.ResponseElement()
        {
            this$0 = GetMFTDResponse.this;
            super();
        }

    }

    private final class GetMFTDResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMFTDResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new GetMFTDResponse.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetMFTDResponse.RootElement()
        {
            this$0 = GetMFTDResponse.this;
            super();
        }

    }


    private static String mftdClientVersion = "unknown";

    public GetMFTD()
    {
    }

    static MessageListResult go(EbayContext ebaycontext, String s, String s1, EbaySite ebaysite)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        mftdClientVersion = new String(s1);
        return ((GetMFTDResponse)EbayRequestHelper.sendRequest(ebaycontext, new GetMFTDRequest(s, ebaysite))).listResult;
    }


}

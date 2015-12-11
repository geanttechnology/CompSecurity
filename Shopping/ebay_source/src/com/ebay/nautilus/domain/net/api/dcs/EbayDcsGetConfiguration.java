// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.dcs;

import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

public final class EbayDcsGetConfiguration
{
    public static final class GetConfigurationRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        static final String REQUEST_NAME = "getConfigurationRequest";
        static final int TIMEOUT = 0x15f90;
        private final String currConfigVersion;
        private final String siteId;
        private final URL url;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            Object obj = getEbayContext();
            String s = EbayAppCredentials.get(((EbayContext) (obj))).appName;
            obj = ((EbayContext) (obj)).getAppInfo().getAppVersionWithoutBuildNumber();
            xmlserializer.setPrefix("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/mobile/v1/services");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "getConfigurationRequest");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "applicationName", s);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "applicationVersion", ((String) (obj)));
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "currentConfigurationVersion", currConfigVersion);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "siteId", siteId);
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "getConfigurationRequest");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        }

        public URL getRequestUrl()
        {
            return url;
        }

        public GetConfigurationResponse getResponse()
        {
            return new GetConfigurationResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public GetConfigurationRequest(URL url1, String s, EbaySite ebaysite)
        {
            super("DeviceConfigurationService", true, "getConfiguration");
            super.soaMessageProtocol = "SOAP12";
            super.soaContentType = "text/xml";
            super.timeout = 0x15f90;
            url = url1;
            currConfigVersion = s;
            siteId = ebaysite.id;
        }
    }

    public static final class GetConfigurationResponse extends EbayResponse
    {

        public String configName;
        public String configVersion;
        public final HashMap properties = new HashMap();
        public String timestamp;
        public String version;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }

        public GetConfigurationResponse()
        {
        }
    }

    private final class GetConfigurationResponse.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetConfigurationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getConfigurationResponse".equals(s1))
            {
                return new GetConfigurationResponse.GetConfigurationResponseElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetConfigurationResponse.BodyElement()
        {
            this$0 = GetConfigurationResponse.this;
            super();
        }

    }

    private final class GetConfigurationResponse.ConfigurationElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetConfigurationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetConfigurationResponse.ConfigurationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        configName = s;
                    }

            
            {
                this$1 = GetConfigurationResponse.ConfigurationElement.this;
                super();
            }
                };
            }
            if ("property".equals(s1))
            {
                return new GetConfigurationResponse.PropertyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetConfigurationResponse.ConfigurationElement()
        {
            this$0 = GetConfigurationResponse.this;
            super();
        }

    }

    private final class GetConfigurationResponse.GetConfigurationResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetConfigurationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(GetConfigurationResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(GetConfigurationResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
            }
            if ("version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetConfigurationResponse.GetConfigurationResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        version = s;
                    }

            
            {
                this$1 = GetConfigurationResponse.GetConfigurationResponseElement.this;
                super();
            }
                };
            }
            if ("timestamp".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetConfigurationResponse.GetConfigurationResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        timestamp = s;
                    }

            
            {
                this$1 = GetConfigurationResponse.GetConfigurationResponseElement.this;
                super();
            }
                };
            }
            if ("configurationVersion".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetConfigurationResponse.GetConfigurationResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        configVersion = s;
                    }

            
            {
                this$1 = GetConfigurationResponse.GetConfigurationResponseElement.this;
                super();
            }
                };
            }
            if ("configuration".equals(s1))
            {
                return new GetConfigurationResponse.ConfigurationElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetConfigurationResponse.GetConfigurationResponseElement()
        {
            this$0 = GetConfigurationResponse.this;
            super();
        }

    }

    private final class GetConfigurationResponse.PropertyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private String name;
        final GetConfigurationResponse this$0;
        private String value;

        private void addIfReady()
        {
            if (name != null && value != null)
            {
                properties.put(name, value);
            }
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetConfigurationResponse.PropertyElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        setName(s);
                    }

            
            {
                this$1 = GetConfigurationResponse.PropertyElement.this;
                super();
            }
                };
            }
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetConfigurationResponse.PropertyElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        setValue(s);
                    }

            
            {
                this$1 = GetConfigurationResponse.PropertyElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        void setName(String s)
        {
            name = new String(s);
            addIfReady();
        }

        void setValue(String s)
        {
            value = new String(s);
            addIfReady();
        }

        private GetConfigurationResponse.PropertyElement()
        {
            this$0 = GetConfigurationResponse.this;
            super();
        }

    }

    private final class GetConfigurationResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetConfigurationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://schemas.xmlsoap.org/soap/envelope/".equals(s) && "Body".equals(s1))
            {
                return new GetConfigurationResponse.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetConfigurationResponse.RootElement()
        {
            this$0 = GetConfigurationResponse.this;
            super();
        }

    }


    private EbayDcsGetConfiguration()
    {
    }
}

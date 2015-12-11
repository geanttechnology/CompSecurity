// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.dcs;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.dcs:
//            EbayDcsGetConfiguration

public static final class RootElement extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbayDcsGetConfiguration.GetConfigurationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getConfigurationResponse".equals(s1))
            {
                return new GetConfigurationResponseElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$0 = EbayDcsGetConfiguration.GetConfigurationResponse.this;
            super();
        }

        BodyElement(EbayDcsGetConfiguration._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ConfigurationElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbayDcsGetConfiguration.GetConfigurationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ConfigurationElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        configName = s;
                    }

            
            {
                this$1 = ConfigurationElement.this;
                super();
            }
                };
            }
            if ("property".equals(s1))
            {
                return new PropertyElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ConfigurationElement()
        {
            this$0 = EbayDcsGetConfiguration.GetConfigurationResponse.this;
            super();
        }

        ConfigurationElement(EbayDcsGetConfiguration._cls1 _pcls1)
        {
            this();
        }
    }

    private final class GetConfigurationResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbayDcsGetConfiguration.GetConfigurationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(EbayDcsGetConfiguration.GetConfigurationResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(EbayDcsGetConfiguration.GetConfigurationResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
            }
            if ("version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetConfigurationResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        version = s;
                    }

            
            {
                this$1 = GetConfigurationResponseElement.this;
                super();
            }
                };
            }
            if ("timestamp".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetConfigurationResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        timestamp = s;
                    }

            
            {
                this$1 = GetConfigurationResponseElement.this;
                super();
            }
                };
            }
            if ("configurationVersion".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetConfigurationResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        configVersion = s;
                    }

            
            {
                this$1 = GetConfigurationResponseElement.this;
                super();
            }
                };
            }
            if ("configuration".equals(s1))
            {
                return new ConfigurationElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetConfigurationResponseElement()
        {
            this$0 = EbayDcsGetConfiguration.GetConfigurationResponse.this;
            super();
        }

        GetConfigurationResponseElement(EbayDcsGetConfiguration._cls1 _pcls1)
        {
            this();
        }
    }

    private final class PropertyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private String name;
        final EbayDcsGetConfiguration.GetConfigurationResponse this$0;
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

                    final PropertyElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        setName(s);
                    }

            
            {
                this$1 = PropertyElement.this;
                super();
            }
                };
            }
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PropertyElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        setValue(s);
                    }

            
            {
                this$1 = PropertyElement.this;
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

        private PropertyElement()
        {
            this$0 = EbayDcsGetConfiguration.GetConfigurationResponse.this;
            super();
        }

        PropertyElement(EbayDcsGetConfiguration._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final EbayDcsGetConfiguration.GetConfigurationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://schemas.xmlsoap.org/soap/envelope/".equals(s) && "Body".equals(s1))
            {
                return new BodyElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = EbayDcsGetConfiguration.GetConfigurationResponse.this;
            super();
        }

        RootElement(EbayDcsGetConfiguration._cls1 _pcls1)
        {
            this();
        }
    }


    public String configName;
    public String configVersion;
    public final HashMap properties = new HashMap();
    public String timestamp;
    public String version;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.esponse
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }

    public RootElement()
    {
    }
}

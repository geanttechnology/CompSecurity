// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.mts;

import android.content.Context;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.net.IHeader;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.IResponseHeaderHandler;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.analytics.mts:
//            AnalyticsProviderModule

public final class TrackEventResponse extends EbayResponse
    implements IResponseHeaderHandler
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final TrackEventResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("trackEventResponse".equals(s1))
            {
                return new ResponseElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$0 = TrackEventResponse.this;
            super();
        }

    }

    private final class ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final TrackEventResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
            {
                if ("ack".equals(s1))
                {
                    return new AckElement(TrackEventResponse.this);
                }
                if ("timestamp".equals(s1))
                {
                    return new TimestampElement(TrackEventResponse.this);
                }
                if ("errorMessage".equals(s1))
                {
                    return new ErrorMessageElement(TrackEventResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
                }
                if ("responseProperties".equals(s1))
                {
                    return new ResponsePropertiesElement();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private ResponseElement()
        {
            this$0 = TrackEventResponse.this;
            super();
        }

    }

    private final class ResponsePropertiesElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        String lastKey;
        final TrackEventResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("key".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponsePropertiesElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        lastKey = s;
                    }

            
            {
                this$1 = ResponsePropertiesElement.this;
                super();
            }
                };
            }
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponsePropertiesElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if ("rovercookie".equals(lastKey))
                        {
                            AnalyticsProviderModule.saveCookie(context, s);
                        }
                    }

            
            {
                this$1 = ResponsePropertiesElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponsePropertiesElement()
        {
            this$0 = TrackEventResponse.this;
            super();
            lastKey = "";
        }

    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final TrackEventResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = TrackEventResponse.this;
            super();
        }

    }


    private static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobile/v1/services";
    private final Context context;

    TrackEventResponse(Context context1)
    {
        context = context1;
    }

    public IResponseHeaderHandler getHeaderHandler()
    {
        return this;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }

    public void readHeaders(IHeaders iheaders)
    {
        if (AnalyticsProviderModule.verboseLogger.isLoggable)
        {
            iheaders = iheaders.iterator();
            do
            {
                if (!iheaders.hasNext())
                {
                    break;
                }
                Object obj = (IHeader)iheaders.next();
                obj = new String((new StringBuilder()).append("<< ").append(((IHeader) (obj)).getName()).append(": ").append(((IHeader) (obj)).getValue()).toString());
                if (AnalyticsProviderModule.verboseLogger.isLoggable)
                {
                    AnalyticsProviderModule.verboseLogger.log(((String) (obj)));
                }
            } while (true);
        }
    }

}

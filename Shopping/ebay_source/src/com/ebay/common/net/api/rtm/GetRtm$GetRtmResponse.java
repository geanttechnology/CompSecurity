// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.rtm;

import android.util.Base64;
import com.ebay.common.rtm.RtmContentResult;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import com.ebay.nautilus.kernel.util.XmlFormatter;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.rtm:
//            GetRtm, EbayRtmApi

public static final class rcr extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRtm.GetRtmResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getRTMContentResponse".equals(s1))
            {
                return new ResponseElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$0 = GetRtm.GetRtmResponse.this;
            super();
        }

        BodyElement(GetRtm._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRtm.GetRtmResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(GetRtm.GetRtmResponse.this);
            }
            if ("version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        rcr.setVersion(s);
                    }

            
            {
                this$1 = ResponseElement.this;
                super();
            }
                };
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(GetRtm.GetRtmResponse.this, "http://www.ebay.com/marketplace/mobileor/v1/commonservices");
            }
            if ("rtmContent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ResponseElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if (EbayRtmApi.debugLogger.isLoggable)
                        {
                            EbayRtmApi.debugLogger.log(XmlFormatter.format(Base64.decode(s, 0)));
                        }
                        rcr.rtmContentBase64 = s;
                    }

            
            {
                this$1 = ResponseElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseElement()
        {
            this$0 = GetRtm.GetRtmResponse.this;
            super();
        }

        ResponseElement(GetRtm._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRtm.GetRtmResponse this$0;

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
            this$0 = GetRtm.GetRtmResponse.this;
            super();
        }

        RootElement(GetRtm._cls1 _pcls1)
        {
            this();
        }
    }


    public RtmContentResult rcr;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.eDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }

    protected RootElement()
    {
        rcr = new RtmContentResult();
    }
}

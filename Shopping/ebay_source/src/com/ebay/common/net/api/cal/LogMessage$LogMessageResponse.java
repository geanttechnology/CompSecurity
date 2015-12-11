// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cal;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.cal:
//            LogMessage

public static final class RootElement extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final LogMessage.LogMessageResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("logMessageResponse".equals(s1))
            {
                return new ResponseElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$0 = LogMessage.LogMessageResponse.this;
            super();
        }

        BodyElement(LogMessage._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final LogMessage.LogMessageResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(LogMessage.LogMessageResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(LogMessage.LogMessageResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(LogMessage.LogMessageResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseElement()
        {
            this$0 = LogMessage.LogMessageResponse.this;
            super();
        }

        ResponseElement(LogMessage._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final LogMessage.LogMessageResponse this$0;

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
            this$0 = LogMessage.LogMessageResponse.this;
            super();
        }

        RootElement(LogMessage._cls1 _pcls1)
        {
            this();
        }
    }


    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.eption
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }

    public RootElement()
    {
    }
}

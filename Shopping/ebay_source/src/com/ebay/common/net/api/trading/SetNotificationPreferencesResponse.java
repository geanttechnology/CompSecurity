// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class SetNotificationPreferencesResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayResponse resp;
        final SetNotificationPreferencesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(resp);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(resp);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(resp, "urn:ebay:apis:eBLBaseComponents");
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = SetNotificationPreferencesResponse.this;
            super();
            resp = SetNotificationPreferencesResponse.this;
        }

    }


    public SetNotificationPreferencesResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class WatchListChangeResponse extends EbayResponse
{
    private static final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final WatchListChangeResponse response;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(response);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(response);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(response, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("WatchListCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final RootElement this$0;

                        public void setValue(int i)
                            throws SAXException
                        {
                            response.itemCount = i;
                        }

            
            {
                this$0 = RootElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement(WatchListChangeResponse watchlistchangeresponse)
        {
            response = watchlistchangeresponse;
        }
    }


    public int itemCount;

    public WatchListChangeResponse()
    {
        itemCount = 0;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement(this));
    }
}

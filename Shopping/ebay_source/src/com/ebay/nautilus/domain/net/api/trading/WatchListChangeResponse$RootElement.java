// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            WatchListChangeResponse

private static final class response extends com.ebay.nautilus.kernel.util.ootElement
{

    final WatchListChangeResponse response;

    public com.ebay.nautilus.kernel.util.ootElement get(String s, String s1, String s2, Attributes attributes)
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

                    final WatchListChangeResponse.RootElement this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        response.itemCount = i;
                    }

            
            {
                this$0 = WatchListChangeResponse.RootElement.this;
                super();
            }
                };
            }
        }
        return super.ootElement(s, s1, s2, attributes);
    }

    public _cls1.this._cls0(WatchListChangeResponse watchlistchangeresponse)
    {
        response = watchlistchangeresponse;
    }
}

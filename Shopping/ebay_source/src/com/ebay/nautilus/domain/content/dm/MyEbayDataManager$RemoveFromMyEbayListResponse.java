// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayDataManager

static class RootElement extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final MyEbayDataManager.RemoveFromMyEbayListResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(MyEbayDataManager.RemoveFromMyEbayListResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(MyEbayDataManager.RemoveFromMyEbayListResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(MyEbayDataManager.RemoveFromMyEbayListResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = MyEbayDataManager.RemoveFromMyEbayListResponse.this;
            super();
        }

        RootElement(MyEbayDataManager._cls1 _pcls1)
        {
            this();
        }
    }


    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.sponse
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }

    RootElement()
    {
    }
}

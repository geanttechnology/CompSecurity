// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.notifications:
//            PushService

private static class <init> extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final PushService.LogNotificationResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(PushService.LogNotificationResponse.this);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = PushService.LogNotificationResponse.this;
            super();
        }

        RootElement(PushService._cls1 _pcls1)
        {
            this();
        }
    }


    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }

    private RootElement()
    {
    }

    RootElement(RootElement rootelement)
    {
        this();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.favseller:
//            RmFavoriteSeller

public static final class RootElement extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RmFavoriteSeller.RmResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("removeFavoriteSellersResponse".equals(s1))
            {
                return new ResponseElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$0 = RmFavoriteSeller.RmResponse.this;
            super();
        }

        BodyElement(RmFavoriteSeller._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RmFavoriteSeller.RmResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(RmFavoriteSeller.RmResponse.this);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResponseElement()
        {
            this$0 = RmFavoriteSeller.RmResponse.this;
            super();
        }

        ResponseElement(RmFavoriteSeller._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RmFavoriteSeller.RmResponse this$0;

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
            this$0 = RmFavoriteSeller.RmResponse.this;
            super();
        }

        RootElement(RmFavoriteSeller._cls1 _pcls1)
        {
            this();
        }
    }


    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.xception
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }

    protected RootElement()
    {
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.mobile.analytics:
//            RoiTrackEventResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t>
{
    private final class RoiTrackEventResponses extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RoiTrackEventResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s) && "roiFactoryResponse".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RoiTrackEventResponses this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        if (urls == null)
                        {
                            urls = new ArrayList();
                        }
                        urls.add(s);
                    }

            
            {
                this$2 = RoiTrackEventResponses.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RoiTrackEventResponses()
        {
            this$1 = RoiTrackEventResponse.RootElement.this;
            super();
        }

        RoiTrackEventResponses(RoiTrackEventResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final RoiTrackEventResponse this$0;

    public com.ebay.nautilus.kernel.util.rackEventResponses get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/mobile/v1/services".equals(s))
        {
            if ("ack".equals(s1))
            {
                return new AckElement(RoiTrackEventResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(RoiTrackEventResponse.this, "http://www.ebay.com/marketplace/mobile/v1/services");
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(RoiTrackEventResponse.this);
            }
            if ("roiFactoryResponses".equals(s1))
            {
                return new RoiTrackEventResponses(null);
            }
        }
        return super.rackEventResponses(s, s1, s2, attributes);
    }

    private RoiTrackEventResponses()
    {
        this$0 = RoiTrackEventResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import com.ebay.nautilus.kernel.io.DirectByteArrayInputStream;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper, RtmContentResult, RtmContent

private class ace
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseDecodedBase64 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("MessageId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BodyElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.messageId = s;
                    }

            
            {
                this$2 = BodyElement.this;
                super();
            }
                };
            }
            if ("CampaignId".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BodyElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.campaignId = s;
                    }

            
            {
                this$2 = BodyElement.this;
                super();
            }
                };
            }
            if ("Content".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BodyElement this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        RtmHelper.access$100(this$0).rc.rawContent = s;
                    }

            
            {
                this$2 = BodyElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$1 = RtmHelper.parseDecodedBase64.this;
            super();
        }

        BodyElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RtmHelper.parseDecodedBase64 this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Placement".equals(s1))
            {
                int j = attributes.getLength();
                for (int i = 0; i < j; i++)
                {
                    if ("id".equals(attributes.getLocalName(i)))
                    {
                        RtmHelper.access$100(this$0).rc.placement = attributes.getValue(i);
                    }
                }

                return new BodyElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$1 = RtmHelper.parseDecodedBase64.this;
            super();
        }

        RootElement(RtmHelper._cls1 _pcls1)
        {
            this();
        }
    }


    final RtmHelper this$0;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.ception
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }

    public RootElement(String s)
    {
        this$0 = RtmHelper.this;
        super();
        try
        {
            parse(new DirectByteArrayInputStream(s.getBytes()));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RtmHelper rtmhelper)
        {
            printStackTrace();
        }
    }
}

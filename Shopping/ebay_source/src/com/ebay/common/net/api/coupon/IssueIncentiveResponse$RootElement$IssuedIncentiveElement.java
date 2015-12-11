// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.coupon;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.coupon:
//            IssueIncentiveResponse

private final class <init> extends com.ebay.nautilus.kernel.util.
{
    private final class MessageElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final IssueIncentiveResponse.RootElement.IssuedIncentiveElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if (domain.equals(s))
            {
                if ("title".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final MessageElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            response.title = s;
                        }

            
            {
                this$2 = MessageElement.this;
                super();
            }
                    };
                }
                if ("primaryBodyText".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final MessageElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            response.primaryBody = s;
                        }

            
            {
                this$2 = MessageElement.this;
                super();
            }
                    };
                }
                if ("secondaryBodyText".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final MessageElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            response.secondaryBody = s;
                        }

            
            {
                this$2 = MessageElement.this;
                super();
            }
                    };
                }
                if ("buttonText".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final MessageElement this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            response.buttonText = s;
                        }

            
            {
                this$2 = MessageElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private MessageElement()
        {
            this$1 = IssueIncentiveResponse.RootElement.IssuedIncentiveElement.this;
            super();
        }

        MessageElement(IssueIncentiveResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final MessageElement this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (this._cls0.this.MessageElement.equals(s) && "message".equals(s1))
        {
            return new MessageElement(null);
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    private MessageElement()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}

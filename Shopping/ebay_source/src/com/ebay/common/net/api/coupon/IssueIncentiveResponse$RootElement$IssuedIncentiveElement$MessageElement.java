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

    final _cls4 this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (this._cls1.this.<init>.<init>.equals(s))
        {
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final IssueIncentiveResponse.RootElement.IssuedIncentiveElement.MessageElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        response.title = s3;
                    }

            
            {
                this$2 = IssueIncentiveResponse.RootElement.IssuedIncentiveElement.MessageElement.this;
                super();
            }
                };
            }
            if ("primaryBodyText".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final IssueIncentiveResponse.RootElement.IssuedIncentiveElement.MessageElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        response.primaryBody = s3;
                    }

            
            {
                this$2 = IssueIncentiveResponse.RootElement.IssuedIncentiveElement.MessageElement.this;
                super();
            }
                };
            }
            if ("secondaryBodyText".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final IssueIncentiveResponse.RootElement.IssuedIncentiveElement.MessageElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        response.secondaryBody = s3;
                    }

            
            {
                this$2 = IssueIncentiveResponse.RootElement.IssuedIncentiveElement.MessageElement.this;
                super();
            }
                };
            }
            if ("buttonText".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final IssueIncentiveResponse.RootElement.IssuedIncentiveElement.MessageElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        response.buttonText = s3;
                    }

            
            {
                this$2 = IssueIncentiveResponse.RootElement.IssuedIncentiveElement.MessageElement.this;
                super();
            }
                };
            }
        }
        return super.(s, s1, s2, attributes);
    }

    private _cls4.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}

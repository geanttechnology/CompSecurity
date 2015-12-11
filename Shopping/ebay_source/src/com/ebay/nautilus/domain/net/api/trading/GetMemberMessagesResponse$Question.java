// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMemberMessagesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.e.Question
{

    final GetMemberMessagesResponse this$0;

    public com.ebay.nautilus.kernel.util.e.Question get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("SenderID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMemberMessagesResponse.Question this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.sender(s3);
                    }

            
            {
                this$1 = GetMemberMessagesResponse.Question.this;
                super();
            }
                };
            }
            if ("Subject".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMemberMessagesResponse.Question this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.subject(s3);
                    }

            
            {
                this$1 = GetMemberMessagesResponse.Question.this;
                super();
            }
                };
            }
            if ("MessageID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMemberMessagesResponse.Question this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.messageId(s3);
                    }

            
            {
                this$1 = GetMemberMessagesResponse.Question.this;
                super();
            }
                };
            }
        }
        return super.Question(s, s1, s2, attributes);
    }

    private _cls3.this._cls1()
    {
        this$0 = GetMemberMessagesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

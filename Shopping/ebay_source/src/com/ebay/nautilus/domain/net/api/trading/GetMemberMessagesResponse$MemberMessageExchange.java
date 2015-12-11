// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMemberMessagesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.geExchange
{

    final GetMemberMessagesResponse this$0;

    public com.ebay.nautilus.kernel.util.geExchange get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Item".equals(s1))
            {
                return new <init>(GetMemberMessagesResponse.this, null);
            }
            if ("Question".equals(s1))
            {
                return new this._cls0(GetMemberMessagesResponse.this, null);
            }
            if ("CreationDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetMemberMessagesResponse.MemberMessageExchange this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        builder.receiveDate(EbayDateUtils.parseXml(s3));
                    }

            
            {
                this$1 = GetMemberMessagesResponse.MemberMessageExchange.this;
                super();
            }
                };
            }
        }
        return super.geExchange(s, s1, s2, attributes);
    }

    private _cls1.this._cls1()
    {
        this$0 = GetMemberMessagesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

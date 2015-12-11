// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMemberMessagesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ponse.Item
{

    final GetMemberMessagesResponse this$0;

    public com.ebay.nautilus.kernel.util.ponse.Item get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("ItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetMemberMessagesResponse.Item this$1;

                    public void setValue(long l)
                        throws SAXException
                    {
                        builder.itemId(l);
                    }

            
            {
                this$1 = GetMemberMessagesResponse.Item.this;
                super();
            }
                };
            }
            if ("ListingDetails".equals(s1))
            {
                return new ngDetails(GetMemberMessagesResponse.this, null);
            }
        }
        return super._mth1(s, s1, s2, attributes);
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

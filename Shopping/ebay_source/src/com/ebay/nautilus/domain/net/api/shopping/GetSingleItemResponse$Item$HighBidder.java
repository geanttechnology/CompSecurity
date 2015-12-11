// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class <init> extends com.ebay.nautilus.kernel.util..HighBidder
{

    final _cls1 this$1;

    public com.ebay.nautilus.kernel.util..HighBidder get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "UserID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.HighBidder this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.highBidderUserId = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.HighBidder.this;
                super();
            }
            };
        } else
        {
            return super.HighBidder(s, s1, s2, attributes);
        }
    }

    private _cls1.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}

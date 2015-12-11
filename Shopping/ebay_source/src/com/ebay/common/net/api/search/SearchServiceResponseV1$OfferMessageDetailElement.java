// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class <init> extends com.ebay.nautilus.kernel.util.
{

    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("legalTextMessage".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.OfferMessageDetailElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    SearchServiceResponseV1.access$2400(this$0).legalTextMessage = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.OfferMessageDetailElement.this;
                super();
            }
            };
        }
        if ("textMessage".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.OfferMessageDetailElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    SearchServiceResponseV1.access$2400(this$0).textMessage = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.OfferMessageDetailElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    private _cls2.this._cls1()
    {
        this$0 = SearchServiceResponseV1.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

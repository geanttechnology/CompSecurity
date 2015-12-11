// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyMessagesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.nseDetails
{

    final _cls1 this$1;

    public com.ebay.nautilus.kernel.util.nseDetails get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ResponseEnabled".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final GetMyMessagesResponse.Message.ResponseDetails this$2;

                public void setValue(boolean flag)
                    throws SAXException
                {
                    builder.responseEnabled(flag);
                }

            
            {
                this$2 = GetMyMessagesResponse.Message.ResponseDetails.this;
                super();
            }
            };
        } else
        {
            return super.nseDetails(s, s1, s2, attributes);
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

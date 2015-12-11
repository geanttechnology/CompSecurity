// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.NameValue;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private final class nameValue extends com.ebay.nautilus.kernel.util.eValueList
{

    protected final NameValue nameValue;
    final nameValue this$0;

    public com.ebay.nautilus.kernel.util.eValueList get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.Item.NameValueList this$1;

                public void text(String s3)
                    throws SAXException
                {
                    nameValue.setName(s3);
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.Item.NameValueList.this;
                super();
            }
            };
        }
        if ("Value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.Item.NameValueList this$1;

                public void text(String s3)
                    throws SAXException
                {
                    nameValue.addValue(s3);
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.Item.NameValueList.this;
                super();
            }
            };
        } else
        {
            return super.eValueList(s, s1, s2, attributes);
        }
    }

    public _cls2.this._cls1(NameValue namevalue)
    {
        this$0 = this._cls0.this;
        super();
        nameValue = namevalue;
    }
}

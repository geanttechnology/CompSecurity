// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

protected class this._cls0 extends com.ebay.nautilus.kernel.util.RootElement
{

    final GetSingleItemResponse this$0;

    public com.ebay.nautilus.kernel.util.RootElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(GetSingleItemResponse.this);
            }
            if ("Version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.RootElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        if (item != null)
                        {
                            item.version = s3;
                        }
                    }

            
            {
                this$1 = GetSingleItemResponse.RootElement.this;
                super();
            }
                };
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(GetSingleItemResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("Item".equals(s1))
            {
                return new this._cls0(GetSingleItemResponse.this);
            }
        }
        return super._mth0(s, s1, s2, attributes);
    }

    protected _cls1.this._cls1()
    {
        this$0 = GetSingleItemResponse.this;
        super();
    }
}

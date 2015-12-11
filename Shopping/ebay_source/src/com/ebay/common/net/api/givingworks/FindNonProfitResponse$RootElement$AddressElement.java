// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            FindNonProfitResponse

private final class data extends com.ebay.nautilus.kernel.util.ement
{

    private final com.ebay.common.model.givingworks.t data;
    final data this$1;

    public com.ebay.nautilus.kernel.util.ement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (FindNonProfitResponse.access$000(this._cls1.this.data).equals(s))
        {
            if ("city".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindNonProfitResponse.RootElement.AddressElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.city = s3;
                    }

            
            {
                this$2 = FindNonProfitResponse.RootElement.AddressElement.this;
                super();
            }
                };
            }
            if ("state".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindNonProfitResponse.RootElement.AddressElement this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.state = s3;
                    }

            
            {
                this$2 = FindNonProfitResponse.RootElement.AddressElement.this;
                super();
            }
                };
            }
        }
        return super.ement(s, s1, s2, attributes);
    }


    public _cls2.this._cls2(com.ebay.common.model.givingworks.t t)
    {
        this$1 = this._cls1.this;
        super();
        data = t;
    }
}

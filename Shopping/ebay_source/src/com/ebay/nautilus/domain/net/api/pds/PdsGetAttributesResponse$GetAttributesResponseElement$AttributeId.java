// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.pds;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.pds:
//            PdsGetAttributesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.buteId
{

    String id;
    final id this$1;

    public com.ebay.nautilus.kernel.util.buteId get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("AttributeId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final PdsGetAttributesResponse.GetAttributesResponseElement.AttributeId this$2;

                public void text(String s3)
                    throws SAXException
                {
                    id = s3;
                }

            
            {
                this$2 = PdsGetAttributesResponse.GetAttributesResponseElement.AttributeId.this;
                super();
            }
            };
        } else
        {
            return super.buteId(s, s1, s2, attributes);
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

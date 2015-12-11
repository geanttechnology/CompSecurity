// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.catalogcontent;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.catalogcontent:
//            GetProductDetailsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.sResponse.Product
{

    final GetProductDetailsResponse this$0;

    public com.ebay.nautilus.kernel.util.sResponse.Product get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("description".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetProductDetailsResponse.Product this$1;

                public void text(String s3)
                    throws SAXException
                {
                    description = s3;
                }

            
            {
                this$1 = GetProductDetailsResponse.Product.this;
                super();
            }
            };
        } else
        {
            return super.Product(s, s1, s2, attributes);
        }
    }

    private _cls1.this._cls1()
    {
        this$0 = GetProductDetailsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

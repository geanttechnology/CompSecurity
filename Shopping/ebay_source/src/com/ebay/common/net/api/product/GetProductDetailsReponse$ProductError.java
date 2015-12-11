// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.product;

import com.ebay.nautilus.domain.net.EbayResponseError;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.product:
//            GetProductDetailsReponse

private final class error extends com.ebay.nautilus.kernel.util.r
{

    private final EbayResponseError error = new EbayResponseError();
    final GetProductDetailsReponse this$0;

    public com.ebay.nautilus.kernel.util.r get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("errorId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetProductDetailsReponse.ProductError this$1;

                public void text(String s3)
                    throws SAXException
                {
                    error.code = s3;
                }

            
            {
                this$1 = GetProductDetailsReponse.ProductError.this;
                super();
            }
            };
        }
        if ("message".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetProductDetailsReponse.ProductError this$1;

                public void text(String s3)
                    throws SAXException
                {
                    error.shortMessage = s3;
                }

            
            {
                this$1 = GetProductDetailsReponse.ProductError.this;
                super();
            }
            };
        } else
        {
            return super.r(s, s1, s2, attributes);
        }
    }


    public _cls2.this._cls1()
    {
        this$0 = GetProductDetailsReponse.this;
        super();
        addResultMessage(new com.ebay.nautilus.kernel.content.ge[] {
            error
        });
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shopping;

import com.ebay.common.model.EbayProduct;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shopping:
//            FindProductsResponse

private final class product extends com.ebay.nautilus.kernel.util.ct
{

    private final EbayProduct product = new EbayProduct();
    final product this$1;

    public com.ebay.nautilus.kernel.util.ct get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindProductsResponse.RootElement.Product this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        product.title = s3;
                    }

            
            {
                this$2 = FindProductsResponse.RootElement.Product.this;
                super();
            }
                };
            }
            if ("ProductID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindProductsResponse.RootElement.Product this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        product.epid = s3;
                    }

            
            {
                this$2 = FindProductsResponse.RootElement.Product.this;
                super();
            }
                };
            }
            if ("StockPhotoURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindProductsResponse.RootElement.Product this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        product.stockPhotoUrl = s3;
                    }

            
            {
                this$2 = FindProductsResponse.RootElement.Product.this;
                super();
            }
                };
            }
            if ("DetailsURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindProductsResponse.RootElement.Product this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        product.detailsUrl = s3;
                    }

            
            {
                this$2 = FindProductsResponse.RootElement.Product.this;
                super();
            }
                };
            }
        }
        return super.ct(s, s1, s2, attributes);
    }


    public _cls4.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
        products.add(product);
    }
}

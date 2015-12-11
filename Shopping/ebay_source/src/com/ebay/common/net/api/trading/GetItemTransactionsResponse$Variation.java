// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.ItemTransactionVariation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.n
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.n get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("SKU".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Variation this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).variation.sku = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Variation.this;
                super();
            }
                };
            }
            if ("VariationTitle".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Variation this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).variation.variationTitle = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Variation.this;
                super();
            }
                };
            }
            if ("VariationViewItemURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Variation this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).variation.variationViewItemURL = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Variation.this;
                super();
            }
                };
            }
            if ("VariationSpecifics".equals(s1))
            {
                return new pecifics(GetItemTransactionsResponse.this, null);
            }
        }
        return super._mth0(s, s1, s2, attributes);
    }

    private _cls3.this._cls1()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

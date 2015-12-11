// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.Variation;
import com.ebay.nautilus.domain.net.CurrencyElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class this._cls1 extends com.ebay.nautilus.kernel.util.ariationXml
{

    final _cls3.val.variation this$1;

    public com.ebay.nautilus.kernel.util.ariationXml get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            final Variation variation = (Variation)item.variations.get(item.variations.size() - 1);
            if ("Quantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item.VariationXml this$2;
                    final Variation val$variation;

                    public void setValue(int i)
                        throws SAXException
                    {
                        variation.setQuantity(i);
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.VariationXml.this;
                variation = variation1;
                super();
            }
                };
            }
            if ("SellingStatus".equals(s1))
            {
                return new (this._cls1.this, variation);
            }
            if ("VariationSpecifics".equals(s1))
            {
                return new ifics(this._cls1.this, variation);
            }
            if ("SKU".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.VariationXml this$2;
                    final Variation val$variation;

                    public void text(String s3)
                        throws SAXException
                    {
                        variation.setSKU(s3);
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.VariationXml.this;
                variation = variation1;
                super();
            }
                };
            }
            if ("".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.VariationXml this$2;
                    final Variation val$variation;

                    public void text(String s3)
                        throws SAXException
                    {
                        variation.setSKU(s3);
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.VariationXml.this;
                variation = variation1;
                super();
            }
                };
            }
            if ("StartPrice".equals(s1))
            {
                return new CurrencyElement(variation.getStartPrice(), "currencyID", attributes);
            }
        }
        return super.ariationXml(s, s1, s2, attributes);
    }

    public _cls3.val.variation()
    {
        this$1 = this._cls1.this;
        super();
        item.variations.add(new Variation());
    }
}

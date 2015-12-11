// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class <init> extends com.ebay.nautilus.kernel.util.em.UnitInfo
{

    final _cls2 this$1;

    public com.ebay.nautilus.kernel.util.em.UnitInfo get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("UnitType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.UnitInfo this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.unitPriceType = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.UnitInfo.this;
                super();
            }
                };
            }
            if ("UnitQuantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.UnitInfo this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.unitPriceQuantity = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.UnitInfo.this;
                super();
            }
                };
            }
        }
        return super.UnitInfo(s, s1, s2, attributes);
    }

    private _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ntPriceInfo
{

    final _cls4 this$1;

    public com.ebay.nautilus.kernel.util.ntPriceInfo get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("MinimumAdvertisedPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.dpiMinimumAdvertisedPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("MinimumAdvertisedPriceExposure".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.DiscountPriceInfo this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.dpiMinimumAdvertisedPriceExposure = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.DiscountPriceInfo.this;
                super();
            }
                };
            }
            if ("OriginalRetailPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.originalRetailPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("PricingTreatment".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.DiscountPriceInfo this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.pricingTreatment = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.DiscountPriceInfo.this;
                super();
            }
                };
            }
            if ("SoldOffeBay".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetSingleItemResponse.Item.DiscountPriceInfo this$2;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.dpiSoldOffEbay = flag;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.DiscountPriceInfo.this;
                super();
            }
                };
            }
            if ("SoldOneBay".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetSingleItemResponse.Item.DiscountPriceInfo this$2;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.dpiSoldOnEbay = flag;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.DiscountPriceInfo.this;
                super();
            }
                };
            }
        }
        return super.ntPriceInfo(s, s1, s2, attributes);
    }

    private _cls4.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}

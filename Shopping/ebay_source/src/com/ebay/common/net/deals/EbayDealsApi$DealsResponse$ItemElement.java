// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.deals;

import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.ParseException;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.deals:
//            EbayDealsApi

static final class _cls2.energyRatingElement extends com.ebay.nautilus.kernel.util.ergyRatingElement
{

    com.ebay.nautilus.kernel.util.dataElement detailsElement;
    com.ebay.common.model.ent.metadataElement item;
    com.ebay.nautilus.kernel.util.dataElement metadataElement;

    _cls2.energyRatingElement get(List list, Attributes attributes)
    {
        item = new com.ebay.common.model.ent.item();
        int j = attributes.getLength();
        for (int i = 0; i < j; i++)
        {
            if ("ItemID".equals(attributes.getLocalName(i)))
            {
                item.item = Long.parseLong(attributes.getValue(i));
            }
        }

        list.add(item);
        return this;
    }

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ItemDetails".equals(s1))
        {
            return detailsElement;
        }
        if ("ItemMetaData".equals(s1))
        {
            return metadataElement;
        } else
        {
            return super.dataElement(s, s1, s2, attributes);
        }
    }

    _cls2()
    {
        item = null;
        detailsElement = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

            com.ebay.nautilus.kernel.util.SaxHandler.TextElement imageUrlElement;
            final EbayDealsApi.DealsResponse.ItemElement this$0;
            com.ebay.nautilus.kernel.util.SaxHandler.TextElement titleElement;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("Title".equals(s1))
                {
                    return titleElement;
                }
                if ("GalleryURL".equals(s1))
                {
                    return imageUrlElement;
                }
                if ("ConvertedCurrentPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.convertedCurrentPrice = s1;
                    return new CurrencyElement(s1, "CurrencyID", attributes);
                }
                if ("RRP".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.origRetailPrice = s1;
                    return new CurrencyElement(s1, "CurrencyID", attributes);
                }
                if ("ShippingPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.shippingCost = s1;
                    return new CurrencyElement(s1, "CurrencyID", attributes);
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

            
            {
                this$0 = EbayDealsApi.DealsResponse.ItemElement.this;
                super();
                titleElement = new _cls1();
                imageUrlElement = new _cls2();
            }
        };
        metadataElement = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

            com.ebay.nautilus.kernel.util.SaxHandler.TextElement endDateElement;
            com.ebay.nautilus.kernel.util.SaxHandler.TextElement energyRatingElement;
            com.ebay.nautilus.kernel.util.SaxHandler.TextElement savingsRateElement;
            final EbayDealsApi.DealsResponse.ItemElement this$0;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("SavingsRate".equals(s1))
                {
                    return savingsRateElement;
                }
                if ("EndTime".equals(s1))
                {
                    return endDateElement;
                }
                if ("MetaAttribute".equals(s1))
                {
                    int j = attributes.getLength();
                    for (int i = 0; i < j; i++)
                    {
                        if ("EEKRating".equals(attributes.getValue(i)))
                        {
                            return energyRatingElement;
                        }
                    }

                }
                return super.get(s, s1, s2, attributes);
            }

            
            {
                this$0 = EbayDealsApi.DealsResponse.ItemElement.this;
                super();
                savingsRateElement = new _cls1();
                endDateElement = new _cls2();
                energyRatingElement = new _cls3();
            }
        };
    }

    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$1$1

/* anonymous class */
    class _cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final _cls1 this$1;

        public void text(String s)
            throws SAXException
        {
            item.title = s;
        }

            
            {
                this$1 = _cls1.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$1$2

/* anonymous class */
    class _cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final _cls1 this$1;

        public void text(String s)
            throws SAXException
        {
            item.imageUrl = s;
        }

            
            {
                this$1 = _cls1.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$2$1

/* anonymous class */
    class _cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final _cls2 this$1;

        public void text(String s)
            throws SAXException
        {
            try
            {
                item.savingsRate = Integer.parseInt(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

            
            {
                this$1 = _cls2.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$2$2

/* anonymous class */
    class _cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final _cls2 this$1;

        public void text(String s)
            throws SAXException
        {
            try
            {
                item.endDate = EbayDateUtils.parseIso8601DateTime(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

            
            {
                this$1 = _cls2.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$2$3

/* anonymous class */
    class _cls3 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final _cls2 this$1;

        public void text(String s)
        {
            item.energyRating = s;
        }

            
            {
                this$1 = _cls2.this;
                super();
            }
    }

}

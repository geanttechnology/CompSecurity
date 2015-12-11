// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.deals;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.ParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.deals:
//            EbayDealsApi

class this._cls1 extends com.ebay.nautilus.kernel.util.._cls1
{

    final  this$1;

    public void text(String s)
    {
        .item = s;
    }

    <init>()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$2

/* anonymous class */
    class EbayDealsApi.DealsResponse.ItemElement._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

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
                savingsRateElement = new EbayDealsApi.DealsResponse.ItemElement._cls2._cls1();
                endDateElement = new EbayDealsApi.DealsResponse.ItemElement._cls2._cls2();
                energyRatingElement = new EbayDealsApi.DealsResponse.ItemElement._cls2._cls3();
            }

        // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$2$1

/* anonymous class */
        class EbayDealsApi.DealsResponse.ItemElement._cls2._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final EbayDealsApi.DealsResponse.ItemElement._cls2 this$1;

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
                        this$1 = EbayDealsApi.DealsResponse.ItemElement._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/ebay/common/net/deals/EbayDealsApi$DealsResponse$ItemElement$2$2

/* anonymous class */
        class EbayDealsApi.DealsResponse.ItemElement._cls2._cls2 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
        {

            final EbayDealsApi.DealsResponse.ItemElement._cls2 this$1;

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
                        this$1 = EbayDealsApi.DealsResponse.ItemElement._cls2.this;
                        super();
                    }
        }

    }

}

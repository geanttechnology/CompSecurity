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

class em extends com.ebay.nautilus.kernel.util.gyRatingElement
{

    com.ebay.nautilus.kernel.util.gyRatingElement endDateElement;
    com.ebay.nautilus.kernel.util.gyRatingElement energyRatingElement;
    com.ebay.nautilus.kernel.util.gyRatingElement savingsRateElement;
    final energyRatingElement this$0;

    public com.ebay.nautilus.kernel.util.gyRatingElement get(String s, String s1, String s2, Attributes attributes)
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
        return super.gyRatingElement(s, s1, s2, attributes);
    }

    _cls3.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
        savingsRateElement = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

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
        };
        endDateElement = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

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
        };
        energyRatingElement = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

            final EbayDealsApi.DealsResponse.ItemElement._cls2 this$1;

            public void text(String s)
            {
                item.energyRating = s;
            }

            
            {
                this$1 = EbayDealsApi.DealsResponse.ItemElement._cls2.this;
                super();
            }
        };
    }
}

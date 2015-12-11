// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ingDetails
{

    final _cls2 this$0;

    public com.ebay.nautilus.kernel.util.ingDetails get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ConvertedBuyItNowPrice".equals(s1))
        {
            s = this._cls0.this.<init>;
            s1 = new ItemCurrency();
            s.convertedBuyItNowPrice = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("StartTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.Item.ListingDetails this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.startDate = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.Item.ListingDetails.this;
                super();
            }
            };
        }
        if ("EndTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.Item.ListingDetails this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.endDate = EbayDateUtils.parseXml(s3);
                    item.endTimestamp = item.endDate.getTime();
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.Item.ListingDetails.this;
                super();
            }
            };
        } else
        {
            return super.ingDetails(s, s1, s2, attributes);
        }
    }

    private _cls2.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}

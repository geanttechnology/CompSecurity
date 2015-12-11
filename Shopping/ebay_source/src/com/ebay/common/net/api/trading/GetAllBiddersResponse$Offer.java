// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.AllBiddersData;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetAllBiddersResponse

private final class offer extends com.ebay.nautilus.kernel.util.r
{

    private final com.ebay.common.model.et offer = new com.ebay.common.model.et();
    final GetAllBiddersResponse this$0;

    public com.ebay.nautilus.kernel.util.r get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Action".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.Offer this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        offer.action = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.Offer.this;
                super();
            }
                };
            }
            if ("ConvertedPrice".equals(s1))
            {
                s = offer;
                s1 = new ItemCurrency();
                s.edPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("Currency".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.Offer this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        offer.currency = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.Offer.this;
                super();
            }
                };
            }
            if ("HighestBid".equals(s1))
            {
                s = offer;
                s1 = new ItemCurrency();
                s.Bid = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("MaxBid".equals(s1))
            {
                s = offer;
                s1 = new ItemCurrency();
                s.offer = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("MyMaxBid".equals(s1))
            {
                s = offer;
                s1 = new ItemCurrency();
                s.d = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("Quantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetAllBiddersResponse.Offer this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        offer.quantity = i;
                    }

            
            {
                this$1 = GetAllBiddersResponse.Offer.this;
                super();
            }
                };
            }
            if ("SecondChanceEnabled".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetAllBiddersResponse.Offer this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        offer.secondChanceEnabled = flag;
                    }

            
            {
                this$1 = GetAllBiddersResponse.Offer.this;
                super();
            }
                };
            }
            if ("SiteCurrency".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.Offer this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        offer.siteCurrency = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.Offer.this;
                super();
            }
                };
            }
            if ("TimeBid".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.Offer this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        offer.timeBid = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetAllBiddersResponse.Offer.this;
                super();
            }
                };
            }
            if ("User".equals(s1))
            {
                return new init>(GetAllBiddersResponse.this, offer.offer);
            }
        }
        return super.offer(s, s1, s2, attributes);
    }


    public _cls6.this._cls1(AllBiddersData allbiddersdata)
    {
        this$0 = GetAllBiddersResponse.this;
        super();
        allbiddersdata.offers.add(offer);
    }
}

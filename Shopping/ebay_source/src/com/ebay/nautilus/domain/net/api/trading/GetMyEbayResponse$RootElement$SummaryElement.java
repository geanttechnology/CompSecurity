// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.SellerTotals;
import com.ebay.nautilus.domain.net.CurrencyElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private static final class sellerTotals extends com.ebay.nautilus.kernel.util.aryElement
{

    protected final SellerTotals sellerTotals;

    public com.ebay.nautilus.kernel.util.aryElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ActiveAuctionCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.SummaryElement this$0;

                public void setValue(int i)
                    throws SAXException
                {
                    sellerTotals.activeAuctionCount = i;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.SummaryElement.this;
                super();
            }
            };
        }
        if ("AuctionSellingCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.SummaryElement this$0;

                public void setValue(int i)
                    throws SAXException
                {
                    sellerTotals.auctionSellingCount = i;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.SummaryElement.this;
                super();
            }
            };
        }
        if ("AuctionBidCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.SummaryElement this$0;

                public void setValue(int i)
                    throws SAXException
                {
                    sellerTotals.auctionBidCount = i;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.SummaryElement.this;
                super();
            }
            };
        }
        if ("TotalSoldCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.SummaryElement this$0;

                public void setValue(int i)
                    throws SAXException
                {
                    sellerTotals.totalSoldCount = i;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.SummaryElement.this;
                super();
            }
            };
        }
        if ("TotalSoldValue".equals(s1))
        {
            s = sellerTotals;
            s1 = new ItemCurrency();
            s.totalSoldValue = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("SoldDurationInDays".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.SummaryElement this$0;

                public void setValue(int i)
                    throws SAXException
                {
                    sellerTotals.soldDurationInDays = i;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.SummaryElement.this;
                super();
            }
            };
        }
        if ("QuantityLimitRemaining".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.SummaryElement this$0;

                public void setValue(int i)
                    throws SAXException
                {
                    sellerTotals.quantityLimitRemaining = i;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.SummaryElement.this;
                super();
            }
            };
        }
        if ("AmountLimitRemaining".equals(s1))
        {
            s = sellerTotals;
            s1 = new ItemCurrency();
            s.amountLimitRemaining = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("TotalAuctionSellingValue".equals(s1))
        {
            s = sellerTotals;
            s1 = new ItemCurrency();
            s.totalAuctionSellingValue = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        } else
        {
            return super.sellerTotals(s, s1, s2, attributes);
        }
    }

    public _cls6.this._cls0(SellerTotals sellertotals)
    {
        sellerTotals = sellertotals;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetAllBiddersResponse

private final class biddingSummary extends com.ebay.nautilus.kernel.util.y
{

    private final com.ebay.common.model.ngSummary biddingSummary;
    final GetAllBiddersResponse this$0;

    public com.ebay.nautilus.kernel.util.y get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("BidActivityWithSeller".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetAllBiddersResponse.BiddingSummary this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        biddingSummary.bidActivityWithSeller = i;
                    }

            
            {
                this$1 = GetAllBiddersResponse.BiddingSummary.this;
                super();
            }
                };
            }
            if ("BidRetractions".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetAllBiddersResponse.BiddingSummary this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        biddingSummary.bidRetractions = i;
                    }

            
            {
                this$1 = GetAllBiddersResponse.BiddingSummary.this;
                super();
            }
                };
            }
            if ("BidsToUniqueCategories".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetAllBiddersResponse.BiddingSummary this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        biddingSummary.bidsToUniqueCategories = i;
                    }

            
            {
                this$1 = GetAllBiddersResponse.BiddingSummary.this;
                super();
            }
                };
            }
            if ("BidsToUniqueSellers".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetAllBiddersResponse.BiddingSummary this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        biddingSummary.bidsToUniqueSellers = i;
                    }

            
            {
                this$1 = GetAllBiddersResponse.BiddingSummary.this;
                super();
            }
                };
            }
            if ("ItemBidDetails".equals(s1))
            {
                return new <init>(GetAllBiddersResponse.this, biddingSummary);
            }
            if ("SummaryDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.BiddingSummary this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        biddingSummary.summaryDays = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.BiddingSummary.this;
                super();
            }
                };
            }
            if ("TotalBids".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetAllBiddersResponse.BiddingSummary this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        biddingSummary.totalBids = i;
                    }

            
            {
                this$1 = GetAllBiddersResponse.BiddingSummary.this;
                super();
            }
                };
            }
        }
        return super.y(s, s1, s2, attributes);
    }


    public _cls6.this._cls1(com.ebay.common.model.ngSummary ngsummary)
    {
        this$0 = GetAllBiddersResponse.this;
        super();
        biddingSummary = ngsummary;
    }
}

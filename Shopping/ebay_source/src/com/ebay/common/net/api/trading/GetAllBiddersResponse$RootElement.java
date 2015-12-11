// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.AllBiddersData;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetAllBiddersResponse

private final class this._cls0 extends com.ebay.nautilus.kernel.util.t
{

    final GetAllBiddersResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(GetAllBiddersResponse.this);
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(GetAllBiddersResponse.this);
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(GetAllBiddersResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("Version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.RootElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        allBidders.setVersion(s3);
                    }

            
            {
                this$1 = GetAllBiddersResponse.RootElement.this;
                super();
            }
                };
            }
            if ("Build".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.RootElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        allBidders.setBuild(s3);
                    }

            
            {
                this$1 = GetAllBiddersResponse.RootElement.this;
                super();
            }
                };
            }
            if ("BidArray".equals(s1))
            {
                return new it>(GetAllBiddersResponse.this, allBidders);
            }
            if ("HighBidder".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.RootElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        allBidders.highBidder = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.RootElement.this;
                super();
            }
                };
            }
            if ("HighestBid ".equals(s1))
            {
                s = allBidders;
                s1 = new ItemCurrency();
                s.highestBid = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ListingStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.RootElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        allBidders.listingStatus = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.RootElement.this;
                super();
            }
                };
            }
        }
        return super.t(s, s1, s2, attributes);
    }

    public _cls4.this._cls1()
    {
        this$0 = GetAllBiddersResponse.this;
        super();
        allBidders = new AllBiddersData();
    }
}

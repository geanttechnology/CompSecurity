// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayDetail;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetEbayDetailsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.s
{
    private final class ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final GetEbayDetailsResponse.RootElement.ListingStartPriceDetails this$2;

        public void text(String s)
            throws SAXException
        {
            if (s.equals("Chinese"))
            {
                detail.auctionDetails = priceDetail;
            } else
            if (s.equals("FixedPriceItem"))
            {
                detail.fixedPriceDetails = priceDetail;
                return;
            }
        }

        private ListingType()
        {
            this$2 = GetEbayDetailsResponse.RootElement.ListingStartPriceDetails.this;
            super();
        }

        ListingType(GetEbayDetailsResponse._cls1 _pcls1)
        {
            this();
        }
    }


    private final com.ebay.common.model.ceDetails priceDetail;
    final _cls1.val.currencyCode this$1;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("ListingType".equals(s1))
            {
                return new ListingType(null);
            }
            if ("StartPrice".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetEbayDetailsResponse.RootElement.ListingStartPriceDetails this$2;
                    final String val$currencyCode;

                    public void text(String s3)
                        throws SAXException
                    {
                        priceDetail.startPrice = new CurrencyAmount(s3, currencyCode);
                    }

            
            {
                this$2 = GetEbayDetailsResponse.RootElement.ListingStartPriceDetails.this;
                currencyCode = s;
                super();
            }
                };
            }
        }
        return super.s(s, s1, s2, attributes);
    }


    private _cls1.val.currencyCode()
    {
        this$1 = this._cls1.this;
        super();
        priceDetail = new com.ebay.common.model.ceDetails.priceDetail();
    }

    priceDetail(priceDetail pricedetail1)
    {
        this();
    }
}

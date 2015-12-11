// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetAllBiddersResponse

private final class itemBidDetail extends com.ebay.nautilus.kernel.util.s
{

    private final com.ebay.common.model.idDetails itemBidDetail = new com.ebay.common.model.nit>();
    final GetAllBiddersResponse this$0;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("BidCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetAllBiddersResponse.ItemBidDetails this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        itemBidDetail.bidCount = i;
                    }

            
            {
                this$1 = GetAllBiddersResponse.ItemBidDetails.this;
                super();
            }
                };
            }
            if ("CategoryID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.ItemBidDetails this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemBidDetail.categoryId = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.ItemBidDetails.this;
                super();
            }
                };
            }
            if ("ItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.ItemBidDetails this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemBidDetail.itemId = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.ItemBidDetails.this;
                super();
            }
                };
            }
            if ("LastBidTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.ItemBidDetails this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemBidDetail.lastBidTime = EbayDateUtils.parseXml(s3);
                    }

            
            {
                this$1 = GetAllBiddersResponse.ItemBidDetails.this;
                super();
            }
                };
            }
            if ("SellerID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetAllBiddersResponse.ItemBidDetails this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        itemBidDetail.sellerId = s3;
                    }

            
            {
                this$1 = GetAllBiddersResponse.ItemBidDetails.this;
                super();
            }
                };
            }
        }
        return super.s(s, s1, s2, attributes);
    }


    public _cls5.this._cls1(com.ebay.common.model.idDetails iddetails)
    {
        this$0 = GetAllBiddersResponse.this;
        super();
        iddetails.temBidDetails.add(itemBidDetail);
    }
}

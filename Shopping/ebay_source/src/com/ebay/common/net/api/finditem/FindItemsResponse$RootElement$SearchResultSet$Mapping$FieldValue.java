// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finditem;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.finditem:
//            FindItemsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ue
{

    final this._cls3 this$3;

    public com.ebay.nautilus.kernel.util.ue get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final FindItemsResponse.RootElement.SearchResultSet.Mapping.FieldValue this$4;

                public void text(String s3)
                    throws SAXException
                {
                    if ("ITEM_ID".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                    {
                        result.id = Long.parseLong(s3);
                    } else
                    {
                        if ("TITLE".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.title = s3;
                            return;
                        }
                        if ("LEAF_CATS".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.leafCategory = s3;
                            return;
                        }
                        if ("SITE".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.site = s3;
                            return;
                        }
                        if ("PRODUCT_REFID".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.productReferenceId = s3;
                            return;
                        }
                        if ("ITEM_CONDITION_NEW".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.conditionNew = s3;
                            return;
                        }
                        if ("BIN_PRICE".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.binPrice = s3;
                            return;
                        }
                        if ("CURRENT_PRICE".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.currentPrice = s3;
                            return;
                        }
                        if ("CURRENCY".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.currency = s3;
                            return;
                        }
                        if ("BID_COUNT".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.bidCount = Integer.valueOf(s3).intValue();
                            return;
                        }
                        if ("SALE_TYPE".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.saleType = s3;
                            return;
                        }
                        if ("SAFE_START_TIME".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.safeStartTime = EbayDateUtils.parseXml(s3);
                            return;
                        }
                        if ("END_TIME".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.endTime = EbayDateUtils.parseXml(s3);
                            return;
                        }
                        if ("BUYER_FIXED_SHIPPING_COST".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.buyerFixedShippingCost = s3;
                            return;
                        }
                        if ("FLAT_SHIP_COST".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.flatShippingCost = s3;
                            return;
                        }
                        if ("FULL_CALCULATED_SHIPPING".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.fullCalculatedShipping = s3;
                            return;
                        }
                        if ("MD5_IMAGE".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.md5Image = s3;
                            return;
                        }
                        if ("IS_FREE_SHIPPING".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.isFreeShipping = Boolean.valueOf(s3).booleanValue();
                            return;
                        }
                        if ("SHIPPING_FLAG".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.shippingFlag = s3;
                            return;
                        }
                        if ("IS_INSURANCE_REQUIRED".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.isInsuranceRequired = Boolean.valueOf(s3).booleanValue();
                            return;
                        }
                        if ("SOLD_AS_BIN".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.soldAsBin = Boolean.valueOf(s3).booleanValue();
                            return;
                        }
                        if ("START_PRICE".equals(FindItemsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.startPrice = s3;
                            return;
                        }
                    }
                }

            
            {
                this$4 = FindItemsResponse.RootElement.SearchResultSet.Mapping.FieldValue.this;
                super();
            }
            };
        } else
        {
            return super.ue(s, s1, s2, attributes);
        }
    }

    private _cls1.this._cls4()
    {
        this$3 = this._cls3.this;
        super();
    }

    this._cls3(this._cls3 _pcls3_1)
    {
        this();
    }
}

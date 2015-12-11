// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.data.ShippingPackageInfo;
import com.ebay.nautilus.domain.data.ShippingTrackingEvent;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class this._cls0 extends com.ebay.nautilus.kernel.util.t
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("StoreID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShippingPackageInfoElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).selectedShippingOption.shippingPackageInfo.storeId = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingPackageInfoElement.this;
                super();
            }
                };
            }
            if ("ShippingTrackingEvent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShippingPackageInfoElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).selectedShippingOption.shippingPackageInfo.shippingTrackingEvent = ShippingTrackingEvent.valueOf(s3);
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingPackageInfoElement.this;
                super();
            }
                };
            }
            if ("ScheduledDeliveryTimeMin".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShippingPackageInfoElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        try
                        {
                            GetItemTransactionsResponse.access$600(this$0).selectedShippingOption.shippingPackageInfo.scheduledDeliveryTimeMin = EbayDateUtils.parseIso8601DateTime(s3);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s3)
                        {
                            throw new SAXException(s3);
                        }
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingPackageInfoElement.this;
                super();
            }
                };
            }
            if ("ScheduledDeliveryTimeMax".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.ShippingPackageInfoElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        try
                        {
                            GetItemTransactionsResponse.access$600(this$0).selectedShippingOption.shippingPackageInfo.scheduledDeliveryTimeMax = EbayDateUtils.parseIso8601DateTime(s3);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s3)
                        {
                            throw new SAXException(s3);
                        }
                    }

            
            {
                this$1 = GetItemTransactionsResponse.ShippingPackageInfoElement.this;
                super();
            }
                };
            }
        }
        return super.t(s, s1, s2, attributes);
    }

    public _cls4.this._cls1()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
        GetItemTransactionsResponse.access$600(GetItemTransactionsResponse.this).selectedShippingOption.shippingPackageInfo = new ShippingPackageInfo();
    }
}

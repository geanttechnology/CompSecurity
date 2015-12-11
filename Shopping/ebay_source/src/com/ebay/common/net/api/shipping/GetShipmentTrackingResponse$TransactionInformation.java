// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetShipmentTrackingResponse

private final class <init> extends com.ebay.nautilus.kernel.util.on
{

    final GetShipmentTrackingResponse this$0;

    public com.ebay.nautilus.kernel.util.on get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("shippedDate".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.TransactionInformation this$1;

                public void text(String s3)
                    throws SAXException
                {
                    tracking.shippedDate = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$1 = GetShipmentTrackingResponse.TransactionInformation.this;
                super();
            }
            };
        }
        if ("transitDate".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.TransactionInformation this$1;

                public void text(String s3)
                    throws SAXException
                {
                    tracking.transitDate = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$1 = GetShipmentTrackingResponse.TransactionInformation.this;
                super();
            }
            };
        }
        if ("handlingTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.TransactionInformation this$1;

                public void text(String s3)
                    throws SAXException
                {
                    tracking.handlingTime = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$1 = GetShipmentTrackingResponse.TransactionInformation.this;
                super();
            }
            };
        }
        if ("estimatedDeliveryDate".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.TransactionInformation this$1;

                public void text(String s3)
                    throws SAXException
                {
                    tracking.estimatedDeliveryDate = EbayDateUtils.parseXml(s3);
                }

            
            {
                this$1 = GetShipmentTrackingResponse.TransactionInformation.this;
                super();
            }
            };
        } else
        {
            return super.on(s, s1, s2, attributes);
        }
    }

    private _cls4.this._cls1()
    {
        this$0 = GetShipmentTrackingResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

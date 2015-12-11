// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import android.util.Log;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import com.ebay.nautilus.domain.data.ShipmentTrackingScanDetail;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shipping:
//            GetShipmentTrackingResponse

private final class detail extends com.ebay.nautilus.kernel.util.il
{

    final ShipmentTrackingDetail detail;
    final GetShipmentTrackingResponse this$0;

    public com.ebay.nautilus.kernel.util.il get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        final ShipmentTrackingScanDetail scanDetail = (ShipmentTrackingScanDetail)detail.scanDetails.get(detail.scanDetails.size() - 1);
        if ("eventStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.ScanDetail this$1;
                final ShipmentTrackingScanDetail val$scanDetail;

                public void text(String s3)
                    throws SAXException
                {
                    scanDetail.eventStatus = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.ScanDetail.this;
                scanDetail = shipmenttrackingscandetail;
                super();
            }
            };
        }
        if ("eventDesc".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.ScanDetail this$1;
                final ShipmentTrackingScanDetail val$scanDetail;

                public void text(String s3)
                    throws SAXException
                {
                    scanDetail.eventDesc = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.ScanDetail.this;
                scanDetail = shipmenttrackingscandetail;
                super();
            }
            };
        }
        if ("eventTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.ScanDetail this$1;
                final ShipmentTrackingScanDetail val$scanDetail;

                public void text(String s3)
                    throws SAXException
                {
                    Object obj;
                    obj = s3;
                    if (!useEventTimeHack)
                    {
                        break MISSING_BLOCK_LABEL_100;
                    }
                    String s4;
                    obj = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.getDefault());
                    obj = (new SimpleDateFormat("Z", Locale.getDefault())).format(((Calendar) (obj)).getTime());
                    s4 = (new StringBuilder()).append(((String) (obj)).substring(0, 3)).append(":").append(((String) (obj)).substring(3, 5)).toString();
                    obj = s3;
                    try
                    {
                        if (!"-7:00".equals(s4))
                        {
                            obj = s3.replace("-07:00", s4);
                        }
                    }
                    catch (Exception exception)
                    {
                        Log.w("ShipmentTrackingResp", "failed to change eventTime, using API supplied value", exception);
                        exception = s3;
                    }
                    scanDetail.eventTime = EbayDateUtils.parseXml(((String) (obj)));
                    return;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.ScanDetail.this;
                scanDetail = shipmenttrackingscandetail;
                super();
            }
            };
        }
        if ("eventCity".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.ScanDetail this$1;
                final ShipmentTrackingScanDetail val$scanDetail;

                public void text(String s3)
                    throws SAXException
                {
                    scanDetail.eventCity = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.ScanDetail.this;
                scanDetail = shipmenttrackingscandetail;
                super();
            }
            };
        }
        if ("eventStateOrProvince".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.ScanDetail this$1;
                final ShipmentTrackingScanDetail val$scanDetail;

                public void text(String s3)
                    throws SAXException
                {
                    scanDetail.eventStateOrProvince = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.ScanDetail.this;
                scanDetail = shipmenttrackingscandetail;
                super();
            }
            };
        }
        if ("eventPostalCode".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.ScanDetail this$1;
                final ShipmentTrackingScanDetail val$scanDetail;

                public void text(String s3)
                    throws SAXException
                {
                    scanDetail.eventPostalCode = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.ScanDetail.this;
                scanDetail = shipmenttrackingscandetail;
                super();
            }
            };
        }
        if ("eventCode".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetShipmentTrackingResponse.ScanDetail this$1;
                final ShipmentTrackingScanDetail val$scanDetail;

                public void text(String s3)
                    throws SAXException
                {
                    scanDetail.eventCode = s3;
                }

            
            {
                this$1 = GetShipmentTrackingResponse.ScanDetail.this;
                scanDetail = shipmenttrackingscandetail;
                super();
            }
            };
        } else
        {
            return super.il(s, s1, s2, attributes);
        }
    }

    public _cls7.val.scanDetail(ShipmentTrackingDetail shipmenttrackingdetail)
    {
        this$0 = GetShipmentTrackingResponse.this;
        super();
        detail = shipmenttrackingdetail;
        shipmenttrackingdetail.addScanDetail();
    }
}

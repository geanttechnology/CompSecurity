// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shipping;

import android.util.Log;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import com.ebay.nautilus.domain.data.ShipmentTrackingScanDetail;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetShipmentTrackingResponse extends EbayResponse
{
    private final class Body extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shipmentTrackingResponse".equals(s1))
            {
                return new ShipmentTrackingResponse();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Body()
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
        }

    }

    private final class History extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ShipmentTrackingDetail shipmenttrackingdetail = (ShipmentTrackingDetail)tracking.details.get(tracking.details.size() - 1);
            if ("scanDetail".equals(s1))
            {
                return new ScanDetail(shipmenttrackingdetail);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private History()
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
        }

    }

    private final class Hop extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final ShipmentTrackingDetail detail;
        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop hop = (com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop)detail.hops.get(detail.hops.size() - 1);
            if ("From".equals(s1))
            {
                return hop. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Hop this$1;
                    final com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop val$hop;

                    public void text(String s)
                        throws SAXException
                    {
                        hop.from = s;
                    }

            
            {
                this$1 = final_hop1;
                hop = com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop.this;
                super();
            }
                };
            }
            if ("To".equals(s1))
            {
                return hop. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Hop this$1;
                    final com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop val$hop;

                    public void text(String s)
                        throws SAXException
                    {
                        hop.to = s;
                    }

            
            {
                this$1 = final_hop1;
                hop = com.ebay.nautilus.domain.data.ShipmentTrackingDetail.Hop.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public Hop(ShipmentTrackingDetail shipmenttrackingdetail)
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
            detail = shipmenttrackingdetail;
            detail.addHop();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Body".equals(s1))
            {
                return new Body();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
        }

    }

    private final class ScanDetail extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ShipmentTrackingDetail detail;
        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ShipmentTrackingScanDetail shipmenttrackingscandetail = (ShipmentTrackingScanDetail)detail.scanDetails.get(detail.scanDetails.size() - 1);
            if ("eventStatus".equals(s1))
            {
                return shipmenttrackingscandetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ScanDetail this$1;
                    final ShipmentTrackingScanDetail val$scanDetail;

                    public void text(String s)
                        throws SAXException
                    {
                        scanDetail.eventStatus = s;
                    }

            
            {
                this$1 = final_scandetail;
                scanDetail = ShipmentTrackingScanDetail.this;
                super();
            }
                };
            }
            if ("eventDesc".equals(s1))
            {
                return shipmenttrackingscandetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ScanDetail this$1;
                    final ShipmentTrackingScanDetail val$scanDetail;

                    public void text(String s)
                        throws SAXException
                    {
                        scanDetail.eventDesc = s;
                    }

            
            {
                this$1 = final_scandetail;
                scanDetail = ShipmentTrackingScanDetail.this;
                super();
            }
                };
            }
            if ("eventTime".equals(s1))
            {
                return shipmenttrackingscandetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ScanDetail this$1;
                    final ShipmentTrackingScanDetail val$scanDetail;

                    public void text(String s)
                        throws SAXException
                    {
                        Object obj;
                        obj = s;
                        if (!useEventTimeHack)
                        {
                            break MISSING_BLOCK_LABEL_100;
                        }
                        String s1;
                        obj = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.getDefault());
                        obj = (new SimpleDateFormat("Z", Locale.getDefault())).format(((Calendar) (obj)).getTime());
                        s1 = (new StringBuilder()).append(((String) (obj)).substring(0, 3)).append(":").append(((String) (obj)).substring(3, 5)).toString();
                        obj = s;
                        try
                        {
                            if (!"-7:00".equals(s1))
                            {
                                obj = s.replace("-07:00", s1);
                            }
                        }
                        catch (Exception exception)
                        {
                            Log.w("ShipmentTrackingResp", "failed to change eventTime, using API supplied value", exception);
                            exception = s;
                        }
                        scanDetail.eventTime = EbayDateUtils.parseXml(((String) (obj)));
                        return;
                    }

            
            {
                this$1 = final_scandetail;
                scanDetail = ShipmentTrackingScanDetail.this;
                super();
            }
                };
            }
            if ("eventCity".equals(s1))
            {
                return shipmenttrackingscandetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ScanDetail this$1;
                    final ShipmentTrackingScanDetail val$scanDetail;

                    public void text(String s)
                        throws SAXException
                    {
                        scanDetail.eventCity = s;
                    }

            
            {
                this$1 = final_scandetail;
                scanDetail = ShipmentTrackingScanDetail.this;
                super();
            }
                };
            }
            if ("eventStateOrProvince".equals(s1))
            {
                return shipmenttrackingscandetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ScanDetail this$1;
                    final ShipmentTrackingScanDetail val$scanDetail;

                    public void text(String s)
                        throws SAXException
                    {
                        scanDetail.eventStateOrProvince = s;
                    }

            
            {
                this$1 = final_scandetail;
                scanDetail = ShipmentTrackingScanDetail.this;
                super();
            }
                };
            }
            if ("eventPostalCode".equals(s1))
            {
                return shipmenttrackingscandetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ScanDetail this$1;
                    final ShipmentTrackingScanDetail val$scanDetail;

                    public void text(String s)
                        throws SAXException
                    {
                        scanDetail.eventPostalCode = s;
                    }

            
            {
                this$1 = final_scandetail;
                scanDetail = ShipmentTrackingScanDetail.this;
                super();
            }
                };
            }
            if ("eventCode".equals(s1))
            {
                return shipmenttrackingscandetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ScanDetail this$1;
                    final ShipmentTrackingScanDetail val$scanDetail;

                    public void text(String s)
                        throws SAXException
                    {
                        scanDetail.eventCode = s;
                    }

            
            {
                this$1 = final_scandetail;
                scanDetail = ShipmentTrackingScanDetail.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ScanDetail(ShipmentTrackingDetail shipmenttrackingdetail)
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
            detail = shipmenttrackingdetail;
            shipmenttrackingdetail.addScanDetail();
        }
    }

    private final class ShipmentTrackingDetailXML extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            ShipmentTrackingDetail shipmenttrackingdetail = (ShipmentTrackingDetail)tracking.details.get(tracking.details.size() - 1);
            if ("tracking".equals(s1))
            {
                return new Tracking(shipmenttrackingdetail);
            }
            if ("trackingStatus".equals(s1))
            {
                return shipmenttrackingdetail. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShipmentTrackingDetailXML this$1;
                    final ShipmentTrackingDetail val$detail;

                    public void text(String s)
                        throws SAXException
                    {
                        detail.trackingStatus = s;
                    }

            
            {
                this$1 = final_shipmenttrackingdetailxml;
                detail = ShipmentTrackingDetail.this;
                super();
            }
                };
            }
            if ("history".equals(s1))
            {
                return new History();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public ShipmentTrackingDetailXML()
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
            tracking.addDetail();
        }
    }

    private final class ShipmentTrackingResponse extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(GetShipmentTrackingResponse.this);
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(GetShipmentTrackingResponse.this);
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(GetShipmentTrackingResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("shipmentTrackingResponseInfo".equals(s1))
            {
                return new ShipmentTrackingResponseInfo();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShipmentTrackingResponse()
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
        }

    }

    private final class ShipmentTrackingResponseInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shipmentTrackingDetail".equals(s1))
            {
                return new ShipmentTrackingDetailXML();
            }
            if ("shipmentTrackingTransactionalInfo".equals(s1))
            {
                return new ShipmentTrackingTransactionalInfo();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShipmentTrackingResponseInfo()
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
        }

    }

    private final class ShipmentTrackingTransactionalInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("transactionInformation".equals(s1))
            {
                return new TransactionInformation();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShipmentTrackingTransactionalInfo()
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
        }

    }

    private final class Tracking extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final ShipmentTrackingDetail detail;
        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippingCarrier".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Tracking this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        detail.carrier = s;
                    }

            
            {
                this$1 = Tracking.this;
                super();
            }
                };
            }
            if ("trackingNumber".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Tracking this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        detail.trackingNumber = s;
                    }

            
            {
                this$1 = Tracking.this;
                super();
            }
                };
            }
            if ("Hop".equals(s1))
            {
                return new Hop(detail);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public Tracking(ShipmentTrackingDetail shipmenttrackingdetail)
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
            detail = shipmenttrackingdetail;
        }
    }

    private final class TransactionInformation extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetShipmentTrackingResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("shippedDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final TransactionInformation this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        tracking.shippedDate = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = TransactionInformation.this;
                super();
            }
                };
            }
            if ("transitDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final TransactionInformation this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        tracking.transitDate = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = TransactionInformation.this;
                super();
            }
                };
            }
            if ("handlingTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final TransactionInformation this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        tracking.handlingTime = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = TransactionInformation.this;
                super();
            }
                };
            }
            if ("estimatedDeliveryDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final TransactionInformation this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        tracking.estimatedDeliveryDate = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = TransactionInformation.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private TransactionInformation()
        {
            this$0 = GetShipmentTrackingResponse.this;
            super();
        }

    }


    public ShipmentTracking tracking;
    public boolean useEventTimeHack;

    public GetShipmentTrackingResponse(boolean flag)
    {
        tracking = new ShipmentTracking();
        useEventTimeHack = flag;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
        if (tracking != null && tracking.details != null)
        {
            inputstream = tracking.details.iterator();
            do
            {
                if (!inputstream.hasNext())
                {
                    break;
                }
                ShipmentTrackingDetail shipmenttrackingdetail = (ShipmentTrackingDetail)inputstream.next();
                if (shipmenttrackingdetail == null)
                {
                    continue;
                }
                boolean flag1 = true;
                Iterator iterator = shipmenttrackingdetail.scanDetails.iterator();
                boolean flag;
                do
                {
                    flag = flag1;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    if (((ShipmentTrackingScanDetail)iterator.next()).eventTime != null)
                    {
                        continue;
                    }
                    flag = false;
                    break;
                } while (true);
                if (flag)
                {
                    Collections.sort(shipmenttrackingdetail.scanDetails);
                    Collections.reverse(shipmenttrackingdetail.scanDetails);
                }
            } while (true);
        }
    }
}

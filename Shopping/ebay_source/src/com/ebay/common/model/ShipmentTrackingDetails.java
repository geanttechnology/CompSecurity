// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ShipmentTrackingDetails
{
    public static final class ScanDetail
    {

        public String eventCity;
        public String eventDesc;
        public String eventPostalCode;
        public String eventStateOrProvince;
        public String eventStatus;
        public Date eventTime;

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("eventStatus: ").append(eventStatus).append('\n');
            stringbuilder.append("eventDesc: ").append(eventDesc).append('\n');
            stringbuilder.append("eventTime: ").append(eventTime).append('\n');
            stringbuilder.append("eventCity: ").append(eventCity).append('\n');
            stringbuilder.append("eventStateOrProvince: ").append(eventStateOrProvince).append('\n');
            stringbuilder.append("eventPostalCode: ").append(eventPostalCode).append('\n');
            return stringbuilder.toString();
        }

        public ScanDetail()
        {
        }
    }


    public Date estimatedDeliveryDate;
    public Date handlingTime;
    public String itemId;
    public ArrayList scanDetails;
    public Date shippedDate;
    public String shippingCarrier;
    public String trackingNumber;
    public String trackingStatus;
    public String transactionId;
    public Date transitDate;

    public ShipmentTrackingDetails()
    {
        scanDetails = new ArrayList();
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("transactionId: ").append(transactionId).append('\n');
        stringbuilder.append("itemId: ").append(itemId).append('\n');
        stringbuilder.append("shippingCarrier: ").append(shippingCarrier).append('\n');
        stringbuilder.append("trackingNumber: ").append(trackingNumber).append('\n');
        stringbuilder.append("trackingStatus: ").append(trackingStatus).append('\n');
        stringbuilder.append("shippedDate: ").append(shippedDate).append('\n');
        stringbuilder.append("transitDate: ").append(transitDate).append('\n');
        stringbuilder.append("handlingTime: ").append(handlingTime).append('\n');
        stringbuilder.append("estimatedDeliveryDate: ").append(estimatedDeliveryDate).append('\n');
        stringbuilder.append("details={\n");
        for (Iterator iterator = scanDetails.iterator(); iterator.hasNext(); stringbuilder.append(((ScanDetail)iterator.next()).toString())) { }
        stringbuilder.append("}\n");
        return stringbuilder.toString();
    }
}

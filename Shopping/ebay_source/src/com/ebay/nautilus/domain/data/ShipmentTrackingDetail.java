// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShipmentTrackingScanDetail

public class ShipmentTrackingDetail
    implements Parcelable
{
    public class Hop
    {

        public String from;
        final ShipmentTrackingDetail this$0;
        public String to;

        public Hop()
        {
            this$0 = ShipmentTrackingDetail.this;
            super();
        }

        public Hop(String s, String s1)
        {
            this$0 = ShipmentTrackingDetail.this;
            super();
            from = s;
            to = s1;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShipmentTrackingDetail createFromParcel(Parcel parcel)
        {
            return new ShipmentTrackingDetail(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShipmentTrackingDetail[] newArray(int i)
        {
            return new ShipmentTrackingDetail[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String carrier;
    public ArrayList hops;
    public ArrayList scanDetails;
    public String trackingNumber;
    public String trackingStatus;

    public ShipmentTrackingDetail()
    {
        hops = new ArrayList();
        scanDetails = new ArrayList();
    }

    private ShipmentTrackingDetail(Parcel parcel)
    {
        hops = new ArrayList();
        scanDetails = new ArrayList();
        carrier = parcel.readString();
        trackingNumber = parcel.readString();
        trackingStatus = parcel.readString();
        int j = parcel.readInt();
        for (int i = 0; i < j; i++)
        {
            hops.add(new Hop(parcel.readString(), parcel.readString()));
        }

        parcel.readTypedList(scanDetails, ShipmentTrackingScanDetail.CREATOR);
    }


    public ShipmentTrackingDetail(String s, String s1)
    {
        hops = new ArrayList();
        scanDetails = new ArrayList();
        trackingNumber = s;
        carrier = s1;
    }

    public void addHop()
    {
        hops.add(new Hop());
    }

    public void addScanDetail()
    {
        scanDetails.add(new ShipmentTrackingScanDetail());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(carrier);
        parcel.writeString(trackingNumber);
        parcel.writeString(trackingStatus);
        parcel.writeInt(hops.size());
        Hop hop;
        for (Iterator iterator = hops.iterator(); iterator.hasNext(); parcel.writeString(hop.to))
        {
            hop = (Hop)iterator.next();
            parcel.writeString(hop.from);
        }

        parcel.writeTypedList(scanDetails);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShipmentTrackingDetail

public class ShipmentTracking
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShipmentTracking createFromParcel(Parcel parcel)
        {
            return new ShipmentTracking(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShipmentTracking[] newArray(int i)
        {
            return new ShipmentTracking[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public ArrayList details;
    public Date estimatedDeliveryDate;
    public Date handlingTime;
    public Date shippedDate;
    public Date transitDate;

    public ShipmentTracking()
    {
        details = new ArrayList();
    }

    private ShipmentTracking(Parcel parcel)
    {
        Object obj = null;
        super();
        details = new ArrayList();
        parcel.readTypedList(details, ShipmentTrackingDetail.CREATOR);
        Date date;
        if (1 == parcel.readInt())
        {
            date = new Date(parcel.readLong());
        } else
        {
            date = null;
        }
        shippedDate = date;
        if (1 == parcel.readInt())
        {
            date = new Date(parcel.readLong());
        } else
        {
            date = null;
        }
        transitDate = date;
        if (1 == parcel.readInt())
        {
            date = new Date(parcel.readLong());
        } else
        {
            date = null;
        }
        handlingTime = date;
        date = obj;
        if (1 == parcel.readInt())
        {
            date = new Date(parcel.readLong());
        }
        estimatedDeliveryDate = date;
    }


    public void addDetail()
    {
        details.add(new ShipmentTrackingDetail());
    }

    public void addDetail(String s, String s1)
    {
        details.add(new ShipmentTrackingDetail(s, s1));
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeTypedList(details);
        if (shippedDate != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (shippedDate != null)
        {
            parcel.writeLong(shippedDate.getTime());
        }
        if (transitDate != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (transitDate != null)
        {
            parcel.writeLong(transitDate.getTime());
        }
        if (handlingTime != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (handlingTime != null)
        {
            parcel.writeLong(handlingTime.getTime());
        }
        if (estimatedDeliveryDate != null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (estimatedDeliveryDate != null)
        {
            parcel.writeLong(estimatedDeliveryDate.getTime());
        }
    }

}

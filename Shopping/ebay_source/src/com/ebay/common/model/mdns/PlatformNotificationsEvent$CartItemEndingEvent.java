// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.Date;

// Referenced classes of package com.ebay.common.model.mdns:
//            PlatformNotificationsEvent

public static class galleryUrl extends PlatformNotificationsEvent
    implements Parcelable
{

    public static final android.os.ItemEndingEvent CREATOR = new android.os.Parcelable.Creator() {

        public PlatformNotificationsEvent.CartItemEndingEvent createFromParcel(Parcel parcel)
        {
            return (PlatformNotificationsEvent.CartItemEndingEvent)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/mdns/PlatformNotificationsEvent$CartItemEndingEvent);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public PlatformNotificationsEvent.CartItemEndingEvent[] newArray(int i)
        {
            return new PlatformNotificationsEvent.CartItemEndingEvent[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };


    public _cls1()
    {
        super.eventType = _fld1._mth1();
    }

    public _cls1(com.ebay.nautilus.domain.data. )
    {
        this(.it>, .it>, .it>, .it>);
    }

    public <init>(Long long1, Date date, String s, String s1)
    {
        this();
        long l;
        if (long1 != null)
        {
            long1 = long1.toString();
        } else
        {
            long1 = "";
        }
        itemId = long1;
        if (date != null)
        {
            l = date.getTime();
        } else
        {
            l = 0L;
        }
        endTimestamp = l;
        if (date != null)
        {
            long1 = date.toString();
        } else
        {
            long1 = "";
        }
        endTime = long1;
        if (s == null)
        {
            s = "";
        }
        title = s;
        if (s1 == null)
        {
            s1 = "";
        }
        galleryUrl = s1;
    }
}

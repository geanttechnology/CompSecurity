// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.inventory;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.ebay.common.model.inventory:
//            StoreAvailability

public static final class _cls1 extends Enum
    implements Parcelable
{

    private static final SHIP_TO_STORE $VALUES[];
    public static final android.os.ity.AvailabilityType CREATOR = new android.os.Parcelable.Creator() {

        public StoreAvailability.AvailabilityType createFromParcel(Parcel parcel)
        {
            return StoreAvailability.AvailabilityType.valueOf(parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public StoreAvailability.AvailabilityType[] newArray(int i)
        {
            return new StoreAvailability.AvailabilityType[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final _cls1.newArray IN_STOCK;
    public static final _cls1.newArray OUT_OF_STOCK;
    public static final _cls1.newArray SHIP_TO_STORE;

    public static _cls1 valueOf(String s)
    {
        return (_cls1)Enum.valueOf(com/ebay/common/model/inventory/StoreAvailability$AvailabilityType, s);
    }

    public static _cls1[] values()
    {
        return (_cls1[])$VALUES.clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(toString());
    }

    static 
    {
        IN_STOCK = new <init>("IN_STOCK", 0);
        OUT_OF_STOCK = new <init>("OUT_OF_STOCK", 1);
        SHIP_TO_STORE = new <init>("SHIP_TO_STORE", 2);
        $VALUES = (new .VALUES[] {
            IN_STOCK, OUT_OF_STOCK, SHIP_TO_STORE
        });
    }

    private _cls1(String s, int i)
    {
        super(s, i);
    }
}

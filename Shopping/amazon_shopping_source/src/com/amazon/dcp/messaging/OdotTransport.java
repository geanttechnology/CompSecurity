// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.messaging;

import android.os.Parcel;
import android.os.Parcelable;

public final class OdotTransport extends Enum
    implements Parcelable
{

    private static final OdotTransport $VALUES[];
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OdotTransport createFromParcel(Parcel parcel)
        {
            return OdotTransport.fromValue(parcel.readInt());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OdotTransport[] newArray(int i)
        {
            return new OdotTransport[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final OdotTransport LAN;
    public static final OdotTransport Unknown;
    public static final OdotTransport WAN;
    private int mValue;

    private OdotTransport(String s, int i, int j)
    {
        super(s, i);
        mValue = j;
    }

    public static OdotTransport fromValue(int i)
    {
        OdotTransport aodottransport[] = values();
        int k = aodottransport.length;
        for (int j = 0; j < k; j++)
        {
            OdotTransport odottransport = aodottransport[j];
            if (odottransport.value() == i)
            {
                return odottransport;
            }
        }

        return Unknown;
    }

    public static OdotTransport valueOf(String s)
    {
        return (OdotTransport)Enum.valueOf(com/amazon/dcp/messaging/OdotTransport, s);
    }

    public static OdotTransport[] values()
    {
        return (OdotTransport[])$VALUES.clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public int value()
    {
        return mValue;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mValue);
    }

    static 
    {
        LAN = new OdotTransport("LAN", 0, 0);
        WAN = new OdotTransport("WAN", 1, 1);
        Unknown = new OdotTransport("Unknown", 2, 0x7fffffff);
        $VALUES = (new OdotTransport[] {
            LAN, WAN, Unknown
        });
    }
}

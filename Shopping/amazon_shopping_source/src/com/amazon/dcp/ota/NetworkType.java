// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;

import android.os.Parcel;
import android.os.Parcelable;

public final class NetworkType extends Enum
    implements Parcelable
{

    private static final NetworkType $VALUES[];
    static final boolean $assertionsDisabled;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NetworkType createFromParcel(Parcel parcel)
        {
            return NetworkType.fromValue(parcel.readInt());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public NetworkType[] newArray(int i)
        {
            return new NetworkType[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final NetworkType LAN;
    public static final NetworkType Roaming;
    public static final NetworkType Unknown;
    public static final NetworkType WAN;
    private int mValue;

    private NetworkType(String s, int i, int j)
    {
        super(s, i);
        mValue = j;
    }

    public static NetworkType fromValue(int i)
    {
        NetworkType anetworktype[] = values();
        int k = anetworktype.length;
        for (int j = 0; j < k; j++)
        {
            NetworkType networktype = anetworktype[j];
            if (networktype.mValue == i)
            {
                return networktype;
            }
        }

        return Unknown;
    }

    public static NetworkType valueOf(String s)
    {
        return (NetworkType)Enum.valueOf(com/amazon/dcp/ota/NetworkType, s);
    }

    public static NetworkType[] values()
    {
        return (NetworkType[])$VALUES.clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(mValue);
    }

    static 
    {
        boolean flag;
        if (!com/amazon/dcp/ota/NetworkType.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
        LAN = new NetworkType("LAN", 0, 1);
        WAN = new NetworkType("WAN", 1, 2);
        Roaming = new NetworkType("Roaming", 2, 3);
        Unknown = new NetworkType("Unknown", 3, 0x7fffffff);
        $VALUES = (new NetworkType[] {
            LAN, WAN, Roaming, Unknown
        });
    }
}

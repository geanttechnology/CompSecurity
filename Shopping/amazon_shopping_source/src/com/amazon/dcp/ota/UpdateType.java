// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.ota;

import android.os.Parcel;
import android.os.Parcelable;

public final class UpdateType extends Enum
    implements Parcelable
{

    private static final UpdateType $VALUES[];
    public static final UpdateType App;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public UpdateType createFromParcel(Parcel parcel)
        {
            return UpdateType.fromValue(parcel.readInt());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public UpdateType[] newArray(int i)
        {
            return new UpdateType[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final UpdateType OS;
    public static final UpdateType Unknown;
    private final int mValue;

    private UpdateType(String s, int i, int j)
    {
        super(s, i);
        mValue = j;
    }

    public static UpdateType fromValue(int i)
    {
        UpdateType aupdatetype[] = values();
        int k = aupdatetype.length;
        for (int j = 0; j < k; j++)
        {
            UpdateType updatetype = aupdatetype[j];
            if (updatetype.value() == i)
            {
                return updatetype;
            }
        }

        return Unknown;
    }

    public static UpdateType valueOf(String s)
    {
        return (UpdateType)Enum.valueOf(com/amazon/dcp/ota/UpdateType, s);
    }

    public static UpdateType[] values()
    {
        return (UpdateType[])$VALUES.clone();
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
        OS = new UpdateType("OS", 0, 0);
        App = new UpdateType("App", 1, 1);
        Unknown = new UpdateType("Unknown", 2, 0x7fffffff);
        $VALUES = (new UpdateType[] {
            OS, App, Unknown
        });
    }
}

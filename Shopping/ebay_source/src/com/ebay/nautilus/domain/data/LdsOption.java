// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;

public class LdsOption
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LdsOption createFromParcel(Parcel parcel)
        {
            return new LdsOption(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LdsOption[] newArray(int i)
        {
            return new LdsOption[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String caption;
    public String value;

    public LdsOption()
    {
    }

    private LdsOption(Parcel parcel)
    {
        value = parcel.readString();
        caption = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public int getIntValue()
    {
        int i;
        try
        {
            i = Integer.parseInt(value);
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0;
        }
        return i;
    }

    public String toString()
    {
        return caption;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(value);
        parcel.writeString(caption);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.os.Parcel;
import android.os.Parcelable;
import com.pointinside.internal.utils.StringUtils;

public class Metadata
    implements Parcelable
{

    public static android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Metadata createFromParcel(Parcel parcel)
        {
            return new Metadata(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Metadata[] newArray(int i)
        {
            return new Metadata[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final String data;
    public final String type;

    private Metadata(Parcel parcel)
    {
        type = parcel.readString();
        data = parcel.readString();
    }


    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringUtils.appendIfNotNull(stringbuilder, "TYPE", type);
        StringUtils.appendIfNotNull(stringbuilder, "DATA", data);
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(type);
        parcel.writeString(data);
    }

}

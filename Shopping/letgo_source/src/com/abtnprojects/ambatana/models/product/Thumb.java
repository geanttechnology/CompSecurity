// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import android.os.Parcel;
import android.os.Parcelable;

public class Thumb
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Thumb createFromParcel(Parcel parcel)
        {
            return new Thumb(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Thumb[] newArray(int i)
        {
            return new Thumb[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final Integer height;
    private final String url;
    private final Integer width;

    protected Thumb(Parcel parcel)
    {
        url = parcel.readString();
        width = (Integer)parcel.readSerializable();
        height = (Integer)parcel.readSerializable();
    }

    public Thumb(String s, Integer integer, Integer integer1)
    {
        url = s;
        width = integer;
        height = integer1;
    }

    public int describeContents()
    {
        return 0;
    }

    public Integer getHeight()
    {
        return height;
    }

    public String getUrl()
    {
        return url;
    }

    public Integer getWidth()
    {
        return width;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Thumb{url='").append(url).append('\'').append(", width=").append(width).append(", height=").append(height).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(url);
        parcel.writeSerializable(width);
        parcel.writeSerializable(height);
    }

}

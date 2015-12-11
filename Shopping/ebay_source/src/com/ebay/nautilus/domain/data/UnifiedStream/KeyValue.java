// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import android.os.Parcel;
import android.os.Parcelable;

public class KeyValue
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public KeyValue createFromParcel(Parcel parcel)
        {
            return new KeyValue(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public KeyValue[] newArray(int i)
        {
            return new KeyValue[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String key;
    public String source;
    public String value;

    public KeyValue(Parcel parcel)
    {
        source = parcel.readString();
        key = parcel.readString();
        value = parcel.readString();
    }

    public KeyValue(String s, String s1, String s2)
    {
        source = s;
        key = s1;
        value = s2;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("KeyValue(").append(source).append(",").append(key).append(",").append(value).append(")").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(source);
        parcel.writeString(key);
        parcel.writeString(value);
    }

}

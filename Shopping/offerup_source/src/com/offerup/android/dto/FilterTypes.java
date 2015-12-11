// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class FilterTypes
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private String name;
    private String type;

    private FilterTypes(Parcel parcel)
    {
        type = parcel.readString();
        name = parcel.readString();
    }

    FilterTypes(Parcel parcel, _cls1 _pcls1)
    {
        this(parcel);
    }

    public FilterTypes(String s, String s1)
    {
        type = s;
        name = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(type);
        parcel.writeString(name);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final FilterTypes createFromParcel(Parcel parcel)
        {
            return new FilterTypes(parcel, null);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final FilterTypes[] newArray(int i)
        {
            return new FilterTypes[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}

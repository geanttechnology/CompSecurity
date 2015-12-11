// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class FilterValue
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public FilterValue createFromParcel(Parcel parcel)
        {
            return new FilterValue(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public FilterValue[] newArray(int i)
        {
            return new FilterValue[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String filterId;
    public String filterValue;

    protected FilterValue(Parcel parcel)
    {
        filterId = parcel.readString();
        filterValue = parcel.readString();
    }

    public FilterValue(String s, String s1)
    {
        filterId = s;
        filterValue = s1;
    }

    public String asUrlParam()
    {
        return String.format("%s:%s", new Object[] {
            filterId, filterValue
        });
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(filterId);
        parcel.writeString(filterValue);
    }

}

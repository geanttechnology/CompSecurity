// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortMethod
    implements Parcelable
{
    public static class Methods
    {

        public static final SortMethod DISTANCE;
        public static final SortMethod PRICE_ASC;
        public static final SortMethod PRICE_DESC;
        public static final SortMethod RELEVANCE;
        public static final List values;

        static 
        {
            RELEVANCE = new SortMethod("relevance");
            PRICE_ASC = new SortMethod("price:asc");
            PRICE_DESC = new SortMethod("price:desc");
            DISTANCE = new SortMethod("distance");
            values = Collections.unmodifiableList(Arrays.asList(new SortMethod[] {
                RELEVANCE, PRICE_ASC, PRICE_DESC, DISTANCE
            }));
        }

        public Methods()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SortMethod createFromParcel(Parcel parcel)
        {
            return new SortMethod(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SortMethod[] newArray(int i)
        {
            return new SortMethod[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String ID_DISTANCE = "distance";
    public static final String ID_PRICE_ASC = "price:asc";
    public static final String ID_PRICE_DESC = "price:desc";
    public static final String ID_RELEVANCE = "relevance";
    public String id;

    private SortMethod(Parcel parcel)
    {
        id = parcel.readString();
    }


    private SortMethod(String s)
    {
        id = s;
    }


    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return obj != null && (obj instanceof SortMethod) && ((SortMethod)obj).id.equals(id);
    }

    public int hashCode()
    {
        return id.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
    }

}

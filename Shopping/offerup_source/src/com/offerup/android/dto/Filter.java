// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class Filter
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private boolean defaultValue;
    private String label;
    private String name;
    private List options;
    private boolean selected;
    private String type;

    public Filter()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public String getLabel()
    {
        return label;
    }

    public String getName()
    {
        return name;
    }

    public List getOptions()
    {
        return options;
    }

    public String getType()
    {
        return type;
    }

    public boolean isDefaultValue()
    {
        return defaultValue;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeString(label);
        parcel.writeString(type);
        parcel.writeTypedList(options);
        if (selected)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }



/*
    static String access$002(Filter filter, String s)
    {
        filter.name = s;
        return s;
    }

*/


/*
    static String access$102(Filter filter, String s)
    {
        filter.label = s;
        return s;
    }

*/


/*
    static String access$202(Filter filter, String s)
    {
        filter.type = s;
        return s;
    }

*/



/*
    static List access$302(Filter filter, List list)
    {
        filter.options = list;
        return list;
    }

*/


/*
    static boolean access$402(Filter filter, boolean flag)
    {
        filter.selected = flag;
        return flag;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Filter createFromParcel(Parcel parcel)
        {
            Filter filter = new Filter();
            filter.name = parcel.readString();
            filter.label = parcel.readString();
            filter.type = parcel.readString();
            filter.options = new ArrayList();
            parcel.readTypedList(filter.options, FilterOption.CREATOR);
            filter.selected = (new OfferUpBoolean(parcel.readInt())).value;
            return filter;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Filter[] newArray(int i)
        {
            return new Filter[i];
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

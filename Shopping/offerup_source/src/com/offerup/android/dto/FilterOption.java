// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class FilterOption
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private boolean defaultValue;
    private String labelLong;
    private String labelShort;
    private boolean selected;
    private String value;

    public FilterOption()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public String getLongLabel()
    {
        return labelLong;
    }

    public String getShortLabel()
    {
        return labelShort;
    }

    public String getValue()
    {
        return value;
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
        boolean flag = true;
        parcel.writeString(labelLong);
        if (defaultValue)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(labelShort);
        parcel.writeString(value);
        if (selected)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }



/*
    static String access$002(FilterOption filteroption, String s)
    {
        filteroption.labelLong = s;
        return s;
    }

*/


/*
    static boolean access$102(FilterOption filteroption, boolean flag)
    {
        filteroption.defaultValue = flag;
        return flag;
    }

*/


/*
    static String access$202(FilterOption filteroption, String s)
    {
        filteroption.labelShort = s;
        return s;
    }

*/


/*
    static String access$302(FilterOption filteroption, String s)
    {
        filteroption.value = s;
        return s;
    }

*/


/*
    static boolean access$402(FilterOption filteroption, boolean flag)
    {
        filteroption.selected = flag;
        return flag;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final FilterOption createFromParcel(Parcel parcel)
        {
            FilterOption filteroption = new FilterOption();
            filteroption.labelLong = parcel.readString();
            filteroption.defaultValue = (new OfferUpBoolean(parcel.readInt())).value;
            filteroption.labelShort = parcel.readString();
            filteroption.value = parcel.readString();
            filteroption.selected = (new OfferUpBoolean(parcel.readInt())).value;
            return filteroption;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final FilterOption[] newArray(int i)
        {
            return new FilterOption[i];
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

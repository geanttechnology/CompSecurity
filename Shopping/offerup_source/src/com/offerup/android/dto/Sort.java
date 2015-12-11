// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Sort
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private boolean defaultValue;
    private String labelLong;
    private String labelShort;
    private boolean selected;
    private String value;

    public Sort()
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
        parcel.writeString(value);
        parcel.writeString(labelShort);
        if (defaultValue)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
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
    static String access$002(Sort sort, String s)
    {
        sort.labelLong = s;
        return s;
    }

*/


/*
    static String access$102(Sort sort, String s)
    {
        sort.value = s;
        return s;
    }

*/


/*
    static String access$202(Sort sort, String s)
    {
        sort.labelShort = s;
        return s;
    }

*/


/*
    static boolean access$302(Sort sort, boolean flag)
    {
        sort.defaultValue = flag;
        return flag;
    }

*/


/*
    static boolean access$402(Sort sort, boolean flag)
    {
        sort.selected = flag;
        return flag;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Sort createFromParcel(Parcel parcel)
        {
            Sort sort = new Sort();
            sort.labelLong = parcel.readString();
            sort.value = parcel.readString();
            sort.labelShort = parcel.readString();
            sort.defaultValue = (new OfferUpBoolean(parcel.readInt())).value;
            sort.selected = (new OfferUpBoolean(parcel.readInt())).value;
            return sort;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Sort[] newArray(int i)
        {
            return new Sort[i];
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

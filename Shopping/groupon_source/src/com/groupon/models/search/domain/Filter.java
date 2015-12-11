// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.search.domain:
//            FilterValue

public class Filter
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Filter createFromParcel(Parcel parcel)
        {
            return new Filter(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Filter[] newArray(int i)
        {
            return new Filter[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String filterId;
    private List filterValues;

    protected Filter(Parcel parcel)
    {
        filterValues = new ArrayList();
        filterId = parcel.readString();
        filterValues = parcel.createTypedArrayList(FilterValue.CREATOR);
    }

    public Filter(String s)
    {
        filterValues = new ArrayList();
        filterId = s;
    }

    public void addFilterValue(FilterValue filtervalue)
    {
        filterValues.add(filtervalue);
    }

    public String asUrlParam()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = filterValues.iterator(); iterator.hasNext(); arraylist.add(((FilterValue)iterator.next()).asUrlParam())) { }
        return Strings.join(";", arraylist);
    }

    public int describeContents()
    {
        return 0;
    }

    public String getFilterValue(String s)
    {
        for (Iterator iterator = filterValues.iterator(); iterator.hasNext();)
        {
            FilterValue filtervalue = (FilterValue)iterator.next();
            if (Strings.equals(filtervalue.filterId, s))
            {
                return filtervalue.filterValue;
            }
        }

        return null;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(filterId);
        parcel.writeTypedList(filterValues);
    }

}

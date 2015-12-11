// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            Trend

public static class ConstructTextSpan
    implements Parcelable
{

    public static final android.os. CREATOR = new android.os.Parcelable.Creator() {

        public Trend.SearchStats createFromParcel(Parcel parcel)
        {
            return new Trend.SearchStats(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Trend.SearchStats[] newArray(int i)
        {
            return new Trend.SearchStats[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public List searchHistogramEntries;
    public eProperty total;
    public eProperty totalClicks;

    private eProperty ConstructTextSpan(Parcel parcel)
    {
        eProperty eproperty = new eProperty();
        eproperty.value = Long.valueOf(parcel.readLong());
        int i = parcel.readInt();
        eproperty.textSpans = new ArrayList(i);
        for (; i > 0; i--)
        {
            eProperty eproperty1 = new it>();
            eproperty1.t = parcel.readString();
            eproperty.textSpans.add(eproperty1);
        }

        return eproperty;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedList(searchHistogramEntries);
        parcel.writeLong(((Long)total.value).longValue());
        parcel.writeInt(total.textSpans.size());
        for (Iterator iterator = total.textSpans.iterator(); iterator.hasNext(); parcel.writeString(((eProperty.textSpans)iterator.next()).t)) { }
        parcel.writeLong(((Long)totalClicks.value).longValue());
        parcel.writeInt(totalClicks.textSpans.size());
        for (Iterator iterator1 = totalClicks.textSpans.iterator(); iterator1.hasNext(); parcel.writeString(((eProperty.textSpans)iterator1.next()).t)) { }
    }


    public _cls1(Parcel parcel)
    {
        searchHistogramEntries = new ArrayList();
        parcel.readTypedList(searchHistogramEntries, ramEntry.CREATOR);
        total = ConstructTextSpan(parcel);
        totalClicks = ConstructTextSpan(parcel);
    }
}

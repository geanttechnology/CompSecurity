// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags;

import android.os.Parcel;
import android.os.Parcelable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Referenced classes of package com.xfinity.playerlib.model.tags:
//            Tag

public final class OrderedTag
    implements Parcelable, Tag, Comparable
{

    public static final OrderedTag ALL_MOVIES = new OrderedTag("-2", "Movies", 1);
    public static final OrderedTag ALL_TV = new OrderedTag("-1", "Series", 2);
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public OrderedTag createFromParcel(Parcel parcel)
        {
            return new OrderedTag(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public OrderedTag[] newArray(int i)
        {
            return new OrderedTag[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private final String merlinId;
    private final String name;
    private final int order;

    private OrderedTag(Parcel parcel)
    {
        merlinId = parcel.readString();
        name = parcel.readString();
        order = parcel.readInt();
    }


    public OrderedTag(String s, String s1, int i)
    {
        merlinId = s;
        name = s1;
        order = i;
    }

    public int compareTo(OrderedTag orderedtag)
    {
        if (order < orderedtag.order)
        {
            return -1;
        }
        return order <= orderedtag.order ? 0 : 1;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((OrderedTag)obj);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (OrderedTag)obj;
            if (order != ((OrderedTag) (obj)).order)
            {
                return false;
            }
            if (merlinId == null ? ((OrderedTag) (obj)).merlinId != null : !merlinId.equals(((OrderedTag) (obj)).merlinId))
            {
                return false;
            }
            if (name == null ? ((OrderedTag) (obj)).name != null : !name.equals(((OrderedTag) (obj)).name))
            {
                return false;
            }
        }
        return true;
    }

    public String getId()
    {
        return merlinId;
    }

    public String getName()
    {
        return name;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (merlinId != null)
        {
            i = merlinId.hashCode();
        } else
        {
            i = 0;
        }
        if (name != null)
        {
            j = name.hashCode();
        }
        return (i * 31 + j) * 31 + order;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("id", merlinId).append("name", name).append("order", order).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(merlinId);
        parcel.writeString(name);
        parcel.writeInt(order);
    }

}

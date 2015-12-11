// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gdt;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.groupon.models.gdt:
//            GdtUserOrdersItem

public class GdtUserOrdersData
    implements Parcelable
{
    private static class GdtUserOrdersDataCreator
        implements android.os.Parcelable.Creator
    {

        public GdtUserOrdersData createFromParcel(Parcel parcel)
        {
            return new GdtUserOrdersData(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public GdtUserOrdersData[] newArray(int i)
        {
            return new GdtUserOrdersData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        private GdtUserOrdersDataCreator()
        {
        }

    }


    public static final android.os.Parcelable.Creator CREATOR = new GdtUserOrdersDataCreator();
    public List orders;
    public int pageSize;

    public GdtUserOrdersData()
    {
        orders = Collections.emptyList();
    }

    private GdtUserOrdersData(Parcel parcel)
    {
        orders = Collections.emptyList();
        pageSize = parcel.readInt();
        parcel.readList(orders, com/groupon/models/gdt/GdtUserOrdersItem.getClassLoader());
    }


    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(pageSize);
        parcel.writeList(orders);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;

import android.os.Parcel;
import android.os.Parcelable;
import com.pointinside.internal.utils.StringUtils;
import java.util.Iterator;
import java.util.List;

public class CustomerData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CustomerData createFromParcel(Parcel parcel)
        {
            java.util.ArrayList arraylist;
            if (parcel.readByte() == 0)
            {
                arraylist = parcel.createStringArrayList();
            } else
            {
                arraylist = null;
            }
            if (parcel.readByte() == 0)
            {
                parcel = parcel.createStringArrayList();
            } else
            {
                parcel = null;
            }
            return new CustomerData(arraylist, parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CustomerData[] newArray(int i)
        {
            return new CustomerData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public final List alternateIds;
    public final List catEntryIds;

    private CustomerData(Parcel parcel)
    {
        catEntryIds = parcel.createStringArrayList();
        alternateIds = parcel.createStringArrayList();
    }

    private CustomerData(List list, List list1)
    {
        catEntryIds = list;
        alternateIds = list1;
    }


    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (catEntryIds != null)
        {
            for (Iterator iterator = catEntryIds.iterator(); iterator.hasNext(); StringUtils.appendIfNotNull(stringbuilder, "catentryid", (String)iterator.next())) { }
        }
        if (alternateIds != null)
        {
            for (Iterator iterator1 = alternateIds.iterator(); iterator1.hasNext(); StringUtils.appendIfNotNull(stringbuilder, "alternateId", (String)iterator1.next())) { }
        }
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        if (catEntryIds == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (catEntryIds != null)
        {
            parcel.writeStringList(catEntryIds);
        }
        if (alternateIds == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (alternateIds != null)
        {
            parcel.writeStringList(alternateIds);
        }
    }

}

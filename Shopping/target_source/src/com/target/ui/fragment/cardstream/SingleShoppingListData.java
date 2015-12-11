// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.b.h;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.model.list.ListDetailItem;
import java.util.List;

public class SingleShoppingListData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SingleShoppingListData a(Parcel parcel)
        {
            return new SingleShoppingListData(parcel);
        }

        public SingleShoppingListData[] a(int i)
        {
            return new SingleShoppingListData[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    public final h listItems;
    public final ListSummary listSummary;

    private SingleShoppingListData(Parcel parcel)
    {
        listSummary = (ListSummary)parcel.readParcelable(com/target/mothership/model/list/interfaces/ListSummary.getClassLoader());
        listItems = h.a(parcel.readArrayList(com/target/ui/model/list/ListDetailItem.getClassLoader()));
    }


    public SingleShoppingListData(ListSummary listsummary, List list)
    {
        listSummary = listsummary;
        listItems = h.a(list);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (SingleShoppingListData)obj;
        if (listSummary == null ? ((SingleShoppingListData) (obj)).listSummary != null : !listSummary.equals(((SingleShoppingListData) (obj)).listSummary))
        {
            return false;
        }
        if (listItems == null) goto _L4; else goto _L3
_L3:
        if (listItems.equals(((SingleShoppingListData) (obj)).listItems)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((SingleShoppingListData) (obj)).listItems == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (listSummary != null)
        {
            i = listSummary.hashCode();
        } else
        {
            i = 0;
        }
        if (listItems != null)
        {
            j = listItems.hashCode();
        }
        return i * 31 + j;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(listSummary, i);
        parcel.writeList(listItems);
    }

}

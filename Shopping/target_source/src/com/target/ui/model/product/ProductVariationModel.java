// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.product;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.f.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.target.ui.model.product:
//            ListItem, GridItem

public class ProductVariationModel
    implements Parcelable
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a NONE;
        public static final a SINGLE_DIMENSION_GRID;
        public static final a SINGLE_DIMENSION_LIST;
        public static final a TWO_DIMENSION;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/model/product/ProductVariationModel$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            NONE = new a("NONE", 0);
            TWO_DIMENSION = new a("TWO_DIMENSION", 1);
            SINGLE_DIMENSION_LIST = new a("SINGLE_DIMENSION_LIST", 2);
            SINGLE_DIMENSION_GRID = new a("SINGLE_DIMENSION_GRID", 3);
            $VALUES = (new a[] {
                NONE, TWO_DIMENSION, SINGLE_DIMENSION_LIST, SINGLE_DIMENSION_GRID
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ProductVariationModel a(Parcel parcel)
        {
            return new ProductVariationModel(parcel);
        }

        public ProductVariationModel[] a(int i)
        {
            return new ProductVariationModel[i];
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
    private LinkedHashMap mAvailabilityArray;
    private List mGridItemArray;
    private GridItem mGridSavedState;
    private List mListItemArray;
    private ListItem mListSavedState;
    private String mListTitle;
    private a mVariationType;

    public ProductVariationModel()
    {
    }

    private ProductVariationModel(Parcel parcel)
    {
        mListTitle = parcel.readString();
        mListSavedState = (ListItem)parcel.readParcelable(com/target/ui/model/product/ListItem.getClassLoader());
        mGridSavedState = (GridItem)parcel.readParcelable(com/target/ui/model/product/GridItem.getClassLoader());
        int i = parcel.readInt();
        Object obj;
        int j;
        if (i == -1)
        {
            obj = null;
        } else
        {
            obj = a.values()[i];
        }
        mVariationType = ((a) (obj));
        mListItemArray = new ArrayList();
        parcel.readList(mListItemArray, com/target/ui/model/product/ListItem.getClassLoader());
        mGridItemArray = new ArrayList();
        parcel.readList(mGridItemArray, com/target/ui/model/product/GridItem.getClassLoader());
        mAvailabilityArray = new LinkedHashMap();
        j = parcel.readInt();
        for (i = 0; i < j; i++)
        {
            Object obj1 = (ListItem)parcel.readParcelable(com/target/ui/model/product/ListItem.getClassLoader());
            GridItem griditem = (GridItem)parcel.readParcelable(com/target/ui/model/product/ListItem.getClassLoader());
            obj = (Boolean)parcel.readValue(java/lang/Boolean.getClassLoader());
            obj1 = new h(obj1, griditem);
            mAvailabilityArray.put(obj1, obj);
        }

    }


    public a a()
    {
        return mVariationType;
    }

    public void a(GridItem griditem)
    {
        mGridSavedState = griditem;
    }

    public void a(ListItem listitem)
    {
        mListSavedState = listitem;
    }

    public void a(a a1)
    {
        mVariationType = a1;
    }

    public void a(String s)
    {
        mListTitle = s;
    }

    public void a(LinkedHashMap linkedhashmap)
    {
        mAvailabilityArray = linkedhashmap;
    }

    public void a(List list)
    {
        mListItemArray = list;
    }

    public List b()
    {
        return mListItemArray;
    }

    public void b(List list)
    {
        mGridItemArray = list;
    }

    public List c()
    {
        return mGridItemArray;
    }

    public LinkedHashMap d()
    {
        return mAvailabilityArray;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return mListTitle;
    }

    public ListItem f()
    {
        return mListSavedState;
    }

    public GridItem g()
    {
        return mGridSavedState;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mListTitle);
        parcel.writeParcelable(mListSavedState, i);
        parcel.writeParcelable(mGridSavedState, i);
        int j;
        if (mVariationType == null)
        {
            j = -1;
        } else
        {
            j = mVariationType.ordinal();
        }
        parcel.writeInt(j);
        parcel.writeList(mListItemArray);
        parcel.writeList(mGridItemArray);
        parcel.writeInt(mAvailabilityArray.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = mAvailabilityArray.entrySet().iterator(); iterator.hasNext(); parcel.writeValue(entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
            parcel.writeParcelable((Parcelable)((h)entry.getKey()).a, i);
            parcel.writeParcelable((Parcelable)((h)entry.getKey()).b, i);
        }

    }

}

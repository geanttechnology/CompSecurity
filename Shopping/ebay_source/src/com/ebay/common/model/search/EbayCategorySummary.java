// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.EbayCategory;

public final class EbayCategorySummary
    implements Parcelable, Cloneable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayCategorySummary createFromParcel(Parcel parcel)
        {
            return new EbayCategorySummary(parcel.readLong(), parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayCategorySummary[] newArray(int i)
        {
            return new EbayCategorySummary[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final long DEFAULT_CATEGORY_ID = -2L;
    public static final long EXPLICIT_ALL_CATEGORIES_ID = 0L;
    public long id;
    public String name;

    public EbayCategorySummary()
    {
        this(-2L, null);
    }

    public EbayCategorySummary(long l, String s)
    {
        id = l;
        name = s;
    }

    public EbayCategorySummary(EbayCategoryHistogram.Category category)
    {
        id = category.id;
        name = category.name;
    }

    public EbayCategorySummary(EbayCategoryHistogram.ParentCategory parentcategory)
    {
        id = parentcategory.id;
        name = parentcategory.name;
    }

    public EbayCategorySummary(EbayCategory ebaycategory)
    {
        id = ebaycategory.id;
        name = ebaycategory.name;
    }

    public EbayCategorySummary clone()
    {
        EbayCategorySummary ebaycategorysummary;
        try
        {
            ebaycategorysummary = (EbayCategorySummary)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return null;
        }
        return ebaycategorysummary;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof EbayCategorySummary) || id != ((EbayCategorySummary)obj).id) 
        {
            return false;
        }
        return true;
    }

    public boolean isDefault()
    {
        return id == -2L;
    }

    public String toString()
    {
        return (new StringBuilder()).append(name).append(" (").append(id).append(')').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(id);
        parcel.writeString(name);
    }

}

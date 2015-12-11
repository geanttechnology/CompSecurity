// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.search.domain.FacetFilter;
import com.groupon.models.search.domain.FilterSheetListItemType;
import java.util.List;

public abstract class Facet
    implements Parcelable, FilterSheetListItemType
{

    public int count;
    public String friendlyName;
    public String id;

    public Facet()
    {
    }

    public Facet(Parcel parcel)
    {
        id = parcel.readString();
        friendlyName = parcel.readString();
        count = parcel.readInt();
    }

    public Facet(String s)
    {
        id = s;
    }

    public abstract FacetFilter createEmptyFacetFilter(String s);

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof Facet))
        {
            return false;
        } else
        {
            return ((Facet)obj).id.equals(id);
        }
    }

    public abstract int getFilterSheetListItemType();

    public abstract List getValues();

    public int hashCode()
    {
        return id.hashCode();
    }

    public boolean isMultiSelect()
    {
        return true;
    }

    public boolean isNested()
    {
        return false;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(friendlyName);
        parcel.writeInt(count);
    }
}

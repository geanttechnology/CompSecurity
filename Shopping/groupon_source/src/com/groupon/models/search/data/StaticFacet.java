// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.data;

import android.os.Parcel;
import com.groupon.models.search.domain.FacetFilter;
import com.groupon.models.search.domain.NestedFilter;
import com.groupon.models.search.domain.StaticFilter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.models.search.data:
//            Facet, FacetValue

public class StaticFacet extends Facet
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StaticFacet createFromParcel(Parcel parcel)
        {
            return new StaticFacet(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public StaticFacet[] newArray(int i)
        {
            return new StaticFacet[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int nestedType = 2;
    public static final int staticType = 1;
    public List values;

    public StaticFacet()
    {
        values = new ArrayList();
    }

    public StaticFacet(Parcel parcel)
    {
        super(parcel);
        values = new ArrayList();
        parcel.readList(values, com/groupon/models/search/data/FacetValue.getClassLoader());
    }

    public StaticFacet(String s)
    {
        super(s);
        values = new ArrayList();
    }

    public FacetFilter createEmptyFacetFilter(String s)
    {
        if (isNested())
        {
            return new NestedFilter(s);
        } else
        {
            return new StaticFilter(s);
        }
    }

    public int getFilterSheetListItemType()
    {
        return !isNested() ? 1 : 2;
    }

    public List getValues()
    {
        return values;
    }

    public boolean isNested()
    {
        return id.contains("|");
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeList(values);
    }

}

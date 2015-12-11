// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.data;

import android.os.Parcel;
import com.groupon.models.search.domain.FacetFilter;
import com.groupon.models.search.domain.RangedFilter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.models.search.data:
//            Facet, RangedFacetValue

public class RangedFacet extends Facet
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RangedFacet createFromParcel(Parcel parcel)
        {
            return new RangedFacet(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RangedFacet[] newArray(int i)
        {
            return new RangedFacet[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int rangedType = 0;
    public List values;

    public RangedFacet()
    {
        values = new ArrayList();
    }

    public RangedFacet(Parcel parcel)
    {
        super(parcel);
        values = new ArrayList();
        parcel.readList(values, com/groupon/models/search/data/RangedFacetValue.getClassLoader());
    }

    public RangedFacet(String s)
    {
        super(s);
        values = new ArrayList();
    }

    public FacetFilter createEmptyFacetFilter(String s)
    {
        return new RangedFilter(s);
    }

    public int getFilterSheetListItemType()
    {
        return 0;
    }

    public List getValues()
    {
        return values;
    }

    public boolean isMultiSelect()
    {
        return false;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeList(values);
    }

}

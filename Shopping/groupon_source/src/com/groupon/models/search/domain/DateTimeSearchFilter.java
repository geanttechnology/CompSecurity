// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import android.os.Parcel;
import com.groupon.models.search.data.FacetValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.search.domain:
//            FacetFilter, RangedFilter

public class DateTimeSearchFilter extends FacetFilter
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RangedFilter createFromParcel(Parcel parcel)
        {
            return new RangedFilter(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RangedFilter[] newArray(int i)
        {
            return new RangedFilter[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public DateTimeSearchFilter(Parcel parcel)
    {
        super(parcel);
    }

    public DateTimeSearchFilter(String s)
    {
        super(s);
    }

    public String asUrlParam()
    {
        StringBuilder stringbuilder = new StringBuilder(facetId);
        if (selectedFacetValueList.size() > 0)
        {
            stringbuilder.append("->");
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator = selectedFacetValueList.iterator(); iterator.hasNext(); arraylist.add(((FacetValue)iterator.next()).id)) { }
            stringbuilder.append(Strings.join(";", arraylist));
        }
        return stringbuilder.toString();
    }

}

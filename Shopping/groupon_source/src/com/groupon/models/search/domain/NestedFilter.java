// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import android.os.Parcel;
import com.groupon.models.search.data.FacetValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.search.domain:
//            FacetFilter

public class NestedFilter extends FacetFilter
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NestedFilter createFromParcel(Parcel parcel)
        {
            return new NestedFilter(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public NestedFilter[] newArray(int i)
        {
            return new NestedFilter[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public NestedFilter(Parcel parcel)
    {
        super(parcel);
    }

    public NestedFilter(String s)
    {
        super(s);
    }

    public String asUrlParam()
    {
        String as[] = facetId.split("\\|");
        StringBuilder stringbuilder = new StringBuilder(facetId);
        if (selectedFacetValueList.size() > 0)
        {
            stringbuilder.append("->(");
            ArrayList arraylist = new ArrayList();
            FacetValue facetvalue;
            for (Iterator iterator = selectedFacetValueList.iterator(); iterator.hasNext(); arraylist.add(String.format(Locale.US, "%s:%s", new Object[] {
    as[facetvalue.derivedDepth], facetvalue.id
})))
            {
                facetvalue = (FacetValue)iterator.next();
            }

            stringbuilder.append(Strings.join(" AND ", arraylist));
            stringbuilder.append(")");
        }
        return stringbuilder.toString();
    }

}

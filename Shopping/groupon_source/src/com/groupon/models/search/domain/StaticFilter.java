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

public class StaticFilter extends FacetFilter
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public StaticFilter createFromParcel(Parcel parcel)
        {
            return new StaticFilter(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public StaticFilter[] newArray(int i)
        {
            return new StaticFilter[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };

    public StaticFilter(Parcel parcel)
    {
        super(parcel);
    }

    public StaticFilter(String s)
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
            FacetValue facetvalue;
            for (Iterator iterator = selectedFacetValueList.iterator(); iterator.hasNext(); arraylist.add(String.format(Locale.US, "%s:%s", new Object[] {
    facetId, facetvalue.id
})))
            {
                facetvalue = (FacetValue)iterator.next();
            }

            if (selectedFacetValueList.size() > 1)
            {
                stringbuilder.append(String.format("(%s)", new Object[] {
                    Strings.join(" OR ", arraylist)
                }));
            } else
            {
                stringbuilder.append(Strings.join(" OR ", arraylist));
            }
        }
        return stringbuilder.toString();
    }

}

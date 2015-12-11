// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import com.groupon.models.search.data.Facet;
import com.groupon.models.search.data.FacetValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.search.domain:
//            NestedFacetValueDisplayListBuilder

public class FacetSelectionSummaryStringBuilder
{

    public FacetSelectionSummaryStringBuilder()
    {
    }

    public String buildSummaryString(Facet facet)
    {
        Iterator iterator;
        int i;
        switch (facet.getFilterSheetListItemType())
        {
        default:
            throw new IllegalStateException("Unsupported facet type");

        case 0: // '\0'
        case 1: // '\001'
            ArrayList arraylist = new ArrayList();
            facet = facet.getValues().iterator();
            do
            {
                if (!facet.hasNext())
                {
                    break;
                }
                FacetValue facetvalue1 = (FacetValue)facet.next();
                if (facetvalue1.isSelected)
                {
                    arraylist.add(facetvalue1.friendlyName);
                }
            } while (true);
            return Strings.join(", ", arraylist);

        case 2: // '\002'
            ArrayList arraylist1 = new ArrayList();
            (new NestedFacetValueDisplayListBuilder()).generateDisplayFacetValueListForNestedFacet(facet.getValues(), arraylist1);
            i = -1;
            facet = null;
            iterator = arraylist1.iterator();
            break;
        }
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FacetValue facetvalue = (FacetValue)iterator.next();
            if (facetvalue.isSelected && facetvalue.derivedDepth > i)
            {
                i = facetvalue.derivedDepth;
                facet = facetvalue;
            }
        } while (true);
        if (facet != null)
        {
            return ((FacetValue) (facet)).friendlyName;
        } else
        {
            return "";
        }
    }
}

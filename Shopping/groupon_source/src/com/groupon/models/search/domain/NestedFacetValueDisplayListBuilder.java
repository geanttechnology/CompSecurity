// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import com.groupon.models.search.data.FacetValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedFacetValueDisplayListBuilder
{

    public NestedFacetValueDisplayListBuilder()
    {
    }

    public void generateDisplayFacetValueListForNestedFacet(List list, List list1)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ArrayList arraylist1;
        ArrayList arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        for (list = list.iterator(); list.hasNext();)
        {
            FacetValue facetvalue2 = (FacetValue)list.next();
            if (facetvalue2.isSelected)
            {
                arraylist.add(facetvalue2);
            } else
            {
                arraylist1.add(facetvalue2);
            }
        }

        if (arraylist.size() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        list = arraylist.iterator();
        while (list.hasNext()) 
        {
            FacetValue facetvalue = (FacetValue)list.next();
            list1.add(facetvalue);
            generateDisplayFacetValueListForNestedFacet(facetvalue.children, list1);
        }
        if (true) goto _L1; else goto _L3
_L3:
        list = arraylist1.iterator();
        while (list.hasNext()) 
        {
            FacetValue facetvalue1 = (FacetValue)list.next();
            boolean flag;
            if (facetvalue1.derivedDepth > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            facetvalue1.isDerivedLeaf = flag;
            list1.add(facetvalue1);
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}

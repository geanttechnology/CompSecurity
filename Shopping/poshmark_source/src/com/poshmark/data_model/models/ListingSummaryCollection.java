// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.utils.ItemPair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            PMData, ListingSummary, Facets

public class ListingSummaryCollection extends PMData
{

    private List data;
    Facets facets;
    LinkedHashMap listingSummaryMap;
    PMData.NextMaxID more;

    public ListingSummaryCollection()
    {
        data = new ArrayList();
        more = null;
        listingSummaryMap = new LinkedHashMap();
    }

    public void append(PMData pmdata)
    {
        if (data != null && pmdata != null)
        {
            ListingSummaryCollection listingsummarycollection = (ListingSummaryCollection)pmdata;
            for (pmdata = ((ListingSummaryCollection)pmdata).data.iterator(); pmdata.hasNext();)
            {
                ListingSummary listingsummary = (ListingSummary)pmdata.next();
                if (listingSummaryMap.containsKey(listingsummary.id))
                {
                    pmdata.remove();
                } else
                {
                    listingSummaryMap.put(listingsummary.id, listingsummary);
                }
            }

            data.addAll(listingsummarycollection.data);
            more = listingsummarycollection.more;
        }
    }

    public void createHashAndRemoveDups()
    {
        for (Iterator iterator = data.iterator(); iterator.hasNext();)
        {
            ListingSummary listingsummary = (ListingSummary)iterator.next();
            if (listingSummaryMap.containsKey(listingsummary.id))
            {
                iterator.remove();
            } else
            {
                listingSummaryMap.put(listingsummary.id, listingsummary);
            }
        }

    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        if (data == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        LinkedHashMap linkedhashmap = listingSummaryMap;
        linkedhashmap;
        JVM INSTR monitorenter ;
        int j;
        int k;
        j = listingSummaryMap.size();
        k = j / 2;
        int i = 0;
        Object aobj[] = listingSummaryMap.values().toArray();
_L2:
        if (i >= k * 2)
        {
            break; /* Loop/switch isn't completed */
        }
        custommatrixcursor.addRow(new Object[] {
            Integer.valueOf(0), new ItemPair((ListingSummary)aobj[i], (ListingSummary)aobj[i + 1])
        });
        i += 2;
        if (true) goto _L2; else goto _L1
_L1:
        if (j % 2 == 0)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        custommatrixcursor.addRow(new Object[] {
            Integer.valueOf(0), new ItemPair((ListingSummary)aobj[j - 1], null)
        });
        linkedhashmap;
        JVM INSTR monitorexit ;
        return;
        custommatrixcursor;
        linkedhashmap;
        JVM INSTR monitorexit ;
        throw custommatrixcursor;
    }

    public Facets getFacets()
    {
        return facets;
    }

    public String getNextPageMaxValue()
    {
        if (more != null)
        {
            return more.next_max_id;
        } else
        {
            return null;
        }
    }

    public boolean hasListing(String s)
    {
        return listingSummaryMap.containsKey(s);
    }

    public boolean isEmpty()
    {
        return listingSummaryMap.isEmpty();
    }

    public void removeListing(String s)
    {
        listingSummaryMap.remove(s);
    }
}

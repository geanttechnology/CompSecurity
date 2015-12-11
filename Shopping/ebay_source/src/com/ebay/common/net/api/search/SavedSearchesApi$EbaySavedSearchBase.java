// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.EbayRequestHelper;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

private static abstract class context
    implements com.ebay.common.net.api.finding.ontext
{

    private EbayAspectHistogram aspects;
    private EbayCategoryHistogram categories;
    private final EbayContext context;
    private ArrayList firstPage;
    private ArrayList itemIds;
    private int listCount;
    private String savedSearchQuery;
    private int totalCount;

    private nse sendRequestAndTrackResponse(e e, int i)
        throws com.ebay.nautilus.kernel.net.ponse, com.ebay.nautilus.kernel.net.ponse, com.ebay.common.net.eption, com.ebay.nautilus.kernel.net.ponse, IOException, InterruptedException
    {
        e = (nse)EbayRequestHelper.sendRequest(context, e);
        trackResponse(e, i);
        return e;
    }

    public void fill(ArrayList arraylist, int i, int j)
        throws com.ebay.nautilus.kernel.net.ase, com.ebay.nautilus.kernel.net.ase, com.ebay.common.net.eption, com.ebay.nautilus.kernel.net.ase, IOException, InterruptedException
    {
        if (i < listCount) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k;
        k = j;
        if (i + j > listCount)
        {
            k = listCount - i;
        }
        if (i != 0 || firstPage == null || firstPage.size() != k)
        {
            break; /* Loop/switch isn't completed */
        }
        ArrayList arraylist1 = firstPage;
        firstPage = null;
        i = 0;
        while (i < k) 
        {
            arraylist.add(arraylist1.get(i));
            i++;
        }
        if (true) goto _L1; else goto _L3
_L3:
        e e = getRequest(i);
        i = 0;
        if (e instanceof getRequest)
        {
            i = cess._mth000((cess._cls000)e);
        }
        sendRequestAndTrackResponse(e, i).fill(arraylist);
        if (arraylist.size() < k)
        {
            i = 0;
            while (i < k && arraylist.size() < k) 
            {
                arraylist.add(arraylist.get(i));
                i++;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public EbayAspectHistogram getAspects()
    {
        return aspects;
    }

    public EbayCategoryHistogram getCategories()
    {
        return categories;
    }

    public ArrayList getItemIds()
    {
        return itemIds;
    }

    protected abstract int getMaxCountPerPage();

    protected abstract e getRequest(int i);

    public final String getSavedSearchQuery()
    {
        return savedSearchQuery;
    }

    public final int getTotalCount()
    {
        return totalCount;
    }

    public int query()
        throws com.ebay.nautilus.kernel.net.ponse, com.ebay.nautilus.kernel.net.ponse, com.ebay.common.net.eption, com.ebay.nautilus.kernel.net.ponse, IOException, InterruptedException
    {
        int j = getMaxCountPerPage();
        Object obj = getRequest(0);
        int i = 0;
        if (obj instanceof getRequest)
        {
            i = cess._mth000((cess._cls000)obj);
        }
        obj = sendRequestAndTrackResponse(((e) (obj)), i);
        itemIds = ((nse) (obj)).getItemIds();
        totalCount = ((nse) (obj)).getTotalCount();
        if (totalCount > j * 100)
        {
            i = j * 100;
        } else
        {
            i = totalCount;
        }
        listCount = i;
        firstPage = ((nse) (obj)).getPage();
        categories = ((nse) (obj)).getCategories();
        aspects = ((nse) (obj)).getAspects();
        savedSearchQuery = ((nse) (obj)).getSavedSearchQuery();
        return listCount;
    }

    protected abstract void trackResponse(nse nse, int i);

    protected nse(EbayContext ebaycontext)
    {
        categories = null;
        aspects = null;
        savedSearchQuery = null;
        itemIds = new ArrayList();
        totalCount = 0;
        listCount = 0;
        firstPage = null;
        context = ebaycontext;
    }
}

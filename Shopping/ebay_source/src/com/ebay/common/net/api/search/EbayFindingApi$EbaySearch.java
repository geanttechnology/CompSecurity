// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.content.Context;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.Iterator;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi, SearchParameters, ISearchEventTracker

private static final class searchTracker extends ase
{

    private final ISearchEventTracker searchTracker;

    private void mergeHistograms(EbayAspectHistogram ebayaspecthistogram, EbayAspectHistogram ebayaspecthistogram1)
    {
        Iterator iterator = ebayaspecthistogram.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.ebay.common.model.search.  = (com.ebay.common.model.search.)iterator.next();
            boolean flag1 = false;
            Iterator iterator1 = ebayaspecthistogram1.iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!iterator1.hasNext())
                {
                    break;
                }
                com.ebay.common.model.search. 1 = (com.ebay.common.model.search.)iterator1.next();
                if (!.name.equals(1.name))
                {
                    continue;
                }
                flag = true;
                break;
            } while (true);
            if (!flag)
            {
                int i;
                if (ebayaspecthistogram.indexOf() < ebayaspecthistogram1.size())
                {
                    i = ebayaspecthistogram.indexOf();
                } else
                {
                    i = 0;
                }
                ebayaspecthistogram1.add(i, );
            }
        } while (true);
    }

    private EbayAspectHistogram suppressSingleValueAspects(EbayAspectHistogram ebayaspecthistogram)
    {
        if (ebayaspecthistogram != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((EbayAspectHistogram) (obj));
_L2:
        Iterator iterator = ebayaspecthistogram.iterator();
        do
        {
            obj = ebayaspecthistogram;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (com.ebay.common.model.search.)iterator.next();
            if (((com.ebay.common.model.search.) (obj)).size() < 2)
            {
                obj.suppressDisplay = true;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public EbayAspectHistogram getAspects()
    {
        EbayAspectHistogram ebayaspecthistogram1;
        if (params.aspectHistogram == null)
        {
            ebayaspecthistogram1 = suppressSingleValueAspects(super.getAspects());
        } else
        {
            EbayAspectHistogram ebayaspecthistogram2 = suppressSingleValueAspects(params.aspectHistogram);
            ebayaspecthistogram1 = ebayaspecthistogram2;
            if (ebayaspecthistogram2.mergeStrategy != com.ebay.common.model.search.ergeStrategy.RETAIN)
            {
                ebayaspecthistogram1 = super.getAspects();
                EbayAspectHistogram ebayaspecthistogram = ebayaspecthistogram1;
                if (params.aspectHistogram.mergeStrategy == com.ebay.common.model.search.ergeStrategy.MERGE_SUPPRESS)
                {
                    ebayaspecthistogram = suppressSingleValueAspects(ebayaspecthistogram1);
                }
                ebayaspecthistogram1 = ebayaspecthistogram2;
                if (ebayaspecthistogram != null)
                {
                    mergeHistograms(ebayaspecthistogram2, ebayaspecthistogram);
                    return ebayaspecthistogram;
                }
            }
        }
        return ebayaspecthistogram1;
    }

    public int getPageSize()
    {
        return params.maxCountPerPage;
    }

    protected equestBase getRequest(int i)
    {
        return new equest(params, i);
    }

    protected void trackResponse(esponse esponse, int i)
    {
        if (searchTracker != null)
        {
            searchTracker.trackFindingResponse((Context)context.getExtension(android/content/Context), i, esponse);
        }
    }

    public esponse(EbayContext ebaycontext, SearchParameters searchparameters, ISearchEventTracker isearcheventtracker)
    {
        super(ebaycontext, searchparameters.maxCountPerPage, searchparameters);
        searchTracker = isearcheventtracker;
    }
}

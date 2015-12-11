// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics.impressions;

import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.metrics.impressions:
//            ProductViewSnapshot, AsinImpression

public class AsinImpressionTracker
{
    private class TaskListener extends com.amazon.retailsearch.data.SearchTask.SearchTaskListener
    {

        private String activeRid;
        final AsinImpressionTracker this$0;

        private void save(List list)
        {
            Product product1;
            for (list = list.iterator(); list.hasNext(); asinToRid.put(product1.getAsin(), activeRid))
            {
                product1 = (Product)list.next();
            }

        }

        public void categoryCorrected(CategoryCorrected categorycorrected)
        {
            save(categorycorrected.getResults().getItems());
        }

        public void fkmr(FKMR fkmr1)
        {
            save(fkmr1.getResults().getItems());
        }

        public void noResultsSet(NoResultsSet noresultsset)
        {
            save(noresultsset.getFallbackResults());
        }

        public void product(Product product1)
        {
            asinToRid.put(product1.getAsin(), activeRid);
        }

        void reset()
        {
            activeRid = null;
        }

        public void spellCorrected(SpellCorrected spellcorrected)
        {
            save(spellcorrected.getResults().getItems());
        }

        public void trackingInfo(TrackingInfo trackinginfo)
        {
            activeRid = trackinginfo.getRid();
        }

        public void wordSplitter(SpellCorrected spellcorrected)
        {
            save(spellcorrected.getResults().getItems());
        }

        private TaskListener()
        {
            this$0 = AsinImpressionTracker.this;
            super();
        }

    }


    private static final Long ALREADY_IMPRESSED = Long.valueOf(-1L);
    private static final float MIN_ASIN_VIEW_PERCENT_VISIBILITY = 0.7F;
    private static final int MIN_ASIN_VISIBILITY_LENGTH_MS = 1000;
    private Map asinToRid;
    private List confirmedAsinImpressions;
    private Map firstVisibleTimes;
    private RetailSearchLogger searchLogger;
    private TaskListener taskListener;

    public AsinImpressionTracker()
    {
        confirmedAsinImpressions = new ArrayList();
        firstVisibleTimes = new HashMap();
        asinToRid = new HashMap();
        taskListener = new TaskListener();
        searchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
    }

    private void reset()
    {
        confirmedAsinImpressions.clear();
        firstVisibleTimes.clear();
        asinToRid.clear();
        taskListener.reset();
    }

    private void send()
    {
        searchLogger.recordAsinImpressions(confirmedAsinImpressions);
    }

    public void evaluateByIncrementalSnapshot(ProductViewSnapshot productviewsnapshot)
    {
        String s = productviewsnapshot.getAsin();
        if (!ALREADY_IMPRESSED.equals(firstVisibleTimes.get(s)))
        {
            if (productviewsnapshot.getPercentVisible() < 0.7F)
            {
                firstVisibleTimes.remove(s);
                return;
            }
            Long long1 = (Long)firstVisibleTimes.get(s);
            if (long1 == null)
            {
                firstVisibleTimes.put(s, Long.valueOf(productviewsnapshot.getTimestamp()));
                return;
            }
            if (productviewsnapshot.getTimestamp() - long1.longValue() >= 1000L)
            {
                productviewsnapshot = (String)asinToRid.get(s);
                if (productviewsnapshot != null && !productviewsnapshot.isEmpty())
                {
                    confirmedAsinImpressions.add(new AsinImpression(productviewsnapshot, s));
                    firstVisibleTimes.put(s, ALREADY_IMPRESSED);
                    return;
                }
            }
        }
    }

    public com.amazon.retailsearch.data.SearchTask.SearchTaskListener getSearchTaskListener()
    {
        return taskListener;
    }

    public void recordImpressions()
    {
        send();
        reset();
    }

    public boolean wasAsinViewed(String s)
    {
        return ALREADY_IMPRESSED.equals(firstVisibleTimes.get(s));
    }


}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics.impressions;

import com.amazon.searchapp.retailsearch.model.CategoryCorrected;
import com.amazon.searchapp.retailsearch.model.FKMR;
import com.amazon.searchapp.retailsearch.model.NoResultsSet;
import com.amazon.searchapp.retailsearch.model.Product;
import com.amazon.searchapp.retailsearch.model.ProductSection;
import com.amazon.searchapp.retailsearch.model.SpellCorrected;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.metrics.impressions:
//            AsinImpressionTracker

private class <init> extends com.amazon.retailsearch.data.r.TaskListener
{

    private String activeRid;
    final AsinImpressionTracker this$0;

    private void save(List list)
    {
        Product product1;
        for (list = list.iterator(); list.hasNext(); AsinImpressionTracker.access$100(AsinImpressionTracker.this).put(product1.getAsin(), activeRid))
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
        AsinImpressionTracker.access$100(AsinImpressionTracker.this).put(product1.getAsin(), activeRid);
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

    private ()
    {
        this$0 = AsinImpressionTracker.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

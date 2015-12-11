// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import com.amazon.retailsearch.data.sims.SimilaritiesLoader;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            Sims, SimsModel

class el
    implements Runnable
{

    final Sims this$0;
    final SimsModel val$model;

    public void run()
    {
        SimilaritiesLoader.getSims(new msViewCallback(Sims.this, val$model.getResourceProvider(), val$model.getListener(), val$model.getMerchantId()), val$model.getAsin(), Sims.access$000(Sims.this), val$model.getMerchantId());
    }

    el()
    {
        this$0 = final_sims;
        val$model = SimsModel.this;
        super();
    }
}

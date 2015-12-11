// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.loader.DealLoaderCallbacks;

// Referenced classes of package com.groupon.activity:
//            AbstractThanks

class  extends DealLoaderCallbacks
{

    final AbstractThanks this$0;

    public void onDealLoaded(Deal deal)
    {
        AbstractThanks.this.deal = deal;
        afterDealLoaded(deal);
        initMegamindWidgets();
    }

    (Context context, String s)
    {
        this$0 = AbstractThanks.this;
        super(context, s);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.groupon.adapter.DealDetailsRecyclerAdapter;
import com.groupon.callbacks.OnMerchantRecommendationsClickEventListener;
import com.groupon.models.dealdetails.DealDetailsViewType;
import com.groupon.models.nst.CSVEncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private class <init>
    implements OnMerchantRecommendationsClickEventListener
{

    final DealDetails this$0;

    public void onClick(View view, String s)
    {
        detailsRecyclerView.scrollToPosition(DealDetails.access$2900(DealDetails.this).getFirstPositionForItem(DealDetailsViewType.TIPS));
        view = new CSVEncodedNSTField(logger, new String[] {
            s
        });
        logger.logClick("", "dd_recommendation_see_all", dealId, view, Logger.NULL_NST_FIELD);
    }

    private ()
    {
        this$0 = DealDetails.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.adapter.DealDetailsRecyclerAdapter;
import com.groupon.callbacks.OnActivityTransitionFinishedListener;
import com.groupon.models.dealdetails.DealDetailsViewType;
import com.groupon.mvc.controller.recycleritem.DetailsHeaderController;
import java.util.Map;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private class <init>
    implements OnActivityTransitionFinishedListener
{

    final DealDetails this$0;

    public void onTransitionFinished()
    {
        if (DealDetails.access$1400(DealDetails.this) != null)
        {
            DealDetails.access$3400(DealDetails.this);
        } else
        {
            DetailsHeaderController detailsheadercontroller = (DetailsHeaderController)DealDetails.access$2700(DealDetails.this).get(DealDetailsViewType.HEADER);
            if (detailsheadercontroller != null)
            {
                detailsheadercontroller.setDisplayLoadingView(true);
                detailsheadercontroller.processData();
                if (detailsheadercontroller.isReady())
                {
                    DealDetails.access$2900(DealDetails.this).updateItem(DealDetailsViewType.HEADER, detailsheadercontroller);
                    return;
                }
            }
        }
    }

    private r()
    {
        this$0 = DealDetails.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

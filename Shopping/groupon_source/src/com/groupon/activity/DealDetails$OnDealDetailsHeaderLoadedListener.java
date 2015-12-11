// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.callbacks.OnRecyclerViewHeaderLoadedListener;
import com.groupon.mvc.controller.BottomBarController;
import com.groupon.mvc.view.viewholder.DetailsHeaderViewHolder;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private class <init>
    implements OnRecyclerViewHeaderLoadedListener
{

    final DealDetails this$0;

    public void onHeaderLoaded(DetailsHeaderViewHolder detailsheaderviewholder)
    {
        DealDetails.access$3702(DealDetails.this, detailsheaderviewholder.dealImageContainer);
        DealDetails.access$3802(DealDetails.this, detailsheaderviewholder.imageGradientOverlay);
        DealDetails.access$3902(DealDetails.this, detailsheaderviewholder.temporaryDealImageView);
        DealDetails.access$4002(DealDetails.this, detailsheaderviewholder.titleValuePriceSection);
        DealDetails.access$3302(DealDetails.this, true);
        if (DealDetails.access$4100(DealDetails.this))
        {
            DealDetails.access$4200(DealDetails.this);
            return;
        } else
        {
            DealDetails.access$4300(DealDetails.this);
            return;
        }
    }

    public void onHeaderReloaded(DetailsHeaderViewHolder detailsheaderviewholder)
    {
        DealDetails.access$3000(DealDetails.this).displayBottomBar();
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.groupon.adapter.DealDetailsRecyclerAdapter;
import com.groupon.models.dealdetails.DealDetailsViewType;
import com.groupon.models.nst.InteractionDealIdMetadata;
import com.groupon.mvc.controller.recycleritem.DetailsHeaderController;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.util.TransparentToolBarRecyclerHelper;
import java.util.Map;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private class <init> extends android.support.v7.widget.>
{

    final DealDetails this$0;

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        super.>(recyclerview, i, j);
        if (DeviceInfoUtil.getScreenOrientation(DealDetails.this) == 1)
        {
            DealDetails.access$3200(DealDetails.this).adjustToolbarTransparency(j);
        }
        LinearLayoutManager linearlayoutmanager = (LinearLayoutManager)recyclerview.getLayoutManager();
        if (linearlayoutmanager.findLastCompletelyVisibleItemPosition() == DealDetails.access$2700(DealDetails.this).size() - 1)
        {
            logger.logUserInteraction("", "end_of_deal_details", getPageViewId(), loggingUtils.encodeAsJson(new InteractionDealIdMetadata(dealId)), Logger.NULL_NST_FIELD);
        }
        recyclerview = (DetailsHeaderController)DealDetails.access$2700(DealDetails.this).get(DealDetailsViewType.HEADER);
        if (recyclerview != null)
        {
            boolean flag1 = DealDetails.access$3300(DealDetails.this);
            boolean flag;
            if (linearlayoutmanager.findFirstCompletelyVisibleItemPosition() == DealDetailsViewType.HEADER.ordinal())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag1 != flag)
            {
                DealDetails dealdetails = DealDetails.this;
                if (!DealDetails.access$3300(DealDetails.this))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                DealDetails.access$3302(dealdetails, flag);
                recyclerview.setHeaderFullyVisible(DealDetails.access$3300(DealDetails.this));
                recyclerview.processDealImageViewData();
                DealDetails.access$2900(DealDetails.this).updateItem(DealDetailsViewType.HEADER, recyclerview);
            }
        }
    }

    private r()
    {
        this$0 = DealDetails.this;
        super();
    }

    ( )
    {
        this();
    }
}

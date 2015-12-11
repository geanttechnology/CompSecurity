// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.callbacks.DefaultQandARequestCallback;
import com.groupon.db.models.Pagination;
import com.groupon.models.qadiscussions.QaDiscussionPaginationWrapper;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            DealDetails

private class <init> extends DefaultQandARequestCallback
{

    final DealDetails this$0;

    public void onDiscussionsSuccess(QaDiscussionPaginationWrapper qadiscussionpaginationwrapper)
    {
        DealDetails.access$4402(DealDetails.this, qadiscussionpaginationwrapper.pagination.getCount());
        DealDetails.access$4600(DealDetails.this, DealDetails.access$4500(DealDetails.this, DealDetails.access$4400(DealDetails.this), false));
    }

    public void onPostsSuccess(List list)
    {
        DealDetails dealdetails = DealDetails.this;
        int i;
        if (list != null)
        {
            i = list.size();
        } else
        {
            i = 0;
        }
        DealDetails.access$4402(dealdetails, i);
        DealDetails.access$4600(DealDetails.this, DealDetails.access$4500(DealDetails.this, DealDetails.access$4400(DealDetails.this), true));
    }

    private nWrapper()
    {
        this$0 = DealDetails.this;
        super();
    }

    t>(t> t>)
    {
        this();
    }
}

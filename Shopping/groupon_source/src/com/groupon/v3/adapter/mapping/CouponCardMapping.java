// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.view.list_view.CouponSummaryWrapper;
import com.groupon.view.dealcards.CouponCard;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class CouponCardMapping extends Mapping
{

    protected boolean isInstoreMerchantCoupon;

    public CouponCardMapping(boolean flag)
    {
        super(com/groupon/v3/view/list_view/CouponSummaryWrapper);
        isInstoreMerchantCoupon = false;
        isInstoreMerchantCoupon = flag;
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (CouponSummaryWrapper)universallistadapter.getItem(i);
        ((CouponCard)(CouponCard)viewholder.itemView.findViewById(0x7f1001b4)).setCoupon(universallistadapter.getCouponSummary(), isInstoreMerchantCoupon);
        viewholder.itemView.setTag(0x7f100001, universallistadapter);
        viewholder = (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback);
        if (viewholder != null)
        {
            viewholder.onViewBound(i, universallistadapter);
        }
    }

    public View createView(Context context)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        return LayoutInflater.from(context).inflate(0x7f03006b, null);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }
}

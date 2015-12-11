// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.view.list_view.CouponTopItemType;
import com.groupon.view.widgetcards.CouponTopItemLayout;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class CouponTopItemCardMapping extends Mapping
{

    public CouponTopItemCardMapping()
    {
        super(com/groupon/v3/view/list_view/CouponTopItemType);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (CouponTopItemType)universallistadapter.getItem(i);
        ((CouponTopItemLayout)(CouponTopItemLayout)viewholder.itemView).setTopItemContainer(universallistadapter);
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
        return LayoutInflater.from(context).inflate(0x7f03007e, null);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.v3.view.list_view.SnapGroceryDetailsWrapper;
import com.groupon.view.widgetcards.GroceryItemLayout;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class SnapGroceryMapping extends Mapping
{

    protected Context context;

    public SnapGroceryMapping()
    {
        super(com/groupon/v3/view/list_view/SnapGroceryDetailsWrapper);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (SnapGroceryDetailsWrapper)universallistadapter.getItem(i);
        ((GroceryItemLayout)viewholder.itemView.findViewById(0x7f100346)).setGroceryDetailsList(universallistadapter, (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback));
        viewholder = (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback);
        if (viewholder != null)
        {
            viewholder.onViewBound(i, universallistadapter);
        }
    }

    public View createView(Context context1)
    {
        return LayoutInflater.from(context1).inflate(0x7f030122, null);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context1, UniversalListAdapter universallistadapter)
    {
        context = context1;
        return getHolderWithCallback(context1, universallistadapter);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.groupon.db.models.BusinessSummary;
import com.groupon.util.LocationsUtil;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.callback.IViewCallback;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class PoGBussinessAutocompleteMapping extends Mapping
{

    public PoGBussinessAutocompleteMapping()
    {
        super(com/groupon/db/models/BusinessSummary);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (BusinessSummary)universallistadapter.getItem(i);
        TextView textview = (TextView)viewholder.itemView.findViewById(0x7f10015a);
        TextView textview1 = (TextView)viewholder.itemView.findViewById(0x7f100159);
        textview.setText(((BusinessSummary) (universallistadapter)).name);
        textview1.setText(LocationsUtil.getLocationForBusinessSummary(universallistadapter));
        viewholder.itemView.setTag(0x7f100001, universallistadapter);
        viewholder = (IViewCallback)getCallback(com/groupon/v3/adapter/callback/IViewCallback);
        if (viewholder != null)
        {
            viewholder.onViewBound(i, universallistadapter);
        }
    }

    public View createView(Context context)
    {
        return LayoutInflater.from(context).inflate(0x7f030190, null);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }
}

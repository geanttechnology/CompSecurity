// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.adapter.widget.WidgetPart;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.view.widgetcards.DealDetailsWidgetHeaderCard;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class DealDetailsWidgetHeaderCardMapping extends Mapping
{

    public DealDetailsWidgetHeaderCardMapping()
    {
        super(com/groupon/adapter/widget/WidgetPart);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (WidgetPart)universallistadapter.getItem(i);
        ((DealDetailsWidgetHeaderCard)viewholder.itemView).setInfo(universallistadapter.getWidgetSummary());
    }

    public View createView(Context context)
    {
        return new DealDetailsWidgetHeaderCard(context);
    }

    public boolean getSpanAllColumns()
    {
        return true;
    }
}

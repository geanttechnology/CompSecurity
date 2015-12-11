// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.widget.WidgetPartV3;
import com.groupon.view.DealSetCallbacks;
import com.groupon.view.widgetcards.RotatingImageWidgetCard;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class RotatingImageWidgetCardMapping extends Mapping
{

    public RotatingImageWidgetCardMapping()
    {
        super(com/groupon/v3/adapter/widget/WidgetPartV3);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (WidgetPartV3)universallistadapter.getItem(i);
        ((RotatingImageWidgetCard)viewholder.itemView).setInfo(universallistadapter.getWidgetSummary(), (DealSetCallbacks)getCallback(com/groupon/view/DealSetCallbacks));
    }

    public View createView(Context context)
    {
        return new RotatingImageWidgetCard(context);
    }
}

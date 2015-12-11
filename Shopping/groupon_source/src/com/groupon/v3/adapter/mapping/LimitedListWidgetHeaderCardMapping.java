// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.widget.WidgetPartV3;
import com.groupon.view.DealSetCallbacks;
import com.groupon.view.widgetcards.LimitedListWidgetHeaderCard;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class LimitedListWidgetHeaderCardMapping extends Mapping
{

    public LimitedListWidgetHeaderCardMapping()
    {
        super(com/groupon/v3/adapter/widget/WidgetPartV3);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        WidgetPartV3 widgetpartv3 = (WidgetPartV3)universallistadapter.getItem(i);
        boolean flag = ((Boolean)universallistadapter.getExtrasByKey("hideWidgetSubsetNavigation")).booleanValue();
        ((LimitedListWidgetHeaderCard)viewholder.itemView).setInfo(widgetpartv3.getWidgetSummary(), (DealSetCallbacks)getCallback(com/groupon/view/DealSetCallbacks), flag);
    }

    public View createView(Context context)
    {
        return new LimitedListWidgetHeaderCard(context);
    }

    public boolean getSpanAllColumns()
    {
        return true;
    }
}

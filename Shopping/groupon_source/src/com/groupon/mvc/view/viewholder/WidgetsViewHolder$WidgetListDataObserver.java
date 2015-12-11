// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.database.DataSetObserver;
import android.view.View;
import android.widget.TextView;
import com.groupon.adapter.WidgetOnDealDetailsPagerAdapter;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            WidgetsViewHolder

private class titleView extends DataSetObserver
{

    private View mainContainer;
    private String slotId;
    final WidgetsViewHolder this$0;
    private TextView titleView;
    private FilterableWidgetListAdapter widgetListAdapter;

    public void onChanged()
    {
        Ln.d((new StringBuilder()).append("Widget refreshed").append(slotId).toString(), new Object[0]);
        WidgetsViewHolder.access$100(WidgetsViewHolder.this).clear();
        if (widgetListAdapter.getCount() > 0 && Strings.equals(widgetListAdapter.getLayoutType(0, slotId), "small_deal_list_cards_layout"))
        {
            toggleContainerVisibility(mainContainer, true);
            titleView.setText(widgetListAdapter.getDisplayName(0, slotId));
        } else
        {
            toggleContainerVisibility(mainContainer, false);
        }
        super.onChanged();
        WidgetsViewHolder.access$200(WidgetsViewHolder.this).notifyDataSetChanged();
    }

    public (String s, FilterableWidgetListAdapter filterablewidgetlistadapter, View view, TextView textview)
    {
        this$0 = WidgetsViewHolder.this;
        super();
        slotId = s;
        widgetListAdapter = filterablewidgetlistadapter;
        mainContainer = view;
        titleView = textview;
    }
}

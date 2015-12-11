// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import com.groupon.adapter.WidgetOnDealDetailsPagerAdapter;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.adapter.widget.WidgetPart;
import com.groupon.db.models.DealSummary;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public abstract class WidgetsViewHolder extends RecyclerItemViewHolder
{
    private class WidgetChangeListener extends android.support.v4.view.ViewPager.SimpleOnPageChangeListener
    {

        final WidgetsViewHolder this$0;

        public void onPageSelected(int i)
        {
            Object obj = (WidgetPart)widgetPagerAdapter.getItem(i);
            int l = i - 1;
            DealSummary dealsummary = ((WidgetPart) (obj)).getDealSummary();
            int j = i;
            obj = dealsummary;
            int k = j;
            if (l == 0)
            {
                obj = dealsummary;
                k = j;
                if (!widgetImpressionTracker.contains(Integer.valueOf(l)))
                {
                    obj = ((WidgetPart)widgetPagerAdapter.getItem(l)).getDealSummary();
                    k = l;
                    widgetImpressionTracker.add(Integer.valueOf(l));
                }
            }
            if (!widgetImpressionTracker.contains(Integer.valueOf(i)))
            {
                widgetImpressionTracker.add(Integer.valueOf(i));
            }
            onWidgetPageSelected(((DealSummary) (obj)), k);
        }

        private WidgetChangeListener()
        {
            this$0 = WidgetsViewHolder.this;
            super();
        }

    }

    private class WidgetListDataObserver extends DataSetObserver
    {

        private View mainContainer;
        private String slotId;
        final WidgetsViewHolder this$0;
        private TextView titleView;
        private FilterableWidgetListAdapter widgetListAdapter;

        public void onChanged()
        {
            Ln.d((new StringBuilder()).append("Widget refreshed").append(slotId).toString(), new Object[0]);
            widgetImpressionTracker.clear();
            if (widgetListAdapter.getCount() > 0 && Strings.equals(widgetListAdapter.getLayoutType(0, slotId), "small_deal_list_cards_layout"))
            {
                toggleContainerVisibility(mainContainer, true);
                titleView.setText(widgetListAdapter.getDisplayName(0, slotId));
            } else
            {
                toggleContainerVisibility(mainContainer, false);
            }
            super.onChanged();
            widgetPagerAdapter.notifyDataSetChanged();
        }

        public WidgetListDataObserver(String s, FilterableWidgetListAdapter filterablewidgetlistadapter, View view, TextView textview)
        {
            this$0 = WidgetsViewHolder.this;
            super();
            slotId = s;
            widgetListAdapter = filterablewidgetlistadapter;
            mainContainer = view;
            titleView = textview;
        }
    }


    private List widgetImpressionTracker;
    private WidgetOnDealDetailsPagerAdapter widgetPagerAdapter;

    public WidgetsViewHolder(View view)
    {
        super(view);
    }

    protected void addSliderWidget(FilterableWidgetListAdapter filterablewidgetlistadapter, View view, TextView textview, ViewPager viewpager, String s)
    {
        widgetImpressionTracker = new ArrayList();
        widgetPagerAdapter = new WidgetOnDealDetailsPagerAdapter(filterablewidgetlistadapter, itemView.getContext().getApplicationContext());
        viewpager.setAdapter(widgetPagerAdapter);
        filterablewidgetlistadapter.registerDataSetObserver(new WidgetListDataObserver(s, filterablewidgetlistadapter, view, textview));
        viewpager.setOnPageChangeListener(new WidgetChangeListener());
        onWidgetsInitialized();
    }

    protected abstract void onWidgetPageSelected(DealSummary dealsummary, int i);

    protected abstract void onWidgetsInitialized();

    public void populateViews()
    {
    }

    protected void toggleContainerVisibility(View view, boolean flag)
    {
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        int i;
        if (flag)
        {
            i = -2;
        } else
        {
            i = 0;
        }
        layoutparams.height = i;
        view.setLayoutParams(layoutparams);
    }


}

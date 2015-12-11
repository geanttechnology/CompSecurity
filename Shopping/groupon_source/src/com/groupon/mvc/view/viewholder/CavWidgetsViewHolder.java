// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.callbacks.OnDealDetailsWidgetsEventListener;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;
import com.groupon.mvc.model.CabCavWidget;
import com.groupon.view.DealSetCallbacks;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            WidgetsViewHolder

public class CavWidgetsViewHolder extends WidgetsViewHolder
{
    private class OnWidgetEventListener
        implements DealSetCallbacks
    {

        final CavWidgetsViewHolder this$0;

        public void onMemberClick(View view, DealSummary dealsummary)
        {
            if (callback != null)
            {
                ((OnDealDetailsWidgetsEventListener)callback).onCavWidgetClick(view, dealsummary);
            }
        }

        public void onSubsetClick(WidgetSummary widgetsummary)
        {
        }

        private OnWidgetEventListener()
        {
            this$0 = CavWidgetsViewHolder.this;
            super();
        }

    }


    TextView cavTitleView;
    View cavWidgetContainer;
    private FilterableWidgetListAdapter cavWidgetListAdapter;
    ViewPager cavWidgetViewPager;

    public CavWidgetsViewHolder(View view)
    {
        super(view);
    }

    protected void onWidgetPageSelected(DealSummary dealsummary, int i)
    {
        if (callback != null)
        {
            ((OnDealDetailsWidgetsEventListener)callback).onCavWidgetPageSelected(dealsummary, i);
        }
    }

    protected void onWidgetsInitialized()
    {
        if (callback != null)
        {
            ((OnDealDetailsWidgetsEventListener)callback).onCavWidgetsInitialized(cavWidgetListAdapter);
        }
    }

    public void populateViews()
    {
        toggleContainerVisibility(cavWidgetContainer, false);
        if (((CabCavWidget)model).displayWidget && cavWidgetListAdapter == null)
        {
            cavWidgetListAdapter = new FilterableWidgetListAdapter(itemView.getContext(), new OnWidgetEventListener(), null, ((CabCavWidget)model).currentLocation, null, "INVALID_KEYSTRING", ((CabCavWidget)model).channel, new String[] {
                "middleSlot"
            });
            addSliderWidget(cavWidgetListAdapter, cavWidgetContainer, cavTitleView, cavWidgetViewPager, "middleSlot");
        }
    }
}

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

public class CabWidgetsViewHolder extends WidgetsViewHolder
{
    private class OnWidgetEventListener
        implements DealSetCallbacks
    {

        final CabWidgetsViewHolder this$0;

        public void onMemberClick(View view, DealSummary dealsummary)
        {
            if (callback != null)
            {
                ((OnDealDetailsWidgetsEventListener)callback).onCabWidgetClick(view, dealsummary);
            }
        }

        public void onSubsetClick(WidgetSummary widgetsummary)
        {
        }

        private OnWidgetEventListener()
        {
            this$0 = CabWidgetsViewHolder.this;
            super();
        }

    }


    TextView cabTitleView;
    View cabWidgetContainer;
    private FilterableWidgetListAdapter cabWidgetListAdapter;
    ViewPager cabWidgetViewPager;

    public CabWidgetsViewHolder(View view)
    {
        super(view);
    }

    protected void onWidgetPageSelected(DealSummary dealsummary, int i)
    {
        if (callback != null)
        {
            ((OnDealDetailsWidgetsEventListener)callback).onCabWidgetPageSelected(dealsummary, i);
        }
    }

    protected void onWidgetsInitialized()
    {
        if (callback != null)
        {
            ((OnDealDetailsWidgetsEventListener)callback).onCabWidgetsInitialized(cabWidgetListAdapter);
        }
    }

    public void populateViews()
    {
        toggleContainerVisibility(cabWidgetContainer, false);
        if (((CabCavWidget)model).displayWidget && cabWidgetListAdapter == null)
        {
            cabWidgetListAdapter = new FilterableWidgetListAdapter(itemView.getContext(), new OnWidgetEventListener(), null, ((CabCavWidget)model).currentLocation, null, "INVALID_KEYSTRING", ((CabCavWidget)model).channel, new String[] {
                "topSlot"
            });
            addSliderWidget(cabWidgetListAdapter, cabWidgetContainer, cabTitleView, cabWidgetViewPager, "topSlot");
        }
    }
}

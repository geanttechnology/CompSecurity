// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMTabButton

public class PMTabBar extends LinearLayout
{
    public static interface PMTabListener
    {

        public abstract void onTabSelected(PMTabButton pmtabbutton);

        public abstract void onTabUnselected(PMTabButton pmtabbutton);
    }


    private PMTabButton currentActiveTab;
    android.view.View.OnClickListener listener;

    public PMTabBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        listener = new android.view.View.OnClickListener() {

            final PMTabBar this$0;

            public void onClick(View view)
            {
                view = (PMTabButton)view;
                String s = view.getClickEventString();
                if (s != null)
                {
                    Analytics.getInstance().trackEvent(null, "app", s, null);
                }
                setActiveTab(view);
            }

            
            {
                this$0 = PMTabBar.this;
                super();
            }
        };
    }

    private void activateTabContent(PMTabButton pmtabbutton)
    {
    }

    public void addTab(PMTabButton pmtabbutton, PMTabListener pmtablistener)
    {
        addView(pmtabbutton);
        pmtabbutton.setOnClickListener(listener);
        pmtabbutton.setTabListener(pmtablistener);
    }

    public PMTabButton getActiveTab()
    {
        return currentActiveTab;
    }

    public void handleDoubleTap(PMTabButton pmtabbutton)
    {
    }

    public void handleSingleTap(PMTabButton pmtabbutton)
    {
        setActiveTab(pmtabbutton);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        j = getChildCount();
        for (i = 0; i < j; i++)
        {
            PMTabButton pmtabbutton = (PMTabButton)getChildAt(i);
            pmtabbutton.setOnClickListener(listener);
            pmtabbutton.setParentTabBar(this);
        }

    }

    public void setActiveTab(PMTabButton pmtabbutton)
    {
        if (currentActiveTab != pmtabbutton)
        {
            if (currentActiveTab != null)
            {
                currentActiveTab.getTabListener().onTabUnselected(currentActiveTab);
            }
            pmtabbutton.getTabListener().onTabSelected(pmtabbutton);
            currentActiveTab = pmtabbutton;
        }
    }

    void setTabListener()
    {
    }
}

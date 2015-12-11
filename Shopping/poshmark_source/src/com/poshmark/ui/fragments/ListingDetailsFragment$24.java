// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment, ListingDetailsDrawerFragment

class this._cls0
    implements android.support.v4.widget.r
{

    final ListingDetailsFragment this$0;

    public void onDrawerClosed(View view)
    {
    }

    public void onDrawerOpened(View view)
    {
        if (drawerFragment != null)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listing_actions_button_tapped", null);
            drawerFragment.updateDrawer(false);
        }
    }

    public void onDrawerSlide(View view, float f)
    {
    }

    public void onDrawerStateChanged(int i)
    {
    }

    nt()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}

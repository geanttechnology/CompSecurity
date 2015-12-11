// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.ui.fragments:
//            MetaItemListViewFragment

class this._cls0
    implements android.view.ewFragment._cls3
{

    final MetaItemListViewFragment this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag && showBrandFollowButton)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "brand_searched", null);
        }
    }

    ()
    {
        this$0 = MetaItemListViewFragment.this;
        super();
    }
}

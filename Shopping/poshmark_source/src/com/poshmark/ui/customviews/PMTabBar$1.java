// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.view.View;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMTabBar, PMTabButton

class this._cls0
    implements android.view.kListener
{

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

    ()
    {
        this$0 = PMTabBar.this;
        super();
    }
}

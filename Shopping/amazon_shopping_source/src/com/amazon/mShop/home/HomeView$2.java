// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.home:
//            HomeView

class this._cls0
    implements android.view.kListener
{

    final HomeView this$0;

    public void onClick(View view)
    {
        ActivityUtils.startCategoryBrowseActivity(getContext());
        if (getResources().getConfiguration().orientation == 2)
        {
            RefMarkerObserver.logRefMarker("hm_br_land");
            return;
        } else
        {
            RefMarkerObserver.logRefMarker("hm_br_port");
            return;
        }
    }

    erver()
    {
        this$0 = HomeView.this;
        super();
    }
}

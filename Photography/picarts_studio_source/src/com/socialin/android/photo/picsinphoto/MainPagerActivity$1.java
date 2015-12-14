// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import com.melnykov.fab.FloatingActionButton;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity, e

final class r extends android.support.v4.view.geChangeListener
{

    private MainPagerActivity a;

    public final void onPageSelected(int i)
    {
        MainPagerActivity.a(a, i);
        if (MainPagerActivity.a(a) == 13)
        {
            MainPagerActivity.b(a).setVisibility(0);
            MainPagerActivity.b(a).a(true, true, false);
        } else
        {
            MainPagerActivity.b(a).setVisibility(8);
        }
        switch (e.a[i])
        {
        default:
            return;

        case 2131232187: 
            MainPagerActivity.a(a, "my_network");
            MainPagerActivity.b(a, e.b[0]);
            if (MainPagerActivity.c(a))
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.kOpenEvent("other"));
                MainPagerActivity.a(a, false);
                return;
            }
            if (MainPagerActivity.d(a))
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.kOpenEvent("landing_page"));
                MainPagerActivity.e(a);
                return;
            } else
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.kOpenEvent("tab_click"));
                return;
            }

        case 2131231428: 
            MainPagerActivity.a(a, "explore");
            MainPagerActivity.b(a, e.b[1]);
            if (MainPagerActivity.c(a))
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.eOpenEvent("other"));
                MainPagerActivity.a(a, false);
                return;
            }
            if (MainPagerActivity.d(a))
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.eOpenEvent("landing_page"));
                MainPagerActivity.e(a);
                return;
            } else
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.eOpenEvent("tab_click"));
                return;
            }

        case 2131232179: 
            MainPagerActivity.a(a, "contest");
            MainPagerActivity.b(a, e.b[3]);
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tsOpenEvent("tab_click"));
            return;

        case 2131231373: 
            MainPagerActivity.a(a, "artist");
            MainPagerActivity.b(a, e.b[2]);
            break;
        }
        if (MainPagerActivity.c(a))
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.sOpenEvent("other"));
            MainPagerActivity.a(a, false);
            return;
        } else
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.sOpenEvent("tab_click"));
            return;
        }
    }

    Event(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class a extends ActionBarDrawerToggle
{

    private MainPagerActivity a;

    public final void onDrawerClosed(View view)
    {
        super.onDrawerClosed(view);
        a.invalidateOptionsMenu();
        if (MainPagerActivity.g(a) != null)
        {
            MainPagerActivity.g(a).run();
            MainPagerActivity.h(a);
        }
    }

    public final void onDrawerOpened(View view)
    {
        super.onDrawerOpened(view);
        MainPagerActivity.b(a, view.getId());
        AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.OpenEvent(MainPagerActivity.i(a)));
    }

    public final void onDrawerStateChanged(int i)
    {
        MainPagerActivity.j(a).closeDrawer(0x800005);
    }

    vent(MainPagerActivity mainpageractivity, Activity activity, DrawerLayout drawerlayout, Toolbar toolbar)
    {
        a = mainpageractivity;
        super(activity, drawerlayout, toolbar, 0x7f080319, 0x7f0802a4);
    }
}

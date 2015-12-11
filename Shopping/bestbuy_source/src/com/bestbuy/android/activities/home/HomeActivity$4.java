// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.ActionBar;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity

class a
    implements android.view.ngeListener
{

    final HomeActivity a;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            if (HomeActivity.inStoresFragment)
            {
                if (HomeActivity.access$300(a) != null)
                {
                    HomeActivity.access$300(a).setVisible(false);
                }
                if (HomeActivity.access$400(a) != null)
                {
                    HomeActivity.access$400(a).setVisible(false);
                }
            }
        } else
        {
            HomeActivity.access$500(a).collapseActionView();
            if (HomeActivity.inLifeEventsFragment)
            {
                HomeActivity.access$500(a).setVisible(false);
            }
            a.getActionBar().setDisplayShowHomeEnabled(true);
            if (HomeActivity.inStoresFragment)
            {
                if (HomeActivity.access$300(a) != null)
                {
                    HomeActivity.access$300(a).setVisible(true);
                }
                if (HomeActivity.access$400(a) != null)
                {
                    HomeActivity.access$400(a).setVisible(true);
                    return;
                }
            }
        }
    }

    (HomeActivity homeactivity)
    {
        a = homeactivity;
        super();
    }
}

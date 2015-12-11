// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import java.util.HashMap;
import kc;
import lu;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity

class a extends kc
{

    final HomeActivity a;

    public void onDrawerClosed(View view)
    {
        HomeActivity.access$002(a, false);
        HomeActivity.access$100(a);
    }

    public void onDrawerOpened(View view)
    {
        view = new HashMap();
        view.put(lu.bo, "browse,more");
        view.put(lu.bp, "NAV");
        lu.b(lu.g, view);
        HomeActivity.access$002(a, true);
        HomeActivity.access$100(a);
    }

    (HomeActivity homeactivity, Activity activity, DrawerLayout drawerlayout, int i, int j, int k)
    {
        a = homeactivity;
        super(activity, drawerlayout, i, j, k);
    }
}

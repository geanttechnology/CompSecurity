// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.view.View;
import com.groupon.service.LoginService;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.util:
//            GrouponNavigationDrawerActivity

class this._cls0
    implements android.support.v4.widget._cls9
{

    final GrouponNavigationDrawerActivity this$0;

    public void onDrawerClosed(View view)
    {
        invalidateOptionsMenu();
    }

    public void onDrawerOpened(View view)
    {
        invalidateOptionsMenu();
        if (GrouponNavigationDrawerActivity.access$100(GrouponNavigationDrawerActivity.this))
        {
            GrouponNavigationDrawerActivity.access$200(GrouponNavigationDrawerActivity.this).logUserInteraction("", "swipe_open", "navigation_drawer", "", Logger.NULL_NST_FIELD);
        }
        GrouponNavigationDrawerActivity.access$200(GrouponNavigationDrawerActivity.this).logPageView("", "navigation_drawer", Logger.NULL_NST_FIELD);
        if (GrouponNavigationDrawerActivity.access$300(GrouponNavigationDrawerActivity.this).isLoggedIn() && isViewVisible(loginPromptView) || !GrouponNavigationDrawerActivity.access$300(GrouponNavigationDrawerActivity.this).isLoggedIn() && isViewVisible(profileContentView))
        {
            populateNavDrawer();
            setupProfileViewOnNavDrawer();
        }
    }

    public void onDrawerSlide(View view, float f)
    {
        onNavDrawerSlide(f);
    }

    public void onDrawerStateChanged(int i)
    {
        invalidateOptionsMenu();
        if (i == 0)
        {
            GrouponNavigationDrawerActivity.access$102(GrouponNavigationDrawerActivity.this, false);
        } else
        if (i == 1)
        {
            GrouponNavigationDrawerActivity.access$102(GrouponNavigationDrawerActivity.this, true);
            return;
        }
    }

    er()
    {
        this$0 = GrouponNavigationDrawerActivity.this;
        super();
    }
}

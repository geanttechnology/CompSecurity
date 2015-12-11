// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.view.MenuItem;
import com.groupon.activity.IntentFactory;
import com.groupon.service.LoginService;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.util:
//            GrouponNavigationDrawerActivity

class this._cls0
    implements android.support.v7.widget.
{

    final GrouponNavigationDrawerActivity this$0;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 0 0: default 24
    //                   0 26;
           goto _L1 _L2
_L1:
        return false;
_L2:
        GrouponNavigationDrawerActivity.access$200(GrouponNavigationDrawerActivity.this).logClick("", "signout_button_click", "navigation_drawer", Logger.NULL_NST_FIELD);
        GrouponNavigationDrawerActivity.access$300(GrouponNavigationDrawerActivity.this).logout();
        startActivity(((IntentFactory)intentFactory.get()).newSplashIntent(((IntentFactory)intentFactory.get()).newCarouselIntent()));
        finish();
        if (true) goto _L1; else goto _L3
_L3:
    }

    istener()
    {
        this$0 = GrouponNavigationDrawerActivity.this;
        super();
    }
}

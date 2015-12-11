// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.view.View;
import com.groupon.activity.IntentFactory;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.util:
//            GrouponNavigationDrawerActivity

class this._cls0
    implements android.view.y._cls7
{

    final GrouponNavigationDrawerActivity this$0;

    public void onClick(View view)
    {
        view = ((IntentFactory)intentFactory.get()).newLoginIntent(GrouponNavigationDrawerActivity.this);
        if (view != null)
        {
            startActivity(view);
            return;
        } else
        {
            setupProfileViewOnNavDrawer();
            populateNavDrawer();
            return;
        }
    }

    ()
    {
        this$0 = GrouponNavigationDrawerActivity.this;
        super();
    }
}

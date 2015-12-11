// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.navigation;

import android.view.View;
import com.google.a.a.e;
import com.target.ui.analytics.a.ai;
import com.target.ui.fragment.list.ListDetailFragment;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.service.m;

// Referenced classes of package com.target.ui.fragment.navigation:
//            NavigationDrawerFragment

class this._cls0
    implements android.view.tionDrawerFragment._cls7
{

    final NavigationDrawerFragment this$0;

    public void onClick(View view)
    {
        view = ListDetailFragment.a((ListCollectionItem)m.a().b().d());
        NavigationDrawerFragment.a(NavigationDrawerFragment.this, view);
        ai.a(com.target.ui.analytics.a.gment).e();
    }

    ()
    {
        this$0 = NavigationDrawerFragment.this;
        super();
    }
}

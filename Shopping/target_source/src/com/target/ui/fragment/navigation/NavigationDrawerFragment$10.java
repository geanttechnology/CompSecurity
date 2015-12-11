// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.navigation;

import android.view.View;
import com.target.ui.fragment.common.TargetWebFragment;

// Referenced classes of package com.target.ui.fragment.navigation:
//            NavigationDrawerFragment

class this._cls0
    implements android.view.ionDrawerFragment._cls10
{

    final NavigationDrawerFragment this$0;

    public void onClick(View view)
    {
        view = TargetWebFragment.a(false, "file:///android_asset/htmls/partners.html", getString(0x7f0903f8));
        NavigationDrawerFragment.a(NavigationDrawerFragment.this, view, TargetWebFragment.TAG);
    }

    ()
    {
        this$0 = NavigationDrawerFragment.this;
        super();
    }
}

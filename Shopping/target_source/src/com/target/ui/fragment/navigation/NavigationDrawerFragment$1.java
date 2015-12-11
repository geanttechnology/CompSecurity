// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.navigation;

import android.view.View;
import android.view.WindowInsets;
import com.target.ui.view.navigation.NavigationHeaderView;

// Referenced classes of package com.target.ui.fragment.navigation:
//            NavigationDrawerFragment

class val.rootView
    implements android.view.tener
{

    final NavigationDrawerFragment this$0;
    final View val$rootView;

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowinsets)
    {
        if (NavigationDrawerFragment.a(NavigationDrawerFragment.this) != null)
        {
            NavigationDrawerFragment.a(NavigationDrawerFragment.this).navigationHeaderView.a(windowinsets.getSystemWindowInsetTop());
            val$rootView.setOnApplyWindowInsetsListener(null);
            val$rootView.requestLayout();
        }
        return val$rootView.onApplyWindowInsets(windowinsets);
    }

    ews()
    {
        this$0 = final_navigationdrawerfragment;
        val$rootView = View.this;
        super();
    }
}

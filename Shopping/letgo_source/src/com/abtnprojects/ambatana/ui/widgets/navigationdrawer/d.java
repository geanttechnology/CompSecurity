// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets.navigationdrawer;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.a;
import android.support.v7.widget.Toolbar;
import android.view.View;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets.navigationdrawer:
//            NavigationDrawerFragment

class d extends a
{

    private final NavigationDrawerFragment a;

    public d(Activity activity, DrawerLayout drawerlayout, Toolbar toolbar, int i, int j, NavigationDrawerFragment navigationdrawerfragment)
    {
        super(activity, drawerlayout, toolbar, i, j);
        a = navigationdrawerfragment;
    }

    private void a(NavigationDrawerFragment navigationdrawerfragment)
    {
        if (!navigationdrawerfragment.isAdded())
        {
            return;
        } else
        {
            navigationdrawerfragment.getActivity().invalidateOptionsMenu();
            return;
        }
    }

    public void a(View view)
    {
        super.a(view);
        a(a);
    }

    public void b(View view)
    {
        super.b(view);
        a(a);
    }
}

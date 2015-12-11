// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets.navigationdrawer;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.aqo;
import android.support.v7.widget.Toolbar;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets.navigationdrawer:
//            e, d, NavigationDrawerFragment

public class c
{

    public static d a(Activity activity, DrawerLayout drawerlayout, Toolbar toolbar, int i, int j, NavigationDrawerFragment navigationdrawerfragment)
    {
        if (activity instanceof e.a)
        {
            aqo.a("Is instace of LetgoDrawerToggle.OnDrawerWillOpenListener", new Object[0]);
            return new e(activity, drawerlayout, toolbar, i, j, (e.a)activity, navigationdrawerfragment);
        } else
        {
            return new d(activity, drawerlayout, toolbar, i, j, navigationdrawerfragment);
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import com.smule.android.network.managers.UserManager;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ab

class oggle extends ActionBarDrawerToggle
{

    final ab a;

    public void onDrawerClosed(View view)
    {
        super.onDrawerClosed(view);
        ab.a(a).invalidateOptionsMenu();
    }

    public void onDrawerOpened(View view)
    {
        if (ab.b(a).booleanValue() && UserManager.n().h())
        {
            a.b();
        }
        super.onDrawerOpened(view);
        ab.a(a).invalidateOptionsMenu();
    }

    Manager(ab ab1, Activity activity, DrawerLayout drawerlayout, int i, int j, int k)
    {
        a = ab1;
        super(activity, drawerlayout, i, j, k);
    }
}

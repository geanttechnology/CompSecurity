// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            FindFriendsActivity

final class d extends ActionBarDrawerToggle
{

    private FindFriendsActivity a;

    public d(FindFriendsActivity findfriendsactivity, Activity activity, DrawerLayout drawerlayout, int i, int j)
    {
        a = findfriendsactivity;
        super(activity, drawerlayout, FindFriendsActivity.a(findfriendsactivity), i, j);
    }

    public final void onDrawerClosed(View view)
    {
        super.onDrawerClosed(view);
        if (FindFriendsActivity.b(a) != null)
        {
            FindFriendsActivity.b(a).run();
            FindFriendsActivity.c(a);
        }
        if (a.getSupportActionBar() != null)
        {
            a.getSupportActionBar().setTitle(a.getString(0x7f0802cb));
        }
    }

    public final void onDrawerOpened(View view)
    {
        super.onDrawerOpened(view);
        if (a.getSupportActionBar() != null)
        {
            a.getSupportActionBar().setTitle(a.getString(0x7f080324));
        }
    }
}

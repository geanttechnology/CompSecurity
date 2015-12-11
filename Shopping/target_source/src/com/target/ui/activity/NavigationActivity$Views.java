// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.activity;

import android.support.v4.app.h;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.f;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.target.ui.fragment.navigation.NavigationDrawerFragment;
import com.target.ui.view.ToolbarSpinner;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.activity:
//            NavigationActivity

static class erFragment extends a
{

    TextView customTitle;
    NavigationDrawerFragment drawerFragment;
    DrawerLayout drawerLayout;
    View dropShadow;
    View fragmentContainer;
    View progress;
    Toolbar toolbar;
    ToolbarSpinner toolbarSpinner;

    erFragment(f f1)
    {
        super(f1.findViewById(0x7f1000ae));
        drawerFragment = (NavigationDrawerFragment)f1.f().a(0x7f1000b5);
    }
}

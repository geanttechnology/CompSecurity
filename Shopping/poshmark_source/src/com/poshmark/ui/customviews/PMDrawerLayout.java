// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.PMFragment;

public class PMDrawerLayout extends DrawerLayout
{

    Context context;
    PMFragment drawerContentsFragment;
    PMActivity parentActivity;

    public PMDrawerLayout(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public void enableDrawer(boolean flag)
    {
        if (flag)
        {
            setDrawerLockMode(0);
            return;
        } else
        {
            setDrawerLockMode(1);
            return;
        }
    }

    public PMFragment getCurrentFragment()
    {
        return drawerContentsFragment;
    }

    public void setCurrentFragment(PMFragment pmfragment)
    {
        drawerContentsFragment = pmfragment;
    }
}

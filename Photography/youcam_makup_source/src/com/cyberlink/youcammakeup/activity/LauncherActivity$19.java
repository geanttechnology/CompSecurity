// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.ViewPropertyAnimator;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableRelativeLayout;
import com.cyberlink.beautycircle.view.widgetpool.common.m;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements m
{

    final LauncherActivity a;

    public void a(ObservableRelativeLayout observablerelativelayout, boolean flag)
    {
        float f;
        if (flag)
        {
            f = 1.1F;
        } else
        {
            f = 1.0F;
        }
        observablerelativelayout.animate().scaleX(f).scaleY(f).setDuration(100L).start();
    }

    ableRelativeLayout(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}

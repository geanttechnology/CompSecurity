// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.cyberlink.beautycircle.view.widgetpool.common.ObservableRelativeLayout;
import com.cyberlink.youcammakeup.utility.h;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements android.view.lobalLayoutListener
{

    final LauncherActivity a;

    public void onGlobalLayout()
    {
        if (android.os.T >= 16)
        {
            LauncherActivity.a(a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else
        {
            LauncherActivity.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        h.a(LauncherActivity.a(a).getWidth(), LauncherActivity.a(a).getHeight());
        h.a((ViewGroup)a.findViewById(0x7f0c0144));
    }

    ableRelativeLayout(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
    }
}

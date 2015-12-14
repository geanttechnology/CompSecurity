// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class b
    implements Runnable
{

    final View a;
    final int b;
    final LauncherActivity c;

    public void run()
    {
        a.setVisibility(b);
    }

    (LauncherActivity launcheractivity, View view, int i)
    {
        c = launcheractivity;
        a = view;
        b = i;
        super();
    }
}

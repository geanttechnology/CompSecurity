// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements android.view.
{

    final EditViewActivity a;

    public void onClick(View view)
    {
        EditViewActivity.e(a).b(true);
        a.N();
        Globals.d().t().u(false);
        a.c(true);
        view = StatusManager.j().e();
        a.a(MakeupMode.b, BeautyMode.x, view);
    }

    er(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}

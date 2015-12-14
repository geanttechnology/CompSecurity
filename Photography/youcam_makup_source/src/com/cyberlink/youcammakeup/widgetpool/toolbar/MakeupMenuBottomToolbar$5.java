// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupMenuBottomToolbar

class a
    implements android.view.hangedListener
{

    final MakeupMenuBottomToolbar a;

    public void onScrollChanged()
    {
        MakeupMode makeupmode = StatusManager.j().r();
        for (com.cyberlink.youcammakeup.utility.BeautyMode beautymode = StatusManager.j().s(); makeupmode == MakeupMode.g || beautymode != null || !MakeupMenuBottomToolbar.c(a);)
        {
            return;
        }

        MakeupMenuBottomToolbar.a(a, true);
        a.c();
        StatusManager.j().a(MakeupMode.g);
    }

    (MakeupMenuBottomToolbar makeupmenubottomtoolbar)
    {
        a = makeupmenubottomtoolbar;
        super();
    }
}

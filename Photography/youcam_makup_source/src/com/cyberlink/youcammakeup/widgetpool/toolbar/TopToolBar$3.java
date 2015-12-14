// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.widgetpool.panel.a;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            TopToolBar

class a
    implements android.view.istener
{

    final TopToolBar a;

    public void onClick(View view)
    {
        if (!StatusManager.j().E().booleanValue())
        {
            return;
        }
        a.a(Boolean.valueOf(true));
        if (TopToolBar.c(a) != null)
        {
            TopToolBar.c(a).b();
            if (StatusManager.j().o().equals("editView"))
            {
                com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar.a(a, null);
            }
        }
        a.b();
    }

    (TopToolBar toptoolbar)
    {
        a = toptoolbar;
        super();
    }
}

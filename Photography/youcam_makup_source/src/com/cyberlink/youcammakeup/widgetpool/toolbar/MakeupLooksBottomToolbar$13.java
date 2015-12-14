// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar

class a
    implements Runnable
{

    final int a;
    final MakeupLooksBottomToolbar b;

    public void run()
    {
        if (MakeupLooksBottomToolbar.b(b) != null)
        {
            MakeupLooksBottomToolbar.b(b).a(a, false);
            MakeupLooksBottomToolbar.b(b).g(a);
            MakeupLooksBottomToolbar.a(b, MakeupLooksBottomToolbar.b(b).a(a).a(), true);
        }
    }

    (MakeupLooksBottomToolbar makeuplooksbottomtoolbar, int i)
    {
        b = makeuplooksbottomtoolbar;
        a = i;
        super();
    }
}

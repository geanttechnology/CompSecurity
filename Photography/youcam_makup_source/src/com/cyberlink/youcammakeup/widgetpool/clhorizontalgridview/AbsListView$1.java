// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            AbsListView, g

class b
    implements Runnable
{

    final View a;
    final g b;
    final AbsListView c;

    public void run()
    {
        c.D = -1;
        a.setPressed(false);
        c.setPressed(false);
        if (!c.ah)
        {
            b.run();
        }
    }

    (AbsListView abslistview, View view, g g1)
    {
        c = abslistview;
        a = view;
        b = g1;
        super();
    }
}

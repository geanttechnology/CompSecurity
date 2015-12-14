// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.i;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupMenuBottomToolbar

class a
    implements i
{

    final EditViewActivity a;
    final MakeupMenuBottomToolbar b;

    public void a(a a1)
    {
        a.b(this);
        while (a1 == null || StatusManager.j().P()) 
        {
            return;
        }
        b.d();
    }

    (MakeupMenuBottomToolbar makeupmenubottomtoolbar, EditViewActivity editviewactivity)
    {
        b = makeupmenubottomtoolbar;
        a = editviewactivity;
        super();
    }
}

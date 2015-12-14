// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.activity.i;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupMenuBottomToolbar

class c
    implements i
{

    final EditViewActivity a;
    final com.cyberlink.youcammakeup.utility.te b;
    final com.cyberlink.youcammakeup.utility.rl c;
    final MakeupMenuBottomToolbar d;

    public void a(a a1)
    {
        a.b(this);
        if (a1 == null)
        {
            return;
        }
        if (b != null)
        {
            d.b(b.makeupMode, b.beautyMode);
            return;
        } else
        {
            d.b(SkuTemplateUtils.g(c.type), SkuTemplateUtils.h(c.type));
            return;
        }
    }

    (MakeupMenuBottomToolbar makeupmenubottomtoolbar, EditViewActivity editviewactivity, com.cyberlink.youcammakeup.utility.te te, com.cyberlink.youcammakeup.utility.rl rl)
    {
        d = makeupmenubottomtoolbar;
        a = editviewactivity;
        b = te;
        c = rl;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupMenuBottomToolbar;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            d, EditViewActivity

class a
    implements android.view..OnClickListener
{

    final EditViewActivity a;
    final d b;

    public void onClick(View view)
    {
        if (!StatusManager.j().E().booleanValue())
        {
            return;
        }
        if (YMKSavingPageEvent.e())
        {
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(com.cyberlink.youcammakeup.clflurry.avingPageEvent.PageType.a));
        }
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.avingPageEvent.Operation.g, false, false));
        StatusManager.j().a(Boolean.valueOf(false));
        EditViewActivity.f(b.a).d();
        StatusManager.j().a(Boolean.valueOf(true));
    }

    ViewActivity(d d1, EditViewActivity editviewactivity)
    {
        b = d1;
        a = editviewactivity;
        super();
    }
}

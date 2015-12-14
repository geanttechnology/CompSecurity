// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.pages.a.a;
import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.p;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            CostumeLooksPagerActivity

class a
    implements Runnable
{

    final DownloadGridItem a;
    final CostumeLooksPagerActivity b;

    public void run()
    {
        Object obj = (p)a.getTag();
        a.setDownloadBtnState(com.cyberlink.youcammakeup.pages.moreview.te.d);
        ((p) (obj)).a(com.cyberlink.youcammakeup.pages.moreview.te.d);
        obj = CostumeLooksPagerActivity.c(b).a(((p) (obj)).a());
        b.a(new com.cyberlink.youcammakeup.utility.(-1L, ((String) (obj)), MakeupMode.a, BeautyMode.D));
    }

    oadState(CostumeLooksPagerActivity costumelookspageractivity, DownloadGridItem downloadgriditem)
    {
        b = costumelookspageractivity;
        a = downloadgriditem;
        super();
    }
}

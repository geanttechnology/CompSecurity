// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.pages.moreview.p;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            CostumeLooksPagerActivity

class b
    implements Runnable
{

    final DownloadGridItem a;
    final a b;
    final CostumeLooksPagerActivity c;

    public void run()
    {
        if (((p)a.getTag()).c() == com.cyberlink.youcammakeup.pages.moreview.te.c)
        {
            a.setProgress(af.a(b));
        }
    }

    oadState(CostumeLooksPagerActivity costumelookspageractivity, DownloadGridItem downloadgriditem, a a1)
    {
        c = costumelookspageractivity;
        a = downloadgriditem;
        b = a1;
        super();
    }
}

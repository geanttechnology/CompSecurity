// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ao;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            DownloadItemUtility

class a
    implements ao
{

    final e a;
    final DownloadItemUtility b;

    public void a(ap ap1)
    {
        a.a(ap1);
    }

    public void a(bn bn1)
    {
        a.b(bn1);
    }

    public volatile void a(Object obj)
    {
        a((ap)obj);
    }

    public void a(Void void1)
    {
        a.c(new String("GetStatusTask cancel"));
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    (DownloadItemUtility downloaditemutility, e e1)
    {
        b = downloaditemutility;
        a = e1;
        super();
    }
}

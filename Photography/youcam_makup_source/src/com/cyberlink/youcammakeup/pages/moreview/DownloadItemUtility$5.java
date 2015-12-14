// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.n;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.p;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            DownloadItemUtility

class a
    implements p
{

    final e a;
    final DownloadItemUtility b;

    public void a(bn bn1)
    {
        a.b(bn1);
    }

    public void a(n n1)
    {
        if (n1 == null || n1.a() == null)
        {
            return;
        } else
        {
            a.a(n1.a());
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((n)obj);
    }

    public void a(Void void1)
    {
        a.c(void1);
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

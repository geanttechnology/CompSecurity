// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c:
//            e, b, f

class c
    implements l
{

    final List a;
    final b b;
    final f c;
    final e d;

    public void a(a a1)
    {
    }

    public void a(bn bn1)
    {
        m.e("PromotionInfoCtrl", (new StringBuilder()).append("DownloadThumbnailCallback#error: ").append(String.valueOf(bn1)).toString());
    }

    public volatile void a(Object obj)
    {
        a((String)obj);
    }

    public void a(String s)
    {
        m.c("PromotionInfoCtrl", (new StringBuilder()).append("DownloadThumbnailCallback#complete: ").append(String.valueOf(s)).toString());
        if (s == null || s.equalsIgnoreCase(""))
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.networkmanager.c.e.a(d, s, a, b, c);
            return;
        }
    }

    public void a(Void void1)
    {
        m.e("PromotionInfoCtrl", "DownloadThumbnailCallback#cancel");
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    public void d(Object obj)
    {
        a((a)obj);
    }

    n(e e1, List list, b b1, f f)
    {
        d = e1;
        a = list;
        b = b1;
        c = f;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.q;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.t;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            IntroDialogUtils, ac

final class c
    implements t
{

    final troDialogType a;
    final Integer b;
    final ac c;

    public void a(bn bn1)
    {
    }

    public void a(q q1)
    {
        IntroDialogUtils.a(a, b, q1, c);
    }

    public volatile void a(Object obj)
    {
        a((q)obj);
    }

    public void a(Void void1)
    {
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void c(Object obj)
    {
        a((Void)obj);
    }

    troDialogType(troDialogType trodialogtype, Integer integer, ac ac)
    {
        a = trodialogtype;
        b = integer;
        c = ac;
        super();
    }
}

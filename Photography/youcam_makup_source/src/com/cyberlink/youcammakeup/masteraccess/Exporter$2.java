// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.masteraccess;

import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.f;

// Referenced classes of package com.cyberlink.youcammakeup.masteraccess:
//            Exporter, c

class d
    implements f
{

    final c a;
    final BeautifierManager b;
    final long c;
    final boolean d;
    final Exporter e;

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        if (!beautifiertaskinfo.a())
        {
            a.a(new ror(ror.JavaError.k));
            return;
        } else
        {
            b.i();
            beautifiertaskinfo = b.g();
            e.a(c, beautifiertaskinfo, d, a);
            return;
        }
    }

    ager(Exporter exporter, c c1, BeautifierManager beautifiermanager, long l, boolean flag)
    {
        e = exporter;
        a = c1;
        b = beautifiermanager;
        c = l;
        d = flag;
        super();
    }
}

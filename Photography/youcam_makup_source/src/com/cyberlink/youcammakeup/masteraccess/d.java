// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.masteraccess;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.a;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.q;

// Referenced classes of package com.cyberlink.youcammakeup.masteraccess:
//            e, c, Exporter

class d
    implements a
{

    private static final e a = new e(null);
    private final c b;
    private final long c;
    private final boolean d;
    private final String e;

    d(c c1, long l, boolean flag)
    {
        if (c1 == null)
        {
            c1 = a;
        }
        b = c1;
        c = l;
        e = String.valueOf(c);
        d = flag;
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s, Object obj)
    {
        b.a();
    }

    public void a(q q1, Object obj)
    {
        if (q1 == null)
        {
            b.a(new Exporter.Error(Exporter.Error.JavaError.b));
            return;
        } else
        {
            Globals.d().r().a(c, q1.a(), d, b);
            return;
        }
    }

    public void a(String s, Object obj)
    {
        b.a(new Exporter.Error(Exporter.Error.JavaError.h));
    }

}

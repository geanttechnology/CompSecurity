// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.a;

import com.cyberlink.youcammakeup.kernelctrl.status.u;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.a:
//            a

class b
    implements u
{

    final a a;

    private b(a a1)
    {
        a = a1;
        super();
    }

    b(a a1, a._cls1 _pcls1)
    {
        this(a1);
    }

    public void g(boolean flag)
    {
        a a1 = a;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.cyberlink.youcammakeup.widgetpool.panel.a.a.a(a1, flag);
    }
}

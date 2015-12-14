// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.masteraccess.b;
import com.cyberlink.youcammakeup.masteraccess.c;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            PanelDataCenter, aq, bo, av

class f
    implements c
{

    final aq a;
    final ImageBufferWrapper b;
    final String c;
    final av d;
    final String e;
    final List f;
    final PanelDataCenter g;

    public void a()
    {
        if (a != null)
        {
            a.a(new Exception("Failed to save thumbnail."));
        }
        b.m();
    }

    public void a(com.cyberlink.youcammakeup.masteraccess.erWrapper.m m)
    {
        if (a != null)
        {
            a.a(new Exception("Failed to save thumbnail."));
        }
        b.m();
    }

    public void a(b b1)
    {
        b1 = bo.a(c, d, e, f);
        if (a != null)
        {
            a.a(b1);
        }
        b.m();
    }

    eBufferWrapper(PanelDataCenter paneldatacenter, aq aq1, ImageBufferWrapper imagebufferwrapper, String s, av av, String s1, List list)
    {
        g = paneldatacenter;
        a = aq1;
        b = imagebufferwrapper;
        c = s;
        d = av;
        e = s1;
        f = list;
        super();
    }
}

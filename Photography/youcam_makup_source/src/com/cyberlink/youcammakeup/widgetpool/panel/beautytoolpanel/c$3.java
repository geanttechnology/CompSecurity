// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import com.cyberlink.youcammakeup.utility.aw;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            c, BeautyToolPanel

class a
    implements Runnable
{

    final aw a;
    final c b;

    public void run()
    {
        c.p(b);
        if (a == null)
        {
            c.c(b).a(null);
            return;
        } else
        {
            c.c(b).a(c.a(b, (ArrayList)a.i(), null));
            return;
        }
    }

    tyToolPanel(c c1, aw aw1)
    {
        b = c1;
        a = aw1;
        super();
    }
}

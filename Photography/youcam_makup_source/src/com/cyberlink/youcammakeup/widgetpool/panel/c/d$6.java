// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            d, m, f

class b
    implements Runnable
{

    final View a;
    final int b;
    final d c;

    public void run()
    {
        ((m)a).a(false);
        d.i(c).a(b, false);
    }

    (d d1, View view, int i)
    {
        c = d1;
        a = view;
        b = i;
        super();
    }
}

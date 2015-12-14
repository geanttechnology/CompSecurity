// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            d

class a
    implements android.view.TreeObserver.OnGlobalLayoutListener
{

    final d a;

    public void onGlobalLayout()
    {
        d.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        d.b(a);
        d.c(a);
    }

    er(d d1)
    {
        a = d1;
        super();
    }
}

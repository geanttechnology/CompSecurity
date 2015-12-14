// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.view.View;
import com.cyberlink.youcammakeup.activity.EditViewActivity;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class a
    implements android.view.OnLayoutChangeListener
{

    final d a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        while (d.i(a) == null || d.i(a).isFinishing() || l1 - j1 == l - j) 
        {
            return;
        }
        d.i(a).c(view.getHeight() + d.j(a).getHeight());
    }

    y(d d1)
    {
        a = d1;
        super();
    }
}

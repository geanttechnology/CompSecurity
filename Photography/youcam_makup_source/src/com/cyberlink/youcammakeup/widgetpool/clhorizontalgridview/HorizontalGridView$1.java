// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            HorizontalGridView

class b
    implements Runnable
{

    final int a;
    final int b;
    final HorizontalGridView c;

    public void run()
    {
        View view = c.getChildAt(a - c.getFirstVisiblePosition());
        if (view == null)
        {
            return;
        } else
        {
            int i = (int)(view.getX() - (float)((c.getWidth() - view.getWidth()) / 2));
            c.b(i, b);
            return;
        }
    }

    (HorizontalGridView horizontalgridview, int i, int j)
    {
        c = horizontalgridview;
        a = i;
        b = j;
        super();
    }
}

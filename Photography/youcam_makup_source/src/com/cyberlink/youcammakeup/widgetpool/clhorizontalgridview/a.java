// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            l, AbsListView

class a extends l
    implements Runnable
{

    final AbsListView a;

    private a(AbsListView abslistview)
    {
        a = abslistview;
        super(abslistview, null);
    }

    a(AbsListView abslistview, AbsListView._cls1 _pcls1)
    {
        this(abslistview);
    }

    public void run()
    {
        if (a.isPressed() && a.ak >= 0)
        {
            int i = a.ak;
            int j = a.T;
            View view = a.getChildAt(i - j);
            if (!a.ah)
            {
                boolean flag;
                if (b())
                {
                    flag = a.c(view, a.ak, a.al);
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    a.setPressed(false);
                    view.setPressed(false);
                }
            } else
            {
                a.setPressed(false);
                if (view != null)
                {
                    view.setPressed(false);
                    return;
                }
            }
        }
    }
}

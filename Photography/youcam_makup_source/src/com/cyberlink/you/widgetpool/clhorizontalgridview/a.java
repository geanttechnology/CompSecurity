// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.view.View;

// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
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
        if (a.isPressed() && a.aj >= 0)
        {
            int i = a.aj;
            int j = a.S;
            View view = a.getChildAt(i - j);
            if (!a.ag)
            {
                boolean flag;
                if (b())
                {
                    flag = a.c(view, a.aj, a.ak);
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

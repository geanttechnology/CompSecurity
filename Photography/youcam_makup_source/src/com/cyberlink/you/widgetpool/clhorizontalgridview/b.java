// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
//            l, AbsListView

class b extends l
    implements Runnable
{

    final AbsListView a;

    private b(AbsListView abslistview)
    {
        a = abslistview;
        super(abslistview, null);
    }

    b(AbsListView abslistview, AbsListView._cls1 _pcls1)
    {
        this(abslistview);
    }

    public void run()
    {
label0:
        {
            int i = a.x;
            View view = a.getChildAt(i - a.S);
            if (view != null)
            {
                int j = a.x;
                long l1 = a.g.getItemId(a.x);
                boolean flag;
                if (b() && !a.ag)
                {
                    flag = a.c(view, j, l1);
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
                a.C = -1;
                a.setPressed(false);
                view.setPressed(false);
            }
            return;
        }
        a.C = 2;
    }
}

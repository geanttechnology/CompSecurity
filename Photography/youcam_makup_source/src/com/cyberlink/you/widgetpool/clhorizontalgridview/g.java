// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.widget.ListAdapter;

// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
//            l, AbsListView

class g extends l
    implements Runnable
{

    int a;
    final AbsListView b;

    private g(AbsListView abslistview)
    {
        b = abslistview;
        super(abslistview, null);
    }

    g(AbsListView abslistview, AbsListView._cls1 _pcls1)
    {
        this(abslistview);
    }

    public void run()
    {
        if (!b.ag)
        {
            ListAdapter listadapter = b.g;
            int i = a;
            if (listadapter != null && b.al > 0 && i != -1 && i < listadapter.getCount() && b())
            {
                android.view.View view = b.getChildAt(i - b.S);
                if (view != null)
                {
                    b.a(view, i, listadapter.getItemId(i));
                    return;
                }
            }
        }
    }
}

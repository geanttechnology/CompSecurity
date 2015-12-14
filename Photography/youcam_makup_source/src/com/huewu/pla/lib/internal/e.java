// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;

import android.view.View;
import android.widget.ListAdapter;

// Referenced classes of package com.huewu.pla.lib.internal:
//            j, PLA_AbsListView

class e extends j
    implements Runnable
{

    View a;
    int b;
    final PLA_AbsListView c;

    private e(PLA_AbsListView pla_abslistview)
    {
        c = pla_abslistview;
        super(pla_abslistview, null);
    }

    e(PLA_AbsListView pla_abslistview, PLA_AbsListView._cls1 _pcls1)
    {
        this(pla_abslistview);
    }

    public void run()
    {
        if (!c.Q)
        {
            ListAdapter listadapter = c.e;
            int i = b;
            if (listadapter != null && c.V > 0 && i != -1 && i < listadapter.getCount() && b())
            {
                c.b(a, i, listadapter.getItemId(i));
                return;
            }
        }
    }
}

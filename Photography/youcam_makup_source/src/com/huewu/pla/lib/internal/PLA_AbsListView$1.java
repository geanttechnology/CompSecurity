// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;

import android.view.View;

// Referenced classes of package com.huewu.pla.lib.internal:
//            PLA_AbsListView, e

class b
    implements Runnable
{

    final View a;
    final e b;
    final PLA_AbsListView c;

    public void run()
    {
        a.setPressed(false);
        c.setPressed(false);
        if (!c.Q)
        {
            c.post(b);
        }
        c.v = -1;
    }

    (PLA_AbsListView pla_abslistview, View view, e e)
    {
        c = pla_abslistview;
        a = view;
        b = e;
        super();
    }
}

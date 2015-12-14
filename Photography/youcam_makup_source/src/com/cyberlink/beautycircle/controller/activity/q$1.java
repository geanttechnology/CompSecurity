// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            q

class a
    implements android.view..OnLayoutChangeListener
{

    final q a;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        if (q.a(a) != null)
        {
            q.a(a).removeOnLayoutChangeListener(q.b(a));
            q.a(a, Integer.valueOf(q.a(a).getWidth()));
            if (q.c(a) != null && q.d(a) != null)
            {
                q.d(a).getLayoutParams().width = q.e(a).intValue();
                q.d(a).requestLayout();
            }
        }
    }

    (q q1)
    {
        a = q1;
        super();
    }
}

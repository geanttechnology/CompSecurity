// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class b
    implements android.view.OnLayoutChangeListener
{

    final p a;
    private int b;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        i = a.i.getHeight() + p.b(a).getHeight();
        if (i == b)
        {
            return;
        } else
        {
            b = i;
            view = p.P(a).getLayoutParams();
            view.height = i;
            p.P(a).setLayoutParams(view);
            return;
        }
    }

    _cls9(p p1)
    {
        a = p1;
        super();
        b = 0;
    }
}

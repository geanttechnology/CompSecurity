// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            d

class a
    implements android.view..OnLayoutChangeListener
{

    final boolean a;
    final d b;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        view.removeOnLayoutChangeListener(this);
        d.a(b, a);
    }

    (d d1, boolean flag)
    {
        b = d1;
        a = flag;
        super();
    }
}

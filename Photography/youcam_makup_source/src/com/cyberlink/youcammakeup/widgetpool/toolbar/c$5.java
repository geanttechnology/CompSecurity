// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            c

class b
    implements android.view..OnLayoutChangeListener
{

    final View a;
    final ch b;
    final c c;

    public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        a.removeOnLayoutChangeListener(this);
        float f = a.getY();
        a.setY((float)a.getHeight() + f);
        a.animate().alphaBy(0.5F).alpha(1.0F).y(f).setDuration(300L).setListener(b);
    }

    (c c1, View view, ch ch)
    {
        c = c1;
        a = view;
        b = ch;
        super();
    }
}

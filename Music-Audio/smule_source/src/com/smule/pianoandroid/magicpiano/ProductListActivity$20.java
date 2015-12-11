// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.view.animation.Animation;
import com.smule.pianoandroid.utils.n;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity, ac

class c
    implements android.view.animation.ener
{

    final View a;
    final View b;
    final Runnable c;
    final ProductListActivity d;

    public void onAnimationEnd(Animation animation)
    {
        a.setVisibility(8);
        b.setVisibility(8);
        ac.a().a("NOTIFICATION_ACHIEVEMENTS", ProductListActivity.d());
        ProductListActivity.b(0);
        if (c != null)
        {
            c.run();
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        n.a(ProductListActivity.a(d), ProductListActivity.b(d)[1], 1.2F, false);
    }

    (ProductListActivity productlistactivity, View view, View view1, Runnable runnable)
    {
        d = productlistactivity;
        a = view;
        b = view1;
        c = runnable;
        super();
    }
}

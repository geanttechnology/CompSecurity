// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity

class e
    implements android.view.animation.ener
{

    final View a;
    final View b;
    final View c;
    final View d;
    final Runnable e;
    final ProductListActivity f;

    public void onAnimationEnd(Animation animation)
    {
        b.setVisibility(8);
        ProductListActivity.c(f, c, d, b, e);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        a.setVisibility(8);
    }

    (ProductListActivity productlistactivity, View view, View view1, View view2, View view3, Runnable runnable)
    {
        f = productlistactivity;
        a = view;
        b = view1;
        c = view2;
        d = view3;
        e = runnable;
        super();
    }
}

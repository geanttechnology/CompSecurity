// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity

class d
    implements android.view.animation.ener
{

    final View a;
    final View b;
    final View c;
    final Runnable d;
    final ProductListActivity e;

    public void onAnimationEnd(Animation animation)
    {
        animation = (TextView)e.findViewById(0x7f0a01d5);
        animation.setText((new StringBuilder()).append("+").append(ProductListActivity.d()).toString());
        animation.setVisibility(0);
        ProductListActivity.b(e, b, c, a, d);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        a.setVisibility(0);
    }

    (ProductListActivity productlistactivity, View view, View view1, View view2, Runnable runnable)
    {
        e = productlistactivity;
        a = view;
        b = view1;
        c = view2;
        d = runnable;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.idunnololz.widgets;

import android.view.animation.Animation;

// Referenced classes of package com.idunnololz.widgets:
//            a, b

class b
    implements android.view.animation.ation.AnimationListener
{

    final int a;
    final b b;
    final a c;

    public void onAnimationEnd(Animation animation)
    {
        com.idunnololz.widgets.a.a(c, a);
        c.notifyDataSetChanged();
        b.setTag(Integer.valueOf(0));
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ation(a a1, int i, b b1)
    {
        c = a1;
        a = i;
        b = b1;
        super();
    }
}

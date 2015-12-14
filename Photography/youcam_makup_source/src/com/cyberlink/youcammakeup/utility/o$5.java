// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            o, p

class d
    implements android.view.animation.ation.AnimationListener
{

    final Animation a;
    final ViewGroup b;
    final View c;
    final p d;
    final o e;

    private void a()
    {
        b.removeView(c);
        d.a();
    }

    public void onAnimationEnd(Animation animation)
    {
        a();
    }

    public void onAnimationRepeat(Animation animation)
    {
        o.a(e, true);
        if (o.b(e))
        {
            a.cancel();
        }
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ionListener(o o1, Animation animation, ViewGroup viewgroup, View view, p p1)
    {
        e = o1;
        a = animation;
        b = viewgroup;
        c = view;
        d = p1;
        super();
    }
}

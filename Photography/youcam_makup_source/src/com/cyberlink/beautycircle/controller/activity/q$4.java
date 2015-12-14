// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.animation.Animation;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            q, SearchActivity, s

class a
    implements android.view.animation.ation.AnimationListener
{

    final boolean a;
    final q b;

    public void onAnimationEnd(Animation animation)
    {
        q.a(b, 0, 4);
        if (a && SearchActivity.s(b.a) != null)
        {
            SearchActivity.s(b.a).b();
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    chActivity(q q1, boolean flag)
    {
        b = q1;
        a = flag;
        super();
    }
}

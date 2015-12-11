// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.view.animation.Animation;

// Referenced classes of package com.j.a.d:
//            ag

class w
    implements android.view.animation.Animation.AnimationListener
{

    final ag a;

    w(ag ag1)
    {
        a = ag1;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        ag.a(a, null);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}

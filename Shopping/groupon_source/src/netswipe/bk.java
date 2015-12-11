// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.view.animation.Animation;
import android.widget.ImageView;

// Referenced classes of package netswipe:
//            bi

class bk
    implements android.view.animation.Animation.AnimationListener
{

    final bi a;

    bk(bi bi1)
    {
        a = bi1;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        bi.a(a);
        if (bi.b(a) < bi.c())
        {
            bi.d(a).startAnimation(bi.e(a));
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}

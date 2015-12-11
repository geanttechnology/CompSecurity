// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package android.support.v4.app:
//            ah, ab, ag

class af
    implements android.view.animation.Animation.AnimationListener
{

    private boolean a;
    private View b;

    public af(View view, Animation animation)
    {
        a = false;
        if (view == null || animation == null)
        {
            return;
        } else
        {
            b = view;
            return;
        }
    }

    static View a(af af1)
    {
        return af1.b;
    }

    public void onAnimationEnd(Animation animation)
    {
        if (a)
        {
            b.post(new ah(this));
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        a = ab.a(b, animation);
        if (a)
        {
            b.post(new ag(this));
        }
    }
}

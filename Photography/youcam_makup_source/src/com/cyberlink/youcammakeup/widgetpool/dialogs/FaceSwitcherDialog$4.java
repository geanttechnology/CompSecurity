// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.animation.Animator;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            FaceSwitcherDialog

class f extends ch
{

    final ViewGroup a;
    final ch b;
    final float c;
    final float d;
    final float e;
    final float f;
    final FaceSwitcherDialog g;

    public void onAnimationEnd(Animator animator)
    {
        a.animate().setListener(b).setDuration(250L).setInterpolator(AnimationUtils.loadInterpolator(g.getActivity(), 0x10a0006)).scaleXBy(1.0F).scaleX(c).scaleYBy(1.0F).scaleY(d).rotationBy(70F).rotation(90F).x(e).y(f).start();
    }

    (FaceSwitcherDialog faceswitcherdialog, ViewGroup viewgroup, ch ch1, float f1, float f2, float f3, float f4)
    {
        g = faceswitcherdialog;
        a = viewgroup;
        b = ch1;
        c = f1;
        d = f2;
        e = f3;
        f = f4;
        super();
    }
}

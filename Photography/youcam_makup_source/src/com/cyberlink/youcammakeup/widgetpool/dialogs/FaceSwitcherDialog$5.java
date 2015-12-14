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

    final float a;
    final float b;
    final float c;
    final float d;
    final ViewGroup e;
    final ch f;
    final FaceSwitcherDialog g;

    public void onAnimationEnd(Animator animator)
    {
        float f1 = a;
        float f2 = b;
        float f3 = c;
        float f4 = d;
        e.animate().setListener(f).setDuration(300L).setInterpolator(AnimationUtils.loadInterpolator(g.getActivity(), 0x10a0005)).scaleXBy(1.0F).scaleX((1.0F - f1) * 0.3F).scaleYBy(1.0F).scaleY((1.0F - f2) * 0.3F).rotationBy(0.0F).rotation(70F).x(f3 * 0.2F).y(f4).start();
    }

    (FaceSwitcherDialog faceswitcherdialog, float f1, float f2, float f3, float f4, ViewGroup viewgroup, ch ch1)
    {
        g = faceswitcherdialog;
        a = f1;
        b = f2;
        c = f3;
        d = f4;
        e = viewgroup;
        f = ch1;
        super();
    }
}

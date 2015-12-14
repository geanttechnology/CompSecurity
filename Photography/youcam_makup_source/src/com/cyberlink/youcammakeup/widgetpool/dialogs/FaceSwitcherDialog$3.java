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

class b extends ch
{

    final ViewGroup a;
    final ch b;
    final FaceSwitcherDialog c;

    public void onAnimationEnd(Animator animator)
    {
        a.animate().setListener(b).setDuration(350L).setInterpolator(AnimationUtils.loadInterpolator(c.getActivity(), 0x10a0006)).alphaBy(1.0F).alpha(0.0F).start();
    }

    (FaceSwitcherDialog faceswitcherdialog, ViewGroup viewgroup, ch ch1)
    {
        c = faceswitcherdialog;
        a = viewgroup;
        b = ch1;
        super();
    }
}

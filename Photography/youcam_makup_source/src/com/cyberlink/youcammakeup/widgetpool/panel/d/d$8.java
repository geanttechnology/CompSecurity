// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.b;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class a extends ch
{

    final ch a;
    final d b;

    public void onAnimationEnd(Animator animator)
    {
        if (d.g(b) != null && (d.g(b) instanceof b))
        {
            ((b)d.g(b)).c(false);
        }
        d.s(b).setVisibility(8);
        if (a != null)
        {
            a.onAnimationEnd(animator);
        }
        if (d.i(b) != null && !d.i(b).isFinishing())
        {
            d.i(b).c(d.j(b).getHeight() + d.t(b).getHeight());
        }
    }

    ty(d d1, ch ch1)
    {
        b = d1;
        a = ch1;
        super();
    }
}

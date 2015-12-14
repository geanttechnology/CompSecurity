// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.animation.Animator;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            c

class a extends ch
{

    final ch a;
    final c b;

    public void onAnimationEnd(Animator animator)
    {
        if (a != null)
        {
            a.onAnimationEnd(animator);
        }
        c.a(b, false);
        c.a(b);
        StatusManager.j().a(Boolean.valueOf(true));
    }

    sManager(c c1, ch ch1)
    {
        b = c1;
        a = ch1;
        super();
    }
}

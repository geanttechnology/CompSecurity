// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.animation.Animator;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class a extends ch
{

    final ch a;
    final d b;

    public void onAnimationEnd(Animator animator)
    {
        if (a != null)
        {
            a.onAnimationEnd(animator);
        }
    }

    (d d1, ch ch1)
    {
        b = d1;
        a = ch1;
        super();
    }
}

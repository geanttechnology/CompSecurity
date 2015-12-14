// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import android.view.animation.Animation;
import com.cyberlink.youcammakeup.utility.cg;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            j

class nit> extends cg
{

    final View a;
    final j b;

    public void onAnimationEnd(Animation animation)
    {
        if (a.getAnimation() == animation)
        {
            a.clearAnimation();
        }
    }

    (j j1, View view)
    {
        b = j1;
        a = view;
        super();
    }
}

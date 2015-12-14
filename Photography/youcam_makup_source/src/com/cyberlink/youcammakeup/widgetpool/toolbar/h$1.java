// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.view.View;
import android.view.animation.Animation;
import com.cyberlink.youcammakeup.utility.cg;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            h

class b extends cg
{

    final View a;
    final View b;
    final h c;

    public void onAnimationEnd(Animation animation)
    {
        a.setVisibility(8);
        if (b.getAnimation() == animation)
        {
            b.clearAnimation();
        }
    }

    (h h1, View view, View view1)
    {
        c = h1;
        a = view;
        b = view1;
        super();
    }
}

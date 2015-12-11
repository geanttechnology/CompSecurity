// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;

import android.view.View;
import android.view.animation.Animation;
import com.shazam.android.b.d;

// Referenced classes of package com.shazam.android.advert:
//            i

final class a extends d
{

    final View a;
    final i b;

    public final void onAnimationStart(Animation animation)
    {
        super.onAnimationStart(animation);
        if (a != null)
        {
            b.c.cancel();
            b.c.reset();
            b.c.setAnimationListener(new d(a, 0));
            a.clearAnimation();
            a.startAnimation(b.c);
        }
    }

    on(i j, View view, View view1)
    {
        b = j;
        a = view1;
        super(view, 0);
    }
}

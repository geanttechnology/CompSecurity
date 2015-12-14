// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeActivity

class b
    implements android.view.animation.tener
{

    final boolean a;
    final View b;
    final MagComposeActivity c;

    public void onAnimationEnd(Animation animation)
    {
        if (a && b != null)
        {
            b.setVisibility(0);
            return;
        } else
        {
            b.setVisibility(4);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    er(MagComposeActivity magcomposeactivity, boolean flag, View view)
    {
        c = magcomposeactivity;
        a = flag;
        b = view;
        super();
    }
}

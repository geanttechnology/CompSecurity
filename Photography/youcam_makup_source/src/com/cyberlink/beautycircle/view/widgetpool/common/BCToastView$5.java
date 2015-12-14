// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.os.Handler;
import android.view.animation.Animation;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            BCToastView

class a
    implements android.view.animation.ationListener
{

    final Runnable a;
    final BCToastView b;

    public void onAnimationEnd(Animation animation)
    {
        b.setVisibility(8);
        if (a != null)
        {
            BCToastView.b(b).post(a);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    (BCToastView bctoastview, Runnable runnable)
    {
        b = bctoastview;
        a = runnable;
        super();
    }
}

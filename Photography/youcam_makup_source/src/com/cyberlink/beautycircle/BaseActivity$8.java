// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import java.util.Timer;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity, j

class b
    implements Runnable
{

    final boolean a;
    final String b;
    final BaseActivity c;

    public void run()
    {
        if (BaseActivity.f(c) != null)
        {
            BaseActivity.f(c).cancel();
            BaseActivity.a(c, null);
        }
        if (BaseActivity.d(c) == null)
        {
            BaseActivity.a(c, (TextView)c.findViewById(j.status_panel));
        }
        if (BaseActivity.e(c) == null)
        {
            BaseActivity.a(c, c.findViewById(j.updown_shadow_panel));
        }
        if (a && BaseActivity.d(c) != null && BaseActivity.e(c) != null)
        {
            BaseActivity.a(c, b);
            BaseActivity.d(c).setText(b);
            if (BaseActivity.d(c).getVisibility() == 8)
            {
                BaseActivity.d(c).setVisibility(0);
                ObjectAnimator.ofFloat(BaseActivity.d(c), "alpha", new float[] {
                    0.0F, 1.0F
                }).setDuration(200L).start();
            }
            if (BaseActivity.e(c).getVisibility() == 8)
            {
                ObjectAnimator.ofFloat(BaseActivity.e(c), "alpha", new float[] {
                    0.0F, 1.0F
                }).setDuration(200L).start();
            }
            return;
        } else
        {
            BaseActivity.a(c, null);
            c.m();
            return;
        }
    }

    (BaseActivity baseactivity, boolean flag, String s)
    {
        c = baseactivity;
        a = flag;
        b = s;
        super();
    }
}

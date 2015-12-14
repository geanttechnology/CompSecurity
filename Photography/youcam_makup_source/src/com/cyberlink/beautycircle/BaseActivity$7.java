// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.TextView;
import java.util.Timer;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity, j, b

class b
    implements Runnable
{

    final String a;
    final int b;
    final BaseActivity c;

    public void run()
    {
        if (BaseActivity.d(c) == null)
        {
            BaseActivity.a(c, (TextView)c.findViewById(j.status_panel));
        }
        if (BaseActivity.e(c) == null)
        {
            BaseActivity.a(c, c.findViewById(j.updown_shadow_panel));
        }
        if (BaseActivity.d(c) != null && BaseActivity.e(c) != null)
        {
            BaseActivity.d(c).setText(a);
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
            if (BaseActivity.f(c) != null)
            {
                BaseActivity.f(c).cancel();
                BaseActivity.a(c, null);
            }
            BaseActivity.a(c, new Timer());
            BaseActivity.f(c).schedule(new b(c, null), b);
        }
    }

    (BaseActivity baseactivity, String s, int i)
    {
        c = baseactivity;
        a = s;
        b = i;
        super();
    }
}

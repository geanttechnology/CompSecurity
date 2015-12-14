// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.view.VelocityTracker;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            d, AbsListView, u

class a
    implements Runnable
{

    final d a;

    public void run()
    {
        int i = AbsListView.d(a.a);
        VelocityTracker velocitytracker = AbsListView.e(a.a);
        u u1 = d.a(a);
        if (velocitytracker == null || i == -1)
        {
            return;
        }
        velocitytracker.computeCurrentVelocity(1000, AbsListView.f(a.a));
        float f = -velocitytracker.getXVelocity(i);
        if (Math.abs(f) >= (float)AbsListView.g(a.a) && u1.a(f, 0.0F))
        {
            a.a.postDelayed(this, 40L);
            return;
        } else
        {
            a.b();
            a.a.D = 3;
            a.a.b(1);
            return;
        }
    }

    istView(d d1)
    {
        a = d1;
        super();
    }
}

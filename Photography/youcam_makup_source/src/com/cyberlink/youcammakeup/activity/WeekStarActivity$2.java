// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.widget.ProgressBar;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.j;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            WeekStarActivity

class a
    implements j
{

    final WeekStarActivity a;

    public void a(a a1)
    {
        com.cyberlink.youcammakeup.activity.WeekStarActivity.a(a).setProgress((WeekStarActivity.c(a) * 100) / WeekStarActivity.d(a) + (int)((100L * a1.a()) / a1.b() / (long)WeekStarActivity.d(a)));
    }

    public void a(bn bn1)
    {
    }

    public volatile void a(Object obj)
    {
        a((Void)obj);
    }

    public void a(Void void1)
    {
        WeekStarActivity.b(a);
        if (WeekStarActivity.c(a) == WeekStarActivity.d(a))
        {
            com.cyberlink.youcammakeup.activity.WeekStarActivity.a(a).setProgress(100);
            com.cyberlink.youcammakeup.activity.WeekStarActivity.a(a, WeekStarActivity.e(a));
        }
    }

    public void b(Object obj)
    {
        a((bn)obj);
    }

    public void b(Void void1)
    {
    }

    public void c(Object obj)
    {
        b((Void)obj);
    }

    public void d(Object obj)
    {
        a((a)obj);
    }

    sk.bn(WeekStarActivity weekstaractivity)
    {
        a = weekstaractivity;
        super();
    }
}

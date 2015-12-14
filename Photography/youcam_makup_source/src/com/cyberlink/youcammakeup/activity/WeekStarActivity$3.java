// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            WeekStarActivity

class a
    implements Runnable
{

    final WeekStarActivity a;

    public void run()
    {
        WeekStarActivity.f(a).setVisibility(8);
    }

    (WeekStarActivity weekstaractivity)
    {
        a = weekstaractivity;
        super();
    }
}

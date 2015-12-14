// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            OpeningTutorialActivity

class a
    implements android.view.ningTutorialActivity._cls2
{

    final OpeningTutorialActivity a;

    public void onClick(View view)
    {
        view = OpeningTutorialActivity.a(a);
        view.setCurrentItem(view.getCurrentItem() - 1, true);
    }

    (OpeningTutorialActivity openingtutorialactivity)
    {
        a = openingtutorialactivity;
        super();
    }
}

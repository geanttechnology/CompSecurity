// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.cyberlink.youcammakeup.widgetpool.common.IndicatorView;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            OpeningTutorialActivity

class b
    implements android.support.v4.view.ener
{

    final IndicatorView a;
    final int b;
    final OpeningTutorialActivity c;

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0 || i == 2)
        {
            OpeningTutorialActivity.a(c, false);
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        OpeningTutorialActivity.a(c, false);
    }

    public void onPageSelected(int i)
    {
        OpeningTutorialActivity.a(c, i);
        a.setIndex(i);
        if (i == b - 1)
        {
            OpeningTutorialActivity.a(c, a);
            return;
        } else
        {
            OpeningTutorialActivity.b(c, a);
            return;
        }
    }

    (OpeningTutorialActivity openingtutorialactivity, IndicatorView indicatorview, int i)
    {
        c = openingtutorialactivity;
        a = indicatorview;
        b = i;
        super();
    }
}

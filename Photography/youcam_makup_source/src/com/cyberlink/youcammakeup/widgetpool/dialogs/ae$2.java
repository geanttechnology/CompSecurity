// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.support.v4.view.ViewPager;
import com.cyberlink.youcammakeup.clflurry.YMKBeforeAfterEvent;
import com.cyberlink.youcammakeup.widgetpool.common.CollageImageView;
import com.cyberlink.youcammakeup.widgetpool.common.IndicatorView;
import com.cyberlink.youcammakeup.widgetpool.common.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ae

class b
    implements android.support.v4.view.ager.OnPageChangeListener
{

    final IndicatorView a;
    final m b;
    final ae c;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        YMKBeforeAfterEvent.a(true);
        ae.a(c, i);
        a.setIndex(i);
        android.view.View view = ae.c(c).findViewWithTag(Integer.valueOf(i));
        if (view != null && (view instanceof CollageImageView))
        {
            ((CollageImageView)view).a(b);
        }
    }

    torView(ae ae1, IndicatorView indicatorview, m m)
    {
        c = ae1;
        a = indicatorview;
        b = m;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.views;

import android.os.Handler;

// Referenced classes of package com.gotv.crackle.views:
//            HeroViewPager, PagerIndicator

class this._cls0
    implements android.support.v4.view.ChangeListener
{

    final HeroViewPager this$0;

    public void onPageScrollStateChanged(int i)
    {
        PagerIndicator pagerindicator = getIndicator();
        if (pagerindicator != null)
        {
            pagerindicator.setCurrentPage(getCurrentItem() % pagerindicator.getNumberOfPages());
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
        HeroViewPager.access$100().removeMessages(0);
        HeroViewPager.access$200(HeroViewPager.this);
    }

    public void onPageSelected(int i)
    {
    }

    eChangeListener()
    {
        this$0 = HeroViewPager.this;
        super();
    }
}

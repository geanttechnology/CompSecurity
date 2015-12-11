// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

// Referenced classes of package com.ebay.android.widget:
//            ImageViewPager

class this._cls0
    implements android.support.v4.view.hangeListener
{

    final ImageViewPager this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        setCollectionBounds(i, imagePager.getAdapter().getCount());
    }

    hangeListener()
    {
        this$0 = ImageViewPager.this;
        super();
    }
}

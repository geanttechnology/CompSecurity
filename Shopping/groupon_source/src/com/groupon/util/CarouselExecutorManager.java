// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import com.groupon.activity.Carousel;
import com.groupon.fragment.BaseCardListFragment;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.view.GrouponViewPager;

// Referenced classes of package com.groupon.util:
//            ExecutorManager

public class CarouselExecutorManager extends ExecutorManager
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    public CarouselExecutorManager(Activity activity, ExecutorManager executormanager)
    {
        super(activity, executormanager);
        ((Carousel)activity).addOnPageChangeListener(this);
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        updateChannelPriorities();
    }

    protected void updateChannelPriorities()
    {
        Object obj = ((Carousel)activity).getViewPager();
        PagerAdapter pageradapter = ((GrouponViewPager) (obj)).getAdapter();
        int i = ((GrouponViewPager) (obj)).getCurrentItem();
        int j = i - 1;
        int k = i + 1;
        if (j >= 0)
        {
            Object obj2 = ((GrouponViewPager) (obj)).findFragmentByPositionIfAvailable(j);
            if (obj2 != null && (obj2 instanceof BaseCardListFragment))
            {
                obj2 = ((BaseCardListFragment)obj2).getSyncManager().getExecutor();
                removeExecutor(((PausableThreadPoolExecutor) (obj2)));
                addExecutor(((PausableThreadPoolExecutor) (obj2)));
            }
        }
        if (k < pageradapter.getCount())
        {
            Object obj1 = ((GrouponViewPager) (obj)).findFragmentByPositionIfAvailable(k);
            if (obj1 != null && (obj1 instanceof BaseCardListFragment))
            {
                obj1 = ((BaseCardListFragment)obj1).getSyncManager().getExecutor();
                removeExecutor(((PausableThreadPoolExecutor) (obj1)));
                addExecutor(((PausableThreadPoolExecutor) (obj1)));
            }
        }
        obj = ((GrouponViewPager) (obj)).findFragmentByPositionIfAvailable(i);
        if (obj != null && (obj instanceof BaseCardListFragment))
        {
            obj = ((BaseCardListFragment)obj).getSyncManager().getExecutor();
            removeExecutor(((PausableThreadPoolExecutor) (obj)));
            addExecutor(((PausableThreadPoolExecutor) (obj)));
        }
    }
}

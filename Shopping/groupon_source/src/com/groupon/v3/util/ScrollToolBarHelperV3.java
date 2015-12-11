// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.util;

import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import com.groupon.activity.Carousel;
import com.groupon.util.ScrollChangeListener;
import com.groupon.util.SwipeRefreshManager;
import com.groupon.v3.view.GrouponSwipeRefreshLayoutV3;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.v3.util:
//            ScrollEventRecyclerView

public class ScrollToolBarHelperV3
{
    protected class ListScrollListener
        implements ScrollChangeListener
    {

        final ScrollToolBarHelperV3 this$0;

        public void onScrollDelta(float f)
        {
            scrollToolbar(f);
        }

        public void onScrollFinish(float f)
        {
            snapToolBar(f);
        }

        protected ListScrollListener()
        {
            this$0 = ScrollToolBarHelperV3.this;
            super();
        }
    }

    protected class SwipeRefreshController
        implements SwipeRefreshManager
    {

        final ScrollToolBarHelperV3 this$0;

        public boolean canSwipeRefresh()
        {
            boolean flag;
            if (fragmentContent.getY() == (float)(tabs.getHeight() + toolbar.getHeight()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        }

        protected SwipeRefreshController()
        {
            this$0 = ScrollToolBarHelperV3.this;
            super();
        }
    }


    private static final float EPSILON = 0.01F;
    private static final int HEADER_HIDE_ANIM_DURATION = 300;
    private View fragmentContent;
    private GrouponViewPager pager;
    private PagerSlidingTabStrip tabs;
    private Toolbar toolbar;

    public ScrollToolBarHelperV3()
    {
    }

    public ScrollToolBarHelperV3 initToolBar(Carousel carousel, Fragment fragment)
    {
        pager = (GrouponViewPager)carousel.findViewById(0x7f1000ad);
        toolbar = (Toolbar)carousel.findViewById(0x7f100180);
        tabs = (PagerSlidingTabStrip)carousel.findViewById(0x7f1000a9);
        fragmentContent = fragment.getView().findViewById(0x7f1000da);
        fragmentContent.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ScrollToolBarHelperV3 this$0;

            public void onGlobalLayout()
            {
                fragmentContent.setY(toolbar.getY() + (float)toolbar.getHeight() + (float)tabs.getHeight());
                fragmentContent.setPadding(0, 0, 0, tabs.getHeight());
                fragmentContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }

            
            {
                this$0 = ScrollToolBarHelperV3.this;
                super();
            }
        });
        setRecyclerView((ScrollEventRecyclerView)fragment.getView().findViewById(0x7f1000dc));
        setSwipeRefresh((GrouponSwipeRefreshLayoutV3)fragment.getView().findViewById(0x7f1000db));
        return this;
    }

    protected void scrollToolbar(float f)
    {
        float f1 = toolbar.getY();
        float f4 = toolbar.getHeight();
        float f3 = tabs.getHeight();
        if (f == 0.0F)
        {
            return;
        }
        float f2;
        if (f > 0.0F)
        {
            f1 -= f;
        } else
        {
            f1 += f * -1F;
        }
        if (f1 < f4 * -1F)
        {
            f2 = f4 * -1F;
        } else
        {
            f2 = f1;
            if (f1 > 0.0F)
            {
                f2 = 0.0F;
            }
        }
        toolbar.setY(f2);
        f1 = f2 + f4;
        if (Math.abs(f1 - f4) >= 0.01F && Math.abs(f1) >= 0.01F)
        {
            tabs.setY(f1 - 1.0F);
        } else
        {
            tabs.setY(f1);
        }
        f1 = fragmentContent.getY();
        if (f > 0.0F)
        {
            f1 -= f;
            f = f1;
            if (f1 < f3)
            {
                f = f3;
            }
            setAllFragmentY(f);
            return;
        }
        f1 += -1F * f;
        f2 = f4 + f3;
        f = f1;
        if (f1 > f2)
        {
            f = f2;
        }
        setAllFragmentY(f);
    }

    protected void setAllFragmentY(float f)
    {
        for (int i = 0; i < pager.getChildCount(); i++)
        {
            View view = pager.getChildAt(i);
            if (view == null)
            {
                continue;
            }
            view = view.findViewById(0x7f1000da);
            if (view != null)
            {
                view.setY(f);
            }
        }

    }

    public ScrollToolBarHelperV3 setRecyclerView(ScrollEventRecyclerView scrolleventrecyclerview)
    {
        if (scrolleventrecyclerview != null)
        {
            scrolleventrecyclerview.setOnScrollDelta(new ListScrollListener());
        }
        return this;
    }

    public ScrollToolBarHelperV3 setSwipeRefresh(GrouponSwipeRefreshLayoutV3 grouponswiperefreshlayoutv3)
    {
        if (grouponswiperefreshlayoutv3 != null)
        {
            grouponswiperefreshlayoutv3.setSwipeRefreshManager(new SwipeRefreshController());
        }
        return this;
    }

    public void snapDown()
    {
        if (toolbar != null && tabs != null && toolbar.getHeight() > 0)
        {
            toolbar.animate().translationY(0.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator()).start();
            tabs.animate().translationY(toolbar.getHeight()).setDuration(300L).setInterpolator(new DecelerateInterpolator()).start();
        }
    }

    protected void snapToolBar(float f)
    {
        int i;
        int j;
        i = toolbar.getHeight() / 2;
        j = tabs.getHeight();
        if (f < 0.0F)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (toolbar.getY() >= (float)(i * -1) || fragmentContent.getY() != (float)j) goto _L2; else goto _L1
_L1:
        snapUp();
_L4:
        return;
_L2:
        if (tabs.getY() <= 0.0F) goto _L4; else goto _L3
_L3:
        snapDown();
        return;
        snapDown();
        return;
    }

    public void snapUp()
    {
        if (toolbar != null && tabs != null && toolbar.getHeight() > 0)
        {
            toolbar.animate().translationY(toolbar.getHeight() * -1).setDuration(300L).setInterpolator(new DecelerateInterpolator()).start();
            tabs.animate().translationY(0.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator()).start();
        }
    }



}

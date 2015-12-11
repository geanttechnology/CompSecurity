// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import com.groupon.activity.Carousel;
import com.groupon.view.GrouponSwipeRefreshLayout;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.util:
//            ScrollEventListView, ScrollChangeListener, SwipeRefreshManager

public class ScrollToolBarHelper
{
    protected class ListScrollListener
        implements ScrollChangeListener
    {

        final ScrollToolBarHelper this$0;

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
            this$0 = ScrollToolBarHelper.this;
            super();
        }
    }

    public static interface OnToolBarInitializeListener
    {

        public abstract void onToolBarInitialized();
    }

    public static interface OnToolBarSnapDownListener
    {

        public abstract void onSnapDown();
    }

    protected class SwipeRefreshController
        implements SwipeRefreshManager
    {

        final ScrollToolBarHelper this$0;

        public boolean canSwipeRefresh()
        {
            return fragmentContent.getY() == (float)(tabs.getHeight() + toolbar.getHeight());
        }

        protected SwipeRefreshController()
        {
            this$0 = ScrollToolBarHelper.this;
            super();
        }
    }


    private static final float EPSILON = 0.01F;
    private static final int HEADER_HIDE_ANIM_DURATION = 300;
    private View fragmentContent;
    private GrouponViewPager pager;
    private PagerSlidingTabStrip tabs;
    private Toolbar toolbar;

    public ScrollToolBarHelper()
    {
    }

    public float getTabsBarScreenHeight()
    {
        if (tabs != null)
        {
            return (float)tabs.getHeight();
        } else
        {
            return 0.0F;
        }
    }

    public float getToolBarScreenHeight()
    {
        if (toolbar != null)
        {
            return (float)toolbar.getHeight() + toolbar.getTranslationY();
        } else
        {
            return 0.0F;
        }
    }

    public ScrollToolBarHelper initToolBar(Carousel carousel, final Fragment fragment)
    {
        pager = (GrouponViewPager)carousel.findViewById(0x7f1000ad);
        toolbar = (Toolbar)carousel.findViewById(0x7f100180);
        tabs = (PagerSlidingTabStrip)carousel.findViewById(0x7f1000a9);
        fragmentContent = fragment.getView().findViewById(0x7f1000da);
        fragmentContent.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final ScrollToolBarHelper this$0;
            final Fragment val$fragment;

            public void onGlobalLayout()
            {
                fragmentContent.setY(toolbar.getY() + (float)toolbar.getHeight() + (float)tabs.getHeight());
                fragmentContent.setPadding(0, 0, 0, tabs.getHeight());
                if (fragment instanceof OnToolBarInitializeListener)
                {
                    ((OnToolBarInitializeListener)fragment).onToolBarInitialized();
                }
                fragmentContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }

            
            {
                this$0 = ScrollToolBarHelper.this;
                fragment = fragment1;
                super();
            }
        });
        setListView((ListView)fragment.getView().findViewById(0x102000a));
        setSwipeRefresh((GrouponSwipeRefreshLayout)fragment.getView().findViewById(0x7f1000db));
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

    public ScrollToolBarHelper setListView(ListView listview)
    {
        if (listview != null && (listview instanceof ScrollEventListView))
        {
            ((ScrollEventListView)listview).setOnScrollDelta(new ListScrollListener());
        }
        return this;
    }

    public ScrollToolBarHelper setSwipeRefresh(GrouponSwipeRefreshLayout grouponswiperefreshlayout)
    {
        if (grouponswiperefreshlayout != null)
        {
            grouponswiperefreshlayout.setSwipeRefreshManager(new SwipeRefreshController());
        }
        return this;
    }

    public void snapDown(final OnToolBarSnapDownListener listener)
    {
        if (toolbar != null && tabs != null)
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(toolbar, "translationY", new float[] {
                0.0F
            });
            ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(tabs, "translationY", new float[] {
                (float)toolbar.getHeight()
            });
            final AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[] {
                objectanimator, objectanimator1
            });
            animatorSet.setDuration(300L);
            animatorSet.setInterpolator(new DecelerateInterpolator());
            if (listener != null)
            {
                animatorSet.addListener(new android.animation.Animator.AnimatorListener() {

                    final ScrollToolBarHelper this$0;
                    final AnimatorSet val$animatorSet;
                    final OnToolBarSnapDownListener val$listener;

                    public void onAnimationCancel(Animator animator)
                    {
                        listener.onSnapDown();
                        animatorSet.removeListener(this);
                    }

                    public void onAnimationEnd(Animator animator)
                    {
                        listener.onSnapDown();
                        animatorSet.removeListener(this);
                    }

                    public void onAnimationRepeat(Animator animator)
                    {
                    }

                    public void onAnimationStart(Animator animator)
                    {
                    }

            
            {
                this$0 = ScrollToolBarHelper.this;
                listener = ontoolbarsnapdownlistener;
                animatorSet = animatorset;
                super();
            }
                });
            }
            animatorSet.start();
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
            break MISSING_BLOCK_LABEL_75;
        }
        if (toolbar.getY() >= (float)(i * -1) || fragmentContent.getY() != (float)j) goto _L2; else goto _L1
_L1:
        snapUp();
_L4:
        return;
_L2:
        if (tabs.getY() <= 0.0F) goto _L4; else goto _L3
_L3:
        snapDown(null);
        return;
        snapDown(null);
        return;
    }

    public void snapUp()
    {
        if (toolbar != null && tabs != null)
        {
            toolbar.animate().translationY(toolbar.getHeight() * -1).setDuration(300L).setInterpolator(new DecelerateInterpolator()).start();
            tabs.animate().translationY(0.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator()).start();
        }
    }



}

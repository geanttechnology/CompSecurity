// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.astuetz.PagerSlidingTabStrip;
import com.target.ui.e.a;
import com.target.ui.e.e;
import com.target.ui.e.f;
import com.target.ui.util.ah;
import com.target.ui.util.al;
import com.target.ui.util.q;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.common:
//            BaseNavigationFragment

public abstract class TabbedFragment extends BaseNavigationFragment
    implements f
{
    static class Views extends com.target.ui.view.a
    {

        PagerSlidingTabStrip pagerSlidingTabStrip;
        View tabStripWrapper;
        ViewPager viewPager;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(float f1);
    }

    public static class b
    {

        private static final long ID_UNSET = 0x8000000000000000L;
        private final Fragment mFragment;
        private final String mLabel;
        private final long mUniqueId;

        public Fragment a()
        {
            return mFragment;
        }

        public String b()
        {
            return mLabel;
        }

        public long c()
        {
            return mUniqueId;
        }

        public b(Fragment fragment, String s)
        {
            this(fragment, s, 0x8000000000000000L);
        }

        public b(Fragment fragment, String s, long l1)
        {
            mLabel = s;
            mFragment = fragment;
            mUniqueId = l1;
        }
    }

    public static class c extends j
    {

        private final List mItems;

        public int a(Object obj)
        {
            for (Iterator iterator = mItems.iterator(); iterator.hasNext();)
            {
                if (((b)iterator.next()).a() == obj)
                {
                    return -1;
                }
            }

            return -2;
        }

        public Fragment a(int i1)
        {
            Fragment fragment = ((b)mItems.get(i1)).a();
            try
            {
                BaseNavigationFragment basenavigationfragment = (BaseNavigationFragment)fragment;
                basenavigationfragment.m(false);
                basenavigationfragment.n(false);
                basenavigationfragment.h(2);
            }
            catch (ClassCastException classcastexception)
            {
                throw new ClassCastException((new StringBuilder()).append(fragment.toString()).append(" must subclass ").append("BaseNavigationFragment to be used with TabbedFragment").toString());
            }
            return fragment;
        }

        public void a(b b1, int i1)
        {
            if (i1 >= mItems.size())
            {
                com.target.ui.util.q.a(TabbedFragment.TAG, (new StringBuilder()).append("Invalid index ").append(i1).append(", unable to replace fragment").toString());
                return;
            } else
            {
                mItems.remove(i1);
                mItems.add(i1, b1);
                c();
                return;
            }
        }

        public int b()
        {
            return mItems.size();
        }

        public long b(int i1)
        {
            b b1 = (b)mItems.get(i1);
            if (b1.c() == 0x8000000000000000L)
            {
                return (long)i1;
            } else
            {
                return b1.c();
            }
        }

        public CharSequence c(int i1)
        {
            return ((b)mItems.get(i1)).b();
        }

        public c(h h1, List list)
        {
            super(h1);
            mItems = list;
        }
    }


    private static final int TAB_ANIMATION_DURATION_MS = 200;
    public static final String TAG = com/target/ui/fragment/common/TabbedFragment.getSimpleName();
    private static final int VIEW_PAGER_DEFAULT_SELECTION = 0;
    private static final int VIEW_PAGER_OFF_SCREEN_LIMIT = 2;
    private c mAdapter;
    private int mCurrentTranslationForScroll;
    private boolean mForcedDownAnimating;
    private Animator mScrollingTabAnimator;
    private int mTabHeight;
    private Boolean mTabStripVisible;
    private boolean mViewPagerScrollStateIdle;
    private Views mViews;

    public TabbedFragment()
    {
        mForcedDownAnimating = false;
        mViewPagerScrollStateIdle = true;
        mTabStripVisible = Boolean.valueOf(true);
    }

    static Views a(TabbedFragment tabbedfragment)
    {
        return tabbedfragment.mViews;
    }

    private void a()
    {
        a(false);
    }

    private void a(boolean flag)
    {
        int i1 = mViews.pagerSlidingTabStrip.getHeight();
        float f2 = mViews.tabStripWrapper.getTranslationY();
        if (mScrollingTabAnimator != null)
        {
            mScrollingTabAnimator.cancel();
        }
        float f1 = -i1;
        boolean flag1;
        boolean flag2;
        if (mCurrentTranslationForScroll > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (Float.compare(f2, (float)(-i1) * 0.5F) > 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag || flag2 || flag1)
        {
            f1 = 0.0F;
        }
        mScrollingTabAnimator = ObjectAnimator.ofFloat(mViews.tabStripWrapper, View.TRANSLATION_Y, new float[] {
            f2, f1
        });
        mScrollingTabAnimator.setDuration(200L);
        mScrollingTabAnimator.addListener(new AnimatorListenerAdapter() {

            final TabbedFragment this$0;

            public void onAnimationCancel(Animator animator)
            {
                com.target.ui.fragment.common.TabbedFragment.a(TabbedFragment.this, false);
            }

            public void onAnimationEnd(Animator animator)
            {
                com.target.ui.fragment.common.TabbedFragment.a(TabbedFragment.this, false);
            }

            
            {
                this$0 = TabbedFragment.this;
                super();
            }
        });
        mScrollingTabAnimator.start();
        mForcedDownAnimating = flag;
        mCurrentTranslationForScroll = 0;
    }

    static boolean a(TabbedFragment tabbedfragment, boolean flag)
    {
        tabbedfragment.mForcedDownAnimating = flag;
        return flag;
    }

    static void b(TabbedFragment tabbedfragment)
    {
        tabbedfragment.n();
    }

    private boolean b()
    {
        return g() && mTabStripVisible.booleanValue();
    }

    static boolean b(TabbedFragment tabbedfragment, boolean flag)
    {
        tabbedfragment.mViewPagerScrollStateIdle = flag;
        return flag;
    }

    private void c(int i1)
    {
        float f1;
        float f2;
        float f3;
        f1 = 0.0F;
        f2 = -Math.round(i1);
        f3 = mViews.tabStripWrapper.getTranslationY();
        f2 += f3;
        if (Float.compare(f2, -mTabHeight) >= 0) goto _L2; else goto _L1
_L1:
        f1 = -mTabHeight;
_L4:
        mCurrentTranslationForScroll = (int)((float)mCurrentTranslationForScroll + (f1 - f3));
        mViews.tabStripWrapper.setTranslationY(f1);
        n();
        return;
_L2:
        if (Float.compare(f2, 0.0F) <= 0)
        {
            f1 = f2;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void c(boolean flag)
    {
        mTabStripVisible = Boolean.valueOf(flag);
        l();
        mViews.tabStripWrapper.setTranslationY(0.0F);
        if (flag)
        {
            al.b(mViews.pagerSlidingTabStrip);
            return;
        } else
        {
            al.c(mViews.pagerSlidingTabStrip);
            return;
        }
    }

    private void k()
    {
        if (mAdapter != null)
        {
            return;
        } else
        {
            mAdapter = new c(getChildFragmentManager(), c());
            return;
        }
    }

    private void l()
    {
        if (!mTabStripVisible.booleanValue())
        {
            mViews.viewPager.setPadding(0, 0, 0, 0);
            return;
        }
        if (b())
        {
            mViews.viewPager.setPadding(0, 0, 0, 0);
            return;
        } else
        {
            mViews.viewPager.setPadding(0, mTabHeight, 0, 0);
            return;
        }
    }

    private void n()
    {
        if (getChildFragmentManager().f() == null)
        {
            com.target.ui.util.q.a(TAG, "Attempted to use null fragment list when updating offset listeners");
        } else
        {
            float f1 = mViews.tabStripWrapper.getTranslationY();
            Iterator iterator = getChildFragmentManager().f().iterator();
            while (iterator.hasNext()) 
            {
                Fragment fragment = (Fragment)iterator.next();
                if (fragment instanceof a)
                {
                    ((a)fragment).a(f1);
                }
            }
        }
    }

    private void o()
    {
        mViews.pagerSlidingTabStrip.a(ah.a(getActivity(), com.target.ui.util.ah.a.REGULAR), 0);
        mViews.pagerSlidingTabStrip.setViewPager(mViews.viewPager);
        mViews.pagerSlidingTabStrip.setOnPageChangeListener(new android.support.v4.view.ViewPager.f() {

            final TabbedFragment this$0;

            public void a(int i1)
            {
                if (com.target.ui.fragment.common.TabbedFragment.a(TabbedFragment.this) == null)
                {
                    return;
                } else
                {
                    TabbedFragment.this.a(i1);
                    TabbedFragment.b(TabbedFragment.this);
                    return;
                }
            }

            public void a(int i1, float f1, int j1)
            {
            }

            public void b(int i1)
            {
                boolean flag = true;
                if (i1 == 1)
                {
                    h();
                }
                TabbedFragment tabbedfragment = TabbedFragment.this;
                if (i1 != 0)
                {
                    flag = false;
                }
                TabbedFragment.b(tabbedfragment, flag);
            }

            
            {
                this$0 = TabbedFragment.this;
                super();
            }
        });
        if (mAdapter.b() < 2)
        {
            c(false);
        }
    }

    private void p()
    {
        mViews.viewPager.setCurrentItem(d());
    }

    private void q()
    {
        mViews.viewPager.setAdapter(mAdapter);
        mViews.viewPager.setOffscreenPageLimit(2);
        l();
    }

    protected void a(int i1)
    {
    }

    protected void a(b b1, int i1)
    {
        mAdapter.a(b1, i1);
    }

    public boolean a(e e1)
    {
        if (mViews == null)
        {
            return false;
        }
        Fragment fragment = j();
        boolean flag;
        if (fragment != null && (fragment instanceof com.target.ui.e.a) && ((com.target.ui.e.a)fragment).a(e1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public void b(int i1)
    {
        if (!mForcedDownAnimating)
        {
            if (mScrollingTabAnimator != null)
            {
                mScrollingTabAnimator.cancel();
                mScrollingTabAnimator = null;
            }
            if (b())
            {
                if (mViewPagerScrollStateIdle)
                {
                    c(i1);
                    return;
                } else
                {
                    a();
                    return;
                }
            }
        }
    }

    protected abstract List c();

    protected int d()
    {
        return 0;
    }

    public int e()
    {
        return mTabHeight;
    }

    public void f()
    {
        while (mForcedDownAnimating || !b()) 
        {
            return;
        }
        a();
    }

    protected boolean g()
    {
        return false;
    }

    public void h()
    {
        a(true);
    }

    protected List i()
    {
        List list1 = getChildFragmentManager().f();
        List list = list1;
        if (list1 == null)
        {
            list = Collections.emptyList();
        }
        return list;
    }

    protected Fragment j()
    {
        List list = getChildFragmentManager().f();
        if (list == null)
        {
            return null;
        } else
        {
            return (Fragment)list.get(mViews.viewPager.getCurrentItem());
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mTabHeight = getResources().getDimensionPixelSize(0x7f0a02ca);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        n(false);
        k();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03008a, viewgroup, false);
        mViews = new Views(layoutinflater);
        q();
        o();
        p();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mAdapter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mViews = null;
    }

}

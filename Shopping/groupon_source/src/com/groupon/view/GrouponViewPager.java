// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.groupon.Channel;
import com.groupon.adapter.CarouselFragmentPagerAdapter;
import com.groupon.util.OnInterceptTouchEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class GrouponViewPager extends ViewPager
{
    protected static class OnPageChangeListenerGroup
        implements android.support.v4.view.ViewPager.OnPageChangeListener
    {

        private ArrayList pageListeners;

        public void addOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
        {
            pageListeners.add(onpagechangelistener);
        }

        public void onPageScrollStateChanged(int i)
        {
            for (Iterator iterator = pageListeners.iterator(); iterator.hasNext(); ((android.support.v4.view.ViewPager.OnPageChangeListener)iterator.next()).onPageScrollStateChanged(i)) { }
        }

        public void onPageScrolled(int i, float f, int j)
        {
            for (Iterator iterator = pageListeners.iterator(); iterator.hasNext(); ((android.support.v4.view.ViewPager.OnPageChangeListener)iterator.next()).onPageScrolled(i, f, j)) { }
        }

        public void onPageSelected(int i)
        {
            for (Iterator iterator = pageListeners.iterator(); iterator.hasNext(); ((android.support.v4.view.ViewPager.OnPageChangeListener)iterator.next()).onPageSelected(i)) { }
        }

        protected OnPageChangeListenerGroup()
        {
            pageListeners = new ArrayList();
        }
    }


    private OnInterceptTouchEvent onInterceptTouchEvent;
    private OnPageChangeListenerGroup onPageChangeListeners;
    private boolean pagingEnabled;

    public GrouponViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        onPageChangeListeners = new OnPageChangeListenerGroup();
        pagingEnabled = true;
        setOnPageChangeListener(onPageChangeListeners);
    }

    private String makeFragmentName(int i, int j)
    {
        return (new StringBuilder()).append("android:switcher:").append(i).append(":").append(j).toString();
    }

    public void addOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        onPageChangeListeners.addOnPageChangeListener(onpagechangelistener);
    }

    public Fragment findFragmentByPositionIfAvailable(int i)
    {
        return ((Activity)getContext()).getFragmentManager().findFragmentByTag(makeFragmentName(getId(), i));
    }

    public Fragment getCurrentFragment()
    {
        return findFragmentByPositionIfAvailable(getCurrentItem());
    }

    public boolean isSelected(Channel channel)
    {
        return ((CarouselFragmentPagerAdapter)getAdapter()).getChannel(getCurrentItem()) == channel;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (onInterceptTouchEvent != null)
        {
            onInterceptTouchEvent.onInterceptTouchEvent(motionevent);
        }
        return pagingEnabled && super.onInterceptTouchEvent(motionevent);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return pagingEnabled && super.onTouchEvent(motionevent);
    }

    public void removeOnInterceptTouchEvent()
    {
        onInterceptTouchEvent = null;
    }

    public void setOnInterceptTouchEvent(OnInterceptTouchEvent onintercepttouchevent)
    {
        onInterceptTouchEvent = onintercepttouchevent;
    }

    public void setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        super.setOnPageChangeListener(onpagechangelistener);
    }

    public void setPagingEnabled(boolean flag)
    {
        pagingEnabled = flag;
    }
}

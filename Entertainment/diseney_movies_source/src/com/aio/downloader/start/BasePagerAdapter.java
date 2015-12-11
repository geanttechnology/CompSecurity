// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.start;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class BasePagerAdapter extends PagerAdapter
{

    private List views;

    public BasePagerAdapter(List list)
    {
        views = new ArrayList();
        views = list;
    }

    public void destroyItem(View view, int i, Object obj)
    {
        ((ViewPager)view).removeView((View)views.get(i));
    }

    public int getCount()
    {
        return views.size();
    }

    public Object instantiateItem(View view, int i)
    {
        ((ViewPager)view).addView((View)views.get(i));
        return views.get(i);
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}

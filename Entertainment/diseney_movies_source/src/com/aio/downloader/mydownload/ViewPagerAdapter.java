// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.mydownload;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter
{

    public List mListViews;

    public ViewPagerAdapter(List list)
    {
        mListViews = list;
    }

    public void destroyItem(View view, int i, Object obj)
    {
        ((ViewPager)view).removeView((View)mListViews.get(i));
    }

    public int getCount()
    {
        return mListViews.size();
    }

    public Object instantiateItem(View view, int i)
    {
        ((ViewPager)view).addView((View)mListViews.get(i), 0);
        return mListViews.get(i);
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}

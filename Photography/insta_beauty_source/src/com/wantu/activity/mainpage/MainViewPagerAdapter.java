// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.mainpage;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import biv;

// Referenced classes of package com.wantu.activity.mainpage:
//            ViewMainPage1, ViewMainPage2

public class MainViewPagerAdapter extends PagerAdapter
{

    Context a;
    ViewMainPage1 b;
    ViewMainPage2 c;
    biv d;
    Activity e;
    int f;
    int g;

    public MainViewPagerAdapter(Context context)
    {
        a = context;
    }

    public void a(int i, int j)
    {
        g = i;
        f = j;
    }

    public void a(Activity activity)
    {
        e = activity;
    }

    public void a(biv biv)
    {
        d = biv;
    }

    public void destroyItem(View view, int i, Object obj)
    {
        if (i == 0 && b != null)
        {
            ((ViewPager)view).removeView(b);
        }
        if (i == 1 && c != null)
        {
            ((ViewPager)view).removeView(c);
        }
    }

    public int getCount()
    {
        return 1;
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public Object instantiateItem(View view, int i)
    {
        ViewMainPage1 viewmainpage1 = null;
        if (i == 0)
        {
            if (b == null)
            {
                b = new ViewMainPage1(a, null);
                b.setOnClickListener(d);
                b.resize(f, g);
            }
            ((ViewPager)view).addView(b, 0);
            viewmainpage1 = b;
        } else
        if (i == 1)
        {
            if (c == null)
            {
                c = new ViewMainPage2(a, null);
                c.setOnClickListener(d);
                c.resize(f, g);
            }
            ((ViewPager)view).addView(c, 0);
            return c;
        }
        return viewmainpage1;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.mainViewPager;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import sl;

// Referenced classes of package com.pipcamera.activity.mainViewPager:
//            ViewMainPage1

public class MainViewPagerAdapter extends PagerAdapter
{

    Context a;
    ViewMainPage1 b;
    sl c;
    Activity d;

    public MainViewPagerAdapter(Context context)
    {
        a = context;
    }

    public void a(Activity activity)
    {
        d = activity;
    }

    public void a(sl sl)
    {
        c = sl;
    }

    public void a(boolean flag)
    {
        if (b != null)
        {
            b.setHasMaterialNew(flag);
        }
    }

    public void destroyItem(View view, int i, Object obj)
    {
        if (i == 0 && b != null)
        {
            ((ViewPager)view).removeView(b);
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
        Object obj = null;
        if (i == 0)
        {
            if (b == null)
            {
                b = new ViewMainPage1(a, null);
                b.setOnClickListener(c);
                obj = b.getClassicItem();
                d.registerForContextMenu(((View) (obj)));
            }
            ((ViewPager)view).addView(b, 0);
            obj = b;
        }
        return obj;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}

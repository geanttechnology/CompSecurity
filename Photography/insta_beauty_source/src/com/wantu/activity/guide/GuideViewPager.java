// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.guide;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import java.util.List;

// Referenced classes of package com.wantu.activity.guide:
//            GuideView

public class GuideViewPager extends PagerAdapter
{

    private List a;

    public GuideViewPager(List list)
    {
        a = list;
    }

    public void a()
    {
        for (int i = 0; i < a.size(); i++)
        {
            ((GuideView)a.get(i)).recycleBGResource();
        }

    }

    public void destroyItem(View view, int i, Object obj)
    {
        ((GuideView)a.get(i)).recycleBGResource();
        Log.i("removeView", (new StringBuilder()).append("...remove   ").append(i).toString());
        ((ViewPager)view).removeView((View)a.get(i));
    }

    public void finishUpdate(View view)
    {
    }

    public int getCount()
    {
        if (a != null)
        {
            return a.size();
        } else
        {
            return 0;
        }
    }

    public Object instantiateItem(View view, int i)
    {
        Log.i("addView", (new StringBuilder()).append("...").append(i).toString());
        try
        {
            GuideView guideview = (GuideView)a.get(i);
            guideview.refreshBgView();
            ((ViewPager)view).addView(guideview, 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        return a.get(i);
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classloader)
    {
    }

    public Parcelable saveState()
    {
        return null;
    }

    public void startUpdate(View view)
    {
    }
}

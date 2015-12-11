// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.bestbuy.android.api.lib.models.offers.Offer;
import com.bestbuy.android.bbyobjects.BBYLEPromoPager;
import java.util.ArrayList;
import java.util.List;

public class kd extends PagerAdapter
{

    final BBYLEPromoPager a;
    private ArrayList b;
    private int c;
    private Context d;

    public kd(BBYLEPromoPager bbylepromopager, Context context, ViewPager viewpager, List list)
    {
        a = bbylepromopager;
        super();
        d = context;
        b = (ArrayList)list;
        c = list.size() + 2;
        context = (Offer)list.get(0);
        list.add(0, (Offer)list.get(list.size() - 1));
        list.add(context);
        viewpager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener(bbylepromopager, viewpager) {

            final BBYLEPromoPager a;
            final ViewPager b;
            final kd c;

            public void onPageScrollStateChanged(int i)
            {
                if (i != 0) goto _L2; else goto _L1
_L1:
                int j;
                i = b.getCurrentItem();
                j = b.getAdapter().getCount() - 2;
                if (i != 0) goto _L4; else goto _L3
_L3:
                b.setCurrentItem(j, false);
_L6:
                return;
_L4:
                if (i > j)
                {
                    b.setCurrentItem(1, false);
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (i == 1)
                {
                    BBYLEPromoPager.a(false);
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public void onPageScrolled(int i, float f, int j)
            {
            }

            public void onPageSelected(int i)
            {
            }

            
            {
                c = kd.this;
                a = bbylepromopager;
                b = viewpager;
                super();
            }
        });
    }

    public void destroyItem(View view, int i, Object obj)
    {
        ((ViewPager)view).removeView((View)obj);
    }

    public void finishUpdate(View view)
    {
    }

    public int getCount()
    {
        return c;
    }

    public Object instantiateItem(View view, int i)
    {
        return a.a(d, view, i, b);
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (View)obj;
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

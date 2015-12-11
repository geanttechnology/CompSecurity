// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.offers.Offer;
import com.bestbuy.android.bbyobjects.BBYPromoPager;
import java.util.ArrayList;
import java.util.List;

public class kg extends PagerAdapter
{

    final BBYPromoPager a;
    private ArrayList b;
    private int c;
    private Context d;

    public kg(BBYPromoPager bbypromopager, Context context, ViewPager viewpager, List list)
    {
        a = bbypromopager;
        super();
        d = context;
        b = (ArrayList)list;
        c = list.size() + 2;
        Offer offer = (Offer)list.get(0);
        list.add(0, (Offer)list.get(list.size() - 1));
        list.add(offer);
        viewpager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener(bbypromopager, context, viewpager) {

            final BBYPromoPager a;
            final Context b;
            final ViewPager c;
            final kg d;

            public void onPageScrollStateChanged(int i)
            {
                if (!(b instanceof HomeActivity)) goto _L2; else goto _L1
_L1:
                if (i != 0) goto _L4; else goto _L3
_L3:
                int j;
                i = c.getCurrentItem();
                j = c.getAdapter().getCount() - 2;
                if (i != 0) goto _L6; else goto _L5
_L5:
                c.setCurrentItem(j, false);
_L9:
                ((HomeActivity)b).reEnablePullDown();
_L2:
                return;
_L6:
                if (i > j)
                {
                    c.setCurrentItem(1, false);
                }
                continue; /* Loop/switch isn't completed */
_L4:
                if (i != 1) goto _L2; else goto _L7
_L7:
                BBYPromoPager.a(false);
                ((HomeActivity)b).disablePullDown();
                return;
                if (true) goto _L9; else goto _L8
_L8:
            }

            public void onPageScrolled(int i, float f, int j)
            {
            }

            public void onPageSelected(int i)
            {
            }

            
            {
                d = kg.this;
                a = bbypromopager;
                b = context;
                c = viewpager;
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.pages.librarypicker.PickedFragment;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.r;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view.TouchImageView;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage:
//            TouchViewPager

public class b extends PagerAdapter
{

    private ArrayList a;
    private LibraryPickerActivity b;
    private TouchViewPager c;
    private ExecutorService d;
    private android.view.View.OnClickListener e;

    public b(Activity activity, long al[], TouchViewPager touchviewpager)
    {
        e = new android.view.View.OnClickListener() {

            final b a;

            public void onClick(View view)
            {
                view = (TouchImageView)view;
                if (view.getImageId() != -1L && b.a(a).j() != null && b.a(a).j().d() && b.a(a).b(1))
                {
                    PickedFragment pickedfragment = (PickedFragment)b.a(a).getFragmentManager().findFragmentById(0x7f0c0157);
                    if (pickedfragment != null)
                    {
                        pickedfragment.a(view.getImageId());
                    }
                }
            }

            
            {
                a = b.this;
                super();
            }
        };
        b = (LibraryPickerActivity)activity;
        a = new ArrayList();
        for (int i = 0; i < al.length; i++)
        {
            a.add(Long.valueOf(al[i]));
        }

        c = touchviewpager;
        d = Executors.newFixedThreadPool(1);
    }

    static LibraryPickerActivity a(b b1)
    {
        return b1.b;
    }

    public int a(ViewPager viewpager, int i)
    {
        viewpager.setAdapter(null);
        a.remove(i);
        viewpager.setAdapter(this);
        return i;
    }

    public long a()
    {
        int i = c.getCurrentItem();
        if (i < a.size() && i >= 0)
        {
            return ((Long)a.get(i)).longValue();
        } else
        {
            return -1L;
        }
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return a.size();
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        View view = b.getLayoutInflater().inflate(0x7f03020a, null);
        long l = ((Long)a.get(i)).longValue();
        TouchImageView touchimageview = (TouchImageView)view.findViewById(0x7f0c08e5);
        touchimageview.setImageId(l);
        touchimageview.setOnClickListener(e);
        if (com.cyberlink.youcammakeup.c.f().g(l) != null)
        {
            (new r(touchimageview, l)).a(d, new Void[0]);
        }
        ((ViewPager)viewgroup).addView(view, 0);
        c.b = touchimageview;
        return view;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == (View)obj;
    }
}

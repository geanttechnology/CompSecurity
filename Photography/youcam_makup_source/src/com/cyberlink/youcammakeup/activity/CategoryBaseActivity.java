// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.NetworkBaseActivity;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.pages.moreview.BeautyCategoryItem;
import com.cyberlink.youcammakeup.pages.moreview.a;
import com.cyberlink.youcammakeup.pages.moreview.b;
import com.cyberlink.youcammakeup.pages.moreview.c;
import com.cyberlink.youcammakeup.pages.moreview.f;
import com.cyberlink.youcammakeup.pages.moreview.j;
import com.cyberlink.youcammakeup.pages.moreview.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CategoryBaseActivity extends NetworkBaseActivity
    implements b, c
{

    private final int a = 1080;
    protected a b;
    protected FrameLayout c;
    protected ArrayList d;
    protected Map e;
    protected android.view.View.OnClickListener f;
    private View g;
    private android.view.View.OnClickListener h;

    public CategoryBaseActivity()
    {
        h = new android.view.View.OnClickListener() {

            final CategoryBaseActivity a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.activity.CategoryBaseActivity.a(a, false);
                a.a(view);
            }

            
            {
                a = CategoryBaseActivity.this;
                super();
            }
        };
        f = new android.view.View.OnClickListener() {

            final CategoryBaseActivity a;

            public void onClick(View view)
            {
                a.b(view);
                a.k();
            }

            
            {
                a = CategoryBaseActivity.this;
                super();
            }
        };
    }

    static void a(CategoryBaseActivity categorybaseactivity, boolean flag)
    {
        categorybaseactivity.c(flag);
    }

    private void c(boolean flag)
    {
        g.setClickable(flag);
    }

    private void l()
    {
        d = new ArrayList();
        e = new HashMap();
        g = m();
        g.setOnClickListener(h);
        c = n();
        k();
    }

    protected void a(long l1, BeautyCategoryItem beautycategoryitem)
    {
    }

    protected void a(View view)
    {
    }

    public void a(BeautyCategoryItem beautycategoryitem)
    {
    }

    protected void b(View view)
    {
    }

    protected void k()
    {
        if (b != null)
        {
            b.b(this);
            b.b();
            b = null;
        }
        b = new f(this, f);
        b.a(this);
        if (NetworkManager.L())
        {
            b.f();
        }
    }

    protected View m()
    {
        return null;
    }

    protected FrameLayout n()
    {
        return null;
    }

    public void o()
    {
        if (b != null && b.c() > 0 && !c())
        {
            runOnUiThread(new Runnable() {

                final CategoryBaseActivity a;

                public void run()
                {
                    Map map = a.b.d();
                    if (map != null && map.size() != 0)
                    {
                        a.c.removeAllViews();
                        a.e.clear();
                        a.d.clear();
                        Object obj = a.b.e();
                        if (obj != null && !((Collection) (obj)).isEmpty())
                        {
                            DisplayMetrics displaymetrics = new DisplayMetrics();
                            a.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                            float f1 = (float)displaymetrics.widthPixels / 1080F;
                            obj = ((Collection) (obj)).iterator();
                            int i = 0;
                            while (((Iterator) (obj)).hasNext()) 
                            {
                                Long long1 = (Long)((Iterator) (obj)).next();
                                if (!a.d.contains(long1))
                                {
                                    Object obj2 = (j)map.get(long1);
                                    Object obj1 = ((j) (obj2)).a();
                                    k k1 = new k();
                                    k1.a = ((k) (obj1)).a * f1;
                                    k1.b = ((k) (obj1)).b * f1;
                                    k1.c = ((k) (obj1)).c * f1;
                                    k1.d = ((k) (obj1)).d * f1;
                                    obj1 = a.b.a(i);
                                    a.a(long1.longValue(), ((BeautyCategoryItem) (obj1)));
                                    ((BeautyCategoryItem) (obj1)).setmThumbClickListener(a);
                                    obj2 = ((j) (obj2)).b();
                                    k k2 = new k();
                                    k2.a = ((k) (obj2)).a * f1;
                                    k2.b = ((k) (obj2)).b * f1;
                                    k2.c = ((k) (obj2)).c * f1;
                                    k2.d = ((k) (obj2)).d * f1;
                                    k1 = ((BeautyCategoryItem) (obj1)).a(k1, k2, f1);
                                    obj2 = new android.widget.FrameLayout.LayoutParams((int)k1.c, (int)k1.d);
                                    obj2.leftMargin = (int)k1.a;
                                    obj2.topMargin = (int)k1.b;
                                    a.c.addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj2)));
                                    a.e.put(long1, obj1);
                                    a.d.add(long1);
                                    i++;
                                }
                            }
                        }
                    }
                }

            
            {
                a = CategoryBaseActivity.this;
                super();
            }
            });
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        l();
    }

    protected void onDestroy()
    {
        if (b != null)
        {
            b.b(this);
            b.b();
            b = null;
        }
        if (d != null)
        {
            d.clear();
            d = null;
        }
        if (e != null)
        {
            e.clear();
            e = null;
        }
        super.onDestroy();
    }
}

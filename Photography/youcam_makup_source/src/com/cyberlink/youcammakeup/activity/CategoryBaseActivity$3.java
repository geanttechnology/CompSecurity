// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.cyberlink.youcammakeup.pages.moreview.BeautyCategoryItem;
import com.cyberlink.youcammakeup.pages.moreview.a;
import com.cyberlink.youcammakeup.pages.moreview.j;
import com.cyberlink.youcammakeup.pages.moreview.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            CategoryBaseActivity

class a
    implements Runnable
{

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
                float f = (float)displaymetrics.widthPixels / 1080F;
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
                        k1.a = ((k) (obj1)).a * f;
                        k1.b = ((k) (obj1)).b * f;
                        k1.c = ((k) (obj1)).c * f;
                        k1.d = ((k) (obj1)).d * f;
                        obj1 = a.b.a(i);
                        a.a(long1.longValue(), ((BeautyCategoryItem) (obj1)));
                        ((BeautyCategoryItem) (obj1)).setmThumbClickListener(a);
                        obj2 = ((j) (obj2)).b();
                        k k2 = new k();
                        k2.a = ((k) (obj2)).a * f;
                        k2.b = ((k) (obj2)).b * f;
                        k2.c = ((k) (obj2)).c * f;
                        k2.d = ((k) (obj2)).d * f;
                        k1 = ((BeautyCategoryItem) (obj1)).a(k1, k2, f);
                        obj2 = new android.widget.s((int)k1.c, (int)k1.d);
                        obj2.leftMargin = (int)k1.a;
                        obj2.topMargin = (int)k1.b;
                        a.c.addView(((android.view.View) (obj1)), ((android.view.CategoryBaseActivity.c) (obj2)));
                        a.e.put(long1, obj1);
                        a.d.add(long1);
                        i++;
                    }
                }
            }
        }
    }

    m(CategoryBaseActivity categorybaseactivity)
    {
        a = categorybaseactivity;
        super();
    }
}

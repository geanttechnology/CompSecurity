// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.perfectcorp.utility.e;
import java.util.LinkedHashMap;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CirclePager

class h extends PagerAdapter
{

    final CirclePager a;

    private h(CirclePager circlepager)
    {
        a = circlepager;
        super();
    }

    h(CirclePager circlepager, CirclePager._cls1 _pcls1)
    {
        this(circlepager);
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        e.b(new Object[] {
            Integer.valueOf(i)
        });
        if (obj instanceof View)
        {
            viewgroup.removeView((View)obj);
        }
    }

    public int getCount()
    {
        return CirclePager.k(a);
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        e.b(new Object[] {
            Integer.valueOf(i)
        });
        return CirclePager.a(a, viewgroup, (List)CirclePager.c(a).get(Integer.valueOf(i)));
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        boolean flag1 = false;
        e.b(new Object[] {
            Integer.valueOf(view.hashCode()), ":", Integer.valueOf(obj.hashCode())
        });
        boolean flag = flag1;
        if (view != null)
        {
            flag = flag1;
            if (obj != null)
            {
                flag = view.equals(obj);
            }
        }
        return flag;
    }
}

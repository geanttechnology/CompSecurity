// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.model.MeADPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p, q

class a extends PagerAdapter
{

    final p a;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        if (obj != null)
        {
            viewgroup.removeView(((q)obj).a());
            if (p.o(a).containsKey(Integer.valueOf(i)))
            {
                p.o(a).remove(Integer.valueOf(i));
            }
        }
    }

    public int getCount()
    {
        return p.z(a).size();
    }

    public int getItemPosition(Object obj)
    {
        if (p.o(a).size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = p.o(a).entrySet().iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        java.util.ntry ntry = (java.util.ntry)iterator.next();
        if (ntry.getValue() != obj) goto _L6; else goto _L5
_L5:
        obj = (Integer)ntry.getKey();
_L8:
        if (obj != null)
        {
            return ((Integer) (obj)).intValue();
        } else
        {
            return -2;
        }
_L2:
        return -2;
_L4:
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        Object obj1 = null;
        android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
        Object obj = obj1;
        if (fragmentactivity != null)
        {
            obj = obj1;
            if (i < p.z(a).size())
            {
                q q1 = (q)p.o(a).get(Integer.valueOf(i));
                obj = q1;
                if (q1 == null)
                {
                    obj = (MeADPager)p.z(a).get(i);
                    obj = new q(a, fragmentactivity, viewgroup, ((MeADPager) (obj)));
                    p.o(a).put(Integer.valueOf(i), obj);
                }
                ((q) (obj)).a(p.e(a), p.h(a), p.f(a));
            }
        }
        return obj;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view.getTag().equals(Integer.valueOf(((q)obj).hashCode()));
    }

    _cls9(p p1)
    {
        a = p1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            u, w, v

class a extends PagerAdapter
{

    final u a;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        if (obj != null)
        {
            viewgroup.removeView(((w)obj).b);
            if (u.e(a).containsKey(Integer.valueOf(i)))
            {
                u.e(a).remove(Integer.valueOf(i));
            }
        }
    }

    public int getCount()
    {
        return u.c(a).size();
    }

    public int getItemPosition(Object obj)
    {
        if (u.e(a).size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = u.e(a).entrySet().iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        java.util.Entry entry = (java.util.Entry)iterator.next();
        if (entry.getValue() != obj) goto _L6; else goto _L5
_L5:
        obj = (Integer)entry.getKey();
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
        Object obj = null;
        android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
        w w1 = obj;
        if (fragmentactivity != null)
        {
            w1 = obj;
            if (i < u.c(a).size())
            {
                w w2 = (w)u.e(a).get(Integer.valueOf(i));
                v v1 = (v)u.c(a).get(i);
                w1 = w2;
                if (w2 == null)
                {
                    w1 = new w(a, fragmentactivity, viewgroup, v1);
                    u.e(a).put(Integer.valueOf(i), w1);
                }
                if (v1.b == null)
                {
                    u.a(a, i, v1);
                }
                w1.a();
            }
        }
        return w1;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view.getTag().equals(Integer.valueOf(((w)obj).hashCode()));
    }

    (u u1)
    {
        a = u1;
        super();
    }
}

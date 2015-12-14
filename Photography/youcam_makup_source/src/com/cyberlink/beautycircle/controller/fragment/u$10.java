// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cyberlink.beautycircle.i;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            u

class a
    implements android.support.v4.view.ager.OnPageChangeListener
{

    final u a;

    public void onPageScrollStateChanged(int j)
    {
        if (j == 0 && u.j(a) == 0 && u.k(a))
        {
            u.a(a, false);
            u.l(a);
        }
    }

    public void onPageScrolled(int j, float f, int k)
    {
    }

    public void onPageSelected(int j)
    {
        if (j < com.cyberlink.beautycircle.controller.fragment.u.i(a).getChildCount())
        {
            Object obj = (Integer)com.cyberlink.beautycircle.controller.fragment.u.i(a).getTag();
            if (obj != null)
            {
                if (((Integer) (obj)).intValue() == j)
                {
                    return;
                }
                obj = (ImageView)com.cyberlink.beautycircle.controller.fragment.u.i(a).getChildAt(((Integer) (obj)).intValue());
                if (obj != null)
                {
                    ((ImageView) (obj)).setImageResource(i.bc_indicator_dot);
                    ((ImageView) (obj)).setSelected(false);
                }
            }
            obj = (ImageView)com.cyberlink.beautycircle.controller.fragment.u.i(a).getChildAt(j);
            if (obj != null)
            {
                ((ImageView) (obj)).setImageResource(i.bc_indicator_dot);
                ((ImageView) (obj)).setSelected(true);
            }
            com.cyberlink.beautycircle.controller.fragment.u.i(a).setTag(Integer.valueOf(j));
        }
        u.b(a, j);
        u.g(a);
    }

    er(u u1)
    {
        a = u1;
        super();
    }
}

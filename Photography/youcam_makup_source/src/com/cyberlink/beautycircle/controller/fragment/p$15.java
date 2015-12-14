// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.cyberlink.beautycircle.i;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements android.support.v4.view.ager.OnPageChangeListener
{

    final p a;

    public void onPageScrollStateChanged(int j)
    {
        if (j == 0 && p.t(a) == 0 && p.u(a))
        {
            p.v(a);
        }
    }

    public void onPageScrolled(int j, float f, int k)
    {
    }

    public void onPageSelected(int j)
    {
        if (j < p.r(a).getChildCount())
        {
            Object obj = (Integer)p.r(a).getTag();
            if (obj != null)
            {
                if (((Integer) (obj)).intValue() == j)
                {
                    return;
                }
                obj = (ImageView)p.r(a).getChildAt(((Integer) (obj)).intValue());
                if (obj != null)
                {
                    ((ImageView) (obj)).setImageResource(i.bc_dot_g);
                }
            }
            obj = (ImageView)p.r(a).getChildAt(j);
            if (obj != null)
            {
                ((ImageView) (obj)).setImageResource(i.bc_dot_n);
            }
            p.r(a).setTag(Integer.valueOf(j));
        }
        p.a(a, j);
        p.s(a);
    }

    er(p p1)
    {
        a = p1;
        super();
    }
}

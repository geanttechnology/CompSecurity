// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.controller.fragment.BottomBarFragment;
import com.cyberlink.beautycircle.controller.fragment.f;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity, e, d

class a
    implements android.support.v4.view.eChangeListener
{

    final MainActivity a;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f1, int j)
    {
    }

    public void onPageSelected(int i)
    {
        if (com.cyberlink.beautycircle.controller.activity.MainActivity.f(a) != MainActivity.g(a))
        {
            MainActivity.h(a);
            MainActivity.b(a, MainActivity.g(a));
        }
        if (i >= 0 && i < MainActivity.i(a).size())
        {
            int j = 0;
            while (j < MainActivity.i(a).size()) 
            {
                Object obj = (e)MainActivity.i(a).get(j);
                if (obj != null)
                {
                    if (i == j)
                    {
                        BottomBarFragment bottombarfragment = a.u();
                        if (bottombarfragment != null)
                        {
                            bottombarfragment.a(((e) (obj)).a);
                            bottombarfragment.a();
                        }
                        if (((e) (obj)).c != null)
                        {
                            ((e) (obj)).c.a();
                        }
                        obj = ((e) (obj)).a();
                        ((f) (obj)).a(i);
                        MainActivity.a(a, a.p);
                        a.p = ((f) (obj));
                        MainActivity.j(a);
                    } else
                    {
                        ((e) (obj)).a().f();
                    }
                }
                j++;
            }
        }
    }

    nt(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.support.v4.view.ViewPager;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.fragment.a;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity, e

class a
    implements a
{

    final MainActivity a;

    public boolean a(com.cyberlink.beautycircle.controller.fragment.nt.Tab tab)
    {
        com.cyberlink.beautycircle.controller.activity.MainActivity.a(a, false, false);
        if (!MainActivity.k(a).isEnabled())
        {
            return false;
        }
        if (tab.name().equalsIgnoreCase(com.cyberlink.beautycircle.controller.fragment.nt.Tab.d.toString()) || tab.name().equalsIgnoreCase(com.cyberlink.beautycircle.controller.fragment.nt.Tab.e.toString()))
        {
            aq.c = tab.name();
        }
        int i = 0;
        do
        {
label0:
            {
                if (i < MainActivity.i(a).size())
                {
                    if (((e)MainActivity.i(a).get(i)).a != tab)
                    {
                        break label0;
                    }
                    MainActivity.c(a, i);
                    MainActivity.k(a).setCurrentItem(i);
                }
                return true;
            }
            i++;
        } while (true);
    }

    nt.Tab(MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}

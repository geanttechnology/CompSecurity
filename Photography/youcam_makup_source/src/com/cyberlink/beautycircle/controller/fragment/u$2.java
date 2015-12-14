// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.support.v4.view.ViewPager;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            u

class a
    implements Runnable
{

    final u a;

    public void run()
    {
        if (u.m(a) != null)
        {
            u.n(a);
            u.c(a, u.c(a).size());
            u.m(a).setCurrentItem(u.j(a), true);
        }
    }

    (u u1)
    {
        a = u1;
        super();
    }
}

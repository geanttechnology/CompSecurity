// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.support.v4.view.ViewPager;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements Runnable
{

    final p a;

    public void run()
    {
        if (p.x(a) != null)
        {
            p.y(a);
            p.b(a, p.z(a).size());
            p.x(a).setCurrentItem(p.t(a), true);
        }
    }

    _cls9(p p1)
    {
        a = p1;
        super();
    }
}

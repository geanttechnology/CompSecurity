// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.j;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p, q

class a
    implements Runnable
{

    final p a;

    public void run()
    {
        if (p.e(a) != null)
        {
            q q1 = (q)p.o(a).get(Integer.valueOf(0));
            if (q1 != null && q1.b().equals(com.cyberlink.beautycircle.model.Pager.DisplayType.b))
            {
                j.a().b(p.e(a).userType, q1.a);
            }
        }
    }

    ype(p p1)
    {
        a = p1;
        super();
    }
}

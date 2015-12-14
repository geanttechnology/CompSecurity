// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            u, v

class a extends j
{

    final v a;
    final u b;

    public Boolean a(d d1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (d1 != null)
        {
            flag = flag1;
            if (d1.b != null)
            {
                flag = flag1;
                if (d1.b.size() > 0)
                {
                    a.b = (Post)d1.b.get(0);
                    flag = true;
                }
            }
        }
        return Boolean.valueOf(flag);
    }

    public volatile Object a(Object obj)
    {
        return a((d)obj);
    }

    (u u1, v v1)
    {
        b = u1;
        a = v1;
        super();
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.net.Uri;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            u, v

class a extends j
{

    final u a;

    protected Boolean a(d d1)
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
                    u.e(a).clear();
                    u.c(a).clear();
                    d1 = d1.b.iterator();
                    do
                    {
                        if (!d1.hasNext())
                        {
                            break;
                        }
                        UserInfo userinfo = (UserInfo)d1.next();
                        if (userinfo != null && userinfo.bgImageUrl != null && !userinfo.bgImageUrl.toString().isEmpty())
                        {
                            v v1 = new v(a, null);
                            v1.a = userinfo;
                            u.c(a).add(v1);
                        }
                    } while (true);
                    flag = true;
                }
            }
        }
        return Boolean.valueOf(flag);
    }

    protected volatile Object a(Object obj)
    {
        return a((d)obj);
    }

    (u u1)
    {
        a = u1;
        super();
    }
}

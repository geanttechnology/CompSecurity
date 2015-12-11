// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.d;

import com.offerup.android.g.b.ag;
import com.offerup.android.network.UserService;
import com.offerup.android.network.o;
import java.util.concurrent.Executors;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.d:
//            e, f

public final class d
{

    private e a;

    public d(e e1)
    {
        a = e1;
    }

    static e a(d d1)
    {
        return d1.a;
    }

    public final void a(ag ag1)
    {
        boolean flag2 = false;
        String s = ag1.a;
        boolean flag;
        boolean flag1;
        if (StringUtils.isEmpty(s))
        {
            a.a(11);
            flag = false;
        } else
        if (s.length() < 3)
        {
            a.a(12);
            flag = false;
        } else
        {
            flag = true;
        }
        s = ag1.b;
        if (StringUtils.isEmpty(s))
        {
            a.a(13);
            flag1 = false;
        } else
        if (s.length() < 3)
        {
            a.a(14);
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (StringUtils.isEmpty(ag1.c))
        {
            a.a(15);
        } else
        {
            flag2 = true;
        }
        if (flag & flag1 & flag2)
        {
            a.a();
            s = ag1.c;
            String s1 = ag1.a;
            ag1 = ag1.b;
            f f1 = new f(this);
            o.e(o.a(Executors.newSingleThreadExecutor())).createUser(s, s1, ag1, f1);
        }
    }
}

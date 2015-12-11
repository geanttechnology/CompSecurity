// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.d;

import com.offerup.android.g.b.j;
import com.offerup.android.network.b;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.d:
//            c, b

public final class a
{

    private c a;

    public a(c c1)
    {
        a = c1;
    }

    static c a(a a1)
    {
        return a1.a;
    }

    public final void a(j j1)
    {
        boolean flag1 = false;
        String s = j1.b;
        boolean flag;
        if (StringUtils.isEmpty(s))
        {
            a.a(3);
            flag = false;
        } else
        if (s.length() < 3)
        {
            a.a(4);
            flag = false;
        } else
        {
            flag = true;
        }
        s = j1.a;
        if (StringUtils.isEmpty(s))
        {
            a.a(1);
        } else
        if (s.length() < 3)
        {
            a.a(2);
        } else
        {
            flag1 = true;
        }
        if (flag & flag1)
        {
            a.a();
            b.a(j1.a, j1.b, new com.offerup.android.d.b(this));
        }
    }
}

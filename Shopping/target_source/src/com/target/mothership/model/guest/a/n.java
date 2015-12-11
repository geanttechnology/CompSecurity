// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.a;

import com.google.b.f;
import com.target.mothership.b;
import com.target.mothership.model.common.a.a;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.common.a.e;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest.a:
//            k

public class n
    implements e
{

    public n()
    {
    }

    public c a(x x1)
    {
        c c1;
        if (x1 == null || x1.a() == null)
        {
            c1 = c._ERR_UNKNOWN;
        } else
        {
            c c2 = (new a()).a(x1);
            c1 = c2;
            if (c2 == c._ERR_UNKNOWN)
            {
                return ((k)b.a().k().a(x1.a(), com/target/mothership/model/guest/a/k)).a();
            }
        }
        return c1;
    }

    public volatile Object a(Object obj)
    {
        return a((x)obj);
    }
}

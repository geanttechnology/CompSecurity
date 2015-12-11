// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.c;

import com.target.mothership.model.d;
import com.target.mothership.model.e;
import com.target.mothership.services.apigee.h.c.a;

// Referenced classes of package com.target.mothership.model.c:
//            a

class b
    implements com.target.mothership.model.c.a
{

    private final a mServices = new a();

    public b()
    {
    }

    public void a(String s, d d1)
    {
        com.target.mothership.model.c.a.b b1 = new com.target.mothership.model.c.a.b(s);
        if (b1.a())
        {
            d1.b(b1.b());
            return;
        } else
        {
            d1 = new e(new com.target.mothership.model.c.b.a(d1));
            mServices.a(s, d1);
            return;
        }
    }
}

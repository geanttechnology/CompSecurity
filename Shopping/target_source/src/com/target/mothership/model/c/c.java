// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.c;

import com.target.mothership.b;
import com.target.mothership.model.a;
import com.target.mothership.model.d;

// Referenced classes of package com.target.mothership.model.c:
//            d, b, a

public class c extends a
{

    private final com.target.mothership.model.c.a mLocationDataSource;

    public c()
    {
        if (b.a().m())
        {
            mLocationDataSource = new com.target.mothership.model.c.d();
            return;
        } else
        {
            mLocationDataSource = new com.target.mothership.model.c.b();
            return;
        }
    }

    public void a(String s, d d1)
    {
        mLocationDataSource.a(s, d1);
    }
}
